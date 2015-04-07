package com.twitter;

import java.util.LinkedList;

import com.twiter.poruke.TwitterPoruka;

public class Twitter {

		/**
		 * Lista twitter poruka.
		 */
		private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	
		/**
		 * Metoda vraca sve twitter poruke.
		 * @return listu svih twitter poruka.
		 */
		public LinkedList<TwitterPoruka> vratiSvePoruke(){
			return poruke;
			}
	
		/**
		 * Metoda kreira nov objekat klase TwitterPoruka na osnovu unetih parametara, i unosi ga na kraj liste poruke.
		 * @param korisnik 
		 * @param poruka
		 */
		public void unesi(String korisnik, String poruka) {
			//Pravi se nova poruka i puni podacima.
			TwitterPoruka tp = new TwitterPoruka();
			tp.setKorisnik("korisnik");
			tp.setPoruka(poruka);
			//Poruka se unosi u listu na kraj
			poruke.addLast(tp);
			}
	
		/**
		 * Metoda pretrazuje listu poruke na osnovu taga koji se unosi kao ulazni parametar,
		 *  i popunjavaju niz, koji je izlazni rezultat ove metode, TwitterPorukama koje sadrze uneti tag.
		 * @param maxBroj
		 * @param tag
		 * @return niz ciji su elementi TwitterPoruke koje sadrze tag, koji je unet kao ulazni parametar metode.
		 */
		public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
			if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
			//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
			if (maxBroj<=0)
			maxBroj = 100;
			 //Pomocna promenljiva koja predstavlja brojac upisanih poruka
			int brojac = 0;
			//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
			//sve poruke koje u sebi imaju zadati tag
			TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
			//Pretrazuju se poruke i traze se one koje sadrze tag.
			//Ako se nadje neka takva, i ako nije prekoracen maxBroj
			//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
			//se prekida.
			for (int i = 0; i < poruke.size(); i++)
				if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
					if (brojac < maxBroj){
						rezultat[brojac+1]=poruke.get(i);
						brojac++;
					}
					else break;
				return rezultat;
		} 
}
