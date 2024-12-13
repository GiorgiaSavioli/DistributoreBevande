package distributore;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int c = 1;
		Scanner scan = new Scanner(System.in);
		Distributore distributore = new Distributore();

		Gestore gestore = new Gestore();

		String[][] beverages = { { "Soda", "1.50", "" }, { "Juice", "2.00", "12" }, { "Water", "1.00", "18" },
				{ "Iced Tea", "1.75", "14" }, { "Lemonade", "2.25", "16" }, { "Coffee", "2.50", "13" },
				{ "Hot Chocolate", "2.75", "17" }, { "Tea", "1.25", "19" }, { "Energy Drink", "3.00", "11" },
				{ "Smoothie", "3.50", "10" } };

		for (String[] beverage : beverages) {
			gestore.aggiungiProdotto(beverage[0], c, Double.parseDouble(beverage[1]), 5, true);
			c++;
		}

		System.out.println("BENVENUTO! Inserisci il codice del prodotto che vuoi acquistare. ");

		gestore.visualizzaProdotti();

		while (true) {
			int scelta = scan.nextInt();
			double denaro = 0;
			
			System.out.println("Hai scelto "+ distributore.getProdotto(scelta).getNome() +" il prezzo è di " + distributore.getProdotto(scelta).getPrezzo() + " €");

			if (distributore.verificaDisponibilitaProdotto(scelta)) {

				System.out.println("Il prodotto è disponibile, inserisci denaro");
				denaro += scan.nextDouble();
			}
			while (!(distributore.verificaDenaro(scelta, denaro))) {

				System.out.println("Hai inserito: " + denaro);

				System.out.println("Denaro insufficiente, inserire altro. ");
				denaro += scan.nextDouble();
			}
			System.out.println(denaro);

		}

		
		
		
		
		// questo sara il posto dove andro a implementare i scanner per la interazione
		// con la interfaccia del distributore

		// HOW WILL IT WORK

		/*
		 * 1. STAMPA BENVENUTO 2. STAMPA LISTA CON NUMERI E PRODOTTI CHE CORRISPONDONO
		 * 3. SE NUMERO CORRETTO VAI AVANTI, SE NO STAMPA PRODOTTO NON DISPONIBILE/NON
		 * ESISTENTE. RIPROVA 4. VERIFICA SE IL NUMERO INSERITO E GESTORE 5. VERIFICA
		 * DISPONIBILITA PRODOTTO 6. VERIFICA SE CALDO O FREDDO 7. SE CALDO, CHIEDERE DI
		 * SELEZIONARE QUANTITA ZUCCHERO 8. INSERIRE MONETA 9. IN QUALSIASI MOMENTO
		 * CLICCANDO 0 SI PUO USCIRE DAL PROGRAMMA E TORNARE ALLA SCHERMATA INIZIALE 10.
		 * PRODOTTO CONFERMATO, EROGAZIONE, RITIRA PRODOTTO 11. CONTROLLO SE CE RESTO DA
		 * DARE
		 * 
		 * 
		 * FUNZIONALITA GESTORE 1. AGGIUNGERE PRODOTTO 2. RIMUOVERE PRODOTTO 3. CAMBIARE
		 * QUANTITA PRODOTTO ESISTENTE 4. CAMBIARE PREZZO DI UN PRODOTTO 5. MOSTRA
		 * STATISTICHE: 1. TOTALE INCASSO, 2. ELENCO PRODOTTI ACQUISTATI CON QUANTITA
		 * 
		 * 
		 */

	}

}