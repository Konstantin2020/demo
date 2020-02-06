package ru.pts28;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
//вывод JSON_1, JSON_2
public class ClassMarkSerializer implements JsonSerializer<ClassMark>
    {
        @Override
        public JsonElement serialize(ClassMark src, Type typeOfSrc, JsonSerializationContext context)
            {
                JsonObject result = new JsonObject();
                result.addProperty("key", src.getKey());
                result.addProperty("quantity", src.getQuantity());
                return result;
            }

            }




