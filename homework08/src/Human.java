public class Human {
    private String name;
    private int weight;

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setName(String name) {
        if (name.length() == 0 || name.length() > 30) {
            name = null;
        }
        this.name = name;
    }

    public void setWeight(int weight) {
        if (weight <= 0 || weight > 150) {
            weight = 0;
        }
        this.weight = weight;
    }
}
