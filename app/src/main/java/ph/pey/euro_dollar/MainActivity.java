package ph.pey.euro_dollar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final double TAUX = 1.2282;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText query = findViewById(R.id.query);
        Button convert = findViewById(R.id.convert);

        final RadioButton euro = findViewById(R.id.in_euros);
        final RadioButton dollar = findViewById(R.id.in_dollar);

        final ResultAdapter adapter = new ResultAdapter(this.getApplicationContext());

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = Double.valueOf(query.getText().toString());
                String text = "";
                if(euro.isChecked()) {
                    text = num + " euros = " + String.valueOf(num / TAUX) + " dollars";
                } else if(dollar.isChecked()) {
                    text = num + " dollars = " + String.valueOf(num * TAUX) + " euros";
                }

                adapter.addResult(text);
            }
        });
    }
}
