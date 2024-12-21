package com.thick124.lop03.nhom13;

import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;



public class login_activity extends AppCompatActivity {
    TextView tvDK;
    Button btnDN;
    CheckBox cbXemMK;
    AppCompatEditText edtTDN;
    AppCompatEditText edtMK;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    private static final String CHANNEL_ID = "example_channel_id";

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvDK = (TextView) findViewById(R.id.formDangKy);
        btnDN = (Button) findViewById(R.id.buttonDangNhap);
        cbXemMK = (CheckBox) findViewById(R.id.show_password);
        edtTDN = findViewById(R.id.edt_TenNguoiDungDN);
        edtMK = findViewById(R.id.edt_MatKhauDN);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);


        btnDN.setOnClickListener(new View.OnClickListener() {
          //  @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                String username = edtTDN.getText().toString().trim();
                String password = edtMK.getText().toString().trim();

                //   Toast.makeText(login_activity.this, username+":"+password, Toast.LENGTH_SHORT).show();


                loginViewModel.loginInVM(username, password).observe(login_activity.this, user -> {
                    if (user != null) {
                        //Thông báo
                        Toast.makeText(login_activity.this, "Đăng nhập với tên: " + user.getUsername() + ":" + user.getName(), Toast.LENGTH_SHORT).show();


                        //Lưu user đang đăng nhập vào phiên đăng nhập
                        CurrentUserSesssion.getInstance().setUserCurrent(user);



                        // Chuyển sang màn hình trang chủ
                        Intent chuyensangManHinhChinh = new Intent(login_activity.this, MainScreen.class);
                        // Toast.makeText(login_activity.this, "Đăng nhập thành công!!", Toast.LENGTH_SHORT).show();
                        startActivity(chuyensangManHinhChinh);
                    } else {
                        Toast.makeText(login_activity.this, "Tài khoản hoặc mật khẩu không hợp lệ!", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        cbXemMK.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                edtMK.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            else
                edtMK.setTransformationMethod(PasswordTransformationMethod.getInstance());
        });


        //chuyển sang trang đăng ký tài khoản
        tvDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chuyensangDangKy = new Intent(login_activity.this, activity_signup.class);
                startActivity(chuyensangDangKy);
            }
        });


    } //end onCreate


    private void createNotificationChannel() {
        // Tạo kênh thông báo cho Android 8.0 trở lên
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Example Channel";
            String description = "Channel for example notifications";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


//method ngoài để gọi
private void showPopupWarning() {

    Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.dialog_warning_login);

    // Để nền dialog trong suốt
    dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    Button btnClose = dialog.findViewById(R.id.btn_close);
    btnClose.setOnClickListener(v -> dialog.dismiss());


    dialog.show();
}
    }