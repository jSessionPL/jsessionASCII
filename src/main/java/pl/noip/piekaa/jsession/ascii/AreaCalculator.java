package pl.noip.piekaa.jsession.ascii;

public interface AreaCalculator 
{
	/**
	 * Calculates how light is this area
	 * @param array
	 * @return 0.0 - 1
	 */
	float calculate(int[][] array);
}
