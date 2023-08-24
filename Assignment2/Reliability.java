// Tsampiras Konstantinos, AM 4508, cse84508

import java.lang.Math;

class Reliability
{
    // Attributes
    private double temperatureReliability;
    private double lightReliability;
    private double totalReliability;
    private int timePassed = 1;



    // My Constructor (without parameters)
    public Reliability() {
        temperatureReliability = Math.exp(-0.001*timePassed);
        lightReliability = Math.exp(-0.001*timePassed);
        totalReliability = temperatureReliability*lightReliability;
        timePassed = 1;
    }
    
    // Constructor that defines all the fields
    public Reliability(double temperatureReliability, double lightReliability, double totalReliability, int timePassed) {
    	this.temperatureReliability = temperatureReliability;
    	this.lightReliability = lightReliability;
    	this.totalReliability = totalReliability;
    	this.timePassed = timePassed;
    }
    
    // Copy Constructor
    public Reliability(Reliability other) {
    	this.temperatureReliability = other.getTemperatureReliability();
    	this.lightReliability = other.getLightReliability();
    	this.totalReliability = other.getTotalReliability();
    	this.timePassed = other.getTimePassed();
    }



    // equals method
    public boolean equals(Reliability other) {
    	if (this.temperatureReliability == other.temperatureReliability && this.lightReliability == other.lightReliability && 
    		this.totalReliability == other.totalReliability && this.timePassed == other.timePassed) {
    		return true;
    	}
    	return false;
    }
    
    // toString method
    public String toString() {
    	return "Synoliki aksiopistia: " + String.format("%.2f", this.getTotalReliability()) + "; ";
    }
    
    // Accessors
    public double getTemperatureReliability() {
        return temperatureReliability;
    }

    public double getLightReliability() {
        return lightReliability;
    }

    public double getTotalReliability() {
        return totalReliability;
    }

    public int getTimePassed() {
        return timePassed;
    }

    // Mutators
    public void setTemperatureReliability(double temperatureReliability) {
        this.temperatureReliability = temperatureReliability;
    }

    public void setLightReliability(double lightReliability) {
        this.lightReliability = lightReliability;
    }

    public void setTotalReliability(double totalReliability) {
        this.totalReliability = totalReliability;
    }

    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
    }

    // updateReliability
    public void updateReliability() {
        timePassed++;
        temperatureReliability = Math.exp(-0.001*timePassed);
        lightReliability = Math.exp(-0.001*timePassed);
        totalReliability = temperatureReliability*lightReliability;
    }
}