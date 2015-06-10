package org.alex859.worthtravelcard.service;

import java.util.List;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public interface TflService
{
   List<String> getStationCodes(String query);
   Double getFare(String fromCode, String toCode);
}
