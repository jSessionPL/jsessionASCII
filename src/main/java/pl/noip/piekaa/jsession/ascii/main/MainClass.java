package pl.noip.piekaa.jsession.ascii.main;

import pl.noip.piekaa.jsession.ascii.configuration.Configuration;
import pl.noip.piekaa.jsession.ascii.execute.Executor;

public class MainClass 
{
	public static void main(String[] args) 
	{
		Configuration config = Configuration.getInstance();
		config.configure(args);
		Executor executor = config.getExecutor();
		
		executor.execute();
		
		
	}	
}
