package distributore;

import java.util.ArrayList;

public class Distributore {

	private double totaleIncassi;
	private int zucchero;
	private int codiceID = 1;
	private static ArrayList<Prodotti> prodotti = new ArrayList<Prodotti>(); // lista dei prodotti che contiene il
																				// distributore
	

	public Distributore() {
		this.zucchero = 50;
		this.totaleIncassi = 0;
	}

	public ArrayList<Prodotti> getProdotti() {
		return prodotti;
	}


	public int getID() {
		return codiceID;
	}
	
	public int setID() {
		return codiceID++;
	}
	
	public void create() {
		
		Gestore gestore = new Gestore();
		String[][] beveragesHot = { { "Soda", "1.50" }, { "Juice", "2.00" }, { "Water", "1.00" },
				{ "Iced Tea", "1.75" }, { "Lemonade", "2.25" }, { "Energy Drink", "3.00" }, { "Smoothie", "3.50" } };

		String[][] beveragesCold = { { "Coffee", "2.50" }, { "Hot Chocolate", "2.75" }, { "Tea", "1.25" } };

		for (String[] beverage : beveragesHot) {
			gestore.aggiungiProdotto(beverage[0], setID(), Double.parseDouble(beverage[1]),
					((int) (Math.random() * 15 + 10)), false);
		}
		for (String[] beverage : beveragesCold) {
			gestore.aggiungiProdotto(beverage[0], setID(), Double.parseDouble(beverage[1]),
					((int) (Math.random() * 15 + 15)), true);
		}
	}

	static boolean verificaDisponibilitaProdotto(int id) {

		boolean disponibilita = false;

		for (int i = 0; i < prodotti.size(); i++) {

			if (prodotti.get(i).getCodice() == id && prodotti.get(i).getQuantita() > 0) {
				disponibilita = true;
			}
		}
		return disponibilita;
	}

	static boolean verificaDenaro(int id, double denaro) {

		boolean disponibilita = false;

		for (int i = 0; i < prodotti.size(); i++) {

			if (prodotti.get(i).getCodice() == id && prodotti.get(i).getPrezzo() <= denaro) {
				disponibilita = true;
			}
		}
		return disponibilita;
	}

	static double verificaResto(double prezzo, double denaro) {
		return denaro - prezzo;

	}

	static Prodotti getProdotti(int id) {

		int a = 0;
		for (int i = 0; i < prodotti.size(); i++) {
			if (prodotti.get(i).getCodice() == id) {
				a = i;
			}
		}
		return prodotti.get(a);
	}
	
	public void aggiornaQuantVenduta(int scelta) {
		
		for (int i = 0; i < prodotti.size(); i++) {

			if (prodotti.get(i).getCodice() == scelta) {
				prodotti.get(i).unitaVenduti++;
				setTotaleIncassi(prodotti.get(i).getPrezzo());
			}

		}
	}
	
	public void mostraVenduti() {
		boolean venduto = false;
		for (int i = 0; i < prodotti.size(); i++) {
			if (prodotti.get(i).unitaVenduti > 0) {
				System.out.println(prodotti.get(i).getNome()+" quantita venduto: " +prodotti.get(i).unitaVenduti);
				venduto = true;
			}
		}
		if(!venduto)System.out.println("Non e stato venduto nessun prodotto\n");
	}
	
	private void setTotaleIncassi(double prezzoProdotto) {
		totaleIncassi+=prezzoProdotto;
	}
	
	public double getTotaleIncassi() {
		return totaleIncassi;
	}
	
	public void setZucchero(int zucchero) {
		this.zucchero = zucchero;
	}
	
	public int getZucchero() {
		return zucchero;
	}
}