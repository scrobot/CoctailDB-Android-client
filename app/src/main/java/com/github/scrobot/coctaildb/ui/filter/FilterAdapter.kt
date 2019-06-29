package com.github.scrobot.coctaildb.ui.filter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.scrobot.coctaildb.R
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import com.github.scrobot.coctaildb.utils.inflate
import kotlinx.android.synthetic.main.adapter_view_filter_item.view.*
import timber.log.Timber

class FilterAdapter(
    private val filterListChangesListener: FilterListChangesListener
): RecyclerView.Adapter<FilterAdapter.ViewHolder>() {

    private val originalList = mutableListOf<DrinkCategory>()
    private val categoriesList = mutableListOf<DrinkCategory>()
    lateinit var diffUtil: FilterDIffUtil

    fun load(list: List<DrinkCategory>) {
        if(originalList.isEmpty()) {
            originalList.addAll(list)
        }

        categoriesList.clear()
        categoriesList.addAll(list)

        diffUtil = FilterDIffUtil(originalList, categoriesList)
//        DiffUtil.calculateDiff(diffUtil).dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    fun updateOldList() {
        originalList.clear()
        originalList.addAll(categoriesList)
        diffUtil = FilterDIffUtil(originalList, categoriesList)
    }

    fun getFilterChanges() = categoriesList.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(parent.inflate(R.layout.adapter_view_filter_item))

    override fun getItemCount() = categoriesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoriesList[position]
        holder.bind(category) { isChecked ->
            categoriesList[position] = DrinkCategory(category.categoryId, isChecked)
            notifyItemChanged(position)

            diffUtil.updateNewList(categoriesList)
            filterListChangesListener.isFilterChanges(areListsEquals())
        }
    }

    private fun areListsEquals(): Boolean {
        if(originalList.size != categoriesList.size) return false

        for (i in 0 until originalList.size) {
            if(!diffUtil.areContentsTheSame(i, i))
                return false
        }
        Timber.d("//-----------------\\\\//-----------------\\\\")

        return true
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