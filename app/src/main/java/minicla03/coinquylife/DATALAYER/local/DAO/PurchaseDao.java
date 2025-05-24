package minicla03.coinquylife.DATALAYER.local.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import minicla03.coinquylife.DATALAYER.local.entity.Purchase;
import minicla03.coinquylife.DATALAYER.local.relationship.PurchaseRelationship;

@Dao
public interface PurchaseDao {

    @Insert
    void insertPurchase(Purchase purchase);

    @Update
    void updatePurchase(Purchase purchase);

    @Delete
    void deletePurchase(Purchase purchase);

    @Transaction
    @Query("SELECT * FROM Purchase WHERE id_purchase = :purchaseId")
    PurchaseRelationship getPurchaseWithDetails(String purchaseId);

    @Transaction
    @Query("SELECT * FROM Purchase")
    LiveData<List<PurchaseRelationship>> getAllPurchasesWithDetails();
}