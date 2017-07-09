package DisplayMapWithIntialSetup;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class DisplayEarthquake extends PApplet {
	private UnfoldingMap map;
	public void setup(){
		size(950, 600, OPENGL);
		map = new UnfoldingMap(this, 200, 50, 700, 500, new OpenStreetMap.OpenStreetMapProvider());
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);
	    
	    Location valLoc = new Location(-23.5, 34.5);
	    PointFeature valEq = new PointFeature(valLoc);
	    valEq.addProperty("title", "SEattle,WA");
	    valEq.addProperty("magnitude", 9);
	    
	    Location valLoc1 = new Location(-19.5, -34.5);
	    PointFeature valEq1 = new PointFeature(valLoc1);
	    valEq1.addProperty("title", "SEattle,WA");
	    valEq1.addProperty("magnitude", 4);
	    
	    List<PointFeature> earthquakes = new ArrayList<PointFeature>();
	    earthquakes.add(valEq);
	    earthquakes.add(valEq1);
	    
	    
	    List<Marker> markers = new ArrayList<Marker>();


	    for(PointFeature eq : earthquakes){
	    	markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));	    	
	    }

	    map.addMarkers(markers);
	    
	    //To change the marker colors
	    
	    int red = color(220,20,60);
	    for(Marker mk : markers) {
	    	if((int) mk.getProperty("magnitude") > 6){
	    		mk.setColor(red);	    		
	    	}
	    }
	    		
	}
	public void draw(){
		background(255, 204, 0);
		map.draw();		
	}
	

}
