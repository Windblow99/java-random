package aplc.tutorial.pkg10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class question3 {
    static List<Student> markList;
    
    static {
        markList = getStudents();
    }
    
    static List<Student> getStudents() {
        List<Student> lst = new ArrayList();
        lst.add(new Student(new Integer[]{23,56,76,76}));
        lst.add(new Student(new Integer[]{43,61,66,78}));
        lst.add(new Student(new Integer[]{12,56,87,78}));
        lst.add(new Student(new Integer[]{67,23,86,76}));
        return lst;
    }
    
    public static void main(String[] args) {
        Item i1 = new Item("Soap", 3.9);
	Item i2 = new Item("Plate", 15.9);
	Item i3 = new Item("Wok", 199.9);
		
	Order order = new Order();
	order.setItems( Arrays.asList( i1, i2, i3 ) );
        
        compute(order.getItems());
    }
    
    private static void compute(List<Item> order){
        System.out.println(tenPercent.apply(sixPercentSum.apply(order)));
    }
    
    //function object
    static Function<List<Item>,Double> sixPercentSum = itemLst -> itemLst.stream()
            .map(item -> item.price * 1.06)
            .mapToDouble(Number::doubleValue)
            .sum();

    static Function<Double,Double> tenPercent = e -> e * 1.10;
}


class Order{
    List<Item> items = new ArrayList();

    public List<Item> getItems() {
	return items;
    }

    public void setItems(List<Item> items) {
	this.items = items;
    }
}

class Item{
    String name;
    double price;
    public Item(String name, double price) {
	super();
	this.name = name;
	this.price = price;
    }
	
    public Item() {
	super();
    }
}