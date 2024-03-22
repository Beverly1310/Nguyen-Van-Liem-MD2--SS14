package bai9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Bai1 {
    public static void main(String[] args) {
        LocalDateTime systemTime = LocalDateTime.now();
        System.out.println("Thoi gian hien tai cua he thong la: "+systemTime);
        //Tokyo
        LocalDateTime tokyoTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Thoi gian hien tai o Tokyo la: "+tokyoTime);
        //Australia
        LocalDateTime australiaTime = LocalDateTime.now(ZoneId.of("Australia/Sydney"));
        System.out.println("Thoi gian hien tai o Australia la: "+australiaTime);
        //America
        LocalDateTime americaTime = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Thoi gian hien tai o America la: "+americaTime);
    }
}
