package StreamsDemo;


import graphql.org.antlr.v4.runtime.tree.Tree;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Use list.stream().max(Comparator.reverseOrder()) for getting max of any list => reverseOrder() method is static so should be called directly with Comparator class name
// Use list.stream().sorted(Comparator.reverseOrder())  => for normal lists of strings or integers (OR)
// list.stream().sorted(Comparator.comparingDouble(Person::getSalary)) => For getting nth highest salary with classes

/*
*         Arrays.asList("").stream()
                        .max(Comparator.comparing(Function.identity()));

        Arrays.asList("").stream()
                        .max(Comparator.naturalOrder());

        Arrays.asList("").stream()
                        .max((o1,o2)-> o1.compareToIgnoreCase(o2));
* */
public class JavaEightFeatures {



    static Supplier<Stream<String>> supplier = ()->{
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");
        return memberNames.stream();
    };

    public static void collectorsDemo(){
         supplier.get().collect(Collectors.toList());
         supplier.get().collect(Collectors.toUnmodifiableList()); // Arrays.asList() also returns UnModifiableList
        //supplier.get().collect(Collectors.toSet()).forEach(System.out::println);
        supplier.get().collect(Collectors.toMap(s -> s, s-> s.length()));
        supplier.get().collect(Collectors.toMap(Function.identity(), s-> s.length()));// same as above
        supplier.get().collect(Collectors.toMap(Function.identity(), String::length));
        // Other than list, set and Map
        supplier.get().collect(Collectors.toCollection(LinkedList::new));
        supplier.get().collect(Collectors.toCollection(LinkedHashSet::new)); // We can use this in case of preserving order
        supplier.get().collect(Collectors.toCollection(Vector::new));
        supplier.get().collect(Collectors.toCollection(ArrayDeque::new));


        // ********************************* Collectors with 3 parameters *********************************

        TreeMap<String, Set<Person>> treeParam = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment, TreeMap::new, Collectors.toSet()));
        // OR
        TreeMap<String, HashSet<Person>> collect1 = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment, () -> new TreeMap<>(), Collectors.toCollection(HashSet::new)));

        getPersonsList().stream().collect(Collectors.groupingBy(Person::getGender, TreeMap::new, Collectors.toCollection(HashSet::new)));

        // Function.identity() is a short-circuit operator which accepts and returns same value.
        //Function<String, String> identity = Function.identity();
//      //System.out.println(identity.apply("Surendra"))////
//      supplier.get().collect(Collectors.toMap(name -> name, String::length));
//      //supplier.get().distinct().collect(Collectors.toMap(Function.identity(), String::length));// name -> name,is replaced with Function.identity()

        supplier.get().collect(Collectors.joining(" @ ", "[", "]"));// [ssr @ ffg @ hhj]
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().mapToInt(Integer::intValue).max().getAsInt();
        integers.stream().min(Comparator.naturalOrder());
        integers.stream().max(Comparator.naturalOrder());// for max
        Integer sum = integers.stream().mapToInt(Integer::intValue).sum();
        integers.stream().sorted();
                //.reduce(0, (a, b) -> a + b);

        integers.stream()
                .max(Integer::compareTo);
        integers.stream().max(Comparator.naturalOrder());

        integers.stream()
                .max((o1, o2)-> o1.compareTo(o2));

        integers.stream()
                .max(Integer::max);

        integers.stream()
                .max(Integer::compareTo);

        integers.stream()
                .sorted(Integer::compare);

        integers.stream()
                .mapToInt(Integer::valueOf)
                .max();

        Optional<Integer> collect = integers.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));

        // Get min / max values by Comparator.compare, Comparator.compareTo(which internally uses compare()), Integer::max, Integer::min

    }

    public static void streamSamples(){
        supplier.get()
                .filter(name -> name.startsWith("Am"))
                .forEach(System.out::println);

        Boolean aBoolean = supplier.get()
                .anyMatch(name -> name.equalsIgnoreCase("Yana"));

        boolean bBollean = supplier.get()
                .noneMatch(name -> name.equalsIgnoreCase("suri"));

        boolean all = supplier.get()
                .allMatch(name -> name.equalsIgnoreCase("ssr"));

        supplier.get()
                .map(String::length).forEach(System.out::println);

        supplier.get()
                .map(String::length)
                .distinct()
                .sorted(Integer::max);

        supplier.get()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        supplier.get()
                .sorted(String::compareToIgnoreCase);

        // Get The Highest salary
        Optional<Person> max = getPersonsList().stream()
                .max(Comparator.comparingDouble(Person::getSalary));

        // Get MINIMUM salaried
        Person person2 = getPersonsList().stream()
                        .min(Comparator.comparingDouble(Person::getSalary)).get();

        // Get 4th highest salary of a person
        getPersonsList().stream()
                .map(Person::getSalary)
                .sorted(Comparator.reverseOrder())
                .skip(3)
                .findFirst()
                .get();

        Optional<Double> aDouble = getPersonsList().stream()
                .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                .skip(3)
                .findFirst()
                .map(Person::getSalary);

        Integer integer = aDouble.map(Double::intValue).orElse(0);

        // Comparing by multiple props
        getPersonsList().stream()
                .sorted(Comparator.comparingDouble(Person::getSalary).thenComparing(Person::getName))
                .forEach(System.out::println);

        // Filtering by multiple Predicates or Predicate chain
        Predicate<Person> predicate1 = person -> person.getSalary() > 2000;
        Predicate<Person> predicate2 = person -> person.getAge() > 20;
        getPersonsList().stream()
                .filter(predicate1.and(predicate2))
                .forEach(System.out::println);

        getPersonsList().stream()
                        .min(Comparator.comparing(Person::getName));
        Arrays.asList("abc").stream().sorted(Comparator.comparing(Function.identity()));
        Arrays.asList(1,2).stream().sorted(Comparator.comparing(Function.identity()));

        // Filter Male persons
        getPersonsList().stream()
                .filter(person -> person.getGender().equalsIgnoreCase("M"))
                .forEach(System.out::println);

        // Count no of Female & Male persons
        Map<String, Long> map = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));

        // Find average salary of males & Female - PART 1
        getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.averagingDouble(Person::getSalary)));

        // Find average salary of males & Female - PART 2
        Map<String, Double> collect13 = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().collect(Collectors.averagingDouble(Person::getSalary))
                )));

        // Get min salaried in both men & women
        getPersonsList().stream().collect(Collectors.groupingBy(
                Person::getGender,
                Collectors.minBy(Comparator.comparingDouble(Person::getSalary))
                ));

        // Get 2nd least salaried => gender wise
        getPersonsList().stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.collectingAndThen(
                                Collectors.toCollection(ArrayList::new),
                                arrayList -> arrayList.stream()
                                        .sorted(Comparator.comparing(Person::getSalary)) // can also use comparing double
                                        .skip(1)
                                        .findFirst()
                                        .get()
                        )
                ));

        TreeMap<String, Long> collect16 = getPersonsList().stream()
                .collect(Collectors.groupingBy(p -> p.getGender(), TreeMap::new, Collectors.counting()));

        System.out.println(map); // { M = 2, F = 2}

        // Minimum salaried person
        getPersonsList().stream()
                .sorted(Comparator.comparingDouble(Person::getSalary))
                .findFirst();

        // (OR)
        String person = getPersonsList().stream()
                .min(Comparator.comparingDouble(Person::getSalary))
                .get().getName();

        String s = getPersonsList().stream()
                .min(Comparator.comparingDouble(Person::getSalary))
                .map(Person::getName)
                .orElse("Default");

        // 3rd minimum salaried in each department
        Map<String, Person> collect19 = getPersonsList().stream()
                .collect(Collectors.groupingBy(
                        p -> p.getDepartment(),
                        Collectors.collectingAndThen(
                                Collectors.toCollection(ArrayList::new),
                                arrayList -> arrayList.stream()
                                        .sorted(Comparator.comparingDouble(Person::getSalary))
                                        .skip(2)
                                        .findFirst()
                                        .get()
                        )
                ));

        // 3rd minimum salaried in each department gender wise - Part1
        Map<String, Map<String, Person>> collect20 = getPersonsList().stream()
                .collect(Collectors.groupingBy(
                        Person::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toUnmodifiableList(),
                                list -> list.stream()
                                        .collect(Collectors.groupingBy(
                                                Person::getGender,
                                                Collectors.collectingAndThen(
                                                        Collectors.toCollection(ArrayList::new),
                                                        arrayList -> arrayList.stream()
                                                                .sorted(Comparator.comparingDouble(Person::getSalary))
                                                                .skip(2)
                                                                .findFirst()
                                                                .get()
                                                )
                                        ))
                        )
        ));

        // 3rd minimum salaried in each department gender wise - Part2
        Map<String, Map<String, List<Person>>> groupedByDeptAndGender = getPersonsList().stream().collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.groupingBy(Person::getGender, Collectors.toCollection(ArrayList::new))
        ));
        groupedByDeptAndGender.forEach((department, genderGroupedMap)->{
            genderGroupedMap.forEach((gender, list) -> {
                Person person1 = list.stream().sorted(Comparator.comparingDouble(Person::getSalary))
                        .skip(2)
                        .findFirst().get();
                System.out.println("3rd min salaried person from dept: "+ department + "is "+ person1.getName() + " and their gender is "+person1.getGender());
            });
        });


        // Maximum salaried
        getPersonsList().stream()
                        .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                                .findFirst().get().getName();

        getPersonsList().stream()
                        .max(Comparator.comparingDouble(Person::getSalary))
                                .get().getName();

        getPersonsList().stream()
                .max(Comparator.comparingDouble(Person::getSalary))
                .get().getName();

        // Find the elder/ older person
        getPersonsList().stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get().getName();

        // Elder person gender wise
        Map<String, Optional<Person>> collect21 = getPersonsList().stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.maxBy(Comparator.comparingInt(Person::getAge))
                ));

        // Elder in each dept
        Map<String, Optional<Person>> collect22 = getPersonsList().stream()
                .collect(Collectors.groupingBy(
                        p -> p.getDepartment(),
                        Collectors.maxBy(Comparator.comparingInt(P -> P.getAge()))
                ));

        // Elder male and female in each department
        Map<String, Map<String, List<Person>>> collect23 = getPersonsList().stream()
                .collect(
                        Collectors.groupingBy(
                                p -> p.getDepartment(),
                                Collectors.groupingBy(Person::getGender)
                        )
                );
        collect23.forEach((dept, genderWiseMap)->{
            genderWiseMap.forEach((gender, list)->{
                Person person1 = list.stream().max(Comparator.comparingInt(Person::getAge)).get();
                System.out.println("Eldest person from dept: "+ dept + "is "+ person1.getName() + " and their gender is "+person1.getGender());
            });
        });

        getPersonsList().stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .findFirst().get().getName();

        // Find count of persons in each department
        Map<String, Long> collect = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.counting()));

        // Find average salary of MALE & FEMALE persons
        Map<String, Double> collect1 = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.averagingDouble(Person::getSalary)));

        getPersonsList().stream().collect(Collectors.groupingBy(Person::getGender, Collectors.summingDouble(Person::getSalary)));

        // 2nd highest salaried person in each department
        Map<String, Person> collect18 = getPersonsList().stream().collect(Collectors.groupingBy(Person::getDepartment, Collectors.collectingAndThen(
                Collectors.toList(),
                list -> list.stream()
                        .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                        .skip(1)
                        .findFirst()
                        .get()
        )));

        // 2nd highest salary in IT department
        getPersonsList().stream().filter(ps -> ps.getDepartment().equalsIgnoreCase("IT"))
                .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                .skip(1)
                .findFirst().get().getName();

        // 2nd highest salary in each dept
        Map<String, String> collect12 = getPersonsList().stream().collect(Collectors.groupingBy(Person::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                                .skip(1)
                                .findFirst()
                                .get()
                                .getName()
                )
        ));

        // 2nd highest salaried employees in each department
        // Refer https://www.geeksforgeeks.org/collectors-collectingandthen-method-in-java-with-examples/
        Map<String, Optional<Person>> collect3 = getPersonsList().stream()
                .collect(
                        Collectors.groupingBy(Person::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                                                .skip(1)
                                                .findFirst()
                                )
                        )
                );

        // average of top 2 persons salaries from each department
        Map<String, Double> collect2 = getPersonsList().stream()
                .collect(Collectors.groupingBy(
                        Person::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                                        .limit(2) // (OR).mapToDouble(Person::getSalary).average().getAsDouble()
                                        .collect(Collectors.averagingDouble(Person::getSalary))
                        )
                ));

        //Find maximum salaried from each department
        Map<String, Optional<Person>> collect17 = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .max(Comparator.comparingDouble(Person::getSalary))
                        )));

        Map<String, Optional<Person>> maxSalariedPersonsMap = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.maxBy(
                        Comparator.comparingDouble(Person::getSalary)
                )));

        maxSalariedPersonsMap.forEach((departmentName, personOptional)-> {
            personOptional.ifPresent(person1 -> {
                System.out.println(departmentName + " " + person1.getName());
            });
        });

        // Find average salary of all persons
        Double collect4 = getPersonsList().stream()
                .collect(Collectors.averagingDouble(Person::getSalary));

        // Find total of salaries of all persons
        double sum = getPersonsList().stream()
                .mapToDouble(Person::getSalary)
                .sum();
        // OR
        Double collect5 = getPersonsList().stream()
                .collect(Collectors.summingDouble(Person::getSalary));

        // Find average salary of persons in each department
        Map<String, Double> collect6 = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment,Collectors.averagingDouble(Person::getSalary)));
        
        // Find total salaries of persons in each dept
        Map<String, Double> collect7 = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.summingDouble(Person::getSalary)));
        
        // For above instead of performing each operation separately, we go with summarization
        DoubleSummaryStatistics collect8 = getPersonsList().stream().collect(
                Collectors.summarizingDouble(Person::getSalary));
        collect8.getAverage();
        collect8.getSum();// min, max etc...,

        Arrays.asList(3,6).stream().mapToInt(n -> Integer.parseInt(n+"")).sum();
        Arrays.asList(3,6).stream().mapToInt((ToIntFunction) Function.identity()).sum();
        Arrays.asList(3,6).stream().mapToInt(Integer::intValue).sum();

        Map<String, Person> collect9 = getPersonsList().stream()
                .collect(Collectors.toMap(p -> p.getName(), Function.identity()));

        collect9.forEach((name, personObj) -> {
            System.out.println("name is : "+name);
            System.out.println("Person info is "+ personObj);
        });

        BiConsumer<String, Person> biConsumer = (name, personObj) -> {
            System.out.println("name is : "+name);
            System.out.println("Person info is "+ personObj);
        };

        collect9.forEach(biConsumer);

        Arrays.asList("3","6")
                .stream()
                .map(Long::valueOf)
                .forEach(System.out::println);

        List<String> list = new ArrayList<>(){{ add(""); add(""); }};

        // convert string to List<integer>
        String str = "1,2,3,4,5,6";
        Arrays.stream(str.split(","))
                .map(Integer::valueOf)
                .map(num -> num * num)
                .filter(num -> num < 100)
                .collect(Collectors.averagingInt(i-> i));

        // Find duplicates from the list
        List<String> list1 = Arrays.asList("apple", "orange", "avacado", "apple", "orange", "banana");
        Map<String, List<String>> collect10 = list1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));

        // 1st way
        List<String> collect11 = collect10.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Unique elements from list
        Arrays.asList("apple", "orange", "avacado", "apple", "orange", "banana")
                        .stream()
                        .collect(Collectors.groupingBy(Function.identity()))
                        .entrySet()
                        .stream()
                        .filter(name -> name.getValue().size() == 1)
                        .collect(Collectors.toList());

        // 2nd
        list1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()))
                .forEach((element, list2)-> {
                    if (list2.size() > 1){
                        System.out.println("Duplicate element is "+ element);
                    }
                });
        // 3rd way
        Set<String> strings = new HashSet<>(list1.size());
        list1.stream()
                .filter(strs -> !strings.add(strs))
                .collect(Collectors.toList());
        
        // Find top 5 persons based on salary > 5000 and should be MALE
        List<Person> m = getPersonsList().stream()
                .filter(person1 -> person1.getSalary() > 5000 && person1.getGender().equalsIgnoreCase("M"))
                .sorted(Comparator.comparingDouble(Person::getSalary))
                .limit(5)
                .collect(Collectors.toList());


        TreeMap<String, Set<Person>> collect15 = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment, TreeMap::new, Collectors.toSet()));

        Map<String, DoubleSummaryStatistics> collect14 = getPersonsList().stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.summarizingDouble(Person::getSalary)));

        Arrays.asList("Thanks for such amazing videos brother these are very helpful".split(" "))
        .stream()
        .collect(Collectors.groupingBy(String::length))
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        .forEach(entry -> System.out.println(entry.getKey() +" = "+ "  " + entry.getValue()));


    }

    public static List<Person> getPersonsList() {
        Person person1 = new Person();
        person1.setName("John");
        person1.setAge(30);
        person1.setSalary(50000.0);
        person1.setGender("M");
        person1.setDepartment("CSE");

        Person person2 = new Person();
        person2.setName("Alice");
        person2.setAge(25);
        person2.setSalary(60000.0);
        person2.setGender("F");
        person1.setDepartment("CSE");

        Person person3 = new Person();
        person3.setName("Bob");
        person3.setAge(35);
        person3.setSalary(75000.0);
        person3.setGender("M");
        person1.setDepartment("ECE");

        Person person4 = new Person();
        person4.setName("Emily");
        person4.setAge(28);
        person4.setSalary(55000.0);
        person4.setGender("F");
        person1.setDepartment("ECE");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        return personList;
    }

    // mapToObject() method is only used over primitive streams like IntStream, LongStream etc..,
    public static void streamsDemo(){

        // Primitive streams types are
        //IntStream, LongStream, DoubleStream

        //IntStream to Stream<Integer> in 3 ways
        IntStream.rangeClosed(1,100)
                .mapToObj(num -> num)
                .collect(Collectors.toList());

        IntStream.range(1,11)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());

        IntStream.range(1,11)
                .boxed()
                .collect(Collectors.toList());


        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        String[] strings = {"a", "b", "c", "d", "e", "f"};
        Stream<String> strings1 = Stream.of(strings);
        Stream<String> strings2 = Arrays.stream(strings, 1,4);


        // Generate Strings
        //Stream.generate(() -> "SSR").limit(3).forEach(System.out::println);// SSR SSR SSR

        //Stream.iterate(1, n -> n + 1).limit(100).forEach(System.out::println);

//        IntStream.rangeClosed(1,100)
//                .filter(n -> n % 2 == 0)
//                .forEach(System.out::println); // 2 4 6 8 ...

//        String str = "attribute1Values = TAX0001,TAX002, attribute2Values = TAX0002,TAX003, attribute3Values = TAX0003,TAX004"  ;
//        Pattern.compile("attribute[0-9]Values = ")
//                .splitAsStream(str)
//                .map(s -> s.split(",").length > 1 && s.substring(0, s.length() - 1).equals(",") ? s.substring(0, s.length() - 1) : s)
//                .forEach(System.out::println);
//
//
//        Consumer<String> consumer = strs -> System.out.println(strs);
//        consumer.accept("");
//
//        BiConsumer<Consumer<String>, String> biConsumer = (ss,in) -> ss.accept(in);
//        biConsumer.accept(consumer, "");
//
//        Function<String, Integer> function = String::length;
//        function.apply("ssr");
//
//        Supplier<String> supplier = () -> "surendra reddy seelam";
//        supplier.get();

        // Creating empty stream
        Stream<String> stream = Stream.empty();


        // IntStream
        //IntStream chars = "abc".chars(); // chars() gives the ascii code for a character
        //"abc".chars().forEach(System.out::println); // 97 98 99

        // Skip
        //"abc".chars().skip(1).forEach(System.out::println); // skipped 1 element

        //"rtwtqwertyuiasdfghjklzxcvbnm".chars().mapToObj(Integer::valueOf).sorted(Comparator.reverseOrder()).forEach(System.out::println);

//        String collect = Stream.of("abc", "def", "ghi")
//                .collect(Collectors.joining("@", "[", "]"));
//        System.out.println(collect);

//        Stream<Integer> randomNumbers = Stream
//                .generate(() -> new Random().nextInt(100));
//        randomNumbers.limit(5).forEach(System.out::println);

        // using primitive
        int[] ints = IntStream.rangeClosed(1, 100)
                .filter(num -> num % 2 == 0)
                .toArray();
        // using wrapper
        Integer[] integers = IntStream.rangeClosed(1, 100)
                .boxed()
                .filter(num -> num % 2 == 0)
                .toArray(Integer[]::new);

        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        memberNames.stream().sorted(Comparator.naturalOrder());
        memberNames.stream().sorted(Comparator.reverseOrder());


        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

        // Below 3 ways are used to stream over list of Optional<String>
        listOfOptionals.stream()
                .flatMap(strOptional -> strOptional.isPresent() ? Stream.of(strOptional.get()) : Stream.empty())
                .forEach(System.out::println);

        listOfOptionals.stream()
                .flatMap(optional -> optional.map(st -> Stream.of(st)).orElseGet(() -> Stream.empty()));

        listOfOptionals.stream()
                .flatMap(strOptional -> strOptional.map(Stream::of).orElseGet(Stream::empty));

        //Since java 9
        listOfOptionals.stream()
                .flatMap(Optional::stream);

        String vowels = "a,e,i,o,u";
        List<String> collect = Stream.of(vowels.split(","))
                .collect(Collectors.toList());

        List<Character> collects = vowels.chars()
                .mapToObj(asciiNum -> (char) asciiNum)
                .collect(Collectors.toList());

        // String to MAP
        String s = "attribute1Values = TAX001, attribute2Values = TAX002";
        Map<String, Integer> collect1 = Stream.of(s.split(","))
                .map(str -> str.split("="))
                .collect(
                        Collectors.toMap(stringArray -> stringArray[0], stringArray -> stringArray.length > 0 ? stringArray[1].length() : 0)
                ); // we made sure length > 0 instead of directly using arr[1]

        // findAny(), findFirst() & findLast()
        supplier.get().findAny().map(String::toUpperCase).orElse("default");

        supplier.get().findFirst().map(String::length).orElse(0);

        supplier.get().skip(supplier.get().count() - 1).findFirst().map(String::toUpperCase); // skipping up to last element


        // Converting String to Stream<Character> in 2 ways
        String string = "attribute1Values";
        Arrays.stream(string.split(""))
                .map(str -> str.charAt(0))
                .collect(Collectors.toList());

        string.chars()
                .mapToObj(num -> (char)num)
                .collect(Collectors.toList());

        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        Stream.generate(uuidSupplier)
                .skip(10)
                .limit(100)
                .collect(Collectors.toList());


        // Get maximum salaried
        Optional<Person> collect2 = getPersonsList().stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Person::getSalary)));

        // GET persons less salaried than 3rd highest salaried person
        getPersonsList().stream()
                .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                .skip(2)
                .findFirst()
                .ifPresent(person -> {
                    getPersonsList().stream()
                            .filter(p ->  p.getSalary() < person.getSalary())
                            .collect(Collectors.toList());
                });

        // OR
        getPersonsList().stream()
                .sorted(Comparator.comparingDouble(Person::getSalary).reversed())
                .skip(3)
                .collect(Collectors.toList());

        // Sum of all elements in an array using streams
        int[] arr  = {1,2,4,5,6,3,2,4};
        int sum = Arrays.stream(arr).sum();
    }


    @FunctionalInterface
    public interface FunctionalInterfaceDemos1{
        void greet();

        default int subtract(int a, int b){
            return a - b;
        }
    }
    public static void wish(){
        System.out.println("Hello java expert");
    }

    @FunctionalInterface
    public interface FunctionalInterfaceDemos2{
        int add(int a, int b);
    }
    public static int sum(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(1,2,7,3,9,54,12)
                .stream()
                .max(Comparator.naturalOrder()).get());

        FunctionalInterfaceDemos1 functionalInterfaceDemos = JavaEightFeatures::wish;
        functionalInterfaceDemos.greet();


        // If we have default methods which acts as default/dummy or common method for all implementing classes
        // We can use the same implementation which is defined in interface
        // OR we can override the "default" method and provide our own implementation like below.
        FunctionalInterfaceDemos1 functionalInterfaceDemos1 = new FunctionalInterfaceDemos1() {
            @Override
            public void greet() {
                System.out.println("Hello amazing people!");
            }

            @Override
            public int subtract(int a, int b) {
                return a - b;
            }
        };

        FunctionalInterfaceDemos2 functionalInterfaceDemos2 = JavaEightFeatures::sum;
        functionalInterfaceDemos2.add(2,3);

        //streamsDemo();
        //collectorsDemo();
       // In java "PemGen" is replaced with "MetaSpace" because it has no size restrictions or
        // can dynamically increase size for storing classes
       // These are the memory areas java uses to store classes

//        StringJoiner joiner = new StringJoiner(",","[","]");
//        joiner.add("surendra");
//        joiner.add("reddy");
//        joiner.add("seelam");
//        System.out.println(joiner);//[surendra,reddy,seelam]

        // String.join() is used to join any Iterable collection
        //String join = String.join("-", Arrays.asList("abc", "def"));// abc-def


    }
}
