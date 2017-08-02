package com.example.sakshi.imagesavinginexternalstorage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {
    //declaring button imageview and fileoutputstream
    Button button;
    ImageView image;
    FileOutputStream fileOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //associating button and imageview
        button=(Button)findViewById(R.id.button);
        image=(ImageView)findViewById(R.id.image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //setting demo image to bitmap
                Bitmap bitmap = BitmapFactory.decodeResource( getResources(), R.drawable.demo);
                //setting path for external storage
                String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                //creating file with name demo and the above mentioned path
                File file = new File(extStorageDirectory+"/Demo.PNG");

                try{
                    //outputstream
                    fileOutputStream = new FileOutputStream(file);
                    //compressing image bitmap
                    bitmap.compress(Bitmap.CompressFormat.JPEG,60,fileOutputStream);
                    fileOutputStream.flush();
                    //closing fileoutputstream
                    fileOutputStream.close();
                    Toast.makeText(MainActivity.this, "Image Saved Successfully!", Toast.LENGTH_SHORT).show();

                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
