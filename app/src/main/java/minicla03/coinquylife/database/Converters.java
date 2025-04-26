package minicla03.coinquylife.database;

import androidx.room.TypeConverter;
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
}
