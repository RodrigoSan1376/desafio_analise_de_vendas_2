package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Map<String, Double> sales = new HashMap<>();

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[2];
				Double total = Double.parseDouble(fields[4]);

				if (sales.containsKey(name)) {
					double totalSoFar = sales.get(name);
					sales.put(name, total + totalSoFar);
				} 
				else {
					sales.put(name, total);
				}

				line = br.readLine();
			}

			System.out.println();
			System.out.println("Total de vendas por vendedor:");
			for (String s : sales.keySet()) {
				System.out.println(s + " - R$ " + String.format("%.2f", sales.get(s)));
			}

		} 
		catch (IOException e) {
			System.out.println("Error" + e.getMessage());
		}

		sc.close();
	}

}
