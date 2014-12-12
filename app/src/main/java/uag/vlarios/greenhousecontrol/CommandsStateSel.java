package uag.vlarios.greenhousecontrol;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vlarios on 12/10/2014.
 */
public class CommandsStateSel extends Fragment {
    String commandStatus = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.commands_state_sel, container, false);
        TextView textview = (TextView) view.findViewById(R.id.textViewTitle);
        textview.setText("Control de " + MainWindow.commandStr);
        TextView textview2 = (TextView) view.findViewById(R.id.textViewStatus);

        if (MainWindow.commandStr.equals("Compuerta 1")) {
            commandStatus = MainWindow.comp1St;
        }
        else if (MainWindow.commandStr.equals("Compuerta 2")) {
            commandStatus = MainWindow.comp2St;
        }
        else if (MainWindow.commandStr.equals("Compuerta 3")) {
            commandStatus = MainWindow.comp3St;
        }
        else if (MainWindow.commandStr.equals("Compuerta 4")) {
            commandStatus = MainWindow.comp4St;
        }
        else if (MainWindow.commandStr.equals("Compuerta 5")) {
            commandStatus = MainWindow.comp5St;
        }
        else if (MainWindow.commandStr.equals("Ventilador 1")) {
            commandStatus = MainWindow.vent1St;
        }
        else if (MainWindow.commandStr.equals("Ventilador 2")) {
            commandStatus = MainWindow.vent2St;
        }
        else if (MainWindow.commandStr.equals("Ventilador 3")) {
            commandStatus = MainWindow.vent3St;
        }
        else if (MainWindow.commandStr.equals("Ventilador 4")) {
            commandStatus = MainWindow.vent4St;
        }
        else if (MainWindow.commandStr.equals("Ventilador 5")) {
            commandStatus = MainWindow.vent5St;
        }
        else if (MainWindow.commandStr.equals("Sistema de riego 1")) {
            commandStatus = MainWindow.sr1St;
        }
        else if (MainWindow.commandStr.equals("Sistema de riego 2")) {
            commandStatus = MainWindow.sr2St;
        }
        else if (MainWindow.commandStr.equals("Sistema de riego 3")) {
            commandStatus = MainWindow.sr3St;
        }
        else if (MainWindow.commandStr.equals("Sistema de riego 4")) {
            commandStatus = MainWindow.sr4St;
        }
        else if (MainWindow.commandStr.equals("Sistema de riego 5")) {
            commandStatus = MainWindow.sr5St;
        }

        textview2.setText(commandStatus);
        return view;
    }
}
