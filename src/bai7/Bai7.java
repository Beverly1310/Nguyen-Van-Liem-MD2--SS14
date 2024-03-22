package bai7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Bai7 {
    public static void main(String[] args) {
        System.out.println("Nhap vao so thu nhat:");
        int a = Integer.parseInt(new Scanner(System.in).nextLine());
        System.out.println("Nhap vao so thu hai:");
        int b = Integer.parseInt(new Scanner(System.in).nextLine());
        List<Integer> list = IntStream.range(a,b+1).boxed().toList();
        System.out.println(list);
    }
}
