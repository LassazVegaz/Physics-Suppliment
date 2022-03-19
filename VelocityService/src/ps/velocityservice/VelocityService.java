package ps.velocityservice;

public class VelocityService implements IVelocityService {

	@Override
	public double calculateFinalVelocity(double initialVelocity, double acceleration, double time) {
		return initialVelocity + (acceleration * time);
	}

	@Override
	public double calculateFinalVelocityWihtoutTime(double initialVelocity, double acceleration, double displacement) {
		return Math.sqrt(Math.pow(initialVelocity, 2) + (2 * acceleration * displacement));
	}

	@Override
	public double calculateDisplacement(double initialVelocity, double acceleration, double time) {
		return (initialVelocity * time) + (0.5 * acceleration * Math.pow(time, 2));
	}

	@Override
	public double calculateDisplacementWihtoutAcceleration(double initialVelocity, double finalVelocity, double time) {
		return 0.5 * time * (initialVelocity + finalVelocity);
	}

}
