package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {

		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== Teste Department findById ===");
		Department dep = depDao.findById(2);
		System.out.println(dep);
		
		System.out.println("\n=== Teste 2 Department findAll ===");
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== Teste 3 Department findAll ===");
		Department newDep = new Department(null, "Guitarras");
		depDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 5: seller update===");
		dep = depDao.findById(1);
		dep.setName("Puteiro");
		depDao.update(dep);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: seller delete===");
		System.out.printf("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
