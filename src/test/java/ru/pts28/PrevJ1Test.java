package ru.pts28;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrevJ1Test {

    Map <String, Integer> source1= new LinkedHashMap<String, Integer>(); {
        source1.put("key1", 0);
        source1.put("key2", 0);
    };
    Map <String, Integer> source2= new LinkedHashMap<String, Integer>(); {
        source2.put("key1", 1);
        source2.put("key2", 3);
    };
    Map <String, Integer> expected= new HashMap<String, Integer>(); {
        expected.put("key1", 1);
        expected.put("key2", 3);
    };

    @Test
    void mainRetJ1() throws Exception {
        Map <String, Integer> actual = new PrevJ1(source1,source2).mainRetJ1();
        assertEquals(expected, actual);

    }
}
