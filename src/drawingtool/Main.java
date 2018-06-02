package drawingtool;

import drawingtool.drawer.Drawer;
import drawingtool.exception.CouldNotDrawException;
import drawingtool.exception.NoCanvasException;
import drawingtool.exception.UnknownShapeException;

import java.io.File;
import java.io.IOException;

/**
 * This application reads instructions from INPUT and draws them into OUTPUT.
 */
public class Main {

    private static final String DEFAULT_OUTPUT = System.getProperty("user.dir") + File.separator + "output.txt";
    private static final String DEFAULT_INPUT = System.getProperty("user.dir") + File.separator + "input.txt";

    public static void main(String[] args) {

        int argsLength = args.length;
        String input = (argsLength > 0) ? args[0] : DEFAULT_INPUT;
        String output = (argsLength > 1) ? args[1] : DEFAULT_OUTPUT;

        try {
            if (argsLength == 0) {
                System.out.println("No input provided. Using default input location: " + DEFAULT_INPUT);
            }
            Drawer drawer = Drawer.getInstance();
            drawer.draw(input, output);

            System.out.println("Output written into: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoCanvasException | CouldNotDrawException | UnknownShapeException e) {
           System.out.println(e.getMessage());
        }


    }
}
