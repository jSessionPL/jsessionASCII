package pl.noip.piekaa.jsession.ascii;

public class TableBasedLetterProvider implements LetterProvider
{
	String letterTable;
	 
	
	
	
	public TableBasedLetterProvider(String letterTable) {
		super();
		this.letterTable = letterTable;
	}

	public char getLetter(float lightness) 
	{ 
		System.out.print(lightness);
		return letterTable.charAt( (int) (lightness * (letterTable.length()-1 ))  );
	}
 
	public String getEndl() 
	{
		return "\n";
	}
}
