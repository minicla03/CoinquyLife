package minicla03.coinquylife.PERSISTANCE.database.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.PERSISTANCE.database.entity.CoinquyHouse;
import minicla03.coinquylife.PERSISTANCE.database.entity.User;

public class CoinquyHouseWithUserRelationship
{
    @Embedded
    public CoinquyHouse house;

    @Relation(
            parentColumn = "id_house",
            entityColumn = "houseUser"
    )
    public List<User> users;
}
