package com.xq.nestedbehaviordemo

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

open class NestedRecycleView : RecyclerView {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    var scrollByOutsideView = false
    protected var bottomSheetBehavior: SNBBottomSheetBehavior<View>? = null
    private var placeholderView: View? = null
    private var totalDy: Int = 0

    init {
        addOnScrollListener(object : OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalDy += dy
                if (!scrollByOutsideView) {
                    bottomSheetBehavior?.let {
                        val isPlaceholderViewVisible = isPlaceholderViewVisible()
                        it.setSlideByOutsideView(isPlaceholderViewVisible)
                        it.setOutsideView(this@NestedRecycleView)

                        val slideHeight = measuredHeight - (placeholderView!!.top - totalDy) + it.peekHeight

                        if (isPlaceholderViewVisible) {
                            it.slideHeight = slideHeight
                        }
                    }
                }

                scrollByOutsideView = false
            }
        })
    }

    fun bindSNBBottomSheetBehavior(bottomSheetBehavior: SNBBottomSheetBehavior<View>) {
        if (this.bottomSheetBehavior != null) {
            return
        }

        this.bottomSheetBehavior = bottomSheetBehavior
        placeholderView = View(context)
        placeholderView?.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, bottomSheetBehavior.getCollapsedOffset())
        val firstChildView = getChildAt(0) as ViewGroup
        firstChildView.addView(placeholderView)
    }

    private fun isPlaceholderViewVisible(): Boolean {
        if (placeholderView == null) {
            return false
        }

        val scrollBounds = Rect()
        getHitRect(scrollBounds)
        return placeholderView!!.getLocalVisibleRect(scrollBounds)
    }

}