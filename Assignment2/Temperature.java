// Tsampiras Konstantinos, AM 4508, cse84508

import java.util.Random;

class Temperature extends Sensor
{
    // Attribute
    private Random randomIntValue = new Random();



    // My Constructor (without parameters) 
    public Temperature() {
        super();
    }

    // Constructor that defines all the fields
    public Temperature(double temperatureValue, int sensorID, double randomValue) {
        super(temperatureValue, sensorID, randomValue);
    }
    
    // Copy Constructor
    public Temperature(Temperature other) {
    	super(other);
    }
    


    // equals method
    public boolean equals(Temperature other) {
    	if (this.getValue() == other.getValue()) {
    		return true;
    	}
    	return false;
    }
    
    // toString method
    public String toString() {
    	return "Thermokrasia: " + (int)this.getValue() + "; (SID: " + this.getSensorID() + "); \n\t";
    }
    
    // update 
    public void update() {
        super.setValue(randomIntValue.nextInt(101));
    }

    // computeRandom
    public double computeRandom() {
        double x = randomIntValue.nextInt(101);
        super.setRandomValue(x);
        return x;
    }
}