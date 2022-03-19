package ps.forceservice;

public interface IForceService {
	
	/**
	 * Calculate force using equation F= ma
	 * @param m Mass
	 * @param a Acceleration
	 * @return Force
	 */
	double calculateForce(double m, double a);
	
	/**
	 * Calculate up thrust using amount of water displaced
	 * @param m Mass of water displaced
	 * @param a Acceleration due to gravity
	 * @return Up thrust
	 */
	double calculateUpthrust(double m, double a);
	
	/**
	 * Calculate up thrust using amount of water displaced
	 * @param v Volume of water displaced
	 * @param d Density of water displaced
	 * @param a Acceleration due to gravity
	 * @return Up thrust
	 */
	double calculateUpthrust(double v, double d, double a);
	
	/**
	 * Calculate frictional force acting on an object
	 * @param f0 Coefficient of friction between two objects
	 * @param f Force applied on object
	 * @return Frictional force acting on object
	 */
	double calculateFrictionalForce(double f0, double f);

}
