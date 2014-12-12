package uag.vlarios.greenhousecontrol;

import 	android.view.View;
import 	android.content.Context;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Color;

/**
 * Created by vlarios on 12/1/2014.
 */
public class DrawArea extends View{
    Paint paint = new Paint();

    public DrawArea(Context context) {
        super(context);
    }
    @Override
    public void onDraw(Canvas canvas) {


        int lowX = 20;
        int lowY = 130;
        int hiX = 350;
        int hiY = 350;
        int numDivX;
        int sizeDivX;
        int numDivY = 11;
        int sizeDivY = (hiY- lowY) / numDivY;
        Integer sensorValInY=0;
        String hr = "";
        String min = "";
        String sec = "";
        String[] tokens2 = new String[3];
        String[] tokens3 = new String[3];
        int selTime;
        int selValue = 0;
        int offset = 0;


        //int[] pointsArray = {4,6,8,10,9,7,5,3,1,3};

        //check the type of sensor
        String[] tokens = MainWindow.sensorStr.split(" ");
        String sensorType = tokens[0];
        if (sensorType.equals("Temperatura")) {
            sensorValInY = 25;
            offset = 24;
        }
        else {
            sensorValInY = 1;
            offset = 0;
        }

        //draw rectangle
        Rect rect = new Rect(lowX, lowY, hiX, hiY);

        // fill
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.CYAN);
        canvas.drawRect(rect, paint);

        // border
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(rect, paint);

        //draw X scale
        tokens2 = MainWindow.sensorsValRcvd.split(" ");
        numDivX = (tokens2.length/3) + 1;
        selTime = tokens2.length - 1;
        sizeDivX = (hiX - lowX) / numDivX;
        for (int i = 1; i < numDivX; i++) {
            canvas.drawLine(lowX + (sizeDivX * i), hiY - 10, lowX + (sizeDivX * i), hiY + 10, paint);
            tokens3 = tokens2[selTime].split(":");
            selTime = selTime - 3;
            hr = tokens3[0];
            min = tokens3[1];
            sec = tokens3[2];
            canvas.drawText(hr+"h", lowX + (sizeDivX * i)-6, hiY + 25, paint);
            canvas.drawText(min+"m", lowX + (sizeDivX * i)-6, hiY + 45, paint);
            canvas.drawText(sec+"s", lowX + (sizeDivX * i)-6, hiY + 65, paint);
        }

        //draw Y scale
        for (int i = 1; i < numDivY; i++) {
            canvas.drawLine(lowX-10, hiY - (sizeDivY * i), lowX+10, hiY - (sizeDivY * i), paint);
            canvas.drawText(sensorValInY.toString(), lowX-17, hiY - (sizeDivY * i), paint);
            sensorValInY++;
        }

        //draw points and lines
        int xIni;
        int xFinal;
        int yIni;
        int yFinal;
        selValue = (tokens2.length - 1)-2;
        for (int i = 1; i < numDivX; i++) {
            canvas.drawRect(lowX + (sizeDivX * i), (hiY - (sizeDivY * (Integer.parseInt(tokens2[selValue])-(offset))))-4,(lowX + (sizeDivX * i))+4, hiY - (sizeDivY *(Integer.parseInt(tokens2[selValue])-(offset))), paint);
            if (i < numDivX-1) {
                xIni = lowX + (sizeDivX * i);
                xFinal = lowX + (sizeDivX * (i+1));
                yIni = hiY - (sizeDivY * (Integer.parseInt(tokens2[selValue])-(offset)));
                yFinal = hiY - (sizeDivY * (Integer.parseInt(tokens2[selValue-3])-(offset)));
                canvas.drawLine(xIni,yIni,xFinal,yFinal,paint);
                selValue = selValue - 3;
            }

        }

    }
}
