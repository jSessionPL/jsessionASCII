package Pieka.AsciiJsession;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.noip.piekaa.jsession.ascii.ASCIIProvider;
import pl.noip.piekaa.jsession.ascii.TableBasedASCIIProvider;

public class TableBasedLetterProviderTest 
{
	
	ASCIIProvider letterProvider;
	
	@Before
	public void init()
	{
		letterProvider = new TableBasedASCIIProvider("#a ");
	}
	
	
	@Test
	public void shouldReturnSpace()
	{
		assertEquals(' ', letterProvider.getASCII(1));
	}
	
	@Test
	public void shouldReturnA()
	{
		assertEquals('a', letterProvider.getASCII(0.5f));
	}
	@Test
	public void shouldReturnHash()
	{
		assertEquals('#', letterProvider.getASCII(0));
	}
	
	@Test
	public void almost0Returnhash()
	{
		assertEquals('#', letterProvider.getASCII(.1f));
	}
	
	
}
