package com.rooftop.academy.dto;

public class CheckApiResponse{
	private Boolean message;

	public void setMessage(Boolean message){
		this.message = message;
	}

	public Boolean isMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"CheckApiResponse{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
