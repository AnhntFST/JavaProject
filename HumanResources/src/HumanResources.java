import java.util.*;

public class HumanResources {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choose;

        //ArrayList chua thong tin cac bo phan cty
        ArrayList<Department> departmentList = new ArrayList<>();
        Department hanhChinh = new Department("HC", "Hanh chinh nhan su", 0);
        Department congngheTT = new Department("IT", "Cong nghe thong tin", 0);
        Department marketing = new Department("MKT", "Marketing", 0);
        departmentList.add(hanhChinh);
        departmentList.add(congngheTT);
        departmentList.add(marketing);

      //ArrayList chua thong tin toan bo nhan vien cty
        ArrayList<Staff> staffList = new ArrayList<>();

        do {
            showMenu();
            choose = Integer.parseInt(input.nextLine());
            switch (choose){
                case 1:
                    //Hien thi danh sach nhan vien hien co trong cong ty
                    System.out.println();
                    System.out.format("%-12s%-2c%-18s%-2c%-6s%-2c%-10s%-2c%-15s%-2c%-18s%-2c%-20s%-2c%-25s%-2c%-10s\n","Ma nhan vien",'|',"Ten nhan vien",'|',"Tuoi",'|',"HS luong",'|',"Ngay vao lam",'|',"Ngay nghi phep",'|',"Bo phan",'|',"So gio lam them/chuc vu",'|',"Luong");
                    System.out.println("-".repeat(145));
                    staffList.forEach(staff -> staff.displayInformation());
                    System.out.println();
                    break;
                case 2:
                    // Hien thi cac bo phan trong cty
                    System.out.println();
                    System.out.format("%-20s%-2c%-30s%-2c%-15s\n", "Ma bo phan",'|',"Ten bo phan",'|',"So luong nhan vien hien tai");
                    System.out.println("-".repeat(80));
                    departmentList.forEach(department -> department.display());
                    System.out.println();
                    break;
                case 3:
                    // Hien thi danh sach nhan vien theo tung bo phan
                    System.out.println();
                    for (int i = 0; i < departmentList.size(); i++){
                        // In ra ten cua bo phan
                        System.out.println(departmentList.get(i).getNameDpm());
                        System.out.println("-".repeat(50));
                        System.out.format("%-12s%-2c%-18s%-2c%-6s%-2c%-10s%-2c%-15s%-2c%-18s%-2c%-20s%-2c%-25s%-2c%-10s\n","Ma nhan vien",'|',"Ten nhan vien",'|',"Tuoi",'|',"HS luong",'|',"Ngay vao lam",'|',"Ngay nghi phep",'|',"Bo phan",'|',"So gio lam them/chuc vu",'|',"Luong");

                        // In ra danh sach nhan vien cua bo phan
                        for (int j = 0; j < staffList.size(); j++) {
                            if (staffList.get(j).getDepartment().equalsIgnoreCase(departmentList.get(i).getNameDpm())){
                                staffList.get(j).displayInformation();
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    // Them moi danh sach nhan vien
                    System.out.println();
                    addStaff(staffList, departmentList);
                    break;
                case 5:
                    // Tim kiem thong tin theo ten hoac theo ma nhan vien
                    System.out.println();
                    System.out.println("1. Tim nhan vien bang ten");
                    System.out.println("2. Tim nhan vien bang ma nhan vien");
                    System.out.print("Ban chon: ");
                    choose = Integer.parseInt(input.nextLine());
                    switch (choose){
                        case 1:
                            searchByName(staffList);
                            break;
                        default:
                        searchById(staffList);
                        break;
                    }
                    break;
                case 6:
                    // Hien thi bang luong cua toan bo nhan vien cong ty
                    System.out.println();
                    System.out.format("%-12s%-2c%-18s%-2c%-6s%-2c%-10s%-2c%-15s%-2c%-18s%-2c%-20s%-2c%-25s%-2c%-10s\n","Ma nhan vien",'|',"Ten nhan vien",'|',"Tuoi",'|',"HS luong",'|',"Ngay vao lam",'|',"Ngay nghi phep",'|',"Bo phan",'|',"So gio lam them/chuc vu",'|',"Luong");
                    staffList.forEach(staff -> staff.displayInformation());
                    System.out.println();
                    break;
                case 7:
                    // Hien thi bang luong cua nhan vien theo thu tu tang dan
                    System.out.println();
                    System.out.println("1. Sap xep luong tang dan");
                    System.out.println("2. Sap xep luong giam dan");
                    System.out.println("Ban chon: ");
                    choose = Integer.parseInt(input.nextLine());
                    switch (choose){
                        case 1:
                            displayAscending(staffList);
                            break;
                        default:
                            displayDecrease(staffList);
                            break;
                    }
                     break;
                case 0:
                    System.out.println("Good bye and See you again!!!");
                    break;
                default:
                    System.err.println("Ban nhap sai");
                    break;
            }

        }while (choose != 0);

    }


    // Method them nhan vien
    static void addStaff(ArrayList<Staff> staffList, ArrayList<Department> departmentList) {
        Staff staff = createStaff(departmentList);
        staffList.add(staff);
    }

    static Staff createStaff(ArrayList<Department> departmentList) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Them nhan vien thong thuong");
        System.out.println("2. Them nhan vien la cap quan ly (co them chuc vu)");
        System.out.print("Ban chon: ");
        int choose = Integer.parseInt(input.nextLine());
        Staff staff = null;
        switch (choose){
            case 1:
                staff = new Employee();
                break;
            case 2:
                staff = new Manager();
                break;
        }
        staff.input(departmentList);
        return staff;
    }

    // Ham hien thi danh sach chuc nang
    static void showMenu(){
        System.out.println("1. Hien thi danh sach nhan vien hien co trong cong ty");
        System.out.println("2. Hien thi cac bo phan trong cong ty");
        System.out.println("3. Hien thi cac nhan vien theo tung bo phan");
        System.out.println("4. Them nhan vien moi vao cong ty");
        System.out.println("5. Tim kiem thong tin nhan vien theo ten hoac theo ma nhan vien");
        System.out.println("6. Hien thi bang luong cua nhan vien toan cong ty");
        System.out.println("7. Hien thi bang luong cua nhan vien theo thu tu tang dan hoac giam dan");
        System.out.println("0. Thoat chuong trinh");
        System.out.print("Lua chon cua ban: ");
    }

    // Ham tim kiem nhan vien theo ten nhan vien
    static void searchByName(ArrayList<Staff> staffList){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ten nhan vien can tim: ");
        String name = input.nextLine();
        System.out.println();
        boolean isFind = false;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getName().contains(name)){
                System.out.format("%-12s%-2c%-18s%-2c%-6s%-2c%-10s%-2c%-15s%-2c%-18s%-2c%-20s%-2c%-25s%-2c%-10s\n","Ma nhan vien",'|',"Ten nhan vien",'|',"Tuoi",'|',"HS luong",'|',"Ngay vao lam",'|',"Ngay nghi phep",'|',"Bo phan",'|',"So gio lam them/chuc vu",'|',"Luong");
                staffList.get(i).displayInformation();
                isFind = true;
                break;
            }
        }
        if(!isFind) {
            System.out.println("Ten nhan vien dang tim khong co trong danh sach nhan vien");
            System.out.println();
        }
    }
    // Ham tim kiem nhan vien theo Ma nhan vien
    static void searchById(ArrayList<Staff> staffList){
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can tim: ");
        String idsearch = input.nextLine();
        boolean isFind = false;
        System.out.println();
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getId().equalsIgnoreCase(idsearch)){
                System.out.format("%-12s%-2c%-18s%-2c%-6s%-2c%-10s%-2c%-15s%-2c%-18s%-2c%-20s%-2c%-25s%-2c%-10s\n","Ma nhan vien",'|',"Ten nhan vien",'|',"Tuoi",'|',"HS luong",'|',"Ngay vao lam",'|',"Ngay nghi phep",'|',"Bo phan",'|',"So gio lam them/chuc vu",'|',"Luong");
                staffList.get(i).displayInformation();
                isFind = true;
                break;
            }
        }
        if(!isFind) {
            System.out.println("Ma nhan vien dang tim khong co trong danh sach nhan vien");
            System.out.println();
        }
    }
    // Ham sap xep luong nhan vien tu tang dan
    static void displayAscending(ArrayList<Staff> staffList){
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getSalary() >= o2.getSalary() ? 1 : -1;
            }
        });
        System.out.format("%-12s%-2c%-18s%-2c%-6s%-2c%-10s%-2c%-15s%-2c%-18s%-2c%-20s%-2c%-25s%-2c%-10s\n","Ma nhan vien",'|',"Ten nhan vien",'|',"Tuoi",'|',"HS luong",'|',"Ngay vao lam",'|',"Ngay nghi phep",'|',"Bo phan",'|',"So gio lam them/chuc vu",'|',"Luong");
        for (int i = 0; i < staffList.size(); i++) {
            staffList.get(i).displayInformation();
        }

    }
    // Ham sap xep luong nhan vien tu giam dan
    static void displayDecrease(ArrayList<Staff> staffList){
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return o1.getSalary() >= o2.getSalary() ? -1 : 1;
            }
        });
        System.out.format("%-12s%-2c%-18s%-2c%-6s%-2c%-10s%-2c%-15s%-2c%-18s%-2c%-20s%-2c%-25s%-2c%-10s\n","Ma nhan vien",'|',"Ten nhan vien",'|',"Tuoi",'|',"HS luong",'|',"Ngay vao lam",'|',"Ngay nghi phep",'|',"Bo phan",'|',"So gio lam them/chuc vu",'|',"Luong");
        for (int i = 0; i < staffList.size(); i++) {
            staffList.get(i).displayInformation();
        }

    }
}
