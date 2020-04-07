package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter rental data");

			System.out.print("Car model: ");
			String carModel = sc.nextLine();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
			Date startDate = sdf.parse(sc.nextLine());
			System.out.print("Return (dd/MM/yyyy HH:mm): ");
			Date finishDate = sdf.parse(sc.nextLine());

			CarRental carRental = new CarRental(startDate, finishDate, new Vehicle(carModel));

			System.out.print("Enter price per hour: ");
			double pricePerHour = sc.nextDouble();
			System.out.print("Enter price per day: ");
			double pricePerDay = sc.nextDouble();

			RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

			rentalService.processInvoice(carRental);

			System.out.println("INVOICE:");
			System.out.println(carRental.getInvoice());

		} catch (ParseException e) {
			System.out.println("Parse Error:" + e.getMessage());
		}

	}

}
