package drawingtool.drawer;

import drawingtool.Canvas;
import drawingtool.Line;

public class LineShapeDrawer implements IShapeDrawer {

    @Override
    public Canvas draw(Canvas canvas, String input, String output) {
        System.out.println("Line: " + input);
        String[] coordinates = input.split(" ");

        int x1 = Integer.parseInt(coordinates[0]);
        int y1 = Integer.parseInt(coordinates[1]);
        int x2 = Integer.parseInt(coordinates[2]);
        int y2 = Integer.parseInt(coordinates[3]);

        Line line = new Line(x1,y1,x2,y2);
        canvas.fillLine(line);
        canvas.draw(output, true);
        return canvas;
    }


}
