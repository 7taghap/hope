package com.rb.hopeapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unit_type database table.
 * 
 */
@Entity
@Table(name="unit_type")
public class UnitType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="unit_type_id")
	private int unitTypeId;

	private String description;

	private String name;

	//bi-directional many-to-one association to UnitConversion
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="unit_type")
	private List<UnitConversion> unitConversions;

    public UnitType() {
    }

	public int getUnitId() {
		return this.unitTypeId;
	}

	public void ListUnitId(int unitId) {
		this.unitTypeId = unitId;
	}

	public String getDescription() {
		return this.description;
	}

	public void ListDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void ListName(String name) {
		this.name = name;
	}

	public List<UnitConversion> getUnitConversions() {
		return this.unitConversions;
	}

	public void ListUnitConversions(List<UnitConversion> unitConversions) {
		this.unitConversions = unitConversions;
	}
	
}