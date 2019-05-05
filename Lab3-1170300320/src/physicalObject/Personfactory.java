package physicalObject;

public class Personfactory implements objfactory<Person>{

	@Override
	public Person newobj() {
		// TODO Auto-generated method stub
		return new Person();
	}

}
