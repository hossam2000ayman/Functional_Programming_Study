package functional_interface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String args[]) {
        System.out.println("Without predicate");
        System.out.println(isPhoneNumberValid("01112847555"));
        System.out.println(isPhoneNumberValid("01198765432"));
        System.out.println(isPhoneNumberValid("0111234567"));
        System.out.println(isPhoneNumberValid("011123456789"));
        System.out.println(isPhoneNumberValid("01234A67890"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("01112847555"));
        System.out.println(isPhoneNumberValidPredicate.test("01198765432"));
        System.out.println(isPhoneNumberValidPredicate.test("0111234567"));
        System.out.println(isPhoneNumberValidPredicate.test("011123456789"));
        System.out.println(isPhoneNumberValidPredicate.test("01234A67890"));

        System.out.println("Is phone number valid and contains number 3 = " + isPhoneNumberValidPredicate.and(containNumber3).test("01130000000"));
        System.out.println("Is phone number valid and contains number 3 = " + isPhoneNumberValidPredicate.and(containNumber3).test("01230000000"));
        System.out.println("Is phone number valid and contains number 3 = " + isPhoneNumberValidPredicate.and(containNumber3).test("01250000000"));

        System.out.println("Is phone number valid or contains number 3 = " + isPhoneNumberValidPredicate.or(containNumber3).test("01250000000"));
        System.out.println("Is phone number valid or contains number 3 = " + isPhoneNumberValidPredicate.or(containNumber3).test("30"));

        System.out.println("isDivisible : " + isDivisible.test(5, 2));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("011") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = (phoneNumber) -> (phoneNumber.startsWith("011") && phoneNumber.length() == 11);

    static Predicate<String> containNumber3 = (phoneNumber) -> phoneNumber.contains("3");

    static BiPredicate<Integer, Integer> isDivisible = (t, u) -> t % u == 0;
}
