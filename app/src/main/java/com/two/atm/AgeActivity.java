package com.two.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {

    private EditText edage;
int [] num = {18 , 19 , 20 , 21 , 22 , 23 , 24};
String rainbow[] = null;
    private EditText edage1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        rainbow = getResources().getStringArray(R.array.colorful);
        RecyclerView recyclerview = findViewById(R.id.recycler);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new AgeAdapter());
        edage = findViewById(R.id.ed_age);
    }
    public void next (View view){
       // edage = findViewById(R.id.ed_age);
       int age = Integer.parseInt(edage.getText().toString());
       user.setAge(age);
        Intent gender = new Intent(this , GenderActivity.class);
        startActivity(gender);
    }
    public void back(View view){
        finish();
    }

        class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeViewHolder> {

        //紅字時按Alt + Enter後會出現3個方法
            @NonNull
            @Override
            public AgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                //Inflater把xml變成String                                            Resource                                 使用上方的parent           不要一開始就觸發顯示
                View view = getLayoutInflater().inflate(R.layout.age_onerow , parent , false);
                //回傳資料內容
                return new AgeViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull AgeViewHolder holder, final int position) {
                // 因為setText放int會以為是value+ ""使num[position]變成String
holder.ageText.setText(num[position]+"");
holder.itemView.setBackgroundColor(Color.parseColor(rainbow[position % 6]));
//用itemview可以不用一定要按到數字才會有反應
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Log.d("AgeActivity" , "onClick:" + num[position]);
        edage.setText(num[position] + "");
    }
});
// 19變成紅字
//if(num[position] == 19){
//    holder.ageText.setTextColor(Color.RED);}
            }

            @Override
            public int getItemCount() {
                //回傳資料數
                return num.length;
            }

            class AgeViewHolder extends RecyclerView.ViewHolder{
                TextView ageText;
                public AgeViewHolder(View itemView) {
                    super(itemView);
                    ageText = itemView.findViewById(R.id.tv_age);
                }
            }
    }
}
