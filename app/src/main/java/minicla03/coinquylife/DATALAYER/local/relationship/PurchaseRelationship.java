package minicla03.coinquylife.DATALAYER.local.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import minicla03.coinquylife.DATALAYER.local.entity.CoinquyHouse;
import minicla03.coinquylife.DATALAYER.local.entity.Purchase;
import minicla03.coinquylife.DATALAYER.local.entity.User;

public class PurchaseRelationship {
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