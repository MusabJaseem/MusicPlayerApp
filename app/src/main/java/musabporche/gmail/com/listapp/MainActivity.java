package musabporche.gmail.com.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Resources res = getResources();
        ListView myListView = (ListView) findViewById(R.id.myListView);
        String[] items = res.getStringArray(R.array.items);
        String[] prices = res.getStringArray(R.array.prices);
        String[] description = res.getStringArray(R.array.description);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, description);
        myListView.setAdapter(itemAdapter);

        //Goes from this activity to the DetailActivity
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class); //(Must, where to go);
                showDetailActivity.putExtra("musabporche.gmail.com.ITEM_INDEX", i);
                startActivity(showDetailActivity);

            }
        });
    }
}
