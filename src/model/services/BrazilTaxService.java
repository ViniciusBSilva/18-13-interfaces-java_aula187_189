package model.services;

public class BrazilTaxService implements TaxService {

	@Override
	public double tax(double amount) {

		double tax = 0.00;
		if (amount <= 100.00) {
			tax = amount * 0.2;
		} else {
			tax = amount * 0.15;
		}
		
		return tax;
	}

}
