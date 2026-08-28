package helloWorld;

import java.util.Scanner;

public class Bai03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập cạnh : ");
		int canh = scanner.nextInt();

		double thetich = Math.pow(canh, 3);

		System.out.println("Thể tích khối lập phương là : " + thetich);
		scanner.close();
	}

}
