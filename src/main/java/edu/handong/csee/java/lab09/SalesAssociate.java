package edu.handong.csee.java.lab09;

/**
 * This class implements sales associate
 * This class only contains getters and setters of private variables of mName and mSales
 * @author qpalzmm22
 *
 */
public class SalesAssociate {
	private String mName;
	private double mSales;

	/**
	 * this is getter for mName
	 * @return the member variable, mName of this object
	 */
	public String getName() {
		return mName;
	}
	/**
	 * this method sets member variable mName by parameter, name
	 * @param name name of the sales associate
	 */
	public void setName(String name) {
		this.mName = name;
	}
	/**
	 * this method is getter for mSales
	 * @return the member variable, mSales of this object
	 */
	public double getSales() {
		return mSales;
	}
	/**
	 * This method sets member variable mSales by parameter, sales
	 * @param sales sales of the sales associate
	 */
	public void setSales(double sales) {
		this.mSales = sales;
	}
}
