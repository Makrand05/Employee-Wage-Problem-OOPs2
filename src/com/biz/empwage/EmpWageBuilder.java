package com.biz.empwage;

public class EmpWageBuilder {

    int status;

    final int PART_TIME = 2;
    final int FULL_TIME = 1;
    int empHours = 0;
    int totalMonthlyWage = 0;
    int totalWorkingHours = 0;
    int totalEmployeeWage;
    CompanyEmpWage[] companyEmpArray = new CompanyEmpWage[5];
    int noOfCompany = 0;

    public static void main(String[] args) {
        //for the working hour rate 20, working hour in month- 100 working hour in month 20

        EmpWageBuilder empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompanyEmpWage("ABC", 20, 100, 20);
        empWageBuilder.addCompanyEmpWage("Apple", 25, 120, 25);
        empWageBuilder.empWageArray();
    }

    private void empWageArray() {
        for (int i = 0; i < noOfCompany; i++) {
            int totalWage = calculateDailyWage(companyEmpArray[i]);
            System.out.println(companyEmpArray[i]);
        }
    }

    private void addCompanyEmpWage(String companyName, int ratePerHrs, int totalHours, int daysPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, ratePerHrs, totalHours, daysPerMonth);
        companyEmpArray[noOfCompany++] = companyEmpWage;
    }

    //Check whether the employee is present or not


    //Calculated Employ wage
    private int calculateEmpWage(int RATE_PER_HOUR) {
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
        return (empHours * RATE_PER_HOUR);
    }

    private int calculateDailyWage(CompanyEmpWage companyEmpWage) {
        int day = 0;
        while (day < companyEmpWage.workingDayInMonth && totalWorkingHours < companyEmpWage.MAX_WORKING_HOURS) {
            totalMonthlyWage += calculateEmpWage(companyEmpWage.RATE_PER_HOUR);
            day++;
        }
        return totalMonthlyWage;
    }

}
