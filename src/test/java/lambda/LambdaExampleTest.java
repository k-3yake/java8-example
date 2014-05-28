package lambda;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import com.sun.prism.impl.Disposer.Target;

public class LambdaExampleTest {

//	@Test
//	public void old_ソートのテスト_小さい順にして返す() {
//		List<Integer> result = new LambdaExample().sort_old();
//		assertThat(result.get(0) , is(1));
//		assertThat(result.get(1) , is(2));
//		assertThat(result.get(2) , is(3));
//	}
//
//	@Test
//	public void new_ソートのテスト_小さい順にして返す() {
//	List<Integer> result = new LambdaExample().sort_new();
//	assertThat(result.get(0) , is(1));
//	assertThat(result.get(1) , is(2));
//	assertThat(result.get(2) , is(3));
//}

	@Test
	public void ソートのテスト_小さい順にして返す() {
		assertSort(()-> new LambdaExample().sort_old());
		assertSort(()-> new LambdaExample().sort_new());
	}

	public void assertSort(Supplier<List<Integer>> supplier) {
		List<Integer> result = supplier.get();
		assertThat(result.get(0) , is(1));
		assertThat(result.get(1) , is(2));
		assertThat(result.get(2) , is(3));
	}	

//	@Test
//	public void old_コールバック実行のテスト_事前処理実行後にコールバックを実行する() throws Exception {
//		List<String> logs = new LambdaExample().execCallback(new LambdaCallback() {
//			@Override
//			public String exec(){
//				return "callback";
//			}
//		});
//		assertThat(logs.get(0), is("before"));
//		assertThat(logs.get(1), is("callback"));
//		assertThat(logs.get(2), is("after"));
//	}
//
//	@Test
//	public void new_コールバック実行のテスト_事前処理実行後にコールバックを実行する() throws Exception {
//		List<String> logs = new LambdaExample().execCallback(()->"callback");
//		assertThat(logs.get(0), is("before"));
//		assertThat(logs.get(1), is("callback"));
//		assertThat(logs.get(2), is("after"));
//	}

	@Test
	public void コールバック実行のテスト_事前処理実行後にコールバックを実行する() throws Exception {
		assertProcessOrder(
				()->new LambdaExample().execCallback_old(new LambdaCallback() {
					@Override
					public String exec(){
						return "callback";
					}
				})
		);
		assertProcessOrder(()->new LambdaExample().execCallback_new(()->"callback"));
		assertProcessOrder(()->new LambdaExample().execCallback_new(LambdaCallback::execStatic));
	}

	public void assertProcessOrder(Supplier<List<String>> target) throws Exception {
		List<String> logs = target.get();
		assertThat(logs.get(0), is("before"));
		assertThat(logs.get(1), is("callback"));
		assertThat(logs.get(2), is("after"));
	}
}