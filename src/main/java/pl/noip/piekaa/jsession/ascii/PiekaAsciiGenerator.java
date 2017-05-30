package pl.noip.piekaa.jsession.ascii;

import pl.noip.piekaa.jsession.ascii.calculations.AreaCalculator;
import pl.noip.piekaa.jsession.ascii.calculations.AreaInfo;
import pl.noip.piekaa.jsession.ascii.image.ImageIterator;

public class PiekaAsciiGenerator implements AsciiGenerator {

	ImageIterator imageIterator;
	AreaCalculator areaCalculator;
	ASCIIProvider letterProvider;

	
	
	
	public PiekaAsciiGenerator(ImageIterator imageIterator,
			AreaCalculator areaCalculator, ASCIIProvider letterProvider) {
		super();
		this.imageIterator = imageIterator;
		this.areaCalculator = areaCalculator;
		this.letterProvider = letterProvider;
	}




	public String generate() 
	{
		StringBuilder asciiTextBuilder = new StringBuilder();

		while (imageIterator.hasNext()) 
		{
			AreaInfo areaInfo = imageIterator.next();
			if (areaInfo.isEndl())
				asciiTextBuilder.append(letterProvider.getEndl());
			else
				asciiTextBuilder.append(letterProvider.getASCII(areaCalculator.calculate(areaInfo.getArea())));
		}

		return asciiTextBuilder.toString();
	}

}
