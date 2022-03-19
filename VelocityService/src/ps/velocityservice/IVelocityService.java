package ps.velocityservice;

public interface IVelocityService {
	
	double calculateFinalVelocity(double initialVelocity, double acceleration, double time);
	double calculateFinalVelocityWihtoutTime(double initialVelocity, double acceleration, double displacement);
	double calculateDisplacement(double initialVelocity, double acceleration, double time);
	double calculateDisplacementWihtoutAcceleration(double initialVelocity, double finalVelocity, double time);

}
