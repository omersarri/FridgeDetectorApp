package com.omersari.hesaplama.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omersari.hesaplama.databinding.RecipeRowBinding;
import com.omersari.hesaplama.model.Recipe;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {
    private final RecyclerViewInterface recyclerViewInterface;



    public RecipeAdapter(List<Recipe> recipeList, RecyclerViewInterface recyclerViewInterface) {
        this.recipeList = recipeList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    private List<Recipe> recipeList;

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecipeRowBinding recyclerRowBinding = RecipeRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RecipeHolder(recyclerRowBinding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        holder.binding.textView1.setText(recipeList.get(position).name);
        holder.binding.textView2.setText(recipeList.get(position).prepTime + "Preparation");
        holder.binding.textView3.setText(recipeList.get(position).cookTime + "Cooking");
        //holder.binding.cardView.setCardBackgroundColor(wordList.get(position).color);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }


    public class RecipeHolder extends RecyclerView.ViewHolder {
        private RecipeRowBinding binding;
        public RecipeHolder(RecipeRowBinding binding, RecyclerViewInterface recyclerViewInterface) {
            super(binding.getRoot());
            this.binding = binding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if(recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemLongClick(pos);
                        }
                    }
                    return true;
                }
            });

        }
    }


}