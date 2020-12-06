package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkersLevel;

public class Worker {
	//atributos basicos//
private String name;
private WorkersLevel level;
private Double baseSalary;
    //associacoes//
private Department department;
private List <HourContract> contracts= new ArrayList<HourContract>();//se usa quando tem muitos//

  //public// 
    public Worker() {
    }
    public Worker(String name, WorkersLevel level, Double baseSalary, Department department) {
    	this.name = name;
    	this.level = level;
    	this.baseSalary = baseSalary;
    	this.department = department;
    }
    
    //getersseters//
    public String getName() {
		return name;
	}
    public void setName(String name) {
	  this.name = name;
    }
	public WorkersLevel getLevel() {
	  return level;
    }
   public void setLevel(WorkersLevel level) {
	  this.level = level;
   }
   public Double getBaseSalary() {
	  return baseSalary;
   }
   public void setBaseSalary(Double baseSalary) {
	  this.baseSalary = baseSalary;
   }
   public Department getDepartment() {
	  return department;
   }
   public void setDepartment(Department department) {
	  this.department = department;
   }
   public List<HourContract> getContracts() {
	  return contracts;
   }
   //metodos resp por fazer ou desfazer os contratos//
   public void addContract(HourContract contract) {
	   contracts.add(contract);
   }
   public void removeContract(HourContract contract) {
	   contracts.remove(contract);
   }
   
   public double income(int year, int month) {
	   double sum=baseSalary;
	   Calendar cal= Calendar.getInstance();
	   for(HourContract c: contracts) {
			   cal.setTime(c.getDate());
				int c_year = cal.get(Calendar.YEAR);
				int c_month = 1 + cal.get(Calendar.MONTH);
				if (year == c_year && month == c_month) {
					sum += c.totalValue();
					
		   }
	   }
	   return sum;
   }

}














