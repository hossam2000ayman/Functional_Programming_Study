package functional_interface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {

    public static void main(String args[]) {

        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users";

    }

    //Supplier it takes no argument but it return a value
    static Supplier<List<String>> getDBConnectionUrlSupplier = () -> List.of(
            "jdbc://localhost:5432/users",
            "jdbc://localhost:5432/customers"
    );
}
