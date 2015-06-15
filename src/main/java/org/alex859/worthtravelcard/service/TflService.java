package org.alex859.worthtravelcard.service;

import org.alex859.worthtravelcard.model.Station;

import java.util.List;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public interface TflService
{
   List<Station> getStations(String query);
   Double getFare(Station fromCode, Station toCode);
}
