package bjfu.bit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//我的设想是，先出现一张用来测试的图片，下面提示让要）次你看图后语音说出指向，然后点击下一步按钮后，开始进行语音识别，然后重复n（按算法需
public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ImageView picture = (ImageView) findViewById(R.id.test_image);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Test.this,ShowImage.class);
                startActivity(intent);
            }
        });
    }




}
