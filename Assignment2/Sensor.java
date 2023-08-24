// Tsampiras Konstantinos, AM 4508, cse84508

import java.util.Random;

abstract class Sensor 
{
    // Attributes
    private double value;
    private int sensorID;
    private double randomValue;
    private Random rand = new Random();



    // My Constructor (without parameters)
    public Sensor() {
        this.value = randomValue;
        computeRandomID();
    }

    // Constructor that defines all the fields
    public Sensor(double value, int sensorID, double randomValue) {
        this.value = value;
        this.sensorID = sensorID;
        this.randomValue = randomValue;
    }

    // Copy Constructor
    public Sensor(Sensor other) {
        other.value = this.getValue();
        other.sensorID = this.getSensorID();
        other.randomValue = this.getRandomValue();
    }



    // update 
    public abstract void update();

    // computeRandomID
    public void computeRandomID() {
        setSensorID(rand.nextInt(1000000000));
    }

    // equals method
    public boolean equals(Sensor other) {
        if (this.value == other.value && this.sensorID == other.sensorID) {
            return true;
        }
        return false;
    }

    // toString method
    public String toString() {
        return "value: " + value + " id: " + sensorID + " ;";
    }

    // Accessors
    public double getValue() {
        return value;
    }

    public int getSensorID() {
        return sensorID;
    }

    public double getRandomValue() {
        return randomValue;
    }

    // Mutators
    public void setValue(double value) {
        this.value = value;
    }

    public void setSensorID(int sensorID) {
        this.sensorID = sensorID;
    }

    public void setRandomValue(double randomValue) {
        this.randomValue = randomValue;
    }
}