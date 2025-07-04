import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        Date futureDate = cal.getTime();

        Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, futureDate, 0.2);
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 3, futureDate, 0.7);
        Product tv = new ShippableProduct("TV", 12000, 10, 50.0);
        Product scratchCard = new Product("Scratch Card", 50, 20) {};

        Customer customer = new Customer("Ahmed Khaled Farag", 20000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(scratchCard, 1);
        cart.add(tv, 1);

        ECommerceSystem.checkout(customer, cart);
    }
}