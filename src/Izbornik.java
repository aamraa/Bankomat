
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Izbornik {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ClassNotFoundException{

		opcije();

	}

	public static void opcije() throws IOException, ClassNotFoundException{
		System.out.println();
		System.out.println("      DOBRODOSLI U GLAVNI IZBORNIK   ");
		System.out.println("   IZABERITE NEKU OD SLJEDECIH OPCIJA: ");
		System.out.println("1. Kreiranje racuna");
		System.out.println("2. Transfer novca");
		System.out.println("3. Ispis racuna");

		int izbor =0;
		
		do {
			try {
				izbor = inputInt();
				
				if(izbor < 1 || izbor >7 )
					throw new InputMismatchException();
				break;
			}
			catch (Exception e) {
				System.out.println("Pogresan izbor. Pokusajte ponovo.");
				input.nextLine();
				continue;
			}
		} while(true);
		
		
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

	public static void kreiranjeRacuna() throws IOException, ClassNotFoundException{
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK KREIRANJE RACUNA   ");
		Racun racun = new Racun();
		
		System.out.println("Unesite broj racuna: ");
		int brojRacuna = provjeriDaLiJeNegativan();


		while (!racun.provjeriZauzetost(brojRacuna)) {
			System.out.println("Upisani ID je zauzet. Pokusajte sa novim unosom!");
			brojRacuna = provjeriDaLiJeNegativan();
		}
	

		System.out.println("Unesite vase ime:");
		String ime = input.next();

		System.out.println("Unesite iznos koji postavljate na racun: ");
		double iznosPostavljanja = provjeriJeLiNegativan();
		while (iznosPostavljanja <= 0) {
			System.out.println("Iznos novca ne moze biti negativan. Unesite pozitivan iznos.");
			iznosPostavljanja = provjeriJeLiNegativan();
		}

		
		ObjectOutputStream objectOutputStream =
	            new ObjectOutputStream(new FileOutputStream("/Users/medn/eclipse-workspace/Bankomat/racuni.txt"));

		racun = new Racun(brojRacuna, ime, iznosPostavljanja);
		

	        objectOutputStream.writeObject(racun);
	        objectOutputStream.close();


	        ObjectInputStream objectInputStream =
	            new ObjectInputStream(new FileInputStream("/Users/medn/eclipse-workspace/Bankomat/racuni.txt"));

	        Racun personRead = (Racun) objectInputStream.readObject();

	        objectInputStream.close();

	        System.out.println(personRead.getImeVlasnika());
	        System.out.println(personRead.getBrojRacuna());
		
		
			
		opcije();
	}

	public static void transferNovca() throws IOException, ClassNotFoundException{

		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK ZA TRANSFER NOVCA   ");
		TransferNovca transfer = new TransferNovca();
		
		System.out.println("Unesite broj racuna sa kog zelite prebaciti novac: ");
		int sourceBroj = provjeriDaLiJeNegativan();
		transfer.setIzvorniRacun(sourceBroj);

		System.out.println("Unesite broj racuna na koji zelite prebaciti novac: ");
		int targetBroj = provjeriDaLiJeNegativan();
		transfer.setTargetRacun(targetBroj);

		System.out.println("Unesite iznos novca koji zelite postaviti: ");
		double novacZaPolog = provjeriJeLiNegativan();
		while (novacZaPolog <= 0) {
			System.out.println("Ne mozete unositi negativan iznos ili iznos jednak 0!! Pokusajte ponovo");
			novacZaPolog = provjeriJeLiNegativan();
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

	public static void ispisRacuna() throws IOException, ClassNotFoundException{
		
		System.out.println();
		System.out.println("   DOBRODOSLI U IZBORNIK ZA ISPIS STANJA TRAZENOG RACUNA   ");
		System.out.println("Unesite broj racuna: ");
		int broj = provjeriDaLiJeNegativan();

		Racun.ispisRacuna(broj);


		opcije();

	}
	
	
	// handle exception za integer brojeve
		public static int inputInt() {
			
			int izbor=0;
			do {
				try {
					 izbor = input.nextInt();
					 break;
				} 
				catch (Exception ex) {
					System.out.println("Pogresan unos! Pokusaj ponovo: ");
					input.nextLine();
				}
				
			} while (true);	
			return izbor;
		}
		
	// handle exception za double brojeve
		public static double inputDouble() {
					
			double izbor=0;
				do {
						try {
							 izbor = input.nextDouble();
							 break;
						} 
						catch (Exception ex) {
							System.out.println("Pogresan unos! Pokusaj ponovo: ");
							input.nextLine();
						}
						
					} while (true);	
					return izbor;
				}
		
		// handle exception za negativne integer brojeve
				public static int provjeriDaLiJeNegativan() {
							
					int izbor =0;
					
					do {
						try {
							izbor = inputInt();
							
							if(izbor < 0 )
								throw new InputMismatchException();
							break;
						}
						catch (Exception e) {
							System.out.println("Pogresan izbor. Pokusajte ponovo.");
							input.nextLine();
							continue;
						}
					} while(true);
					return izbor;
				}
				
				// handle exception za negativne double brojeve
				public static double provjeriJeLiNegativan() {
							
					double izbor=0.0;
					
					do {
						try {
							izbor = inputDouble();
							
							if(izbor < 0 )
								throw new InputMismatchException();
							break;
						}
						catch (Exception e) {
							System.out.println("Pogresan izbor. Pokusajte ponovo.");
							input.nextLine();
							continue;
						}
					} while(true);
					return izbor;
				}

}

