import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Staff implements ICalculator{
    double overTime; // gio lam them

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public void input(ArrayList<Department> departmentList){
        super.input(departmentList);
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so gio lam them");
        overTime = Double.parseDouble(input.nextLine());
        setSalary(calculator());
    }
    // Hien thi nhan vien
    @Override
    public void displayInformation() {
        System.out.format("%-12s%-2c%-18s%-2c%-6d%-2c%-10.1f%-2c%-15s%-2c%-18d%-2c%-20s%-2c%-25s%-2c%-10.2f \n",id,'|',name,'|',age,'|',levelOfSalary,'|',dateIn,'|',leave,'|',department,'|',overTime,'|',salary);

    }
    // Ham tinh luong nhan vien
    @Override
    public double calculator() {
        int luongCoBan = 3000000;
        int luongOT = 200000;
        salary = getLevelOfSalary()*luongCoBan + getOverTime()*luongOT;
        return salary;
    }
     // Ham setter
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
