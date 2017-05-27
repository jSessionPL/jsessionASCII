package pl.noip.piekaa.jsession.ascii;

public class PiekaAsciiGenerator implements AsciiGenerator {

	ImageIterator imageIterator;
	AreaCalculator areaCalculator;
	LetterProvider letterProvider;

	
	
	
	public PiekaAsciiGenerator(ImageIterator imageIterator,
			AreaCalculator areaCalculator, LetterProvider letterProvider) {
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
				asciiTextBuilder.append(letterProvider.getLetter(areaCalculator.calculate(areaInfo.getArea())));
		}

		return asciiTextBuilder.toString();
	}

}
