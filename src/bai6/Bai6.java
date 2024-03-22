package bai6;

import java.util.Arrays;
import java.util.List;

public class Bai6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","d","f","h","e","c","g");
        List<String> newList = list.stream().map(String::toUpperCase).toList();
        System.out.println(newList);
    }
}
