package kr.ddd.a2.ui.home.model

import kr.ddd.a2.base.DisplayModel

data class MeetingListUiModel(
    val emoji: String? = null,
    val title: String,
) : DisplayModel {
    val visibleEmoji get() =
        !emoji.isNullOrBlank()
}