package algonquin.cst2335.darf0003.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import algonquin.cst2335.darf0003.data.MainViewModel;
import algonquin.cst2335.darf0003.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

     ActivityMainBinding variableBinding;
     MainViewModel vModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vModel = new ViewModelProvider(this).get(MainViewModel.class);
        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());
        TextView tv = variableBinding.mytextview;
        Button b = variableBinding.mybutton;
        EditText et = variableBinding.mytext;

        variableBinding.thecheckbox.setOnCheckedChangeListener(
                ( btn, onOrOff ) -> {
                    vModel.onOrOff.postValue(onOrOff);
                }
        );

        variableBinding.theswitch.setOnCheckedChangeListener(
                ( btn, onOrOff ) -> {
                    vModel.onOrOff.postValue(onOrOff);
                }
        );

        variableBinding.theradiobutton.setOnCheckedChangeListener(
                ( btn, onOrOff ) -> {
                    vModel.onOrOff.postValue(onOrOff);
                }
        );

        variableBinding.theimagebtn.setOnClickListener(
                clk -> {
                        int width = variableBinding.theimagebtn.getWidth();
                        int height = variableBinding.theimagebtn.getHeight();

                        String toastMessage = "The width = " + width + " and height = " + height;

                        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

                    variableBinding.mytextview.setText("You clicked the image !");
                }

        );

        vModel.onOrOff.observe(this, newValue -> {
            variableBinding.thecheckbox.setChecked(newValue);
            variableBinding.theswitch.setChecked(newValue);
            variableBinding.theradiobutton.setChecked(newValue);
        });

        et.setText(vModel.userString.getValue());

        vModel.userString.observe(this, (s) -> {
            tv.setText("Your text is now: " + s);
            b.setText("Your text is now: " + s);
            et.setText("Your text is now: " + s);
        });

        b.setOnClickListener( v-> {

                vModel.userString.postValue(et.getText().toString());

        });

    }

}