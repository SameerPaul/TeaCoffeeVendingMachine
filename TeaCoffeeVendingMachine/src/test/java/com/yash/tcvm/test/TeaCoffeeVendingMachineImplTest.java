package com.yash.tcvm.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.tcvm.exception.EmptyContainerException;
import com.yash.tcvm.main.TeaCoffeeVendingMachineImpl;
import com.yash.tcvm.model.Containers;
import com.yash.tcvm.model.InputScanner;
import com.yash.tcvm.model.TeaCoffeeSaleReport;
import com.yash.tcvm.model.WasteOfMaterial;
import com.yash.tcvm.constants.MasterConstant;

@RunWith(MockitoJUnitRunner.class)
public class TeaCoffeeVendingMachineImplTest {
	
		
	
	@Mock
	InputScanner scanner;
	
	@InjectMocks
	TeaCoffeeVendingMachineImpl teaCoffeeVendingMachineImpl;
	
	@InjectMocks
	MasterConstant drinkType;
	
	@Test(expected = EmptyContainerException.class)
	public void shouldThrowEmptyContainerExceptionWhenContainerIsEmpty() throws EmptyContainerException{
		
		List<Containers> containerList = null;
		teaCoffeeVendingMachineImpl.prepareDrink(MasterConstant.TEA, 2, containerList);
	}
	
	@Test
	public void shouldReturnTrueWhenContainersAreFilledAndChoiceIsCoffee() throws EmptyContainerException{
		List<Containers> containerList = new ArrayList<Containers>();
			
		Boolean actual = teaCoffeeVendingMachineImpl.prepareDrink(MasterConstant.COFFEE, 2, containerList);
		
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnTrueWhenContainersAreFilledAndChoiceIsTea() throws EmptyContainerException{
		List<Containers> containerList = new ArrayList<Containers>();
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		teaCoffeeVendingMachineImpl.initiliazeContainers(containerList);
		teaCoffeeVendingMachineImpl.initiliazeTeaCoffeeSaleReport(saleReportList);
		teaCoffeeVendingMachineImpl.initiliazeWasteMaterials(wasteOfMaterialList);
		
		Boolean actual = false;
		
		actual = teaCoffeeVendingMachineImpl.prepareDrink(MasterConstant.TEA, 2, containerList);
		
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnTrueWhenContainersAreFilledAndChoiceIsBlackCoffee() throws EmptyContainerException{
		List<Containers> containerList = new ArrayList<Containers>();
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		teaCoffeeVendingMachineImpl.initiliazeContainers(containerList);
		teaCoffeeVendingMachineImpl.initiliazeTeaCoffeeSaleReport(saleReportList);
		teaCoffeeVendingMachineImpl.initiliazeWasteMaterials(wasteOfMaterialList);
		
		Boolean actual = false;
		
		actual = teaCoffeeVendingMachineImpl.prepareDrink(MasterConstant.BLACK_COFFEE, 2, containerList);
		
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnTrueWhenContainersAreFilledAndChoiceIsBlackTea() throws EmptyContainerException{
		List<Containers> containerList = new ArrayList<Containers>();
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		teaCoffeeVendingMachineImpl.initiliazeContainers(containerList);
		teaCoffeeVendingMachineImpl.initiliazeTeaCoffeeSaleReport(saleReportList);
		teaCoffeeVendingMachineImpl.initiliazeWasteMaterials(wasteOfMaterialList);
		
		Boolean actual = false;
		
		actual = teaCoffeeVendingMachineImpl.prepareDrink(MasterConstant.BLACK_TEA, 2, containerList);
		
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnTrueWhenVendingMachineSalesReportGenerated(){
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		teaCoffeeVendingMachineImpl.initiliazeTeaCoffeeSaleReport(saleReportList);
		teaCoffeeVendingMachineImpl.displaySalesReport(saleReportList);
		Boolean actual = teaCoffeeVendingMachineImpl.generateSaleReport(saleReportList, MasterConstant.TEA, 10);
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnTrueWhenVendingMachineSalesReportGeneratedForCoffee(){
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		teaCoffeeVendingMachineImpl.initiliazeTeaCoffeeSaleReport(saleReportList);
		
		Boolean actual = teaCoffeeVendingMachineImpl.generateSaleReport(saleReportList, MasterConstant.COFFEE, 10);
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnTrueWhenVendingMachineSalesReportGeneratedForBlackCoffee(){
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		teaCoffeeVendingMachineImpl.initiliazeTeaCoffeeSaleReport(saleReportList);
		
		Boolean actual = teaCoffeeVendingMachineImpl.generateSaleReport(saleReportList, MasterConstant.BLACK_COFFEE, 10);
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnTrueWhenVendingMachineSalesReportGeneratedForBlackTea(){
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		teaCoffeeVendingMachineImpl.initiliazeTeaCoffeeSaleReport(saleReportList);
		
		Boolean actual = teaCoffeeVendingMachineImpl.generateSaleReport(saleReportList, MasterConstant.BLACK_TEA, 10);
		assertEquals(true, actual);
		
	}
	
	@Test
	public void shouldReturnTrueWhenContainerHasBeenReset(){
		List<Containers> containerList = new ArrayList<Containers>();
		
		Boolean actual = teaCoffeeVendingMachineImpl.resetContainer(containerList);
		
		assertEquals(true, actual);
		
	}
	

	
	@Test
	public void shouldDisplaySalesReport(){
		List<TeaCoffeeSaleReport> saleReportList = new ArrayList<TeaCoffeeSaleReport>();
		
		teaCoffeeVendingMachineImpl.displaySalesReport(saleReportList);;
	}
	
	@Test
	public void shouldDisplayWasteOfMaterials(){
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		teaCoffeeVendingMachineImpl.displayWasteOfMaterials(wasteOfMaterialList);
		
	}
	
	@Test
	public void shouldCalculateWasteOfMaterialsForTea(){
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		teaCoffeeVendingMachineImpl.initiliazeWasteMaterials(wasteOfMaterialList);
		//teaCoffeeVendingMachineImpl.displayWasteOfMaterials(wasteOfMaterialList);
		String typeOfDrink = MasterConstant.TEA;
		Integer numberOfCup = 10;
		teaCoffeeVendingMachineImpl.calculateWasteOfmaterials(typeOfDrink, numberOfCup, wasteOfMaterialList);
		teaCoffeeVendingMachineImpl.displayWasteOfMaterials(wasteOfMaterialList);
	}
	
	@Test
	public void shouldCalculateWasteOfMaterialsForBlackTea(){
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		teaCoffeeVendingMachineImpl.initiliazeWasteMaterials(wasteOfMaterialList);
		String typeOfDrink = MasterConstant.BLACK_TEA;
		Integer numberOfCup = 10;
		teaCoffeeVendingMachineImpl.calculateWasteOfmaterials(typeOfDrink, numberOfCup, wasteOfMaterialList);
		
	}
	
	@Test
	public void shouldCalculateWasteOfMaterialsForCoffee(){
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		teaCoffeeVendingMachineImpl.initiliazeWasteMaterials(wasteOfMaterialList);
		String typeOfDrink = MasterConstant.COFFEE;
		Integer numberOfCup = 10;
		teaCoffeeVendingMachineImpl.calculateWasteOfmaterials(typeOfDrink, numberOfCup, wasteOfMaterialList);
		
	}
	
	@Test
	public void shouldCalculateWasteOfMaterialsForBlackCoffee(){
		List<WasteOfMaterial> wasteOfMaterialList = new ArrayList<WasteOfMaterial>();
		teaCoffeeVendingMachineImpl.initiliazeWasteMaterials(wasteOfMaterialList);
		String typeOfDrink = MasterConstant.BLACK_COFFEE;
		Integer numberOfCup = 10;
		teaCoffeeVendingMachineImpl.calculateWasteOfmaterials(typeOfDrink, numberOfCup, wasteOfMaterialList);
		
	}
	
	@Test
	public void WhenInputIsCoffee() throws EmptyContainerException {
		
		String typeOfDrink=MasterConstant.COFFEE;
		Integer numberOfCup=2;
		List<Containers> containerList=new ArrayList<Containers>();
		teaCoffeeVendingMachineImpl.initiliazeContainers(containerList);
		Boolean actual = teaCoffeeVendingMachineImpl.prepareDrink(typeOfDrink, numberOfCup, containerList);
		assertEquals(true, actual);		
	}
	
	
	
	
	@Test
	public void a() throws EmptyContainerException{
		List<Containers> containerList=new ArrayList<Containers>();
		List<TeaCoffeeSaleReport> saleReportList=new ArrayList<TeaCoffeeSaleReport>();;
		List<WasteOfMaterial> wasteOfMaterialList=new ArrayList<WasteOfMaterial>();;
		
		when(scanner.nextInt()).thenReturn(1);
		
		teaCoffeeVendingMachineImpl.start(containerList, saleReportList, wasteOfMaterialList);
	}
	
	@Test
	public void b() throws EmptyContainerException{
		List<Containers> containerList=new ArrayList<Containers>();
		List<TeaCoffeeSaleReport> saleReportList=new ArrayList<TeaCoffeeSaleReport>();;
		List<WasteOfMaterial> wasteOfMaterialList=new ArrayList<WasteOfMaterial>();;
		
		when(scanner.nextInt()).thenReturn(2);
		
		teaCoffeeVendingMachineImpl.start(containerList, saleReportList, wasteOfMaterialList);
	}
	
	@Test
	public void c() throws EmptyContainerException{
		List<Containers> containerList=new ArrayList<Containers>();
		List<TeaCoffeeSaleReport> saleReportList=new ArrayList<TeaCoffeeSaleReport>();;
		List<WasteOfMaterial> wasteOfMaterialList=new ArrayList<WasteOfMaterial>();;
		
		when(scanner.nextInt()).thenReturn(3);
		
		teaCoffeeVendingMachineImpl.start(containerList, saleReportList, wasteOfMaterialList);
	}
	
	@Test
	public void d() throws EmptyContainerException{
		List<Containers> containerList=new ArrayList<Containers>();
		List<TeaCoffeeSaleReport> saleReportList=new ArrayList<TeaCoffeeSaleReport>();;
		List<WasteOfMaterial> wasteOfMaterialList=new ArrayList<WasteOfMaterial>();;
		
		when(scanner.nextInt()).thenReturn(4);
		
		teaCoffeeVendingMachineImpl.start(containerList, saleReportList, wasteOfMaterialList);
	}
	
	@Test
	public void shouldRefillConntainer(){
		
		List<Containers> containerList = new ArrayList<Containers>();
		teaCoffeeVendingMachineImpl.initiliazeContainers(containerList);
		Integer quantityForTea = 20;
		Integer quantityForCoffee = 20;
		Integer quantityForSugar = 20;
		Integer quantityForMilk = 20;
		Integer quantityForWater = 20;
		teaCoffeeVendingMachineImpl.refillContainer(containerList, quantityForTea, quantityForCoffee, quantityForSugar, quantityForMilk, quantityForWater);
	}
	
	@Test
	public void shouldSelectRefillContainerOption() throws EmptyContainerException{
		List<Containers> containerList = new ArrayList<Containers>();
		teaCoffeeVendingMachineImpl.initiliazeContainers(containerList);
		Integer quantityForTea = 20;
		Integer quantityForCoffee = 20;
		Integer quantityForSugar = 20;
		Integer quantityForMilk = 20;
		Integer quantityForWater = 20;
		when(scanner.nextInt()).thenReturn(5);

		
		List<TeaCoffeeSaleReport> saleReportList=new ArrayList<TeaCoffeeSaleReport>();;
		List<WasteOfMaterial> wasteOfMaterialList=new ArrayList<WasteOfMaterial>();;
		
			
		teaCoffeeVendingMachineImpl.inputMaterials(containerList);
		teaCoffeeVendingMachineImpl.refillContainer(containerList, quantityForTea, quantityForCoffee, quantityForSugar, quantityForMilk, quantityForWater);

		teaCoffeeVendingMachineImpl.start(containerList, saleReportList, wasteOfMaterialList);

		
		//Mockito.doCallRealMethod().when(teaCoffeeVendingMachineImpl).refillContainer(containerList, quantityForTea, quantityForCoffee, quantityForSugar, quantityForMilk, quantityForWater);
	}
	

}
