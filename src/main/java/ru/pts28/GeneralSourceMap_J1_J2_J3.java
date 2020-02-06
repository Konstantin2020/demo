package ru.pts28;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.logging.Logger;

//класс для суммирования данных с разных ресурсных файлов
// и оформление в виде массивов к каждому ключу с ненулевыми значениями
public class GeneralSourceMap_J1_J2_J3 {
    private static Logger log = Logger.getLogger(GeneralSourceMap_J1_J2_J3.class.getName());
    Map<String,Integer> GSMSearchMap;
    String [] GSMArrListSourceFiles;
    public GeneralSourceMap_J1_J2_J3(Map<String, Integer> appMapSearchFile, String[] appListSourceFiles) {
        GSMSearchMap=appMapSearchFile;
        GSMArrListSourceFiles=appListSourceFiles;
    }

    public Map mainRetGeneralSourceMap_J1_J2() throws Exception {
        log.info("begin formation Map for J1 and J2");
        Map<String, Integer> MapCombined_J1_J2=new HashMap<>();
        ArrayList<SingleSourceFileMap> SMarr = new ArrayList<>();
        if (GSMArrListSourceFiles.length > 0) {
            for (int z = 0; z < GSMArrListSourceFiles.length; z++) {
                SingleSourceFileMap y = new SingleSourceFileMap(GSMArrListSourceFiles[z]);
                SMarr.add(y);
//суммирование значений для совпадающих ключей из разных ресурсных файлов, без учета искомых ключей
                (SMarr.get(z).mainRetSingleSourceMap()).forEach((k, v) -> MapCombined_J1_J2.merge((String) k, (Integer) v, (v1, v2) -> v1 + v2));
            }
        }
        return MapCombined_J1_J2;
    }



      @SuppressWarnings({"rawtypes", "unchecked"})
    public Map<String, Integer[]> mainRetGeneralSourceMap_J3() throws Exception {
          log.info("begin formation Map for J3");
// начало преобразований данных для JSON_3
        Map<String, Integer[]> MapCombined_J3 = new HashMap<>();
        if (GSMArrListSourceFiles.length > 0) {
            ArrayList<String> combinedKey = new ArrayList<>();
            ArrayList<Integer[]> combinedValue = new ArrayList<>();

            Map<String,Integer[]> MapJ3_Step1 = new LinkedHashMap<>();
            Map<String,Integer[]> MapJ3_Step2=new HashMap<>();
            Map<String,Integer[]> MapJ3_Step3= new HashMap<>();
            ArrayList<SingleSourceFileMapWithArr> SMarrWA = new ArrayList<>();

            for (int z = 0; z < GSMArrListSourceFiles.length; z++) {
                SingleSourceFileMapWithArr y = new SingleSourceFileMapWithArr(GSMArrListSourceFiles[z]);
                SMarrWA.add(y);
                MapJ3_Step1 = (SMarrWA.get(z).mainRetSingleSourceMapWithArr());

            for (java.util.Map.Entry<String, Integer[]> entrysource1 : MapJ3_Step1.entrySet()) {
                combinedKey.add(entrysource1.getKey());
                combinedValue.add(entrysource1.getValue());
                MapJ3_Step2.put(entrysource1.getKey(), entrysource1.getValue());
            }
            }

            MapJ3_Step3 = MapJ3_Step2;
                for (java.util.Map.Entry<String, Integer[]> entrysource2 : MapJ3_Step3.entrySet()) {
                String mark = entrysource2.getKey();
                    Integer[] both = new Integer[0];

                for (int b = 0; b < combinedKey.size(); b++) {
                    if ((mark).equalsIgnoreCase(combinedKey.get(b))) {
                        both = ArrayUtils.addAll(both, combinedValue.get(b));
                        Arrays.sort(both, Collections.reverseOrder());
                        }
               }MapCombined_J3.put(mark,both);
}

        }return MapCombined_J3;}



}



