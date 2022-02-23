package com.javaproject.dayten.employeeWageUC9;

public class EmployeeWageUC9 {
    static final int is_Full_Time = 1;
    static final int is_Part_Time = 2;

    private final String companyName;
    private final int emp_Rate_Per_Hr;
    private final int num_Of_Working_Days;
    private final int maxHrs;
    private int totalWage;

    public EmployeeWageUC9(String companyName, int emp_Rate_Per_Hr,
                           int num_Of_Working_Days, int maxHrs) {
        this.companyName = companyName;
        this.emp_Rate_Per_Hr = emp_Rate_Per_Hr;
        this.num_Of_Working_Days = num_Of_Working_Days;
        this.maxHrs = maxHrs;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program\n");
        EmployeeWageUC9 tcs = new EmployeeWageUC9("TCS", 20,
                20, 50);
        EmployeeWageUC9 bridgelabz = new EmployeeWageUC9("BRIDGELABZ", 20,
                24,50);
        tcs.employeeWage();
        System.out.println(tcs+"\n");
        bridgelabz.employeeWage();
        System.out.println(bridgelabz);
    }

    public void employeeWage(){
        int total_Working_Days = 0;
        int total_Employee_Wage = 0;
        int total_Emp_Hrs = 0;
        int emp_Hrs = 0;

        while(total_Emp_Hrs < maxHrs && total_Working_Days < num_Of_Working_Days){
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
        total_Employee_Wage = total_Emp_Hrs * emp_Rate_Per_Hr;
        System.out.println("Total Salary of an Employee is " + total_Employee_Wage+"\n");
        totalWage = total_Employee_Wage;
    }

    @Override
    public String toString() {
        return "{" +
                "companyName='" + companyName + '\'' +
                ", emp_Rate_Per_Hr=" + emp_Rate_Per_Hr +
                ", num_Of_Working_Days=" + num_Of_Working_Days +
                ", maxHrs=" + maxHrs +
                ", totalWage=" + totalWage +
                '}';
    }
}