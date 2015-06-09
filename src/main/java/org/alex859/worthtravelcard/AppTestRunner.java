package org.alex859.worthtravelcard;

import org.alex859.worthtravelcard.facade.FareCalculatorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
@Component
public class AppTestRunner implements CommandLineRunner
{
   @Autowired
   private FareCalculatorFacade fareCalculatorFacade;

   @Override
   public void run(final String... args) throws Exception
   {
      System.out.println(fareCalculatorFacade.getFare("limehouse", "bermondsey"));
   }
}
