package functional_interface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        //Function takes 1 argument and produce 1 result
        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment2 = incrementFunction.apply(1);

        System.out.println(increment2);

        //chaining function
        int multiply = mutiplyBy10.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> incrementBy1AndThenMultiplyBy10 = incrementFunction.andThen(mutiplyBy10);

        int addBy1AndThenMultiplyBy10 = incrementFunction.andThen(mutiplyBy10).apply(4);
        System.out.println(addBy1AndThenMultiplyBy10);

        //Bi Function takes 2 argument and produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));

    }

    static Function<Integer, Integer> incrementFunction = (number) -> ++number;

    static Function<Integer, Integer> mutiplyBy10 = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction = (numberToBeIncrementByOne, numberToBeMultiplyBy) -> (numberToBeIncrementByOne + 1) * numberToBeMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }

}
