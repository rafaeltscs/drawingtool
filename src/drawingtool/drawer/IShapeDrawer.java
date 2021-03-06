package drawingtool.drawer;

import drawingtool.Canvas;
import drawingtool.exception.NoCanvasException;

import java.io.IOException;

/**
 * This interface should be implemented by any Drawer class.
 */
public interface IShapeDrawer {
    Canvas draw(Canvas canvas, String input, String output) throws IOException, NoCanvasException;
}
