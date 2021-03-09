package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Mar 4, 2021
 */

@Entity
@Table(name="lore")
public class Lore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LORE_ID")
	private int id;
	@Column(name="LORE_NAME")
	private String loreName;
	
	public Lore() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lore(int id, String loreName) {
		super();
		this.id = id;
		this.loreName = loreName;
	}

	public Lore(String loreName) {
		super();
		this.loreName = loreName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoreName() {
		return loreName;
	}

	public void setLoreName(String loreName) {
		this.loreName = loreName;
	}

	@Override
	public String toString() {
		return "Lore [id=" + id + ", loreName=" + loreName + "]";
	}
}
