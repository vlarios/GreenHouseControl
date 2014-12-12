package uag.vlarios.greenhousecontrol;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


/**
 * Created by vlarios on 11/24/2014.
 */
public class SensorsTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sensors_tab, container, false);
        //TextView textview = (TextView) view.findViewById(R.id.tabtextview2);
        //textview.setText(R.string.One);
        //textview.setText("One");

        ListView listView = (ListView) view.findViewById(R.id.list_elements);
        final SensorsListItemAdapter listItemAdapter = new SensorsListItemAdapter(getActivity().getBaseContext(), MainWindow.sensorsArray);
        listView.setAdapter(listItemAdapter);

        //set on click listeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            MainWindow.sensorStr = MainWindow.sensorsArray.get(i).getHeader();
            SensorTimeSel sensorTimeSel = new SensorTimeSel();
            FragmentManager fragmentManager = getActivity().getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.sensors_tab, sensorTimeSel);
            fragmentTransaction.commit();
            }

        }
        );

        return view;
    }
}
