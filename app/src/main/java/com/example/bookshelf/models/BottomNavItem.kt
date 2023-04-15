package com.example.bookshelf.models

import androidx.compose.ui.graphics.painter.Painter
import com.example.bookshelf.config.BottomNavBarItemType

data class BottomNavItem(
    val type: BottomNavBarItemType,
    val label: String,
    val route: String,
    val icon: Painter
)