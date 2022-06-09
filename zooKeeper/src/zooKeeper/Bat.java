package zooKeeper;

public class Bat extends Mammal {

	public Bat(int x) {
		super(x);
//		int energyLevel = 300;
	}
	
	public void fly(){
		this.setEnergyLevel(getEnergyLevel() - 50);
		System.out.println("WHOOOOOSH!" + getEnergyLevel());
		
	}
	public void eatHumans(){
		this.setEnergyLevel(getEnergyLevel() + 25);
		System.out.println("MUNCH!" + getEnergyLevel());
		
	}
	public void attackTown(){
		this.setEnergyLevel(getEnergyLevel() - 100);
		System.out.println("oh they comin" + getEnergyLevel());
		
	}
	
	
	
	
	


	
	

}
