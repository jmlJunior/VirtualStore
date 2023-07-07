package application;

public class Product {
	
	private int code;
	private int quantity;
	
	public Product() {
		
	}

	public Product(int code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
