package drawingtool.drawer;

import drawingtool.Canvas;

public class CanvasShapeDrawer implements IShapeDrawer {

    @Override
    public Canvas draw(Canvas canvas, String input, String output) {
        System.out.println("Canvas: " + input);
        String[] dimensions = input.split(" ");
        canvas.setSize(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
        canvas.draw(output, false);
        return canvas;
    }
}
