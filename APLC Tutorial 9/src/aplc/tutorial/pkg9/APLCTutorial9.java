package aplc.tutorial.pkg9;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

////q3
//public class APLCTutorial9 {
//    public static double sumList(List<? extends Number>list) { //producer
//        return list.stream()
//                .mapToDouble(Number::doubleValue)
//                .sum();
//    }
//    
//    public static void main(String[] args) {
//        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
//        List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0, 4.0);
//        List<Float> floats = Arrays.asList(1.0f, 2.0f, 3.0f, 4.0f);
//        List<BigDecimal> bigDecimals = Arrays.asList(
//                new BigDecimal("1.0"),
//                new BigDecimal("2.0"),
//                new BigDecimal("3.0"),
//                new BigDecimal("4.0")
//        );
//        
//        System.out.printf("ints sum is %s%n", sumList(ints));
//        System.out.printf("doubles sum is %s%n", sumList(doubles));
//        System.out.printf("floats sum is %s%n", sumList(floats));
//        System.out.printf("bigdecimals sum is %s%n", sumList(bigDecimals));
//    }
//    
//}

////q4
//public abstract class APLCTutorial9<T extends Number> {
//    T[] nums;
//    
//    APLCTutorial9(T[] arg) {
//        this.nums = arg;
//    }
//    
//    abstract T sum();
//    
//    abstract T avg();
//}
//
////child class
//class salesCacl extends APLCTutorial9<Double>{
//    public salesCacl(Double[] arg) {
//        super(arg);
//    }
//    
//    @Override
//    Double sum() {
//        return Arrays.asList(nums).stream().mapToDouble(Number::doubleValue).summaryStatistics().getSum();
//    }
//
//    @Override
//    Double avg() {
//        return Arrays.asList(nums).stream().mapToDouble(Number::doubleValue).summaryStatistics().getAverage();
//    }
//}

public class APLCTutorial9 {
    static void addNew(List<Property> lst,Property obj){
        lst.add(obj);
    }
    
    static void disp(List<Property> lst,int price){
        lst.stream().filter(obj -> obj.price > 100000).forEach(System.out::println);
    }
    public static void main(String[] args) {
        
    List<Property> propLst = new ArrayList();
    addNew( propLst ,new Residential() );
    List<Agricultural> agriLst = new ArrayList();
        //addNew( agriLst, new Residential() );
        List<Residential> resLst = new ArrayList();
        //addNew( resLst, new Residential() );
        
        List<Property> propLst2 = new ArrayList();
        Residential res = new Residential();
        res.name = "Residential";
        res.price = 200000;
        addNew( propLst2, res );
        
Commercial com = new Commercial();
        com.name = "Commercial";
        com.price = 400000;
        addNew( propLst2, com );
        
PalmOil land = new PalmOil();
        land.name = "Agricultural";
        land.price = 2000000;
        addNew( propLst2, land );
        
     //display and filter the property price with 100,000
        disp( propLst2, 100000 );
 
}
 
}
 
class Property{ 
   String name;
   int price;
   
   public String toString(){
       return String.format("%s %s",name, price);
   }
}
 
class Agricultural extends Property{}
class Unagricultural extends Property{}
class Residential extends Property{}
class Commercial extends Property{}
class PalmOil extends Property{}