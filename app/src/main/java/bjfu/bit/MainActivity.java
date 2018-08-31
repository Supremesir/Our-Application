package bjfu.bit;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button begin = (Button) findViewById(R.id.main_button_test);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Test.class);
                startActivity(intent);
            }
        });

        Button history = (Button) findViewById(R.id.main_button_history);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,History.class);
                startActivity(intent);
            }
        });

        Button tip = (Button) findViewById(R.id.main_tip);
        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new QMUIDialog.MessageDialogBuilder(MainActivity.this)
                        .setTitle("标题")
                        .setMessage("Lorem ipsum dolor sit amet, " +
                                "" +
                                "consectetur adipisicing elit. Corporis optio libero et eligendi. Vel possimus deserunt voluptatibus recusandae reprehenderit sunt modi fugiat distinctio, natus repudiandae laudantium ad in sequi. Quam.")
                        .addAction("取消", new QMUIDialogAction.ActionListener() {
                            @Override
                            public void onClick(QMUIDialog dialog, int index) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }
}
