package thuyhien.layoutanduicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SignUpStep2Activity extends AppCompatActivity {
    TextView txtSalary;
    SeekBar seekBarSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step2);

        txtSalary = (TextView) findViewById(R.id.txtSalary);
        seekBarSalary = (SeekBar) findViewById(R.id.seekBarSalary);

        seekBarSalary.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String result = getResources().getString(R.string.your_salary) + ' ' +
                        progress + getResources().getString(R.string.dollars);
                txtSalary.setText(result);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
