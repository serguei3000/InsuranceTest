package south62.com.configuration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Settings {
	
	private  Map<String, BigDecimal> mapTypes = new HashMap<>();
	private  Map<Integer, BigDecimal> mapYear = new TreeMap<>();
	private Map<Integer, BigDecimal> mapSquare = new TreeMap<>();
	
	public Settings () {}
	public Settings(Map<String, BigDecimal> mapTypes, Map<Integer, BigDecimal> mapYear, Map<Integer, BigDecimal> mapSquare) {
		this.mapTypes = mapTypes;
		this.mapYear = mapYear;
		this.mapSquare = mapSquare;

	}
	public Map<String, BigDecimal> getMapTypes() {
		return mapTypes;
	}
	public void setMapTypes(Map<String, BigDecimal> mapTypes) {
		this.mapTypes = mapTypes;
	}
	public Map<Integer, BigDecimal> getMapYear() {
		return mapYear;
	}
	public void setMapYear(Map<Integer, BigDecimal> mapYear) {
		this.mapYear = mapYear;
	}
	public Map<Integer, BigDecimal> getMapSquare() {
		return mapSquare;
	}
	public void setMapSquare(Map<Integer, BigDecimal> mapSquare) {
		this.mapSquare = mapSquare;
	}

	
} 