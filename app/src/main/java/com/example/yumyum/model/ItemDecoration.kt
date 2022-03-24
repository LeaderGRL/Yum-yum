package com.example.yumyum.model

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.yumyum.R
import com.example.yumyum.R.dimen

class ItemDecoration(var context: Context) : RecyclerView.ItemDecoration() {
    private var space: Int = 0
    private var extraMargin: Int = 0

    init {
        extraMargin =
            context.resources.getDimensionPixelOffset(R.dimen.default_padding)
    }

    fun spaceBetweenItem(space: Int) {
        this.space = space
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        //outRect.top = space
        outRect.bottom = space
        //outRect.left = space
        //outRect.right = space
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = space;
        }
    }
}