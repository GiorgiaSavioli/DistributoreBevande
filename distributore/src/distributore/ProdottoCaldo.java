package distributore;

public class ProdottoCaldo  extends Prodotti {
	
	public ProdottoCaldo(String nome, int codice, double prezzo, int quantita, boolean caldo) {
		super(nome, codice, prezzo, quantita, true);
		
	}
}