package com.example;

public class CoffeeSalesModel {
	private int count;
	private String type;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int typeCost() {
		switch (type) {
		case "espresso":
			return 4;
		case "cappuccino":
			return 6;
		default:
			throw new RuntimeException("unknown coffee!");
		}
	}

	public int getCost() {
		return count * typeCost();
	}
}
