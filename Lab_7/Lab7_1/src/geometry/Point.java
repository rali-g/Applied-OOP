package geometry;

public class Point {

private double[] coords; //(x, y)

    public Point() {
        this(new double[] {0, 0});
    }
    public Point(double[] coords) {
        setCoords(coords);
    }

    public void setCoords(double[] coords) {
        if(coords != null && coords.length == 2) {
            this.coords = new double[coords.length];
            for(int i = 0; i < coords.length; i++){
                //possible if for negative numbers
                this.coords[i] = coords[i];
            }
        }else{
            this.coords = new double[2];
        }
    }

    public Point(Point p){
        this(p.getCoords());
    }

    public double[] getCoords() {
        double[] copy = new double[coords.length];
        for (int i = 0; i < coords.length; i++) {
            copy[i] = coords[i];
        }
        return copy;
    }

    @Override
    public String toString(){
        return String.format("(%.2f; %.2f)", coords[0], coords[1]);
    }
}
