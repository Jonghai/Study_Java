package work01;

import java.util.*;

public class mapTest {
    static ArrayList<Integer> testArray = new ArrayList<>(50000000);

    public static long putTest (Map<Integer,Integer> map){
        long start = System.currentTimeMillis();
        for(Integer value : testArray){
            map.put(value, value);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long getTest (Map<Integer,Integer> map){
        long start = System.currentTimeMillis();
        for(Integer value : testArray){
            map.get(value);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long removeTest (Map<Integer,Integer> map){
        long start = System.currentTimeMillis();
        for(Integer value : testArray){
            map.remove(value);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long IteratorTest (Map<Integer,Integer> map){
        for(Integer value : testArray){
            map.put(value, value);
        }
        long start = System.currentTimeMillis();
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while(entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] ages){
        HashMap hashmap = new HashMap();
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        for(int i = 0; i < 5000000; ++i) {
            testArray.add(i);
        }
        Collections.shuffle(testArray);

        System.out.println("====== put");
        System.out.println("HashMap : " + putTest(hashmap));
        System.out.println("LinkedHashMap : " + putTest(linkedhashmap));

        System.out.println("====== get");
        System.out.println("HashMap : " + getTest(hashmap));
        System.out.println("LinkedHashMap : " + getTest(linkedhashmap));

        System.out.println("====== remove");
        System.out.println("HashMap : " + removeTest(hashmap));
        System.out.println("LinkedHashMap : " + removeTest(linkedhashmap));

        System.out.println("====== iterator");
        System.out.println("HashMap : " + IteratorTest(hashmap));
        System.out.println("LinkedHashMap : " + IteratorTest(linkedhashmap));
    }
}