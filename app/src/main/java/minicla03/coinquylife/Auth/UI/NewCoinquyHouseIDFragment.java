package minicla03.coinquylife.Auth.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import minicla03.coinquylife.R;

public class NewCoinquyHouseIDFragment extends Fragment {

    private TextView textViewID;
    private Button btnProceed;

    public NewCoinquyHouseIDFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_new_coinquy_house, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewID = view.findViewById(R.id.textViewID);
        btnProceed = view.findViewById(R.id.btnProceed);

        textViewID.setText("ID: ABC123XYZ");

        btnProceed.setOnClickListener(v -> {
            // TODO: Naviga al prossimo fragment o activity
            // Esempio: Navigation.findNavController(view).navigate(R.id.action_to_nextDestination);
        });
    }
}
