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

	public static int getbrojRacunaUkupno() {
		return 0;
	}

	public int getBrojRacuna() {
		return 0;
	}

	public void setBrojRacuna(int brojRacuna) {
		
	}

	public String getImeVlasnika() {
		return 0;
	}

	public void setImeVlasnika(String imeVlasnika) {
		
	}

	public double getTrenutnoStanjeRacuna() {
		return 0;
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
