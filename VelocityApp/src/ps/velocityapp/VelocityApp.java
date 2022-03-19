package ps.velocityapp;

import java.util.Scanner;

import ps.core.IApp;
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

	}

	private void calVeloNoTime() {

	}

	private void calDis() {

	}

	private void calDisNoAcc() {

	}

}
