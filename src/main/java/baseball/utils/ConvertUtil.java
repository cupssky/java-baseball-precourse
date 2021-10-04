package baseball.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ConvertUtil {

    public static Set<Integer> convertStringToSet(String value) {
        Set<Integer> set = new LinkedHashSet<>();
        for (char numberValue : value.toCharArray()) {
            set.add(numberValue - '0');
        }
        return set;
    }

    public static List<Integer> convertSetToList(Set<Integer> value) {
        Iterator<Integer> iterator = value.iterator();
        List<Integer> list = new ArrayList<>();

        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

}
