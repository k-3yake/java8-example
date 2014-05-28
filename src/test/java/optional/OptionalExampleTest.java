package optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class OptionalExampleTest {

	@Test
	public void 文字列結合のテスト_引数がnullの場合_sufixのみ返す() {
		assertThat(new OptionalExample().add_old(null), is("sufix"));
		assertThat(new OptionalExample().add_new(null), is("sufix"));
	}

	@Test
	public void 文字列結合のテスト_引数がnul以外の場合_引数とsufixを連結して返す() {
		assertThat(new OptionalExample().add_old("hoge"), is("hogesufix"));
		assertThat(new OptionalExample().add_new("hoge"), is("hogesufix"));
	}

}