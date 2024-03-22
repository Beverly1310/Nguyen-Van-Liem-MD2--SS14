package bai9;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bai10 {
    public static void main(String[] args) {
        System.out.println("Nhap ngay thu nhat(HH:mm:ss):");
        LocalTime t1 = LocalTime.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Nhap ngay thu hai(HH:mm:ss):");
        LocalTime t2 = LocalTime.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("HH:mm:ss"));
        int timeBetween = t1.compareTo(t2);
        System.out.println("Ket qua sao so sanh la: "+timeBetween);
    }
}
