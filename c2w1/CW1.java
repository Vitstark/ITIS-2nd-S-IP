import java.util.*;
import java.util.stream.*;

// Задания контрольной в README.md
public class CW1 {
    // Решение задания A
    public static double taskA(List<PROGA.CW.Purchase> purchases, String user) {
        double result = 0;
        result += purchases.stream()
                .filter(x -> x.getCustomer().equals(user))
                .filter(x -> x.getItem().equals("икра"))
                .mapToDouble(x -> x.getPrice() * x.getCount() * 0.8)
                .sum();
        result += purchases.stream()
                .filter(x -> x.getCustomer().equals(user))
                .filter(x -> !x.getItem().equals("икра"))
                .mapToDouble(x -> x.getPrice() * x.getCount())
                .sum();
        return result;
    }
    // Решение задания B
    public static Map<String, List<PROGA.CW.Purchase>> taskB(List<PROGA.CW.Purchase> purchases) {
        return purchases.stream()
                .collect(Collectors.toMap(x -> x.getItem(), x -> Stream.of(x).toList(), (a,b) -> {
                    List<PROGA.CW.Purchase> newList = new ArrayList<>(a);
                    newList.addAll(b);
                    return newList;
                }));
    }
    // Решение задания C
    public static List<PROGA.CW.Purchase> taskC(Map<String, List<PROGA.CW.Purchase>> res, String from, String to)  {
        List<PROGA.CW.Purchase> result = new LinkedList<>();
        Iterator<String> iterator = res.keySet().iterator();
        while (iterator.hasNext()) {
            String elem = iterator.next();
            if (elem.compareTo(from) > 0 && elem.compareTo(to) < 0) {
                result.addAll(res.get(elem));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // Поездка в город
        List<Purchase> list = List.of(
            new Purchase("2021-03-31", "сноха", "доха", 2, 300),
            new Purchase("2021-04-01", "брат", "кофе", 1, 1.23),
            new Purchase("2021-04-02", "невестка", "ковер", 2, 200),
            new Purchase("2021-04-03", "зять", "икра", 1, 50),
            new Purchase("2021-04-04", "тесть", "коньяк", 1, 12),

            new Purchase("2021-06-01", "брат", "доха", 2, 400),
            new Purchase("2021-06-02", "сестрин муж", "духи", 1, 20),
            new Purchase("2021-06-03", "тесть", "что попадётся", 10, 12),
            new Purchase("2021-06-04", "зять", "икра", 1, 60),
            new Purchase("2021-06-05", "кум", "водка", 4, 3.62),

            new Purchase("2021-08-01", "брат", "шуба", 1, 400),
            new Purchase("2021-08-02", "кум", "всё подряд", 12, 10),
            new Purchase("2021-08-03", "тесть", "водка", 1, 3.62),
            new Purchase("2021-08-04", "невестка", "ковер", 2, 300),
            new Purchase("2021-08-05", "зять", "нора", 7, 1.1),
            new Purchase("2021-08-06", "сестра", "красивое", 1, 30),

            new Purchase("2021-12-01", "автор", "махра", 10, 0.9),
            new Purchase("2021-12-02", "зять", "икра", 1, 70),
            new Purchase("2021-12-03", "тесть", "духи", 1, 30),
            new Purchase("2021-12-04", "невестка", "всё равно", 2, 5),
            new Purchase("2021-12-05", "сестрин муж", "вино", 1, 10),
            new Purchase("2021-12-06", "автор", "желтое в тарелке", 1, 2),

            new Purchase("2022-04-01", "автор", "доха", 1, 500),
            new Purchase("2022-04-01", "зять", "кофе", 1, 2.34),
            new Purchase("2022-04-01", "тесть", "хрен", 1, 0.23),
            new Purchase("2022-04-01", "кум", "пиво", 1, 0.3),
            new Purchase("2022-04-01", "автор", "коньяк", 1, 12),
            new Purchase("2022-04-01", "брат", "самогон", 1, 0.5)
            );
        System.out.println(taskA(list, "брат"));
        Map<String, List<Purchase>> res = taskB(list);
        System.out.println(res);
        System.out.println(taskC(res,"до","от"));
    }
}

// Покупка в магазине
class Purchase {
    // Дата покупки в формате YYYY-MM-DD
    private String date;
    // Покупатель
    private String customer;
    // Название купленного предмета
    private String item;
    // Количество купленных предметов
    private int count;
    // Цена одного предмета (без учёта скидок)
    private double price;

    public Purchase(String date, String customer, String item, int count, double price) {
        this.date = date;
        this.customer = customer;
        this.item = item;
        this.count = count;
        this.price = price;
    }

    public String getDate() { return date; }
    public String getItem() { return item; }
    public String getCustomer() { return customer; }
    public int getCount() { return count; }
    public double getPrice() { return price; }
}
