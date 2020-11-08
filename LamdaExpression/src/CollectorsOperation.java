import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsOperation {
	List<String> givenList = Arrays.asList("aaa", "bbb", "ccc", "ddd");
	List intList = Arrays.asList(10, 20, 30, 40, 50);

	public void Example1() {
		List<String> list = givenList.stream().collect(Collectors.toList());
		long count = list.stream().collect(Collectors.counting());

		// Averaging int
		Double result1 = (Double) intList.stream().collect(Collectors.averagingInt(v -> Integer.parseInt(v.toString())));
		System.out.println(result1);

		Double result2 = (Double) intList.stream().collect(Collectors.averagingInt(v -> Integer.parseInt(v.toString()) * Integer.parseInt(v.toString())));
		System.out.println(result2);
		
		String  stringWithHyphen = givenList.stream().collect(Collectors.joining("-"));
		System.out.println("String with hyphen : "+stringWithHyphen);
		String  stringWithHyphenAndPrefixAndSuffix = givenList.stream().collect(Collectors.joining("-","==","=="));
		System.out.println("String with hyphen , suffix and prefix :  "+stringWithHyphenAndPrefixAndSuffix);	
		
		Double result3 =  Double.parseDouble(intList.stream().collect(Collectors.summingInt(v->Integer.parseInt(v.toString()))).toString());
		System.out.println(result3);
		
		Double result4 = Double.parseDouble(intList.stream().collect(Collectors.summingInt(v->Integer.parseInt(v.toString())*Integer.parseInt(v.toString()))).toString());
		System.out.println(result4);
		
		int result5 = (int) intList.stream().collect(Collectors.collectingAndThen(Collectors.summingInt(v->(int)v),result->result/2));
		System.out.println(result5);
	}
}
