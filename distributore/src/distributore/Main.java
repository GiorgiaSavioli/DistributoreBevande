package distributore;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		

		Scanner scan = new Scanner(System.in);
		Distributore distributore = new Distributore();
		Gestore gestore = new Gestore();

		System.out.println("BENVENUTO!");

		distributore.create();

		while (true) {
			distributore.visualizzaProdotti(false);
			System.out.println("\nInserisci il codice del prodotto che vuoi acquistare.");

			int scelta = scan.nextInt();

			if (scelta == 1234) {
				boolean continua = true;
				while (continua) {

					System.out.println(
							"1. Aggiungere prodotto\n2. Rimuovere prodotto \n3. Cambiare quantita prodotto esistente.\n4. Cambiare prezzo di un prodotto \n5. Totale incasso \n6. Quantità acquistati \n7. Visualizza elenco prodotti \n8. Visualizza elenco esauriti \n9. Cambia prezzo di tutti i prodotti(es. -10 cambiera prezzo di tutti i prodotti di -10%)\n0. Esci dal menu gestore");
					int operazione = scan.nextInt();
					switch (operazione) {
					case 1:
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
						gestore.rimuoviProdotto(id);
						break;
					case 3:
						System.out.println("Inserisci ID del prodotto");
						id = scan.nextInt();
						System.out.println("Inserisci quantita prodotto");
						int quant = scan.nextInt();
						gestore.modificaQuantita(quant, id);
						break;
					case 4:
						System.out.println("Inserisci ID del prodotto");
						id = scan.nextInt();
						System.out.println("Inserisci nuovo prezzo del prodotto");
						double nuovoPrezzo = scan.nextDouble();
						gestore.modificaPrezzo(nuovoPrezzo, id, false);
						break;
					case 5:
						System.out.println("Incasso totale: " + distributore.getTotaleIncassi() + "€\n");
						break;
					case 6:
						distributore.mostraVenduti();
						System.out.println();
						break;
					case 7:
						distributore.visualizzaProdotti(true);
						System.out.println();
						break;
					case 8:
						gestore.mostraEsauriti();
						break;
					case 9:
						System.out.println("Inserisci la percentuale di aumento/decremento");
						gestore.modificaPrezzo(scan.nextDouble(), 0, true);
						break;
					case 0:
						continua = false;
						break;
					default:
						System.out.println("Azione errata, riprovare\n");
						continue;
					}
				}

			} else {

				if (scelta < 1 || scelta > distributore.getProdotti().size())
					System.out.println("Codice errato, riprovare");

				else {
					double denaro = 0;

					System.out.println("Hai scelto " + distributore.getProdotto(scelta).getNome() + " il prezzo è di "
							+ distributore.getProdotto(scelta).getPrezzo() + " €");

					if (distributore.verificaDisponibilitaProdotto(scelta)) {

						System.out.println("Il prodotto è disponibile, inserisci denaro");
						denaro = distributore.verificaInput(scan.nextDouble(), denaro);

					}
					while (!(distributore.verificaDenaro(scelta, denaro))) {

						System.out.println("Hai inserito: " + denaro);
						
						System.out.println("Denaro insufficiente, inserire altro. ");

						denaro = distributore.verificaInput(scan.nextDouble(), denaro);
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
					distributore.aggiornaQuantVenduta(scelta);
				}
			}
		}
	}
}