package entity_classes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FoodOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_food_order")
	@SequenceGenerator(name="my_food_order",initialValue=1,allocationSize=1)
	private int id;
	private String status;
	
	private double totalPrice;
	private LocalDateTime orderCreatedTime;
	private LocalDateTime orderDeliveryTime;
	private String customerName;
	private long contactNumber;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	@OneToMany
	private List<Item> items;
}
