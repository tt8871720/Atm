package com.two.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    private EditText edgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }
    public void next (View view){
        edgender = findViewById(R.id.ed_gender);
        String gender = edgender.getText().toString();
        getSharedPreferences("user" , MODE_PRIVATE)
                .edit()
                .putString("GENDER" , gender)
                .apply();
        Intent main = new Intent(this , MainActivity.class);
        setResult(RESULT_OK);
        // single clear 刪除面的Activity
        // single top 回到指定的Activity而非重新建立一個刪除前面的
        main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(main);
    }
}
