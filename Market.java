import java.util.*;

// Интерфейс для поведения очереди
interface QueueBehaviour<T> {
    boolean add(T element);  // добавить элемент в очередь
    T remove();  // удалить и вернуть первый элемент из очереди
    T peek();  // вернуть первый элемент из очереди, не удаляя его
}

// Интерфейс для поведения рынка
interface MarketBehaviour<T> {
    void enterMarket(T person);  // поместить человека в очередь магазина
    void leaveMarket(T person);  // удалить человека из очереди магазина
}

// Класс, реализующий оба интерфейса и представляющий магазин
public class Market<T> implements QueueBehaviour<T>, MarketBehaviour<T> {

    private Queue<T> queue;  // Очередь магазина

    // Конструктор для создания нового магазина
    public Market() {
        this.queue = new LinkedList<>();
    }

    // Методы из интерфейса QueueBehaviour

    // Добавление элемента в очередь
    @Override
    public boolean add(T element) {
        return queue.add(element);
    }

    // Удаление и возврат первого элемента из очереди
    @Override
    public T remove() {
        return queue.remove();
    }

    // Возврат первого элемента из очереди без его удаления
    @Override
    public T peek() {
        return queue.peek();
    }

    // Методы из интерфейса MarketBehaviour

    // Добавление человека в магазин
    @Override
    public void enterMarket(T person) {
        queue.add(person);
        System.out.println(person + " вошел в магазин.");
    }

    // Удаление человека из магазина
    @Override
    public void leaveMarket(T person) {
        if (queue.remove(person)) {
            System.out.println(person + " покинул магазин.");
        } else {
            System.out.println(person + " не был найден в очереди магазина.");
        }
    }

    // Дополнительный метод для обновления состояния магазина
    public void update() {
        // Реализация метода update, обновляющего состояние магазина (принимает и отдаёт заказы)
        // ...
    }

    // Метод main для тестирования функционала магазина
    public static void main(String[] args) {
        Market<String> market = new Market<>();
        market.enterMarket("Александр");
        market.enterMarket("Елена");
        market.leaveMarket("Александр");
        System.out.println("Первый в очереди: " + market.peek());
    }
}
