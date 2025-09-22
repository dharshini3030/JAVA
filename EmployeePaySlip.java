import java.util.Scanner;
class Employee {
    String empName, address, mailId;
    long empId, mobileNo;
    double basicPay, da, hra, pf, staffClub, grossSalary, netSalary;
  void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        empId = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        empName = sc.nextLine();
        System.out.print("Enter Address: ");
        address = sc.nextLine();
        System.out.print("Enter Mail ID: ");
        mailId = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        mobileNo = sc.nextLong();
        System.out.print("Enter Basic Pay: ");
        basicPay = sc.nextDouble();
    }
    void calculateSalary(double daPercent, double hraPercent, double pfPercent, double staffClubPercent) {
        da = (daPercent / 100) * basicPay;
        hra = (hraPercent / 100) * basicPay;
        pf = (pfPercent / 100) * basicPay;
        staffClub = (staffClubPercent / 100) * basicPay;
        grossSalary = basicPay + da + hra;
        netSalary = grossSalary - (pf + staffClub);
    }
    void displayPaySlip() {
        System.out.println("\n------ PAY SLIP ------");
        System.out.println("Employee ID : " + empId);
        System.out.println("Name : " + empName);
        System.out.println("Address : " + address);
        System.out.println("Mail ID : " + mailId);
        System.out.println("Mobile No. : " + mobileNo);
        System.out.println("Basic Pay : " + basicPay);
        System.out.println("DA : " + da);
        System.out.println("HRA : " + hra);
        System.out.println("PF : " + pf);
        System.out.println("Staff Club : " + staffClub);
        System.out.println("Gross Salary : " + grossSalary);
        System.out.println("Net Salary : " + netSalary);
        System.out.println("----------------------\n");
    }
}
class Programmer extends Employee {
    void process() {
        getDetails();
        calculateSalary(97, 10, 12, 1);
        displayPaySlip();
    }
}
class AssistantProfessor extends Employee {
    void process() {
        getDetails();
        calculateSalary(110, 20, 12, 5);
        displayPaySlip();
    }
}
class AssociateProfessor extends Employee {
    void process() {
        getDetails();
        calculateSalary(130, 30, 12, 10);
        displayPaySlip();
    }
}

class Professor extends Employee {
    void process() {
        getDetails();
        calculateSalary(140, 40, 12, 15);
        displayPaySlip();
    }
}
public class EmployeePaySlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Designation:");
        System.out.println("1. Programmer");
        System.out.println("2. Assistant Professor");
        System.out.println("3. Associate Professor");
        System.out.println("4. Professor");
        System.out.println("5.Driver");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        Employee emp;
        switch (choice) {
            case 1:
                emp = new Programmer();
                ((Programmer) emp).process();
                break;
            case 2:
                emp = new AssistantProfessor();
                ((AssistantProfessor) emp).process();
                break;
            case 3:
                emp = new AssociateProfessor();
                ((AssociateProfessor) emp).process();
                break;
            case 4:
                emp = new Professor();
                ((Professor) emp).process();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
