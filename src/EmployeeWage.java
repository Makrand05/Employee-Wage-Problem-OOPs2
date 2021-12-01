public class EmployeeWage {

    int status;
    int RATE_PER_HOUR = 20;
    int DAY_HOURS = 8;
    int wage = 0;

    private void checkStatus() {

        this.status = ((int) (Math.random() * 10) % 2);
        if (status == 1) {
            System.out.println("Employee is present");
        } else
            System.out.println("Employee is absent");
    }

    public static void main(String[] args) {

        EmployeeWage employeeWage = new EmployeeWage();
        employeeWage.checkStatus();
        employeeWage.calculateDailyWage();


    }

    private void calculateDailyWage() {
        if(status==1){
            wage=DAY_HOURS*RATE_PER_HOUR;
        }
        else
            wage=0;
        System.out.println("Total Wage of Employee is : "+wage);
    }


}
