package application;

import java.sql.Date;

public class order {
	private int id;
	private int cusid;
	private Date date;
	private int amount;
	private double price;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public order(int id,int cusid, Date date, int amount) {
		this.id= id;
		this.cusid = cusid;
		this.date = date;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "order [cusid=" + cusid + ", date=" + date + ", amount=" + amount + "]";
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	
	
	
}
