package com.rb.hopeapp.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.ProductCategoryNamedQueries;

import java.util.Date;


/**
 * The persistent class for the product_category database table.
 * 
 */
@Entity
@AutoProperty
@Table(name="product_category")
@NamedQueries({
	@NamedQuery(name=ProductCategoryNamedQueries.FIND_BY_NAME, 
			query = "select o from ProductCategory o where o.categoryName=:"+NamedQueriesParam.SEARCH_NAME)
})
public class ProductCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_category_id")
	private int productCategoryId;

	@Column(name="category_name")
	private String categoryName;

	@Column(name="category_type")
	private int categoryType;

	private String description;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="effective_end_date")
	private Date effectiveEndDate;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="effective_start_date")
	private Date effectiveStartDate;

	@Column(name="parent_category")
	private int parentCategory;

    public ProductCategory() {
    }

	public int getProductCategoryId() {
		return this.productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryType() {
		return this.categoryType;
	}

	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public int getParentCategory() {
		return this.parentCategory;
	}

	public void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String toString() {
		return Pojomatic.toString(this);
	}
}