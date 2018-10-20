package task6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Task6 {
    public static void taskDo(){
        List<String> listStudent = new ArrayList<String>();
        listStudent.add("Саша,ФРТК");
        listStudent.add("Паша,ФРТК");
        listStudent.add("Полина,ФРТК");
        listStudent.add("Коля,ФРТК");
        listStudent.add("Сева,ФИВТ");
        listStudent.add("Гриша,ФАЛТ");
        listStudent.add("Слава,ФАЛТ");
        listStudent.add("Дима,ФАКИ");
        listStudent.add("Кирилл,ФАКИ");
        listStudent.add("Даня,ФАКИ");


        Map<String, String> map = listStudent.stream()
                .map(elem -> elem.split(","))
                .collect(Collectors.toMap(elem -> elem[0], elem -> elem[1]));

        System.out.println(map);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(student -> System.out.println(student.getKey() + ": " +  student.getValue()) );

        Map<String, Long> sortedMap = map.entrySet().stream()
                .collect(groupingBy(Map.Entry::getValue, counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(4)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        System.out.println(sortedMap);
        System.out.println("=======================================================");
    }

    public static void main(String[] args) {
        Task6.taskDo();
    }

}
