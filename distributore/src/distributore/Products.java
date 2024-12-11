package distributore;

import java.util.ArrayList;
import java.util.Arrays;

public class Products {

	private static int profit = 0;

	private static ArrayList<String[]> quantitySold = new ArrayList<String[]>();

	private static ArrayList<String[]> products = new ArrayList<String[]>();

	private static String[][] beverages = { { "Soda", "€1.50", "15" }, { "Juice", "€2.00", "12" },
			{ "Water", "€1.00", "18" }, { "Iced Tea", "€1.75", "14" }, { "Lemonade", "€2.25", "16" },
			{ "Coffee", "€2.50", "13" }, { "Hot Chocolate", "€2.75", "17" }, { "Tea", "€1.25", "19" },
			{ "Energy Drink", "€3.00", "11" }, { "Smoothie", "€3.50", "10" } };

	public static void main(String[] args) {

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

	private static void addProduct(String[] prod) {

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

	public static ArrayList<String[]> getProducts() {
		int i = 1;
			for (String[] beverage : beverages) {
				products.add(beverage);
				quantitySold.add(new String[] { beverage[0], "0" });
			System.out.println(i+". "+beverage[0]+ " price " +beverage[1]);
			i++;
		}
		return products;
	}

	private static void updateProfit(int prod) {
		profit += prod;
	}

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

}