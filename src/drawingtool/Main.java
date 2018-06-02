package drawingtool;

import drawingtool.drawer.Drawer;
import drawingtool.exception.CouldNotDrawException;
import drawingtool.exception.NoCanvasException;
import drawingtool.exception.NoInputException;
import drawingtool.exception.UnknownShapeException;

import java.io.File;
import java.io.IOException;

/**
 * This application reads instructions from INPUT and draws them into OUTPUT.
 */
public class Main {

    private static final String DEFAULT_OUTPUT = System.getProperty("user.dir") + File.separator + "output.txt";

    public static void main(String[] args) {

        int argsLength = args.length;
        String output = (argsLength > 1) ? args[1] : DEFAULT_OUTPUT;

        try {
            if (argsLength == 0) {
                throw new NoInputException("You must provide an input source.");
            }

            Drawer drawer = Drawer.getInstance();
            drawer.draw(args[0], output);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoInputException | NoCanvasException | CouldNotDrawException | UnknownShapeException e) {
           System.out.println(e.getMessage());
        }


    }
}
