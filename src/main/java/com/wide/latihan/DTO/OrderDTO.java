package com.wide.latihan.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.wide.latihan.entity.Order;

public class OrderDTO {
    private String customerName;
    private String address;
    private List<OrderItemDTO> items;
    private int total;

    public OrderDTO(Order order) {
        this.customerName = order.getCustomerName();
        this.address = order.getAddress();
        this.items = order.getItems().stream()
            .map(OrderItemDTO::new)
            .collect(Collectors.toList());
        this.total = order.getTotal();
    }

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
    
    

}
