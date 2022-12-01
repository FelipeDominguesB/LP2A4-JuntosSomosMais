 package com.challenge.models;

import java.util.*;

public class InsumoPage {

	public InsumoPage()
	{
		insumos = new ArrayList<Insumo>();
		
	}
	
	
	public int totalCount;
	public int pageSize;
	public int pageNumber;
	public List<Insumo> insumos;
}
