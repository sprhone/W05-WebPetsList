package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Sterling Rhone - sprhone
 * 202102 CIS175 26740
 * Mar 4, 2021
 */

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="LORE_ID")
	private Lore lore;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
		@JoinTable (
				name = "pets_on_list",
				joinColumns = {
						@JoinColumn(name="LIST_ID", referencedColumnName = "LIST_ID")
						},
				inverseJoinColumns = {
						@JoinColumn(name="PET_ID", referencedColumnName = "ID", unique = true)
				})
	private List<PetsList> listOfPets;
	
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ListDetails(int id, String listName, Lore lore, List<PetsList> listOfPets) {
		super();
		this.id = id;
		this.listName = listName;
		this.lore = lore;
		this.listOfPets = listOfPets;
	}

	public ListDetails(String listName, Lore lore, List<PetsList> listOfPets) {
		super();
		this.listName = listName;
		this.lore = lore;
		this.listOfPets = listOfPets;
	}

	public ListDetails(String listName, Lore lore) {
		super();
		this.listName = listName;
		this.lore = lore;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Lore getLore() {
		return lore;
	}
	public void setLore(Lore lore) {
		this.lore = lore;
	}
	public List<PetsList> getListOfPets() {
		return listOfPets;
	}
	public void setListOfPets(List<PetsList> listOfPets) {
		this.listOfPets = listOfPets;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", lore=" + lore + ", listOfPets=" + listOfPets
				+ "]";
	}
}
