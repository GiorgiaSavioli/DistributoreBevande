package distributore;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
	
	static Scanner s = new Scanner(System.in);
	static int choice;

	public static void main(String[] args) {
		Products prod = new Products();
		System.out.println("BENVENUTO!\nChe prodotto vuoi acquistare?: ");
		prod.getProducts();
		int choice = s.nextInt();
		
		while(true) {
			
			if(choice == 444) {
				System.out.println("Scegli che azione vuoi svolgere: \n1. aggiunge\n2. rimuove \n3. cambia quantita\n4. cambia prezzo\n5. totale incasso\n6. Elenco acquistati\n0. Exit");
			}
			
		}
		
		
		


		
		// questo sara il posto dove andro a implementare i scanner per la interazione con la interfaccia del distributore
		
		//HOW WILL IT WORK
		
		
		
		/*1. STAMPA BENVENUTO
		 * 2. STAMPA LISTA CON NUMERI E PRODOTTI CHE CORRISPONDONO
		 * 3. SE NUMERO CORRETTO VAI AVANTI, SE NO STAMPA PRODOTTO NON DISPONIBILE/NON ESISTENTE. RIPROVA
		 * 4. VERIFICA SE IL NUMERO INSERITO E GESTORE
		 * 5. VERIFICA DISPONIBILITA PRODOTTO
		 * 6. VERIFICA SE CALDO O FREDDO
		 * 7. SE CALDO, CHIEDERE DI SELEZIONARE QUANTITA ZUCCHERO
		 * 8. INSERIRE MONETA
		 * 9. IN QUALSIASI MOMENTO CLICCANDO 0 SI PUO USCIRE DAL PROGRAMMA E TORNARE ALLA SCHERMATA INIZIALE
		 * 10. PRODOTTO CONFERMATO, EROGAZIONE, RITIRA PRODOTTO
		 * 11. CONTROLLO SE CE RESTO DA DARE
		 * 
		 * 
		 * FUNZIONALITA GESTORE
		 * 1. AGGIUNGERE PRODOTTO
		 * 2. RIMUOVERE PRODOTTO
		 * 3. CAMBIARE QUANTITA PRODOTTO ESISTENTE
		 * 4. CAMBIARE PREZZO DI UN PRODOTTO
		 * 5. MOSTRA STATISTICHE: 1. TOTALE INCASSO, 2. ELENCO PRODOTTI ACQUISTATI CON QUANTITA
		 * 
		 * 
		 */

	}

}
