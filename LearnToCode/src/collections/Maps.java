package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;

public class Maps {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		Integer c = map.getOrDefault(args, 0);
		System.out.println(c);//0
		System.out.println(map.get(args));//null
		map.put("1",11);
		System.out.println(map.put("1",100));//11
		Map<String, Integer> map2 = new HashMap<>(map);
		map.put(map2.toString(), 3);
		System.out.println(map);//{1=100, {1=100}=3}
		System.out.println(map.get("1"));//100
	}

}
