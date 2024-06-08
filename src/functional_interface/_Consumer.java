package functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String args[]) {
        Customer maria = new Customer("Maria", "01112847555");
        // Normal Java Function
        greetCustomer(maria);
        // Consumer Functional Interface -> take a one argument and not return a result (void method)
        greetCustomerConsumer.accept(maria);
        greetCustomerBiConsumer.accept(maria, false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) -> {
        System.out.println("Hello " + customer.customerName
                + " , thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "**************"));

    };

    static Consumer<Customer> greetCustomerConsumer = (customer) -> {
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    };

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    static class Customer {

        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
