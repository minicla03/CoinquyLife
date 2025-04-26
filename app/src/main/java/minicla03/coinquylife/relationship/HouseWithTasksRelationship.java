package minicla03.coinquylife.relationship;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import minicla03.coinquylife.entity.CoinquyHouse;
import minicla03.coinquylife.entity.Task;

public class HouseWithTasksRelationship {
    @Embedded
    public CoinquyHouse house;

    @Relation(
        parentColumn = "id_house", //CoinquyHouse
        entityColumn = "id_house" //Task
    )
    public List<Task> tasks;
}