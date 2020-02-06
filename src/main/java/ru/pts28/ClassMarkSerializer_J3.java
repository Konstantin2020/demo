package ru.pts28;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

//вывод JSON_3
public class ClassMarkSerializer_J3 implements JsonSerializer<ClassMark_J3>
{
    @Override
    public JsonElement serialize(ClassMark_J3 src, Type typeOfSrc, JsonSerializationContext context)
    {
        JsonObject result = new JsonObject();
        result.addProperty("key", src.getKey());
        result.addProperty("quantity", (Number) src.getQuantity());

        return result;
    }

}
