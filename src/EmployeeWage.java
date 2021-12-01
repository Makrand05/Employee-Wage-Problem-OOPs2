public class EmployeeWage {

    int status;
    int RATE_PER_HOUR = 20;
    int DAY_HOURS = 8;
    int wage = 0;
    int PART_TIME = 2;
    int FULL_TIME = 1;
    int empHours = 0;

    //Check whether the employee is present or not
    private void checkStatus() {

        this.status = ((int) (Math.random() * 10) % 3);
        if (status == FULL_TIME) {
            //System.out.println("Employee is present");
            empHours = DAY_HOURS;
        } else if (status == PART_TIME)
            //System.out.println("Employee is absent");
            empHours = 4;
        else
            empHours = 0;
    }

    public static void main(String[] args) {

        EmployeeWage employeeWage = new EmployeeWage();
        employeeWage.checkStatus();
        employeeWage.calculateDailyWage();


    }

    //Calculated Employ wage
    private void calculateDailyWage() {
        wage = empHours * RATE_PER_HOUR;
        System.out.println("Total Wage of Employee is : " + wage);
    }


}
