package pat;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class BookDemo02 {
    static class Book {
        double price;
        String name;
    }

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            books[i] = new Book();
            books[i].name = Reader.nextLine();
            books[i].price = Reader.nextDouble();
        }
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                // TODO Auto-generated method stub
                return (int) (o1.price - o2.price);
            }
        });

        System.out.println(String.format("%.2f", books[books.length - 1].price) + ", " + books[books.length - 1].name);
        System.out.println(String.format("%.2f", books[0].price) + ", " + books[0].name);
    }
}

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static char nextChar() throws IOException {
        return next().charAt(0);
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}



