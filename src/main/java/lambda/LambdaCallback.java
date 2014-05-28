package lambda;

public interface LambdaCallback {

	String exec();
	
	public static String execStatic(){
		return "callback";
	}

}
