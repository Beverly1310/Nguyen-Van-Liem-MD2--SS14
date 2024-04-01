package bai9;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        System.out.println("Nhap ngay thu nhat(dd/MM/yyy):");
        LocalDate d1 = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Nhap ngay thu hai(dd/MM/yyy):");
        LocalDate d2 = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int dayBetween = d1.compareTo(d2);
        System.out.println("Ket qua sao so sanh la: "+dayBetween);
    }
}
