package com.hydra.joker.mylife;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btn = (Button)findViewById(R.id.btn_toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("www.baidu.com"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.add_item:
               Toast.makeText(FirstActivity.this, "添加", Toast.LENGTH_SHORT).show();
               break;
           case R.id.delete_item:
               Toast.makeText(FirstActivity.this, "删除", Toast.LENGTH_SHORT).show();
               break;
           case R.id.back_item:
               Toast.makeText(FirstActivity.this, "返回", Toast.LENGTH_SHORT).show();
               finish();
               default:
       }
        return true;
    }
}
