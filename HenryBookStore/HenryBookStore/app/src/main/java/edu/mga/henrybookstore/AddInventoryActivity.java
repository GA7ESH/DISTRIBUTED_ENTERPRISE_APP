package edu.mga.henrybookstore;

import android.app.ProgressDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class AddInventoryActivity extends AppCompatActivity {

    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);
    }

    public void addInventory(View view) {

        progressDoalog = new ProgressDialog(AddInventoryActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        InventoryService service = RetrofitClient.getInvInstance().create(InventoryService.class);

        EditText editBookId = (EditText) findViewById(R.id.editBookId);
        EditText editBranchId = (EditText) findViewById(R.id.editBranchId);
        EditText editQuantity = (EditText) findViewById(R.id.editQuantity);
        Inventory inventory = new Inventory(editBookId.getText().toString(), editBranchId.getText().toString(), editQuantity.getText().toString());

        Call<Void> call = service.createInventory(inventory);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                progressDoalog.dismiss();
                //generateDataList(response.body());
                Log.d("Test", "Response received");
                if (response.isSuccessful()){
                    Log.d("Result", "Success");
                    Toast.makeText(AddInventoryActivity.this, "Successfully added!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(AddInventoryActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}