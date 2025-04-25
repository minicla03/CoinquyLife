package minicla03.coinquylife.DATALAYER.database.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.DATALAYER.database.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.database.entity.User;

public class CoiquyHouseWithUserRelationship
{
    @Embedded
    public CoinquyHouse house;

    @Relation(
            parentColumn = "id_house",
            entityColumn = "houseUser"
    )
    public List<User> users;
}
