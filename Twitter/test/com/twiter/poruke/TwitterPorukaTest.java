package com.twiter.poruke;

import static org.junit.Assert.*; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tp;
	
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}
	
	@Test 
	public void testSetKorisnik() {
		tp.setKorisnik("nemac91");
		
		assertEquals("nemac91", tp.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrekoracenaDuzina() {
		tp.setPoruka("Poslednjih 200 godina primena novih tehnologija igrala je vodecu ulogu "
				+ "u spektakularnom rastu i transformaciji strukture razvijenih, a u novije vreme,"
				+ " i manje razvijenih zemalja. Inicijalne promene u tehnološkom domenu ne mogu"
				+ " se odvojeno posmatrati od promena ekonomskog i društvenog sistema.");
	}
		
	@Test
	public void testSetPoruka() {
		tp.setPoruka("Programiranje je kul.");
		
		assertEquals("Programiranje je kul.", tp.getPoruka());
	}

	@Test
	public void testToString() {
		tp.setKorisnik("nemac91");
		tp.setPoruka("Programiranje je kul.");
		
		assertEquals("KORISNIK: "+"nemac91"+" PORUKA: "+"Programiranje je kul.",
				"KORISNIK: "+tp.getKorisnik()+" PORUKA: "+tp.getPoruka());
	}

}
