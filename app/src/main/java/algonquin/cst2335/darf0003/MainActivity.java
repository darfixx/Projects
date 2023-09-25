package algonquin.cst2335.darf0003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.mytextview);
        Button b = findViewById(R.id.mybutton);
        EditText et = findViewById(R.id.mytext);

        b.setOnClickListener( v-> {

                tv.setText("you clicked the button");
                b.setText("you clicked the button");
                et.setText("you clicked the button");
        });

    }
}