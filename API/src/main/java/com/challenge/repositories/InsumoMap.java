package com.challenge.repositories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.models.*;

public class InsumoMap {

	private static Map<Integer, Insumo> insumos;
	private int counter = 0;
	
	public InsumoMap()
	{
		if(insumos == null)
			insumos = new HashMap<Integer, Insumo>();
	}
	
	public void InsereInsumo(Insumo insumo)
	{
		insumo.id = counter;
		insumos.put(counter, insumo);
		counter++;
	}
	
	public List<Insumo> pegarInsumos()
	{
		return new ArrayList<Insumo>(insumos.values());
	}
}
