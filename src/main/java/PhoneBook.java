import java.util.*;

public class PhoneBook {

    private final Map<String, String> nameToNumber;    // Для поиска по имени
    private final Map<String, String> numberToName;    // Для поиска по номеру
    private final TreeSet<String> names;               // Для хранения имен в отсортированном порядке

    public PhoneBook() {
        nameToNumber = new HashMap<>();
        numberToName = new HashMap<>();
        names = new TreeSet<>();
    }

    public int add(String name, String number) {
        if (nameToNumber.containsKey(name)) {
            return nameToNumber.size(); // Возвращаем текущее количество
        }

        nameToNumber.put(name, number);
        numberToName.put(number, name);
        names.add(name);

        return nameToNumber.size();
    }

    public String findByNumber(String number) {
        return numberToName.get(number);
    }

    public String findByName(String name) {
        return nameToNumber.get(name);
    }

    public List<String> printAllNames() {
        // TODO: реализовать
        return new ArrayList<>(names); // TreeSet уже отсортирован
    }

}
