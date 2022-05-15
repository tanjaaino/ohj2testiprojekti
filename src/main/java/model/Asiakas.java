package model;

public class Asiakas {

	// attributes
	private int asiakastunnus; // asiakastunnus
	private String etunimi;
	private String sukunimi;
	// profilointitiedot
	private int syntymavuosi;
	private String sukupuoli; // N=nainen, M=mies
	// yhteystiedot
	private String katuosoite;
	private String postinro;
	private String email;

	private double bonuspisteet; // ostoista kertyneet bonuspisteet

	// constructors
	
	public Asiakas() {
		
		super();
		this.asiakastunnus = 0;
		this.etunimi = null;
		this.sukunimi = null;
		this.syntymavuosi = 0;
		this.sukupuoli = null;
		this.katuosoite = null;
		this.postinro = null;
		this.email = null;
		this.bonuspisteet = 0.0;
	}
	
	public Asiakas(String etunimi, String sukunimi) {
		super();
		this.asiakastunnus = 0;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sukunimi = null;
		this.syntymavuosi = 0;
		this.sukupuoli = null;
		this.katuosoite = null;
		this.postinro = null;
		this.email = null;
		this.bonuspisteet = 0.0;
	}

	public Asiakas(String etunimi, String sukunimi, int syntymavuosi, String sukupuoli,
			String katuosoite, String postinro, String email, double bonuspisteet) {
		super();
		this.asiakastunnus = 0;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.syntymavuosi = syntymavuosi;
		this.sukupuoli = sukupuoli;
		this.katuosoite = katuosoite;
		this.postinro = postinro;
		this.email = email;
		this.bonuspisteet = bonuspisteet;
	}
	
	public Asiakas(int asiakastunnus, String etunimi, String sukunimi, int syntymavuosi, String sukupuoli,
			String katuosoite, String postinro, String email, double bonuspisteet) {
		super();
		this.asiakastunnus = asiakastunnus;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.syntymavuosi = syntymavuosi;
		this.sukupuoli = sukupuoli;
		this.katuosoite = katuosoite;
		this.postinro = postinro;
		this.email = email;
		this.bonuspisteet = bonuspisteet;
	}
	
	public Asiakas(int asiakastunnus, String etunimi, String sukunimi, int syntymavuosi, String sukupuoli,
			String katuosoite, String postinro, String email) {
		super();
		this.asiakastunnus = asiakastunnus;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.syntymavuosi = syntymavuosi;
		this.sukupuoli = sukupuoli;
		this.katuosoite = katuosoite;
		this.postinro = postinro;
		this.email = email;
		this.bonuspisteet = 0;
	}
	
	// setters

	public void setAsiakastunnus(int asiakastunnus) {
		this.asiakastunnus = asiakastunnus;
	}

	
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public void setSyntymavuosi(int syntymavuosi) {
		this.syntymavuosi = syntymavuosi;
	}

	public void setSukupuoli(String sukupuoli) {
		this.sukupuoli = sukupuoli;
	}

	public void setKatuosoite(String katuosoite) {
		this.katuosoite = katuosoite;
	}

	public void setPostinro(String postinro) {
		this.postinro = postinro;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBonuspisteet(double bonuspisteet) {
		this.bonuspisteet = bonuspisteet;
	}

	// getters

	public int getAsiakastunnus() {
		return asiakastunnus;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public int getSyntymavuosi() {
		return syntymavuosi;
	}

	public String getSukupuoli() {
		return sukupuoli;
	}

	public String getKatuosoite() {
		return katuosoite;
	}

	public String getPostinro() {
		return postinro;
	}

	public String getEmail() {
		return email;
	}

	public double getBonuspisteet() {
		return bonuspisteet;
	}

	// toString

	@Override
	public String toString() {
		return "Asiakas [asiakastunnus=" + asiakastunnus + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", syntymavuosi=" + syntymavuosi + ", sukupuoli=" + sukupuoli + ", katuosoite=" + katuosoite
				+ ", postinro=" + postinro + ", email=" + email + ", bonuspisteet=" + bonuspisteet + "]";
	}

}