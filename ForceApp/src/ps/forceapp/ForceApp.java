package ps.forceapp;

import java.util.Scanner;

import ps.forceservice.IForceService;

public class ForceApp implements IForceApp {

	private static final int OPTION_FORCE = 1, OPTION_UPTHRUST_MASS = 2, OPTION_UPTHRUST_VOL = 3, OPTION_FRICTION = 4,
			OPTION_EXIT = 0;

	private Scanner scanner = new Scanner(System.in);
	private IForceService forceService;

	public ForceApp(IForceService forceService) {
		this.forceService = forceService;
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
			case OPTION_FORCE:
				calForce();
				break;

			case OPTION_UPTHRUST_MASS:
				calUpthrustWithMass();
				break;

			case OPTION_UPTHRUST_VOL:
				calUpthrustWithVol();
				break;

			case OPTION_FRICTION:
				calFriction();
				break;

			default:
				System.out.println("Invaliid input");
			}

		}

		scanner.close();

	}

	private void displayMenu() {
		System.out.println(OPTION_EXIT + " -> Exit");
		System.out.println(OPTION_FORCE + " -> Calculate force");
		System.out.println(OPTION_UPTHRUST_MASS + " -> Calculate upthrust with mass");
		System.out.println(OPTION_UPTHRUST_VOL + " -> Calculate upthrust with volume");
		System.out.println(OPTION_FRICTION + " -> Calculate frictional force");
	}

	private void calForce() {
		try {

			var m = getMass();
			var a = getAcceleration();

			var f = forceService.calculateForce(m, a);
			System.out.printf("Force : %.2f N\n", f);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calUpthrustWithMass() {
		try {

			var m = getMass();
			var a = getAcceleration();

			var f = forceService.calculateUpthrust(m, a);
			System.out.printf("Upthrust : %.2f N\n", f);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calUpthrustWithVol() {
		try {

			var v = getVolume();
			var d = getDensity();
			var a = getAcceleration();

			var f = forceService.calculateUpthrust(v, d, a);
			System.out.printf("Upthrust : %.2f N\n", f);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calFriction() {
		try {

			var f = getForce();
			var f0 = getCoefficientOfFric();

			var fric = forceService.calculateFrictionalForce(f0, f);
			System.out.printf("Frictional force : %.2f N\n", fric);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private double getMass() {
		System.out.println("Enter mass (kg) : ");
		return scanner.nextDouble();
	}

	private double getAcceleration() {
		System.out.println("Enter acceleration (ms-2) : ");
		return scanner.nextDouble();
	}

	private double getForce() {
		System.out.println("Enter force (N) : ");
		return scanner.nextDouble();
	}

	private double getVolume() {
		System.out.println("Enter volume (m3) : ");
		return scanner.nextDouble();
	}

	private double getDensity() {
		System.out.println("Enter density (kg m-3) : ");
		return scanner.nextDouble();
	}

	private double getCoefficientOfFric() {
		System.out.println("Enter coefficient of friction : ");
		return scanner.nextDouble();
	}

}
