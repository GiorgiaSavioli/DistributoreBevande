package distributore;

import java.util.ArrayList;

public class Products {

	private static int profit = 0;

	private static ArrayList<Products> quantitySold = new ArrayList<Products>();

	private static ArrayList<Products> products = new ArrayList<Products>();

	String nome;
	double prezzo;
	int pezzi;
	int identificatore;
	private static int contatore = 1; // contatore che serve alla generazione del ID
	
	
	private static int createID() { // metodo per creare l'ID
		return (contatore++);
	}
	
	public Products(String nome, double prezzo, int pezzi) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.pezzi = pezzi;
        this.identificatore = createID();
	}
	
	public Products(String nome, int pezzi) {
        this.nome = nome;
        this.pezzi = pezzi;
	}
	
	public Products() {
        this.nome = nome;
        this.pezzi = pezzi; 
	}
	
	public void addProductsToArray() {
		products.add(soda);
		products.add(juice);
		products.add(water);
		products.add(icedTea);
		products.add(lemonade);
		products.add(coffee);
		products.add(hotChocolate);
		products.add(tea);
		products.add(energyDrink);
		products.add(smoothie);
	}
	
	
	
	static	Products soda = new Products("Soda", 1.50, 15);
	static	Products juice = new Products("Juice", 2.00, 12);
	static	Products water = new Products("Water", 1.00, 18);
	static	Products icedTea = new Products("Iced Tea", 1.75, 14);
	static	Products lemonade = new Products("Lemonade", 2.25, 16);
	static	Products coffee = new Products("Coffee", 2.50, 13);
	static	Products hotChocolate = new Products("Hot Chocolate", 2.75, 17);
	static	Products tea = new Products("Tea", 1.25, 19);
	static	Products energyDrink = new Products("Energy Drink", 3.00, 11);
	static	Products smoothie = new Products("Smoothie", 3.50, 10); 

	public static boolean verifyProductAvailability(int id) {
		for (Products product : products) {
			if (product.identificatore == id && product.pezzi > 0) {
			return true;
			}
		}return false;

	}
	
	public static void main(String[] args) {
				 
		getProducts();
		
	
//		for (String[] beverage : beverages) {
//			products.add(beverage);
//			quantitySold.add(new String[] { beverage[0], "0" });
//
//		}

//		removeProduct("Water");
//		
//		String newAd[] = {"Garbage", "€2", "15"};
//		
//		addProduct(newAd);

//		for (String[] yes : products) {
//			System.out.println(Arrays.toString(yes));
//		}

	}

 /*	private static void addProduct(String[] prod) {

		products.add(prod);

		quantitySold.add(new String[] { prod[0], "0" });
	}

	private static void removeProduct(String prod) {

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i)[0].equals(prod)) {

				products.remove(i);
			}
		}
	}

	private static void changeProductQuantity(String prod, int quantity) {

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i)[0].equals(prod)) {

				products.get(i)[2] = String.valueOf(quantity);
			}
		}
	}

	private static void changeProductPrice(String prod, int price) {

		for (int i = 0; i < products.size(); i++) {

			if (products.get(i)[0].equals(prod)) {

				products.get(i)[1] = String.valueOf(price);
			}

		}
	}
*/
	public static void getProducts() {
			for (Products beverage : products) {
				quantitySold.add(new Products (beverage.nome, 0));
			System.out.println(beverage.identificatore +". "+beverage.nome + " " + beverage.prezzo + "€");
			}
	}
	
	

	private static void updateProfit(int prod) {
		profit += prod;
	}
	/*
	private static void getProfit() {
		System.out.println("L'incasso totale e: " + profit);

	}

	private static void updateQuantitySold(String[] array) {
		for (int i = 0; i < quantitySold.size(); i++) {
			if (array[0].equals(quantitySold.get(i)[0]))
				;
			quantitySold.get(i)[1] += 1;
		}

	}

	private static void getQuantitySold() {
		for (int i = 0; i < quantitySold.size(); i++) {

			System.out.println(quantitySold.get(i));
		}
	}

//	static void verifyProductAvailability(String product) {
//		for (int i = 0; i < products.size(); i++) {
//
//			if (products.get(i)[0].equals(product)) {
//				int quantity = Integer.parseInt(products.get(i)[2]);
//				if(quantity>0)
//			}
//		}
//	}

//	 5. MOSTRA STATISTICHE: 1. TOTALE INCASSO, 2. ELENCO PRODOTTI ACQUISTATI CON QUANTITA
*/
}
	
	