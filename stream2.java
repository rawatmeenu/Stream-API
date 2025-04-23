import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
public class stream2 {
    public static void main(String args[])
    {
        //counting count of empty stream
        Stream<String> str = Stream.empty();
        System.out.println("Empty stream str:" + str.count());

        List<String> list = Arrays.asList("abc","hbc","gdyuw");
        Stream<String> str1= list.stream();
        System.out.println("arrays of stream list: " + str1);
        str1.forEach(System.out::println);


        String[] arr = {"nee", "bucs", "nocs"};
        Stream<String> str2= Arrays.stream(arr);
        str2.forEach(System.out::println);


        Stream<Double> steamgenerated= Stream.generate(Math::random).limit(3);
        steamgenerated.forEach(System.out::println);


        Stream<Integer> stream2 = Stream.iterate(0, n -> n+2).limit(4);
        stream2.forEach(System.out::println);


        LongStream n= LongStream.range(34,40);
        n.forEach(System.out::println);

        List<String> lisst = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        lisst.stream().filter(s -> s.startsWith("a")). map(String::toUpperCase).sorted().forEach(System.out::println);

        List<String> list2 = Arrays.asList("d2", "a2", "b1", "b3", "c");
        list2.stream().map(s -> { System.out.println("map" +s);
                    return s.toUpperCase();})

                .filter(s->{ System.out.println(s);
                    return s.startsWith("A");}).
                forEach(s-> System.out.println("output"+s));


        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5);
        Integer um = list4.stream().reduce(0, (a,b) -> a+b);
        System.out.println("reduct---- " + um);

        List<String> list5 = Arrays.asList("a", "b", "c", "d");
        List<String> upperca= list5.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("coll--- "+ upperca);

        List<String> palist = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        palist.parallelStream().filter(s -> {System.out.println("para** " +s);
                    return true;}).
                map(s-> {System.out.println("uppercase**** "+s);
                    return s.toUpperCase();}).
                forEach(s -> System.out.println(s));

        List<String> list8 = Arrays.asList("abc1", "abc2", "abc3");
        System.out.println("**************");
        long size = list8.stream().skip(1).map(el -> el.substring(0,2)).sorted().count();



        List<String> fruits= Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");
        Optional<String> optfr=fruits.stream().max(Comparator.comparingInt(String::length));
        System.out.println(optfr);


        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> word= words.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(word);

        //fibonacci series
//		Stream<Long> fib = Stream.iterate(new long[]{0,1}, f-> new long[] {f[1],f[0]+f[1]}).mapToLong(f -> f[0]);
//		fib.limit(10).forEach(System.out::println);
//

        Stream.iterate(new long[] {0,1}, f-> new long[]{f[1],f[0]+f[1]})
                .map(f->f[0]).
                limit(10).forEach(System.out::println);


        String element = "Hello world";
        String unique= element.chars().distinct().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
        System.out.println(unique);



        //longest common substring
        List<String> strings = Arrays.asList("flower", "flow", "flight", "flask");
        String prestr= strings.stream().reduce((s1,s2) ->{
            int min= Math.min(s1.length(), s2.length());
            int i=0;
            while(i<min && s1.charAt(i) == s2.charAt(i))
            {
                i++;
            }
            return s1.substring(0,i);}).orElse("");
        System.out.println(prestr);

    }
}
