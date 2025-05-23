package minicla03.coinquylife.SelectionHouse.PRESENTATION.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import minicla03.coinquylife.DATALAYER.local.entity.User;
import minicla03.coinquylife.R;
import minicla03.coinquylife.SelectionHouse.Utility.SelectHouseStatus;
import minicla03.coinquylife.SelectionHouse.PRESENTATION.ViewModel.SelectHouseViewModel;
import minicla03.coinquylife.dashboard.UI.DashboardActivity;

public class NewCoinquyHouseIDFragment extends Fragment {

    private EditText houseName;
    private SelectHouseViewModel selectHouseViewModel;
    private User user;

    public NewCoinquyHouseIDFragment() { }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_new_coinquy_house, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        TextView textViewID = view.findViewById(R.id.textViewID);
        Button btnProceed = view.findViewById(R.id.btnProceed);
        ImageButton
                btnCopyID = view.findViewById(R.id.btnCopyID);
        houseName= view.findViewById(R.id.etHouseName);
        selectHouseViewModel = new ViewModelProvider(requireActivity()).get(SelectHouseViewModel.class);
        textViewID.setText(selectHouseViewModel.generateHouseCode());

        selectHouseViewModel.getIntentData().observe(getViewLifecycleOwner(), data -> {
            if (data != null) {
                String idUser = (String) data.get("USER");
                if (idUser == null) {
                    Toast.makeText(requireContext(), "User data is missing", Toast.LENGTH_SHORT).show();
                } else {
                    selectHouseViewModel.retriveUser(idUser);
                }
            }
        });

        selectHouseViewModel.getRetriveUserResult().observe(getViewLifecycleOwner(), user -> this.user = user);

        btnProceed.setOnClickListener(v ->
        {
            String name_house = houseName.getText().toString().trim();
            selectHouseViewModel.createHouse(name_house, user);
        });

        textViewID.setText(selectHouseViewModel.generateHouseCode());

        btnCopyID.setOnClickListener(v -> {
            String textToCopy = textViewID.getText().toString();
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) requireContext().getSystemService(android.content.Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("House ID", textToCopy);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(requireContext(), "ID copiato negli appunti", Toast.LENGTH_SHORT).show();
        });

        btnProceed.setOnClickListener(v -> {
            String name_house = houseName.getText().toString().trim();
            selectHouseViewModel.createHouse(name_house, user);
        });

        selectHouseViewModel.getHouseCreationResult().observe(getViewLifecycleOwner(), result ->
        {
            if (result.getStatus()==SelectHouseStatus.SUCCESS)
            {
                Intent intent = new Intent(requireActivity(), DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("user", result.getUser().getId_user());
                intent.putExtra("coinquyhouse", result.getCoinquyHouse().getId_house());
                startActivity(intent);
            }
            else if(result.getStatus()==SelectHouseStatus.HOUSE_NAME_EMPTY)
            {
                Toast.makeText(requireContext(), "Insert a valid name", Toast.LENGTH_SHORT).show();
            }
            else if(result.getStatus()==SelectHouseStatus.ALREADY_IN_HOUSE)
            {
                Toast.makeText(requireContext(), "User already in a house", Toast.LENGTH_SHORT).show();
            }
            else if(result.getStatus()==SelectHouseStatus.FAILURE)
            {
                Toast.makeText(requireContext(), "Error during the creation of the house", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
