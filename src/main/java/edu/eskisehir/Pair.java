package edu.eskisehir;

import java.util.Arrays;
import java.util.List;

public class Pair<W, X> {

    W first;
    X second;


    public Pair(W w, X x) {
        this.first = w;
        this.second = x;
    }

    public W getFirst() {
        return first;
    }

    public X getSecond() {
        return second;
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getFirst().equals(p2.getFirst()) &&
                p1.getClass().equals(p2.getClass());
    }



    public static void main(String[] args) {


        Pair<String, Double> p = new Pair<>("ahmet", 5.0);
        String first = p.getFirst();

        Pair<String, Integer> q = new Pair<>("ahmet", 10);
        Integer second = q.getSecond();

        System.out.println(Pair.<String, Double>compare(p, new Pair<>("ahmet", 5.0)));

        Pair<Float, Encoding> y = new Pair<>(0.2f, Encoding.ASCII);
        Encoding e = y.getSecond();
    }
}
