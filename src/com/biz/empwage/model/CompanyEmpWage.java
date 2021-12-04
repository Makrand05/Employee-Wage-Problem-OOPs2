package com.biz.empwage.model;

import java.util.Arrays;

public class CompanyEmpWage {
    String compName;
    public int RATE_PER_HOUR;
    public int MAX_WORKING_HOURS;
    public int workingDayInMonth;
   public int monthlyEmpWage;

    public int empDailyWage[];

    public CompanyEmpWage(String compName, int RATE_PER_HOUR, int MAX_WORKING_HOURS, int workingDayInMonth) {
        this.compName = compName;
        this.RATE_PER_HOUR = RATE_PER_HOUR;
        this.MAX_WORKING_HOURS = MAX_WORKING_HOURS;
        this.workingDayInMonth = workingDayInMonth;
        this.empDailyWage = new int[workingDayInMonth];

    }

    @Override
    public String toString() {
        return "CompanyEmpWage{" +
                "compName='" + compName + '\'' +
                ", RATE_PER_HOUR=" + RATE_PER_HOUR +
                ", MAX_WORKING_HOURS=" + MAX_WORKING_HOURS +
                ", workingDayInMonth=" + workingDayInMonth +
                ", monthlyEmpWage=" + monthlyEmpWage +
                ", empDailyWage=" + Arrays.toString(empDailyWage) +
                '}';
    }
}