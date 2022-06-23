package com.rooftop.academy.dto;

import java.util.List;

public class BlocksDTO{
	private List<String> blocks;

	public void setBlocks(List<String> blocks){
		this.blocks = blocks;
	}

	public List<String> getBlocks(){
		return blocks;
	}

	@Override
 	public String toString(){
		return 
			"BlocksDTO{" + 
			"blocks = '" + blocks + '\'' + 
			"}";
		}
}