package bai9;

import BaiTongHop.business.config.InputMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bai12 {
    public static void main(String[] args) {
        System.out.println("Nhap vao thoi gian can tinh toan(dd/MM/yyy)");//Nhập ngày
        LocalDate date = LocalDate.parse(InputMethods.getString(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
        System.out.println("Ban muon tim ngay:\n" +
                "1.Truoc do\n" +
                "2.Sau do");
        byte choice = InputMethods.getByte();
        switch (choice){
            case 1:
                date = date.minusDays(1);
                System.out.println(date);
                break;
            case 2:
                date = date.plusDays(1);
                System.out.println(date);
                break;
            default:
                break;
        }
    }
}
