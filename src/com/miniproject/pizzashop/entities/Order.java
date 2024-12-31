package com.miniproject.pizzashop.entities;

public class Order {
	// Keep the attribute name as same as present in databases.
	private int oid;
	private int cid;
	private int mid;

	public Order() {

	}

	public Order(int oid, int cid, int mid) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.mid = mid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cid=" + cid + ", mid=" + mid + "]";
	}

}
