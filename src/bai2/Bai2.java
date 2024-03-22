package bai2;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Bai2 {
    public static void main(String[] args) {
        List<Integer> list = Stream.generate(()->new Random().nextInt(1000)).limit(100).sorted().filter(num -> num%2==0).toList();
        System.out.println(list);
    }
}
