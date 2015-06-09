package org.alex859.worthtravelcard.service.impl;

import org.alex859.worthtravelcard.service.TflService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import uk.gov.tfl.FareSearchResponse;
import uk.gov.tfl.Match;
import uk.gov.tfl.StopSearchResponse;
import uk.gov.tfl.TicketsAvailable;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
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

   @Override
   public List<String> getNaptanCodes(final String query)
   {
      final UriComponentsBuilder builder = getUriBuilder(stopSearchUrl)
              .queryParam("query", query)
              .queryParam("modes", "dlr,overground,tflrail,tube,national-rail");

      final StopSearchResponse stopSearchResponse = restTemplate.getForObject(builder.toUriString(), StopSearchResponse.class);

      if (stopSearchResponse != null && CollectionUtils.isNotEmpty(stopSearchResponse.getMatches()))
      {
         return stopSearchResponse.getMatches().stream()
                 .filter(m -> m.getStopType().endsWith("Station"))
                 .map(Match::getStationId)
                 .collect(Collectors.toList());

      }

      return Collections.emptyList();
   }

   @Override
   public Double getFare(final String fromCode, final String toCode)
   {
      final UriComponentsBuilder builder = getUriBuilder(fareSearchUrl)
              .queryParam("id", fromCode)
              .queryParam("toStopPointId", toCode);

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

   protected String decode(final String encoded)
   {
      try
      {
         return URLDecoder.decode(encoded, "UTF-8");
      } catch (UnsupportedEncodingException e)
      {
         e.printStackTrace();
      }

      return null;
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
