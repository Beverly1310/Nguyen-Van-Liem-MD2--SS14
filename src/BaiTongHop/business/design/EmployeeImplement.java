package BaiTongHop.business.design;

import BaiTongHop.business.config.InputMethods;
import BaiTongHop.business.entity.Department;
import BaiTongHop.business.entity.Employee;
import BaiTongHop.business.entity.Manager;

import java.util.ArrayList;
import java.util.List;
import static BaiTongHop.business.design.DepartmentImplement.departments;


public class EmployeeImplement implements IEmployee {
   static List<Employee> employees = new ArrayList<>();
    //Tạo danh sách quản lý
   static List<Manager> managers = new ArrayList<>();
    @Override
// Lựa chọn thêm mới nhân viên hoặc quản lý
    public void create() {
        System.out.println("Them moi:");
        System.out.println("1. Nhan vien:");
        System.out.println("2. Quan ly:");
        byte choice= InputMethods.getByte();
        System.out.println("Nhap so nhan vien muon them: ");
        byte count = InputMethods.getByte();
        switch (choice) {
            case 1:
                for (int i = 0; i < count; i++) {
                    System.out.println("Nhap thong tin cho nhan vien thu: "+(i+1));
                    Employee newEmployee = Employee.addEmployee(employees,managers,departments);
                    employees.add(newEmployee);
                }
                break;
            case 2:
                for (int i = 0; i < count; i++) {
                    System.out.println("Nhap thong tin cho quan ly thu: "+(i+1));
                    Manager newManager = Employee.addManager(employees,departments);
                    managers.add(newManager);
                    employees.add(newManager);
                }
                break;
            default:
                break;
        }

    }

    //Hiển thị danh sách nhân viên
    @Override
    public void read() {
        for (Employee employee : employees) {
            System.out.println("Mã nhân viên: " + employee.getEmployeeId());
            System.out.println("Tên nhân viên: " + employee.getEmployeeName());
            System.out.println("------------------------");
        }
    }

    //hiển thị
    @Override
    public void displayData() {
        System.out.println("Nhập ID nhân viên cần kiểm tra thông tin:");
        String input = InputMethods.getString();
        boolean flag = true;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(input)) {
                employees.get(i).displayData();;
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Không có nhân viên cần tìm");
        }
    }

    // Thay đổi thông tin nhân viên
    @Override
    public void update() {
        boolean flag = false;
        System.out.println("Nhap ID nhan vien can sua");
        String input =InputMethods.getString();
        for (int i = 0; i < employees.size(); i++) {// duyệt để tìm nhân viên cần sửa
            if (employees.get(i).getEmployeeId().equals(input)) {// tìm thấy thì gọi đến method getEmployee()
                if (managers.contains(employees.get(i))){
                    employees.get(i).displayData();
                    Manager editEmployee = Employee.addManager(employees,departments);
                    managers.set(managers.indexOf(employees.get(i)),editEmployee);
                    employees.set(i, editEmployee);
                    flag = true;
                    break;
                } else {
                    Employee editEmployee = Employee.addEmployee(employees,managers,departments);
                    employees.set(i, editEmployee);
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("Khong tim thay nhan vien");
        }
    }

    // Xóa nhân viên
    @Override
    public void delete() {
        boolean flag = false;
        System.out.println("Nhap ID nhan vien can xoa");
        for (int i = 0; i < employees.size(); i++) {//duyệt để tìm nhân viên theo ID
            if (employees.get(i).getEmployeeId().equals(InputMethods.getString())) {
                employees.remove(employees.get(i));//xóa nhân viên khỏi list
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Khong tim thay nhan vien");
        }
    }

    //Thống kê số lượng phòng ban mỗi nhân viên
    @Override
    public void getSumaryEmployee() {
        System.out.println("Trung bình: " + employees.size() / departments.size() + "nhan vien/phong ban");
    }

    //Tìm ra 5 phòng có sô lượng nhân viên đông nhất
    @Override
    public void getTop5DepartEmploy() {
        List<Department> sortedDepart = departments.stream().sorted(((o1, o2) -> {// sắp xêp list departments theo thứ tự thành viên giảm dân
            return o2.getTotalMembers() - o1.getTotalMembers();
        })).toList();
        System.out.println("Top 5 phong ban co so luong nhan vien dong nhat la");
        if (sortedDepart.size() > 5) {
            for (int i = 0; i < 5; i++) {//in ra 5 phòng ban đầu của list sau sx
                System.out.println("Top" + (i+1) + ": " + sortedDepart.get(i).getDepartmentName());
                System.out.println("---------------------------");
            }
        } else {
            for (int i = 0; i < sortedDepart.size(); i++) {//in ra 5 phòng ban đầu của list sau sx
                System.out.println("Top" + (i+1) + ": " + sortedDepart.get(i).getDepartmentName());
                System.out.println("---------------------------");
            }
        }
    }

    //Tìm ra người quản lý nhiều  nhân viên nhất
    @Override
    public void topManager() {
        List<Manager> sortedManager = managers.stream().sorted((o1, o2) -> {//sx list manager theo tt số ng quản lý giảm dần
            return o2.getTotalManage() - o1.getTotalManage();
        }).toList();
        System.out.println("Nguoi quan ly nhieu nhan vien nhat la: " + sortedManager.get(0).getEmployeeName());// in ra thành viên đầu của list sau sx
    }

    //	Tìm ra 5 nhân viên có tuổi cao nhất công ty
    @Override
    public void top5oldest() {
        List<Employee> sortedEmployee = employees.stream().sorted((o1, o2) -> {// sắp xêp list employee theo thứ tự tuổi giảm dân
            return o1.getBirthday().compareTo(o2.getBirthday());
        }).toList();
        if (sortedEmployee.size() > 5) {
            System.out.println("Top 5 nhan vien cao tuoi nhat la");
            for (int i = 0; i < 5; i++) {//in ra 5 nhân viên đầu của list sau sx
                System.out.println("Top" + (i+1) + ": " + sortedEmployee.get(i).getEmployeeName());
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("Top 5 nhan vien cao tuoi nhat la");
            for (int i = 0; i < sortedEmployee.size(); i++) {//in ra 5 nhân viên đầu của list sau sx
                System.out.println("Top" + (i+1) + ": " + sortedEmployee.get(i).getEmployeeName());
                System.out.println("---------------------------");
            }
        }

    }

    //Tìm ra 5 nhân viên hưởng lương cao nhất
    @Override
    public void top5HighestSalary() {
        List<Employee> sortedEmployee = employees.stream().sorted((o1, o2) -> {// sắp xêp list employee theo thứ tự lương giảm dân
            return (int) (o2.getSalary() - o1.getSalary());
        }).toList();
        if (sortedEmployee.size() > 5) {
            System.out.println("Top 5 nhan vien luong cao nhat la");
            for (int i = 0; i < 5; i++) {//in ra 5 nhân viên đầu của list sau sx
                System.out.println("Top" + (i+1) + ": " + sortedEmployee.get(i).getEmployeeName());
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("Top 5 nhan vien luong cao nhat la");
            for (int i = 0; i < sortedEmployee.size(); i++) {//in ra 5 nhân viên đầu của list sau sx
                System.out.println("Top" + (i+1) + ": " + sortedEmployee.get(i).getEmployeeName());
                System.out.println("---------------------------");
            }
        }
    }
}
