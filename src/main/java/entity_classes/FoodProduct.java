package entity_classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FoodProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_food_product")
	@SequenceGenerator(name="my_food_product",initialValue=1,allocationSize=1)
	private int id;
	
	private String name;
	private String type;
	private String about;
	private boolean availability;
	private double price;
	
	@ManyToOne
	@JoinColumn
	private Menu menu;
}
