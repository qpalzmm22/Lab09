package edu.handong.csee.java.lab09; // makes it a package

/**
 * This class implements sales associate
 * This class only contains getters and setters of private variables of mName and mSales
 * @author qpalzmm22
 *
 */
public class SalesAssociate { // This class contains information about name and sales number of associate
	private String mName;	// name of associate
	private double mSales;	// sales of associate

	/**
	 * this is getter for mName
	 * @return the member variable, mName of this object
	 */
	public String getName() {	// gets the name of this object
		return mName;			// returns the mName
	}
	/**
	 * this method sets member variable mName by parameter, name
	 * @param name name of the sales associate
	 */
	public void setName(String name) {	// sets the name by given parameter
		this.mName = name;				// mName of this object becomes the given parameter
	}
	/**
	 * this method is getter for mSales
	 * @return the member variable, mSales of this object
	 */
	public double getSales() {	// gets the name of this object
		return mSales;			// returns the mSales
	}
	/**
	 * This method sets member variable mSales by parameter, sales
	 * @param sales sales of the sales associate
	 */
	public void setSales(double sales) {	// sets the sales number by given parameter
		this.mSales = sales;				// mSales of this object becomes the given parameter
	}
}
