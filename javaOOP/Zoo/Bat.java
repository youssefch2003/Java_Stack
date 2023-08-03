package zoo;

public class Bat extends Mammal {
    private int energy;

	public Bat() {
        this.energy =300;
    }

    public void fly() {
        System.out.println("Bat  fly");
        setEnergy(getEnergy() - 50);
    }

    public void eatHumans() {
	    System.out.println("Bat has eaten a human");
	    setEnergy(getEnergy() + 25);
	}


    public void attackTown() {
        System.out.println(" Bat is attacking");
        setEnergy(getEnergy() - 100);
    }
    
}

