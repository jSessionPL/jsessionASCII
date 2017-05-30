package pl.noip.piekaa.jsession.ascii.execute;

import pl.noip.piekaa.jsession.ascii.AsciiGenerator;

public class CommandLineExecutor implements Executor
{

	private AsciiGenerator asciiGenerator;
	
	
	
	public CommandLineExecutor(AsciiGenerator asciiGenerator) {
		super();
		this.asciiGenerator = asciiGenerator;
	}



	@Override
	public void execute() 
	{
		System.out.println(asciiGenerator.generate());
	}
	

}
