package ComparableAndComparator;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

/*
* The Comparator interface defines a compare(arg1, arg2) method with two arguments that
* represent objects to be compared, and works similarly to the Comparable.compareTo() method.
*
* Comparable interface will have compareTo(Object o) whereas Comparator will have compare(Object o1, Object o2)
*
* */
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Players> footballTeam = new ArrayList<>();
        Players player1 = new Players(59, "John", 20, 2, LocalDate.of(2029, 4, 6));
        Players player2 = new Players(67, "Roger", 22, 6, LocalDate.of(2023, 7, 1));
        Players player3 = new Players(45, "Steven", 24, 6, LocalDate.of(2022, 5, 7));
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

//        Collections.sort(footballTeam, new PlayerRankingComparator());
//        Collections.sort(footballTeam, new PlayersAgeComparator());

        // We can make use of Lambda here, Instead of creating a new class for each & every comparator
//******** For primitive "long" property of class **********************************
//        Collections.sort(footballTeam, (o1, o2) -> Long.compare(o1.getAge(), o2.getAge()));   // age
//        Collections.sort(footballTeam, Comparator.comparingLong(Players::getAge));   // age
// ******** For primitive "int" property of class  ************************************
//        Collections.sort(footballTeam, (o1, o2) -> Integer.compare(o1.getRanking(), o2.getRanking()));   // ranking
//        Collections.sort(footballTeam, Comparator.comparingInt(Players::getRanking));   // ranking

//********* But If class property is of WRAPPER or DATE-TIME. Then ************************************
//        Collections.sort(footballTeam, (o1, o2) -> o1.getFavNum().compareTo(o2.getFavNum()));~
//        Collections.sort(footballTeam, Comparator.comparing(Players::getFavNum));
//        Collections.sort(footballTeam, Comparator.comparingLong(Players::getFavNum));
//        Collections.sort(footballTeam, Comparator.comparingInt(Players::getFavNum));
//        Collections.sort(footballTeam, Comparator.comparingDouble(Players::getFavNum));
//        System.out.println("Fav num : "+ footballTeam);


//******************************** For any field we can use Comparator.comparing() **************************
//        Collections.sort(footballTeam, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));   // name
//        Collections.sort(footballTeam, Comparator.comparing(Players::getName));

//        For LocalDate
//        Collections.sort(footballTeam, (o1, o2) -> o1.getDob().compareTo(o2.getDob()));
//        Collections.sort(footballTeam, Comparator.comparing(Players::getDob));
//**********Collections.sort(footballTeam, Comparator.comparingInt(Players::getDob));// Compile time error // Incompatible types

        /*
        Comparators can also be used to control the order of certain data structures (such as sorted sets or sorted maps)
        to provide an ordering that is not natural ordering.
        * */
/*      TreeSet<Players> players = new TreeSet<>(new PlayersAgeComparator());
        Players players1 = new Players(59, "John", 40, 2, LocalDate.of(2029, 4, 6));
        Players players2 = new Players(67, "Roger", 22, 6, LocalDate.of(2023, 7, 1));
        Players players3 = new Players(45, "Steven", 24, 6, LocalDate.of(2022, 5, 7));

        players.add(players1);
        players.add(players2);
        players.add(players3);

        System.out.println(players);
*/
        Comparator<Players> comparingDOB = Comparator.comparing(Players::getDob);
        Comparator<Players> playersComparator = comparingDOB.thenComparing(new PlayerRankingComparator());

        Collections.sort(footballTeam, playersComparator);
        footballTeam.stream().sorted(Comparator.comparingInt(Players::getRanking));
        footballTeam.stream().sorted(Comparator.comparing(Players::getAge));
        footballTeam.stream().sorted(Comparator.comparingLong(Players::getAge).reversed());
        footballTeam.stream().sorted(Comparator.comparingLong(Players::getAge).thenComparingLong(Players::getRanking).reversed());

        Players[] players = footballTeam.stream()
                .sorted(Comparator.comparing(Players::getAge))
                .toArray(Players[]::new);

        Collections.sort(footballTeam, (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        footballTeam.stream()
                .sorted((o1,o2) -> o1.getRanking() < o2.getRanking() ? -1 : (o1.getRanking() == o2.getRanking() ? 0 : 1));
        footballTeam.stream()
                .sorted(Comparator.comparingLong(Players::getAge));


//        footballTeam.stream()
//                        .sorted(Comparator.comparingInt(Players::getAge));// Gives error because "age" field is of type "long". So cannot use it with lower capacity

//        footballTeam.stream()
//                        .sorted(Comparator.comparingLong(Players::getRanking));// Here "ranking" is of  type "int", But we can use "comparingLong" because (long > int)

//        int i = 10;
//        long l = i;
//        i = l; // error
//        i = (int)l; // no error
        System.out.println(Arrays.toString(players));
        Arrays.sort(players);



    }
}

class Players implements Comparable<Players>{
    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    private LocalDate dob;
    private int ranking;
    private String name;
    long age;

    Integer favNum;

    public Integer getFavNum() {
        return favNum;
    }

    public void setFavNum(Integer favNum) {
        this.favNum = favNum;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Players(int ranking, String name, int age, Integer favNum, LocalDate dob){
        this.ranking = ranking;
        this.name = name;
        this.age = age;
        this.favNum = favNum;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Players{" +
                "dob=" + dob +
                ", ranking=" + ranking +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", favNum=" + favNum +
                '}';
    }

    // If we want to natural sort the players class.
    // But here we are using only one field.
    @Override
    public int compareTo(Players players){
        return players == null ? -1 :  Integer.compare(ranking, players.getRanking());
    }

}

class PlayerRankingComparator implements Comparator<Players>{

    @Override
    public int compare(Players o1, Players o2) {
        return Integer.compare(o1.getRanking(), o2.getRanking());// asc order o2, o1 will be desc
    }
}

class PlayersAgeComparator implements Comparator<Players>{

    @Override
    public int compare(Players o1, Players o2){
        return Long.compare(o2.getAge(), o1.getAge());// Desc
    }

}

//class PlayersNameComparator extends Comparator<Players>{
//
//    @Override
//    public int compare(Players o1,Players o2){
//        return o1.getName().compareToIgnoreCase(o2.getName());
//    }
//
//}