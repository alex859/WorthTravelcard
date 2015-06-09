package org.alex859.worthtravelcard.facade.impl;

import org.alex859.worthtravelcard.facade.FareCalculatorFacade;
import org.alex859.worthtravelcard.service.TflService;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public class DefaultFareCalculatorFacade implements FareCalculatorFacade
{
   private static final Logger LOGGER = LoggerFactory.getLogger(DefaultFareCalculatorFacade.class);

   private TflService tflService;

   @Override
   public Double getFare(final String from, final String to)
   {
      final List<String> fromCodes = tflService.getNaptanCodes(from);
      final List<String> toCodes = tflService.getNaptanCodes(to);

      if (CollectionUtils.isNotEmpty(fromCodes) && CollectionUtils.isNotEmpty(toCodes))
      {
         return fromCodes.stream()
                 .flatMap(c1 -> toCodes.stream().map(c2 -> tflService.getFare(c1, c2)).filter(c -> c != null).peek(c -> LOGGER.info("Cost: {}", c)))
                 .mapToDouble(d -> d)
                 .average().getAsDouble();
      }

      LOGGER.warn("Not all codes found for input: {}, {}", from, to);
      return null;
   }

   @Autowired
   public void setTflService(final TflService tflService)
   {
      this.tflService = tflService;
   }
}
