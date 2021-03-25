package aplc.tutorial.pkg5;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class Book{
    String title;
    double rating;
 
    public Book(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public double getRating() {
        return rating;
    }
 
    public void setRating(double rating) {
        this.rating = rating;
    }
 
    @Override
    public String toString() {
        return "Book{" + "title=" + title + ";Rating=" + rating + '}';
    }
}

class Membership{
    int point;
    Membership(int pt){ this.point = pt; }
}

public class InClassExercise {
    //Question 2
    void q2() {
        List<String> username = 
                Arrays.asList("ali", "ahmad", "maria", "john", "derick", "salleh" );    
        String target = username.stream()
            .filter(elem -> elem.equals("salleh"))
            .findAny().orElse(null);
        System.out.println(target!=null ? target:"Salleh not found!");
        
        //Alternatively,
        Optional<String> target1 = Optional.ofNullable(
                username.stream()
                .filter(elem -> elem.equals("salleh"))
                .findAny().orElse(null)
            );
            target1.ifPresent(System.out::println);
    }
    
    //Question 3
    static BiFunction<String, String, String> join = (elem1, elem2) -> elem1 + elem2;
    void q3() {
        System.out.println(join.apply("hello", "world!"));
    }
    
    //Question 4
    static int sum = 0;
    static int compute (int x, int[] a) {
        return Arrays.stream(a).sum()*x;
    }
    
    //Question 5
    void q5() {
        Function<Integer, Function<Integer, Integer>> add = a -> b -> a+b;
        System.out.println(add.apply(20).apply(15));
    }
    
    //Question 6
    void q6() {
        List<Book> bookList = Arrays.asList(
                new Book("When Breath Becomes Air", 8.8),
                new Book("The Universe Has Your Back", 5.6),
                new Book("A War and Peace", 7.9),
                new Book("One Hundred Years of Solitude", 7.9),
                new Book("Moby Dick", 4.3),
                new Book("The Great Wall", 7.0)
         );
 
        bookList.sort(Comparator.comparing(Book::getTitle));
        bookList.forEach(x->System.out.println(x.toString()));
        System.out.println("");
        bookList.sort(Comparator.comparing(Book::getRating));
        bookList.forEach(x->System.out.println(x.toString()));
        //bookList is a mutable object where implicity is a side effect
        //Side effect is triggered by modifying a data structure of a given object
    }
    
    //Question 7
    void q7() {
        Function<Integer, Function<Integer, Integer>> add = a->b->a+b;
        Function<Integer, Function<Integer, Integer>> mul = a->b->a*b;
        int result = mul
                .apply(add.apply(10).apply(20))
                .apply(add.apply(30).apply(40));
        System.out.println(result);
    }
    
    //Question 8
    void q8() {
        BiFunction<Integer, Integer, Integer> add10 = (a, b) -> a + b;
        List<Membership> list = new ArrayList();
        list.add(new Membership(100));
        list.add(new Membership(200));
        list.add(new Membership(300));
        list.add(new Membership(400));
        
        //increase 10 points
        List<Membership> newLst = list.stream()
                .map(elem->new Membership(elem.point + 10))
                .collect(Collectors.toList());
        
        //immutable list
        list.stream().forEach(elem->System.out.println(elem.point));
        
        //newList
        newLst.stream().forEach(elem->System.out.println(elem.point));
    }
    
    //Question 9
    static Function<String, Integer> toInt = elem -> Integer.parseInt(elem);
    void q9() {
        String filename = "C:\\Users\\ongshaoan\\Documents\\NetBeansProjects\\APLC Tutorial 5\\src\\aplc\\tutorial\\pkg5\\units.txt";
        List<String> units = null;
        try {
            units = Files.readAllLines(Paths.get(filename));
//            List<Integer> unitInt = units.stream()
//                    .map(Integer::parseInt).collect(Collectors.toList());
//            int result = unitInt.stream().mapToInt(Integer::intValue).sum();
            int result = units.stream()
//                        .map(Integer::parseInt) //parse String into Int
//                        .map(elem -> Integer.parseInt(elem))
                    .map(toInt)
                    .mapToInt(Integer::intValue) //transform to numeric Int
                    .sum();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        InClassExercise demo = new InClassExercise();
        demo.q8();
    }
}
