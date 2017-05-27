package pl.noip.piekaa.jsession.ascii;

public interface ColorDecoder 
{
	/**
	 * Decodes color and returns how light it is 
	 * @param color
	 * @return returns value 0 - 255 
	 */
	int decode(int color);
}
