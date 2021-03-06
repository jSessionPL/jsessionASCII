package pl.noip.piekaa.jsession.ascii.image;

import pl.noip.piekaa.jsession.ascii.calculations.AreaInfo;

/**
 * Splits image to rectangles. Provides them starting with top left, then top left +1 and so on.
 * @author piekaa
 *
 */
public interface ImageIterator 
{
	boolean hasNext();
	AreaInfo next();
}
