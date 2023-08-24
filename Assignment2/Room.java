// Tsampiras Konstantinos, AM 4508, cse84508

class Room implements Comparable<Room>
{
    // Attributes
    private Integer roomID;
    private Temperature tempSensor;
    private Light lightSensor;
    private Reliability reliabilityOfSensors;



    // My Constructor (only with roomID as parameter)
    public Room(Integer roomID) {
        this.roomID = roomID;
        tempSensor = new Temperature();
        lightSensor = new Light();
        tempSensor.update();
        lightSensor.update();
        reliabilityOfSensors = new Reliability();
    }
    
    // Constructor that defines all the fields
    public Room(Integer roomID, Temperature tempSensor, Light lightSensor, Reliability reliabilityOfSensors) {
    	this.roomID = roomID;
    	this.tempSensor = tempSensor;
    	this.lightSensor = lightSensor;
    	this.reliabilityOfSensors = reliabilityOfSensors;
    }
    
    // Copy Constructor
    public Room(Room other) {
    	this.roomID = other.getRoomID();
    	this.tempSensor = new Temperature(tempSensor);
    	this.lightSensor = new Light(lightSensor);
    	this.reliabilityOfSensors = new Reliability(reliabilityOfSensors);	
    }



    // equals method
    public boolean equals(Room other) {
        if (this.roomID == other.roomID) {
            return true;
        }
        return false;
    }

    // toString method
    public String toString() {
        String x = "Area: " + roomID.toString() + "; \n\t" + tempSensor.toString() + lightSensor.toString() + reliabilityOfSensors.toString();
        if (this.getTempSensor() > 50 && this.getLightSensor() > 140.0 && this.getReliabilityOfSensors() > 0.9) {
            x += "\n\t- Entopistike Pyrkagia !!!\n";
        } else {
            x += "\n\t- Den yparxei pyrkagia\n";
        }
        return x;
    }

    // Accessors
    public Integer getRoomID() {
		return roomID;
    }

    public int getTempSensor() {
        return (int)tempSensor.getValue();
    }

    public double getLightSensor() {
        return lightSensor.getValue();
    }

    public double getReliabilityOfSensors() {
        return reliabilityOfSensors.getTotalReliability();
    }
    
    public int getTime() {
    	return reliabilityOfSensors.getTimePassed();
    }
    
    // Mutators
    public void setRoomID(Integer roomID) {
		this.roomID = roomID;
    }
    
    public void setTempSensor(int temperatureValue) {
        tempSensor.setValue(temperatureValue);
    }

    public void setLightSensor(double lightValue) {
        lightSensor.setValue(lightValue);
    }

    public void setReliabilityOfSensors(double totalReliability) {
        reliabilityOfSensors.setTotalReliability(totalReliability);
    }

    public void setTime(int timePassed) {
    	reliabilityOfSensors.setTimePassed(timePassed);
    }
    
    // updater
    public void updater() {
        tempSensor.update();
        lightSensor.update();
        reliabilityOfSensors.updateReliability();
    }

    // compareTo
    public int compareTo(Room other) {
    	return this.getRoomID().compareTo(other.getRoomID());
    }
}