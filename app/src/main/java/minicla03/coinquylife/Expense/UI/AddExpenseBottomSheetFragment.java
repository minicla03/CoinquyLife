package minicla03.coinquylife.Expense.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import minicla03.coinquylife.R;

public class AddExpenseBottomSheetFragment extends BottomSheetDialogFragment {

    private EditText etAmount, etDescription;
    private ToggleButton toggleDaFare, toggleSaldata;
    private Button btnConfirm;
    private OnExpenseAddedListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pannel_expense, container, false);

        etAmount = view.findViewById(R.id.et_expense_amount);
        etDescription = view.findViewById(R.id.et_expense_description);
        toggleDaFare = view.findViewById(R.id.toggle_da_fare);
        toggleSaldata = view.findViewById(R.id.toggle_saldata);
        btnConfirm = view.findViewById(R.id.btn_confirm_expense);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = etAmount.getText().toString();
                String description = etDescription.getText().toString();
                boolean daFare = toggleDaFare.isChecked();
                boolean saldata = toggleSaldata.isChecked();


                if (listener != null) {
                    //listener.onExpenseAdded(amount, description, daFare, saldata);
                }
                dismiss();
            }
        });

        return view;
    }

    public void setOnExpenseAddedListener(OnExpenseAddedListener listener) {
        this.listener = listener;
    }
}
