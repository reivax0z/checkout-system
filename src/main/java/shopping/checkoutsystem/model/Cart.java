package shopping.checkoutsystem.model;

import org.springframework.stereotype.Component;
import shopping.checkoutsystem.util.NonRecognizedItemException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static shopping.checkoutsystem.util.Constants.*;

@Component
public class Cart {

	List<Item> content = new ArrayList<>();
	double totalPriceBeforeDiscount;
	double totalPriceAfterDiscount;

	public List<Item> getContent() {
		return content;
	}

	public void add(Item content) {
		this.content.add(content);
	}

	public double getTotalPriceBeforeDiscount() {
		return totalPriceBeforeDiscount;
	}

	public void setTotalPriceBeforeDiscount(double totalPriceBeforeDiscount) {
		this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
	}

	public double getTotalPriceAfterDiscount() {
		return totalPriceAfterDiscount;
	}

	public void setTotalPriceAfterDiscount(double totalPriceAfterDiscount) {
		this.totalPriceAfterDiscount = totalPriceAfterDiscount;
	}

	public int getElements() {
		return content.size();
	}
}
