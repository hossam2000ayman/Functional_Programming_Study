package combinator_design_pattern;

import java.time.LocalDate;
import java.time.Month;

public class Main {

    public static void main(String args[]) {
        Customer customer = new Customer(
                "ALice",
                "alice@gmail.com",
                "+(20) 01112847555",
                LocalDate.of(2000, Month.NOVEMBER, 11)
        );

//        System.out.println( new CustomerValidatorService().isValid(customer));
        // if valid we can store customer in db
        // Using Combinator Design pattern
        CustomerRegisterationValidator.ValidationResult result = CustomerRegisterationValidator.isEmailValid()
                .and(CustomerRegisterationValidator.isPhoneNumberValid())
                .and(CustomerRegisterationValidator.isAnAdult())
                .apply(customer);
        System.out.println("result : " + result);
        if (result != CustomerRegisterationValidator.ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
