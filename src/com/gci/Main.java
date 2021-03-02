package com.gci;

public class Main {

    public static void main(String[] args) {
        Cycler c1 = new Cycler("Ilon", "Maks", 30, "Pendossia",
                new Bicycle[] {
                        new Bicycle("Stels XT300", 50, 50000),
                        new Bicycle("Merdia Silex700", 65, 144000),
                        new Bicycle("Cube Attain Race", 60, 100000),
                }, 67);
        Cycler c2 = new Cycler("Vovocka", "Sidorov", 10, "Russia",
                new Bicycle[] {
                        new Bicycle("Merdia Silex700", 69, 144000),
                        new Bicycle("Cube Attain Race", 60, 100000),
                }, 50);
        Cycler.getInfo();
    }
}
