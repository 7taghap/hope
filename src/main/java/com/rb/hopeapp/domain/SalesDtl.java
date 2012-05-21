package com.rb.hopeapp.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import com.rb.hopeapp.domain.namedqueries.NamedQueriesParam;
import com.rb.hopeapp.domain.namedqueries.SalesNamedQueries;

import java.util.Date;


/**
 * The persistent class for the sales_dtl database table.
 * 
 */
@AutoProperty
@Entity
@Table(name="sales_dtl")
@NamedQueries({
	@NamedQuery(name=SalesNamedQueries.FIND_DETAILS_BY_CREATED_BY , 
			query="select o from SalesDtl o where o.sale.createdBy=:"+NamedQueriesParam.SEARCH_CREATED_BY),
	@NamedQuery(name=SalesNamedQueries.FIND_DETAILS_BY_DATE, 
			query="select o from SalesDtl o where o.createdDate >=:"+NamedQueriesParam.SEARCH_START_DATE + " and o.createdDate <=:" + NamedQueriesParam.SEARCH_END_DATE),
	@NamedQuery(name=SalesNamedQueries.FIND_DETAILS_BY_ITEM_NAME, 
			query="select o from SalesDtl o where o.product.product.productName=:"+NamedQueriesParam.SEARCH_NAME)
})
public class SalesDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sales_dtl_id")
	private int salesDtlId;

	private Double amt;

	@Column(name="created_date",updatable=false)
	private Date createdDate;

	private Double dpst;

	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

//	@Column(name="product_id")
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="product_dtl_id")
	private ProductDtl product;

	private int qty;

	@Column(name="qty_return")
	private int qtyReturn;

	private int status;

	//bi-directional many-to-one association to Sale
    @ManyToOne
	@JoinColumn(name="sales_id")
	private Sale sale;

    public SalesDtl() {
    }

	public int getSalesDtlId() {
		return this.salesDtlId;
	}

	public void setSalesDtlId(int salesDtlId) {
		this.salesDtlId = salesDtlId;
	}

	public Double getAmt() {
		return this.amt;
	}

	public void setAmt(Double amt) {
		this.amt = amt;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Double getDpst() {
		return this.dpst;
	}

	public void setDpst(Double dpst) {
		this.dpst = dpst;
	}

	public Date getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public ProductDtl getProduct() {
		return this.product;
	}

	public void setProduct(ProductDtl productId) {
		this.product = productId;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getQtyReturn() {
		return this.qtyReturn;
	}

	public void setQtyReturn(int qtyReturn) {
		this.qtyReturn = qtyReturn;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	public String toString() {
		return Pojomatic.toString(this);
	}
	
}