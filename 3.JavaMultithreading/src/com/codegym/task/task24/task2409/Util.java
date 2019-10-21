package com.codegym.task.task24.task2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static {
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Armani, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Lucky, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKlein, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        //add your code here
        abstract class AbstractJeans implements Jeans{
            int id;
            int length;
            int size;
            double price;

            public AbstractJeans(int id, int length, int size, double price) {
                this.id = id;
                this.length = length;
                this.size = size;
                this.price = price;
            }

            @Override
            public int getLength() {
                return this.length;
            }

            @Override
            public int getSize() {
                return this.size;
            }

            @Override
            public int getId() {
                return this.id;
            }

            @Override
            public double getPrice() {
                return this.price;
            }


            @Override
            public String toString() {
                return this.getTM()+
                        "{" +
                        "id=" + id +
                        ", length=" + length +
                        ", size=" + size +
                        ", price=" + price +
                        '}';
            }

        }

        class Levis extends AbstractJeans{
            public Levis(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getTM() {
                return this.getClass().getSimpleName();
            }
        }
        class Armani extends AbstractJeans{
            public Armani(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getTM() {
                return this.getClass().getSimpleName();
            }
        }

        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company ) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            if (Company.Levis == company) {
                jeans = new Levis(id, length, size, price);
            } else
                if (Company.Armani == company) {
                    jeans = new Armani(id, length, size, price);
                } else {
                    jeans = new AbstractJeans(id, length, size, price) {
                        public String getTM() {
                            return company.fullName;
                        }
                    };
                }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis ("Levi's"),
        Armani("Armani"),
        Lucky("Lucky"),
        CalvinKlein("Calvin Klein");

        final String fullName;
        Company(String name) {
            this.fullName = name;
        }
    }
}
