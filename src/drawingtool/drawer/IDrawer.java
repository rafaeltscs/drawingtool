package drawingtool.drawer;

import drawingtool.Canvas;
import drawingtool.exception.NoCanvasException;

import java.io.IOException;

/**
 * This interface should be implemented by any Drawer class.
 */
public interface IDrawer {
    Canvas draw(Canvas canvas, String input) throws IOException, NoCanvasException;
}
