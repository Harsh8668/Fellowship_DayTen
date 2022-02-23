package com.javaproject.dayten.employeeWageUC10;

public class EmployeeWageUC10 {
    public static final int is_Full_Time = 1;
    public static final int is_Part_Time = 2;

    private int numOfCompany = 0;
    private CompanyEmpWage[] companyEmpWagesArr;

    public EmployeeWageUC10() {
        companyEmpWagesArr = new CompanyEmpWage[6];
    }

    private void addCompanyEmpWage(String companyName, int emp_Rate_Per_Hrs,
                                   int num_Of_Working_Days, int maxHrs){
        companyEmpWagesArr[numOfCompany] = new CompanyEmpWage(companyName, emp_Rate_Per_Hrs,
                                                num_Of_Working_Days, maxHrs);
        numOfCompany++;
    }

    private void ComputeEmpWage(){
        for (int i = 0; i < numOfCompany; i++) {
            companyEmpWagesArr[i].setTotalWage(this.ComputeEmpWage(companyEmpWagesArr[i]));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EmployeeWageUC10 employeeWageUC10 = new EmployeeWageUC10();
        employeeWageUC10.addCompanyEmpWage("TCS", 20,
                20,50);
        employeeWageUC10.addCompanyEmpWage("BRIDGELABZ", 20,
                24,50);
        employeeWageUC10.ComputeEmpWage();
    }
    public int ComputeEmpWage(CompanyEmpWage companyEmpWage){
        int total_Working_Days = 0;
        int total_Employee_Wage = 0;
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
//        System.out.println("Total Salary of an Employee is " + total_Employee_Wage+"\n");
    }
}