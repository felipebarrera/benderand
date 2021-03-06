package cl.webinc.benderand.crud;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import cl.webinc.benderand.R;
import cl.webinc.benderand.AppMy;
import cl.webinc.benderand.provider.Base.*;
import cl.webinc.benderand.sync.PostData;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class Tipo_pagoEditor extends Activity {
    private static final String TAG = "EDITOR tipo_pago";
    private String ID = "0";
    private static final int ADD_ID = Menu.FIRST;
    private static final int DISCARD_ID = Menu.FIRST + 1;
    private static final int DELETE_ID = Menu.FIRST + 2;
    private static final int EDIT_ID = Menu.FIRST + 3;
    private static final int STATE_EDIT = 1;
    private static final int STATE_INSERT = 0;
    private int mState;
    private HashMap<String, String> map = new HashMap<String, String>();
    public String action;
    private ArrayList<HashMap<String, String>> mylist;
    private static AppMy app = AppMy.getinstance();
    public HashMap<String, ArrayList<HashMap<String, String>>>  arraylist;
    private EditText mid_tipo_pago;
    private EditText mnombre_tipo_pago;
    private EditText mcomision_tipo_pago;
    
    
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "ONCREATE ");
        super.onCreate(savedInstanceState);
        ID = app.getExtra().get("id");
        
        setContentView(R.layout.editortipo_pago);
        asignarCamposvariableCorta();
        if(!ID.equals("0"))
        {           
            Log.e("ONCREATE query  ", "ID != 0" + ID );
            limpiarPantalla();
            mState = STATE_EDIT;
            
            new sincTaskbuscarid().execute();
        }
        else
        {
            limpiarPantalla();
            mState = STATE_INSERT;
        }
        
        new sincTaskcargaspinners().execute();        
        
    }
    
    private class sincTask extends AsyncTask<String, Void, Boolean>  
    {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Tipo_pagoEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        private boolean login = false;
        @Override
        protected void onPostExecute(Boolean result) 
        {
            if(login)
            {
                Toast.makeText(getApplicationContext(), "Sinc tipo_pago ok", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Sinc tipo_pago ok");
            }
            else 
            {
                Toast.makeText(getApplicationContext(), "Error en sinc tipo_pago", Toast.LENGTH_SHORT).show();
                Log.e("sincTask " + mState, "Error en sinc tipo_pago");
            }
            dialog.dismiss();
            finish();//vuelvo a la lista
        }
        @Override
        protected Boolean doInBackground(
                String... params) {
            app = AppMy.getinstance();
            Log.e("addtipo_pago  ", " do in background");
            if(!app.isExternal()){
                if (mState == STATE_INSERT) {
                    String idtipo_pago = String.valueOf(Integer.valueOf(getContentResolver().insert(tipo_pago.CONTENT_URI, PostData.getinstance().postdataready(map, "tipo_pago")).getLastPathSegment()));
                    login = Integer.valueOf(idtipo_pago) > 0;
                    Log.e("addtipo_pago  ", " do in background " + idtipo_pago);
                }
                else
                {
                    Log.e("" + mState, "mState" + mState);
                    try{
                        Log.e("values", "" + PostData.getinstance().postdataready(map, "tipo_pago").toString());
                        String idtipo_pago = String.valueOf(Integer.valueOf(getContentResolver().update(ContentUris.withAppendedId(tipo_pago.CONTENT_URI, Long.parseLong(ID)),
                                PostData.getinstance().postdataready(map, "tipo_pago"),null,null)));
                        login = Integer.valueOf(idtipo_pago) > 0;
                        Log.e("updatetipo_pago ", " do in background " + idtipo_pago);
                    }
                        catch (SQLException e) {e.printStackTrace(); Log.e("catch insert", "" + e);}
                    
                }
            }
            else
            {
                if(app.isOnline(Tipo_pagoEditor.this))
                {
                    if (mState == STATE_INSERT) {
                        action = "savetipo_pago";
                    }
                    else
                    {
                        action = "updatetipo_pago";
                    }
                    login = WebConector.sendData("http://" + app.getUrl() + "/index.php/androidtienda/" + action, map, "tipo_pago");
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
                }
            }
            return login;
        }
     }
    
    
    private class sincTaskbuscarid extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>  
    {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Tipo_pagoEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
            if(result.size() != 0) 
            {
                asignarCamposvariableCorta();
                muestraeditor();
                Log.e("tipo_pagoeditor", " not null");
            }else {
                Toast.makeText(getApplicationContext(), "No se encuentra tipo_pago, error de sincronizacion", Toast.LENGTH_SHORT).show();
                Log.e("terrible null", " return");
            }
            dialog.dismiss();
         }
        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(
                String... params) {
            Log.e("thread end", " thread end");
            app = AppMy.getinstance();
            if(!app.isExternal()){
                mylist = CursortoArrayhash.getinstance().ahTipo_pago(getContentResolver().query(
                        ContentUris.withAppendedId(tipo_pago.CONTENT_URI, Long.parseLong(ID)), ProjectionCreater.pctipo_pago, null, null, tipo_pago.DEFAULT_ORDEN));
            }
            else
            {
                if(app.isOnline(Tipo_pagoEditor.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda/get_producto_by_id/" + ID, "tipo_pago");
                    } catch (JSONException e) {
                        mylist = new ArrayList<HashMap<String, String>>();
                        Log.e("json", " array list" + e);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
                }
            }
             return mylist;
        }
     }
    private class sincTaskcargaspinners extends AsyncTask<String, Void, HashMap<String, ArrayList<HashMap<String, String>>>> 
    {      
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Tipo_pagoEditor.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(HashMap<String, ArrayList<HashMap<String, String>>> result) {
            if(result != null) {
                Log.e(TAG,  "" + result.size());
                
            }else {
                Log.e("categoria task", "onpost execute result null");
            }
            //m_ProgressDialog.dismiss();
         }
        @Override
        protected HashMap<String, ArrayList<HashMap<String, String>>> doInBackground(String... params) {
            Log.e("thread end", " thread end");
            app = AppMy.getinstance();
            arraylist = new HashMap<String, ArrayList<HashMap<String, String>>>();
            if(!app.isExternal()){
                
            }
            else
            {
                if(app.isOnline(Tipo_pagoEditor.this))
                {
                    try {
                        arraylist.put("mylistsubcategoria", WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/androidtienda//getsubcategoriasdroid", "subcategoriaspinner"));
                    } catch (JSONException e) {
                        arraylist.put("mylistsubcategoria", new ArrayList<HashMap<String, String>>());
                        Log.e("json", " array list" + e);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No hay conexión a internet", Toast.LENGTH_SHORT).show();
                }
            }
             return arraylist;
        }
    }
    private void muestraeditor() 
    {
        Log.e("json", " result.size() " + mylist.size() + " " + mylist.toString());
        mid_tipo_pago.setTextKeepState(mylist.get(mylist.size()-1).get(tipo_pago.id_tipo_pago));
        mnombre_tipo_pago.setTextKeepState(mylist.get(mylist.size()-1).get(tipo_pago.nombre_tipo_pago));
        mcomision_tipo_pago.setTextKeepState(mylist.get(mylist.size()-1).get(tipo_pago.comision_tipo_pago));
        
        
    }
    public void asignarCamposvariableCorta()
    {        
        // asigno textbox a variable corta
        mid_tipo_pago = (EditText) findViewById(R.id.etid_tipo_pago);
        mnombre_tipo_pago = (EditText) findViewById(R.id.etnombre_tipo_pago);
        mcomision_tipo_pago = (EditText) findViewById(R.id.etcomision_tipo_pago);
        
        
    }
    
    public void limpiarPantalla()
    {
        Log.e("limpiapantalla", "limpio___________________");
        mid_tipo_pago.setText("");
        mnombre_tipo_pago.setText("");
        mcomision_tipo_pago.setText("");
        
    }

    private void addTipo_pago() {
        Log.e("add", "add Tipo_pago");
        map.put(tipo_pago.id_tipo_pago, mid_tipo_pago.getText().toString());
        map.put(tipo_pago.nombre_tipo_pago, mnombre_tipo_pago.getText().toString());
        map.put(tipo_pago.comision_tipo_pago, mcomision_tipo_pago.getText().toString());
        
        

        Log.e("if (mState", "mState" + mState);
        new sincTask().execute();
    }

    private void delTipo_pago() {
        //BORRA PROD POR ID
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onresume.............");
  }

    @Override
    protected void onPause() {
        Log.e(TAG, "pause.............");
        super.onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Log.e("onCreateOptionsMenu", "menuoptions.............");

        // Build the menus that are shown when editing.
        Log.e("estado mennu ", "mState " + mState);
        if (mState == STATE_EDIT) {
            menu.add(0, ADD_ID, 0, R.string.menu_update)
                    .setShortcut('0', 'r')
                    .setIcon(android.R.drawable.ic_menu_save);
            menu.add(0, DELETE_ID, 0, R.string.menu_delete)
                    .setShortcut('1', 'd')
                    .setIcon(android.R.drawable.ic_menu_delete);
        } else {
            menu.add(0, ADD_ID, 0, R.string.menu_insert)
            .setShortcut('0', 'r')
            .setIcon(android.R.drawable.ic_menu_save);
            menu.add(0, DISCARD_ID, 0, R.string.menu_discard)
                    .setShortcut('0', 'd')
                    .setIcon(android.R.drawable.ic_menu_delete);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e(TAG, "itemselected.............");
        // Handle all of the possible menu actions.
        switch (item.getItemId()) {
        case DELETE_ID:
            delTipo_pago();
            finish();
            break;
        case EDIT_ID:
            addTipo_pago();
            break;
        case ADD_ID:
            addTipo_pago();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}