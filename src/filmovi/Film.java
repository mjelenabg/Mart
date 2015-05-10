package filmovi;

public class Film {
	private String naziv;
	private int godina;
	private String reziser;
	private String zanr;
	private double ocenaGledalaca;
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public String getReziser() {
		return reziser;
	}
	public void setReziser(String reziser) {
		this.reziser = reziser;
	}
	public String getZanr() {
		return zanr;
	}
	public void setZanr(String zanr) {
		this.zanr = zanr;
	}
	public double getOcenaGledalaca() {
		return ocenaGledalaca;
	}
	public void setOcenaGledalaca(double ocenaGledalaca) {
		this.ocenaGledalaca = ocenaGledalaca;
	}
	@Override
	public String toString() {
		return "Film [naziv=" + naziv + ",\n godina=" + godina + ",\n reziser="
				+ reziser + ",\n zanr=" + zanr + ",\n ocenaGledalaca="
				+ ocenaGledalaca + "]";
	}
	
	

}
