package optionals;

import java.util.Optional;

public class _Optionals {

    public static void main(String args[]) {
        Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");

        Optional.ofNullable(value).ifPresent((x) -> {
            System.out.println("value : " + x);
        });

        Optional.ofNullable(null).ifPresentOrElse((y) -> {
            System.out.println("Sending email to  : " + y);
        }, () -> {
            System.out.println("cannot sending the email");
        });

    }
}
