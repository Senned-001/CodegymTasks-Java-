package com.codegym.task.task24.task2406;

import java.math.BigDecimal;

/* 
Inheriting an inner class

*/
public class Solution {

    public class Building {

        public class Hall {
            private BigDecimal area;

            public Hall(BigDecimal area) {
                this.area = area;
            }
        }



        public class Apartment {
        }
    }

    public class ThreeBedroomApt extends Building.Apartment {
        public ThreeBedroomApt(Building building) {
            building.super();
        }
    }

    public class BigHall extends Building.Hall{
        public BigHall(Building building,BigDecimal a) {
            building.super(a);
        }
    }

    public static void main(String[] args) {

    }
}
