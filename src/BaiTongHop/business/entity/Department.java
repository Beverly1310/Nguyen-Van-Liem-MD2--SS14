package BaiTongHop.business.entity;

import BaiTongHop.business.config.InputMethods;

import java.util.List;

public class Department {
    private String departmentId;
    private String departmentName;
    private int totalMembers;

    public Department() {

    }

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = 0;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public void displayData() {
        System.out.println("Department{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", totalMembers=" + totalMembers +
                '}');
        System.out.println("--------------------------------");
    }

    public static Department inputData(List<Department> departments) {
        Department newDepartment = new Department();
        // Nhập ID cho phòng ban với validate theo yêu cầu
        idInput(departments, newDepartment);
        // Nhập tên cho phòng ban với validate theo yêu cầu
        nameInput(departments, newDepartment);
        // thêm phòng ban vào list
        return newDepartment;
    }

    private static void nameInput(List<Department> departments, Department newDepartment) {
        while (true) {
            System.out.println("Nhap ten phong ban: ");
            String inputName = InputMethods.getString();
            if (!inputName.isBlank()) {
                newDepartment.setDepartmentName(inputName);
                break;
            } else {
                System.err.println("Ten khong duoc de trong");
            }
        }
    }

    private static void idInput(List<Department> departments, Department newDepartment) {
        final String regex = "^D\\w{3}$";
        while (true) {
            System.out.println("Nhap Id phong ban:");
            String inputId = InputMethods.getString();
            if (!inputId.isBlank()) {
                if (inputId.matches(regex)) {
                    if (departments.stream().noneMatch(t -> t.getDepartmentId().equals(inputId))) {
                        newDepartment.setDepartmentId(inputId);
                        break;
                    }else {
                        System.err.println("Ten da ton tai");
                    }
                }else {
                    System.err.println("Khong dung dinh danh D___");
                }
            }else {
                System.err.println("Khong duoc de trong");
            }
        }
    }
}


