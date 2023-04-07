package com.blissvine.dietapp.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.blissvine.dietapp.R
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.rv_ingredients_item.view.*
import kotlinx.android.synthetic.main.vertical_recyclerview_item.view.*

class IngredientsItemAdapter(private val ingredients: IntArray)
    : RecyclerView.Adapter<IngredientsItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val ingredientImages : ImageView = itemView.IVingredients
        val view = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_ingredients_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
              val dishImages = ingredients[position]
     //  Picasso.get().load(ingredients[position]).into(holder.ingredientImages)
         holder.ingredientImages.setImageDrawable(holder.view.context.getDrawable(dishImages))


    }

    override fun getItemCount(): Int {
         return  ingredients.size
    }

    operator fun get(position: Int): Any {
          return position
    }


}