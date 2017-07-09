package LifeExpectancyDisplayMap;

import java.util.HashMap;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancyDisplay extends PApplet {
	private UnfoldingMap map;
	private Map<String, Float> lifeExpectancyByCountry;
	public void setup(){
		size(950, 600, OPENGL);
		map = new UnfoldingMap(this, 200, 50, 700, 500, new OpenStreetMap.OpenStreetMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		
		lifeExpectancyByCountry = loadlifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");
		System.out.println(lifeExpectancyByCountry.size());
		System.out.println(lifeExpectancyByCountry.entrySet());
		
	}

	public void draw(){
		map.draw();
		
	}
	
	private Map<String, Float> loadlifeExpectancyFromCSV(String fileName) {
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		String[] rows = loadStrings(fileName);
		for(String row : rows){
			String[] column = row.split(",");
			if (column.length == 6 && !column[5].equals("..")) {
				lifeExpMap.put(column[4], Float.parseFloat(column[5]));
			}			
		}
		
		return lifeExpMap;
	}

}
