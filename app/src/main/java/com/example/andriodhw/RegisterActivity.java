package com.example.andriodhw;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.andriodhw.databinding.ActivityRegisterBinding;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.imgPasswordToggle.setOnClickListener(v -> {
            if (isPasswordVisible) {
                binding.etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                binding.imgPasswordToggle.setImageResource(R.drawable.ic_eye_slash);
                isPasswordVisible = false;
            } else {
                binding.etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                binding.imgPasswordToggle.setImageResource(R.drawable.ic_eye);
                isPasswordVisible = true;
            }
            binding.etPassword.setSelection(binding.etPassword.getText().length());
        });

        binding.imgConfirmPasswordToggle.setOnClickListener(v -> {
            if (isConfirmPasswordVisible) {
                binding.etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                binding.imgConfirmPasswordToggle.setImageResource(R.drawable.ic_eye_slash);
                isConfirmPasswordVisible = false;
            } else {
                binding.etConfirmPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                binding.imgConfirmPasswordToggle.setImageResource(R.drawable.ic_eye);
                isConfirmPasswordVisible = true;
            }
            binding.etConfirmPassword.setSelection(binding.etConfirmPassword.getText().length());
        });

        binding.btnRegister.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString().trim();
            String username = binding.etUsername.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();
            String confirmPassword = binding.etConfirmPassword.getText().toString().trim();

            if (email.isEmpty()) {
                binding.etEmail.setError("Email is required");
                binding.etEmail.requestFocus();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.setError("Enter a valid email address");
                binding.etEmail.requestFocus();
                return;
            }

            if (username.isEmpty()) {
                binding.etUsername.setError("Username is required");
                binding.etUsername.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                binding.etPassword.setError("Password is required");
                binding.etPassword.requestFocus();
                return;
            }

            if (password.length() < 6) {
                binding.etPassword.setError("Password must be at least 6 characters");
                binding.etPassword.requestFocus();
                return;
            }

            if (confirmPassword.isEmpty()) {
                binding.etConfirmPassword.setError("Please confirm your password");
                binding.etConfirmPassword.requestFocus();
                return;
            }

            if (!password.equals(confirmPassword)) {
                binding.etConfirmPassword.setError("Passwords do not match");
                binding.etConfirmPassword.requestFocus();
                return;
            }

            Snackbar.make(binding.getRoot(), "Account created successfully for " + username, Snackbar.LENGTH_LONG).show();

            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        binding.tvSignUpPrompt.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        binding.btnGoogle.setOnClickListener(v ->
                Toast.makeText(RegisterActivity.this, "Google Sign Up Clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnFacebook.setOnClickListener(v ->
                Toast.makeText(RegisterActivity.this, "Facebook Sign Up Clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnGithub.setOnClickListener(v ->
                Toast.makeText(RegisterActivity.this, "GitHub Sign Up Clicked", Toast.LENGTH_SHORT).show()
        );
    }
}
