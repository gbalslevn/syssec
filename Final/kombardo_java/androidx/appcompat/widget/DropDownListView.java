package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class DropDownListView extends ListView {
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding;
    private int mSelectionLeftPadding;
    private int mSelectionRightPadding;
    private int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        static void drawableHotspotChanged(View view, float f5, float f6) {
            view.drawableHotspotChanged(f5, f6);
        }
    }

    /* loaded from: classes.dex */
    static class Api30Impl {
        private static boolean sHasMethods;
        private static Method sPositionSelector;
        private static Method sSetNextSelectedPositionInt;
        private static Method sSetSelectedPositionInt;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                sPositionSelector = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                sSetSelectedPositionInt = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                sSetNextSelectedPositionInt = declaredMethod3;
                declaredMethod3.setAccessible(true);
                sHasMethods = true;
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
            }
        }

        static boolean canPositionSelectorForHoveredItem() {
            return sHasMethods;
        }

        @SuppressLint({"BanUncheckedReflection"})
        static void positionSelectorForHoveredItem(DropDownListView dropDownListView, int i5, View view) {
            try {
                sPositionSelector.invoke(dropDownListView, Integer.valueOf(i5), view, Boolean.FALSE, -1, -1);
                sSetSelectedPositionInt.invoke(dropDownListView, Integer.valueOf(i5));
                sSetNextSelectedPositionInt.invoke(dropDownListView, Integer.valueOf(i5));
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api33Impl {
        static boolean isSelectedChildViewEnabled(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void setSelectedChildViewEnabled(AbsListView absListView, boolean z5) {
            absListView.setSelectedChildViewEnabled(z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class GateKeeperDrawable extends DrawableWrapperCompat {
        private boolean mEnabled;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            this.mEnabled = true;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.mEnabled) {
                super.draw(canvas);
            }
        }

        void setEnabled(boolean z5) {
            this.mEnabled = z5;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspot(float f5, float f6) {
            if (this.mEnabled) {
                super.setHotspot(f5, f6);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i5, int i6, int i7, int i8) {
            if (this.mEnabled) {
                super.setHotspotBounds(i5, i6, i7, i8);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.mEnabled) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z5, boolean z6) {
            if (this.mEnabled) {
                return super.setVisible(z5, z6);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PreApi33Impl {
        private static final Field sIsChildViewEnabled;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e5) {
                e5.printStackTrace();
            }
            sIsChildViewEnabled = field;
        }

        static boolean isSelectedChildViewEnabled(AbsListView absListView) {
            Field field = sIsChildViewEnabled;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
                return false;
            }
        }

        static void setSelectedChildViewEnabled(AbsListView absListView, boolean z5) {
            Field field = sIsChildViewEnabled;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z5));
                } catch (IllegalAccessException e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        public void cancel() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.removeCallbacks(this);
        }

        public void post() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.drawableStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DropDownListView(Context context, boolean z5) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = z5;
        setCacheColorHint(0);
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
    }

    private void clickPressedItem(View view, int i5) {
        performItemClick(view, i5, getItemIdAtPosition(i5));
    }

    private void drawSelectorCompat(Canvas canvas) {
        Drawable selector;
        if (this.mSelectorRect.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.mSelectorRect);
        selector.draw(canvas);
    }

    private void positionSelectorCompat(int i5, View view) {
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.mSelectionLeftPadding;
        rect.top -= this.mSelectionTopPadding;
        rect.right += this.mSelectionRightPadding;
        rect.bottom += this.mSelectionBottomPadding;
        boolean superIsSelectedChildViewEnabled = superIsSelectedChildViewEnabled();
        if (view.isEnabled() != superIsSelectedChildViewEnabled) {
            superSetSelectedChildViewEnabled(!superIsSelectedChildViewEnabled);
            if (i5 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void positionSelectorLikeFocusCompat(int i5, View view) {
        Drawable selector = getSelector();
        boolean z5 = (selector == null || i5 == -1) ? false : true;
        if (z5) {
            selector.setVisible(false, false);
        }
        positionSelectorCompat(i5, view);
        if (z5) {
            Rect rect = this.mSelectorRect;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.setHotspot(selector, exactCenterX, exactCenterY);
        }
    }

    private void positionSelectorLikeTouchCompat(int i5, View view, float f5, float f6) {
        positionSelectorLikeFocusCompat(i5, view);
        Drawable selector = getSelector();
        if (selector == null || i5 == -1) {
            return;
        }
        DrawableCompat.setHotspot(selector, f5, f6);
    }

    private void setPressedItem(View view, int i5, float f5, float f6) {
        View childAt;
        this.mDrawsInPressedState = true;
        Api21Impl.drawableHotspotChanged(this, f5, f6);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i6 = this.mMotionPosition;
        if (i6 != -1 && (childAt = getChildAt(i6 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.mMotionPosition = i5;
        Api21Impl.drawableHotspotChanged(view, f5 - view.getLeft(), f6 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i5, view, f5, f6);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void setSelectorEnabled(boolean z5) {
        GateKeeperDrawable gateKeeperDrawable = this.mSelector;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.setEnabled(z5);
        }
    }

    private boolean superIsSelectedChildViewEnabled() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.isSelectedChildViewEnabled(this) : PreApi33Impl.isSelectedChildViewEnabled(this);
    }

    private void superSetSelectedChildViewEnabled(boolean z5) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setSelectedChildViewEnabled(this, z5);
        } else {
            PreApi33Impl.setSelectedChildViewEnabled(this, z5);
        }
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void updateSelectorStateCompat() {
        Drawable selector = getSelector();
        if (selector != null && touchModeDrawsInPressedStateCompat() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        drawSelectorCompat(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.mResolveHoverRunnable != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        updateSelectorStateCompat();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.mHijackFocus || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.mHijackFocus || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.mHijackFocus || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }

    public int measureHeightOfChildrenCompat(int i5, int i6, int i7, int i8, int i9) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i10 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        View view = null;
        while (i11 < count) {
            int itemViewType = adapter.getItemViewType(i11);
            if (itemViewType != i12) {
                view = null;
                i12 = itemViewType;
            }
            view = adapter.getView(i11, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i14 = layoutParams.height;
            view.measure(i5, i14 > 0 ? View.MeasureSpec.makeMeasureSpec(i14, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i11 > 0) {
                i10 += dividerHeight;
            }
            i10 += view.getMeasuredHeight();
            if (i10 >= i8) {
                return (i9 < 0 || i11 <= i9 || i13 <= 0 || i10 == i8) ? i8 : i13;
            }
            if (i9 >= 0 && i11 >= i9) {
                i13 = i10;
            }
            i11++;
        }
        return i10;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onForwardedEvent(MotionEvent motionEvent, int i5) {
        boolean z5;
        boolean z6;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z5 = false;
        } else if (actionMasked == 2) {
            z5 = true;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i5);
        if (findPointerIndex >= 0) {
            int x5 = (int) motionEvent.getX(findPointerIndex);
            int y5 = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x5, y5);
            if (pointToPosition != -1) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                setPressedItem(childAt, pointToPosition, x5, y5);
                if (actionMasked == 1) {
                    clickPressedItem(childAt, pointToPosition);
                }
                z5 = true;
                z6 = false;
                if (z5) {
                }
                clearPressedItem();
                if (z5) {
                }
                return z5;
            }
            z6 = true;
            if (z5 || z6) {
                clearPressedItem();
            }
            if (z5) {
                if (this.mScrollHelper == null) {
                    this.mScrollHelper = new ListViewAutoScrollHelper(this);
                }
                this.mScrollHelper.setEnabled(true);
                this.mScrollHelper.onTouch(this, motionEvent);
            } else {
                ListViewAutoScrollHelper listViewAutoScrollHelper = this.mScrollHelper;
                if (listViewAutoScrollHelper != null) {
                    listViewAutoScrollHelper.setEnabled(false);
                }
            }
            return z5;
        }
        z6 = false;
        z5 = false;
        if (z5) {
        }
        clearPressedItem();
        if (z5) {
        }
        return z5;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i5 = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.mResolveHoverRunnable == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.mResolveHoverRunnable = resolveHoverRunnable;
            resolveHoverRunnable.post();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i5 < 30 || !Api30Impl.canPositionSelectorForHoveredItem()) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        Api30Impl.positionSelectorForHoveredItem(this, pointToPosition, childAt);
                    }
                }
                updateSelectorStateCompat();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.mResolveHoverRunnable;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z5) {
        this.mListSelectionHidden = z5;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable = drawable != null ? new GateKeeperDrawable(drawable) : null;
        this.mSelector = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }
}
