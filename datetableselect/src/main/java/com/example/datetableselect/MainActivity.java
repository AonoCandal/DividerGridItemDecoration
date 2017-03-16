package com.example.datetableselect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleview = (RecyclerView) findViewById(R.id.recycleview);
        recycleview.addItemDecoration(new DividerGridItemDecoration(this,R.drawable.listdivider, DividerGridItemDecoration.DISABLE_OUTER_BORDER));
//        recycleview.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL,false));
        recycleview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
        recycleview.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(getLayoutInflater().inflate(R.layout.item,parent,false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTvCount.setText(String.valueOf(position));
            ViewGroup.LayoutParams layoutParams = holder.mTvCount.getLayoutParams();
            layoutParams.width = position*50 + 100;
            holder.mTvCount.setLayoutParams(layoutParams);
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvCount;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTvCount = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }
}
