package physicalObject;

public class Athletefactory implements objfactory<Athlete>{

	@Override
	public Athlete newobj() {
		// TODO Auto-generated method stub
		return new Athlete();
	}

}
