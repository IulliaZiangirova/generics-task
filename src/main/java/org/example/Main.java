package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list2 = new MyList<>();
        list2.add(34);
        list2.add(0);
        list2.add(0);
        list2.add(-56);
        list2.add(-1);
        list2.add(555555);
        list2.add(76);
        list2.add(34);
        list2.add(3);
        System.out.println(list2.get(10));

    }
}