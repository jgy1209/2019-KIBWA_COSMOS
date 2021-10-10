package org.techtown.location;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    public static class SweetViewHolder extends RecyclerView.ViewHolder{

        ImageView sweetPicture;
        TextView sweetItem;
        TextView sweetPrice;
        Activity activity;


        public SweetViewHolder(View view){
            super(view);
            sweetPicture = view.findViewById(R.id.sweet_picture);
            sweetItem = view.findViewById(R.id.sweet_item);
            sweetPrice = view.findViewById(R.id.sweet_price);
            // view.setOnClickListener(new View.OnClickListener() {

            /*
            view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      //  Log.d("Recyclerview", "position =" + getAdapterPosition());
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

                        builder.setTitle("COSMOS").setMessage("주문을 도와드릴까요?");

                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(activity.getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
                            }
                        });

                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(activity.getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
                            }
                        });
                }
            });
            */
        }



            /*
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "주문을 도와드릴까요?" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
            */

    }




    ArrayList<SweetInfo> sweetInfoArrayList;
    public MyAdapter(ArrayList<SweetInfo> sweetInfoArrayList){
        this.sweetInfoArrayList = sweetInfoArrayList;
    }


    /*
    public MyAdapter(Context context, ArrayList<String> list) {
        super();
        this.context = context;
        this.unFilteredlist = list;
        this.filteredList = list;
    }
    */

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sweet_view, parent, false);

        return new SweetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        SweetViewHolder sweetViewHolder = (SweetViewHolder) holder;

        sweetViewHolder.sweetPicture.setImageResource(sweetInfoArrayList.get(position).drawableId);
        sweetViewHolder.sweetItem.setText(sweetInfoArrayList.get(position).item);
        sweetViewHolder.sweetPrice.setText(sweetInfoArrayList.get(position).price);

    }

    @Override
    public int getItemCount() {
        return sweetInfoArrayList.size();
    }





}