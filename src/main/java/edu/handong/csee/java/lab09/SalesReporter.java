package edu.handong.csee.java.lab09;

import java.util.Scanner;
/**
 * This class implements a sales report. This class gains information about sales assoicates and
 * checks who has the highest sales and obtain the average sales
 * @author qpalzmm22
 *
 */
public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	private int numberOfAssociate; 

	/**
	 * This method ask how many info about sales associate the user is going to get and
	 * then, it gets data from user
	 */
	public void getData() {
		
		System.out.println("Enter number of sales associates:");
		Scanner keyboard = new Scanner(System.in);
		numberOfAssociate  = keyboard.nextInt();
		team = new SalesAssociate[numberOfAssociate];
		
		for(int i = 0; i < numberOfAssociate; i++ ) {
			team[i] = new SalesAssociate();
			System.out.println("Enter data for associate number " + (i+1));
			System.out.print("Enter name of sales associate: ");
			team[i].setName(keyboard.next());
			System.out.print("Enter associate's sales: ");
			team[i].setSales(keyboard.nextInt());
		}
		
		keyboard.close();
	}
	/**
	 * This method finds average sales and highest sales from the sales associates
	 */
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
	/**
	 * this method displays the result.
	 * first it prints the result of average and highest sales, then print out who has the highest sales
	 * And then,it prints rest
	 */
	public void displayResults() {
		
		System.out.println("\nAverage sales per associate is $" + averageSales);
		System.out.println("The highest sales figure is $" + highestSales);
		
		System.out.println("The following had the highest sales:");
		
		for(int i = 0; i < numberOfAssociate; i++) {
			if(highestSales == team[i].getSales()) {
				displayAssociateInfo(team[i]);
			}
		}
		
		System.out.println("The rest performed as follows:");
		
		for(int i = 0; i < numberOfAssociate; i++) {
			if(highestSales != team[i].getSales()) {
				displayAssociateInfo(team[i]);
			}
		}
		
	}
	/**
	 * This method prints given associate's info. it prints name and sales of the given associate
	 * @param associate Sales associate 
	 */
	private void displayAssociateInfo(SalesAssociate associate) {
		System.out.println("Name: " + associate.getName());
		System.out.println("Sales: " + associate.getSales());
		printCompAverage(associate);
	}
	/**
	 * This method prints the difference in sales and average sales.
	 * @param associate Sales associate
	 */
	private void printCompAverage(SalesAssociate associate) {
		double diff = averageSales - associate.getSales(); 
		if(diff > 0) 
			System.out.println("$" + diff + " below the average.");

		if(diff < 0)
			System.out.println("$" + -1*diff + " above the average.");
		
		if(diff == 0)
			System.out.println("Sales is average");
	}
	
	/**
	 * This main method instantiate SalesReporter to get data, 
	 * compute the average and highest sales, and display the result 
	 * @param args no command arguments are given
	 */
	public static void main(String[] args) {
		SalesReporter report = new SalesReporter();
		
		report.getData();
		report.computeStats();
		report.displayResults();
	}

}
