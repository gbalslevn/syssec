package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenuItem;

/* loaded from: classes.dex */
public abstract class MenuItemCompat {
    private static final String TAG = "MenuItemCompat";

    /* loaded from: classes.dex */
    static class Api26Impl {
        static MenuItem setAlphabeticShortcut(MenuItem menuItem, char c5, int i5) {
            return menuItem.setAlphabeticShortcut(c5, i5);
        }

        static MenuItem setContentDescription(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setContentDescription(charSequence);
        }

        static MenuItem setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
            return menuItem.setIconTintList(colorStateList);
        }

        static MenuItem setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
            return menuItem.setIconTintMode(mode);
        }

        static MenuItem setNumericShortcut(MenuItem menuItem, char c5, int i5) {
            return menuItem.setNumericShortcut(c5, i5);
        }

        static MenuItem setTooltipText(MenuItem menuItem, CharSequence charSequence) {
            return menuItem.setTooltipText(charSequence);
        }
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c5, int i5) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c5, i5);
        } else {
            Api26Impl.setAlphabeticShortcut(menuItem, c5, i5);
        }
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else {
            Api26Impl.setContentDescription(menuItem, charSequence);
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else {
            Api26Impl.setIconTintList(menuItem, colorStateList);
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else {
            Api26Impl.setIconTintMode(menuItem, mode);
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c5, int i5) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c5, i5);
        } else {
            Api26Impl.setNumericShortcut(menuItem, c5, i5);
        }
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else {
            Api26Impl.setTooltipText(menuItem, charSequence);
        }
    }
}
