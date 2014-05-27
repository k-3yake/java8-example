package optional;

import java.util.Optional;

public class OptionalExample {

	public String add_new(String arg) {
		return Optional.ofNullable(arg).orElse("").concat("sufix");
	}

	public String add_old(String arg) {
		final String str;
		if(arg == null){
			str = "";
		}else{
			str = arg;
		}
		return str.concat("sufix");
	}

}