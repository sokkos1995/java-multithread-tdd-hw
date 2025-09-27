import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PhoneBookTest {
    @Test
    public void testAddContact() {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем первый контакт
        int count1 = phoneBook.add("Alice", "123-456-789");
        assertEquals(1, count1);

        // Добавляем второй контакт
        int count2 = phoneBook.add("Bob", "987-654-321");
        assertEquals(2, count2);

        // Проверяем, что дубликаты не добавляются (по условию гарантируется, но тест для надежности)
        int count3 = phoneBook.add("Alice", "999-999-999");
        assertEquals(2, count3); // Количество не должно измениться
    }

    @Test
    public void testFindByNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        phoneBook.add("Bob", "987-654-321");

        // Поиск существующего номера
        assertEquals("Alice", phoneBook.findByNumber("123-456-789"));
        assertEquals("Bob", phoneBook.findByNumber("987-654-321"));

        // Поиск несуществующего номера
        assertNull(phoneBook.findByNumber("000-000-000"));
    }

    @Test
    public void testFindByName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Alice", "123-456-789");
        phoneBook.add("Bob", "987-654-321");

        // Поиск существующего имени
        assertEquals("123-456-789", phoneBook.findByName("Alice"));
        assertEquals("987-654-321", phoneBook.findByName("Bob"));

        // Поиск несуществующего имени
        assertNull(phoneBook.findByName("Charlie"));
    }

    @Test
    public void testPrintAllNames() {
        PhoneBook phoneBook = new PhoneBook();

        // Проверяем пустую книгу
        assertTrue(phoneBook.printAllNames().isEmpty());

        // Добавляем контакты в разном порядке
        phoneBook.add("Charlie", "555-555-555");
        phoneBook.add("Alice", "123-456-789");
        phoneBook.add("Bob", "987-654-321");

        // Проверяем сортировку по алфавиту
        List<String> result = phoneBook.printAllNames();
        assertEquals(List.of("Alice", "Bob", "Charlie"), result);

        // Добавляем еще один контакт и проверяем порядок
        phoneBook.add("David", "111-222-333");
        result = phoneBook.printAllNames();
        assertEquals(List.of("Alice", "Bob", "Charlie", "David"), result);
    }
}
