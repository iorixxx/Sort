package edu.eskisehir;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class GenericsDemo<E> {

    ArrayList<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public E get(int index) {
        return list.get(index);
    }

    boolean contains(E e) {
        for (E i : list)
            if (e.equals(i))
                return true;

        return false;

    }

    void add(E e) {
        list.add(e);
    }


    // generic method that prints all elements of a given list
    static void printList(List<? extends Number> list) {
        for (Number o : list)
            System.out.println(o);
    }

    static void printList1(List<?> list) {
        for (Object o : list)
            System.out.println(o);
    }

    static void printList2(List list) {
        for (Object o : list)
            System.out.println(o);
    }

    static void printList3(List<Number> list) {
        for (Object o : list)
            System.out.println(o);
    }

    public static void main(String[] args) {

        // nice example of a generic method Lists.of
        List<Integer> iList = List.of(4, 5, 6, 7, 8, 9);
        List<Double> dList = List.of(4.0, 5.0, 6.0, 7.0, 8.0, 9.0);
        List<Float> fList = List.of(4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f);

        // They do not work! printList3(fList);    printList3(iList);    printList3(dList);

        printList(iList);
        printList(dList);

        printList1(iList);
        printList1(dList);

        printList2(iList);
        printList2(dList);

        Map<String, Float> map = new HashMap<>();

        map.put("key", 5f);
        Float f = map.get("key");


        List<String> lines = new ArrayList<>();


        //  lines.add(5);
        //  lines.add(Encoding.UTF8);

        lines.add("Ahmet");


        //  Integer i = (Integer) lines.get(1);

        // Also this method signature contains( Object o ) provides a really nice gun to conveniently
        // shoot yourself in a foot. This method is really a showcase of limitation of Java Generics.

        lines.contains(5);
        lines.remove(Encoding.ASCII);

        // In short, they wanted to maximize backwards compatibility, because collections have been introduced long before generics.

        GenericsDemo<Encoding> demo = new GenericsDemo<>();

        demo.add(Encoding.UTF8);

        // demo.contains(5); does not compile. This is how I wanted.

        System.out.println(demo.contains(Encoding.UTF8));
        System.out.println(demo.contains(Encoding.ASCII));
        System.out.println(demo.size());


    }
}
