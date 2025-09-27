import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private final Map<String, String> nameToNumber;    // Для поиска по имени
    private final Map<String, String> numberToName;    // Для поиска по номеру

    public PhoneBook() {
        nameToNumber = new HashMap<>();
        numberToName = new HashMap<>();
    }

    public int add(String name, String number) {
        if (nameToNumber.containsKey(name)) {
            return nameToNumber.size(); // Возвращаем текущее количество
        }

        nameToNumber.put(name, number);
        numberToName.put(number, name);

        return nameToNumber.size();
    }

    public String findByNumber(String number) {
        return numberToName.get(number);
    }

    public String findByName(String name) {
        return nameToNumber.get(name);
    }
}
