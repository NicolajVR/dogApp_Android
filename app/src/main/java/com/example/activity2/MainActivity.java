package com.example.activity2;

//Imports
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


//adds an Event Listener for the buttons.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Store all buttons in an array for code optimization
    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.dogBtn,
            R.id.catBtn,
            R.id.owlBtn,
            R.id.deerBtn,
            R.id.Act3btn
    };

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<Button>(BUTTON_IDS.length);

        // Here is a dynamic way to findviewbyid and set onclicklisterner on all buttons
        for(int id : BUTTON_IDS){
            Button button = findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == AppConstants.RESULT_CODE_SECOUND) {
                            Intent intent = result.getData();
                           // txt_msg.setText(intent.getStringExtra("msg"));
                            Toast.makeText(MainActivity.this, intent.getStringExtra("msg"), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if(result.getResultCode() == AppConstants.RESULT_CODE_THIRD) {
                            //txt_msg.setText(result.getData().getStringExtra("msg"));
                            //Toast.makeText(MainActivity.this, "*******", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });
    }

    //We use one Onclick method for all buttons
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dogBtn:

                Intent intent = new Intent(MainActivity.this, SecoundActivity2.class);
                intent.putExtra("fromMain", "Besked fra main");
                launcher.launch(intent);
                Toast.makeText(this, "Dog button was pressed!", Toast.LENGTH_SHORT).show();

                break;

            case R.id.catBtn:

                Toast.makeText(this, "Cat button was pressed!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.owlBtn:

                Toast.makeText(this, "Owl button was pressed!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.deerBtn:

                Toast.makeText(this, "Deer button was pressed!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Act3btn:
                Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
                launcher.launch(intent2);
                Toast.makeText(this, "Went to third act.", Toast.LENGTH_SHORT).show();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
