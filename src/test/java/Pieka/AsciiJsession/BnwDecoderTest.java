package Pieka.AsciiJsession;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import pl.noip.piekaa.jsession.ascii.BnwDecoder;
import pl.noip.piekaa.jsession.ascii.ColorDecoder;


public class BnwDecoderTest  
{
	
	ColorDecoder colorDecoder;
	
	BufferedImage image;
	
	@Before
	public void init()
	{
		colorDecoder = new BnwDecoder();
		try {
			image = ImageIO.read(new File("testImage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void realImageValuesTest()
	{
		for(int i = 0 ; i < image.getWidth() ; i++)
			for(int j = 0 ; j < image.getHeight() ;j++)
			{
				int decoded = colorDecoder.decode(image.getRGB(i, j));			
				
				assertThat(decoded, Matchers.greaterThan(-1));
				assertThat(decoded, lessThan(256)); 
				
			}
	}
	
	
	
	@Test
	public void blackTestWithAlpha0()
	{
		int color = 0;
		
		int decoded = colorDecoder.decode(color);
		
		assertEquals( 0, decoded);
		
	}
	
	@Test
	public void blackTestWithAlpha255()
	{
		int color = getColor(0, 0, 0, 255);
		
		int decoded = colorDecoder.decode(color);
		
		assertEquals( 0, decoded);
	}
	
	
	@Test
	public void whiteTestWithAlpha0()
	{
		int color = getColor(255,255,255,0);
		
		int decoded = colorDecoder.decode(color);
		
		assertEquals( 255, decoded);
		
	}
	
	@Test
	public void whiteTestWithAlpha255()
	{
		int color = getColor(255,255,255,255);
		
		int decoded = colorDecoder.decode(color);
		
		assertEquals( 255, decoded);
		
	}

	
	public void testAvgWithAlpha0()
	{
		int color = getColor(100,150,200,0);
		
		int decoded = colorDecoder.decode(color);
		
		assertEquals(150, decoded);
		
	}
	
	@Test
	public void testAvgWithAlpha100()
	{
		int color = getColor(100,150,200,100);
		
		int decoded = colorDecoder.decode(color);
		
		assertEquals(150, decoded);
		
	}
	
	@Test
	public void testAvgWithAlpha255()
	{
		int color = getColor(100,150,200,255);
		
		int decoded = colorDecoder.decode(color);
		
		assertEquals(150, decoded);
		
	}
	
	private int getColor(int r, int g, int b, int a)
	{
		return (a << 24) | (r << 16) | (g << 8) | b; 
	}
	 
}
