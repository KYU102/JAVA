package zooKeeper;

public class Mammal {
	private int energyLevel;

	// constructor
	public Mammal() {
		//set default values
		energyLevel = 100;	
	}
	
	public int getEnergyLevel() {
		return this.energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
