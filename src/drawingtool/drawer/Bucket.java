package drawingtool.drawer;

import drawingtool.Canvas;
import drawingtool.exception.CoordinatesOutOfBoundsException;

public class Bucket {
    private int x,y;
    private String color;

    public Bucket(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public void validate(Canvas canvas) {
        if(x < 1 || y < 1 || x > canvas.getWidth() || y > canvas.getHeight())
            throw new CoordinatesOutOfBoundsException( String.format("(%2d, %2d) is invalid for filling.", x, y));
    }

    public String[][] fill(String[][] canvas) {
        return floodFill(canvas, x-1, y-1, canvas[y][x]);
    }

    private String[][] floodFill(String[][] canvas, int xNode, int yNode, String targetColor) {

        if(xNode < 0 || yNode < 0 || xNode >= canvas[0].length || yNode >= canvas.length)
            return canvas;

        String nodeColor = canvas[yNode][xNode];

        if (targetColor.equals(this.color) || !nodeColor.equals(targetColor))
            return canvas;

        canvas[yNode][xNode] = this.color;

        canvas = floodFill(canvas, xNode, yNode+1, targetColor);
        canvas = floodFill(canvas, xNode, yNode-1, targetColor);
        canvas = floodFill(canvas, xNode+1, yNode, targetColor);
        canvas = floodFill(canvas, xNode-1, yNode, targetColor);

        return canvas;
    }

}
