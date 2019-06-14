package com.yash.tcvm.model;

public class Containers {
	
	private Integer teaContainer;
	private Integer coffeContainer;
	private Integer milkContainer;
	private Integer waterContainer;
	private Integer sugarContainer;
	
		
	public Integer getTeaContainer() {
		return teaContainer;
	}



	public void setTeaContainer(Integer teaContainer) {
		this.teaContainer = teaContainer;
	}



	public Integer getCoffeContainer() {
		return coffeContainer;
	}



	public void setCoffeContainer(Integer coffeContainer) {
		this.coffeContainer = coffeContainer;
	}



	public Integer getMilkContainer() {
		return milkContainer;
	}



	public void setMilkContainer(Integer milkContainer) {
		this.milkContainer = milkContainer;
	}



	public Integer getWaterContainer() {
		return waterContainer;
	}



	public void setWaterContainer(Integer waterContainer) {
		this.waterContainer = waterContainer;
	}



	public Integer getSugarContainer() {
		return sugarContainer;
	}



	public void setSugarContainer(Integer sugarContainer) {
		this.sugarContainer = sugarContainer;
	}



	@Override
	public String toString() {
		return "TeaContainer=" + teaContainer + ", CoffeContainer=" + coffeContainer + ", MilkContainer="
				+ milkContainer + ", WaterContainer=" + waterContainer + ", SugarContainer=" + sugarContainer + "";
	}
	
	

}
