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

public class PutExtrasActivity extends AppCompatActivity {

    //TODO 1: Deklarasi
    //Deklarasi View
    EditText etNamaLengkap, etNIS, etAlamat, etAsalSekolah;
    RadioGroup rgJenKel;
    RadioButton rbAkhi, rbUkhti;
    Button btKirimData;
    CheckBox cbFootball, cbML, cbCoding;
    CoordinatorLayout crlayoutView;
    AlertDialog.Builder builder;

    //Buat Public Variable Global
    String NamaLengkap, NIS, AsalSekolah, Alamat, getJenisKelamin, getPilihHoby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_extras);

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
            methodValidasiRadioButton();
            methodAmbilDataCheckbox();

            NamaLengkap = etNamaLengkap.getText().toString();
            NIS = etNIS.getText().toString();
            AsalSekolah = etAsalSekolah.getText().toString();
            Alamat = etAlamat.getText().toString();

            builder
                    .setTitle("Inputan User")
                    .setMessage("Nama Lengkap : " + NamaLengkap + "\n" +
                            "NIS : " + NIS + "\n" +
                            "Asal Sekolah : " + AsalSekolah + "\n" +
                            "Alamat : " + Alamat + "\n" +
                            "Jenis Kelamin : " + getJenisKelamin + "\n" +
                            "Hobynya : " + getPilihHoby)

                    .setPositiveButton("Kirim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            transferData(NamaLengkap, NIS, AsalSekolah, Alamat, getJenisKelamin, getPilihHoby);
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
    public void transferData(String namaLengkap, String nIS, String asalSekolah, String alamatSiswa, String jenisKelamin, String hobySiswa) {
        //Proses Paketing
        Bundle paketData = new Bundle();
        paketData.putString("NAMA_SISWA", namaLengkap);
        paketData.putString("NIS_SISWA", nIS);
        paketData.putString("ASALSEKOLAH_SISWA", asalSekolah);
        paketData.putString("ALAMATSEKOLAH_SISWA", alamatSiswa);
        paketData.putString("JK_SISWA", jenisKelamin);
        paketData.putString("HOBY_SISWA", hobySiswa);

        //Proses Pengirimannya
        Intent prosesKirim = new Intent(PutExtrasActivity.this, SecondActivity.class);
        prosesKirim.putExtras(paketData);
        startActivity(prosesKirim);
        return;
    }

    public void methodValidasiRadioButton() {
        int id = rgJenKel.getCheckedRadioButtonId();
        switch (id){
            case R.id.rb_laki :
                getJenisKelamin = "" + ((RadioButton)findViewById(id)).getText();
                break;
            case R.id.rb_perempuan :
                getJenisKelamin = "" + ((RadioButton)findViewById(id)).getText();
                break;
        }
    }

    public void methodAmbilDataCheckbox() {
        String tampungPilihHoby;
        tampungPilihHoby = "";

        if (cbFootball.isChecked() == false && cbML.isChecked() == false && cbCoding.isChecked() == false) {
            tampungPilihHoby += "Anda Tidak Memilih Hoby!";
        }
        if(cbFootball.isChecked()){
            tampungPilihHoby += "Football ";
        }
        if(cbML.isChecked()){
            tampungPilihHoby += "Game ML (Mobile Legend) ";
        }
        if(cbCoding.isChecked()){
            tampungPilihHoby += "Ngoding.";
        }
        getPilihHoby = tampungPilihHoby;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MenuActivity.class));
        finish();
    }
}
