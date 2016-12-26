package com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.security.GeneralSecurityException;


public class MainActivity extends AppCompatActivity {
    private TextView text1;
    private TextView text2;

    private Button button;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        String password = "password";
        String message = "hello world";

        // 加密
        try {

            String encryptedMsg = AESCrypt.encrypt(password, message);
            text1.setText(encryptedMsg);
            Log.d("crypt", "AES encrypt succeeded.");
            Log.d("crypt", encryptedMsg);

        } catch (GeneralSecurityException e) {

            Log.d("crypt", "AES encrypt failed.");
        }
        // 解密
        String encryptedMsg = "2B22cS3UC5s35WBihLBo8w==";
        try {
            String messageAfterDecrypt = AESCrypt.decrypt(password, encryptedMsg);

            text2.setText(messageAfterDecrypt);

            Log.d("crypt", "AES decrypt succeeded.");
            Log.d("crypt", messageAfterDecrypt);

        } catch (GeneralSecurityException e) {

            Log.d("crypt", "AES decrypt failed.");
        }

    }

}




