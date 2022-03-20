package ps.physics_suppliment;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import ps.forceapp.IForceApp;
import ps.velocityapp.IApp;

public class Activator implements BundleActivator {

	private static final int OPTION_EXIT = 0, OPTION_VELO = 1, OPTION_FORCE = 2, OPTION_ENERGY = 3, OPTION_ELEC = 4;

	private IApp velocityApp;
	private IForceApp forceApp;

	@Override
	public void start(BundleContext context) throws Exception {
		var veloServiceRef = context.getServiceReference(IApp.class);
		velocityApp = context.getService(veloServiceRef);
		
		var forceServiceRef = context.getServiceReference(IForceApp.class);
		forceApp = context.getService(forceServiceRef);
		
		start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {

	}

	private void start() {
		System.out.println("Welcome to Physics Supplement!");
		System.out.println("Solve all your physics problems with US");
		
		var scanner = new Scanner(System.in);

		while (true) {

			System.out.println();
			System.out.println();
			displayMenu();
			System.out.print("Please select an option : ");

			int input;
			try {
				input = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid input");
				continue;
			}

			if (input == OPTION_EXIT)
				break;

			switch (input) {
			case OPTION_VELO:
				velocityApp.start();
				break;
				
			case OPTION_FORCE:
				forceApp.start();
				break;

			default:
				System.out.println("Invalid input");
				break;
			}

		}

		scanner.close();
	}

	private void displayMenu() {

		System.out.println(OPTION_EXIT + " -> Exit");
		System.out.println(OPTION_VELO + " -> Velocity equations");
		System.out.println(OPTION_FORCE + " -> Force equations");
		System.out.println(OPTION_ENERGY + " -> Energy equations");
		System.out.println(OPTION_ELEC + " -> Electricity equations");

	}

}
