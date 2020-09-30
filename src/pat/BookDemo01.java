package pat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author coderhu1
 * @create 2020-09-14 15:18
 */
public class BookDemo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ArrayList<Book> books = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            double v = Double.parseDouble(sc.nextLine());
            Book book = new Book(s, v);
            books.add(book);
        }
        sc.close();

        Collections.sort(books);

        System.out.printf("%.2f, ",books.get(n - 1).getPrices());
        System.out.println(books.get(n - 1).getName());
        System.out.printf("%.2f, ",books.get(0).getPrices());
        System.out.println(books.get(0).getName());
    }
}

class Book implements Comparable<Book>{
    private String name;
    private double prices;

    public Book(String name, double prices) {
        this.name = name;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    @Override
    public int compareTo(Book o) {
        if((this.getPrices() - o.getPrices()) > 0) {
            return 1;
        }else if((this.getPrices() - o.getPrices()) == 0){
            return 0;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", prices=" + prices +
                '}';
    }
}
