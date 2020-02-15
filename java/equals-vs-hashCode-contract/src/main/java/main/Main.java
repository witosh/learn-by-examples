package main;

import java.util.logging.Logger;

import model.Citizen;
import model.Person;

public class Main {
	
	private final static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[]args) {
		
		Person personJon = new Person("Jon", 22);
		Person doubledJon = personJon;
		Person personAnotherJon = new Person("Jon", 22);
		
		Citizen citizenGenry = new Citizen("Gendry");
		Citizen doubleGenry = citizenGenry;
		Citizen citizenAnotherGendry = new Citizen("Gendry");
		
		logger.info("-------Person object with override equals and hashCode");
		logger.info("personJon.equals(personAnotherJon): " + personJon.equals(personAnotherJon));
		logger.info("personJon.equals(doubledJon): " + personJon.equals(doubledJon));
		logger.info("personJon.hashCode(): " + personJon.hashCode());
		logger.info("doubledJon.hashCode(): " + doubledJon.hashCode());
		logger.info("personAnotherJon.hashCode(): " + personAnotherJon.hashCode());
		
		logger.info("-------Citizen object without override equals and hashCode");
		logger.info("personJon.equals(personAnotherJon): " + citizenGenry.equals(citizenAnotherGendry));
		logger.info("personJon.equals(doubledJon): " + citizenGenry.equals(doubleGenry));
		logger.info("personJon.hashCode(): " + citizenGenry.hashCode());
		logger.info("doubledJon.hashCode(): " + doubleGenry.hashCode());
		logger.info("personAnotherJon.hashCode(): " + citizenAnotherGendry.hashCode());
	}
}
