package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("\n=== TEST 1: Department Insert ===");
		Department department = new Department(null, "D2");
		departmentDao.insert(department);
		System.out.println("Inserted! New id = " + department.getId());

		System.out.println("\n=== TEST 2: Department Update ===");
		department = departmentDao.findById(6);
		department.setName("D1");
		departmentDao.update(department);
		System.out.println("Update completed!");

		System.out.println("\n=== TEST 3: Department Delete ===");
		System.out.print("Enter ID for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);

		System.out.println("\n=== TEST 4: Department findById ===");
		System.out.print("Enter ID for find test: ");
		id = sc.nextInt();
		department = departmentDao.findById(id);
		System.out.println(department);

		System.out.println("\n=== TEST 5: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		sc.close();
	}

}
