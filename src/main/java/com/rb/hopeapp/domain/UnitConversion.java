package com.rb.hopeapp.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.UnitConversionNameQueries;

import java.util.Set;


/**
 * The persistent class for the unit_conversion database table.
 * 
 */
@AutoProperty
@Entity
@Table(name="unit_conversion")
@NamedQueries({
	@NamedQuery(name=UnitConversionNameQueries.FIND_BY_NAME , 
			query="select o from UnitConversion o where o.name=:"+NamedQueriesParam.SEARCH_NAME)
})
public class UnitConversion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String abbr;

	private Double factor;

	private String name;

	@OneToOne
	@JoinColumn(name="status_id")
	private Status status;

		
	@Column(name="unit_type")
	private int unitType;

    public UnitConversion() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbbr() {
		return this.abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public Double getFactor() {
		return this.factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	public int getUnitType() {
		return unitType;
	}

	public void setUnitType(int unitType) {
		this.unitType = unitType;
	}
	
	public String toString() {
		return Pojomatic.toString(this);
	}
	
	
}