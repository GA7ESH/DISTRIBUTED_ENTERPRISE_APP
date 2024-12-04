package edu.mga.henrybookstore;

import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.Path;

public interface BookService {

    @GET("get")
    Call<List<Book>> getAllBooks();

    @POST("create")
    Call<Void> addBook(@Body Book book);

    @GET("{id}")
    Call<Book> getBook(@Path("id") Long id);
}
