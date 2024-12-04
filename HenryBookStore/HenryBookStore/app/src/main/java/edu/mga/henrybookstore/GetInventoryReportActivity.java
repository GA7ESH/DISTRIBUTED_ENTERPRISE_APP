package edu.mga.henrybookstore;

import android.app.ProgressDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.widget.Toast;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class GetInventoryReportActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_inventory_report);

        progressDoalog = new ProgressDialog(GetInventoryReportActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        InventoryService service = RetrofitClient.getInvInstance().create(InventoryService.class);

        Call<List<Inventory>> call = service.getInventory();

        call.enqueue(new Callback<List<Inventory>>() {
            @Override
            public void onResponse(Call<List<Inventory>> call, Response<List<Inventory>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
                Log.d("Test", "Response received");
                //Log.d("Response", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Inventory>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(GetInventoryReportActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Inventory> inventoryList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this,inventoryList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(GetInventoryReportActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}