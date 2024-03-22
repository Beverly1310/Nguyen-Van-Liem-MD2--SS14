package bai1;

import java.util.*;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Bai1 {
    public static void main(String[] args) {
        List<Integer> random = Stream.generate(() -> new Random().nextInt(1000)).limit(100).sorted().toList();
        Optional<Integer> max = random.stream().max((o1, o2) -> {
            return o1 - o2;
        });
        System.out.println("Max la: " + max.orElseThrow(RuntimeException::new));
    }
}