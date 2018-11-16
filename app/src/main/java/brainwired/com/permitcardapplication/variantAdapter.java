package brainwired.com.permitcardapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class variantAdapter extends RecyclerView.Adapter<variantAdapter.variantViewHolder> {
    private List<variant> variantList;
    private Context context;

    private static int currentPosition = 0;

    public variantAdapter(List<variant> variantList, Context context) {
        this.variantList = variantList;
        this.context = context;
    }

    @Override
    public variantAdapter.variantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_variants, parent, false);
        return new variantAdapter.variantViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final variantAdapter.variantViewHolder holder, final int position) {
        variant variant = variantList.get(position);
        holder.textViewName.setText(variant.getName());

        holder.linearLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);
        }

        holder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting the position of the item to expand it
                currentPosition = position;

                //reloding the list
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return variantList.size();
    }

    class variantViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;

        LinearLayout linearLayout;

        variantViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);




            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}

