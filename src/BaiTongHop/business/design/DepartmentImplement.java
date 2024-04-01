package BaiTongHop.business.design;

import BaiTongHop.business.config.InputMethods;
import BaiTongHop.business.entity.Department;
import BaiTongHop.business.entity.Employee;
import BaiTongHop.business.entity.Manager;

import java.util.ArrayList;
import java.util.List;
import static BaiTongHop.business.design.EmployeeImplement.employees;


public class DepartmentImplement implements IDepartment{
    //Tạo danh sách phòng ban
    static List<Department> departments = new ArrayList<>();
    //Tạo danh sách nhân viên


    //////////////////////////////// QUẢN TRỊ PHÒNG BAN\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //Thêm phòng ban
    @Override
    public void create() {
        Department newDepartment = Department.inputData(departments);
        departments.add(newDepartment);
    }

    // hiển thị  danh sách phòng ban
    @Override
    public void read() {
        for (Department department : departments) {
            department.displayData();
        }
    }

    // Chỉnh sửa tên phòng ban
    @Override
    public void update() {
        boolean flag = false;
        System.out.println("Nhap ma phong ban");
        String inputName = InputMethods.getString();
        for (int i = 0; i < departments.size(); i++) {// tìm phòng ban theo tên
            if (departments.get(i).getDepartmentId().equals(inputName)) {
                departments.get(i).displayData();//hiển thị thông tin phòng ban tìm đc
                System.out.println("Nhap ten moi cho phong ban: ");
                departments.get(i).setDepartmentName(InputMethods.getString());// thay đổi tên
                break;
            } else flag = true;
        }
        if (flag) {
            System.out.println("Không có phòng ban cần sửa");
        }
    }

    // Hiện thị số lượng thành viên của mỗi phòng ban
    @Override
    public void showNumberOfMember() {
        for (int i = 0; i < departments.size(); i++) {
            System.out.println("Phòng: " + departments.get(i).getDepartmentName());
            System.out.println("Danh sách");
            for (int j = 0; j < employees.size(); j++) {
                if (employees.get(j).getDepartment()==departments.get(i)) {
                    System.out.println((j+1) + employees.get(j).getEmployeeName());
                }
            }
            System.out.println("--------------------------");
        }
    }

    // xóa phòng ban
    @Override
    public void delete() {
        boolean flag = false;
        System.out.println("Nhap ma phong ban");
        String inputDepartId = InputMethods.getString();
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getDepartmentId().equals(inputDepartId) && departments.get(i).getTotalMembers() == 0) {// tìm phòng ban và kiểm tra xem phòng ban cần xóa có thành viên hay không
                departments.remove(departments.get(i));
                System.out.println("Xoa thanh cong");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Phong ban khong ton tai hoac phong ban can xoa van con nhan vien");
        }
    }
}
