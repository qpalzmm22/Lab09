package edu.handong.csee.java.lab09; // makes it a package

import java.util.Scanner;	// import Scanner to use nextInt() and next()
/**
 * This class implements a sales report. This class gains information about sales assoicates and
 * checks who has the highest sales and obtain the average sales
 * @author qpalzmm22
 *
 */
public class SalesReporter {	// a class to get input from user, calculate highest sales and average and print the result
	private double highestSales;	// a variable to store highest sales
	private double averageSales;	// a variable to store average sales among sales man
	private SalesAssociate[] team;	// an array to store salesAssociates
	private int numberOfAssociate; 	// a variable to get input from user how many associate information if he or she is going to give

	/**
	 * This method ask how many info about sales associate the user is going to get and
	 * then, it gets data from user
	 */
	public void getData() {	// gets data from user
		
		System.out.println("Enter number of sales associates:");	//ask user form number of associates
		Scanner keyboard = new Scanner(System.in);	// instantiate scanner to use nextInt() and next()
		numberOfAssociate  = keyboard.nextInt(); // stores user's input in numberOfAssocaite
		team = new SalesAssociate[numberOfAssociate];	// create array that has length of numberOfAssociate
		
		for(int i = 0; i < numberOfAssociate; i++ ) { // Gets info as much as numberOfAssocaite 
			team[i] = new SalesAssociate();	// instantiate each SalesAssociate
			System.out.println("Enter data for associate number " + (i+1));	// ask user for data
			System.out.print("Enter name of sales associate: ");	// ask name of the sales associate
			team[i].setName(keyboard.next());						// sets the name of i-th sales associate by user-typed name
			System.out.print("Enter associate's sales: ");			// ask sales number of the sales associate
			team[i].setSales(keyboard.nextInt());					// sets the sales number of i-th sales associate by user-typed value
		}
		
		keyboard.close();		// close to prevent the leak
	}
	/**
	 * This method finds average sales and highest sales from the sales associates
	 */
	public void computeStats() {	// calculates the highest sales and average sales
		double sum = 0;				// counter variable for calculating average
		highestSales = team[0].getSales();	// sets default to team[0].getSales() to avoid possible range problem
		
		for(int i = 0; i < numberOfAssociate; i++) {	// continue as much as numberOfAssociate
			sum += team[i].getSales();					// add the sales and store it in sum
			if(highestSales < team[i].getSales())		// if the sales is bigger than highestSales
				highestSales = team[i].getSales();		// make that the highestSales
		}
		
		averageSales = sum / numberOfAssociate;			// divide the sum by number of associate to get the average 
	}
	/**
	 * this method displays the result.
	 * first it prints the result of average and highest sales, then print out who has the highest sales
	 * And then,it prints rest
	 */
	public void displayResults() {	// displays the result of computeStats()
		
		System.out.println("\nAverage sales per associate is $" + averageSales);	// print the result of average
		System.out.println("The highest sales figure is $" + highestSales);			// print the result of highest sales
		
		System.out.println("The following had the highest sales:");					// a statement
		
		for(int i = 0; i < numberOfAssociate; i++) {	// repeat as much as numberOfAssociate
			if(highestSales == team[i].getSales()) {	// if the highestSales number is same as the sales associates sales amount
				displayAssociateInfo(team[i]);			// then print the information of that associate
			}
		}
		
		System.out.println("The rest performed as follows:");	// a statement
		
		for(int i = 0; i < numberOfAssociate; i++) {	// repeat as much as numberOfAssociate
			if(highestSales != team[i].getSales()) {	// if the highestSales number is not same as the sales associates' sales number
				displayAssociateInfo(team[i]);			// then print the information of that associate
			}
		}
		
	}
	/**
	 * This method prints given associate's info. it prints name and sales of the given associate
	 * @param associate Sales associate 
	 */
	private void displayAssociateInfo(SalesAssociate associate) {	// a helper method for displayResults()
		System.out.println("Name: " + associate.getName());			// prints the name of the associate
		System.out.println("Sales: " + associate.getSales());		// prints the sales number of the associate
		printCompAverage(associate);								// calculate the difference between average and the sales and print the reult
	}
	/**
	 * This method prints the difference in sales and average sales.
	 * @param associate Sales associate
	 */
	private void printCompAverage(SalesAssociate associate) {		// a helper method for displayAssociateInfo() 
		double diff = averageSales - associate.getSales(); 			// calculate the difference between average and the sales 
		if(diff > 0) 												// if difference is positive( sales man has less sales than average)
			System.out.println("$" + diff + " below the average.");	// print the amount of difference and print that it's lower than average

		if(diff < 0)												// if difference is positive( sales man has less sales than average)
			System.out.println("$" + -1*diff + " above the average.");// print the amount of difference and print that it's higher than average
		
		if(diff == 0)												// if difference is 0( sales man has sales equals to average)
			System.out.println("Sales is average");					// print that the sales is same as average
	}
	
	/**
	 * This main method instantiate SalesReporter to get data, 
	 * compute the average and highest sales, and display the result 
	 * @param args no command arguments are given
	 */
	public static void main(String[] args) {				// main function to call the methods from SalesReporter
		SalesReporter report = new SalesReporter();			// instantiated to use getDatat(), computeStats(), displayResults()
		
		report.getData();						// gets data from user
		report.computeStats();					// calculate highest sales and the average of sales
		report.displayResults();				// displays the result of computeStats
	}

}
