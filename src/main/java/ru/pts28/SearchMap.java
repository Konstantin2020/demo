package ru.pts28;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Logger;

public class SearchMap {
    private static Logger log = Logger.getLogger(SearchMap.class.getName());
//класс для получения искомых ключей
    public Map mainRetSearchMap() throws Exception {
        log.info("SearchMap for all JSON's");
        String fileName = "ptssearch.csv";
        CSVReader reader = new CSVReader(new FileReader(fileName), ',', '"', 1);
        String[] nextLineSM;
        System.out.println("Text message: list reading data to find from file: \n" + fileName);
        System.out.println(" ");
        Map<String, Integer> resultSM = new LinkedHashMap<>();
        while ((nextLineSM = reader.readNext()) != null) {
            if (nextLineSM != null) {
                int z = 0;
                Integer d=null;
                //либо
                //int d=0;
                //тогда в JSON_2 будет выводить 0
                resultSM.put(nextLineSM[z], d);
            }
        }
        return resultSM;
     }
}




