package setting;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import minicla03.coinquylife.R;

public class SettingOptionFragment extends PreferenceFragmentCompat
{
    private SharedPreferences sharedPreferences;
    private String sharedPrefFile = "minicla03.coinquylife.settings";

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey)
    {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        sharedPreferences = getActivity().getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        Preference preference=this.findPreference("");
        preference.setSummary(sharedPreferences.getString("summary", getString(R.string.summary_default)));

        preference.setOnPreferenceChangeListener((preference1, newValue) -> {
            if ((Boolean) newValue == true)
            {
                preference.setSummary(R.string.option_on);
                SharedPreferences.Editor preferencesEditor = sharedPreferences.edit();
                preferencesEditor.putString("summary", getString(R.string.option_on)).apply();
            }
            else
            {
                preference.setSummary(R.string.option_off);
                SharedPreferences.Editor preferencesEditor =sharedPreferences.edit();
                preferencesEditor.putString("summary", getString(R.string.option_off)).apply();
            }
            return true;
        });
    }
}
