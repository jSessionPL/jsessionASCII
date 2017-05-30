package pl.noip.piekaa.jsession.ascii.configuration;

import java.io.IOException;

import pl.noip.piekaa.jsession.ascii.AsciiGenerator;
import pl.noip.piekaa.jsession.ascii.ASCIIProvider;
import pl.noip.piekaa.jsession.ascii.PiekaAsciiGenerator;
import pl.noip.piekaa.jsession.ascii.TableBasedASCIIProvider;
import pl.noip.piekaa.jsession.ascii.calculations.AreaCalculator;
import pl.noip.piekaa.jsession.ascii.calculations.BnwDecoder;
import pl.noip.piekaa.jsession.ascii.calculations.ColorDecoder;
import pl.noip.piekaa.jsession.ascii.calculations.InlineAreaCalculator;
import pl.noip.piekaa.jsession.ascii.execute.CommandLineExecutor;
import pl.noip.piekaa.jsession.ascii.execute.Executor;
import pl.noip.piekaa.jsession.ascii.execute.OutputFileExecutor;
import pl.noip.piekaa.jsession.ascii.image.CuttingImageIterator;
import pl.noip.piekaa.jsession.ascii.image.ImageIterator;
import pl.noip.piekaa.jsession.ascii.image.ImageReader;
import pl.noip.piekaa.jsession.ascii.image.LocalImageReader;

public class Configuration 
{
	
	private static Configuration instance = new Configuration();
	
	
	public static Configuration getInstance() { return instance; }
	 
	private int boxWidth = 6;
	private int boxHeight = 16;
	
	public void configure(String[] args)
	{
		
	//	for(String arg : args)
	//	System.out.println(arg);
		
		if( args.length == 0)
		{
			System.out.println("arguments: path c/o [[boxWidth] [boxHeight]] [output path]* [asciiArray]" );
			System.exit(0);
		}
		
		if( args.length == 1)
		{
			System.out.println("arguments: path c/o [[boxWidth] [boxHeight]] [output path]* [asciiArray]" );
			System.exit(0);
		}
		
		
		if( args[1].equals("c") == false && args[1].equals("o") == false)
		{
			System.out.println("arguments: path c/o [[[boxWidth boxHeight] [output path]] [asciiArray]]" );
			System.exit(0);
		}
		
		if( args[1].equals("c") )
		{
			if( args.length == 2)
			{
				configure( boxWidth, boxHeight, "@RROO%%??^^,,.", args[0], true, "");
			}
			if( args.length == 4)
			{
				configure( Integer.parseInt(args[2]), Integer.parseInt(args[3]), "@RROO%%??^^,,.", args[0], true, "");
			}
			if( args.length == 5)
			{
				configure( Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4], args[0], true, "");
			}
		}
		else
		{
			if( args.length == 3)
			{
				configure(boxWidth, boxHeight, "@RROO%%??^^,,.", args[0], false, args[2]);
			}
			if( args.length == 5)
			{
				configure( Integer.parseInt(args[2]), Integer.parseInt(args[3]), "@RROO%%??^^,,.", args[0], false, args[4] );
			}
			
			if( args.length == 6)
			{
				configure( Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[4], args[0], false, args[5] );
			}
		}
		 
	}
	
	
	
	private void configure(int boxWidth, int boxHeight, String asciiTable, String path, boolean commandLine, String outPath)
	{
		imageReader = new LocalImageReader();
		 letterProvider = new TableBasedASCIIProvider(asciiTable);
		 colorDecoder = new BnwDecoder();
		 areaCalculator = new InlineAreaCalculator(colorDecoder);
		 try {
			imageIterator = new CuttingImageIterator(imageReader.readImage(path), boxWidth, boxHeight);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 asciiGenerator = new PiekaAsciiGenerator(imageIterator, areaCalculator, letterProvider );
		 
		 if( commandLine == true)
		 {
			 executor = new CommandLineExecutor(asciiGenerator);
		 }
		 else
		 {
			 executor = new OutputFileExecutor(asciiGenerator, outPath);
		 }
		 
		 
	}
	
	
	private AreaCalculator areaCalculator;
	private AsciiGenerator asciiGenerator;
	private ColorDecoder colorDecoder;
	private ImageIterator imageIterator;
	private ImageReader imageReader;
	private ASCIIProvider letterProvider;
	private Executor executor;

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


	public ASCIIProvider getLetterProvider() {
		return letterProvider;
	}



	public Executor getExecutor() {
		return executor;
	}
	
	
	
	
	
	
	
}
