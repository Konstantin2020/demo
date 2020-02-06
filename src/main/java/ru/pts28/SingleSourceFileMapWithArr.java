package ru.pts28;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.logging.Logger;

//класс для вывода суммы из каждого ресурсного файла с суммированием значений для совпадающих ключей
public class SingleSourceFileMapWithArr {
    private static Logger log = Logger.getLogger(SingleSourceFileMap.class.getName());
    String paramFileName;
//в конструктор вносится имя каждого распакованного файла

    public SingleSourceFileMapWithArr(String s) {
        paramFileName = s;
    }

    public Map mainRetSingleSourceMapWithArr() throws Exception {
        log.info("SingleSourceFileMap for J3");
        Map<String, Integer> resultSMWA_Step1 = new LinkedHashMap<>();
        ArrayList<String> combinedKey = new ArrayList<>();
        ArrayList<Integer> combinedValue = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(paramFileName), ',', '"', 1);
        String[] nextLineSMWA;
        Map<String, Integer[]> resultSMWA_Step2 = new HashMap<>();

//составляется карта
        BiFunction<Integer, Integer, Integer> bFunc = (oldValue, newValue) -> oldValue + newValue;
        while ((nextLineSMWA = reader.readNext()) != null) {
            if (nextLineSMWA != null) {
                combinedKey.add(nextLineSMWA[0].toUpperCase());
                combinedValue.add(Integer.valueOf(nextLineSMWA[1]));
// от resultSMWA_Step1 нужны только ключи идет простое заполнение с суммированием значений
                resultSMWA_Step1.merge((nextLineSMWA[0]).toUpperCase(), Integer.valueOf(nextLineSMWA[1]), bFunc);
            }
        }
//на основе resultSMWA_Step1 и двух списков (ключей и значений) значения заполняются массивами для соответствующих ключей
        Integer[] resIntWA;
        for (java.util.Map.Entry<String, Integer> entrysource2 : resultSMWA_Step1.entrySet()) {
            String mark = entrysource2.getKey();
            resIntWA = new Integer[0];
                for (int b = 0; b < combinedKey.size(); b++) {
                if ((mark).equalsIgnoreCase(combinedKey.get(b))) {
                    resIntWA = Arrays.copyOf(resIntWA, resIntWA.length + 1);
                    resIntWA[resIntWA.length - 1] = Integer.valueOf(combinedValue.get(b));
                }
            }resultSMWA_Step2.put(mark,resIntWA);
        }
        return resultSMWA_Step2;
    }
}