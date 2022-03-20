package ps.energyapp;

import java.util.Scanner;

import ps.energyservice.IEnergyService;

public class EnergyApp implements IEnergyApp {

	private static final int OPTION_KE = 1, OPTION_PE = 2, OPTION_POWER = 3, OPTION_WORK = 4, OPTION_EXIT = 0;

	private Scanner scanner = new Scanner(System.in);
	private IEnergyService energyService;

	public EnergyApp(IEnergyService energyService) {
		this.energyService = energyService;
	}

	@Override
	public void start() {

		while (true) {

			System.out.println();
			System.out.println();
			displayMenu();
			System.out.print("Please select an option: ");

			int input;
			try {
				input = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Invaliid input");
				continue;
			}

			if (input == OPTION_EXIT)
				break;

			System.out.println();

			switch (input) {
			case OPTION_KE:
				calKE();
				break;

			case OPTION_PE:
				calPE();
				break;

			case OPTION_POWER:
				calPower();
				break;

			case OPTION_WORK:
				calWork();
				break;

			default:
				System.out.println("Invaliid input");
			}

		}

		scanner.close();

	}

	private void displayMenu() {
		System.out.println(OPTION_EXIT + " -> Exit");
		System.out.println(OPTION_KE + " -> Calculate kinertic energy");
		System.out.println(OPTION_PE + " -> Calculate potential energy");
		System.out.println(OPTION_POWER + " -> Calculate power");
		System.out.println(OPTION_WORK + " -> Calculate work done");
	}

	private void calKE() {
		try {

			var m = getMass();
			var v = getVelocity();

			var e = energyService.calculateKinerticEnergy(m, v);
			System.out.printf("Energy : %.2f J\n", e);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calPE() {
		try {

			var m = getMass();
			var g = getGravAcc();
			var h = getHeight();

			var e = energyService.calculatePotentialEnergy(m, g, h);
			System.out.printf("Energy : %.2f J\n", e);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calPower() {
		try {

			var f = getForce();
			var v = getVelocity();

			var p = energyService.calculatePower(f, v);
			System.out.printf("Power : %.2f W\n", p);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calWork() {
		try {

			var f = getForce();
			var d = getDisplacement();

			var w = energyService.calculateWorkDone(f, d);
			System.out.printf("Work done : %.2f J\n", w);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private double getMass() {
		System.out.println("Enter mass (kg) : ");
		return scanner.nextDouble();
	}

	private double getForce() {
		System.out.println("Enter force (N) : ");
		return scanner.nextDouble();
	}

	private double getVelocity() {
		System.out.println("Enter velocity (ms-1) : ");
		return scanner.nextDouble();
	}

	private double getGravAcc() {
		System.out.println("Enter acceleration due to gravity (ms-2) : ");
		return scanner.nextDouble();
	}

	private double getDisplacement() {
		System.out.println("Enter displacement (m) : ");
		return scanner.nextDouble();
	}

	private double getHeight() {
		System.out.println("Enter height (m) : ");
		return scanner.nextDouble();
	}

}
