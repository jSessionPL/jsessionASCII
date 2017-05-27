package pl.noip.piekaa.jsession.ascii;

import java.io.IOException;

public class Configuration 
{
	
	private static Configuration instance = new Configuration();
	
	
	public static Configuration getInstance() { return instance; }
	
	private String imgPath = "testImage.png";
	private int boxWidth = 12;
	private int boxHeight = 22;
	
	public void configure(String[] args)
	{
		 imageReader = new LocalImageReader();
		 letterProvider = new TableBasedLetterProvider("#a.");
		 colorDecoder = new BnwDecoder();
		 areaCalculator = new InlineAreaCalculator(colorDecoder);
		 try {
			imageIterator = new CuttingImageIterator(imageReader.readImage(imgPath), boxWidth, boxHeight);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 asciiGenerator = new PiekaAsciiGenerator(imageIterator, areaCalculator, letterProvider );
	}
	
	
	private AreaCalculator areaCalculator;
	private AsciiGenerator asciiGenerator;
	private ColorDecoder colorDecoder;
	private ImageIterator imageIterator;
	private ImageReader imageReader;
	private LetterProvider letterProvider;


	public AreaCalculator getAreaCalculator() {
		return areaCalculator;
	}


	public AsciiGenerator getAsciiGenerator() {
		return asciiGenerator;
	}


	public ColorDecoder getColorDecoder() {
		return colorDecoder;
	}


	public ImageIterator getImageIterator() {
		return imageIterator;
	}


	public ImageReader getImageReader() {
		return imageReader;
	}


	public LetterProvider getLetterProvider() {
		return letterProvider;
	}
	
	
	
	
	
	
}
