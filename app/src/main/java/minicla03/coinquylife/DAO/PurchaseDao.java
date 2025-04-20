package minicla03.coinquylife.DAO;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface PurchaseDao {
    @Transaction
    @Query("SELECT * FROM Purchase WHERE id_purchase = :purchaseId")
    PurchaseRelationship getPurchaseWithDetails(String purchaseId);

    @Transaction
    @Query("SELECT * FROM Purchase")
    List<PurchaseRelationship> getAllPurchasesWithDetails();
}