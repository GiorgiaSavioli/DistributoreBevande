package distributore;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//ci richiamiamo sia la classe distributore e gestore 
		Scanner scan = new Scanner(System.in);
		Distributore distributore = new Distributore();
		Gestore gestore = new Gestore();

		System.out.println("BENVENUTO!");

		distributore.create(); // richiamo metodo della classe distributore per inserire i prodotti

		while (true) {
			gestore.visualizzaProdotti();// mi stampo tt i prodotti disp
			System.out.println("\nInserisci il codice del prodotto che vuoi acquistare.");

			int scelta = scan.nextInt();
//verifico se la scelta=1234 si tratta del gestore che puo svolgere le opzioni
			if (scelta == 1234) {
				boolean continua = true;
				while (continua) {

					System.out.println(
							"1. Aggiungere prodotto\n2. Rimuovere prodotto \n3. Cambiare quantita prodotto esistente.\n4. Cambiare prezzo di un prodotto \n5. Totale incasso \n6. Quantità acquistati \n7. Visualizza elenco prodotti \n0. Esci dal programma");
					int operazione = scan.nextInt();
					switch (operazione) {
					case 1:
//						scan.nextLine();
						System.out.println("Inserisci nome prodotto");
						String nome = scan.next();

						System.out.println("Inserisci prezzo prodotto");
						double prezzo = scan.nextDouble();

						System.out.println("Inserisci quantità prodotto");
						int quantita = scan.nextInt();

						System.out.println("Inserisci 1 se il prodotto e caldo, 2 se il prodotto e freddo");
						int caldo = scan.nextInt();
						if (caldo == 1) {
							gestore.aggiungiProdotto(nome, distributore.setID(), prezzo, quantita, true);
							System.out.println("Prodotto " + nome + " aggiunto con successo.");

						} else if (caldo == 2) {
							gestore.aggiungiProdotto(nome, distributore.setID(), prezzo, quantita, false);
							System.out.println("Prodotto " + nome + " aggiunto con successo.");

						} else {
							System.err.println(
									"Numero errato, inserisci 1 se il prodotto e caldo, 2 se il prodotto e freddo ");
						}
						break;
					case 2:
						System.out.println("Inserisci ID del prodotto");
						int id = scan.nextInt();
						gestore.rimuoviProdotto(id);// per rimuovere un prodotto bisogna inserire il codice
						break;
					case 3:
						System.out.println("Inserisci ID del prodotto");
						id = scan.nextInt();
						System.out.println("Inserisci quantita prodotto");
						int quant = scan.nextInt();
						gestore.modificaQuantita(quant, id); // per modificare la quantita inserire il codice e la nuova
																// quantita
						break;
					case 4:
						System.out.println("Inserisci ID del prodotto");
						id = scan.nextInt();
						System.out.println("Inserisci nuovo prezzo del prodotto");
						double nuovoPrezzo = scan.nextDouble();
						gestore.modificaPrezzo(nuovoPrezzo, id);
						break;
					case 5:// per mostrare l incasso totale ci richiamiamo il metodo getotaleincassi
						System.out.println("Incasso totale: " + distributore.getTotaleIncassi() + "€\n");
						break;
					case 6:
						distributore.mostraVenduti();
						System.out.println();
						break;
					case 7:
						gestore.visualizzaProdotti();
						System.out.println();
						break;
					case 0:// altrimenti 0 per uscire
						continua = false;
						break;
					default:
						continue;
					}
				}

			} else {
				// se il codice inserito è negativo o magg della size della lista
				if (scelta < 1 || scelta > distributore.getProdotti().size())
					System.out.println("Codice errato, riprovare");

				else {
					double denaro = 0;// istanziamo una variabile denaro
					// stampiamo il prodotto scelto con il relativo prezzo
					System.out.println("Hai scelto " + distributore.getProdotto(scelta).getNome() + " il prezzo è di "
							+ distributore.getProdotto(scelta).getPrezzo() + " €");
					// controlliamo se il prodotto è disp
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
					// se è stato scelto un prodotto caldo viene richiesto quanto zucchero inserire
					if (distributore.getProdotto(scelta).getCaldo()) {
						System.out.println("Quante ZOLLETTE di zucchero vuoi mettere?");
						int zucchero = scan.nextInt();
						if (zucchero > 3 || zucchero < 0)// min 0 e max3
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
					distributore.aggiornaQuantVenduta(scelta);

				}
			}
		}
	}
}