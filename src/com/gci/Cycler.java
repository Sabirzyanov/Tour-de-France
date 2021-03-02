package com.gci;

public class Cycler {

    static int racersCount;
    private String fName;
    private String lName;
    private int age;
    private String country;
    private Bicycle[] bicycles;
    private double avSpeed;
    private Bicycle currentBicycle;
    private boolean isOnRace;
    private boolean isOutRace;
    private boolean isFinished;
    private String save;
    private static Cycler[] cyclers = new Cycler[0];

    public Cycler(String fName, String lName, int age, String country, Bicycle[] bicycles, double avSpeed) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.country = country;
        this.bicycles = bicycles;
        this.avSpeed = avSpeed;

        // Add this cycler in array
        Cycler[] newCyclerArr = new Cycler[cyclers.length + 1];
        for (int i = 0; i < cyclers.length; i++) {
            newCyclerArr[i] = cyclers[i];
        }
        newCyclerArr[newCyclerArr.length - 1] = this;
        cyclers = newCyclerArr;

    }

    public Bicycle getCurrentBicycle() {
        return currentBicycle;
    }

    public void setCurrentBicycle(Bicycle currentBicycle) {
        this.currentBicycle = currentBicycle;
    }

    public double getAvSpeed() {
        return avSpeed;
    }

    public void setAvSpeed(double avSpeed) {
        this.avSpeed = avSpeed;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Bicycle[] getBicycles() {
        return bicycles;
    }

    public void setBicycles(Bicycle[] bicycles) {
        this.bicycles = bicycles;
    }

    public static void getInfo() {
        for (Cycler cycler : cyclers) {
            System.out.printf("\nИмя и Фамилия: %s %s\n", cycler.fName, cycler.lName);
            System.out.printf("Возраст: %d\n", cycler.age);
            System.out.printf("Страна: %s\n", cycler.country);
            System.out.println("Велосипеды: ");
            for (Bicycle bicycle : cycler.bicycles)
                System.out.printf("%s\n", bicycle.getModelName());
        }
    }

    public int goIn() {
        if (!isFinished && currentBicycle != null && isOutRace) {
            isOnRace = true;
            isOutRace = false;
            racersCount++;
            System.out.printf("Гонщик %s встал на гонку!\n", lName);
        } else if (isOnRace)
            System.out.printf("Гонщик %s уже на гонке!\n", lName);
        else if (currentBicycle == null)
            System.out.printf("У гонщика %s не выбран велосипед!\n", lName);
        else
            System.out.printf("Гонщик %s уже финишировал!\n", lName);
        return racersCount;
    }

    public int goOut() {
        if (!isFinished && isOnRace) {
            isOutRace = true;
            isOnRace = false;
            racersCount--;
            System.out.printf("Гонщик %s вышел с гонки!\n", lName);
        } else if (isOutRace)
            System.out.printf("Гонщик %s уже выбыл с гонки!\n", lName);
        else
            System.out.printf("Гонщик %s уже финишировал!\n", lName);
        return racersCount;
    }

    void addBicycle(Bicycle bicycle) {
        // Arrays copy
        Bicycle[] newBicycleArr = new Bicycle[bicycles.length + 1];
        for (int i = 0; i < bicycles.length; i++)
            newBicycleArr[i] = bicycles[i];
        // Add new object
        newBicycleArr[newBicycleArr.length - 1] = bicycle;

        bicycles = newBicycleArr;
        System.out.println("Вы успешно добавили гоночный болид!");
    }

    public String getSave() {
        if (save != null)
            return save;
        else
            System.out.printf("%s не доехал до финиша!\n", fName);
        return "";
    }

    public double finish() {
        double time = 0d;
        if (currentBicycle != null && !isFinished && isOnRace) {
            isFinished = true;
            time = (10 / Math.pow(age, 2)) / (currentBicycle.getMaxSpeed() * avSpeed);
            save = String.format("Имя: %s, Фамилия: %s, Гоночный болид: %s, Время: %f", fName, lName,
                    currentBicycle.getModelName(), time);
            System.out.printf("%s приехал на финиш!\n", fName);
        } else
            System.out.printf("%s не доехал до финиша!\n", lName);
        return time;
    }

    public void chooseBike(int number) {
        if (number > 0 && number <= bicycles.length)
            currentBicycle = bicycles[number - 1];
        else
            System.out.println("Такого велосипеда не существует!");
    }

    public void chooseBike(String modelName) {
        for (Bicycle bicycle : bicycles) {
            if (modelName.equals(bicycle.getModelName())) {
                currentBicycle = bicycle;
                System.out.printf("Велосипед для %s успешно выбран!\n", lName);
                break;
            }
        }
    }
}
