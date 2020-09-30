package pat;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author coderhu1
 * @create 2020-09-14 18:28
 */
public class AddressBookSort {
    static class Person {
        String name;
        int date;
        String number;

        public Person(String name, int date, String number) {
            this.name = name;
            this.date = date;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int date = sc.nextInt();
            String number = sc.next();
            people[i] = new Person(name, date, number);
        }

        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.date - o2.date;
            }
        }) ;

        for (int i = 0; i < n; i++) {
            System.out.println(people[i].name + " " + people[i].date + " " + people[i].number);
        }
    }
}
