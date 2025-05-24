package minicla03.coinquylife.DATALAYER.local.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import minicla03.coinquylife.DATALAYER.local.relationship.PurchaseRelationship;

@Dao
public interface PurchaseRelationshipDao {

    @Transaction
    @Query("SELECT * FROM Purchase WHERE id_purchase = :purchaseId")
    PurchaseRelationship getPurchaseWithDetails(String purchaseId);

    @Transaction
    @Query("SELECT * FROM Purchase")
    List<PurchaseRelationship> getAllPurchasesWithDetails();
}