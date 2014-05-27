package stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.junit.Test;

import com.sun.swing.internal.plaf.metal.resources.metal;

public class StramExampleTest {

	@Test
	public void fizzBuzzのテスト_3と5の倍数以外の場合_引数の文字列を返す() {
		assertThat("3と5の倍数以外の場合",new StramExample().fizzBuzz_old(1), is("1"));
		assertThat("3と5の倍数以外の場合",new StramExample().fizzBuzz_old(2), is("2"));
		assertThat("3と5の倍数以外の場合",new StramExample().fizzBuzz_old(98), is("98"));
		assertThat("3倍数の場合",new StramExample().fizzBuzz_old(3), is("fizz"));
		assertThat("3倍数の場合",new StramExample().fizzBuzz_old(99), is("fizz"));
		assertThat("5の倍数の場合",new StramExample().fizzBuzz_old(5), is("buzz"));
		assertThat("5の倍数の場合",new StramExample().fizzBuzz_old(100), is("buzz"));
		assertThat("15の倍数の場合",new StramExample().fizzBuzz_old(15), is("fizzbuzz"));
		assertThat("15の倍数の場合",new StramExample().fizzBuzz_old(90), is("fizzbuzz"));
	}

	@Test
	public void リストを受け取るfizzBuzzのテスト_1から100までのリストを受け取った場合_fizzbuzzそれ以外に振り分けて返す() {
		Map<String,List<String>> map = new StramExample().fizzBuzz_old(creteList());
		assertThat(map.size(),is(4));
		Integer valuesSize = 0;
		for(Entry<String, List<String>> entry:map.entrySet()){
			valuesSize += entry.getValue().size();
		}
		assertThat(valuesSize, is(100));
		assertContaint("etc", map, "1");
		assertContaint("etc", map, "2");
		assertContaint("etc", map, "98");
		assertContaint("fizz",map,"3");
		assertContaint("fizz",map,"99");
		assertContaint("buzz",map,"5");
		assertContaint("buzz",map,"100");
		assertContaint("fizzbuzz",map,"15");
		assertContaint("fizzbuzz",map,"90");
	}

	@Test
	public void リストを受け取るfizzBuzzのテスト_1から100までのリストを受け取った場合_fizzbuzzそれ以外に振り分けて返す_new() {
		Map<String,List<String>> map = new StramExample().fizzBuzz_new(creteList());
		assertThat(map.size(),is(4));
		assertThat(map.get("fizzbuzz").toString(),map.get("fizzbuzz").size(), is(6));
		assertThat(map.get("buzz").toString(),map.get("buzz").size(), is(14));
		assertThat(map.get("fizz").toString(),map.get("fizz").size(), is(27));
		assertThat(map.get("etc").toString(),map.get("etc").size(), is(53));
		Integer valuesSize = 0;
		for(Entry<String, List<String>> entry:map.entrySet()){
			valuesSize += entry.getValue().size();
		}
		assertThat(valuesSize, is(100));
		assertContaint("etc", map, "1");
		assertContaint("etc", map, "2");
		assertContaint("etc", map, "98");
		assertContaint("fizz",map,"3");
		assertContaint("fizz",map,"99");
		assertContaint("buzz",map,"5");
		assertContaint("buzz",map,"100");
		assertContaint("fizzbuzz",map,"15");
		assertContaint("fizzbuzz",map,"90");
	}

	private void assertContaint(String key,Map<String, List<String>> map, String str) {
		for(Entry<String, List<String>> entry : map.entrySet()) {
			String message = "str="+str +":expect="+key + ":actual=" + entry.getKey();
			if(entry.getKey().equals(key)){
				assertThat(message,entry.getValue().contains(str),is(true));		
			}else{
				assertThat(message,entry.getValue().contains(str),is(false));		
			}
		}
	}
	
	private List<Integer> creteList(){
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=100 ; i++){
			list.add(i);
		}
		return list;
	}
	
}