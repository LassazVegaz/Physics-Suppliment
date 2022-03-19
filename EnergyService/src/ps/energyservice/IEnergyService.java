package ps.energyservice;

public interface IEnergyService {
	
	/**
	 * Calculate kinertic energy
	 * @param m Mass
	 * @param v Velocity
	 * @return Kinertic energy
	 */
	double calculateKinerticEnergy(double m, double v);
	
	/**
	 * Calculate potential energy
	 * @param m Mass
	 * @param g Acceleration due to gravity
	 * @param h Height of the object position object placed
	 * @return Potential energy
	 */
	double calculatePotentialEnergy(double m, double g, double h);
	
	/**
	 * Calculate power
	 * @param f Force
	 * @param v Velocity
	 * @return Power
	 */
	double calculatePower(double f, double v);
	
	/**
	 * Calculate work done
	 * @param f Force applied
	 * @param d Displacement
	 * @return Work done
	 */
	double calculateWorkDone(double f, double d);

}
