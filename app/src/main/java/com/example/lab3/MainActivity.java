package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Kliknieto przycisk FAB",Toast.LENGTH_SHORT).show();
                Intent intencja=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja,REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id)
        {
            case(R.id.action_settings):
                Toast.makeText(getApplicationContext(), Integer.toString(R.id.action_settings),Toast.LENGTH_SHORT).show();
                break;
            case(R.id.action_settings2):
                Toast.makeText(getApplicationContext(),Integer.toString(R.id.action_settings2),Toast.LENGTH_SHORT).show();
                break;
            case(R.id.action_settings3):
                Toast.makeText(getApplicationContext(),Integer.toString(R.id.action_settings3),Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void kliknij(View view)
    {
        Toast.makeText(getApplicationContext(),"Kliknieto przycisk button",Toast.LENGTH_SHORT).show();
        Intent intencja=new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        Bundle bundle=data.getExtras();
        Bitmap imageBitmap=(Bitmap) bundle.get("data");
        ConstraintLayout lay=(ConstraintLayout)findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(),imageBitmap));

    }

    public void losowanko(View view)
    {
        Random generator= new Random();
        Button btn=(Button) findViewById(R.id.button1);
        Drawable drawable = null;
        switch(generator.nextInt()%4)
        {
            case 0:
                drawable=getResources().getDrawable(R.drawable.icon1,getTheme());
                break;
            case 1:
                drawable=getResources().getDrawable(R.drawable.icon2,getTheme());
                break;
            case 2:
                drawable=getResources().getDrawable(R.drawable.icon3,getTheme());
                break;
            case 3:
                drawable=getResources().getDrawable(R.drawable.icon4,getTheme());
                break;
        }
        btn.setBackground(drawable);
    }
}
