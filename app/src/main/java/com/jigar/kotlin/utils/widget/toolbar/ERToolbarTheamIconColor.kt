package com.jigar.kotlin.utils.widget.toolbar

import android.content.Context
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import android.util.AttributeSet
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.jigar.kotlin.R
import com.jigar.kotlin.data.local.pref.AppPreferencesHelper
import com.jigar.kotlin.utils.AppConstants


class ERToolbarTheamIconColor(context: Context, attrs: AttributeSet) : Toolbar(context, attrs) {

    init {
//        val tintColor: Int = AppPreferencesHelper(context, AppConstants.PREF_NAME).getAppColor()
        val tintColor: Int = ContextCompat.getColor(context, R.color.white)
        setTitleTextColor(tintColor)
        setSubtitleTextColor(tintColor)
        val upArrow = navigationIcon
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            upArrow!!.colorFilter = BlendModeColorFilter(tintColor, BlendMode.SRC_ATOP)
        } else {
            upArrow!!.setColorFilter(tintColor, PorterDuff.Mode.SRC_ATOP)
        }
        navigationIcon = upArrow
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
    }

    override fun inflateMenu(resId: Int) {
        super.inflateMenu(resId)

        val menu = menu
//        val tintColor =
//            AppPreferencesHelper(context, AppConstants.PREF_NAME).getAppColor()
        MenuTintUtils.tintAllIcons(menu, ContextCompat.getColor(context, R.color.white), context)
    }
}