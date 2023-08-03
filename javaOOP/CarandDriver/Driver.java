package CarandDriver;

public class Driver extends Car {
	
	
	private String name;
	
	public Driver () {
		this.name = "Messi";
    }
	public void drive () {
		this.setGas(getGas() - 1);
		System.out.println("gas " + getGas());
		
	}
	public void Usebooster () {
		this.setGas(getGas() - 3);
		System.out.println("Usebooster gas " + getGas());
	}
	public void useRefueling () {
		this.setGas(getGas() + 2);
		System.out.println(" useRefueling gas " + getGas());
		
	}
}
