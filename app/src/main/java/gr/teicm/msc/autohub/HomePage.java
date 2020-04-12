package gr.teicm.msc.autohub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.view.MenuInflater;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    private EditText textBrand;
    private EditText textCar;
    private Spinner spinnerCarType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        textBrand = (EditText) findViewById(R.id.editTextBrand);
        textCar = (EditText) findViewById(R.id.editTextCar);
        spinnerCarType = (Spinner) findViewById(R.id.action_bar_spinnerCarType);
        Button buttonSearch = (Button) findViewById(R.id.buttonSearch);

        ArrayAdapter<CharSequence> cartypeAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.car_types,
                android.R.layout.simple_spinner_item
        );
        cartypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCarType.setAdapter(cartypeAdapter);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // Code will run on Button Click
                //
                String brand = textBrand.getText().toString();
                String car = textCar.getText().toString();
                String car_type = spinnerCarType.getSelectedItem().toString();
                String message = String.format("Brand: %s\nCar: %s\nCar Type: %s", brand, car, car_type);
                Intent intent = new Intent(HomePage.this, CarList.class);
                startActivity(intent);
            }
        });
    }
};