package Bankomat;

public class Racun extends Izbornik {
	private int brojRacuna;
	private String imeVlasnika;
	public double trenutnoStanjeRacuna;
	private static int brojRacunaUkupno;

	public Racun() {
		
	}

	public Racun(double trenutnoStanjeRacuna) {
		
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeVlasnika() {
		return imeVlasnika;
	}

	public void setImeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}

	public double getTrenutnoStanjeRacuna() {
		return trenutnoStanjeRacuna;
	}
	public void dodajNovac(double iznos) {
	
	}

	public static void ispisRacuna(int brojRacuna) {

	}

	@Override
	public String toString() {
		return "\n Broj racuna: " + brojRacuna + "\n Ime: " + imeVlasnika + "\n Trenutno stanje: "
				+ trenutnoStanjeRacuna;
	}
}
