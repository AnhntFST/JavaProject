import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Staff implements ICalculator{
    static double luongCb;
    String position; // chuc vu


    // Ham input position;
    public void input(ArrayList<Department> departmentList){
        super.input(departmentList);
        Scanner input = new Scanner(System.in);
        System.out.println("Chuc danh: ");
        System.out.println("1. Business Leader ");
        System.out.println("2. Project Leader ");
        System.out.println("3. Technical Leader ");
        System.out.println("Nhap chuc danh: ");
        int choose = Integer.parseInt(input.nextLine());
        if (choose == 1) {
            setPosition("Business Leader");
            setSalary(calculator());
        } else if(choose == 2) {
            setPosition("Project Leader");
            setSalary(calculator());
        } else if(choose == 3) {
            setPosition("Technical Leader");
            setSalary(calculator());
        }

    }
    // Hien thi nhan vien
    @Override
    public void displayInformation() {
        System.out.format("%-12s%-2c%-18s%-2c%-6d%-2c%-10.1f%-2c%-15s%-2c%-18d%-2c%-20s%-2c%-25s%-2c%-10.2f \n",id,'|',name,'|',age,'|',levelOfSalary,'|',dateIn,'|',leave,'|',department,'|',position,'|',salary);
    }
    // Ham tinh luong nhan vien
    @Override
    public double calculator() {
        luongCb = 5000000;
        double salary = getLevelOfSalary() * luongCb;
        if(getPosition().equalsIgnoreCase("Business Leader")) {
             salary += 8000000;
        } else if (getPosition().equalsIgnoreCase("Project Leader")) {
            salary += 5000000;
        } else if (getPosition().equalsIgnoreCase("Technical Leader")) {
            salary += 6000000;
        }
        return salary;
    }
    // Cac ham getter và setter
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
