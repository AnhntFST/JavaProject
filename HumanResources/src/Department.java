import java.util.Scanner;

public class Department {
    String idDpm;  // Dpm = Department;
    String nameDpm;
    int numberOfStaff;

    public Department() {
    }

    public Department(String idDpm, String nameDpm, int numberOfStaff) {
        this.idDpm = idDpm;
        this.nameDpm = nameDpm;
        this.numberOfStaff = numberOfStaff;
    }

    // Methods
    //Ham hien thi bo phan

    public void display(){
        System.out.format(toString(), idDpm,'|',nameDpm,'|',numberOfStaff);
    }

    @Override
    public String toString() {
        return "%-20s%-2c%-30s%-2c%-15s\n";
    }

    // Ham nhap bo phan
    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma bo phan: ");
        idDpm = input.nextLine();

        System.out.print("Nhap ten bo phan: ");
        nameDpm = input.nextLine();

    }

    public String getIdDpm() {
        return idDpm;
    }

    public void setIdDpm(String idDpm) {
        this.idDpm = idDpm;
    }

    public String getNameDpm() {
        return nameDpm;
    }

    public void setNameDpm(String nameDpm) {
        this.nameDpm = nameDpm;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }
}
