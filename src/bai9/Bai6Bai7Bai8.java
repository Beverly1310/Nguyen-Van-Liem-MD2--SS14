package bai9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bai6Bai7Bai8 {
    public static void main(String[] args) {
        // chuyen chuoi thanh ngay
        System.out.println("Nhap vao mot ngay(dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(date);
        // chuyen ngay thanh chuoi
        String dateStr = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(dateStr);
        // nhap vao ngay gio
        System.out.println("Nhap vao mot ngay(dd/MM/yyyy HH:mm:ss): ");
        LocalDateTime dateTime = LocalDateTime.parse(new Scanner(System.in).nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        // doi localdatetime sang string
        String dateTimeStr = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println(dateTimeStr);
    }
}
