package circularorbit;

import centralObject.Atomcenter;
import physicalObject.Atom;

public class Atomfactory implements factory<Atomcenter<Atom>,Atom>{

	@Override
	public ConcreteCircularOrbit<Atomcenter<Atom>,Atom> c() {
		// TODO Auto-generated method stub
		return new AtomStructure();
	}

}
