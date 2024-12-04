package edu.mga.henrybookstore;

import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.Path;

public interface InventoryService {

    @GET("get")
    Call<List<Inventory>> getInventory();

    @POST("create")
    Call<Void> createInventory(@Body Inventory inventory);

    @GET("{bookId}/{bookId}")
    Call<Inventory> getInventory(@Path("bookId") Long bookId,@Path("branchId") Long branchId);
}