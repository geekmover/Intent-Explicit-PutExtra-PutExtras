package dev.id.bariscode.intentexplicitputextrawithbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }

    public void aksi2PutExtra(View view) {

        Intent toPutExtra = new Intent(MenuActivity.this, PutExtraActivity.class);
        startActivity(toPutExtra);
        finish();

    }

    public void aksi2PutExtras(View view) {

        Intent toPutExtras = new Intent(MenuActivity.this, PutExtrasActivity.class);
        startActivity(toPutExtras);
        finish();

    }
}
