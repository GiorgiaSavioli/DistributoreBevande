package distributore;

import java.util.ArrayList;

public class Distributore {

	private double totaleIncassi;
	private int zucchero;
	private ArrayList<Prodotto> prodottiVenduti;
	private static ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>(); // lista dei prodotti che contiene il
																				// distributore

	public Distributore() {
		this.zucchero = 50;
		this.totaleIncassi = 0;
		this.prodottiVenduti = new ArrayList<Prodotto>();
	}

	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}

	public ArrayList<Prodotto> getProdottiVenduti() {
		return prodottiVenduti;
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

	static Prodotto getProdotto(int id) {

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
	
	public void setTotaleIncassi(double prezzoProdotto) {
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
