package BaiTongHop.prsentation;

import BaiTongHop.business.config.InputMethods;
import BaiTongHop.business.design.IEmployee;

public class EmployeeImplement {
    static IEmployee employee =new BaiTongHop.business.design.EmployeeImplement();
    public static void employeetManager() {
        byte choice;
        do {
            System.out.println("------------------------MENU------------------------\n" +
                    "\t1.HIển thị danh sách thông tin tất cả nhân viên(mã nhân viên và tên)\n" +
                    "\t2.Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)\n" +
                    "\t3.Thêm mới nhân viên\n" +
                    "\t4.Chỉnh sửa thông tin nhân viên\n" +
                    "\t5.Xóa nhân viên \n" +
                    "\t6.Thống kê số lượng nhân viên trung bình của mỗi phòng \n" +
                    "\t7.Tìm ra 5 phòng có số lượng nhân viên đông nhất\n" +
                    "\t8.Tìm ra người quản lý nhiều  nhân viên nhất\n" +
                    "\t9.Tìm ra 5 nhân viên có tuổi cao nhất công ty\n" +
                    "\t10.Tìm ra 5 nhân viên hưởng lương cao nhất\n" +
                    "\t11.Thoát\n");

            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    employee.read();
                    break;
                case 2:
                    employee.displayData();
                    break;
                case 3:
                    employee.create();
                    break;
                case 4:
                    employee.update();
                    break;
                case 5:
                    employee.delete();
                    break;
                case 6:
                    employee.getSumaryEmployee();
                    break;
                case 7:
                    employee.getTop5DepartEmploy();
                    break;
                case 8:
                    employee.topManager();
                    break;
                case 9:
                    employee.top5oldest();
                    break;
                case 10:
                    employee.top5HighestSalary();
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (choice != 11);
    }
}
