import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String args[])
    {
        List<String> dept = new ArrayList<>();
        dept.add("HR");
        dept.add("sales");
        dept.add("computer science");
        dept.add("Supply");
        dept.add("Marketing");

        Stream<String> depstream = dept.stream();
        depstream.forEach(System.out::println);

        System.out.println("*********************");

        Stream<String> instream = Stream.of("Easy", "java", "oevrriding");
        instream.forEach(System.out::println);

        System.out.println("*********************");

        Stream<String> parastream = dept.parallelStream();
        parastream.forEach(System.out::println);

        System.out.println("*********************");

        Stream<String> emp= Stream.empty();
        emp.forEach(System.out::println);

        System.out.println("*********************");

        Stream<String> mapdep= dept.stream();
        //mapdep.map(wor -> wor.toUpperCase()).forEach(System.out::println);

        dept.stream().map(word -> word.toUpperCase()).forEach(System.out::println);

        //FLATMAP
        String[] arrwords = {"first", "second", "third", "fourth"," fifth"};
        Stream<String> strwords= Arrays.stream(arrwords);
        Stream<String[]> arr2words= strwords.map(word -> word.split(" "));
        arr2words.flatMap(Arrays::stream).forEach(System.out::println);

        System.out.println("**************************");
        //FILTER
        dept.stream().filter(word -> word.startsWith("S")).forEach(System.out::println);

        //LIMIT
        Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);

        //SKIP: skip first 5 values and limit upto 10th number
        Stream.iterate(1, n-> n+1).limit(10).skip(5).forEach(System.out::println);

        //REDUCE(terminal)
        System.out.println(Stream.iterate(1, n-> n+1).limit(5).reduce(0, (a,b)-> a+b));

        //COLLECT(terminal)
        List<String> names = List.of("Sunil", "till", "sonal");
        //Stream<String> strnames = names.stream();

        List<String> liststream = names.stream().filter(word -> word.startsWith("s")).collect(Collectors.toList());
        liststream.forEach(System.out::println);





    }
}
