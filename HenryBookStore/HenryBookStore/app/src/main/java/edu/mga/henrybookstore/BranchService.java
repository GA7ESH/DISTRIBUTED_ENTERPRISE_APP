package edu.mga.henrybookstore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.Path;

public interface BranchService {

    @GET("get")
    Call<List<Branch>> getAllBooks();

    @POST("create")
    Call<Void> addBranch(@Body Branch Branch);

    @GET("{id}")
    Call<Branch> getBook(@Path("id") Long id);
}
