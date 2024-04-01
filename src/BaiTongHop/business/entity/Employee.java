package BaiTongHop.business.entity;

import BaiTongHop.business.config.InputMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String employeeId;
    private String employeeName;
    private LocalDate birthday;
    private boolean sex;
    private double salary;
    private Employee manager;
    private Department department;

    public Employee() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, double salary, Employee manager, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void displayData() {
        System.out.println("Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", birthday=" + birthday +
                ", sex=" + (sex ? "Nam" : "Nữ") +
                ", salary=" + salary +
                ", manager=" + manager +
                '}');
        System.out.println("---------------------------------");
    }


public static Employee addEmployee(List<Employee> employees, List<Manager> managers, List<Department> departments){
    Employee newEmployee = getEmployee(employees, managers, departments);
    return newEmployee;
}
public static Manager addManager(List<Employee> employees,  List<Department> departments){
    Manager newManager = getManager(employees, departments);
    return newManager;
}
    private static Employee getEmployee(List<Employee> employees, List<Manager> managers, List<Department> departments) {
        Employee newEmployee = new Employee();

        inputIdEmployee(employees, newEmployee);

        inputNameEmployee(newEmployee);

        inputBdEmployee(newEmployee);

        inputSexEmployee(newEmployee);

        inputSalaryEmployee(newEmployee);

        inputManagerEmployee(managers, newEmployee);

        inputDepartmentEmployee(departments, newEmployee);

        return newEmployee;
    }

    private static void inputDepartmentEmployee(List<Department> departments, Employee newEmployee) {
        boolean flag = false;
        while (!flag) {
            System.out.println("Nhap ma phong ban");
            for (Department department : departments) {
                System.out.println(department.getDepartmentId()+"\t\t");
            }
            String inputDepart = InputMethods.getString();
            for (int i = 0; i < departments.size(); i++) {
                if (inputDepart.equals(departments.get(i).getDepartmentId())) {// tìm phòng ban
                    newEmployee.setDepartment(departments.get(i));//tìm thấy thì set cho nhân viên
                    departments.get(i).setTotalMembers(departments.get(i).getTotalMembers() + 1);// số lượng thành viên của phòng ban tăng thêm 1
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("Khong co phong ban de them nhan vien. Moi nhap lai");
            }
        }
    }

    private static void inputManagerEmployee(List<Manager> managers, Employee newEmployee) {
        System.out.println("Nhap ID nguoi quan ly");
        for (Manager manager : managers) {
            System.out.print(manager.getEmployeeName()+ ": "+manager.getEmployeeId() +"\t\t");
        }
        String inputManage = new Scanner(System.in).nextLine();
        if (inputManage != null) {
            for (int i = 0; i < managers.size(); i++) {
                if (managers.get(i).getEmployeeId().equals(inputManage)) {//Tìm người quản lý
                    newEmployee.setManager(managers.get(i));//Tìm thấy thì set người quản lý cho nhân viên
                    managers.get(i).setTotalManage(managers.get(i).getTotalManage() + 1);//Số lượng người quản lý của nhân viên tăng thêm 1
                    break;
                }
            }
        }
    }

    private static void inputSalaryEmployee(Employee newEmployee) {
        System.out.println("Nhap luong:");
        newEmployee.setSalary(InputMethods.getDouble());
    }

    private static void inputSexEmployee(Employee newEmployee) {
        System.out.println("Nhap gioi tinh(true/false): ");
        newEmployee.setSex(InputMethods.getBoolean());
    }

    private static void inputBdEmployee(Employee newEmployee) {
        System.out.println("Nhap ngay sinh(dd//MM/yyyy): ");
        newEmployee.setBirthday(LocalDate.parse(InputMethods.getString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    private static void inputNameEmployee(Employee newEmployee) {
        System.out.println("Nhap ten nhan vien: ");
        newEmployee.setEmployeeName(InputMethods.getString());
    }

    private static void inputIdEmployee(List<Employee> employees, Employee newEmployee) {
        while (true) {
            System.out.println("Nhap Id nhan vien:");
            String inputId = InputMethods.getString();
            boolean checkStar = true;
            boolean checkLength = true;
            for (int i = 0; i < employees.size(); i++) {
                if (inputId.length() != 5) {
                    checkLength = false;
                    System.out.println("Phải đủ 5 ký tự");
                }
            }
            if (!inputId.startsWith("E")) {
                checkStar = false;
                System.out.println("Phải bắt đầu bằng ký tự E");
            }
            if (checkLength && checkStar) {
                newEmployee.setEmployeeId(inputId);
                break;
            }
        }
    }

    // Thêm mới quản ly
    private static Manager getManager(List<Employee> employees, List<Department> departments) {
        Manager newManager = new Manager();
        inputIdEmployee(employees, newManager);

        inputNameEmployee(newManager);

        inputBdEmployee(newManager);

        inputSexEmployee(newManager);

        inputSalaryEmployee(newManager);

        inputDepartmentEmployee(departments, newManager);


        return newManager;
    }
}
