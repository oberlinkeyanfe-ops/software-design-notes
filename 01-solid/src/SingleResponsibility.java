import java.util.List;

/**
 * S - Single Responsibility.
 * In a restaurant, the cook cooks and the cashier handles payments.
 * Each class has one reason to change.
 */
public class SingleResponsibility {

    record Order(String dish, double price) {}

    /** Only knows how to prepare food. */
    static class Cook {
        String prepare(Order order) {
            return order.dish() + " is ready";
        }
    }

    /** Only knows how to take payments. */
    static class Cashier {
        double total(List<Order> orders) {
            return orders.stream().mapToDouble(Order::price).sum();
        }
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(new Order("Ndole", 2500), new Order("Poulet DG", 4000));

        Cook cook = new Cook();
        orders.forEach(order -> System.out.println(cook.prepare(order)));

        Cashier cashier = new Cashier();
        System.out.println("Total to pay: " + cashier.total(orders) + " FCFA");

        // If the payment rules change (taxes, discounts), only Cashier changes.
        // If the recipes change, only Cook changes.
    }
}
