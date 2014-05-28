package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StramExample {
	
	public Map<String, List<String>> fizzBuzz_new(List<Integer> valueList) {
		Map<String, List<String>> map = new HashMap<>();
//		valueList.stream().filter(i ->i%15 == 0).forEach(i -> add(map,"fizzbuzz",i));
//		valueList.stream().filter(i ->i%15 != 0 && i%5 == 0).forEach(i -> add(map,"buzz",i));
//		valueList.stream().filter(i ->i%15 != 0 && i%3 == 0).forEach(i -> add(map,"fizz",i));
//		valueList.stream().filter(i ->i%15 != 0 && i%5 != 0 && i%3 !=0 ).forEach(i -> add(map,"etc",i));

//		valueList.stream().forEach(i -> { 
//		switch (fizzBuzz_old(i)) {
//		case "fizz":
//		case "buzz":
//		case "fizzbuzz":
//			add(map,fizzBuzz_old(i),i);
//			break;
//		default:
//			add(map,"etc",i);
//			break;
//		}
//	});

		valueList.forEach(i -> { 
			switch (fizzBuzz_old(i)) {
			case "fizz":
			case "buzz":
			case "fizzbuzz":
				add(map,fizzBuzz_old(i),i);
				break;
			default:
				add(map,"etc",i);
				break;
			}
		});
		
		return map;
	}
	
	public Map<String,List<String>> fizzBuzz_old(List<Integer> values) {
		Map<String, List<String>> map = new HashMap<>();
		for (Integer value: values) {
			switch (fizzBuzz_old(value)) {
			case "fizz":
			case "buzz":
			case "fizzbuzz":
				add(map,fizzBuzz_old(value),value);
				break;
			default:
				add(map,"etc",value);
				break;
			}
		}
		return map;
	}

	private void add(Map<String, List<String>> map, String key, Integer value) {
		if(map.get(key) == null){
			map.put(key,new ArrayList<>());
		}
		map.get(key).add(value.toString());
	}

	protected String fizzBuzz_old(Integer i) {
		if(i % 15 ==0){
			return "fizzbuzz";
		}else if(i % 5 == 0){
			return "buzz";
		}
		if(i % 3 == 0){
			return "fizz";
		}
		return i.toString();
	}




}