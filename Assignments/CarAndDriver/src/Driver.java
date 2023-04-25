
public class Driver extends Car {
	public void drive() {
		this.gas-=1;
		System.out.println("You drive the car");
		System.out.println("Remaining gas :" +this.getGas() +"/10");
	}
	
	public void useBoosters() {
		this.gas-=3;
		System.out.println("You used boosters");
		System.out.println("Remaining gas :" +this.getGas() +"/10");
	}
	
	public void refuel() {
		this.gas+=2;
		System.out.println("You refueled the car");
		System.out.println("Remaining gas :" +this.getGas() +"/10");
	}
}
