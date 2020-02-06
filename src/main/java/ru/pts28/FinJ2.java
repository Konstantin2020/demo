package ru.pts28;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

//окончательный класс для вывода JSON_2
public class FinJ2 {
    private static Logger log = Logger.getLogger(FinJ1.class.getName());
    public static void JSON_2_Write(Map<String, Integer> locJ2_Map)throws Exception {
        log.info("JSON_2 formation");
        System.out.println("Text message: start to JSON_2");

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
                .registerTypeAdapter(ClassMark.class,new ClassMarkSerializer())
                .create();
        String JSON  = gson.toJson(locJ2_Map);
        try {
            FileWriter data = new FileWriter("JSON_2.json");
            data.write(JSON);
            data.flush();
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "Exception: ", e);
        }
        log.fine("some minor, debug message");
        System.out.println("Text message: JSON_2 formed");
        System.out.println(" ");
//проверочный вывод массива для JSON_2
        /*for (java.util.Map.Entry<String, Integer> entry : locJ2_Map.entrySet()) {
            String key = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println("App JSON_2 key= " + key + ", value= " + quantity);

        }
*/

    }
}