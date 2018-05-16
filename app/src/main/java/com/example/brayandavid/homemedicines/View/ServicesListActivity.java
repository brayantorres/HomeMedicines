package com.example.brayandavid.homemedicines.View;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.brayandavid.homemedicines.Conection.TaskImages;
import com.example.brayandavid.homemedicines.Conection.TaskProducts;
import com.example.brayandavid.homemedicines.MainActivity;
import com.example.brayandavid.homemedicines.Objects.Product;
import com.example.brayandavid.homemedicines.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesListActivity extends AppCompatActivity {

    TextView textView;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_list);

        textView = (TextView) findViewById(R.id.textViewSearch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        if (findViewById(R.id.servicios_detail_container) != null) {
            mTwoPane = true;
        }

        RecyclerView recyclerView =  (RecyclerView) findViewById(R.id.servicios_list);
        assert recyclerView != null;
        setupRecyclerView(recyclerView);

        TaskProducts task = new TaskProducts(this);
        try {
            List<Product> products = task.execute().get();
            recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, products, mTwoPane));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(this, getProductxxx(), mTwoPane));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final ServicesListActivity mParentActivity;
        private final List<Product> mValues;
        private final boolean mTwoPane;
        private final View.OnClickListener mOnClickListener;

        {
            mOnClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product item = (Product) view.getTag();
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putSerializable(ServicesDetailFragment.ARG_ITEM_ID, item);
                        ServicesDetailFragment fragment = new ServicesDetailFragment();
                        fragment.setArguments(arguments);
                        mParentActivity.getSupportFragmentManager().beginTransaction()
                                .replace(R.id.servicios_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, ServicesDetailActivity.class);
                        intent.putExtra(ServicesDetailFragment.ARG_ITEM_ID, item);
                        context.startActivity(intent);
                    }
                }
            };
        }

        SimpleItemRecyclerViewAdapter(ServicesListActivity parent,
                                      List<Product> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.servicios_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            Product product = mValues.get(position);
            TaskImages taskImages = new TaskImages(holder.mIdView);
            taskImages.execute(product);
            holder.mContentView.setText(product.getName());
            holder.mdetalleView.setText(product.getDescription());
            holder.itemView.setTag(product);
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final ImageView mIdView;
            final TextView mContentView;
            final TextView mdetalleView;


            ViewHolder(View view) {
                super(view);
                mIdView = (ImageView) view.findViewById(R.id.iv_avatar);
                mContentView = (TextView) view.findViewById(R.id.ev_name);
                mdetalleView = (TextView) view.findViewById(R.id.ev_txt);

            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(getText(R.string.search));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(ServicesListActivity.this, R.string.submitted, Toast.LENGTH_SHORT).show();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                textView.setText(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public boolean OnOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                action(R.string.action_settings);
                return true;
            case R.id.action_help:
                action(R.string.action_help);
                return true;
            case R.string.action_about:
                action(R.string.action_about);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void action(int resid) {
        Toast.makeText(this, getText(resid), Toast.LENGTH_SHORT).show();
    }

    public List<Product> getProductxxx() {
        List<Product> list = new ArrayList<>();
        return list;
    }
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.Espera);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage(R.string.Mensaje2);
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent regress = new Intent(ServicesListActivity.this, MainActivity.class);
                startActivity(regress);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
