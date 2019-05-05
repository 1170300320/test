package circularorbit;

import centralObject.Athletecenter;
import physicalObject.Athlete;

public class Athletefactory implements factory<Athletecenter<Athlete>,Athlete>{

	@Override
	public ConcreteCircularOrbit<Athletecenter<Athlete>,Athlete> c() {
		// TODO Auto-generated method stub
		return new AthleteSystem();
	}

}
