package com.javaproject.dayten.employeewage;

public class CompanyEmpWage {
    public final String companyName;
    public final int emp_Rate_Per_Hrs;
    public final int num_Of_Working_Days;
    public final int maxHrs;
    public int totalWage;

    public CompanyEmpWage(String companyName, int emp_Rate_Per_Hrs,
                          int num_Of_Working_Days, int maxHrs) {
        this.companyName = companyName;
        this.emp_Rate_Per_Hrs = emp_Rate_Per_Hrs;
        this.num_Of_Working_Days = num_Of_Working_Days;
        this.maxHrs = maxHrs;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "{" +
                "companyName='" + companyName + '\'' +
                ", emp_Rate_Per_Hrs=" + emp_Rate_Per_Hrs +
                ", num_Of_Working_Days=" + num_Of_Working_Days +
                ", maxHrs=" + maxHrs +
                ", totalWage=" + totalWage +
                '}';
    }
}
