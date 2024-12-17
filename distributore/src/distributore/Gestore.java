package distributore;

public class Gestore {

	// richiamo classe distributore dove abbiamo inserito la lista
	private Distributore distributore = new Distributore();

	// Metodo aggiungi che passa 5 paramentri
	public void aggiungiProdotto(String nome, int codice, double prezzo, int quantita, boolean caldo) {
		// controllo se è il prodotto inserito è caldo allora mi richiamo la
		// classeProdottoCaldo altrimenti freddo.
		if (caldo) {
			distributore.getProdotti().add(new ProdottoCaldo(nome, codice, prezzo, quantita, caldo));
		} else {
			distributore.getProdotti().add(new ProdottoFreddo(nome, codice, prezzo, quantita, caldo));

		}

	}

	public void visualizzaProdotti() {
		if (distributore.getProdotti().isEmpty()) {//
			// controlla se la lista di prodotti è vuota allora stampa un mexx che non ci
			// sono
			// prodotti nel distributore
			System.out.println("Non ci sono prodotti nel distributore.");
		} else {// altrimenti si stampa la lista dei prodotti contenuti
			System.out.println("\nElenco dei prodotti:");
			for (Prodotto p : distributore.getProdotti()) {
				System.out.println(p.getCodice() + ". " + p.getNome() + " " + p.getPrezzo() + " €");
				// si fa un for each per stampare tutto l elenco dei prodotti presenti nel
 				// distributore
			}

		}
	}

	public void rimuoviProdotto(int codice) { // metodo che accetta in ingresso il codice del prodotto
		// si fa un for con indice in base alla size della lista prodotti
		for (int i = 0; i < distributore.getProdotti().size(); i++) {

			Prodotto p = distributore.getProdotti().get(i); // si Ottiene l'elemento dell'indice corrente
			if (p.getCodice() == codice) {// si fa il controllo sul codice
				distributore.getProdotti().remove(i); // Rimuovi il prodotto dall'elenco in base all inidice
				System.out.println("Prodotto con codice " + codice + " rimosso.");
				return; // Esci dal metodo dopo aver rimosso l'elemento
			}
		}

		// Altrimenti non trovato
		System.out.println("Prodotto con codice " + codice + " non trovato.");
	}

	public void modificaQuantita(int quantita, int codice) {
		// Ciclofor che scorre la lista dei prodotti in base alla size
		for (int i = 0; i < distributore.getProdotti().size(); i++) {
			// Verifico se il codice del prodotto corrente(in base all indice) corrisponde
			// al codice passato come parametro
			if (distributore.getProdotti().get(i).getCodice() == codice) { // richiama il prodotto in base all indice e
																			// lo controlla con quello inserito nel
																			// parametro
				// Se trovato, aggiorno la quantità del prodotto
				distributore.getProdotti().get(i)
						.setQuantita(distributore.getProdotti().get(i).getQuantita() + quantita); // richiama il
																									// prodotto in base
																									// all indice e
																									// aggiorna la
																									// quantita

				System.out.println("Quantità aggiornata per il prodotto con codice: " + codice);
				return; // Esco dal metodo dopo aver aggiornato
			}
		}
		// Se non trovo il prodotto con il codice dato, posso stampare un messaggio
		System.out.println("Prodotto con codice " + codice + " non trovato.");
	}

	public void modificaPrezzo(double prezzo, int codice) {
		if (prezzo < 0) {
			System.out.println("Errore: il prezzo non può essere negativo.");
			return;
		}
		// Ciclo attraverso la lista dei prodotti in base alla size della lista
		for (int i = 0; i < distributore.getProdotti().size(); i++) {
			// Verifico se il codice del prodotto corrente(in base all indice) corrisponde
			// al codice passato come parametro
			if (distributore.getProdotti().get(i).getCodice() == codice) { // richiama il prodotto in base all indice e
																			// lo controlla con quello inserito nel
																			// parametro
				// Se trovato, aggiorno il prezzo del prodotto
				distributore.getProdotti().get(i).setPrezzo(prezzo); // richiama il prodotto in base all indice e a
																		// ggiorna il prezzo

				System.out.println("Il prezzo del prodotto con codice " + codice + " è stato aggiornato ");
				return; // Esco dal metodo dopo aver aggiornato
			}
		}
		// Se non trovo il prodotto con il codice dato, posso stampare un messaggio
		System.out.println("Prodotto con codice " + codice + " non trovato.");
	}

}