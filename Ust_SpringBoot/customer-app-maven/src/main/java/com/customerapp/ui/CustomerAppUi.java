package com.customerapp.ui;
import java.util.Scanner;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 
import com.customerapp.model.Customer;
import com.customerapp.service.CustomerService;
import com.customerapp.service.CustomerServiceImpl;
 

public class CustomerAppUi {

    static Scanner scan;

    static CustomerService service;
 
    public static void addCustomer() {
 
        System.out.println("Enter customer details : ");
        System.out.print("ID : ");
        int id = scan.nextInt();
        System.out.print("Name : ");
        String name = scan.next() + scan.nextLine();
        System.out.print("Email : ");
        String email = scan.next() + scan.nextLine();
 
        Customer c = new Customer(name, id, email);
        service.addCustomer(c);
        System.out.println("Customer added");
 
    }
 
    public static void searchCustomer() {
        System.out.println("Enter an id ");
        int id=scan.nextInt();
        System.out.println(service.getCustomerById(id));
 
    }
 
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        scan=context.getBean(Scanner.class);
        service=context.getBean(CustomerServiceImpl.class);
        while (true) {
            System.out.println("Enter your choice : ");
            System.out.println("1 : Add Customer");
            System.out.println("2 : Search Customer");
            System.out.println("0 : Exit");
            int choice = scan.nextInt();
            switch (choice) {
            case 1:
                addCustomer();
                break;
            case 2:
                searchCustomer();
                break;
            case 0:
                System.out.println("Bye.....");
                System.exit(1);
                break;
            default:
                System.out.println("Unexpected value: " + choice);
                break;
            }
        }
 
    }
 
}
