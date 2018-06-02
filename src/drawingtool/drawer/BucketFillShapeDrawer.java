package drawingtool.drawer;

import drawingtool.Canvas;
import drawingtool.exception.NoCanvasException;

public class BucketFillShapeDrawer implements IShapeDrawer {

    @Override
    public Canvas draw(Canvas canvas, String input, String output) throws NoCanvasException {
        System.out.println("Bucket Fill: " + input);
        String[] values = input.split(" ");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        String color = values[2];

        Bucket bucket = new Bucket(x,y,color);
        canvas.bucketFill(bucket);
        canvas.draw(output, true);
        return canvas;
    }
}

