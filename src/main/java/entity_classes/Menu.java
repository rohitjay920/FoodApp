
package entity_classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_menu_seq")
	@SequenceGenerator(name = "my_menu_seq", initialValue = 100, allocationSize = 1)
	private int id;
	
	@OneToMany(mappedBy = "menu")
	private List<FoodProduct> foodProducts;
	
	@OneToOne 
	@JoinColumn
	private User user;
	
	
}
