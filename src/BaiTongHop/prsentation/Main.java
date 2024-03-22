package BaiTongHop.prsentation;

import BaiTongHop.business.config.InputMethods;

public class Main {
    public static void main(String[] args) {
        byte choice;
        do {
            System.out.println("------------------------MENU------------------------");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("Nhập thao tác: ");
            choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    Management.departmentManager();
                    break;
                case 2:
                    Management.employeetManager();
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (choice!=3);
    }
}
