package com.yash.tcvm.exception;

public class EmptyContainerException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyContainerException(){
		System.out.println("Container is Empty");
	}

}
