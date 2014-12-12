package uag.vlarios.greenhousecontrol;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vlarios on 12/1/2014.
 */
public class SensorTimeSel2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sensor_time_sel_2, container, false);
        TextView textview = (TextView) view.findViewById(R.id.sensor_time_sel_textview);
        //textview.setText(R.string.One);
        textview.setText(MainWindow.sensorStr + " - Seleccione la hora:");
        return view;
    }
}
