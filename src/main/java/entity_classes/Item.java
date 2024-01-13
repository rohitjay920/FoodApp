package entity_classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_item")
	@SequenceGenerator(name="my_item",initialValue=1,allocationSize=1)
	
	private int id;
	
	
	private int productId;
	String name;
	String type;
	private int quantity;
	private double price;
}
