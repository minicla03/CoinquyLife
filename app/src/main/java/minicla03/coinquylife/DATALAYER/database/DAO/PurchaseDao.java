package minicla03.coinquylife.DATALAYER.database.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import minicla03.coinquylife.DATALAYER.database.relationship.PurchaseRelationship;

@Dao
public interface PurchaseDao {
    @Transaction
    @Query("SELECT * FROM Purchase WHERE id_purchase = :purchaseId")
    PurchaseRelationship getPurchaseWithDetails(String purchaseId);

    @Transaction
    @Query("SELECT * FROM Purchase")
    LiveData<List<PurchaseRelationship>> getAllPurchasesWithDetails();
}