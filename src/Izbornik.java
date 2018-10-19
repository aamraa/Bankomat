

import java.util.ArrayList;
import java.util.Scanner;

public class Izbornik {

	public static ArrayList<Racun> racuni = new ArrayList<Racun>();
	static Scanner input = new Scanner(System.in);


	public static void main(String[] args) {

		opcije();

	}

	public static void opcije() {
		System.out.println();
		System.out.println("      DOBRODOSLI U GLAVNI IZBORNIK   ");
		System.out.println("   IZABERITE NEKU OD SLJEDECIH OPCIJA: ");
		System.out.println("1. Kreiranje racuna");
		System.out.println("2. Transfer novca");
		System.out.println("3. Ispis racuna");

		int izbor = input.nextInt();

		while (izbor != 1 && izbor != 2 && izbor != 3) {
			System.out.println("Pogresan izbor. Pokusajte ponovo.");
			izbor = input.nextInt();
		}

		switch (izbor) {
		case 1:
			kreiranjeRacuna();
			break;
		case 2:
			transferNovca();
			break;
		case 3:
			ispisRacuna();
			break;
		}
	}

	public static void kreiranjeRacuna() {
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK KREIRANJE RACUNA   ");
		Racun racun = new Racun();
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = input.nextInt();

		while (brojRacuna < 0) {
			System.out.println("Za kreiranje vaseg ID-a unesite pozitivan broj!");
			brojRacuna = input.nextInt();
		}

		while (!provjeriZauzetost(brojRacuna)) {
			System.out.println("Upisani ID je zauzet. Pokusajte sa novim unosom!");
			brojRacuna = input.nextInt();
		}
		racun.setBrojRacuna(brojRacuna);

		System.out.println("Unesite vase ime:");
		String ime = input.next();
		racun.setImeVlasnika(ime);

		System.out.println("Unesite iznos koji postavljate na racun: ");
		double iznosPostavljanja = input.nextDouble();
		while (iznosPostavljanja <= 0) {
			System.out.println("Iznos novca ne moze biti negativan. Unesite pozitivan iznos.");
			iznosPostavljanja = input.nextDouble();
		}
		racun.dodajNovac(iznosPostavljanja);

		racuni.add(Racun.getbrojRacunaUkupno() - 1, racun);
		System.out.println("Racun je uspjesno kreiran.");
		System.out.println("Broj vaseg racuna je: " + racun.getBrojRacuna());
		System.out.println();
		opcije();
	}

	public static void transferNovca() {

		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK ZA TRANSFER NOVCA   ");
		TransferNovca transfer = new TransferNovca();
		System.out.println("Unesite broj racuna sa kog zelite prebaciti novac: ");
		int sourceBroj = input.nextInt();
		transfer.setIzvorniRacun(sourceBroj);

		System.out.println("Unesite broj racuna na koji zelite prebaciti novac: ");
		int targetBroj = input.nextInt();
		transfer.setTargetRacun(targetBroj);

		System.out.println("Unesite iznos novca koji zelite postaviti: ");
		double novacZaPolog = input.nextDouble();
		while (novacZaPolog <= 0) {
			System.out.println("Ne mozete unositi negativan iznos ili iznos jednak 0!! Pokusajte ponovo");
			novacZaPolog = input.nextDouble();
		}

		transfer.setIznosZaPrebacivanje(novacZaPolog);

		if (transfer.provjeriValidnost()) {
			transfer.izvrsiTransfer();
			System.out.println("Transfer je uspjesno izvrsen.");
		} else {
			System.out.println("Transfer nije uspjesno izvrsen.");
		}
		opcije();
	}

	public static void ispisRacuna() {
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK ZA ISPIS STANJA TRAZENOG RACUNA   ");
		System.out.println("Unesite broj racuna: ");

		int broj = input.nextInt();

		while (broj < 0) {
			System.out.println("Unesite ispravan unos racuna: ");
			broj = input.nextInt();
		}

		Racun.ispisRacuna(broj);


		opcije();

	}
	
	public static boolean provjeriZauzetost(int ID) {
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).getBrojRacuna() == ID)
				return false;
		}
		return true;

	}

}
