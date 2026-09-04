package Lab4;

public class Product {
	private String name;
	private double price;
	private double tax;

	public Product(String name, double price, double tax) {
		this.name = name;
		this.price = price;
		this.tax = tax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

// Lấy thông tin 
	public void xuatthongtin() {
		System.out.println("Name: " + this.getName());
		System.out.println("Price: " + this.getPrice());
		System.out.println("Tax: " + this.getTax());
	}

// Tính thuế 
	public double getTaxPrice() {
		return this.price * this.tax;
	}

}