package drawingtool;

import drawingtool.exception.CouldNotDrawException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class represents the canvas where the shapes must be drawn.
 */
public class Canvas {

    private int width;
    private int height;
    private String[][] canvas;

    public Canvas(){}

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = new String[this.height][this.width];

        for (int x = 0; x < this.height; x++)
        {
            for (int y = 0; y < this.width; y++)
            {
                this.canvas[x][y] =  " ";
            }
        }
    }

    public void draw(String output, boolean append) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output, append));

            writer.append("----------------------");

            writer.newLine();
            for (String[] row : this.canvas) {
                writer.append("|");
                for (String value : row) {
                    writer.append(value);
                }
                writer.append("|");
                writer.newLine();
            }

            writer.append("----------------------");

            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CouldNotDrawException("Output could not be drawn to " + output);
        }
    }

    public void fillLine(Line line) {
        line.validate(this);

        if(line.isHorizontal()) {
            int rowIdx = line.getY1() - 1;
            String[] canvasLine = canvas[rowIdx];
            for (int i = 0; i < canvasLine.length; i++) {
                if (i + 1 >= line.getX1() && i + 1 <= line.getX2()) {
                    canvas[rowIdx][i] = "x";
                }
            }
        } else if (line.isVertical()) {
            int colIdx = line.getX1() -1;
            for(int i = line.getY1() -1; i < line.getY2(); i++) {
                canvas[i][colIdx] = "x";
            }
        }
    }

    public void fillRectangle(Rectangle rectangle) {
        rectangle.validate(this);

        fillLine(rectangle.getTop());
        fillLine(rectangle.getRight());
        fillLine(rectangle.getBottom());
        fillLine(rectangle.getLeft());
    }

    public void bucketFill(Bucket bucket) {
        bucket.validate(this);
        setCanvas(bucket.fill(this.getCanvas()));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getCanvas() {
        return this.canvas;
    }

    public void setCanvas(String[][] canvas) {
        this.canvas = canvas;
    }
}
