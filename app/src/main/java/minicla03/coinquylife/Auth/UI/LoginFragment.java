package minicla03.coinquylife.Auth.UI;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import minicla03.coinquylife.Auth.ViewModel.LoginViewModel;
import minicla03.coinquylife.R;

public class LoginFragment extends Fragment
{
    public LoginFragment()
    {
        super(R.layout.fragment_login); // layout XML del login
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView etEmail = view.findViewById(R.id.etEmail);
        TextView etPassword = view.findViewById(R.id.etPassword);
        View btnLogin = view.findViewById(R.id.btnLogin);

        LoginViewModel loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString();

            loginViewModel.login(email, password);
        });

        loginViewModel.getLoginResult().observe(getViewLifecycleOwner(), result -> {
            if (result != null && result.isSuccess()) 
            {
                Toast.makeText(getContext(), "Login riuscito!", Toast.LENGTH_SHORT).show();
                // Passa alla schermata principale
                //Intent intent = new Intent(getContext(), MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                //startActivity(intent);
            } 
            else 
            {
                Toast.makeText(getContext(), "Login fallito!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
