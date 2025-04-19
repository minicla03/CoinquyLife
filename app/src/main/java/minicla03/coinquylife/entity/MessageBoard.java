package minicla03.coinquylife.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.UUID;

@Entity(tableName = "MessageBoard",
        foreignKeys = @ForeignKey(
                entity=CoinquyHouse.class,
                parentColumns ="id_house",
                childColumns ="house",
                onDelete= ForeignKey.CASCADE,
                onUpdate= ForeignKey.CASCADE
        ),
        indices = {@Index(value = "house", unique = true)}
)
public class MessageBoard
{
    @ColumnInfo(name = "id_board") @PrimaryKey(autoGenerate = true) @NotNull private String id_board;
    @ColumnInfo(name = "house") private String house;

    public MessageBoard(@NotNull String id_board, String house)
    {
        this.id_board = UUID.randomUUID().toString(); ;
        this.house = house;
    }
}
