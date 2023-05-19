package com.sameeragrawal.springreactbasics;

import com.sameeragrawal.springreactbasics.model.Employee;
import com.sameeragrawal.springreactbasics.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactBasicsApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactBasicsApplication.class, args);
	}


//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	@Override
//	public void run(String... args) throws Exception{
//		Employee employee =  new Employee();
//		employee.setFirstName("Sameer");
//		employee.setLastName("Agrawal");
//		employee.setEmailId("sameer02112@gmail.com");
//		employeeRepository.save(employee);
//	}

}
