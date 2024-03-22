package BaiTongHop.prsentation;

import BaiTongHop.business.config.InputMethods;
import BaiTongHop.business.design.CRUD;
import BaiTongHop.business.design.IImplement;

public class Management {
    private static CRUD department = new IImplement();

    public static void departmentManager() {
        byte choice;
        do {
            System.out.println("------------------------MENU------------------------" +
                    "\t1.Hiển thị danh sách phòng ban\n" +
                    "\t2.Thêm mới phòng ban\n" +
                    "\t3.Chỉnh sửa tên phòng ban\n" +
                    "\t4.Hiển thị danh sách nhân viên của phòng ban theo mã phòng\n" +
                    "\t5.Xóa phòng ban\n" +
                    "\t6.Thoát\n");

            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    department.readDepart();
                    break;
                case 2:
                    department.creatDepart();
                    break;
                case 3:
                    department.editDepart();
                    break;
                case 4:
                    department.showDepartmentMember();
                    break;
                case 5:
                    department.deleteDepart();
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (choice != 6);
    }

    public static void employeetManager() {
        byte choice;
        do {
            System.out.println("------------------------MENU------------------------" +
                    "+\t1.HIển thị danh sách thông tin tất cả nhân viên(mã nhân viên và tên)\n" +
                    "+\t2.Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)\n" +
                    "+\t3.Thêm mới nhân viên\n" +
                    "+\t4.Chỉnh sửa thông tin nhân viên\n" +
                    "+\t5.Xóa nhân viên \n" +
                    "+\t6.Thống kê số lượng nhân viên trung bình của mỗi phòng \n" +
                    "+\t7.Tìm ra 5 phòng có số lượng nhân viên đông nhất\n" +
                    "+\t8.Tìm ra người quản lý nhiều  nhân viên nhất\n" +
                    "+\t9.Tìm ra 5 nhân viên có tuổi cao nhất công ty\n" +
                    "+\t10.Tìm ra 5 nhân viên hưởng lương cao nhất\n" +
                    "\t11.Thoát\n");

            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    department.readEmployee();
                    break;
                case 2:
                    department.displayEmployeeData();
                    break;
                case 3:
                    department.creatEmployee();
                    break;
                case 4:
                    department.editEmployee();
                    break;
                case 5:
                    department.deleteDepart();
                    break;
                case 6:
                    department.getSumaryEmployee();
                    break;
                case 7:
                    department.getTop5DepartEmploy();
                    break;
                case 8:
                    department.topManager();
                    break;
                case 9:
                    department.top5oldest();
                    break;
                case 10:
                    department.top5HighestSalary();
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (choice != 6);
    }
}


