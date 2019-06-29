package com.github.scrobot.coctaildb.ui.filter

import androidx.recyclerview.widget.DiffUtil
import com.github.scrobot.coctaildb.business.model.DrinkCategory
import timber.log.Timber

class FilterDIffUtil(
    private val oldList: List<DrinkCategory>,
    private val newList: List<DrinkCategory>
): DiffUtil.Callback() {

    fun updateNewList(list: List<DrinkCategory>): FilterDIffUtil {
        with(newList.toMutableList()) {
            clear()
            addAll(list)
        }

        return this
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Timber.d("old -> ${oldList[oldItemPosition]}; new -> ${newList[newItemPosition]}")

        return oldList[oldItemPosition].categoryId == newList[newItemPosition].categoryId &&
                oldList[oldItemPosition].isChecked == newList[newItemPosition].isChecked
    }
}