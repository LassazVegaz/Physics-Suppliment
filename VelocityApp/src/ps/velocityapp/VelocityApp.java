package ps.velocityapp;

import java.util.Scanner;

import ps.velocityservice.IVelocityService;

public class VelocityApp implements IApp {

	private static final String NAME = "Velocity";

	private static final int OPTION_VELO = 1, OPTION_VELO_NO_TIME = 2, OPTION_DIS = 3, OPTION_DIS_NO_ACC = 4,
			OPTION_EXIT = 0;

	private Scanner scanner = new Scanner(System.in);
	private IVelocityService velocityService;

	public VelocityApp(IVelocityService velocityService) {
		this.velocityService = velocityService;
	}

	@Override
	public String getName() {
		return NAME;
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
			case OPTION_VELO:
				calVelo();
				break;

			case OPTION_VELO_NO_TIME:
				calVeloNoTime();
				break;

			case OPTION_DIS:
				calDis();
				break;

			case OPTION_DIS_NO_ACC:
				calDisNoAcc();
				break;

			default:
				System.out.println("Invaliid input");
			}

		}

		scanner.close();

	}

	private void displayMenu() {
		System.out.println(OPTION_EXIT + " -> Exit");
		System.out.println(OPTION_VELO + " -> Calculate velocity");
		System.out.println(OPTION_VELO_NO_TIME + " -> Calculate velocity without time");
		System.out.println(OPTION_DIS + " -> Calculate displacement");
		System.out.println(OPTION_DIS_NO_ACC + " -> Calculate displacement without acceleration");
	}

	private void calVelo() {
		try {

			var u = getInitialVelocity();
			var a = getAcceleration();
			var t = getTime();

			var v = velocityService.calculateFinalVelocity(u, a, t);
			System.out.printf("Final velocity : %.2f ms-1\n", v);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calVeloNoTime() {
		try {

			var u = getInitialVelocity();
			var a = getAcceleration();
			var s = getDisplacement();

			var v = velocityService.calculateFinalVelocityWihtoutTime(u, a, s);
			System.out.printf("Final velocity : %.2f ms-1\n", v);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calDis() {
		try {

			var u = getInitialVelocity();
			var a = getAcceleration();
			var t = getTime();

			var s = velocityService.calculateDisplacement(u, a, t);
			System.out.printf("Final velocity : %.2f ms-1\n", s);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	private void calDisNoAcc() {
		try {

			var u = getInitialVelocity();
			var v = getFinalVelocity();
			var t = getTime();

			var s = velocityService.calculateDisplacementWihtoutAcceleration(u, v, t);
			System.out.printf("Final velocity : %.2f ms-1\n", s);

		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	private double getInitialVelocity() {
		System.out.println("Enter initial velocity (ms-1) : ");
		return scanner.nextDouble();
	}
	
	private double getAcceleration() {
		System.out.println("Enter acceleration (ms-2) : ");
		return scanner.nextDouble();
	}
	
	private double getTime() {
		System.out.println("Enter time (s) : ");
		return scanner.nextDouble();
	}
	
	private double getFinalVelocity() {
		System.out.println("Enter final velocity (ms-1) : ");
		return scanner.nextDouble();
	}
	
	private double getDisplacement() {
		System.out.println("Enter displacement (m) : ");
		return scanner.nextDouble();
	}

}
