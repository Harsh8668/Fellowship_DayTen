package com.javaproject.dayten.employeewage;

public interface IComputeEmpWage {
    public void addCompanyEmpWage(String companyName, int emp_Rate_Per_Hrs,
                                  int num_Of_Working_Days, int maxHrs);
    public void ComputeEmpWage();
    public int getTotalWage(String companyName);
}

