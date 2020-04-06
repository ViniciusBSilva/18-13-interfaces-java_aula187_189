package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;

	private TaxService taxService;
		
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}

	public void processInvoice (CarRental carRental) {
		
		long startMs = carRental.getStart().getTime();
		long finishMs = carRental.getFinish().getTime();
		double totalHours = (double) (finishMs - startMs) / 1000 / 60 / 60;
		
		double basicPayment;
		if (totalHours <= 12.0) {
			basicPayment = Math.ceil(totalHours) * pricePerHour;
		} else {
			basicPayment = Math.ceil(totalHours / 24) * pricePerDay;
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment,tax));
				
	}

}
