package com.any.twofourteenalgorithms.stringList;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();
        String[] arrayStringLists = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        System.out.println(stringList.add(1,"eleven"));
        System.out.println(stringList.set(2,"twelve"));

    }

}
