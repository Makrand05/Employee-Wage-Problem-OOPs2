import org.openqa.selenium.json.JsonOutput;

import java.util.Scanner;

public class EmployeeWage {

    int status;
    int RATE_PER_HOUR;
    int MAX_WORKING_HOURS;
    final int PART_TIME = 2;
    final int FULL_TIME = 1;
    int empHours = 0;
    int totalMonthlyWage = 0;
    int workingDayInMonth;
    int totalWorkingHours = 0;
    EmployeeWage(int workingRate, int workingHoursInMonth, int workingDayInMonth){
    this.RATE_PER_HOUR=workingRate;
    this.MAX_WORKING_HOURS=workingHoursInMonth;
    this.workingDayInMonth=workingDayInMonth;
    }
    //Check whether the employee is present or not
    private int checkStatus() {
        this.status = ((int) (Math.random() * 10) % 3);
        switch (status) {
            case FULL_TIME:
                empHours = 8;
                totalWorkingHours += 8;
                break;
            case PART_TIME:
                empHours = 4;
                totalWorkingHours += 4;
                break;
            default:
                empHours = 0;
        }
        return empHours;
    }
    //Calculated Employ wage
    private int calculateDailyWage() { return (empHours * RATE_PER_HOUR);   }

    private void wageForMonth() {
        int day=0;
        while (day<workingDayInMonth && totalWorkingHours<MAX_WORKING_HOURS) {
            if(checkStatus()>0){
            totalMonthlyWage += calculateDailyWage();}
            day++;
        }
        System.out.println("Total working day in month : "+day);
    }

    private void printOutput() {
        System.out.println("Total Working Hours in month is : " + totalWorkingHours);
        System.out.println("Total employee wage in month : " + totalMonthlyWage);
    }

    public static void main(String[] args) {
        //for the working hour rate 20, working hour in month- 100 working hour in month 20
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Working day in month : ");
        int workingDayInMonth=sc.nextInt();
        System.out.print("Enter the Hours day in month : ");
        int workingHoursInmonth=sc.nextInt();
        System.out.print("Enter the rate per hours: ");
        int ratePerHours=sc.nextInt();
        EmployeeWage employeeWage = new EmployeeWage(ratePerHours,workingHoursInmonth,workingDayInMonth);
        employeeWage.calculateDailyWage();
        employeeWage.wageForMonth();
        employeeWage.printOutput();
    }
}
