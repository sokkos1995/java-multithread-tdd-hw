import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final Map<String, String> nameToNumber;    // Для поиска по имени

    public PhoneBook() {
        nameToNumber = new HashMap<>();
    }

    public int add(String name, String number) {
        if (nameToNumber.containsKey(name)) {
            return nameToNumber.size(); // Возвращаем текущее количество
        }

        nameToNumber.put(name, number);

        return nameToNumber.size();
    }
}
