package Pieka.AsciiJsession;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.noip.piekaa.jsession.ascii.LetterProvider;
import pl.noip.piekaa.jsession.ascii.TableBasedLetterProvider;

public class TableBasedLetterProviderTest 
{
	
	LetterProvider letterProvider;
	
	@Before
	public void init()
	{
		letterProvider = new TableBasedLetterProvider("#a ");
	}
	
	
	@Test
	public void shouldReturnSpace()
	{
		assertEquals(' ', letterProvider.getLetter(1));
	}
	
	@Test
	public void shouldReturnA()
	{
		assertEquals('a', letterProvider.getLetter(0.5f));
	}
	@Test
	public void shouldReturnHash()
	{
		assertEquals('#', letterProvider.getLetter(0));
	}
	
}
