package com.rb.hopeapp.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.List;


/**
 * The persistent class for the sales database table.
 * 
 */
@Entity
@Table(name="sales")
public class Sale implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sales_id")
	private int salesId;

	@Column(name="claimed_by")
	private String claimedBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="claimed_date")
	private Date claimedDate;

	@Column(name="created_by",updatable=false)
	private String createdBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_date",updatable=false)
	private Date createdDate;

	private int customer;

	@Column(name="last_updated_by")
	private String lastUpdatedBy;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	private String remarks;

	private int status;

	@Column(name="total_amt")
	private Double totalAmt;

	@Column(name="total_dpst")
	private Double totalDpst;

	@Column(name="total_qty_rtrn")
	private int totalQtyRtrn;

	//bi-directional many-to-one association to SalesDtl
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="sales_id")
	private List<SalesDtl> salesDtls;

    public Sale() {
    }

	public int getSalesId() {
		return salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public String getClaimedBy() {
		return claimedBy;
	}

	public void setClaimedBy(String claimedBy) {
		this.claimedBy = claimedBy;
	}

	public Date getClaimedDate() {
		return claimedDate;
	}

	public void setClaimedDate(Date claimedDate) {
		this.claimedDate = claimedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Double getTotalDpst() {
		return totalDpst;
	}

	public void setTotalDpst(Double totalDpst) {
		this.totalDpst = totalDpst;
	}

	public int getTotalQtyRtrn() {
		return totalQtyRtrn;
	}

	public void setTotalQtyRtrn(int totalQtyRtrn) {
		this.totalQtyRtrn = totalQtyRtrn;
	}

	public List<SalesDtl> getSalesDtls() {
		return salesDtls;
	}

	public void setSalesDtls(List<SalesDtl> salesDtls) {
		this.salesDtls = salesDtls;
	}

	
	
}