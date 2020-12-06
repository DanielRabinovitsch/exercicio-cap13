package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkersLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc= new Scanner(System.in);
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department's name: ");
		String departmentName= sc.nextLine();
		//worker data//
		System.out.println("Enter the worker data: ");
		System.out.print("Name: ");
		String workerName=sc.nextLine();
		System.out.print("Level: ");
		String workerLevel=sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkersLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int n=sc.nextInt();
		for(int i=1; i<=n;i++) {
			System.out.println("Enter contract number #" + i+ " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractdate= sdf.parse(sc.next());
			System.out.print("Value per hour:"); 
			double valuePerHour=sc.nextDouble();
			System.out.println("Duration (hours):");
			int hours=sc.nextInt();
			HourContract contract=new HourContract(contractdate, valuePerHour, hours);
			worker.addContract(contract);
		}
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear= sc.next();
		int month=Integer.parseInt(monthAndYear.substring(0, 2));
		int year=Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: "+ worker.getName());		
		System.out.println("Department:"+ worker.getDepartment().getName());		
		System.out.println("Income for: "+ monthAndYear+": "+String.format("%.2f", worker.income(year, month)));		
		
		
		sc.close();

	}

}
