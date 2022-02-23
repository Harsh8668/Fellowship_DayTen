package com.javaproject.dayten.employeewage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class employeeWageUC implements IComputeEmpWage {
    public static final int is_Full_Time = 1;
    public static final int is_Part_Time = 2;

    private int numOfCompany = 0;
    private LinkedList<CompanyEmpWage> companyEmpWageList;
    private Map<String, CompanyEmpWage> companyToEmpWageMap;

    public static void main(String[] args) {
        IComputeEmpWage empWage = new employeeWageUC();
        empWage.addCompanyEmpWage("TCS",20,20,50);
        empWage.addCompanyEmpWage("BRIDGELABZ",20,24,50);
        empWage.ComputeEmpWage();
    }

    public employeeWageUC() {
        this.companyEmpWageList = new LinkedList<>();
        this.companyToEmpWageMap = new HashMap<>();
    }

    @Override
    public void addCompanyEmpWage(String companyName, int emp_Rate_Per_Hrs, int num_Of_Working_Days, int maxHrs) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(companyName,emp_Rate_Per_Hrs, num_Of_Working_Days, maxHrs);
        companyEmpWageList.add(companyEmpWage);
        companyToEmpWageMap.put(companyName, companyEmpWage);
    }

    @Override
    public void ComputeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalWage(this.ComputeEmpWage(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }
    @Override
    public int getTotalWage(String companyName) {
        return companyToEmpWageMap.get(companyName).totalWage;
    }
    public int ComputeEmpWage(CompanyEmpWage companyEmpWage){
        int total_Working_Days = 0;
        int total_Emp_Hrs = 0;
        int emp_Hrs = 0;

        while(total_Emp_Hrs < companyEmpWage.maxHrs &&
                total_Working_Days < companyEmpWage.num_Of_Working_Days){
            total_Working_Days++;
            double emp_Check = Math.floor(Math.random() * 10) % 3;
            if(emp_Check == is_Full_Time){
                System.out.println("Employee is an Full Time Employee");
                emp_Hrs = 8;
            }
            else if(emp_Check == is_Part_Time){
                System.out.println("Employee is an Part Time Employee");
                emp_Hrs = 4;
            }
            else{
                System.out.println("Employee is Absent");
                emp_Hrs = 0;
            }
            total_Emp_Hrs = total_Emp_Hrs + emp_Hrs;
            System.out.println("Total Employee Hours is " +total_Emp_Hrs);
        }
        return total_Emp_Hrs * companyEmpWage.emp_Rate_Per_Hrs;
    }
}
