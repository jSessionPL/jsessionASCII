package Pieka.AsciiJsession;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;

import pl.noip.piekaa.jsession.ascii.calculations.AreaInfo;
import pl.noip.piekaa.jsession.ascii.image.CuttingImageIterator;
import pl.noip.piekaa.jsession.ascii.image.ImageIterator;

public class CuttingImageIteratorTest 
{
	
	ImageIterator imageIterator;
	
	int width;
	int height;
	
	int boxWidth;
	int boxHeight;
	 
	public void init()
	{
		imageIterator = new CuttingImageIterator(new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB), boxWidth, boxHeight);
	}
	
	@Test
	public void iterationTestWithModulo()
	{
		width = 1000;
		height = 1500;
		
		boxWidth = 30;
		boxHeight = 40;
		
		init();
		
		
		int count = 0;
		int lines=0;
		
		assertTrue( imageIterator.hasNext());
		
		
		while( imageIterator.hasNext() )
		{
			
			assertThat( lines, lessThan(height/boxHeight)); 
			
			count++;
			AreaInfo ai = imageIterator.next();
			
			
			if( count <= width/boxWidth )
			{
				assertFalse( ai.isEndl() );
				assertEquals( boxWidth, ai.getArea().length );
				assertEquals( boxHeight, ai.getArea()[0].length);
			}
			else
			{ 
				lines++;
				count=0;
				assertTrue( ai.isEndl() );
				
				assertNull( ai.getArea());
				
			}
			 
		}
		assertEquals(lines, height/boxHeight);
		
	}
	
	
	
	@Test
	public void iterationTestWithoutModulo()
	{
		width = 1000;
		height = 1500;
		
		boxWidth = 10;
		boxHeight = 15;
		
		init();
		
		
		int count = 0;
		int lines=0;
		
		assertTrue( imageIterator.hasNext());
		
		
		while( imageIterator.hasNext() )
		{
			
			assertThat( lines, lessThan(height/boxHeight)); 
			
			count++;
			AreaInfo ai = imageIterator.next();
			
			
			if( count <= width/boxWidth )
			{
				assertFalse( ai.isEndl() );
				assertEquals( boxWidth, ai.getArea().length );
				assertEquals( boxHeight, ai.getArea()[0].length);
			}
			else
			{ 
				lines++;
				count=0;
				assertTrue( ai.isEndl() );
				
				assertNull( ai.getArea());
				
			}
			 
		}
		assertEquals(lines, height/boxHeight);
		
	}
	

}
