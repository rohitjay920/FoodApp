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
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_branch")
	@SequenceGenerator(name="my_branch",initialValue=1,allocationSize=1)
	private int id;
	private String name;
	private String address;
	private long phoneNumber;
	private String email;

	@ManyToOne
	@JoinColumn
	private User user;
}
