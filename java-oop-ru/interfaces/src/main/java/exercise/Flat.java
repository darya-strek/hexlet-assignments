package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public Flat() {
    }

    public double getFlatArea() {
        return area;
    }

    public void setFlatArea(double flatArea) {
        this.area = flatArea;
    }

    public double getBalconyArea() {
        return balconyArea;
    }

    public void setBalconyArea(double balconyArea) {
        this.balconyArea = balconyArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getArea() {
        return (area + balconyArea);
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(this.getArea(), another.getArea());
    }

}
// END
