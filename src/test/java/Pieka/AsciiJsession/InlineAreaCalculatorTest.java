package Pieka.AsciiJsession;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.noip.piekaa.jsession.ascii.calculations.AreaCalculator;
import pl.noip.piekaa.jsession.ascii.calculations.BnwDecoder;
import pl.noip.piekaa.jsession.ascii.calculations.InlineAreaCalculator;

public class InlineAreaCalculatorTest 
{
	
	AreaCalculator areaCalculator;
	
	@Before
	public void init()
	{
		areaCalculator = new InlineAreaCalculator(new BnwDecoder());
	}
	
	@Test
	public void ZeroArea10x10()
	{
		int[][] area = generateArea(10,10,0);
		
		assertEquals(0.0f,  areaCalculator.calculate(area), 0.05f );
		
	}
	
	
	
	@Test
	public void HalfArea100x10()
	{
		int[][] area = generateArea(100,10,127);
		
		assertEquals(0.5f,  areaCalculator.calculate(area), 0.05f );
		
	}
	
	
	@Test
	public void HalfArea10x100()
	{
		int[][] area = generateArea(10,100,127);
		
		assertEquals(0.5f,  areaCalculator.calculate(area), 0.05f );
		
	}
	
	@Test
	public void OneArea4x8()
	{
		int[][] area = generateArea(4,8,255);
		
		assertEquals(1f,  areaCalculator.calculate(area), 0.05f );
		
	}
	
	
	public int[][] generateArray(int w ,int h)
	{
		int array[][];
		
		array = new int[w][];
		
		for(int i  =0 ; i < w ; i ++)
			array[i] = new int[h];
		
		return array;
	}
	
	public int[][] generateArea(int w, int h, int value)
	{
		int[][] array = generateArray(w,h);
		
		for(int i  = 0 ; i < w ; i ++)
			for(int j = 0; j < h ; j++)
			array[i][j] = value | (value << 8) | (value << 16);
		return array;
	}
	

}
