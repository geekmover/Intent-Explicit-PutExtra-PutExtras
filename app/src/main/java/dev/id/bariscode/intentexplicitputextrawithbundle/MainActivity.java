package dev.id.bariscode.intentexplicitputextrawithbundle;

import android.content.DialogInterface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //TODO 1: Deklarasi
    //Deklarasi View
    EditText etNamaLengkap, etNIS, etAlamat, etAsalSekolah;
    RadioGroup rgJenKel;
    RadioButton rbAkhi, rbUkhti;
    Button btKirimData;
    CheckBox cbFootball, cbML, cbCoding;
    CoordinatorLayout crlayoutView;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 2: Inisialisasi
        //Inisialisasi View
        etNamaLengkap = (EditText)findViewById(R.id.txtNama);
        etNIS = (EditText)findViewById(R.id.txtNIS);
        etAsalSekolah = (EditText)findViewById(R.id.txtAsalSekolah);
        etAlamat = (EditText)findViewById(R.id.txtAlamat);

        rgJenKel = (RadioGroup)findViewById(R.id.rg_jk);
        rbAkhi = (RadioButton)findViewById(R.id.rb_laki);
        rbUkhti = (RadioButton)findViewById(R.id.rb_perempuan);

        cbFootball = (CheckBox)findViewById(R.id.cbHoby1);
        cbML = (CheckBox)findViewById(R.id.cbHoby2);
        cbCoding = (CheckBox)findViewById(R.id.cbHoby3);

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
        }else if(etNIS.getText().toString().length()==0){
            etNIS.setError("Isi NIS Dulu Bro!!");
            etNIS.requestFocus();
        }else if(etAsalSekolah.getText().toString().length()==0){
            etAsalSekolah.setError("Isi Asal Sekolah Dulu Bro!!");
            etAsalSekolah.requestFocus();
        }else if(etAlamat.getText().toString().length()==0){
            etAlamat.setError("Isi Alamat Dulu Bro!!");
            etAlamat.requestFocus();
        }else {
            //Snackbar popUp = Snackbar.make(crlayoutView, "EditText Sudah Terisi Seluruhnya", Snackbar.LENGTH_LONG);
            //popUp.show();

            String NamaLengkap = etNamaLengkap.getText().toString();
            String NIS = etNIS.getText().toString();
            String AsalSekolah = etAsalSekolah.getText().toString();
            String Alamat = etAlamat.getText().toString();

            builder
                    .setTitle("Inputan User")
                    .setMessage("Nama Lengkap : " + NamaLengkap + "\n" +
                            "NIS : " + NIS + "\n" +
                            "Asal Sekolah : " + AsalSekolah + "\n" +
                            "Alamat : " + Alamat)

                    .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

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
}
