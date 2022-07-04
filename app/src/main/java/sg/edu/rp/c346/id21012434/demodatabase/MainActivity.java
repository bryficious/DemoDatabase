package sg.edu.rp.c346.id21012434.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnGetTasks;
    EditText editText1, editText2;
    ListView lvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        lvTasks=findViewById(R.id.lvTasks);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newestTask=editText1.getText().toString();
                String newestDate = editText2.getText().toString();
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask(newestTask , newestDate);
                db.close();
            }
        });

                btnGetTasks.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create the DBHelper object, passing in the
                        // activity's Context
                        DBHelper db = new DBHelper(MainActivity.this);

                        // Insert a task
                        ArrayList<Task> al = db.getTasks();
                        db.close();

                        ArrayAdapter aa = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,al);
                        lvTasks.setAdapter(aa);
            }
        });
    }
}








