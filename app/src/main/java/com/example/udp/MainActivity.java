package com.example.udp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText txtHoras, txtDias, txtVHoras, txtDescuento, txtSueldoBase;
    private CheckBox chbxPago, chbxDcto;
    private RadioGroup rgRedondeo;
    private RadioButton rbRedondeo, rbNoRedondeo;
    private Button btnLimpiar, btnCalcular;
    private TextView lbl_pago, lbl_dcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtHoras = (EditText)findViewById(R.id.txtHoras);
        txtDias = (EditText)findViewById(R.id.txtDias);
        chbxPago = (CheckBox)findViewById(R.id.chbxPago);
        chbxDcto = (CheckBox)findViewById(R.id.chbxDcto);
        rgRedondeo = (RadioGroup)findViewById(R.id.rgRedondeo);
        rbNoRedondeo = (RadioButton)findViewById(R.id.rbNoRedondeo);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        lbl_dcto = (TextView)findViewById(R.id.lbl_dcto);
        lbl_pago = (TextView)findViewById(R.id.lbl_pago);
        txtVHoras = findViewById(R.id.txtVHoras);
        txtDescuento = findViewById(R.id.txtDescuento);
        txtSueldoBase = findViewById(R.id.txtSueldoBase);

    }

    public void calcular (View view){

        int horas = Integer.parseInt(txtHoras.getText().toString());
        int dias = Integer.parseInt(txtDias.getText().toString());
        int monto_hora = Integer.parseInt(txtVHoras.getText().toString());
        double descuento = Integer.parseInt(txtDescuento.getText().toString());
        double sueldo_base = Integer.parseInt(txtSueldoBase.getText().toString());
        double pago = sueldo_base + (horas*dias*monto_hora);
        double dtotal =(pago*descuento/100);


        if(chbxPago.isChecked() == true){
            lbl_pago.setText(String.valueOf(pago));
        }
        if(chbxDcto.isChecked() == true && pago >sueldo_base){

            lbl_dcto.setText(String.valueOf(dtotal));
        }
        if (rgRedondeo.getCheckedRadioButtonId() == R.id.rbRedondeo) {
            int pago_redondeo = (int)Math.round(pago);
            lbl_pago.setText(String.valueOf(pago_redondeo));
            int dcto_redondeo = (int)Math.round((descuento));
            lbl_dcto.setText(String.valueOf(dcto_redondeo));
        }

    }

    public void limpiar(View view){

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtDias.getText().clear();
                txtHoras.getText().clear();
                txtDescuento.getText().clear();
                txtSueldoBase.getText().clear();
                txtVHoras.getText().clear();
                rgRedondeo.clearCheck();
                chbxDcto.toggle();
                chbxPago.toggle();
                lbl_dcto.setText("");
                lbl_pago.setText("");
            }
        });


    }
}
