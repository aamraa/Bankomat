

public class TransferNovca extends Racun {

	private int izvorniRacun;
	private int targetRacun;
	private double iznosZaPrebacivanje;

	public TransferNovca() {

	}

	public int getIzvorniRacun() {
		return 0;
	}

	public void setIzvorniRacun(int izvorniRacun) {
		
	}

	public int getTargetRacun() {
		return 0;
	}

	public void setTargetRacun(int targetRacun) {
		
	}

	public double getIznosZaPrebacivanje() {
		return 0;
	}

	public void setIznosZaPrebacivanje(double iznosZaPrebacivanje) {
		
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