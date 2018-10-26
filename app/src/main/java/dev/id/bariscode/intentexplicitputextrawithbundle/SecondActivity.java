package dev.id.bariscode.intentexplicitputextrawithbundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.tvNamaLengkap)
    TextView tvNamaLengkap;
    @BindView(R.id.tvNIS)
    TextView tvNIS;
    @BindView(R.id.tvAsalSekolah)
    TextView tvAsalSekolah;
    @BindView(R.id.tvAlamat)
    TextView tvAlamat;
    @BindView(R.id.tvJenisKelamin)
    TextView tvJenisKelamin;
    @BindView(R.id.tvHoby)
    TextView tvHoby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);


        //Intent getData = getIntent();
        //String getNamaSiswa = getData.getStringExtra("NAMA_SISWA");

        Bundle ambilData = getIntent().getExtras();

        String getNamaLengkap = ambilData.getString("NAMA_SISWA");
        String getNIS = ambilData.getString("NIS_SISWA");
        String getAsalSekolah= ambilData.getString("ASALSEKOLAH_SISWA");
        String getAlamat = ambilData.getString("ALAMATSEKOLAH_SISWA");
        String getJenisKelamin = ambilData.getString("JK_SISWA");
        String getHoby = ambilData.getString("HOBY_SISWA");

        tvNamaLengkap.setText(getNamaLengkap);
        tvNIS.setText(getNIS);
        tvAsalSekolah.setText(getAsalSekolah);
        tvAlamat.setText(getAlamat);
        tvJenisKelamin.setText(getJenisKelamin);
        tvHoby.setText(getHoby);
    }
}
