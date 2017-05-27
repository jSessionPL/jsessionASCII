package pl.noip.piekaa.jsession.ascii;

public class MainClass 
{
	public static void main(String[] args) 
	{
		Configuration config = Configuration.getInstance();
		config.configure(args);
		AsciiGenerator asciiGenerator = config.getAsciiGenerator();
		
		
		System.out.println(asciiGenerator.generate());
		
		
	}	
}
