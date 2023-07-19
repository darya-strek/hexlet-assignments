package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Segment() {
        this.beginPoint = new Point(0, 0);
        this.endPoint = new Point(0, 0);
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(Point beginPoint) {
        this.beginPoint = beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public Point getMidPoint() {
        int xMidPoint = (beginPoint.getX() + endPoint.getX()) / 2;
        int yMidPoint = (beginPoint.getY() + endPoint.getY()) / 2;
        Point midPoint = new Point(xMidPoint, yMidPoint);
        return midPoint;
    }
}
// END
