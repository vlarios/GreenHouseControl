package uag.vlarios.greenhousecontrol;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RelativeLayout;
/**
 * Created by vlarios on 12/1/2014.
 */
public class GraphWindow extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String monthName = "";
        View view = inflater.inflate(R.layout.graph_window, container, false);
        TextView textview = (TextView) view.findViewById(R.id.graph_window_textview);
        textview.setText(MainWindow.sensorStr + " - Gráfica:");
        TextView textview2 = (TextView) view.findViewById(R.id.graph_window_textview_2);
        //convert month number to string
        switch (Integer.parseInt(MainWindow.monthTextMsg)) {
            case 1:
                monthName = "Enero";
                break;
            case 2:
                monthName = "Febrero";
                break;
            case 3:
                monthName = "Marzo";
                break;
            case 4:
                monthName = "Abril";
                break;
            case 5:
                monthName = "Mayo";
                break;
            case 6:
                monthName = "Junio";
                break;
            case 7:
                monthName = "Julio";
                break;
            case 8:
                monthName = "Agosto";
                break;
            case 9:
                monthName = "Septiembre";
                break;
            case 10:
                monthName = "Octubre";
                break;
            case 11:
                monthName = "Noviembre";
                break;
            case 12:
                monthName = "Diciembre";
                break;
            default:
                monthName = "Mes invalido!";
                break;
        }
        textview2.setText(monthName + " " + MainWindow.dayTextMsg + ", " + MainWindow.yearTextMsg);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.graph_window);
        relativeLayout.addView(new DrawArea(getActivity()));
        return view;

    }
}
