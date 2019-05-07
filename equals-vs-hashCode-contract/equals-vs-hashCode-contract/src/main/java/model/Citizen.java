package model;

public class Citizen {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Citizen(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Citizen [name=" + name + "]";
	}
}
