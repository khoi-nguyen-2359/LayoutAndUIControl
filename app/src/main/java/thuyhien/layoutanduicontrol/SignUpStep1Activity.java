package thuyhien.layoutanduicontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class SignUpStep1Activity extends AppCompatActivity {
    @BindView(R.id.editFirstName)
    EditText editFirstName;

    @BindView(R.id.editLastName)
    EditText editLastName;

    @BindView(R.id.editEmail)
    EditText editEmail;

    @BindView(R.id.editPhone)
    EditText editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_step1);

        ButterKnife.bind(this);

    }

    @OnTextChanged(R.id.editEmail)
    public void onEmailChange(CharSequence cs, int start, int count, int after) {
        if (!Patterns.EMAIL_ADDRESS.matcher(editEmail.getText()).matches()) {
            editEmail.setError(getResources().getString(R.string.warning_invalid,
                    getResources().getString(R.string.email)));
        }
    }

    @OnTextChanged(R.id.editPhone)
    public void onPhoneChange(CharSequence cs, int start, int count, int after) {
        if (!Patterns.PHONE.matcher(editPhone.getText()).matches()) {
            editPhone.setError(getResources().getString(R.string.warning_invalid,
                    getResources().getString(R.string.phone_number)));
        }
    }

    @OnClick(R.id.btnNext)
    public void onClickBtnNext() {
        if (checkValidInput()) {
            Intent intent = new Intent(getBaseContext(), SignUpStep2Activity.class);
            startActivity(intent);
            this.finish();
        }
        if (TextUtils.isEmpty(editFirstName.getText())) {
            editFirstName.setError(getResources().getString(R.string.warning_enter,
                    getResources().getString(R.string.first_name)));
        }
        if (TextUtils.isEmpty(editLastName.getText())) {
            editLastName.setError(getResources().getString(R.string.warning_enter,
                    getResources().getString(R.string.last_name)));
        }
        if (TextUtils.isEmpty(editEmail.getText())) {
            editEmail.setError(getResources().getString(R.string.warning_enter,
                    getResources().getString(R.string.email)));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(editEmail.getText()).matches()) {
            editEmail.setError(getResources().getString(R.string.warning_invalid,
                    getResources().getString(R.string.email)));
        }
        if (TextUtils.isEmpty(editPhone.getText())) {
            editPhone.setError(getResources().getString(R.string.warning_enter,
                    getResources().getString(R.string.phone_number)));
        } else if (!Patterns.PHONE.matcher(editPhone.getText()).matches()) {
            editPhone.setError(getResources().getString(R.string.warning_invalid,
                    getResources().getString(R.string.phone_number)));
        }
    }

    public boolean checkValidInput() {
        if (!TextUtils.isEmpty(editFirstName.getText()) &&
                !TextUtils.isEmpty(editLastName.getText()) &&
                !TextUtils.isEmpty(editEmail.getText()) &&
                !TextUtils.isEmpty(editPhone.getText()) &&
                Patterns.EMAIL_ADDRESS.matcher(editEmail.getText()).matches() &&
                Patterns.PHONE.matcher(editPhone.getText()).matches()) {
            return true;
        }
        return false;
    }
}
