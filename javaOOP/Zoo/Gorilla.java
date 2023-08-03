package zoo;

public class Gorilla extends Mammal {
	public Gorilla() {
		// TODO Auto-generated constructor stub
	}
	
	public void throwSomething () {
		System.out.println("throwSomething");
		setEnergy(getEnergy() - 5);
	}
	public void eatBanana () {
		System.out.println("eatBanana");
		setEnergy(getEnergy() + 10);
	}
	public void climb () {
		System.out.println("climb");
		setEnergy(getEnergy() - 10);
		
	}
}
