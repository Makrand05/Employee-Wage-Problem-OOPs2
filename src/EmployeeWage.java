import org.openqa.selenium.json.JsonOutput;

public class EmployeeWage {

    int status;
    int RATE_PER_HOUR = 20;
    int MAX_WORKING_HOURS = 100;
    int wage = 0;
    final int PART_TIME = 2;
    final int FULL_TIME = 1;
    int empHours = 0;
    int totalMonthlyWage = 0;
    int workingDayInMonth = 20;
    int totalWorkingHours = 0;

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
        EmployeeWage employeeWage = new EmployeeWage();
        employeeWage.calculateDailyWage();
        employeeWage.wageForMonth();
        employeeWage.printOutput();
    }
}
