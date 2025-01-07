/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author HP
 */
public class Order extends Product{
	private int orderId;
	private int uid;
	private int qunatity;
	private String date;
	
	public Order() {
	}
	
	public Order(int orderId, int uid, int qunatity, String date) {
		super();
		this.orderId = orderId;
		this.uid = uid;
		this.qunatity = qunatity;
		this.date = date;
	}

	public Order(int uid, int Qunatity, String date) {
		super();
		this.uid = uid;
		this.qunatity = qunatity;
		this.date = date;
	}

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the uid
     */
    public int getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(int uid) {
        this.uid = uid;
    }

    /**
     * @return the qunatity
     */
    public int getQunatity() {
        return qunatity;
    }

    /**
     * @param qunatity the qunatity to set
     */
    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

	
}


