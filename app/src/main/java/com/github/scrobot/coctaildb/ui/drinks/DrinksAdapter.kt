package com.github.scrobot.coctaildb.ui.drinks

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.business.model.DrinkPreview
import com.github.scrobot.coctaildb.utils.GlideApp
import com.github.scrobot.coctaildb.utils.inflate
import kotlinx.android.synthetic.main.adapter_view_category_label.view.*
import kotlinx.android.synthetic.main.adapter_view_drink_preview.view.*
import java.lang.IllegalArgumentException

class DrinksAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<Any>()

    fun load(map: Map<String, List<DrinkPreview>>) {
        list.clear()
        map.entries.forEach {
            list.add(it.key)
            list.addAll(it.value)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
        0 -> LabelViewHolder(parent.inflate(R.layout.adapter_view_category_label))
        1 -> DrinkViewHolder(parent.inflate(R.layout.adapter_view_drink_preview))
        else -> throw IllegalArgumentException("wrong view type")
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is LabelViewHolder -> holder.bind(list[position] as String)
            is DrinkViewHolder -> holder.bind(list[position] as DrinkPreview)
        }
    }

    override fun getItemViewType(position: Int) = when(list[position]) {
        is String -> 0
        is DrinkPreview -> 1
        else -> throw IllegalArgumentException("wrong model in adapter list. Supported only String and DrinksPreview")
    }

    class LabelViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(category: String) {
            view.vCategory.text = category
        }

    }

    class DrinkViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(preview: DrinkPreview) {
            GlideApp.with(view)
                .load(preview.thumb)
                .placeholder(R.drawable.placeholder)
                .into(view.vPreview)

            view.vDrinkName.text = preview.name
        }

    }

}