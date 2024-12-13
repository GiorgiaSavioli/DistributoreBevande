package distributore;

import java.util.Scanner;

import java.util.ArrayList;

public class Gestore {

	// mi creo la lista dei prodotti prodotto è l oggetto
	private ArrayList<Prodotto> prodotti;

	// il costruttore contiene la lista dei prodotti
	public Gestore() {
		prodotti = new ArrayList<>(); //
	}

	// Metodo aggiungi che passa 5 paramentri
	public void aggiungiProdotto(String nome, int codice, double prezzo, int quantita, boolean caldo) {
		// prima di svolgere il for each controlla se il codice contenuto nella lista
		// dei prodotti gia esistenti è uguale a quello inserito se gia è presente esce
		// dal ciclo
		// perche due prodotti non posso avere lo stesso codice (prodotto p corrisponde
		// al singolo prodotto e il prodotto è quello che si sta inserendo)
		for (Prodotto p : prodotti) {
			if (p.getCodice() == (codice)) {
				System.out.println("Errore: il codice prodotto è gia presente.");
				return;
			}
		}
		// controllo se è il prodotto inserito è caldo allora mi richiamo la classe
		// ProdottoCaldo altrimenti freddo.
		if (caldo) {
			prodotti.add(new ProdottoCaldo(nome, codice, prezzo, quantita, caldo));
		} else {
			prodotti.add(new ProdottoFreddo(nome, codice, prezzo, quantita, caldo));

		}

	}
	
	public void visualizzaProdotti() {
		if (prodotti.isEmpty()) {// 
			// controlla se la lista di prodotti  è vuota allora stampa un mexx che non ci sono
			// prodotti nel distributore
			System.out.println("Non ci sono prodotti nel distributore.");
		} else {// altrimenti si stampa la lista dei prodotti contenuti
			System.out.println("\nElenco dei prodotti:");
			for (Prodotto p : prodotti) {
				System.out.println(p);
				// e poi si fa un for each per stampare tutto l elenco dei prodotti presenti
				// nel distributore
			}
		}
	}
	public void rimuoviProdotto(int codice) {  // metodo che accetta in ingresso il codice del prodotto
	    for (int i = 0; i < prodotti.size(); i++) { //si fa un for con indice  in base alla size della lista prodotti
	        Prodotto p = prodotti.get(i); // si Ottiene l'elemento dell'indice corrente
	        if (p.getCodice() == codice) {// si fa il controllo sul codice 
	            prodotti.remove(i); // Rimuovi il prodotto dall'elenco in base all inidice 
	            System.out.println("Prodotto con codice " + codice + " rimosso.");
	            return; // Esci dal metodo dopo aver rimosso l'elemento
	        }
	    }

	    // Se non trova il prodotto
	    System.out.println("Prodotto con codice " + codice + " non trovato.");
	}
	public void modificaquantita(int quantita, int codice) {
	    // Ciclo attraverso la lista dei prodotti in base alla size della lista
	    for (int i = 0; i < prodotti.size(); i++) { 
	        // Verifico se il codice del prodotto corrente(in base all indice) corrisponde al codice passato come parametro
	        if (prodotti.get(i).getCodice() == codice) { //richiama il prodotto in base all indice  e lo controlla con quello inserito nel parametro
	            // Se trovato, aggiorno la quantità del prodotto
	            prodotti.get(i).setQuantita(quantita); //richiama il prodotto in base all indice e a ggiorna la quantita
	     
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
	    for (int i = 0; i < prodotti.size(); i++) { 
	        // Verifico se il codice del prodotto corrente(in base all indice) corrisponde al codice passato come parametro
	        if (prodotti.get(i).getCodice() == codice) { //richiama il prodotto in base all indice  e lo controlla con quello inserito nel parametro
	            // Se trovato, aggiorno il prezzo del prodotto
	            prodotti.get(i).setPrezzo(prezzo); //richiama il prodotto in base all indice e a ggiorna il prezzo
	            
	            System.out.println("Il prezzo del prodotto con codice " + codice + " è stato aggiornato ");
	            return; // Esco dal metodo dopo aver aggiornato
	        }
	    }
	    // Se non trovo il prodotto con il codice dato, posso stampare un messaggio
	    System.out.println("Prodotto con codice " + codice + " non trovato.");
	}

}