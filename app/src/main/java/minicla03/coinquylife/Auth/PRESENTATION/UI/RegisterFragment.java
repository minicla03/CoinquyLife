package minicla03.coinquylife.Auth.PRESENTATION.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import minicla03.coinquylife.DATALAYER.remote.AuthAPI.AuthStatus;
import minicla03.coinquylife.Auth.PRESENTATION.ViewModel.AuthViewModel;
import minicla03.coinquylife.R;
import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.SelectionHouse.PRESENTATION.UI.CoinquyHouseSelectionActivity;

public class RegisterFragment extends Fragment
{
    private AuthViewModel authViewModel;

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText usernameEditText;
    private Button registerButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        initializeUI(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        setupObservers();
        setupListeners();
    }

    private void initializeUI(View view)
    {
        emailEditText = view.findViewById(R.id.etEmail);
        passwordEditText = view.findViewById(R.id.etPassword);
        nameEditText = view.findViewById(R.id.etNome);
        surnameEditText = view.findViewById(R.id.etCognome);
        usernameEditText = view.findViewById(R.id.etUsername);
        registerButton = view.findViewById(R.id.btnRegister);
    }

    private void setupObservers()
    {
        authViewModel.getRegisterResult().observe(getViewLifecycleOwner(), result -> {
            if (result.getStatusAuth()== AuthStatus.SUCCESS)
            {
                Intent intent = new Intent(this.getContext(), CoinquyHouseSelectionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                //intent.putExtra("user_token", result.getToken());
                startActivity(intent);
            }
            else if(result.getStatusAuth() == AuthStatus.AlREADY_REGISTERED)
            {
                Toast.makeText(getContext(), "User already exist", Toast.LENGTH_SHORT).show();
            }
            else if(result.getStatusAuth() == AuthStatus.INVALID_EMAIL)
            {
                Toast.makeText(getContext(), "Invalid email", Toast.LENGTH_SHORT).show();
            }
            else if(result.getStatusAuth() == AuthStatus.ERROR)
            {
                Toast.makeText(getContext(), "Registration failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupListeners()
    {
        registerButton.setOnClickListener(v -> attemptRegistration());
    }

    private void attemptRegistration()
    {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String name = nameEditText.getText().toString().trim();
        String surname = surnameEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();

        User user = new User(username, name, password, surname, email);
        authViewModel.register(user);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
    }
}