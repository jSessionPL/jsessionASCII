package pl.noip.piekaa.jsession.ascii.calculations;

public class InlineAreaCalculator implements AreaCalculator{

	private ColorDecoder colorDecoder;
	
	
	
	
	public InlineAreaCalculator(ColorDecoder colorDecoder) {
		super();
		this.colorDecoder = colorDecoder;
	}




	public float calculate(int[][] array) {
		long sum = 0;
		float avgSum;
		int count = 0;
		for(int i = 0 ; i < array.length ;i ++)
			for(int j = 0 ; j < array[i].length; j++)
			{
			//	if( array[i][j] > 255 || array[i][j] < 0 ) System.out.println(array[i][j]);
				sum += colorDecoder.decode( array[i][j] );
				count++;
			}
		
		avgSum = sum / (float)count;
		
		return avgSum / 255.0f;
	}

}
