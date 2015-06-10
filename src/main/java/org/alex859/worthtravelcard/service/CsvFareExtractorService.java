package org.alex859.worthtravelcard.service;

import java.nio.file.Path;

/**
 * @author alex859 <alessandro.ciccimarra@gmail.com>.
 */
public interface CsvFareExtractorService
{
   Double computeFare(String csv);
   Double computeFare(Path csvFile);
}
