package com.rb.hopeapp.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.rb.hopeapp.domain.namedqueries.ProductNameQueries;

import java.util.Date;


/**
 * The persistent class for the product_dtl database table.
 * 
 */
@AutoProperty
@Entity
@Table(name="product_dtl")
@NamedQueries({
	@NamedQuery(name=ProductNameQueries.FIND_DETAILS_BY_CATEGORY, 
		query="select o from ProductDtl o")
})
public class ProductDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="product_dtl_id")
	private int productDtlId;
	
	@Column(name="dtl_name")
	private String productDtlName;

	@Column(name="created_by")
	private String createdBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="last_updated_by")
	private String lastUpdatedBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	private Double price;

	@Column(name="price_type")
	private int priceType;

	@Column(name="qty_on_hand")
	private Double qtyOnHand;

	@Column(name="selling_qty")
	private Double sellingQty;

	@OneToOne
	@JoinColumn(name="status_id")
	private Status status;

	@Column(name="sug_price")
	private Double sugPrice;

	//bi-directional many-to-one association to UnitConversion
    @ManyToOne
	@JoinColumn(name="package_type")
	private UnitConversion unitConversion;

	//bi-directional many-to-one association to Product
    @ManyToOne
	@JoinColumn(name="product_id")
	private Product product;

    public ProductDtl() {
    }

	public int getProductDtlId() {
		return this.productDtlId;
	}

	public void setProductDtlId(int productDtlId) {
		this.productDtlId = productDtlId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedBy() {
		return this.lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getPriceType() {
		return this.priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	public Double getQtyOnHand() {
		return this.qtyOnHand;
	}

	public void setQtyOnHand(Double qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}

	public Double getSellingQty() {
		return this.sellingQty;
	}

	public void setSellingQty(Double sellingQty) {
		this.sellingQty = sellingQty;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getSugPrice() {
		return this.sugPrice;
	}

	public void setSugPrice(Double sugPrice) {
		this.sugPrice = sugPrice;
	}

	public UnitConversion getUnitConversion() {
		return this.unitConversion;
	}

	public void setUnitConversion(UnitConversion unitConversion) {
		this.unitConversion = unitConversion;
	}
	
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductDtlName() {
		return productDtlName;
	}

	public void setProductDtlName(String productDtlName) {
		this.productDtlName = productDtlName;
	}
	
	public String toString(){ 
		return Pojomatic.toString(this);
	}
	
}