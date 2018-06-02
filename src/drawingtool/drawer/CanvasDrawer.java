package drawingtool.drawer;

import drawingtool.Canvas;

public class CanvasDrawer implements IDrawer {

    @Override
    public Canvas draw(Canvas canvas, String input) {
        System.out.println("Canvas: " + input);
        String[] dimensions = input.split(" ");
        canvas.setSize(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
        return canvas;
    }
}
