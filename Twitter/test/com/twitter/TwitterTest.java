package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twiter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private LinkedList<TwitterPoruka> poruke;

	@Before
	public void setUp() throws Exception {
		poruke = new LinkedList<TwitterPoruka>();
	}

	@After
	public void tearDown() throws Exception {
		poruke = null;
	}

	@Test
	public void testVratiSvePoruke() {
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("ceca");
		tp1.setPoruka("bubububu");
		poruke.add(tp1);
		assertEquals(tp1, poruke.getFirst());
	}
	
	@Test (expected = java.lang.NullPointerException.class)
	public void testVratiSvePorukeNull() {
		poruke = null;
		poruke.getFirst();
	}

	//OSTAVLJAM OVAJ TEST, IAKO NE PROLAZI, JER SAM POMOCU NJEGA PRONASAO GRESKU U KODU METODE!
	@Test
	public void testUnesiGreska() {
		TwitterPoruka tp = new TwitterPoruka();
		String korisnik = "ceca";
		String poruka = "bububub";
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		poruke.addLast(tp);
		assertEquals(korisnik, poruke.getLast().getKorisnik());
	}
	
	@Test
	public void testUnesi() {
		TwitterPoruka tp = new TwitterPoruka();
		String korisnik = "ceca";
		String poruka = "bububub";
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		poruke.addLast(tp);
		assertEquals(korisnik, poruke.getLast().getKorisnik());
	}

	//OSTAVLJAM OVAJ TEST, IAKO NE PROLAZI, JER SAM POMOCU NJEGA PRONASAO GRESKU U KODU METODE!
	@Test
	public void testVratiPorukeGreska() {
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("ceca");
		tp1.setPoruka("roobu");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("maca");
		tp2.setPoruka("buba");
		TwitterPoruka tp3 = new TwitterPoruka();
		tp3.setKorisnik("jeca");
		tp3.setPoruka("bambam");
		poruke.add(tp1);
		poruke.add(tp2);
		poruke.add(tp3);
		
		int maxBroj = 5;
		String tag = "bu";
		int brojac = 0;
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac+1]=poruke.get(i);
					brojac++;
				}
				else break;
		
		assertEquals(poruke.getFirst(), rezultat[0]);
	}
	
	@Test
	public void testVratiPoruke() {
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("ceca");
		tp1.setPoruka("roobu");
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("maca");
		tp2.setPoruka("buba");
		TwitterPoruka tp3 = new TwitterPoruka();
		tp3.setKorisnik("jeca");
		tp3.setPoruka("bambam");
		poruke.add(tp1);
		poruke.add(tp2);
		poruke.add(tp3);
		
		int maxBroj = 5;
		String tag = "bu";
		int brojac = 0;
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		
		assertEquals(poruke.getFirst(), rezultat[0]);
	}
}
