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
		trenutnoStanjeRacuna += iznos;
	
	}

	public static void ispisRacuna(int brojRacuna) {
		for (int i = 0; i < racuni.size(); i++)
			if (racuni.get(i).brojRacuna == brojRacuna) {
				System.out.println(racuni.get(i).toString());
				return;

	}
		System.out.println("Unijeti racun nije pronadjen.");
		}

	@Override
	public String toString() {
		return "\n Broj racuna: " + brojRacuna + "\n Ime: " + imeVlasnika + "\n Trenutno stanje: "
				+ trenutnoStanjeRacuna;
	}
}
