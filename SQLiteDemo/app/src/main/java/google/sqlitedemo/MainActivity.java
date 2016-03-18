package google.sqlitedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private StudentUtility studentUtility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button insertButton = (Button) findViewById(R.id.insertButton);
        Button readButton = (Button) findViewById(R.id.readButton);
        Button updateButton = (Button) findViewById(R.id.updateButton);
        Button deleteButton = (Button) findViewById(R.id.deleteButton);

        insertButton.setOnClickListener(this);
        readButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

        studentUtility = new StudentUtility(this);
        studentUtility.open();

    }

    @Override
    public void onClick(View v) {
        Bundle b = this.getIntent().getExtras();
        String bundleValue = b.getString("a") + b.getInt("b");
        Toast.makeText(this,bundleValue,Toast.LENGTH_LONG).show();
        switch (v.getId()) {
            case R.id.insertButton:
                insertRecords();
                break;
            case R.id.readButton:
                readRecords();
                break;
            case R.id.updateButton:
                updateRecords();
                break;
            case R.id.deleteButton:
                deleteRecords();
                break;
        }
    }

    private void insertRecords() {
        studentUtility.addStudent
                (new Student("Mike", "27"));
        studentUtility.addStudent
                (new Student("Ram", "29"));
        studentUtility.addStudent
                (new Student("Shyam", "28"));
    }

    private void readRecords() {
        studentUtility.listStudents();
    }

    private void updateRecords() {
        studentUtility.updateStudent(new Student("Ram", "31"));
    }

    private void deleteRecords() {
        studentUtility.deleteStudent(new Student("Mike", null));
    }

    @Override
    protected void onDestroy() {
        studentUtility.close();
        super.onDestroy();
    }
}
