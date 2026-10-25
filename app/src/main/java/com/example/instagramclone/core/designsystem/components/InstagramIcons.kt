package com.example.instagramclone.core.designsystem.components

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.instagramclone.core.designsystem.components.icons.ActionIcons
import com.example.instagramclone.core.designsystem.components.icons.NavigationIcons
import com.example.instagramclone.core.designsystem.components.icons.SystemIcons
import com.example.instagramclone.core.designsystem.components.icons.TabIcons

/**
 * Unified facade for all Instagram vector icons.
 * Segregated internally into specialized modules:
 * - [NavigationIcons]: Home, Search, Create, Reels (Regular & Filled)
 * - [ActionIcons]: Heart, Comment, Share, Bookmark, Repost
 * - [TabIcons]: GridTab, TaggedTab
 * - [SystemIcons]: MoreHorizontal, VerifiedBadge, DropdownCaret, Threads, TuneSliders
 */
object InstagramIcons {

    // MARK: - Navigation Icons
    inline val Home: ImageVector get() = NavigationIcons.Home
    inline val HomeFilled: ImageVector get() = NavigationIcons.HomeFilled
    inline val Search: ImageVector get() = NavigationIcons.Search
    inline val SearchFilled: ImageVector get() = NavigationIcons.SearchFilled
    inline val Create: ImageVector get() = NavigationIcons.Create
    inline val CreateFilled: ImageVector get() = NavigationIcons.CreateFilled
    inline val Reels: ImageVector get() = NavigationIcons.Reels
    inline val ReelsFilled: ImageVector get() = NavigationIcons.ReelsFilled

    // MARK: - Post Actions
    inline val Heart: ImageVector get() = ActionIcons.Heart
    inline val HeartFilled: ImageVector get() = ActionIcons.HeartFilled
    inline val Comment: ImageVector get() = ActionIcons.Comment
    inline val Share: ImageVector get() = ActionIcons.Share
    inline val Bookmark: ImageVector get() = ActionIcons.Bookmark
    inline val BookmarkFilled: ImageVector get() = ActionIcons.BookmarkFilled
    inline val Repost: ImageVector get() = ActionIcons.Repost

    // MARK: - Profile Tabs
    inline val GridTab: ImageVector get() = TabIcons.GridTab
    inline val TaggedTab: ImageVector get() = TabIcons.TaggedTab

    // MARK: - System / Control Icons
    inline val MoreHorizontal: ImageVector get() = SystemIcons.MoreHorizontal
    inline val VerifiedBadge: ImageVector get() = SystemIcons.VerifiedBadge
    inline val DropdownCaret: ImageVector get() = SystemIcons.DropdownCaret
    inline val Threads: ImageVector get() = SystemIcons.Threads
    inline val TuneSliders: ImageVector get() = SystemIcons.TuneSliders
}
