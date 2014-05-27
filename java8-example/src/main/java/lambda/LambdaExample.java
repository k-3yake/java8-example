package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class LambdaExample {

	public List<Integer> sort_old() {
		List<Integer> list = createList();
		Collections.sort(list,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});
		return list;
	}

	public List<Integer> sort_new() {
		List<Integer> list = createList();
		Collections.sort(list,(o1,o2)-> Integer.compare(o1, o2));
		return list;
	}

	private List<Integer> createList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(1);
		return list;
	}

	public List<String> execCallback_old(LambdaCallback lambdaCallback) {
		List<String> logs = new ArrayList<>();
		logs.add("before");
		logs.add(lambdaCallback.exec());
		logs.add("after");
		return logs;
	}

	public List<String> execCallback_new(Supplier<String> supplier) {
		List<String> logs = new ArrayList<>();
		logs.add("before");
		logs.add(supplier.get());
		logs.add("after");
		return logs;
	}
}
