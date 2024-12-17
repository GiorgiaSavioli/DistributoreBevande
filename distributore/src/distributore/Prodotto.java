package distributore;

public class Prodotto {
	String nome; //attributi
	int codice;
	double prezzo;
	int quantita;
	boolean caldo;
	int unitaVenduti;
	//costruttore con 5 parametri
	public Prodotto (String nome, int codice,double prezzo,int quantita,boolean caldo) {
		this.nome=nome; //this.nome è il nome del prodotto  
		this.codice=codice;
		this.prezzo=prezzo;
		this.caldo=caldo;
		this.quantita=quantita;
		this.unitaVenduti = 0;
		
	}
	
	public String getNome() { // nel get come return si deve inserire il tipo di variabile ad esempio nome è una stringa
		return nome;
	}

	public void setNome(String nome) {//vuole come parametro il nome 

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
// Metodoset in cui settiamo la quantita e controlliamo che sia maggiore di 0
	public void setQuantita(int quantita ) {
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
