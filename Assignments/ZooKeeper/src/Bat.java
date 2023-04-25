
public class Bat extends Mammal{
	public Bat() {
		this.energyLevel=300;
	}
	
	public int fly() {
	System.out.println("Bat taking off sound in the background");
	this.energyLevel-=50;
	this.displayEnergy();
	return this.energyLevel;
	
	}
	
	public int eatHumans() {
		this.energyLevel+=25;
		this.displayEnergy();
		return this.energyLevel;
	}
	
	public int attackTown() {
		System.out.println("Fire burning the town sound in the background");
		this.energyLevel-=100;
		this.displayEnergy();
		return this.energyLevel;
	}
}

