package distributore;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Distributore {

	private double totaleIncassi;
	private int zucchero;
	private int codiceID = 1;
	private static ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>(); 
	

	public Distributore() {
		this.zucchero = 50;
		this.totaleIncassi = 0;
	}

	public ArrayList<Prodotto> getProdotti() {
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

	static boolean verificaDisponibilitaProdotto(int id, int unita) {

		boolean disponibilita = false;

		for (int i = 0; i < prodotti.size(); i++) {

			if (prodotti.get(i).getCodice() == id && prodotti.get(i).getQuantita() >= unita) {
				disponibilita = true;
			}
		}
		return disponibilita;
	}

	static boolean verificaDenaro(int id, double denaro, int quant) {

		boolean disponibilita = false;

		for (int i = 0; i < prodotti.size(); i++) {

			if (prodotti.get(i).getCodice() == id && prodotti.get(i).getPrezzo()*quant <= denaro && prodotti.get(i).getQuantita()>=quant) {
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
	
	public void aggiornaQuantVenduta(int scelta, int quant) {
		
		for (int i = 0; i < prodotti.size(); i++) {

			if (prodotti.get(i).getCodice() == scelta) {
				prodotti.get(i).unitaVenduti+=quant;
				prodotti.get(i).quantita-=quant;
				setTotaleIncassi(prodotti.get(i).getPrezzo()*quant);
			}

		}
	}
	public void mostraVenduti() {
		boolean venduto = false;
		for (int i = 0; i < prodotti.size(); i++) {
			if (prodotti.get(i).unitaVenduti > 0) {
				System.out.println(prodotti.get(i).getNome()+" - unita vendute: " +prodotti.get(i).unitaVenduti);
				venduto = true;
			}
		}
		if(!venduto)System.out.println("Non e stato venduto nessun prodotto\n");
	}
	
	
	public void visualizzaProdotti(boolean gestore) {
		if (getProdotti().isEmpty()) {// 
			System.out.println("Non ci sono prodotti nel distributore.");
		} else {
			System.out.println("\nElenco dei prodotti:");
			for (Prodotto p : getProdotti()) {
				DecimalFormat df = new DecimalFormat("0.##"); 
			System.out.println(p.getCodice()+". "+p.getNome() +" " +df.format(p.getPrezzo())+" €"+(gestore?" Quantita: "+p.getQuantita():""));

			}
		}
	}
	
	public double verificaInput(double input, double denaro) {
		if(input<=0)return denaro;
		return denaro+input;
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
