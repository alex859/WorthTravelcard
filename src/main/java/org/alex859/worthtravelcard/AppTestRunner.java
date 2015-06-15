package org.alex859.worthtravelcard;

import org.alex859.worthtravelcard.model.Station;
import org.alex859.worthtravelcard.service.CsvFareExtractorService;
import org.alex859.worthtravelcard.service.TflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.util.List;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Component
public class AppTestRunner implements CommandLineRunner
{
   @Autowired
   private CsvFareExtractorService csvFareExtractorService;

   @Autowired
   private TflService tflService;

   @Override
   public void run(final String... args) throws Exception
   {
    //  final List<Station> stations = tflService.getStations("Victoria [London Underground]");
    //  System.out.println(stations);
      csvFareExtractorService.computeFare(Paths.get("/home/alex859/Downloads/057582984385-20150609-2049.csv"));
   }
}
