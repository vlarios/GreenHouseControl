package uag.vlarios.greenhousecontrol;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;


public class MainWindow extends Activity {

    public static ArrayList<ListItem> sensorsArray = null;
    public static ArrayList<ListItem> commandsArray = null;
    public static String sensorStr = "";
    public static String commandStr = "";
    public static String dayTextMsg = "";
    public static String monthTextMsg = "";
    public static String yearTextMsg = "";
    public static String hourTextMsg = "";
    public static String minuteTextMsg = "";
    public static String secondTextMsg = "";
    public static String varId = "";
    public static String sensorsValRcvd = "";
    public static String comp1St = "Status: Apagado";
    public static String comp2St = "Status: Apagado";
    public static String comp3St = "Status: Apagado";
    public static String comp4St = "Status: Apagado";
    public static String comp5St = "Status: Apagado";
    public static String vent1St = "Status: Apagado";
    public static String vent2St = "Status: Apagado";
    public static String vent3St = "Status: Apagado";
    public static String vent4St = "Status: Apagado";
    public static String vent5St = "Status: Apagado";
    public static String sr1St = "Status: Apagado";
    public static String sr2St = "Status: Apagado";
    public static String sr3St = "Status: Apagado";
    public static String sr4St = "Status: Apagado";
    public static String sr5St = "Status: Apagado";
    String cmd = "";
    //private RadioGroup radioOnOffGroup;
    //private RadioButton radioOnOffBtn;
    //private Button cmdSendBtn;

    ActionBar.Tab tab1, tab2;
    Fragment sensorsTab = new SensorsTab();
    Fragment commandsTab = new CommandsTab();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);



        tab1 = actionBar.newTab().setText("Sensores");
        tab2 = actionBar.newTab().setText("Comandos");


        tab1.setTabListener(new TabListener(sensorsTab));
        tab2.setTabListener(new TabListener(commandsTab));


        actionBar.addTab(tab1);
        actionBar.addTab(tab2);

        sensorsArray = new ArrayList<ListItem>();

        updateSensorsArray("Temperatura 1");
        updateSensorsArray("Temperatura 2");
        updateSensorsArray("Temperatura 3");
        updateSensorsArray("Temperatura 4");
        updateSensorsArray("Temperatura 5");
        updateSensorsArray("Humedad 1");
        updateSensorsArray("Humedad 2");
        updateSensorsArray("Humedad 3");
        updateSensorsArray("Humedad 4");
        updateSensorsArray("Humedad 5");
        updateSensorsArray("PH 1");
        updateSensorsArray("PH 2");
        updateSensorsArray("PH 3");
        updateSensorsArray("PH 4");
        updateSensorsArray("PH 5");

        commandsArray = new ArrayList<ListItem>();

        updateCommandsArray("Compuerta 1");
        updateCommandsArray("Compuerta 2");
        updateCommandsArray("Compuerta 3");
        updateCommandsArray("Compuerta 4");
        updateCommandsArray("Compuerta 5");
        updateCommandsArray("Ventilador 1");
        updateCommandsArray("Ventilador 2");
        updateCommandsArray("Ventilador 3");
        updateCommandsArray("Ventilador 4");
        updateCommandsArray("Ventilador 5");
        updateCommandsArray("Sistema de riego 1");
        updateCommandsArray("Sistema de riego 2");
        updateCommandsArray("Sistema de riego 3");
        updateCommandsArray("Sistema de riego 4");
        updateCommandsArray("Sistema de riego 5");

        //radioOnOffGroup = (RadioGroup) findViewById(R.id.onOffGroup);
        //cmdSendBtn = (Button) findViewById(R.id.cmdSendBtn);

        /*
        cmdSendBtn.setOnClickListener(new AdapterView.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioOnOffGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioOnOffBtn = (RadioButton) findViewById(selectedId);

                if (radioOnOffBtn.getText() == "radioOff") {
                    System.out.println("radioOff");
                }
                if (radioOnOffBtn.getText() == "radioOn") {
                    System.out.println("radioOn");
                }


            }

        });
        */

    }

    private void updateSensorsArray(String str) {
        ListItem listItem = new ListItem();
        listItem.setHeader(str);
        sensorsArray.add(listItem);
    }

    private void updateCommandsArray(String str) {
        ListItem listItem = new ListItem();
        listItem.setHeader(str);
        commandsArray.add(listItem);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_window, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goTosensorTimeSel2(View view) {
        EditText dayText = (EditText) findViewById(R.id.dayText);
        dayTextMsg = dayText.getText().toString();
        EditText monthText = (EditText) findViewById(R.id.monthText);
        monthTextMsg = monthText.getText().toString();
        EditText yearText = (EditText) findViewById(R.id.yearText);
        yearTextMsg = yearText.getText().toString();
        SensorTimeSel2 sensorTimeSel2 = new SensorTimeSel2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sensor_time_sel, sensorTimeSel2);
        fragmentTransaction.commit();
    }

    public void goToGraphWindow(View view) {
        //get time strings from the user
        EditText hourText = (EditText) findViewById(R.id.hourText);
        hourTextMsg = hourText.getText().toString();
        EditText minuteText = (EditText) findViewById(R.id.minuteText);
        minuteTextMsg = minuteText.getText().toString();
        EditText secondText = (EditText) findViewById(R.id.secondText);
        secondTextMsg = secondText.getText().toString();
        //convert sensors to name to DB tables names
        getVarIds();
        //contact serger and get variables
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("http://vluag.x10host.com/green_house/get_vars.php?varId="+varId+"&fecha="+yearTextMsg+"-"+monthTextMsg+"-"+dayTextMsg+"&hora="+hourTextMsg+":"+minuteTextMsg+":"+secondTextMsg);
                    URL url = new URL("http://vluag.x10host.com/green_house/get_vars.php?varId="+varId+"&fecha="+yearTextMsg+"-"+monthTextMsg+"-"+dayTextMsg+"&hora="+hourTextMsg+":"+minuteTextMsg+":"+secondTextMsg);
                    HttpURLConnection con = (HttpURLConnection) url
                            .openConnection();
                    readStream(con.getInputStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void goToSensorsTab(View view) {
        SensorsTab sensorsTab = new SensorsTab();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.graph_window, sensorsTab);
        fragmentTransaction.commit();
    }

    /*
    public void goToCommandsTab(View view) {
        CommandsTab commandsTab = new CommandsTab();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.commands_state_sel, commandsTab);
        fragmentTransaction.commit();
    }*/

    public void offCmdSendBtnPressed(View view) {

        if (commandStr.equals("Compuerta 1")) {
            comp1St = "Status: Apagado";
            cmd = "apagar_compuerta_1";
        }
        else if (commandStr.equals("Compuerta 2")) {
            comp2St = "Status: Apagado";
            cmd = "apagar_compuerta_2";
        }
        else if (commandStr.equals("Compuerta 3")) {
            comp3St = "Status: Apagado";
            cmd = "apagar_compuerta_3";
        }
        else if (commandStr.equals("Compuerta 4")) {
            comp4St = "Status: Apagado";
            cmd = "apagar_compuerta_4";
        }
        else if (commandStr.equals("Compuerta 5")) {
            comp5St = "Status: Apagado";
            cmd = "apagar_compuerta_5";
        }
        else if (commandStr.equals("Ventilador 1")) {
            vent1St = "Status: Apagado";
            cmd = "apagar_ventilador_1";
        }
        else if (commandStr.equals("Ventilador 2")) {
            vent2St = "Status: Apagado";
            cmd = "apagar_ventilador_2";
        }
        else if (commandStr.equals("Ventilador 3")) {
            vent3St = "Status: Apagado";
            cmd = "apagar_ventilador_3";
        }
        else if (commandStr.equals("Ventilador 4")) {
            vent4St = "Status: Apagado";
            cmd = "apagar_ventilador_4";
        }
        else if (commandStr.equals("Ventilador 5")) {
            vent5St = "Status: Apagado";
            cmd = "apagar_ventilador_5";
        }
        else if (commandStr.equals("Sistema de riego 1")) {
            sr1St = "Status: Apagado";
            cmd = "apagar_sistema_de_riego_1";
        }
        else if (commandStr.equals("Sistema de riego 2")) {
            sr2St = "Status: Apagado";
            cmd = "apagar_sistema_de_riego_2";
        }
        else if (commandStr.equals("Sistema de riego 3")) {
            sr3St = "Status: Apagado";
            cmd = "apagar_sistema_de_riego_3";
        }
        else if (commandStr.equals("Sistema de riego 4")) {
            sr4St = "Status: Apagado";
            cmd = "apagar_sistema_de_riego_4";
        }
        else if (commandStr.equals("Sistema de riego 5")) {
            sr5St = "Status: Apagado";
            cmd = "apagar_sistema_de_riego_5";
        }
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("http://vluag.x10host.com/green_house/set_commands.php?command="+cmd);
                    URL url = new URL("http://vluag.x10host.com/green_house/set_commands.php?command="+cmd);
                    HttpURLConnection con = (HttpURLConnection) url
                            .openConnection();
                    readStream2(con.getInputStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    public void onCmdSendBtnPressed(View view) {

        if (commandStr.equals("Compuerta 1")) {
            comp1St = "Status: Encendido";
            cmd = "encender_compuerta_1";
        }
        else if (commandStr.equals("Compuerta 2")) {
            comp2St = "Status: Encendido";
            cmd = "encender_compuerta_2";
        }
        else if (commandStr.equals("Compuerta 3")) {
            comp3St = "Status: Encendido";
            cmd = "encender_compuerta_3";
        }
        else if (commandStr.equals("Compuerta 4")) {
            comp4St = "Status: Encendido";
            cmd = "encender_compuerta_4";
        }
        else if (commandStr.equals("Compuerta 5")) {
            comp5St = "Status: Encendido";
            cmd = "encender_compuerta_5";
        }
        else if (commandStr.equals("Ventilador 1")) {
            vent1St = "Status: Encendido";
            cmd = "encender_ventilador_1";
        }
        else if (commandStr.equals("Ventilador 2")) {
            vent2St = "Status: Encendido";
            cmd = "encender_ventilador_2";
        }
        else if (commandStr.equals("Ventilador 3")) {
            vent3St = "Status: Encendido";
            cmd = "encender_ventilador_3";
        }
        else if (commandStr.equals("Ventilador 4")) {
            vent4St = "Status: Encendido";
            cmd = "encender_ventilador_4";
        }
        else if (commandStr.equals("Ventilador 5")) {
            vent5St = "Status: Encendido";
            cmd = "encender_ventilador_5";
        }
        else if (commandStr.equals("Sistema de riego 1")) {
            sr1St = "Status: Encendido";
            cmd = "encender_sistema_de_riego_1";
        }
        else if (commandStr.equals("Sistema de riego 2")) {
            sr2St = "Status: Encendido";
            cmd = "encender_sistema_de_riego_2";
        }
        else if (commandStr.equals("Sistema de riego 3")) {
            sr3St = "Status: Encendido";
            cmd = "encender_sistema_de_riego_3";
        }
        else if (commandStr.equals("Sistema de riego 4")) {
            sr4St = "Status: Encendido";
            cmd = "encender_sistema_de_riego_4";
        }
        else if (commandStr.equals("Sistema de riego 5")) {
            sr5St = "Status: Encendido";
            cmd = "encender_sistema_de_riego_5";
        }
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("http://vluag.x10host.com/green_house/set_commands.php?command="+cmd);
                    URL url = new URL("http://vluag.x10host.com/green_house/set_commands.php?command="+cmd);
                    HttpURLConnection con = (HttpURLConnection) url
                            .openConnection();
                    readStream2(con.getInputStream());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void getVarIds() {
        if (sensorStr.equals("Temperatura 1")) {
            varId = "temp1";
        }
        else if (sensorStr.equals("Temperatura 2")) {
            varId = "temp2";
        }
        else if (sensorStr.equals("Temperatura 3")) {
            varId = "temp3";
        }
        else if (sensorStr.equals("Temperatura 4")) {
            varId = "temp4";
        }
        else if (sensorStr.equals("Temperatura 5")) {
            varId = "tem5";
        }
        else if (sensorStr.equals("Humedad 1")) {
            varId = "hum1";
        }
        else if (sensorStr.equals("Humedad 2")) {
            varId = "hum2";
        }
        else if (sensorStr.equals("Humedad 3")) {
            varId = "hum3";
        }
        else if (sensorStr.equals("Humedad 4")) {
            varId = "hum4";
        }
        else if (sensorStr.equals("Humedad 5")) {
            varId = "hum5";
        }
        else if (sensorStr.equals("PH 1")) {
            varId = "ph1";
        }
        else if (sensorStr.equals("PH 2")) {
            varId = "ph2";
        }
        else if (sensorStr.equals("PH 3")) {
            varId = "ph3";
        }
        else if (sensorStr.equals("PH 4")) {
            varId = "ph4";
        }
        else if (sensorStr.equals("PH 5")) {
            varId = "ph5";
        }
    }

    private void readStream(InputStream in) {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(in));
            System.out.println("about to read lines!");
            String line = "";
            while ((line = reader.readLine()) != null) {
                sensorsValRcvd = line;
                System.out.println(sensorsValRcvd);
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //go to graphics window
                    GraphWindow graphWindow = new GraphWindow();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.sensor_time_sel_2, graphWindow);
                    fragmentTransaction.commit();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void readStream2(InputStream in) {

        BufferedReader reader = null;
        String tmp = "";
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            System.out.println("about to read lines!");
            String line = "";
            while ((line = reader.readLine()) != null) {
                tmp = line;
                System.out.println(tmp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

