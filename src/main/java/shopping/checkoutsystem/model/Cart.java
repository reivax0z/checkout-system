package shopping.checkoutsystem.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

	List<Item> content = new ArrayList<>();
	double totalPriceAfterDiscount;
	int nbItems;

	public List<Item> getContent() {
		return content;
	}

	public void add(Item item) {
		this.content.add(item);
	}

	public void remove(Integer id){
		content.removeIf(p -> id.equals(p.getId()));
	}

	public int getNbItems() {
		return nbItems;
	}

	public void setNbItems(int nbItems) {
		this.nbItems = nbItems;
	}

	public double getTotalPriceAfterDiscount() {
		return totalPriceAfterDiscount;
	}

	public void setTotalPriceAfterDiscount(double totalPriceAfterDiscount) {
		this.totalPriceAfterDiscount = totalPriceAfterDiscount;
	}
}
