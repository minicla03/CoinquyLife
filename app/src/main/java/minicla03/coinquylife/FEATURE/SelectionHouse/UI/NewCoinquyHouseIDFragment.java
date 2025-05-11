package minicla03.coinquylife.FEATURE.SelectionHouse.UI;

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

import minicla03.coinquylife.DATALAYER.database.entity.User;
import minicla03.coinquylife.R;
import minicla03.coinquylife.FEATURE.SelectionHouse.Utility.SelectHouseStatus;
import minicla03.coinquylife.FEATURE.SelectionHouse.ViewModel.SelectHouseViewModel;
import minicla03.coinquylife.FEATURE.dashboard.UI.DashboardActivity;

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
        String id_user=null;
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null)
        {
            id_user=getArguments().getString("user");
            if (id_user == null)
            {
                Toast.makeText(requireContext(), "User data is missing", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        selectHouseViewModel = new ViewModelProvider(this).get(SelectHouseViewModel.class);
        selectHouseViewModel.getRetriveUserResult().observe(getViewLifecycleOwner(), user -> this.user = user);
        selectHouseViewModel.retriveUser(id_user);

        TextView textViewID = view.findViewById(R.id.textViewID);
        Button btnProceed = view.findViewById(R.id.btnProceed);
        ImageButton btnCopyID = view.findViewById(R.id.btnCopyID);
        houseName= view.findViewById(R.id.etHouseName);

        textViewID.setText(selectHouseViewModel.generateHouseCode());

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
            else if(result.getStatus()==SelectHouseStatus.HOUSE_NOT_FOUND)
            {
                Toast.makeText(requireContext(), "House not found", Toast.LENGTH_SHORT).show();
            }
            else if(result.getStatus()==SelectHouseStatus.FAILURE)
            {
                Toast.makeText(requireContext(), "Error during the creation of the house", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
