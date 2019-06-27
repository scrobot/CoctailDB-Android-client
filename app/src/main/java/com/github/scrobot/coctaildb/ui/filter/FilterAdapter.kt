package com.github.scrobot.coctaildb.ui.filter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.utils.inflate
import kotlinx.android.synthetic.main.adapter_view_filter_item.view.*

class FilterAdapter: RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    private val categoriesList = mutableListOf<DrinkCategory>()

    fun load(list: List<DrinkCategory>) {
        categoriesList.clear()
        categoriesList.addAll(list)
        notifyDataSetChanged()
    }

    fun getFilterChanges() = categoriesList.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(parent.inflate(R.layout.adapter_view_filter_item))

    override fun getItemCount() = categoriesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoriesList[position]) { isClicked ->
            categoriesList[position].isChecked = isClicked
            notifyItemChanged(position)
        }
    }

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(category: DrinkCategory, onClickCallback: (Boolean) -> Unit) {
            view.vLabel.text = category.categoryId
            view.vCheck.visibility = if(category.isChecked) View.VISIBLE else View.GONE
            view.vContainer.setOnClickListener {
                onClickCallback(!category.isChecked)
            }
        }

    }

}