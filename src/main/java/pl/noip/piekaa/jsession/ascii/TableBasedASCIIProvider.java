package pl.noip.piekaa.jsession.ascii;

public class TableBasedASCIIProvider implements ASCIIProvider
{
	String letterTable;
	 
	
	
	
	public TableBasedASCIIProvider(String letterTable) {
		super();
		this.letterTable = letterTable;
	}

	public char getASCII(float lightness) 
	{  
		return letterTable.charAt( (int) (lightness * (letterTable.length()-1 ))  );
	}
 
	public String getEndl() 
	{
		return "\n";
	}
}
