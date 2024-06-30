import java.util.Objects;

public class Node implements Comparable<Node>{
    private Integer x;
    private Integer y;
    private Double DistanceH;
    private Double DistanceC;
    private Node parent;
    public Node(Integer x, Integer y, Double DistanceH, Double DistanceC, Node parent) {
        this.x = x;
        this.y = y;
        this.DistanceH = DistanceH;
        this.DistanceC = DistanceC;
        this.parent = parent;
    }
    public Node(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Double getDistanceH() {
        return DistanceH;
    }

    public void setDistanceH(Double distanceH) {
        DistanceH = distanceH;
    }

    public Double getDistanceC() {
        return DistanceC;
    }

    public void setDistanceC(Double distanceC) {
        DistanceC = distanceC;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Double getDistanceA() {
        return DistanceC + DistanceH;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(x, node.x) && Objects.equals(y, node.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.getDistanceA(), o.getDistanceA());
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", DistanceA=" + (DistanceH + DistanceC) +
                '}';
    }
}
