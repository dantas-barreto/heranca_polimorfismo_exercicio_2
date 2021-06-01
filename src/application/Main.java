package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = teclado.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i): ");
			char ch = teclado.next().charAt(0);
			if (ch == 'c') {
				System.out.print("Name: ");
				teclado.nextLine();
				String name = teclado.nextLine();
				System.out.print("Price: ");
				double price = teclado.nextDouble();
				list.add(new Product(name, price));
			} if (ch == 'u') {
				System.out.print("Name: ");
				teclado.nextLine();
				String name = teclado.nextLine();
				System.out.print("Price: ");
				double price = teclado.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(teclado.next());
				list.add(new UsedProduct(name, price, date));
			} if (ch == 'i') {
				System.out.print("Name: ");
				teclado.nextLine();
				String name = teclado.nextLine();
				System.out.print("Price: ");
				double price = teclado.nextDouble();
				System.out.print("Customs fee: ");
				double customFee = teclado.nextDouble();
				list.add(new ImportedProduct(name, price, customFee));
			}
			
			System.out.println();
			System.out.println("PRICE TAGS:");
			
			for (Product product : list) {
				System.out.println(product.priceTag());
			}
		}
		
		teclado.close();
	}

}
