package BaiTongHop.business.entity;

import java.time.LocalDate;

public class Manager extends Employee{
    private int totalManage;

    public Manager() {
        this.totalManage = 0;
    }

    public Manager(String employeeId, String employeeName, LocalDate birthday, boolean sex, double salary, Employee manager, Department department, int totalManage) {
        super(employeeId, employeeName, birthday, sex, salary, manager, department);
        this.totalManage = 0;
    }

    public int getTotalManage() {
        return totalManage;
    }

    public void setTotalManage(int totalManage) {
        this.totalManage = totalManage;
    }
}
