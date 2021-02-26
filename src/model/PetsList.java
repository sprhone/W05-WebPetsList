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
 * Feb 10, 2021
 */

@Entity
@Table(name = "pets")
public class PetsList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "OWNER")
	private String owner;
	@Column(name = "TYPE")
	private String type;
	@Column(name = "NAME")
	private String name;
	
	public PetsList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PetsList(String owner, String type, String name) {
		super();
		this.owner = owner;
		this.type = type;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String returnPetDetails() {
		return owner + ":" + type + ":" + name;
	}

	@Override
	public String toString() {
		return name + " the " + type + " owned by: " + owner;
	}
	
}
