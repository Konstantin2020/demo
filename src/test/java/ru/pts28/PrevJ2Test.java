package ru.pts28;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrevJ2Test {

    Map <String, Integer> source1= new LinkedHashMap<String, Integer>(); {
        source1.put("key1", 4);
        source1.put("key2", 8);
        source1.put("key3", null);
    };
    Map <String, Integer> source2= new LinkedHashMap<String, Integer>(); {
        source2.put("key1", 1);
        source2.put("key2", 3);

    };
    Map <String, Integer> expected= new HashMap<String, Integer>(); {
        expected.put("key1", 5);
        expected.put("key2", 11);
        expected.put("key3", null);
    };

    @Test
    void mainRetJ2() throws Exception {
        Map <String, Integer> actual = new PrevJ2(source1,source2).mainRetJ2();
        assertEquals(expected, actual);

    }
}