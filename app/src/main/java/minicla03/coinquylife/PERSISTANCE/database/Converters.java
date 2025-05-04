package minicla03.coinquylife.PERSISTANCE.database;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

import androidx.room.TypeConverter;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.UUID;

public class Converters
{
    // Converte Date in Long (timestamp)
    @TypeConverter
    public static Long fromDate(Date date) {
        return date == null ? null : date.getTime(); // Restituisce il timestamp in millisecondi
    }

    // Converte Long (timestamp) in Date
    @TypeConverter
    public static Date fromLong(Long value) {
        return value == null ? null : new Date(value); // Crea una data da un timestamp
    }

    // Converte UUID in String
    @TypeConverter
    public static String fromUUID(UUID uuid) {
        return uuid == null ? null : uuid.toString();  // Converte UUID in String
    }

    // Converte String in UUID
    @TypeConverter
    public static UUID fromString(String value) {
        return value == null ? null : UUID.fromString(value);  // Converte String in UUID
    }

    @TypeConverter
    public static String fromDrawable(Drawable drawable) {
        if (drawable == null) return null;

        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        byte[] byteArray = outputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    @TypeConverter
    public static Drawable toDrawable(String encodedString) {
        if (encodedString == null) return null;

        byte[] byteArray = Base64.decode(encodedString, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        return new BitmapDrawable(Resources.getSystem(), bitmap);
    }
}
