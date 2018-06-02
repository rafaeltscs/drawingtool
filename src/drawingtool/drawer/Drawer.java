package drawingtool.drawer;

import drawingtool.Canvas;
import drawingtool.exception.CouldNotDrawException;
import drawingtool.exception.NoCanvasException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Handles the input data and calls the correct Drawers for each shape.
 */
public class Drawer {
    private static Drawer ourInstance = new Drawer();
    public static Drawer getInstance() {
        return ourInstance;
    }

    private Drawer() {
    }

    private Canvas canvas = new Canvas();

    public void draw(String input, String output) throws IOException, NoCanvasException, CouldNotDrawException {

        Optional<Supplier<Stream<String>>> optStreamSupplier = getInputStreamSupplier(input);

        optStreamSupplier.ifPresent( streamSupplier -> {
            if (!streamSupplier.get().findFirst().orElse("").startsWith("C")) {
                throw new NoCanvasException("No canvas has been drawn yet.");
            }

            streamSupplier.get().forEach( line -> {
                switch (line.charAt(0)) {
                    case 'C':
                        canvas = new CanvasDrawer().draw(canvas,line.substring(1).trim());
                        break;
                }
            });

            this.canvas.draw(output);
        });
    }

    /**
     * Gets the Stream supplier for the input path.
     * @param input
     *  path to the input file
     *
     * @return
     *  An optional Stream supplier for the input path.
     */
    private Optional<Supplier<Stream<String>>> getInputStreamSupplier(String input) {
        return Optional.of( () -> {
            try {
                return Files.lines(Paths.get(input));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        });

    }

}