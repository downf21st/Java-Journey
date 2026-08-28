package helloWorld;

import java.util.Scanner;

public class Bai01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Tên sinh viên : ");
		String name = scanner.nextLine();

		System.out.println("Điểm : ");
		int point = scanner.nextInt();

		System.out.println(name + " có điểm = " + point);

		scanner.close();
	}

}
