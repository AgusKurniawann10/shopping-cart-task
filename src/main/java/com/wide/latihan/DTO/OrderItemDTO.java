package com.wide.latihan.DTO;

import com.wide.latihan.entity.OrderItem;

public class OrderItemDTO {
    private int productNo;
    private String productName;
    private int quantity;
    private int unitPrice;
    private int totalPrice;

    public OrderItemDTO(OrderItem item) {
        this.productNo = item.getProduct().getNo();
        this.productName = item.getProduct().getName();
        this.quantity = item.getQuantity();
        this.unitPrice = item.getProduct().getPrice();
        this.totalPrice = item.getTotalPrice();
    }

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
    
    


}
