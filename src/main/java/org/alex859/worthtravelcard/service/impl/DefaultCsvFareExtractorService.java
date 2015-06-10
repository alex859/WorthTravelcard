package org.alex859.worthtravelcard.service.impl;

import org.alex859.worthtravelcard.service.CsvFareExtractorService;
import org.alex859.worthtravelcard.service.FareCalculatorService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Service
public class DefaultCsvFareExtractorService implements CsvFareExtractorService
{
   private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCsvFareExtractorService.class);

   private FareCalculatorService fareCalculatorService;

   @Override
   public Double computeFare(final String csv)
   {
      Assert.isTrue(StringUtils.isNotEmpty(csv), "CSV string cannot be null");

      final List<String> allLines = Arrays.asList(csv.split("\\n"));

      return computeFare(allLines);
   }

   @Override
   public Double computeFare(final Path csvFilePath)
   {
      Assert.notNull(csvFilePath, "File path cannot be null");
      try
      {
         final List<String> allLines = Files.readAllLines(csvFilePath);

         return computeFare(allLines);
      }
      catch (IOException e)
      {
         LOGGER.error("Error reading file: {}", csvFilePath);
      }

      return null;
   }

   protected Double computeFare(final List<String> csvLines)
   {
      Double result = 0.;

      csvLines.stream()
              .skip(2)
              .map(l -> l.split(",")[3].replace("\"", ""))
              .filter(s -> !s.contains("Bus journey") && s.contains(" to "))
              .map(s -> {
                 final String[] split = s.split(" to ");
                 return fareCalculatorService.getFare(split[0], split[1]);
              })
              .forEach(d -> LOGGER.info(d.toString()));

      return result;
   }

   @Autowired
   public void setFareCalculatorService(final FareCalculatorService fareCalculatorService)
   {
      this.fareCalculatorService = fareCalculatorService;
   }
}
