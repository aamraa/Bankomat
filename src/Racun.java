
import java.io.Serializable;
import java.util.ArrayList;

public class Racun extends Izbornik implements Serializable{
	private int brojRacuna;
	private String imeVlasnika;
	protected double trenutnoStanjeRacuna; 
	private static int brojRacunaUkupno;

	protected static ArrayList<Racun> racuni = new ArrayList<Racun>();
	
	public Racun() {
		brojRacunaUkupno++;
	}

	public Racun(int brojRacuna, String imeVlasnika, double iznos) {
		this.brojRacuna = brojRacuna;
		this.imeVlasnika = imeVlasnika;
		this.trenutnoStanjeRacuna = iznos;
		racuni.add(this);
		System.out.println("Racun je uspjesno kreiran.");
		System.out.println("Broj Vaseg racuna je: " + this.brojRacuna);
		System.out.println();
	}
	
	public static int getbrojRacunaUkupno() {
		return brojRacunaUkupno;
	}

	public int getBrojRacuna() {
		return brojRacuna;
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

	public void setTrenutnoStanjeRacuna(double iznos) {
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
	
	public boolean provjeriZauzetost(int ID) {
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).getBrojRacuna() == ID)
				return false;
		}
		return true;

	}
}

