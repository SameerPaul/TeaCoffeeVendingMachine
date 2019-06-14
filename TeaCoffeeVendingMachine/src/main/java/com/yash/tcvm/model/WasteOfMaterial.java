package com.yash.tcvm.model;

public class WasteOfMaterial {
	
	private Integer wasteMaterialForTea;
	private Integer wasteMaterialForCoffee;
	private Integer wasteMaterialForSugar;
	private Integer wasteMaterialForWater;
	private Integer wasteMaterialForMilk;
	
	public Integer getWasteMaterialForTea() {
		return wasteMaterialForTea;
	}
	public void setWasteMaterialForTea(Integer wasteMaterialForTea) {
		this.wasteMaterialForTea = wasteMaterialForTea;
	}
	public Integer getWasteMaterialForCoffee() {
		return wasteMaterialForCoffee;
	}
	public void setWasteMaterialForCoffee(Integer wasteMaterialForCoffee) {
		this.wasteMaterialForCoffee = wasteMaterialForCoffee;
	}
	public Integer getWasteMaterialForSugar() {
		return wasteMaterialForSugar;
	}
	public void setWasteMaterialForSugar(Integer wasteMaterialForSugar) {
		this.wasteMaterialForSugar = wasteMaterialForSugar;
	}
	public Integer getWasteMaterialForWater() {
		return wasteMaterialForWater;
	}
	public void setWasteMaterialForWater(Integer wasteMaterialForWater) {
		this.wasteMaterialForWater = wasteMaterialForWater;
	}
	public Integer getWasteMaterialForMilk() {
		return wasteMaterialForMilk;
	}
	public void setWasteMaterialForMilk(Integer wasteMaterialForMilk) {
		this.wasteMaterialForMilk = wasteMaterialForMilk;
	}
	
	@Override
	public String toString() {
		return "[wasteMaterialForTea=" + wasteMaterialForTea + ", wasteMaterialForCoffee="
				+ wasteMaterialForCoffee + ", wasteMaterialForSugar=" + wasteMaterialForSugar
				+ ", wasteMaterialForWater=" + wasteMaterialForWater + ", wasteMaterialForMilk=" + wasteMaterialForMilk
				+ "]";
	}
	
	
	
	
	

}
