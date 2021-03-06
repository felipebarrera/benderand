package cl.webinc.benderand.crud;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import cl.webinc.benderand.R;
import cl.webinc.benderand.AppMy;
import cl.webinc.benderand.provider.Base.tipo_pago;
import cl.webinc.benderand.sync.WebConector;
import cl.webinc.benderand.util.CursortoArrayhash;
import cl.webinc.benderand.util.ProjectionCreater;

public class Tipo_pagoList extends ListActivity {
    private static final String TAG = "tipo_pagolist";

    // Menu item ids
    public static final int MENU_ITEM_DELETE = Menu.FIRST;
    public static final int MENU_ITEM_INSERT = Menu.FIRST + 1;
    protected ArrayList<HashMap<String, String>> mylist;
    private static AppMy app = AppMy.getinstance();
    private HashMap<String, String> extra = new HashMap<String, String>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setDefaultKeyMode(DEFAULT_KEYS_SHORTCUT);
        registerForContextMenu(getListView());
        
        new sincTask().execute();
        Log.e("tipo_pagolist", "onCreate");
            
        
        final ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                @SuppressWarnings("unchecked")
                HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);
                Intent intent = new Intent(Tipo_pagoList.this, Tipo_pagoEditor.class);
                intent.putExtra("id", o.get("_id"));
                extra.put("id", o.get("_id"));
                app.setExtra(extra);
                Log.e(TAG, "" + app.getExtra().get("_id"));
                startActivityForResult(intent, 1);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult", "" + requestCode);
        new sincTask().execute();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, MENU_ITEM_INSERT, 0, R.string.menu_insert)
                .setShortcut('3', 'a')
                .setIcon(android.R.drawable.ic_menu_add);
        Intent intent = new Intent(null, getIntent().getData());
        intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
        menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
                new ComponentName(this, Tipo_pagoList.class), null, intent, 0, null);

        return true;
    }
    private class sincTask extends AsyncTask<String, Void, ArrayList<HashMap<String, String>>>  
    {
        ProgressDialog dialog;
        
        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(Tipo_pagoList.this);
            dialog.setTitle(R.string.lblObteniendodatos);
            dialog.setMessage(String.valueOf(R.string.lblPorfavorespere));
            dialog.setIndeterminate(true);
            dialog.show();
        }
        @Override
         protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
            if(result != null) {
                ListAdapter adapter = new SimpleAdapter(Tipo_pagoList.this, result, R.layout.listitem,
                        new String[] { tipo_pago.id_tipo_pago, tipo_pago.id_tipo_pago }, new int[] { android.R.id.text1, android.R.id.text2 });
                setListAdapter(adapter);
                }else {
                    Toast.makeText(getApplicationContext(), "Fallo la sincronizacion", Toast.LENGTH_SHORT).show();
                    Log.e("sinctask tipo_pagolista", " Fallo la sincronizacion");
                }
                dialog.dismiss();
         }
        @Override
        protected ArrayList<HashMap<String, String>> doInBackground(
                String... params) {
            Log.e("thread end", " thread end");
            if(!app.isExternal()){
                ProjectionCreater.getinstance();
                Cursor cursor = getContentResolver().query(tipo_pago.CONTENT_URI, ProjectionCreater.pctipo_pago, null, null, tipo_pago.DEFAULT_ORDEN);
                CursortoArrayhash ctah = CursortoArrayhash.getinstance();
                mylist = ctah.ahTipo_pago(cursor);
            }
            else
            {
                if(app.isOnline(Tipo_pagoList.this))
                {
                    try {
                        mylist = WebConector.getJSONfromURL("http://"+ app.getUrl() +"/index.php/sincronize/productocompleto/get_productodroid/" + app.getCarneEmpresa().getId_empresa(), "productocompleto");
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_ITEM_INSERT:
            Intent i = new Intent(this, Tipo_pagoEditor.class);
            extra.put("id", "0");
            app.setExtra(extra);
            startActivityForResult(i,1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info;
        try {
             info = (AdapterView.AdapterContextMenuInfo) menuInfo;
             Log.e(TAG, "bad menuInfo" + info.position);
        } catch (ClassCastException e) {
            Log.e(TAG, "bad menuInfo", e);
            return;
        }


        // Setup the menu header
        menu.setHeaderTitle("Opciones");

        // Add a menu item to delete the note
        menu.add(0, MENU_ITEM_DELETE, 0, R.string.menu_delete);
    }
        
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info;
        try {
             info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
             Log.e(TAG, "bad menuInfo" + info.position);
        } catch (ClassCastException e) {
            Log.e(TAG, "bad menuInfo", e);
            return false;
        }
        switch (item.getItemId()) {
            case MENU_ITEM_DELETE: {
                return true;
            }
        }
        return false;
    }    
}
