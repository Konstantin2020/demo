package ru.pts28;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

//окончательный класс для вывода JSON_3
public class FinJ1 {
    private static Logger log = Logger.getLogger(FinJ1.class.getName());
    public static void JSON_1_Write(Map<String, Integer> locJ1_Map)throws Exception {
        log.info("JSON_1 formation");
        System.out.println("Text message: Start to JSON_1");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(ClassMark.class,new ClassMarkSerializer())
                .create();
        String JSON  = gson.toJson(locJ1_Map);
        try {
            FileWriter data = new FileWriter("JSON_1.json");
            data.write(JSON);
            data.flush();
            data.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.log(Level.SEVERE, "Exception: ", e);
        }
        log.fine("some minor, debug message");
        System.out.println("Text message: JSON_1 formed");
        System.out.println(" ");
//проверочный вывод массива для JSON_2
        /*for (java.util.Map.Entry<String, Integer> entry : locJ1_Map.entrySet()) {
        String key = entry.getKey();
        Integer quantity = entry.getValue();
        System.out.println("App JSON_1 key= " + key + ", value= " + quantity);
    }
*/
}

}
