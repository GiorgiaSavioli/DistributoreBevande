package distributore;

public class ProdottoFreddo extends Prodotto{

	
	//Costruttore e 5 parametri
	public ProdottoFreddo(String nome, int codice, double prezzo, int quantita, boolean caldo) {
		super(nome, codice, prezzo, quantita, false);  //valore 
		//super serve per richiamare la classe prodotto
	}
    public void isCold () {//metodo     
    	System.out.println(codice+ " " + nome +": è stato raffreddato. " );
    	
    }
 
}

