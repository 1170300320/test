package APIs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Difference<L,E> {
	private int num;
	private List<Integer> dif = new ArrayList<>();
	private List<Set<E>> detaildifa = new ArrayList<>();
	private List<Set<E>> detaildifb = new ArrayList<>();
	public int getNum() {
		int n = num;
		return n;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Integer> getDif() {
		List<Integer> d = dif;
		return d;
	}

	public void setDif(List<Integer> dif) {
		this.dif = dif;
	}

	public List<Set<E>> getDetaildifa() {
		List<Set<E>> d = detaildifa;
		return d;
	}

	public void setDetaildifa(List<Set<E>> detaildifa) {
		this.detaildifa = detaildifa;
	}

	public List<Set<E>> getDetaildifb() {
		List<Set<E>> d = detaildifb;
		return d;
	}

	public void setDetaildifb(List<Set<E>> detaildifb2) {
		this.detaildifb = detaildifb2;
	}

}
