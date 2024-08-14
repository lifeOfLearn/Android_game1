package owner.kwcheng.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    private TextView textViewResult;

    private ImageButton imageButtonScissor, imageButtonRock, imageButtonPaper;

    private int[] Data, DataImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Data = new int[] {R.string.draw, R.string.win, R.string.lose};
        DataImg = new int[]{R.drawable.scissor, R.drawable.rock, R.drawable.paper};

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);

        textViewResult = (TextView) findViewById(R.id.textView_result);
        textViewResult.setText("");

        imageButtonScissor = (ImageButton) findViewById(R.id.imageButton_scissor);
        imageButtonRock = (ImageButton)  findViewById(R.id.imageButton_rock);
        imageButtonPaper = (ImageButton) findViewById(R.id.imageButton_paper);

        imageButtonScissor.setOnClickListener(e -> check(0));
        imageButtonRock.setOnClickListener(e -> check(1));
        imageButtonPaper.setOnClickListener(e -> check(2));
    }

    void check(int num) {
        int cpu = (int) (Math.random() * 3);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(DataImg[cpu]);
        try {
            textViewResult.setText(Data[num - cpu]);
        } catch (ArrayIndexOutOfBoundsException e) {
            textViewResult.setText(Data[num - cpu + 3]);
        }
    }
}