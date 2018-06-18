package com.edu.vn;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static List<String> listTask = new ArrayList<>();

	public static void main(String[] args) {
		
		Worker worker1 = new Worker("quan");
		Worker worker2 = new Worker("nghia");
		Worker worker3 = new Worker("vinh");
		Manager manager = new Manager("Trang");
		Manager manager2 = new Manager("Trang");
		Manager manager3 = new Manager("Trang");
		Manager manager4 = new Manager("Trang");
		worker1.start();
		worker2.start();
		manager.start();
		worker3.start();
		manager2.start();
		manager3.start();
		manager4.start();
		
	}
}
