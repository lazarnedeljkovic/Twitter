package com.twiter.poruke;
/**
 * Klasa predstavlja jednu poruku na Twitteru.
 * @author lazar
 *
 */
public class TwitterPoruka {
	
	/**
	 * Ime korisnika.
	 */
	private String korisnik;
	
	/**
	 * Sadrzaj poruke.
	 */
	private String poruka;
	
	/**
	 * Vraca vrednost atributa korisnik.
	 * @return ime korisnika kao String.
	 */
	public String getKorisnik() {
	return korisnik;
	}
	
	/**
	 * Metoda postavlja vrednost atributa korisnik na unetu vrednost.
	 * @param korisnik Nova vrednost za atribut korisnik.
	 * @throws java.lang.RuntimeException ako je unet korisnik:
	 * <ul>
	 * <li>null, ili</li>
	 * <li>prazan String</li>
	 * </ul>	 
	 */
	public void setKorisnik(String korisnik) {
	if (korisnik==null || korisnik.equals(""))
	throw new RuntimeException(
	"Ime korisnika mora biti uneto");
	this.korisnik = korisnik;
	}
	
	/**
	 * Vraca vrednost atributa poruka.
	 * @return sadrzaj poruke kao String.
	 */
	public String getPoruka() {
	return poruka;
	}
	
	/**
	 * Metoda postavlja vrednost atributa poruka na unetu vrednost.
	 * @param poruka Nova vrednost za sadrzaj poruke.
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * <ul>
	 * <li>null, ili</li>
	 * <li>sadrzaj duzi od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
	if (poruka==null || poruka.length()>140)
	throw new RuntimeException(
	"Poruka mora biti uneta i mora imati najvise 140 znakova");
	this.poruka = poruka;
	}
	
	/**
	 * Metoda vraca vrednosti atributa korisnik i poruka kao String.
	 */
	public String toString(){
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	} 
}
