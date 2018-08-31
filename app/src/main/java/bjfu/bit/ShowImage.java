package bjfu.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowImage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        ImageView picture1 = (ImageView) findViewById(R.id.show_image1);
        picture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent intent = new Intent(ShowImage.this,Test.class);
                startActivity(intent);
            }
        });
        ImageView picture2 = (ImageView) findViewById(R.id.show_image2);
        picture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowImage.this,Test.class);
                startActivity(intent);
            }
        });
        ImageView picture3 = (ImageView) findViewById(R.id.show_image3);
        picture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowImage.this,Test.class);
                startActivity(intent);
            }
        });
        ImageView picture4 = (ImageView) findViewById(R.id.show_image4);
        picture4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowImage.this,Test.class);
                startActivity(intent);
            }
        });
    }
}
