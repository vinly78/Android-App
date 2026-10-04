package com.example.andriodhw;

import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.andriodhw.databinding.FragmentRegisterBinding;
import com.google.android.material.snackbar.Snackbar;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;
    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;

    public RegisterFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

            Navigation.findNavController(v).navigate(R.id.action_registerFragment_to_loginFragment);
        });

        binding.tvSignUpPrompt.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_registerFragment_to_loginFragment)
        );

        binding.btnGoogle.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Google Sign Up Clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnFacebook.setOnClickListener(v ->
                Toast.makeText(requireContext(), "Facebook Sign Up Clicked", Toast.LENGTH_SHORT).show()
        );

        binding.btnGithub.setOnClickListener(v ->
                Toast.makeText(requireContext(), "GitHub Sign Up Clicked", Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
