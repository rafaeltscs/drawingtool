package drawingtool;

import drawingtool.exception.CouldNotDrawException;

public class Line {

    private int x1,y1,x2,y2;

    public Line(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public void validate(Canvas canvas) {
        if (x1 < 1 || y1 < 1 || x2 < 1 || y2 < 1)
            throw new CouldNotDrawException("A line should not have coordinates lesser than 1.");
        if (!isVertical() && !isHorizontal())
            throw new CouldNotDrawException("A line should be horizontal or vertical.");
        if (x2 < x1)
            throw new CouldNotDrawException("A line must end after its starting coordinate.");
        if (y2 < y1)
            throw new CouldNotDrawException("A line must end after its starting coordinate.");
        if (x2 > canvas.getWidth())
            throw new CouldNotDrawException("Line is too long.");
        if (x1 > canvas.getWidth())
            throw new CouldNotDrawException("X1 coordinate is not valid.");
        if (y2 > canvas.getHeight())
            throw new CouldNotDrawException("Y2 coordinate is not valid.");
        if (y1 > canvas.getHeight())
            throw new CouldNotDrawException("Y1 coordinate is not valid.");
    }

    public boolean isHorizontal() {
        return y1 == y2;
    }

    public boolean isVertical(){
        return x1 == x2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
}
