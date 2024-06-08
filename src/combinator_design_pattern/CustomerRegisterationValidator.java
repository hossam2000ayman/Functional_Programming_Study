package combinator_design_pattern;

import combinator_design_pattern.CustomerRegisterationValidator.ValidationResult;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegisterationValidator extends Function<Customer, ValidationResult> {

    static CustomerRegisterationValidator isEmailValid() {
        System.out.println("running email validation");
        return customer -> customer.getEmail().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegisterationValidator isPhoneNumberValid() {
        System.out.println("running phone number validation");
        return customer -> customer.getPhoneNumber().startsWith("+") && customer.getPhoneNumber().contains(" ") && customer.getPhoneNumber().contains("(") && customer.getPhoneNumber().contains(")") ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegisterationValidator isAnAdult() {
        System.out.println("running adult validation");
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18 ? ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegisterationValidator and(CustomerRegisterationValidator other) {
        return (customer) -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }

}
