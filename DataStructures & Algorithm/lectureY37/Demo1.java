import java.util.HashMap;

public class Demo1 {

	public static void main(String[] args) {
		HashMap<String,Integer> phone = new HashMap<>();
		phone.put("amit",2222);
		phone.put("ram", 3333);
		System.out.println(phone.get("ram"));
		//phone.remove("ram");
		System.out.println(phone);
		System.out.println(phone.containsKey("amit")?"Found":"Not Found");

	}

}
