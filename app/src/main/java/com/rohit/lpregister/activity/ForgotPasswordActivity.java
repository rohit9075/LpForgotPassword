package com.rohit.lpregister.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rohit.lpregister.R;
import com.rohit.lpregister.database.DatabaseHelper;
import com.rohit.lpregister.utils.SharedPreference;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ForgotPasswordActivity";
    private EditText mEditTextEmail, mEditTextMobileNumber;
    private TextInputEditText mTextInputEditTextPassword , mTextInputEditTextConfirmPassword;

    private Button mButtonReset , mButtonSubmit;

    private DatabaseHelper mDatabaseHelper;

    private LinearLayout mLinearLayoutUserData, mLinearLayoutNewPassword;

   static String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initView(); // initView() method call

        clickListener(); // clickListener(); method call

        initObject(); // initObject method call

    }

    /**
     * clickListener() method definition
     */

    private void clickListener() {

        mButtonSubmit.setOnClickListener(this);
        mButtonReset.setOnClickListener(this);


    }

    /**
     * intiView Method definition
     */
    private void initView() {

     mEditTextMobileNumber = findViewById(R.id.edittext_reset_mobile_number);
     mEditTextEmail = findViewById(R.id.edittext_reset_eamil_id);

     mTextInputEditTextPassword = findViewById(R.id.textinputedittext_reset_password);
     mTextInputEditTextConfirmPassword = findViewById(R.id.textinputedittext_reset_confirm_password);

     mButtonReset = findViewById(R.id.button_reset);
     mButtonSubmit = findViewById(R.id.button_reset_submit);

     mLinearLayoutUserData = findViewById(R.id.linear_user_data);
     mLinearLayoutNewPassword = findViewById(R.id.linear_user_new_password);



    }

    public void initObject(){

        mDatabaseHelper = new DatabaseHelper(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button_reset:
                userDataMatching();
                break;

            case R.id.button_reset_submit:

           boolean status =      mDatabaseHelper.updateCandidatePassword(email, mTextInputEditTextPassword.getText().toString().trim());
           if (status){
               Toast.makeText(this, "Password updated Successfully", Toast.LENGTH_SHORT).show();
               finish();
           }

                break;
        }

    }

    private void userDataMatching() {
        String mobile = mEditTextMobileNumber.getText().toString().trim();

        email = mEditTextEmail.getText().toString().trim();

        boolean  status = mDatabaseHelper.checkCandidateForPassworedReset(email,mobile);
        if (status){

            mLinearLayoutUserData.setVisibility(View.GONE);
            mLinearLayoutNewPassword.setVisibility(View.VISIBLE);

        }
    }
}
