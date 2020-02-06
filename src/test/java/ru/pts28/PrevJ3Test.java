package ru.pts28;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrevJ3Test {

    Map <String, Integer> source1= new LinkedHashMap<String, Integer>(); {
        source1.put("key1", 6 );
        source1.put("key2", 12);
        source1.put("key3", null);
    };
    Integer[] z=new Integer[]{2,5};
    Integer[] y=new Integer[]{1,9};

    Map <String, Integer[]> source2= new LinkedHashMap<String, Integer[]>(); {

        source2.put("key1", z);
        source2.put("key2", y);

    };
    Map <String, Integer[]> expected= new HashMap<String, Integer[]>(); {
        expected.put("key1", z);
        expected.put("key2", y);

    };

    @Test
    void mainRetJ3() throws Exception {
        Map <String, Integer[]> actual = new PrevJ3(source1,source2).mainRetJ3();
        assertEquals(expected, actual);

    }
}