package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;

/* loaded from: classes.dex */
public class MenuPopupHelper {
    private static final int TOUCH_EPICENTER_SIZE_DP = 48;
    private View mAnchorView;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    private final PopupWindow.OnDismissListener mInternalOnDismissListener;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private MenuPopup mPopup;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z5, int i5) {
        this(context, menuBuilder, view, z5, i5, 0);
    }

    private MenuPopup createPopup() {
        Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        MenuPopup cascadingMenuPopup = Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly) : new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
        cascadingMenuPopup.addMenu(this.mMenu);
        cascadingMenuPopup.setOnDismissListener(this.mInternalOnDismissListener);
        cascadingMenuPopup.setAnchorView(this.mAnchorView);
        cascadingMenuPopup.setCallback(this.mPresenterCallback);
        cascadingMenuPopup.setForceShowIcon(this.mForceShowIcon);
        cascadingMenuPopup.setGravity(this.mDropDownGravity);
        return cascadingMenuPopup;
    }

    private void showPopup(int i5, int i6, boolean z5, boolean z6) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z6);
        if (z5) {
            if ((GravityCompat.getAbsoluteGravity(this.mDropDownGravity, this.mAnchorView.getLayoutDirection()) & 7) == 5) {
                i5 -= this.mAnchorView.getWidth();
            }
            popup.setHorizontalOffset(i5);
            popup.setVerticalOffset(i6);
            int i7 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new Rect(i5 - i7, i6 - i7, i5 + i7, i6 + i7));
        }
        popup.show();
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public MenuPopup getPopup() {
        if (this.mPopup == null) {
            this.mPopup = createPopup();
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        MenuPopup menuPopup = this.mPopup;
        return menuPopup != null && menuPopup.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setForceShowIcon(boolean z5) {
        this.mForceShowIcon = z5;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setForceShowIcon(z5);
        }
    }

    public void setGravity(int i5) {
        this.mDropDownGravity = i5;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z5, int i5, int i6) {
        this.mDropDownGravity = 8388611;
        this.mInternalOnDismissListener = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.onDismiss();
            }
        };
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z5;
        this.mPopupStyleAttr = i5;
        this.mPopupStyleRes = i6;
    }

    public boolean tryShow(int i5, int i6) {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(i5, i6, true, true);
        return true;
    }
}
