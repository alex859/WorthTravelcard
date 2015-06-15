package org.alex859.worthtravelcard.model;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public enum Mode
{
   BUS("bus", "Bus"),
   TUBE("tube", "London Underground"),
   TFL_RAIL("tflrail", "Tfl Rail"),
   OVERGROUND("overground", "Overground"),
   RIVER_BUS("river-bus", "River Bus"),
   RIVER_TOUR("river-tour", "River Tour"),
   CABLE_CAR("cable-car", "Cable Car"),
   DLR("dlr", "DLR"),
   NATIONAL_RAIL("national-rail", "National Rail"),
   TRAM("tram", "Tam");

   private String tflCode;
   private String oysterCode;

   Mode(final String code, final String oysterCode)
   {
      this.tflCode = code;
      this.oysterCode = oysterCode;
   }

   /**
    * The string that identifies the station mode in the TFL apis.
    * @return The TFL code identifier
    */
   public String getTflCode()
   {
      return tflCode;
   }

   /**
    * The string that identifies the station mode in the Oyster downloaded CSV.
    * @return The Oyster CSV mode identifier
    */
   public String getOysterCode()
   {
      return oysterCode;
   }

   public static Mode getFromTflCode(final String tflCode)
   {
      Assert.isTrue(StringUtils.isNotBlank(tflCode), "TFL code cannot be null");

      for (final Mode mode : Mode.values())
      {
         if (mode.getTflCode().equals(tflCode))
         {
            return mode;
         }
      }

      throw new IllegalArgumentException("Unrecognized TFL code: " + tflCode);
   }

}
