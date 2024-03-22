package bai9;

import BaiTongHop.business.config.InputMethods;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Bai11 {
    public static void main(String[] args) {
        System.out.println("Nhap vao thoi gian can tinh toan(dd/MM/yyy HH:mm:ss)");//Nhập ngày
        LocalDateTime dateTime = LocalDateTime.parse(InputMethods.getString(), DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss"));
        System.out.println("Ban muon them hay bot?\n" +
                "1.Cong\n" +
                "2.Tru");
        byte choice1= InputMethods.getByte();
        System.out.println("Nhap gia tri de tinh toan");
        long amount=InputMethods.getInteger();
        System.out.println("Chon doi tuong thay doi\n" +
                "1.Ngay\n" +
                "2.Thang\n" +
                "3.Nam\n" +
                "4.Gio\n" +
                "5.Phut\n" +
                "6.Giay\n");
        byte choice2 = InputMethods.getByte();
        switch (choice1){
            case 1://cộng
                switch (choice2){
                    case 1://thêm ngày
                        dateTime=dateTime.plusDays(amount);
                        System.out.println(dateTime);
                        break;
                    case 2://thêm tháng
                        dateTime=dateTime.plusMonths(amount);
                        System.out.println(dateTime);
                        break;
                    case 3://thêm năm
                        dateTime=dateTime.plusYears(amount);
                        System.out.println(dateTime);
                        break;
                    case 4://thêm giờ
                        dateTime=dateTime.plusHours(amount);
                        System.out.println(dateTime);
                        break;
                    case 5://thêm phút
                        dateTime=dateTime.plusMinutes(amount);
                        System.out.println(dateTime);
                        break;
                    case 6://thêm giây
                        dateTime=dateTime.plusSeconds(amount);
                        System.out.println(dateTime);
                        break;
                    default:
                        break;
                }
                break;
            case 2://trừ
                switch (choice2){
                    case 1://trừ ngày
                        dateTime=dateTime.minusDays(amount);
                        System.out.println(dateTime);
                        break;
                    case 2://trừ tháng
                        dateTime=dateTime.minusMonths(amount);
                        System.out.println(dateTime);
                        break;
                    case 3://trừ nam
                        dateTime=dateTime.minusYears(amount);
                        System.out.println(dateTime);
                        break;
                    case 4://trừ giờ
                        dateTime=dateTime.minusHours(amount);
                        System.out.println(dateTime);
                        break;
                    case 5://trừ phút
                        dateTime=dateTime.minusMinutes(amount);
                        System.out.println(dateTime);
                        break;
                    case 6://trừ giây
                        dateTime=dateTime.minusSeconds(amount);
                        System.out.println(dateTime);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

    }
}
