package cresterida.me.learning.fireappdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.zakariya.stickyheaders.StickyHeaderLayoutManager;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterFire adapter=new AdapterFire();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new StickyHeaderLayoutManager());
        recyclerView.setAdapter(adapter);
        adapter.loadList();
    }
}
