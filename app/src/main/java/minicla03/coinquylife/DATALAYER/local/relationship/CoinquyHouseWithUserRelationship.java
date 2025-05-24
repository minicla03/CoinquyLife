package minicla03.coinquylife.DATALAYER.local.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.User;

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
