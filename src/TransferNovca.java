package Bankomat;
//Incijlaizirati metode od getIzvorniRacun do setIznosZaPrebacivanje

//ukljucujuci i navedene dvije za TransferNovca klasu.

public class TransferNovca extends Racun {

	private int izvorniRacun;
	private int targetRacun;
	private double iznosZaPrebacivanje;

	public TransferNovca() {

	}

	public int getIzvorniRacun() {
		return izvorniRacun;
		;
	}

	public void setIzvorniRacun(int izvorniRacun) {
		this.izvorniRacun = izvorniRacun;

	}

	public int getTargetRacun() {
		return targetRacun;
	}

	public void setTargetRacun(int targetRacun) {
		this.targetRacun = targetRacun;
	}

	public double getIznosZaPrebacivanje() {
		return iznosZaPrebacivanje;
		;
	}

	public void setIznosZaPrebacivanje(double iznosZaPrebacivanje) {
		this.iznosZaPrebacivanje = iznosZaPrebacivanje;
		
	}

	public boolean provjeriValidnost() {

	}

	public void izvrsiTransfer() {

	}

}
