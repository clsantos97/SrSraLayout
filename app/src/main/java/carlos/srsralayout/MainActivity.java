package carlos.srsralayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    Button btnEsta;
    Button btnOtra;
    EditText etNombre;
    TextView tvResultado;
    RadioGroup rbSexo;
    RadioButton rbSr;
    RadioButton rbSra;

    //public static final int VOLVER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init elementos de vista
        btnEsta = (Button) findViewById(R.id.btnEsta);
        btnOtra = (Button) findViewById(R.id.btnOtra);
        etNombre = (EditText) findViewById(R.id.etNombre);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
        rbSexo = (RadioGroup) findViewById(R.id.rbSexo);
        rbSr = (RadioButton) findViewById(R.id.rbSr);
        rbSra = (RadioButton) findViewById(R.id.rbSra);

        // init listeners
        btnEsta.setOnClickListener(this);
        btnOtra.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String nombre = etNombre.getText().toString();

        // Validar campo nombre informado
        if (nombre.trim().isEmpty() || nombre == null) {
            Toast toast = Toast.makeText(getApplicationContext(), "Debes rellenar el campo nombre.",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            String mensaje;

            // Definir mensaje
            if (rbSexo.getCheckedRadioButtonId() == rbSr.getId()) {
                mensaje = "Hola Sr " +nombre;
            } else {
                mensaje = "Hola Sra " + nombre;
            }

            // Definir target
            if ((Button) view == btnEsta) { // EN ESTA VENTANA
                tvResultado.setText(mensaje);
            } else { // EN OTRA VENTANA
                tvResultado.setText("");
                Intent intent = new Intent(this, OtraVentana.class);
                intent.putExtra("mensaje", mensaje);
                startActivity(intent);
            }
        }


    }

}
