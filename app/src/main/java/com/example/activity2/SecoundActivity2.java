package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

//Spinner
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SecoundActivity2 extends AppCompatActivity implements View.OnClickListener {
    private List<Button> buttons;
    private Intent intent;
    private EditText send_text;


    private static final int[] BUTTON_IDS = {
            R.id.backBtn,
            R.id.sendMSGbtn

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);

        buttons = new ArrayList<>(BUTTON_IDS.length);

        // Here is a dynamic way to findviewbyid and set onclicklisterner on all buttons
        for (int id : BUTTON_IDS) {
            Button button = findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);

            //Dropdown section
            Spinner dogBreeds = findViewById(R.id.dropSpinner_dog);
            send_text = findViewById(R.id.txtTodog);
            // DropDown (Spinner)
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dogBreeds, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            dogBreeds.setAdapter(adapter);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dogBtn:
                intent.putExtra("msg", "Hilsen fra Dog.");
                setResult(AppConstants.RESULT_CODE_SECOUND, intent);
                finish(); //Method in INTENT class for finishing other activities from Main.
                Toast.makeText(this, "Dog button was pressed!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sendMSGbtn:

                //Send msg to third activity.
                String str = send_text.getText().toString();
                Intent intent = new Intent(SecoundActivity2.this, ThirdActivity.class);
                intent.putExtra("message_key", str);

                startActivity(intent);

                Toast.makeText(this, "Message was sent to the dog!", Toast.LENGTH_SHORT).show();
                break;
    /*
            case R.id.owlBtn:

                Toast.makeText(this, "Owl button was pressed!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.deerBtn:

                Toast.makeText(this, "Red Deer button was pressed!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.lionBtn:

                Toast.makeText(this, "Lion button was pressed", Toast.LENGTH_SHORT).show();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
     */
        }
    }
}