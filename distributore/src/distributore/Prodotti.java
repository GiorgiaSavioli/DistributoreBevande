package distributore;

public class Prodotti {
	String nome; //variabili
	int codice;
	double prezzo;
	int quantita;
	boolean caldo;
	int unitaVenduti;
	
	
		//dichiarazione del costruttore 
		public Prodotti (String nome, int codice,double prezzo,int quantita,boolean caldo) {
		this.nome=nome; //this.nome è il nome del prodotto  
		this.codice=codice;
		this.prezzo=prezzo;
		this.caldo=caldo;
		this.quantita=quantita;
		this.unitaVenduti = 0;
		
	}
	
	public String getNome() {   //metodo per prendere il valore del nome
		return nome;
	}

	public void setNome(String nome) {  //metodo per

		this.nome = nome;
	}
	
	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {

		this.codice = codice;
	}
		
	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo ) {

		this.prezzo = prezzo;
	}	
	
	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita ) {  //metodo utilizzato nella modifica della quantità di prodotti dal gestore
		if (quantita < 0) {
	        System.out.println("Errore: la quantità non può essere negativa.");
	    } else {
	        this.quantita = quantita;
	    }
	}
	
		
	public boolean getCaldo() {
		return caldo;
	}

	public void setCaldo(boolean caldo) {

		this.caldo = caldo;
	}
	
}