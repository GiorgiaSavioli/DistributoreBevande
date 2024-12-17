package distributore;

public class ProdottoCaldo  extends Prodotto{

	//Costruttore e 5 parametri
	public ProdottoCaldo(String nome, int codice, double prezzo, int quantita, boolean caldo) {
		super(nome, codice, prezzo, quantita, true);  //valore 
		//super serve per richiamare la classe prodotto
	}
}
