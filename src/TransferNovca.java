
package Bankomat;


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
		return false;
	}

	public void izvrsiTransfer() {
		for (int i = 0; i < racuni.size(); i++) {

			if (racuni.get(i).getBrojRacuna() == izvorniRacun)
				racuni.get(i).trenutnoStanjeRacuna -= iznosZaPrebacivanje;

			if (racuni.get(i).getBrojRacuna() == targetRacun)
				racuni.get(i).trenutnoStanjeRacuna += iznosZaPrebacivanje;
		}

	}

}
