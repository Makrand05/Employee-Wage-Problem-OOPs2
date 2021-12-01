public class EmployeeWage {

    int status;
    int RATE_PER_HOUR = 20;
    int DAY_HOURS = 8;
    int wage = 0;
    final int PART_TIME = 2;
    final int FULL_TIME = 1;
    int empHours = 0;

    //Check whether the employee is present or not
    private void checkStatus() {

        this.status = ((int) (Math.random() * 10) % 3);
        switch (status) {
            case FULL_TIME:
                empHours = 8;
                break;
            case PART_TIME:
                empHours = 4;
                break;
            default:
                empHours = 0;
        }
    }

    //Calculated Employ wage
    private void calculateDailyWage() {
        wage = empHours * RATE_PER_HOUR;
        System.out.println("Total Wage of Employee is : " + wage);
    }

    public static void main(String[] args) {

        EmployeeWage employeeWage = new EmployeeWage();
        employeeWage.checkStatus();
        employeeWage.calculateDailyWage();


    }


}
