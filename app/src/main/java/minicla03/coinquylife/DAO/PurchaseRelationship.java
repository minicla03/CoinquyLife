package minicla03.coinquylife.DAO;

import androidx.room.Embedded;
import androidx.room.Relation;

import minicla03.coinquylife.entity.CoinquyHouse;
import minicla03.coinquylife.entity.Purchase;
import minicla03.coinquylife.entity.User;

public class PurchaseRelationship
{
    @Embedded
    public Purchase purchase;

    @Relation(
        parentColumn = "id_user",
        entityColumn = "id_user"
    )
    public User user;

    @Relation(
        parentColumn = "id_house",
        entityColumn = "id_house"
    )
    public CoinquyHouse house;
}