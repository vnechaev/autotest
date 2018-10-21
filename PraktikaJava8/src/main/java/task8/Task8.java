package task8;

import java.util.function.Function;
import java.util.function.Predicate;

/*
Даны функция intFunc и два предиката predicate1 и predicate2. Напишите
функцию, которая вернет predicate1, если intFunc1 > 0 и вернет predicate2,
если intFunc1 <= 0
 */
public class Task8 {
    public static void taskDo() {
        Predicate<Integer> pred1 = x -> x > 0;
        Predicate<Integer> pred2 = x -> x < 0 || x == 0;
        Function<Integer, Integer> intFunc = x -> x + 1;

        Predicate<Integer> check = x -> intFunc.apply(x) > 0;
//        Ответ:
        Function<Integer, Predicate<Integer>> checkNull = inte -> check.and(pred1).or(check.negate().and(pred2));
    }
}
