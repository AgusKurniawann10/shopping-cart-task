package com.wide.latihan.DTO;

import com.wide.latihan.entity.Product;

public class ProductDTO {
	private int no;
    private String name;
    private String type;
    private int price;

    public ProductDTO(Product product) {
        this.no = product.getNo();
        this.name = product.getName();
        this.type = product.getType();
        this.price = product.getPrice();
    }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
    
    

}
