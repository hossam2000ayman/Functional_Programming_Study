package combinator_design_pattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
    
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }
    
    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+") && phoneNumber.contains(" ") && phoneNumber.contains("(") && phoneNumber.contains(")");
    }
    
    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() >= 18;
    }
    
    public boolean isValid(Customer customer) {
        return isEmailValid(customer.getEmail())
                && isPhoneNumberValid(customer.getPhoneNumber())
                && isAdult(customer.getDob());
    }
}
