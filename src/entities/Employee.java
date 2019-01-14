package entities;

public class Employee {

	private String name;
	private int id;
	private double salary;
	
	public Employee (String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public void increaseSalary(double percentage) {
		this.salary += salary * percentage / 100;
	}
	
	public String toString () {
		return "\nEmployee ID: " + id + "\nName: " + name + "\nSalary: " + salary + "\n";
	}

}
