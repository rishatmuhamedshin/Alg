package org.example.search;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("claire", Arrays.asList("tom", "johny"));
        graph.put("anuj", List.of(""));
        graph.put("tom", List.of(""));
        graph.put("johny", List.of(""));
        graph.put("peggy", List.of(""));

        System.out.println(findMangoSeller(graph, "you"));

    }

    public static String findMangoSeller(Map<String, List<String>> graph, String youName) {
        Deque<String> deque = new ArrayDeque<>(graph.get(youName));
        while (!deque.isEmpty()) {
            String person = deque.poll();
            if (personSellerMango(person)) {
                System.out.println(person + "is a mango seller");
                return person;
            } else {
                deque.add(graph.get(person).stream().findAny().orElse(""));
            }

        }
        return "false";

    }

    private static boolean personSellerMango(String person) {
        return person.endsWith("m");
    }
}