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

/**
 * Created by vlarios on 11/24/2014.
 */


public class CommandsTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.commands_tab, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_elements);
        final SensorsListItemAdapter listItemAdapter = new SensorsListItemAdapter(getActivity().getBaseContext(), MainWindow.commandsArray);
        listView.setAdapter(listItemAdapter);

        //set on click listeners
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainWindow.commandStr = MainWindow.commandsArray.get(i).getHeader();
                CommandsStateSel commandsStateSel = new CommandsStateSel();
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.commands_tab, commandsStateSel);
                fragmentTransaction.commit();
                }

            }
        );
        return view;
    }
}
