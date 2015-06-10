package org.alex859.worthtravelcard.service.impl;

import org.alex859.worthtravelcard.service.FareCalculatorService;
import org.alex859.worthtravelcard.service.TflService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public class DefaultFareCalculatorService implements FareCalculatorService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(DefaultFareCalculatorService.class);

   private TflService tflService;

   @Override
   public Double getFare(final String from, final String to)
   {
      Assert.isTrue(StringUtils.isNotEmpty(from), "Start location cannot be empty");
      Assert.isTrue(StringUtils.isNotEmpty(to), "End location cannot be empty");

      final List<String> fromCodes = tflService.getStationCodes(from);
      final List<String> toCodes = tflService.getStationCodes(to);

      if (CollectionUtils.isNotEmpty(fromCodes) && CollectionUtils.isNotEmpty(toCodes))
      {
         return fromCodes.stream()
                 .flatMap(c1 -> toCodes.stream().map(c2 -> tflService.getFare(c1, c2)).filter(c -> c != null).peek(c -> LOGGER.info("Cost: {}", c)))
                 .filter(d -> d != null)
                 .mapToDouble(d -> d)
                 .peek(d -> LOGGER.info("Found fare from {} to {}: {}", from, to, d))
                 .average().getAsDouble();
      }

      LOGGER.warn("Not all codes found for input: {}, {}", from, to);
      return 0.;
   }

   @Autowired
   public void setTflService(final TflService tflService)
   {
      this.tflService = tflService;
   }
}
