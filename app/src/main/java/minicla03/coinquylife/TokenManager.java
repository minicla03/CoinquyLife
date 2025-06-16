package minicla03.coinquylife;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class TokenManager
{
    private static final String FILE_NAME = "secure_prefs";
    private static final String KEY_TOKEN = "auth_token";

    private final SharedPreferences sharedPreferences;
    private static TokenManager instance;

    public static synchronized TokenManager getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new TokenManager(context.getApplicationContext());
        }
        return instance;
    }

    private TokenManager(Context context)
    {
        try
        {
            String masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);

            sharedPreferences = EncryptedSharedPreferences.create(
                    FILE_NAME,
                    masterKeyAlias,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        }
        catch (GeneralSecurityException | IOException e)
        {
            throw new RuntimeException("Errore nella creazione di EncryptedSharedPreferences", e);
        }
    }

    public void saveToken(String token)
    {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply();
    }

    public String getToken() {
        return sharedPreferences.getString(KEY_TOKEN, null);
    }

    public void clearToken() {
        sharedPreferences.edit().remove(KEY_TOKEN).apply();
    }
}
