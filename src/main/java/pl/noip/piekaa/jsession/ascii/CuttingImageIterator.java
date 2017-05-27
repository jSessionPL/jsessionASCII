package pl.noip.piekaa.jsession.ascii;

import java.awt.image.BufferedImage;

public class CuttingImageIterator implements ImageIterator
{

	BufferedImage image;
	
	private int line = 0;
	private int posInLine = 0;
	
	private int linesX;
	private int linesY;
	
	private int boxWidth;
	private int boxHeight;
	
	
	
	
	public CuttingImageIterator(BufferedImage image, int boxWidth, int boxHeight) {
		super();
		this.image = image;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		
		linesX = image.getWidth() / boxWidth;
		linesY = image.getHeight() / boxHeight;
		
	}
 

	public boolean hasNext() 
	{
		if( line == linesY )
		{
			return false;
		}
		return true;
	}

	public AreaInfo next() 
	{
		AreaInfo result = null;
		
		if( posInLine == linesX )
		{
			posInLine = 0 ;
			line++;
			return new AreaInfo(true, null);
		}
		
		int[][] array = generateArray();
		
		int ii = 0;
		int jj = 0;
		 
		
		for(int i = posInLine * boxWidth ; i < posInLine * boxWidth + boxWidth ; i++)
		{
			jj = 0;
			for(int j = line * boxHeight ; j < line * boxHeight + boxHeight ; j++)
			{
				array[ii][jj] = image.getRGB(i, j);
				 
			
				jj++;
			}
			ii++; 
		}
		posInLine++;
		result = new AreaInfo(false, array);
		
		return result;

	}
	
	private int[][] generateArray()
	{
		int array[][] = new int [boxWidth][];
		
		for(int i = 0 ; i < boxWidth; i++)
			array[i] = new int[boxHeight];
		
		return array;
		
	}
	
}
