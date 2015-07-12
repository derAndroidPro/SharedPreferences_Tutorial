package de.derandroidpro.sharedprefstutorial;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button btn_save,btn_read,btn_delete;
    EditText et1;
    TextView tv1;

    String eingabetxt;
    String ausgelesen;
    boolean testbool = true;
    boolean ausgelsenbool;

    final String KEY1 = "key1";

    SharedPreferences prefs;
    SharedPreferences.Editor prefseditor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_save = (Button) findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);
        btn_read = (Button) findViewById(R.id.btn_read);
        btn_read.setOnClickListener(this);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(this);


        et1 = (EditText) findViewById(R.id.editText);
        tv1 = (TextView) findViewById(R.id.textView);

        prefs = this.getSharedPreferences("prefsdatei1" , MODE_PRIVATE);
        prefseditor = prefs.edit();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case  R.id.btn_save:{

                if(et1.getText().length() >0){
                eingabetxt = et1.getText().toString();
                    prefseditor.putString(KEY1,eingabetxt);
                    prefseditor.putBoolean("key2", testbool);
                    prefseditor.commit();



                } else {
                    Toast.makeText(getApplicationContext(),"Kein Text",Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case  R.id.btn_read:{

             ausgelesen=  prefs.getString(KEY1,"KeinText gespeichert");
                ausgelsenbool = prefs.getBoolean("key2",false);
                Toast.makeText(getApplicationContext(),Boolean.toString(ausgelsenbool),Toast.LENGTH_SHORT).show();
                tv1.setText(ausgelesen);



                break;
            }
            case  R.id.btn_delete:{


                prefseditor.remove(KEY1);
                prefseditor.remove("key2");
                prefseditor.commit();
                tv1.setText(null);

                break;
            }


        }



    }
}
