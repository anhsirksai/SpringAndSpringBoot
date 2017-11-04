package com.sai;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sai.dao.CustomerRepository;
import com.sai.model.Customer;

@Component
public class ClientDriver {

	@Autowired
	DataSource dataSource;

	@Autowired
	CustomerRepository customerRepository;

	public void readConsole() {
	// TODO Auto-generated method stub
			System.out.println("DataSSource : " + dataSource);
			
			String name, email;
			int choice = 0;
			do {
				
				Scanner s = new Scanner(System.in);
				System.out.println("------------------------------------------");
				System.out.println("Hello There!!! Select choice!!!");
				System.out.println("1. Check Seats Available");
				System.out.println("2. Book Seats");
				System.out.println("3. Exit");
				System.out.print("Enter Choice: ");
				
				try {
					choice = s.nextInt();
					switch(choice) {
					case 1:
						System.out.println("enter name and email of customer");						
						name = s.next();email = s.next();
						System.out.println("Adding customer...");
						customerRepository.addCustomer(name, email);
						break;
					case 2:
						System.out.println("Display all customers...");
						List<Customer> list = customerRepository.findAll();
						list.forEach(x -> System.out.println(x));
						break;
					case 3:
						System.out.println("Thank You for using our service. Bye!");
						s.close();
						break;
					default:
						System.out.println("Enter correct choice!!");
						break;
					}				
				} catch (InputMismatchException e) {
					System.out.println("Enter a valid number.");	
			}
			}while (choice != 3);
	}

}

/*
 * if (args.length <= 0) {
 * System.err.println("[Usage] java xxx.jar {insert name email | display}"); }
 * else { if (args[0].equalsIgnoreCase("insert")) {
 * System.out.println("Add customer..."); String name = args[1]; String email =
 * args[2]; customerRepository.addCustomer(name, email); } if
 * (args[0].equalsIgnoreCase("display")) {
 * System.out.println("Display all customers..."); List<Customer> list =
 * customerRepository.findAll(); list.forEach(x -> System.out.println(x)); }
 * System.out.println("Done!"); } } }
 */