package bai9;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        // ngay 1
        System.out.println("Nhap vao ngay thu nhat (dd/MM/yyyy):");
        LocalDate d1 = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // ngay 2
        System.out.println("Nhap vao ngay thu hai (dd/MM/yyyy):");
        LocalDate d2 = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        // tinh so ngay giua 2 ngay
        long dayBetween = Duration.between(d1.atStartOfDay(),d2.atStartOfDay()).toDays();
        System.out.println("So ngay giua ngay "+d1 +" va ngay "+d2+" la: "+dayBetween);
    }
}
