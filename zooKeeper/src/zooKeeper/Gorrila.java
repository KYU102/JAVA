package zooKeeper;

public class Gorrila extends Mammal{


	public void throwSomething(){
		this.setEnergyLevel(getEnergyLevel() - 5);
		System.out.println("Gorilla threw poop!" + getEnergyLevel());
		
	}
	public void eatBananas(){
		this.setEnergyLevel(getEnergyLevel() + 10);
		System.out.println("Gorilla ate a banana!" + getEnergyLevel());
	}
	public void climb(){
		this.setEnergyLevel(getEnergyLevel() - 10);
		System.out.println("Gorilla is climbing!" + getEnergyLevel());
	}
	
}
