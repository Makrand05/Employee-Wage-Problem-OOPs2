package com.biz.empwage.service;
import com.biz.empwage.interface1.IEmployeeWage;
import com.biz.empwage.model.CompanyEmpWage;
import java.util.ArrayList;

public class EmpWageBuilder implements IEmployeeWage {

    int status;
    final int PART_TIME = 2;
    final int FULL_TIME = 1;
    int empHours = 0;
    int totalMonthlyWage = 0;
    int totalWorkingHours = 0;
    ArrayList<CompanyEmpWage> empCompanyArraylist = new ArrayList<>();


    public static void main(String[] args) {

        IEmployeeWage empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompanyEmpWage("ABC", 20, 100, 20);
        empWageBuilder.addCompanyEmpWage("Apple", 25, 120, 25);
        empWageBuilder.empWageArray();

    }
    public void empWageArray() {
        for (int i = 0; i < empCompanyArraylist.size(); i++) {
            CompanyEmpWage totalWage = calculateDailyWage(empCompanyArraylist.get(i));
            System.out.println(empCompanyArraylist.get(i));
        }
    }

    public void addCompanyEmpWage(String companyName, int ratePerHrs, int totalHours, int daysPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName, ratePerHrs, totalHours, daysPerMonth);
        empCompanyArraylist.add(companyEmpWage);
    }

    //Calculated Employ wage
    private CompanyEmpWage calculateDailyWage(CompanyEmpWage companyEmpWage) {
        int day = 0;
        int index = 0;
        int dayCounter = 0;
        while (day < companyEmpWage.workingDayInMonth && totalWorkingHours < companyEmpWage.MAX_WORKING_HOURS) {
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
            int empWage = empHours * companyEmpWage.RATE_PER_HOUR;
            companyEmpWage.empDailyWage[dayCounter++] = empWage;
            totalMonthlyWage += empWage;
            day++;
        }
        companyEmpWage.monthlyEmpWage=totalMonthlyWage;
        return companyEmpWage;
    }

}
