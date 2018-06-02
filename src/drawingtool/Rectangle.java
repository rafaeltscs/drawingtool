package drawingtool;

/**
 * This class represents a rectangle to be drawn into a Canvas.
 */
public class Rectangle {

    private Line top, right, bottom, left;

    public Rectangle(int x1, int y1, int x2, int y2){
        this.top = new Line(x1,y1,x2,y1);
        this.right = new Line(x2,y1,x2,y2);
        this.bottom = new Line(x1,y2,x2,y2);
        this.left = new Line(x1,y1,x1,y2);
    }

    public void validate(Canvas canvas) {
        top.validate(canvas);
        right.validate(canvas);
        bottom.validate(canvas);
        left.validate(canvas);
    }

    public Line getBottom() {
        return bottom;
    }

    public Line getLeft() {
        return left;
    }

    public Line getRight() {
        return right;
    }

    public Line getTop() {
        return top;
    }
}
