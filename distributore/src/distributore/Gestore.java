package distributore;

public class Gestore {


	private Distributore distributore = new Distributore();
	
	public void aggiungiProdotto(String nome, int codice, double prezzo, int quantita, boolean caldo) {
	
		if (quantita <= 0) {

		}
		if (caldo) {
			distributore.getProdotti().add(new Prodotto(nome, codice, prezzo, quantita, true));
		} else {
			distributore.getProdotti().add(new Prodotto(nome, codice, prezzo, quantita, false));

		}
	}

	public void rimuoviProdotto(int codice) { 

		for (int i = 0; i < distributore.getProdotti().size(); i++) { 
			Prodotto p = distributore.getProdotti().get(i);
			if (p.getCodice() == codice) {
				distributore.getProdotti().remove(i); 
				System.out.println("Prodotto con codice " + codice + " rimosso.");
				return;
			}

		}
		System.out.println("Prodotto con codice " + codice + " non trovato.\n");
	}

	public void modificaQuantita(int quantita, int codice) {


		for (int i = 0; i < distributore.getProdotti().size(); i++) {


			if (distributore.getProdotti().get(i).getCodice() == codice) {
				
				System.out.println(distributore.getProdotti().get(i).getQuantita());

				int quant = quantita >= 0 ? quantita : 0;
				distributore.getProdotti().get(i).setQuantita(distributore.getProdotti().get(i).getQuantita() + quant); 
				System.out.println(distributore.getProdotti().get(i).getQuantita());
				System.out.println(quantita > 0 ? "Quantità aggiornata per il prodotto con codice: " + codice + "\n"
						: "Hai inserito una quantita non valida\n");
				return; 
			}
		}

		System.out.println("Prodotto con codice " + codice + " non trovato.");
	}

	public void modificaPrezzo(double prezzo, int codice, boolean multiple) {
		if (prezzo < 0 && !multiple) {
			System.out.println("Errore: il prezzo non può essere negativo.");
			return;
		}

		for (int i = 0; i < distributore.getProdotti().size(); i++) {
		
			if (distributore.getProdotti().get(i).getCodice() == codice && !multiple) { 
				distributore.getProdotti().get(i).setPrezzo(prezzo);

				System.out.println("Il prezzo del prodotto con codice " + codice + " è stato aggiornato ");
				return; 
			} else if (multiple) {
				double oldPrezzo = distributore.getProdotti().get(i).getPrezzo();
				double newPrezzo = prezzo > 0 ? prezzo / 100 * oldPrezzo + oldPrezzo: oldPrezzo - Math.abs(prezzo) / 100 * oldPrezzo;
				distributore.getProdotti().get(i).setPrezzo(newPrezzo);
			}
		}

		System.out.println(!multiple?"Prodotto con codice " + codice + " non trovato.":"Prezzo dei prodotti alterato");
	}

	public void mostraEsauriti() {
		System.out.println("Prodotti esauriti: \n");
		for (int i = 0; i < distributore.getProdotti().size(); i++) {
			if (distributore.getProdotti().get(i).getQuantita() == 0) {
				System.out.println(distributore.getProdotti().get(i).getNome());
			}
		}
	}

}