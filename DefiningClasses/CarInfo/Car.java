package DefiningClasses.CarInfo;

public class Car {
    private String brand;
    private String model;
    private int hp;

    public Car(String brand, String model, int hp) {
        this.brand = brand;
        this.model = model;
        this.hp = hp;
    }

    public Car (String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.hp = -1;
    }

    public Car() {

    }


    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {

        return String.format("The car is: %s %s - %d HP.%n", this.getBrand(), this.getModel(), this.getHp());
    }
}
