package model.entities;

import java.util.Formatter;

public class Invoice {

	private Double basicPayment;
	private Double tax;
	
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotalPayment() {
		return getTax() + getBasicPayment();
	}
	
	public String toString() {
		
		Formatter formatter = new Formatter();
		
		formatter.format("Basic payment: %.2f%n", getBasicPayment());
		formatter.format("Tax: %.2f%n", getTax());
		formatter.format("Total payment: %.2f%n", getTotalPayment());
		
		String result = formatter.toString();
		
		formatter.close();
		
		return result;
	}
	
}
