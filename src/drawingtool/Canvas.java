package drawingtool;

import drawingtool.exception.CouldNotDrawException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Canvas {

    private int width;
    private int height;
    private String[][] canvas;

    public Canvas(){}

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = new String[this.height][this.width];

        String[] rowSample = new String[width];
        Arrays.fill(rowSample," ");
        Arrays.fill(this.canvas, rowSample);
    }

    public String[][] getCanvas() {
        return canvas;
    }

    public void setCanvas(String[][] canvas) {
        this.canvas = canvas;
    }

    public void draw(String output) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));

            writer.write("----------------------");

            writer.newLine();
            for (String[] row : this.canvas) {
                writer.write("|");
                for (String value : row) {
                    writer.write(value);
                }
                writer.write("|");
                writer.newLine();
            }

            writer.write("----------------------");

            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CouldNotDrawException("Output could not be drawn to " + output);
        }
    }
}
