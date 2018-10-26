package dev.id.bariscode.intentexplicitputextrawithbundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PutExtraActivity extends AppCompatActivity {

    //TODO 1: Deklarasi
    //Deklarasi View
    EditText etNamaLengkap;
    Button btKirimData;
    CoordinatorLayout crlayoutView;
    AlertDialog.Builder builder;

    //Buat Public Variable Global
    String NamaLengkap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_extra);

        //TODO 2: Inisialisasi
        //Inisialisasi View
        etNamaLengkap = (EditText)findViewById(R.id.txtNama);

        btKirimData = (Button)findViewById(R.id.btnKirimData);

        crlayoutView = (CoordinatorLayout)findViewById(R.id.clView);

        builder = new AlertDialog.Builder(this);

        //TODO 3: Buat Action Button
        //Action Button
        btKirimData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 5: Panggil Method Validator EditText
                validasiEditText();
            }
        });
    }

    //TODO 4: Membuat Proses Validasi untuk EditText
    public void validasiEditText() {
        if(etNamaLengkap.getText().toString().length()==0){
            etNamaLengkap.setError("Isi Nama Lengkap Dulu Bro!!");
            etNamaLengkap.requestFocus();
        } else {
            //Snackbar popUp = Snackbar.make(crlayoutView, "EditText Sudah Terisi Seluruhnya", Snackbar.LENGTH_LONG);
            //popUp.show();

            NamaLengkap = etNamaLengkap.getText().toString();

            builder
                    .setTitle("Inputan User")
                    .setMessage("Nama Lengkap : " + NamaLengkap)
                    .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            transferData(NamaLengkap);
                        }
                    })

                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    //TODO 5: Membuat Method Action Put Extra (Mengirim 1 Data) Ke Activity Lain
    public void transferData(String namaLengkap) {
        Intent prosesKirim = new Intent(PutExtraActivity.this, SecondActivity.class);
        prosesKirim.putExtra("NAMA_SISWA", namaLengkap);
        startActivity(prosesKirim);
        return;
    }

    public void kosongkanInputan(View view) {
        etNamaLengkap.setText("");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PutExtraActivity.this, MenuActivity.class));
        finish();
    }


}
