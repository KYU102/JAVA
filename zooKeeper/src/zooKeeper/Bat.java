package zooKeeper;

public class Bat extends Mammal {

	public Bat() {
//		super(x);
		this.setEnergyLevel(300);
	}
	
	public void fly(){
		this.setEnergyLevel(getEnergyLevel() - 50);
		System.out.println("WHOOOOOSH! - " + "Current Energy Level:" +  getEnergyLevel());
		
	}
	public void eatHumans(){
		this.setEnergyLevel(getEnergyLevel() + 25);
		System.out.println("MUNCH! - " + "Current Energy Level:" + getEnergyLevel());
		
	}
	public void attackTown(){
		this.setEnergyLevel(getEnergyLevel() - 100);
		System.out.println("OH THEY COMIN! - " + "Current Energy Level:" + getEnergyLevel());
		
	}
	
	
	
	
	


	
	

}
