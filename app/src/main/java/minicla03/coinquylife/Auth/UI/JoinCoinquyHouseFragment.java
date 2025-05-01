package minicla03.coinquylife.Auth.UI;

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

import minicla03.coinquylife.R;

public class JoinCoinquyHouseFragment extends Fragment {

    private EditText etHouseID;
    private Button btnConfirm;

    public JoinCoinquyHouseFragment() {  }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_existing_house, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etHouseID = view.findViewById(R.id.etHouseID);
        btnConfirm = view.findViewById(R.id.btnConfirmHouseID);

        btnConfirm.setOnClickListener(v -> {
            String houseId = etHouseID.getText().toString().trim();

            if (houseId.isEmpty()) {
                Toast.makeText(requireContext(), "Inserisci un ID valido", Toast.LENGTH_SHORT).show();
            } else {
                // TODO: Verifica ID e naviga o mostra errore
                Toast.makeText(requireContext(), "ID inserito: " + houseId, Toast.LENGTH_SHORT).show();
                // Esempio: Navigation.findNavController(view).navigate(R.id.action_to_nextStep);
            }
        });
    }
}
