package ru.pts28;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

//окончательный класс для вывода JSON_3
public class FinJ3 {
    private static Logger log = Logger.getLogger(FinJ3.class.getName());
    public static void JSON_3_Write(Map<String, Integer[]> locJ3_Map)throws Exception {
        System.out.println("Text message: start to JSON_3");
        log.info("JSON_3 formation");
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .registerTypeAdapter(ClassMark.class,new ClassMarkSerializer())
                .create();

        String JSON  = gson.toJson(locJ3_Map);
        try {
            FileWriter data = new FileWriter("JSON_3.json");
            data.write(JSON);
            data.flush();
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "Exception: ", e);
        }
        log.fine("some minor, debug message");
        System.out.println("Text message: JSON_3 formed");
//проверочный вывод массивов для JSON_3
         /*String keyJ3;
        Integer [] valueJ3 = new Integer[0];
        for (java.util.Map.Entry<String, Integer[]> entrysource : locJ3_Map.entrySet()) {
            String fromvaluej3 = " ";
            keyJ3 = entrysource.getKey();
            valueJ3 = entrysource.getValue();
            for (int z = 0; z < valueJ3.length; z++) {
                fromvaluej3 = fromvaluej3.concat(" " + valueJ3[z]);
            }


            System.out.println("APP JSON_3 key= " + keyJ3 + ", value= " + fromvaluej3);
        }
*/

    }

}