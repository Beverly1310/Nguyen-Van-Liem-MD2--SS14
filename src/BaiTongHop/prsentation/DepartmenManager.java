package BaiTongHop.prsentation;

import BaiTongHop.business.config.InputMethods;
import BaiTongHop.business.design.DepartmentImplement;
import BaiTongHop.business.design.IDepartment;

public class DepartmenManager {
    static IDepartment department = new DepartmentImplement();
    public static void departmentManager() {
        byte choice;
        do {
            System.out.println("------------------------MENU------------------------\n" +
                    "\t1.Hiển thị danh sách phòng ban\n" +
                    "\t2.Thêm mới phòng ban\n" +
                    "\t3.Chỉnh sửa tên phòng ban\n" +
                    "\t4.Hiển thị danh sách nhân viên của phòng ban theo mã phòng\n" +
                    "\t5.Xóa phòng ban\n" +
                    "\t6.Thoát\n");

            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    department.read();
                    break;
                case 2:
                    department.create();
                    break;
                case 3:
                    department.update();
                    break;
                case 4:
                    department.showNumberOfMember();
                    break;
                case 5:
                    department.delete();
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (choice != 6);
    }

}
