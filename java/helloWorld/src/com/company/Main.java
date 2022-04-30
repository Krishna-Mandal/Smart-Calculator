package com.company;
import com.company.mypkg.elementary.*;
import com.company.mypkg.Math;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    String berry = "blue";
    public static void main(String[] args) {
        List<String> songTitles = Arrays.asList("humble", "element", "dna");
        Function<String, String> capitalize = str ->str.toUpperCase();
        songTitles.stream().map(capitalize).forEach(System.out::println);
    }
}
