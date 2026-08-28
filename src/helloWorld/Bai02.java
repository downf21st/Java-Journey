package helloWorld;

import java.util.Scanner;

public class Bai02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Cạnh 1 : ");
		int canh1 = scanner.nextInt();

		System.out.println("Cạnh 2 : ");
		int canh2 = scanner.nextInt();

		int chuvi = (canh1 + canh2) * 2;
		int dientich = canh1 * canh2;
		int min = Math.min(canh2, canh1);

		System.out.println("Chu vi là : " + chuvi);
		System.out.println("Diện tích là : " + dientich);
		System.out.println("Cạnh nhỏ nhất : " + min);
		scanner.close();

	}

}
