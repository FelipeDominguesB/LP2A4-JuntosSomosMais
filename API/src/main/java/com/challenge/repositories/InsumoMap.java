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
	
	public List<Insumo> pegarInsumosFiltrados(String type, String region)
	{
		List<Insumo> insumosFiltrados = new ArrayList<Insumo>();
		for(Insumo insumo : new ArrayList<Insumo>(insumos.values()))
		{
			if(insumo.type.equals(type) && insumo.region.equals(region))
			{
				insumosFiltrados.add(insumo);
			}
		}
		
		return insumosFiltrados;
	}
	
	public InsumoPage pegarInsumosPaginados(List<Insumo> insumos, int pageSize, int pageIndex)
	{
		
		
		InsumoPage insumoPage = new InsumoPage();
		
		try {
			insumoPage.totalCount = insumos.size();
			insumoPage.pageNumber = pageIndex;
			insumoPage.pageSize = pageSize;
			
			for(int i = 0; i < pageSize; i++)
			{
				insumoPage.insumos.add(insumos.get(i + (pageSize * pageIndex - 1)));
			}
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		
		return insumoPage;
		
	}
}
