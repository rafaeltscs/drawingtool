package drawingtool.drawer;

import drawingtool.Canvas;
import drawingtool.Line;
import drawingtool.Rectangle;

/**
 * This class is responsible for controlling the RectangleShape Drawing
 */
public class RectangleShapeDrawer implements IShapeDrawer {

    @Override
    public Canvas draw(Canvas canvas, String input, String output) {
        System.out.println("Drawing Rectangle: " + input);
        String[] coordinates = input.split(" ");

        int x1 = Integer.parseInt(coordinates[0]);
        int y1 = Integer.parseInt(coordinates[1]);
        int x2 = Integer.parseInt(coordinates[2]);
        int y2 = Integer.parseInt(coordinates[3]);

        Rectangle rectangle = new Rectangle(x1,y1,x2,y2);

        canvas.fillRectangle(rectangle);
        canvas.draw(output, true);
        return canvas;
    }


}
