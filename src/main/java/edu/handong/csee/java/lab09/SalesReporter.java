package edu.handong.csee.java.lab09;

import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	private int numberOfAssociate; 
	
	public void getData() {
		
		System.out.println("Enter number of sales associates:");
		Scanner keyboard = new Scanner(System.in);
		numberOfAssociate  = keyboard.nextInt();
		team = new SalesAssociate[numberOfAssociate];
		
		for(int i = 0; i < numberOfAssociate; i++ ) {
			team[i] = new SalesAssociate();
			System.out.println("Enter data for associate number " + (i+1));
			System.out.print("Enter name of sales associate");
			team[i].setName(keyboard.next());
			System.out.println("Enter associate's sales: ");
			team[i].setSales(keyboard.nextInt());
		}
		
		keyboard.close();
	}
	
	public void computeStats() {
		double sum = 0;
		highestSales = team[0].getSales();
		
		for(int i = 0; i < numberOfAssociate; i++) {
			sum += team[i].getSales();
			if(highestSales < team[i].getSales())
				highestSales = team[i].getSales();
		}
		
		averageSales = sum / numberOfAssociate;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
