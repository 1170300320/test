package circularorbit;

import centralObject.Personcenter;
import physicalObject.Person;

public class Socialfactory implements factory<Personcenter<Person>,Person>{
	@Override
	public ConcreteCircularOrbit<Personcenter<Person>,Person> c() {
		// TODO Auto-generated method stub
		return new SocialNetworkCircle();
	}

}
