package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date date;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date date) {
		super(name, price);
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String priceTag() {
		return name + " (used) $ " + price + " (Manufacture date: " + sdf.format(date) + ")";
	}
}
