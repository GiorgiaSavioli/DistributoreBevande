package distributore;

import java.util.ArrayList;

public class Distributore {

	private double totaleIncassi;
	private int zucchero;
	private int codiceID = 1;
	private static ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>(); // lista dei prodotti che contiene il
																				// distributore

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

		Gestore gestore = new Gestore(); // dichiaro il gestore
		// mi creo la lista dei prodotti freddi e caldi e con i due for aggiungo al
		// distrutore
		String[][] beveragesCold = { { "Soda", "1.50" }, { "Juice", "2.00" }, { "Water", "1.00" },
				{ "Iced Tea", "1.75" }, { "Lemonade", "2.25" }, { "Energy Drink", "3.00" }, { "Smoothie", "3.50" } };

		String[][] beveragesHot = { { "Coffee", "2.50" }, { "Hot Chocolate", "2.75" }, { "Tea", "1.25" } };

		for (String[] beverage : beveragesHot) {
			gestore.aggiungiProdotto(beverage[0], setID(), Double.parseDouble(beverage[1]),
					((int) (Math.random() * 15 + 10)), true);
		}
		for (String[] beverage : beveragesCold) {
			gestore.aggiungiProdotto(beverage[0], setID(), Double.parseDouble(beverage[1]),
					((int) (Math.random() * 15 + 15)), false);
		}
	}

	// metodo che restituisce un boolean per verificare se il prodotto è disp
	static boolean verificaDisponibilitaProdotto(int id) {

		boolean disponibilita = false;// inizialmente supponiamo che il prodotto non sia disp.

		for (int i = 0; i < prodotti.size(); i++) { // ciclo for in base alla size prodotti
			// controllo se il codice corrisponde a quello id e se la quantita è >0
			if (prodotti.get(i).getCodice() == id && prodotti.get(i).getQuantita() > 0) {// in caso positivo aggiorno il
																							// boolean
				disponibilita = true;
			}
		}
		return disponibilita;
	}

	static boolean verificaDenaro(int id, double denaro) {

		boolean disponibilita = false;

		for (int i = 0; i < prodotti.size(); i++) {
//codice uguale a quello inserito e se il presso è <= del denaro inserito 
			if (prodotti.get(i).getCodice() == id && prodotti.get(i).getPrezzo() <= denaro) {
				disponibilita = true; // aggiorno
			}
		}
		return disponibilita;
	}

	static double verificaResto(double prezzo, double denaro) {
		return denaro - prezzo;

	}

	static Prodotto getProdotto(int id) {
//per recuperare l indice del prodotto con quel codice abbiamo istanziato una variabile intera con valore iniziale 0
		int a = 0;
		for (int i = 0; i < prodotti.size(); i++) {
			if (prodotti.get(i).getCodice() == id) {// codice del prodotto è uguale al id ingresso
				a = i;
			}
		}
		return prodotti.get(a);
	}

	public void aggiornaQuantVenduta(int scelta) {

		for (int i = 0; i < prodotti.size(); i++) {

			if (prodotti.get(i).getCodice() == scelta) {// recupero il codice de prodtto in base all indice e verifico
														// se sia uguale alla scelta
				prodotti.get(i).unitaVenduti++;// in caso positivo aumento le unita vendute
				setTotaleIncassi(prodotti.get(i).getPrezzo()); // e mi richiamo il metodo
			}

		}
	}

	public void mostraVenduti() {
		boolean venduto = false;
		for (int i = 0; i < prodotti.size(); i++) {
			if (prodotti.get(i).unitaVenduti > 0) { // controllo se unita vendute del prodotto sono >0 stampo il nome
													// del prodotto con le unitavend
				System.out.println(prodotti.get(i).getNome() + " quantita venduto: " + prodotti.get(i).unitaVenduti);
				venduto = true;
			}
		}
		if (!venduto)
			System.out.println("Non e stato venduto nessun prodotto\n");
	}

	private void setTotaleIncassi(double prezzoProdotto) {
		totaleIncassi += prezzoProdotto;
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
