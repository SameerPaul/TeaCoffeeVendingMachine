package com.yash.tcvm.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yash.tcvm.exception.EmptyContainerException;
import com.yash.tcvm.model.Containers;
import com.yash.tcvm.model.InputScanner;
import com.yash.tcvm.model.TeaCoffeeSaleReport;
import com.yash.tcvm.model.WasteOfMaterial;
import com.yash.tcvm.constants.MasterConstant;

public class TeaCoffeeVendingMachineImpl {
	InputScanner scan = new InputScanner();

	public static void main(String[] args) throws EmptyContainerException {
		
		TeaCoffeeVendingMachineImpl tcvmImpl = new TeaCoffeeVendingMachineImpl();
		List<Containers> containerList = new ArrayList<Containers>();
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		tcvmImpl.initiliazeContainers(containerList);
		tcvmImpl.initiliazeTeaCoffeeSaleReport(saleReportList);
		tcvmImpl.initiliazeWasteMaterials(wasteOfMaterialList);
		tcvmImpl.start(containerList,saleReportList,wasteOfMaterialList);
			
	}

	public void start(List<Containers> containerList, List<TeaCoffeeSaleReport> saleReportList, List<WasteOfMaterial> wasteOfMaterialList) throws  EmptyContainerException {
		TeaCoffeeVendingMachineImpl tcvmImpl = new TeaCoffeeVendingMachineImpl();
		Integer option = 0;
		Integer numberOfCup = 0;
		displayMenu();
		System.out.println("Please select Option :");
		option = scan.nextInt();
		if(option>=1 && option <=10){
				
				switch(option){
				
				case 1 :
					System.out.println("Enter number of cup");
					numberOfCup = scan.nextInt();
					tcvmImpl.prepareDrink(MasterConstant.COFFEE,numberOfCup,containerList);
					tcvmImpl.generateSaleReport(saleReportList,MasterConstant.COFFEE,numberOfCup);
					tcvmImpl.calculateWasteOfmaterials(MasterConstant.COFFEE,numberOfCup,wasteOfMaterialList);
					System.out.println("Your Coffee is Ready. Please Pay Rs 15.00..!!");
					System.out.println(containerList);
					break;
										
				case 2 :
					System.out.println("Enter number of cup");
					numberOfCup = scan.nextInt();
					tcvmImpl.prepareDrink(MasterConstant.TEA,numberOfCup,containerList);
					tcvmImpl.generateSaleReport(saleReportList,MasterConstant.TEA,numberOfCup);
					tcvmImpl.calculateWasteOfmaterials(MasterConstant.TEA,numberOfCup,wasteOfMaterialList);
					System.out.println("Your Tea is Ready. Please Pay Rs 10.00..!!");
					break;
					
				case 3 :
					System.out.println("Enter number of cup");
					numberOfCup = scan.nextInt();
					tcvmImpl.prepareDrink(MasterConstant.BLACK_COFFEE,numberOfCup,containerList);
					tcvmImpl.generateSaleReport(saleReportList,MasterConstant.BLACK_COFFEE,numberOfCup);
					tcvmImpl.calculateWasteOfmaterials(MasterConstant.BLACK_COFFEE,numberOfCup,wasteOfMaterialList);
					System.out.println("Your Black Coffee is Ready. Please Pay Rs 10.00..!!");
					break;
				
				case 4 :
					System.out.println("Enter number of cup");
					numberOfCup = scan.nextInt();
					tcvmImpl.prepareDrink(MasterConstant.BLACK_TEA,numberOfCup,containerList);
					tcvmImpl.generateSaleReport(saleReportList,MasterConstant.BLACK_TEA,numberOfCup);
					tcvmImpl.calculateWasteOfmaterials(MasterConstant.BLACK_TEA,numberOfCup,wasteOfMaterialList);
					System.out.println("Your Coffee is Ready. Please Pay Rs 5.00..!!");
					break;
				
				case 5 :
					System.out.println("Refilling Container");
					inputMaterials(containerList);
					break;
				
				case 6 :
					System.out.println("Sale Report");
					displaySalesReport(saleReportList);
					//System.out.println(saleReportList);
					break;
				
				case 7 :
					System.out.println("Checking Container Status");
					System.out.println(containerList);
					break;
				
				case 8 :
					tcvmImpl.resetContainer(containerList);
					System.out.println("Container has been reset");
					break;
				
				case 9 :
					displayWasteOfMaterials(wasteOfMaterialList);
					//System.out.println(wasteOfMaterialList);
					break;
				
				case 10 :
					System.exit(1);
				}
			}
			else {
				System.out.println("Invalid Input");
			}
									
		
		
		
		

		
	}

	public void displayWasteOfMaterials(List<WasteOfMaterial> wasteOfMaterialList) {
		System.out.println(wasteOfMaterialList);
		
	}

	public  void displaySalesReport(List<TeaCoffeeSaleReport> saleReportList) {
		System.out.println(saleReportList);
		
	}

	public void calculateWasteOfmaterials(String typeOfDrink, Integer numberOfCup, List<WasteOfMaterial> wasteOfMaterialList) {
		
		for(WasteOfMaterial wasteOfMaterial : wasteOfMaterialList){
			
			if(MasterConstant.TEA.toString().equals(typeOfDrink)){
				wasteOfMaterial.setWasteMaterialForTea(wasteOfMaterial.getWasteMaterialForTea() + (1 * numberOfCup));
				wasteOfMaterial.setWasteMaterialForWater(wasteOfMaterial.getWasteMaterialForWater() + (5 * numberOfCup));
				wasteOfMaterial.setWasteMaterialForMilk(wasteOfMaterial.getWasteMaterialForMilk() + (4* numberOfCup));
				wasteOfMaterial.setWasteMaterialForSugar(wasteOfMaterial.getWasteMaterialForSugar() + (2 * numberOfCup));
			}
			
			if(MasterConstant.BLACK_TEA.toString().equals(typeOfDrink)){
				wasteOfMaterial.setWasteMaterialForTea(wasteOfMaterial.getWasteMaterialForTea() + 0);
				wasteOfMaterial.setWasteMaterialForWater(wasteOfMaterial.getWasteMaterialForWater() + (12 * numberOfCup));
				wasteOfMaterial.setWasteMaterialForSugar(wasteOfMaterial.getWasteMaterialForSugar() + (2 * numberOfCup));
			}
			
			if(MasterConstant.COFFEE.toString().equals(typeOfDrink)){
				wasteOfMaterial.setWasteMaterialForCoffee(wasteOfMaterial.getWasteMaterialForCoffee() + (1 * numberOfCup));
				wasteOfMaterial.setWasteMaterialForWater(wasteOfMaterial.getWasteMaterialForWater() + (3 * numberOfCup));
				wasteOfMaterial.setWasteMaterialForMilk(wasteOfMaterial.getWasteMaterialForMilk() + (8 * numberOfCup));
				wasteOfMaterial.setWasteMaterialForSugar(wasteOfMaterial.getWasteMaterialForSugar() + (2 * numberOfCup));
			}
			
			if(MasterConstant.BLACK_COFFEE.toString().equals(typeOfDrink)){
				wasteOfMaterial.setWasteMaterialForCoffee(wasteOfMaterial.getWasteMaterialForCoffee() + 0);
				wasteOfMaterial.setWasteMaterialForWater(wasteOfMaterial.getWasteMaterialForWater() + (12 * numberOfCup));
				wasteOfMaterial.setWasteMaterialForSugar(wasteOfMaterial.getWasteMaterialForSugar() + (2 * numberOfCup));
			}
		}
		
	}

	public void inputMaterials(List<Containers> containerList) {
		
		Integer quantityForTea = 0;
		Integer quantityForCoffee = 0;
		Integer quantityForSugar = 0;
		Integer quantityForWater = 0;
		Integer quantityForMilk = 0;
		
		System.out.println("Current Container Status\n" +containerList);
		System.out.println("Please enter quantity in Container..!!");
		System.out.println("For Tea Container :");
		quantityForTea = scan.nextInt();
		System.out.println("For Coffee Container :");
		quantityForCoffee = scan.nextInt();
		System.out.println("For Sugar Container:");
		quantityForSugar = scan.nextInt();
		System.out.println("For Water Container:");
		quantityForWater = scan.nextInt();
		System.out.println("For Milk Container:");
		quantityForMilk = scan.nextInt();
		
		refillContainer(containerList,quantityForTea,quantityForCoffee,quantityForSugar,quantityForMilk,quantityForWater);
		
	}
	
	public void refillContainer(List<Containers> containerList, Integer quantityForTea, Integer quantityForCoffee, Integer quantityForSugar, Integer quantityForMilk, Integer quantityForWater){
		
		Integer requiredQuantityForTea = 0;
		Integer requiredQuantityForCoffee = 0;
		Integer requiredQuantityForSugar = 0;
		Integer requiredQuantityForWater = 0;
		Integer requiredQuantityForMilk = 0;
		
		for(Containers container : containerList){
			requiredQuantityForTea = 2000 - container.getTeaContainer();
			requiredQuantityForCoffee = 2000 - container.getCoffeContainer();
			requiredQuantityForSugar = 8000 - container.getSugarContainer();
			requiredQuantityForWater = 15000 - container.getWaterContainer();
			requiredQuantityForMilk = 10000 - container.getMilkContainer();
			
			if(quantityForTea <= requiredQuantityForTea){
				container.setTeaContainer(container.getTeaContainer() + quantityForTea);
			}
			else {
				System.out.println("Quantity should be "+requiredQuantityForTea);
			}
			if(quantityForCoffee <= requiredQuantityForCoffee){
				container.setCoffeContainer(container.getCoffeContainer() + quantityForCoffee);
			}
			else {
				System.out.println("Quantity should be "+requiredQuantityForCoffee);
			}
			if(quantityForSugar <= requiredQuantityForSugar){
				container.setSugarContainer(container.getSugarContainer() + quantityForSugar);
			}
			else {
				System.out.println("Quantity should be "+requiredQuantityForSugar);
			}
			if(quantityForWater <= requiredQuantityForWater){
				container.setWaterContainer(container.getWaterContainer() + quantityForWater);
			}
			else {
				System.out.println("Quantity should be "+requiredQuantityForWater);
			}
			if(quantityForMilk <= requiredQuantityForMilk){
				container.setMilkContainer(container.getMilkContainer() + quantityForMilk);
			}
			else {
				System.out.println("Quantity should be "+requiredQuantityForMilk);
			}
			
			
		}
		
	}

	public Boolean resetContainer(List<Containers> containerList) {
		containerList.clear(); 
		Containers container = new Containers();
		container.setTeaContainer(0);
		container.setCoffeContainer(0);
		container.setMilkContainer(0);
		container.setWaterContainer(0);
		container.setSugarContainer(0);
		containerList.add(container);
		return true;
		
		
	}

	private void displayMenu() {
		System.out.println("Tea Coffee Vending Machine\n");
		System.out.println("1.Make Coffee");
		System.out.println("2.Make Tea");
		System.out.println("3.Make Black Coffee");
		System.out.println("4.Make Black Tea");
		System.out.println("5.Refill Container");
		System.out.println("6.Check Total Sale");
		System.out.println("7.Container Status");
		System.out.println("8.Reset Container");
		System.out.println("9.Wastage Of Material");
		System.out.println("10.Exit TCVM");
	}

	public void initiliazeContainers(List<Containers> containerList) {
		
		Containers containers = new Containers();
		containers.setCoffeContainer(2000);
		containers.setMilkContainer(10000);
		containers.setWaterContainer(15000);
		containers.setTeaContainer(2000);
		containers.setSugarContainer(8000);
		containerList.add(containers);
		System.out.println(containerList);
		
	}
	
	public void initiliazeTeaCoffeeSaleReport(List<TeaCoffeeSaleReport> saleReportList) {
		
		TeaCoffeeSaleReport teaCoffeeSaleReport = new TeaCoffeeSaleReport();
		teaCoffeeSaleReport.setTotalCupOfTea(0);
		teaCoffeeSaleReport.setTotalCupOfCoffee(0);
		teaCoffeeSaleReport.setTotalCupOfBlackCoffee(0);
		teaCoffeeSaleReport.setTotalCupOfBlackTea(0);
		teaCoffeeSaleReport.setTotalSaleOfTea(0);
		teaCoffeeSaleReport.setTotalSaleOfCoffee(0);
		teaCoffeeSaleReport.setTotalSaleOfBlackTea(0);
		teaCoffeeSaleReport.setTotalSaleOfBlackCoffee(0);
		teaCoffeeSaleReport.setTotalSale(0);
		saleReportList.add(teaCoffeeSaleReport);
	}
	
	public void initiliazeWasteMaterials(List<WasteOfMaterial> wasteOfMaterials) {
			
		WasteOfMaterial wasteOfMaterial = new WasteOfMaterial();
		wasteOfMaterial.setWasteMaterialForTea(0);
		wasteOfMaterial.setWasteMaterialForCoffee(0);
		wasteOfMaterial.setWasteMaterialForSugar(0);
		wasteOfMaterial.setWasteMaterialForWater(0);
		wasteOfMaterial.setWasteMaterialForMilk(0);
		wasteOfMaterials.add(wasteOfMaterial);
		
	}


	public boolean prepareDrink(String typeOfDrink, Integer numberOfCup, List<Containers> containerList) throws EmptyContainerException {
		if(containerList != null){
			if(MasterConstant.TEA.toString().equals(typeOfDrink)){
				Integer requiredMaterialForTea = 5 * numberOfCup;
				Integer requiredMaterialForWater = 60 * numberOfCup;
				Integer requiredMaterialForMilk = 40 * numberOfCup;
				Integer requiredMaterialForSugar = 15 * numberOfCup;
			
				for(Containers container : containerList){
					if(container.getTeaContainer()>=requiredMaterialForTea && container.getMilkContainer()>=requiredMaterialForMilk && container.getSugarContainer()>=requiredMaterialForSugar && container.getWaterContainer()>=requiredMaterialForWater){
						container.setTeaContainer(container.getTeaContainer()- requiredMaterialForTea);
						container.setMilkContainer(container.getMilkContainer()- requiredMaterialForMilk);
						container.setSugarContainer(container.getSugarContainer() - requiredMaterialForSugar);
						container.setWaterContainer(container.getWaterContainer()- requiredMaterialForWater);
					}
				}
				return true;
			}
		
			if(MasterConstant.COFFEE.toString().equals(typeOfDrink)){
				Integer requiredMaterialForCoffee = 4 * numberOfCup;
				Integer requiredMaterialForWater = 20 * numberOfCup;
				Integer requiredMaterialForMilk = 80 * numberOfCup;
				Integer requiredMaterialForSugar = 15 * numberOfCup;
			
				for(Containers container : containerList){
					if(container.getTeaContainer()>=requiredMaterialForCoffee && container.getMilkContainer()>=requiredMaterialForMilk && container.getSugarContainer()>=requiredMaterialForSugar && container.getWaterContainer()>=requiredMaterialForWater){
						container.setCoffeContainer(container.getCoffeContainer()- requiredMaterialForCoffee);
						container.setMilkContainer(container.getMilkContainer()- requiredMaterialForMilk);
						container.setSugarContainer(container.getSugarContainer() - requiredMaterialForSugar);
						container.setWaterContainer(container.getWaterContainer()- requiredMaterialForWater);
					}
				}
				return true;
			}
		
			if(MasterConstant.BLACK_COFFEE.toString().equals(typeOfDrink)){
				Integer requiredMaterialForCoffee = 3 * numberOfCup;
				Integer requiredMaterialForWater = 100 * numberOfCup;
				Integer requiredMaterialForSugar = 15 * numberOfCup;
			
				for(Containers container : containerList){
					if(container.getTeaContainer()>=requiredMaterialForCoffee && container.getSugarContainer()>=requiredMaterialForSugar && container.getWaterContainer()>=requiredMaterialForWater){
						container.setCoffeContainer(container.getCoffeContainer()- requiredMaterialForCoffee);
						container.setSugarContainer(container.getSugarContainer() - requiredMaterialForSugar);
						container.setWaterContainer(container.getWaterContainer()- requiredMaterialForWater);
				}
			}
				return true;
		}
		
		if(MasterConstant.BLACK_TEA.toString().equals(typeOfDrink)){
			Integer requiredMaterialForTea = 3 * numberOfCup;
			Integer requiredMaterialForWater = 100 * numberOfCup;
			Integer requiredMaterialForSugar = 15 * numberOfCup;
			
			for(Containers container : containerList){
				if(container.getTeaContainer()>=requiredMaterialForTea  && container.getSugarContainer()>=requiredMaterialForSugar && container.getWaterContainer()>=requiredMaterialForWater){
					container.setTeaContainer(container.getTeaContainer()- requiredMaterialForTea);
					container.setSugarContainer(container.getSugarContainer() - requiredMaterialForSugar);
					container.setWaterContainer(container.getWaterContainer()- requiredMaterialForWater);
				}
			}
			return true;
		}
		
		
		
	}
	else{
			throw new EmptyContainerException();
		}
	return false;
		

	}
	
	public Boolean generateSaleReport(List<TeaCoffeeSaleReport> saleReportList, String typeOfDrink, Integer numberOfCup) {
		
		for(TeaCoffeeSaleReport teaCoffeeSaleReport : saleReportList ){
			if(MasterConstant.TEA.toString().equals(typeOfDrink)){
				teaCoffeeSaleReport.setTotalCupOfTea(teaCoffeeSaleReport.getTotalCupOfTea() + numberOfCup);
				teaCoffeeSaleReport.setTotalSaleOfTea(teaCoffeeSaleReport.getTotalSaleOfTea() + numberOfCup * 10);
				teaCoffeeSaleReport.setTotalSale(teaCoffeeSaleReport.getTotalSale() + numberOfCup * 10);
			}
			
			if(MasterConstant.COFFEE.toString().equals(typeOfDrink)){
				teaCoffeeSaleReport.setTotalCupOfCoffee(teaCoffeeSaleReport.getTotalCupOfCoffee() + numberOfCup);
				teaCoffeeSaleReport.setTotalSaleOfCoffee(teaCoffeeSaleReport.getTotalSaleOfCoffee() + numberOfCup * 15);
				teaCoffeeSaleReport.setTotalSale(teaCoffeeSaleReport.getTotalSale() + numberOfCup * 15);
			}
			
			if(MasterConstant.BLACK_TEA.toString().equals(typeOfDrink)){
				teaCoffeeSaleReport.setTotalCupOfBlackTea(teaCoffeeSaleReport.getTotalCupOfBlackTea() + numberOfCup);
				teaCoffeeSaleReport.setTotalSaleOfBlackTea(teaCoffeeSaleReport.getTotalSaleOfBlackTea() + numberOfCup * 5);
				teaCoffeeSaleReport.setTotalSale(teaCoffeeSaleReport.getTotalSale() + numberOfCup * 5);
			}
			
			if(MasterConstant.BLACK_COFFEE.toString().equals(typeOfDrink)){
				teaCoffeeSaleReport.setTotalCupOfBlackCoffee(teaCoffeeSaleReport.getTotalCupOfBlackCoffee() + numberOfCup);
				teaCoffeeSaleReport.setTotalSaleOfBlackCoffee(teaCoffeeSaleReport.getTotalSaleOfBlackCoffee() + numberOfCup * 10);
				teaCoffeeSaleReport.setTotalSale(teaCoffeeSaleReport.getTotalSale() + numberOfCup * 10);
			}
		}
		
		return true;
		
		
	}

	
}
