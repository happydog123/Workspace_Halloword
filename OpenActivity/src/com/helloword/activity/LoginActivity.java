package com.helloword.activity;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.helloword.R;
import com.helloword.service.UserService;


public class LoginActivity extends BaseActivity {

	// private Button loginBtn;
	// private Button regBtn;

	
	 private EditText userNameET;
	 private EditText passwordET;
	 
	 
	 
	// private CheckBox remember;

	// private Dialog dialog;
	// private SharedPreferences sp;

//	private static final String DEBUGTAG = "LoginActivity";

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_login);

		// registerBtn = (Button) findViewById(R.id.lg_register_btn);
		// loginBtn = (Button) findViewById(R.id.lg_login_btn);
		
		 userNameET = (EditText) findViewById(R.id.login_username);
		 passwordET = (EditText) findViewById(R.id.login_password);
		 
		// rememberPassword = (CheckBox) findViewById(R.id.lg_remember_password);

		
	}
	
	public void loginHandler(View view) {
	    String userName = userNameET.getText().toString().trim();
	    String password = passwordET.getText().toString().trim();
	    
        if (userName.equals("") || password.equals("")) {
            Toast.makeText(getApplicationContext(), "please input your username or password",
                  Toast.LENGTH_SHORT).show();
        }
        else {
            
            // ==========test test===========
            Intent intent = new Intent(this, OnLineActivity.class);
            startActivity(intent);
            finish();
            //================================
            
//            Log.d(DEBUGTAG, userName + " " + password);
//            NetworkService networkService = new NetworkService(this);
//            if (networkService.isConnected()) {
//                new LoginInBackground().execute(userName, password);
//            }
//            else {
//                Toast.makeText(getApplicationContext(), "Please connect to the internet",
//                        Toast.LENGTH_SHORT).show();
//            }
        }
	    
	}
	
	
	
	public void registerHandler(View view) {
	    Intent intent = new Intent(this, RegisterActivity.class);
	    startActivity(intent);
	}
	
	private class LoginInBackground extends AsyncTask<String, Void, String> {
	    @Override
	    protected String doInBackground(String... params) {
	        UserService userService = new UserService(getApplication());
            return userService.login(params[0], params[1]);
            
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            if (result.equals("success")) {
                Intent intent = new Intent(getApplicationContext(), OnLineActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(getApplicationContext(), result,
                      Toast.LENGTH_SHORT).show();
            }
        }
	}
	

}
