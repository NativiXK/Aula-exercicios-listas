package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Employee> employee = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int amount = sc.nextInt();

		for (int i = 0; i < amount; i++) {

			System.out.println("\nEmployee #" + (i + 1));
			System.out.print("Name : ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("ID : ");
			int id = sc.nextInt();

			for (Employee emp : employee) {
				if (emp.getId() == id) {
					System.out.println("Repeated ID, please insert again!");
					System.out.print("ID : ");
					id = sc.nextInt();
				}
			}

			System.out.print("Salary : ");
			double salary = sc.nextDouble();
			employee.add(new Employee(name, id, salary));

		}
		
		System.out.print("\nEnter the employee ID that will have salary increased: ");
		int id = sc.nextInt();
		Employee result = employee.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (result != null) {
			int index = employee.indexOf(result);
			System.out.print("Enter the porcentage: ");
			double percentage = sc.nextDouble();
			result.increaseSalary(percentage);
			employee.add(index, result);
			employee.remove(index + 1);			
		} else {
			System.out.println("This ID does not exist!");
		}
		
		for (Employee emp : employee) {
			System.out.println(emp.toString());
		}
		
		sc.close();
	}

}
