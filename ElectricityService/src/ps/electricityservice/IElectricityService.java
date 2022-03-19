package ps.electricityservice;

public interface IElectricityService {
	
	/**
	 * Calculate power
	 * @param v Voltage
	 * @param c Current
	 * @return Power
	 */
	double calculatePower(double v, double c);
	
	/**
	 * Calculate voltage
	 * @param c Current
	 * @param r Resistance
	 * @return Voltage
	 */
	double calculateVoltage(double c, double r);
	
	/**
	 * Calculate charge
	 * @param c Current
	 * @param t Time
	 * @return Charge
	 */
	double calculateCharge(double c, double t);
	
	/**
	 * Calculate energy
	 * @param v Voltage
	 * @param c Charge
	 * @return Energy
	 */
	double calculateEnergy(double v, double c);
	
	/**
	 * Calculate energy
	 * @param v Voltage
	 * @param c Current
	 * @param t Time
	 * @return Energy
	 */
	double calculateEnergy(double v, double c, double t);

}
