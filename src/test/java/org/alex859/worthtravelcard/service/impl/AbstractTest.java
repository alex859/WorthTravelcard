package org.alex859.worthtravelcard.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public abstract class AbstractTest
{
   protected <T> T getFromFile(final String filename, final Class<T> clazz)
   {
      try
      {
         return new ObjectMapper().readValue(new File((filename)), clazz);
      }
      catch (IOException e)
      {
         return null;
      }
   }
}
