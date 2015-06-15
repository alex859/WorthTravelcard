package org.alex859.worthtravelcard.service.impl;

import org.alex859.worthtravelcard.model.Mode;
import org.alex859.worthtravelcard.model.Station;
import org.alex859.worthtravelcard.service.TflService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import uk.gov.tfl.FareSearchResponse;
import uk.gov.tfl.Match;
import uk.gov.tfl.StopSearchResponse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public class DefaultTflService implements TflService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(DefaultTflService.class);

   private RestTemplate restTemplate;
   private String stopSearchUrl;
   private String fareSearchUrl;
   private String appId;
   private String appKey;

   // London Bridge [London Underground] -> London Bridge
   private static final Pattern stopDetailsPattern = Pattern.compile("(\\[.+\\]?)");

   @Override
   public List<Station> getStations(final String query)
   {
      Assert.isTrue(StringUtils.isNotEmpty(query), "Location cannot be empty");

      final Matcher matcher = stopDetailsPattern.matcher(query);
      String newQuery = query;
      while (matcher.find())
      {
         newQuery = StringUtils.remove(newQuery, matcher.group(1));
      }

      final UriComponentsBuilder builder = getUriBuilder(stopSearchUrl)
              .queryParam("query", newQuery.trim())
              .queryParam("modes", getModes(query).stream()
                                       .map(Mode::getTflCode)
                                       .collect(Collectors.joining(",")));

      final StopSearchResponse stopSearchResponse = restTemplate.getForObject(builder.toUriString(), StopSearchResponse.class);

      if (stopSearchResponse != null && CollectionUtils.isNotEmpty(stopSearchResponse.getMatches()))
      {
         try
         {
            return stopSearchResponse.getMatches().stream()
                    .sorted((m1, m2) -> compare(query, m1, m2))
                    .map(this::getFromMatch)
                    .collect(Collectors.toList());
         }
         catch (Exception e)
         {
            LOGGER.error("Error getting station list", e);
         }

      }

      return Collections.emptyList();
   }

   @Override
   public Double getFare(final Station from, final Station to)
   {
      Assert.notNull(from, "Start station cannot be null");
      Assert.isTrue(StringUtils.isNotBlank(from.getCode()), "Start station code cannot be null");
      Assert.notNull(to, "End station code cannot be null");
      Assert.isTrue(StringUtils.isNotBlank(to.getCode()), "End station code cannot be null");

      final UriComponentsBuilder builder = getUriBuilder(fareSearchUrl)
              .queryParam("id", from.getCode())
              .queryParam("toStopPointId", to.getCode());

      final FareSearchResponse[] fareSearchResponseArray = restTemplate.getForObject(builder.toUriString(), FareSearchResponse[].class);
      if (fareSearchResponseArray != null && fareSearchResponseArray.length > 0)
      {
         final FareSearchResponse fareSearchResponse = fareSearchResponseArray[0];
         // TODO deal with peak/off peak
         return fareSearchResponse.getRows().stream()
                 .flatMap(r -> r.getTicketsAvailable().stream())
                 .filter(t -> t.getTicketType().getType().contains("Oyster"))
                 .map(t -> Double.parseDouble(t.getCost()))
                 .max(Double::compareTo).get();
      }

      return null;
   }

   protected UriComponentsBuilder getUriBuilder(final String baseUrl)
   {
      return UriComponentsBuilder.fromHttpUrl(baseUrl)
              .queryParam("app_id", appId)
              .queryParam("app_key", appKey);
   }

   /**
    * Tries to work out the requested mode from the CSV query
    * Eg.:
    * Limehouse DLR -> (DLR)
    * London Bridge [National Rail] -> (National Rail)
    * London Waterloo [London Underground / National Rail] -> (Tube, National Rail)
    *
    * @param query The query we get from the CSV
    * @return The associated modes. If no modes are found, returns all of them
    */
   protected List<Mode> getModes(final String query)
   {
      final List<Mode> modeList = Arrays.stream(Mode.values())
              .filter(m -> query.contains(m.getOysterCode())).collect(Collectors.toList());

      return CollectionUtils.isNotEmpty(modeList) ? modeList : Arrays.asList(Mode.values());
   }

   protected int compare(final String query, final Match m1, final Match m2)
   {
      final Integer levenshteinDistance1 = StringUtils.getLevenshteinDistance(query, m1.getName());
      final Integer levenshteinDistance2 = StringUtils.getLevenshteinDistance(query, m2.getName());

      return levenshteinDistance1.compareTo(levenshteinDistance2);
   }

   protected Station getFromMatch(final Match match)
   {
      final Station station = new Station();
      station.setCode(match.getStationId());
      station.setName(match.getName());
      station.setZone(match.getZone());
      station.setModes(match.getModes().stream().map(Mode::getFromTflCode).collect(Collectors.toList()));

      return station;
   }

   @Autowired
   public void setRestTemplate(final RestTemplate restTemplate)
   {
      this.restTemplate = restTemplate;
   }

   @Value("${tfl.stopSearch}")
   public void setStopSearchUrl(final String stopSearchUrl)
   {
      this.stopSearchUrl = stopSearchUrl;
   }

   @Value("${tfl.fareSearch}")
   public void setFareSearchUrl(final String fareSearchUrl)
   {
      this.fareSearchUrl = fareSearchUrl;
   }

   @Value("${tfl.appKey}")
   public void setAppKey(final String appKey)
   {
      this.appKey = appKey;
   }

   @Value("${tfl.appId}")
   public void setAppId(final String appId)
   {
      this.appId = appId;
   }
}
