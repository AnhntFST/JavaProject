import java.util.ArrayList;
import java.util.Scanner;

public abstract class  Staff {
    String id;  // Ma nhan vien
    String name; // full ten nhan vien
    int age; // Tuoi nhan vien
    double levelOfSalary; // Bac luong hay he so luong
    String dateIn;  // Ngay vao lam
    String department; // Ten Bo phan
    int leave;  // So ngay phep
    double salary; // luong nhan vien




    // Ham nhap du lieu nhan vien
    public void input(ArrayList<Department> departmentList){
        Scanner input = new Scanner(System.in);
        int count;
        System.out.print("Nhap ma nhan vien: ");
        id = input.nextLine();

        System.out.print("Nhap ten nhan vien: ");
        name = input.nextLine();

        System.out.print("Nhap tuoi nhan vien: ");
        age = Integer.parseInt(input.nextLine());

        System.out.print("Nhap he so luong nhan vien: ");
        levelOfSalary = Float.parseFloat(input.nextLine());

        System.out.print("Nhap ngay vao lam cua nhan vien: ");
        dateIn = input.nextLine();

        System.out.print("Nhap ngay nghi phep nhan vien: ");
        leave = Integer.parseInt(input.nextLine());

        System.out.println("1. HC - Hanh chinh nhan su");
        System.out.println("2. IT - Cong nghe thong tin");
        System.out.println("3. MKT - Marketing");
        System.out.print("Ban chon bo phan: ");
        int choose = Integer.parseInt(input.nextLine());
        if (choose == 1) {
            department = departmentList.get(0).getNameDpm();
            count = departmentList.get(0).getNumberOfStaff();
            count ++;
            departmentList.get(0).setNumberOfStaff(count);
        } else if(choose == 2) {
            department = departmentList.get(1).getNameDpm();
            count = departmentList.get(1).getNumberOfStaff();
            count ++;
            departmentList.get(1).setNumberOfStaff(count);
        } else if(choose == 3) {
            department = departmentList.get(2).getNameDpm();
            count = departmentList.get(2).getNumberOfStaff();
            count ++;
            departmentList.get(2).setNumberOfStaff(count);
        }
    }
    // Ham hien thi thong tin
    public abstract void displayInformation();

    // Cac ham getter
    public double getLevelOfSalary() {
        return levelOfSalary;
    }
    public String getDepartment(){
        return department;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public double getSalary(){
        return salary;
    }

}
