package org.alex859.worthtravelcard;

import org.alex859.worthtravelcard.service.CsvFareExtractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Component
public class AppTestRunner implements CommandLineRunner
{
   @Autowired
   private CsvFareExtractorService csvFareExtractorService;

   @Override
   public void run(final String... args) throws Exception
   {
      csvFareExtractorService.computeFare(Paths.get("/home/alex859/Downloads/057582984385-20150609-2049.csv"));
   }
}
