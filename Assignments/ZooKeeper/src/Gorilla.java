
public class Gorilla extends Mammal {
	public int throwSomething() {
		System.out.println("I am a Gorilla and I threw something");
		this.energyLevel-=5;
		this.displayEnergy();
		return this.energyLevel;
	}
	
	public int eatBananas() {
		System.out.println("I am a Gorilla and I just ate a banana and it was very delicious");
		this.energyLevel+=10;
		this.displayEnergy();
		return this.energyLevel;
	}
	
	public int climb() {
		System.out.println("I am a Gorilla and I just climbed a tree");
		this.energyLevel-=10;
		this.displayEnergy();
		return this.energyLevel;
	}
	
	
}
