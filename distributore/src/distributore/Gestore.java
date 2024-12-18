package distributore;

public class Gestore {

	private Distributore distributore= new Distributore();
	public void aggiungiProdotto(String nome, int codice, double prezzo, int quantita, boolean caldo) {
		if (caldo) {
			distributore.getProdotti().add(new ProdottoCaldo(nome, codice, prezzo, quantita, caldo));
		} else {
			distributore.getProdotti().add(new ProdottoFreddo(nome, codice, prezzo, quantita, caldo));

		}

	}
	
	public void visualizzaProdotti() {
		if (distributore.getProdotti().isEmpty()) {// 
			System.out.println("Non ci sono prodotti nel distributore.");
		} else {
			System.out.println("\nElenco dei prodotti:");
			for (Prodotti p : distributore.getProdotti()) {
			System.out.println(p.getCodice()+". "+p.getNome() +" " +p.getPrezzo()+" €");
			}
			
		}
	}
	
	public void rimuoviProdotto(int codice) {  
	    for (int i = 0; i < distributore.getProdotti().size(); i++) { 
	    	Prodotti p = distributore.getProdotti().get(i); 
	        if (p.getCodice() == codice) {
	        	distributore.getProdotti().remove(i); 
	            System.out.println("Prodotto con codice " + codice + " rimosso.");
	            return; 
	        }
	    }
	    System.out.println("Prodotto con codice " + codice + " non trovato.");
	}
	public void modificaQuantita(int quantita, int codice) {
	    
	    for (int i = 0; i < distributore.getProdotti().size(); i++) { 
	        
	        if (distributore.getProdotti().get(i).getCodice() == codice) { 	       
	        	distributore.getProdotti().get(i).setQuantita(distributore.getProdotti().get(i).getQuantita()+quantita);	     
	            System.out.println("Quantità aggiornata per il prodotto con codice: " + codice);
	            return; 
	        }
	    }
	    System.out.println("Prodotto con codice " + codice + " non trovato.");
	}

	public void modificaPrezzo(double prezzo, int codice) {
		if (prezzo < 0) {
	        System.out.println("Errore: il prezzo non può essere negativo.");
	        return;
	    }
	    for (int i = 0; i < distributore.getProdotti().size(); i++) { 
	       
	        if (distributore.getProdotti().get(i).getCodice() == codice) { 
	           
	        	distributore.getProdotti().get(i).setPrezzo(prezzo); 
	            
	            System.out.println("Il prezzo del prodotto con codice " + codice + " è stato aggiornato ");
	            return; 
	        }
	    }
	    System.out.println("Prodotto con codice " + codice + " non trovato.");
	}

}