package me.hd.xiaoliurenplus.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import me.hd.xiaoliurenplus.databinding.ViewDiscBinding

class DiscView(
    context: Context,
    attributeSet: AttributeSet? = null
) : LinearLayout(context, attributeSet) {
    var binding: ViewDiscBinding

    init {
        binding = ViewDiscBinding.inflate(LayoutInflater.from(context), this, true)
    }
}