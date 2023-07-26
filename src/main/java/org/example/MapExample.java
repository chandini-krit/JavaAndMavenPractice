package org.example;

import com.sun.org.apache.xml.internal.serializer.SerializerTrace;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        //Adding elements to map
        map.put(1, "Amit");
        map.put(5, "Rahul");
        map.put(2, "Jai");
        map.put(6, "Amit");

        //Traversing Map
        System.out.println(map);
        for (Map.Entry<Integer,String> m : map.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        // adding elements of other map
        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, "rishi");
        map2.put(2, "Arjun");
        map.putAll(map2);
        System.out.println(map.size());

        // other way of traversing map
        System.out.println("traversing through iterator:");
        Set mapSet = map.entrySet();
        Iterator itr = mapSet.iterator();
        while (itr.hasNext()) {
            Map.Entry pair = (Map.Entry) itr.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        System.out.println(map.values());
        System.out.println(map.keySet());
        map.put(null,"ram");
        for (Integer i:map.keySet()) {
            System.out.println(i);
        }
        //LinkedHaashMAp
        // this map maintains the order of the elements.
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        //Adding elements to map
        linkedHashMap.put(1, "Amit");
        linkedHashMap.put(5, "Rahul");
        linkedHashMap.put(2, "Jai");
        linkedHashMap.put(6, "Amit");
        System.out.println(linkedHashMap);
        linkedHashMap.remove(2);
        map.replace(2,"hari");
        // after applying remove operation
        System.out.println(linkedHashMap);

        // sorting map by comparing values of the map
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        //treeMap allows elements in sorted order
        Map<Integer, String> treeMap = new TreeMap<>();
//        treeMap.putAll(map);
        System.out.println(treeMap);
        System.out.println(map.containsValue("Hari"));
    }
}
