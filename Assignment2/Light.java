// Tsampiras Konstantinos, AM 4508, cse84508

import java.util.Random;

class Light extends Sensor
{
    // Attribute
    private Random randomDoubleValue = new Random();


    
    // My Constructor (without parameters)
    public Light() {
        super();
    }

    // Constructor that defines all the fields
    public Light(double lightValue, int sensorID, double randomValue) {
        super(lightValue, sensorID, randomValue);
    }

    // Copy Constructor
    public Light(Light other) {
    	super(other);
    }



    // equals method
    public boolean equals(Light other) {
    	if (this.getValue() == other.getValue()) {
    		return true;
    	}
    	return false;
    }
    
    // toString method
    public String toString() {
    	return "Foteinotita: " + String.format("%.2f", this.getValue()) + "; (SID: " + this.getSensorID()+ "); \n\t";
    }

    // update
    public void update() {
        super.setValue(200*randomDoubleValue.nextDouble());
    }

    // computeRandom 
    public double computeRandom() {
        double x = 200*randomDoubleValue.nextDouble();
        super.setRandomValue(x);
        return x;
    }
}