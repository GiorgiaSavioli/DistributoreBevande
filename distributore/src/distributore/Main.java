package distributore;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int codiceID = 1;
		Scanner scan = new Scanner(System.in);
		Distributore distributore = new Distributore();

		Gestore gestore = new Gestore();

		String[][] beveragesHot = { { "Soda", "1.50" }, { "Juice", "2.00" }, { "Water", "1.00" },
				{ "Iced Tea", "1.75" }, { "Lemonade", "2.25" }, { "Energy Drink", "3.00" }, { "Smoothie", "3.50" } };

		String[][] beveragesCold = { { "Coffee", "2.50" }, { "Hot Chocolate", "2.75" }, { "Tea", "1.25" } };

		for (String[] beverage : beveragesHot) {
			gestore.aggiungiProdotto(beverage[0], codiceID, Double.parseDouble(beverage[1]),
					((int) (Math.random() * 15 + 10)), false);
			codiceID++;
		}
		for (String[] beverage : beveragesCold) {
			gestore.aggiungiProdotto(beverage[0], codiceID, Double.parseDouble(beverage[1]),
					((int) (Math.random() * 15 + 15)), true);
			codiceID++;
		}

		System.out.println("BENVENUTO!");

		gestore.visualizzaProdotti();

		while (true) {
			System.out.println("Inserisci il codice del prodotto che vuoi acquistare.");
			
			int scelta = scan.nextInt();
			
			
//			FUNZIONALITA GESTORE 1. AGGIUNGERE PRODOTTO 2. RIMUOVERE PRODOTTO 3. CAMBIARE
//			 * QUANTITA PRODOTTO ESISTENTE 4. CAMBIARE PREZZO DI UN PRODOTTO 5. MOSTRA
//			 * STATISTICHE: 1. TOTALE INCASSO, 2. ELENCO PRODOTTI ACQUISTATI CON QUANTITA
			
			if(scelta==1234) {
				System.out.println("1. Aggiungere prodotto\n2. Rimuovere prodotto \n3. Cambiare quantita prodotto esistente.\n4. Cambiare prezzo di un prodotto \nStatisctiche\n5. Totale incasso 6. Quantità acquistati 0. Esci dal programma");
				int operazione = scan.nextInt();
				switch(operazione) {
				case 1:
					System.out.println("Inserisci nome prodotto");
					String nome = scan.next();
					
					System.out.println("Inserisci prezzo prodotto");
					double prezzo = scan.nextDouble();
					
					System.out.println("Inserisci quantità prodotto");
					int quantita = scan.nextInt();
					
					System.out.println("Inserisci 1 se il prodotto e caldo, 2 se il prodotto e freddo");
					int caldo = scan.nextInt();
					Boolean caldissimo = true;
					if(caldo==1) {
						gestore.aggiungiProdotto(nome, codiceID, prezzo, quantita, caldissimo);
						System.out.println("Prodotto " +nome+" aggiunto con successo.");
						
					}else if(caldo==2) {
						
					}else {
						System.err.println("Numero errato, inserisci 1 se il prodotto e caldo, 2 se il prodotto e freddo ");
					}
					break;
				case 0:
					gestore.visualizzaProdotti();
//					System.out.println("Inserisci il codice del prodotto che vuoi acquistare.");
					break;
					
					
					
					
				}
				
				
				
			}else {

			if (scelta < 1 || scelta > 10)
				System.out.println("Codice errato, riprovare");

			else {
				double denaro = 0;

				System.out.println("Hai scelto " + distributore.getProdotto(scelta).getNome() + " il prezzo è di "
						+ distributore.getProdotto(scelta).getPrezzo() + " €");

				if (distributore.verificaDisponibilitaProdotto(scelta)) {

					System.out.println("Il prodotto è disponibile, inserisci denaro");
					denaro += scan.nextDouble();
				}
				while (!(distributore.verificaDenaro(scelta, denaro))) {

					System.out.println("Hai inserito: " + denaro);

					System.out.println("Denaro insufficiente, inserire altro. ");
					denaro += scan.nextDouble();
				}

				double resto = distributore.verificaResto(distributore.getProdotto(scelta).getPrezzo(), denaro);

				if (distributore.getProdotto(scelta).getCaldo()) {
					System.out.println("Quante zollette di zucchero vuoi mettere?");
					int zucchero = scan.nextInt();
					if (zucchero > 3 || zucchero < 0)
						zucchero = 3;
					if (distributore.getZucchero() >= zucchero) {
						distributore.setZucchero(distributore.getZucchero() - zucchero);
					}
					System.err.println("Preparazione in corso.\nPreparazione in corso..\nPreparazione in corso...");
					System.out.println("Preparazione completata! Erogazione in corso...");

				}

				if (resto > 0.0) {
					System.out.println("Ritirare il prodotto");
					System.out.println("Erogazione resto: " + resto + "€");
				} else {
					System.out.println("Ritirare il prodotto");
				}
				System.out.println("\nArrivederci!");
				gestore.visualizzaProdotti();
				distributore.aggiornaQuantVenduta(scelta);

//			for(Prodotto pr :distributore.getProdotti()) {
//				System.out.println(pr.unitaVenduti);
//			}

//				gestore.visualizzaProdotti();

//				System.out.println(distributore.getZucchero());
			}
			}

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