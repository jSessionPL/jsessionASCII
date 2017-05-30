package pl.noip.piekaa.jsession.ascii.execute;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import pl.noip.piekaa.jsession.ascii.AsciiGenerator;

public class OutputFileExecutor implements Executor {

	
	private AsciiGenerator asciiGenerator;
	private String filePath;
	
	
	
	
	public OutputFileExecutor(AsciiGenerator asciiGenerator, String filePath) {
		super();
		this.asciiGenerator = asciiGenerator;
		this.filePath = filePath;
	}




	@Override
	public void execute() 
	{
		try {
			PrintWriter pw = new PrintWriter(new File(filePath));
			pw.println( asciiGenerator.generate() );
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
