package task8;

import java.util.function.Function;
import java.util.function.Predicate;

/*
Даны функция intFunc и два предиката predicate1 и predicate2. Напишите
функцию, которая вернет predicate1, если intFunc1 > 0 и вернет predicate2,
если intFunc1 <= 0
 */
public class Task8 {
    public <T> Task8() {
        Predicate<T> pred1 = x -> true;
        Predicate<T> pred2 = x -> false;
        Function<T, Integer> intFunc = x ->  1;

        Predicate<T> check = x -> intFunc.apply(x) > 0;
//        Ответ:
        Function<T, Predicate<T>> checkNull = inte -> check.and(pred1).or(check.negate().and(pred2));
    }
}
