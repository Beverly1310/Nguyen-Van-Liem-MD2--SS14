package BaiTongHop.business.design;

import BaiTongHop.business.config.InputMethods;
import BaiTongHop.business.entity.Department;
import BaiTongHop.business.entity.Employee;
import BaiTongHop.business.entity.Manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class IImplement implements CRUD {
    //Tạo danh sách phòng ban
    List<Department> departments = new ArrayList<>();
    //Tạo danh sách nhân viên
    List<Employee> employees = new ArrayList<>();
    //Tạo danh sách quản lý
    List<Manager> managers = new ArrayList<>();

    //////////////////////////////// QUẢN TRỊ PHÒNG BAN\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    //Thêm phòng ban
    @Override
    public void creatDepart() {
        Department newDepartment = new Department();
        // Nhập ID cho phòng ban với validate theo yêu cầu
        while (true) {
            System.out.println("Nhap Id phong ban:");
            String inputId = InputMethods.getString();
            boolean checkStar = false;
            boolean checkExist = true;
            boolean checkLength = false;
            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getDepartmentId().equals(inputId)) {
                    checkExist = false;
                    System.out.println("ID đã tồn tại");
                }
            }
            if (inputId.startsWith("D")) {
                checkStar = true;
                System.out.println("ID phải bắt đầu bằng ký tự D");
            }
            if (inputId.length() == 4) {
                checkLength = true;
                System.out.println("phải đủ 4 ký tự");
            }
            if (!checkExist && checkLength && checkStar) {
                newDepartment.setDepartmentId(inputId);
                break;
            }
        }
        // Nhập tên cho phòng ban với validate theo yêu cầu
        while (true) {
            System.out.println("Nhap ten phong ban: ");
            String inputName = InputMethods.getString();
            boolean checkExist = true;
            boolean checkBlank = false;
            for (int i = 0; i < departments.size(); i++) {
                if (departments.get(i).getDepartmentId().equals(inputName)) {
                    checkExist = false;
                    System.out.println("Tên đã tồn tại");
                }
            }
            if (inputName.isBlank()) {
                checkBlank = true;
                System.out.println("Không được để trống");
            }
            if (!checkExist && !checkBlank) {
                newDepartment.setDepartmentName(inputName);
                break;
            }
        }
        // Đặt số lượng nhân viên cùa phòng ban vừa thêm = 0
        newDepartment.setTotalMembers(0);
        // thêm phòng ban vào list
        departments.add(newDepartment);
    }

    // hiển thị  danh sách phòng ban
    @Override
    public void readDepart() {
        for (Department department : departments) {
            System.out.println(department.toString());
            System.out.println("--------------------------");
        }
    }

    // Chỉnh sửa tên phòng ban
    @Override
    public void editDepart() {
        boolean flag = false;
        System.out.println("Nhap ma phong ban");
        String inputName = InputMethods.getString();
        for (int i = 0; i < departments.size(); i++) {// tìm phòng ban theo tên
            if (departments.get(i).getDepartmentId().equals(inputName)) {
                departments.get(i).toString();//hiển thị thông tin phòng ban tìm đc
                System.out.println("Nhap ten moi cho phong ban: ");
                departments.get(i).setDepartmentName(InputMethods.getString());// thay đổi tên
                break;
            }
            else flag=true;
        }
        if (flag){
            System.out.println("Không có phòng ban cần xóa");
        }
    }
// Hiện thị số lượng thành viên của mỗi phòng ban
    @Override
    public void showDepartmentMember() {
        for (int i = 0; i < departments.size(); i++) {
            System.out.println("Phòng: "+departments.get(i).getDepartmentName());
            System.out.println("Danh sách");
            for (int j = 0; j < employees.size(); j++) {
                if (employees.get(j).getDepartment().equals(departments.get(i).getDepartmentId())) {
                    System.out.println("j. "+employees.get(j).getEmployeeName());
                }
            }
        }
    }
// xóa phòng ban
    @Override
    public void deleteDepart() {
        boolean flag = false;
        System.out.println("Nhap ma phong ban");
        String inputDepartId = InputMethods.getString();
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getDepartmentId().equals(inputDepartId) && departments.get(i).getTotalMembers() != 0) {// tìm phòng ban và kiểm tra xem phòng ban cần xóa có thành viên hay không
                departments.remove(departments.get(i));
                break;
            } else {
                flag=true;
            }
        }
        if (flag){
            System.out.println("Phong ban khong ton tai hoac phong ban can xoa van con nhan vien");
        }
    }
    //////////////////////////////////QUẢN TRỊ NHÂN VIÊN\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @Override
// Lựa chọn thêm mới nhân viên hoặc quản lý
    public void creatEmployee() {
        System.out.println("Them moi:");
        System.out.println("1. Nhan vien:");
        System.out.println("2. Quan ly:");
        switch (InputMethods.getInteger()) {
            case 1:
                Employee newEmployee = getEmployee();
                employees.add(newEmployee);
                break;
            case 2:
                Employee newManager = getEmployee();
                managers.add((Manager) newManager);
                employees.add(newManager);
                break;
            default:
                break;
        }

    }
// Phương thức thêm mới nhân viên vơi validate
    private Employee getEmployee() {
        Employee newEmployee = new Employee();
        while (true) {
            System.out.println("Nhap Id nhan vien:");
            String inputId = InputMethods.getString();
            boolean checkStar = false;
            boolean checkLength = false;
            for (int i = 0; i < employees.size(); i++) {
                if (inputId.length()==5) {
                    checkLength = true;
                    System.out.println("Phải đủ 5 ký tự");
                }
            }
            if (inputId.startsWith("E")) {
                checkStar = true;
                System.out.println("Phải bắt đầu bằng ký tự E");
            }
            if (checkLength && checkStar) {
                newEmployee.setEmployeeId(inputId);
                break;
            }
        }
        System.out.println("Nhap ten nhan vien: ");
        newEmployee.setEmployeeName(InputMethods.getString());
        System.out.println("Nhap ngay sinh(dd//MM/yyyy): ");
        newEmployee.setBirthday(LocalDate.parse(InputMethods.getString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Nhap gioi tinh(true/false): ");
        newEmployee.setSex(InputMethods.getBoolean());
        System.out.println("Nhap luong:");
        newEmployee.setSalary(InputMethods.getDouble());
        System.out.println("Nhap nguoi quan ly");
        String inputManage = InputMethods.getString();
        if (inputManage != null) {
            for (int i = 0; i < managers.size(); i++) {
                if (managers.get(i).getEmployeeName().equals(inputManage)) {//Tìm người quản lý
                    newEmployee.setManager(managers.get(i));//Tìm thấy thì set người quản lý cho nhân viên
                    managers.get(i).setTotalManage(managers.get(i).getTotalManage()+1);//Số lượng người quản lý của nhân viên tăng thêm 1
                    break;
                }
            }
        }
        boolean flag = true;
        while (flag) {
            System.out.println("Nhap ma phong ban");
            String inputDepart = InputMethods.getString();
            for (int i = 0; i < departments.size(); i++) {
                if (inputDepart.equals(departments.get(i).getDepartmentId())) {// tìm phòng ban
                    newEmployee.setDepartment(departments.get(i));//tìm thấy thì set cho nhân viên
                    departments.get(i).setTotalMembers(departments.get(i).getTotalMembers() + 1);// số lượng thành viên của phòng ban tăng thêm 1
                    flag = false;
                } else System.out.println("Khong co phong ban de them nhan vien. Moi nhap lai");
            }
        }

        return newEmployee;
    }
//Hiển thị danh sách nhân viên
    @Override
    public void readEmployee() {
        for (Employee employee : employees) {
            System.out.println("Mã nhân viên: "+employee.getEmployeeId());
            System.out.println("Tên nhân viên: "+employee.getEmployeeName());
            System.out.println("------------------------");
        }
    }

    @Override
    public void displayEmployeeData() {
        System.out.println("Nhập tên nhân viên cần kiểm tra thông tin:");
        String input = InputMethods.getString();
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(input)){
                employees.get(i).toString();
                break;
            }
            else flag=true;
        }
        if (flag){
            System.out.println("Không có nhân viên cần tìm");
        }
    }

    // Thay đổi thông tin nhân viên
    @Override
    public void editEmployee() {
        boolean flag = false;
        System.out.println("Nhap ID nhan vien can sua");
        for (int i = 0; i < employees.size(); i++) {// duyệt để tìm nhân viên cần sửa
            if (employees.get(i).getEmployeeId().equals(InputMethods.getString())) {// tìm thấy thì gọi đến method getEmployee()
                employees.set(i,getEmployee()) ;
                break;
            } else {
                flag = true;
            }
        }
        if (flag){
            System.out.println("Khong tim thay nhan vien");
        }
    }
// Xóa nhân viên
    @Override
    public void deleteEmployee() {
        boolean flag = false;
        System.out.println("Nhap ID nhan vien can xoa");
        for (int i = 0; i < employees.size(); i++) {//duyệt để tìm nhân viên theo ID
            if (employees.get(i).getEmployeeId().equals(InputMethods.getString())) {
                employees.remove(employees.get(i));//xóa nhân viên khỏi list
                break;
            } else {
               flag=true;
            }
        }
        if (flag){
            System.out.println("Khong tim thay nhan vien");
        }
    }
//Thống kê số lượng phòng ban mỗi nhân viên
    @Override
    public void getSumaryEmployee() {
        System.out.println("Trung bình: "+employees.size()/departments.size()+"/phong ban");
    }
//Tìm ra 5 phòng có sô lượng nhân viên đông nhất
    @Override
    public void getTop5DepartEmploy() {
        List<Department> sortedDepart = departments.stream().sorted(((o1, o2) -> {// sắp xêp list departments theo thứ tự thành viên giảm dân
            return o1.getTotalMembers() - o2.getTotalMembers();
        })).toList();
        System.out.println("Top 5 phong ban co so luong nhan vien dong nhat la");
        for (int i = 0; i < 5; i++) {//in ra 5 phòng ban đầu của list sau sx
            System.out.println("Top" + i + ": " + sortedDepart.get(i).getDepartmentName());
            System.out.println("---------------------------");
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
            return o2.getBirthday().compareTo(o1.getBirthday());
        }).toList();
        System.out.println("Top 5 nhan vien cao tuoi nhat la");
        for (int i = 0; i < 5; i++) {//in ra 5 nhân viên đầu của list sau sx
            System.out.println("Top" + i + ": " + sortedEmployee.get(i).getEmployeeName());
            System.out.println("---------------------------");
        }
    }
//Tìm ra 5 nhân viên hưởng lương cao nhất
    @Override
    public void top5HighestSalary() {
        List<Employee> sortedEmployee = employees.stream().sorted((o1, o2) -> {// sắp xêp list employee theo thứ tự lương giảm dân
            return (int) (o2.getSalary() - o1.getSalary());
        }).toList();
        System.out.println("Top 5 nhan vien luong cao nhat la");
        for (int i = 0; i < 5; i++) {//in ra 5 nhân viên đầu của list sau sx
            System.out.println("Top" + i + ": " + sortedEmployee.get(i).getEmployeeName());
            System.out.println("---------------------------");
        }
    }
}
