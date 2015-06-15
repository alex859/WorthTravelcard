package org.alex859.worthtravelcard.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public class Station
{
   private String code;
   private String name;
   private List<Mode> modes;
   private String zone;

   public String getCode()
   {
      return code;
   }

   public void setCode(final String code)
   {
      this.code = code;
   }

   public String getName()
   {
      return name;
   }

   public void setName(final String name)
   {
      this.name = name;
   }

   public List<Mode> getModes()
   {
      return modes;
   }

   public void setModes(final List<Mode> modes)
   {
      this.modes = modes;
   }

   public String getZone()
   {
      return zone;
   }

   public void setZone(final String zone)
   {
      this.zone = zone;
   }

   @Override
   public String toString()
   {
      return new ToStringBuilder(this)
              .append("code", code)
              .append("name", name)
              .append("modes", modes)
              .append("zone", zone)
              .toString();
   }
}
