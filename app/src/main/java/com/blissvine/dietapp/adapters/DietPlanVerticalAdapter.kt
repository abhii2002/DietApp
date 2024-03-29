package com.blissvine.dietapp.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blissvine.dietapp.R
import com.blissvine.dietapp.models.DietPlanModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dietplan_list_item.view.*



class DietPlanVerticalAdapter (private val dishesList: List<DietPlanModel>) : RecyclerView.Adapter<DietPlanVerticalAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val dietDishTitle: TextView = itemView.tv_dietDishTitle
        val dietDishImage: ImageView = itemView.dietDishImage
        val kcalValue: TextView = itemView.tv_kcalValue
        val timeValue: TextView = itemView.tv_timeValue
        val difficulty: TextView = itemView.btnColorPrimary
        val steps: TextView = itemView.btnColorSecondary
        val btnPrimaryColor = itemView.btnColorPrimary
        val btnSecondaryColor = itemView.btnColorSecondary
        val view = itemView
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dietplan_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DietPlanVerticalAdapter.ViewHolder, position: Int) {
       val dishesList = dishesList[position]
        holder.dietDishTitle.text = dishesList.name
        holder.difficulty.text = dishesList.difficulty
        holder.steps.text = dishesList.steps
        holder.kcalValue.text = dishesList.kcalValue
        holder.timeValue.text = dishesList.preparationTime
        holder.steps.setTextColor(Color.parseColor(dishesList.stepsColor))
        holder.btnPrimaryColor.backgroundTintList = ColorStateList.valueOf(dishesList.colorPrimary)
        holder.btnSecondaryColor.backgroundTintList = ColorStateList.valueOf(dishesList.colorSecondary)


        Picasso.get().load(dishesList.image).into(holder.dietDishImage)
    }

    override fun getItemCount(): Int {
        return dishesList.size
    }
}