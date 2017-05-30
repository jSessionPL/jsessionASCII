package pl.noip.piekaa.jsession.ascii.calculations;

public class BnwDecoder implements ColorDecoder
{

	public int decode(int color)
	{ 
		
		int b = color & 255;
		color >>= 8;
		int g = color & 255;
		color >>= 8;
		int r = color & 255;
		   
		
		return (r + b + g) / 3;
	}
	
}
