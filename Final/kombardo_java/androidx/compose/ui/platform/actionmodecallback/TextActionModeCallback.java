package androidx.compose.ui.platform.actionmodecallback;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.compose.ui.geometry.Rect;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001Bk\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0019\u0010\u0018J!\u0010\u001b\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010$\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\"\u0010#R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b&\u0010'R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\b-\u0010'\"\u0004\b.\u0010/R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010%\u001a\u0004\b0\u0010'\"\u0004\b1\u0010/R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010%\u001a\u0004\b2\u0010'\"\u0004\b3\u0010/R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010/¨\u00066"}, d2 = {"Landroidx/compose/ui/platform/actionmodecallback/TextActionModeCallback;", BuildConfig.FLAVOR, "Lkotlin/Function0;", BuildConfig.FLAVOR, "onActionModeDestroy", "Landroidx/compose/ui/geometry/Rect;", "rect", "onCopyRequested", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Landroid/view/Menu;", "menu", "Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;", "item", Callback.METHOD_NAME, "addOrRemoveMenuItem", "(Landroid/view/Menu;Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;Lkotlin/jvm/functions/Function0;)V", "Landroid/view/ActionMode;", "mode", BuildConfig.FLAVOR, "onCreateActionMode", "(Landroid/view/ActionMode;Landroid/view/Menu;)Z", "onPrepareActionMode", "Landroid/view/MenuItem;", "onActionItemClicked", "(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z", "onDestroyActionMode", "()V", "updateMenuItems$ui_release", "(Landroid/view/Menu;)V", "updateMenuItems", "addMenuItem$ui_release", "(Landroid/view/Menu;Landroidx/compose/ui/platform/actionmodecallback/MenuItemOption;)V", "addMenuItem", "Lkotlin/jvm/functions/Function0;", "getOnActionModeDestroy", "()Lkotlin/jvm/functions/Function0;", "Landroidx/compose/ui/geometry/Rect;", "getRect", "()Landroidx/compose/ui/geometry/Rect;", "setRect", "(Landroidx/compose/ui/geometry/Rect;)V", "getOnCopyRequested", "setOnCopyRequested", "(Lkotlin/jvm/functions/Function0;)V", "getOnPasteRequested", "setOnPasteRequested", "getOnCutRequested", "setOnCutRequested", "getOnSelectAllRequested", "setOnSelectAllRequested", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextActionModeCallback {
    private final Function0<Unit> onActionModeDestroy;
    private Function0<Unit> onCopyRequested;
    private Function0<Unit> onCutRequested;
    private Function0<Unit> onPasteRequested;
    private Function0<Unit> onSelectAllRequested;
    private Rect rect;

    public TextActionModeCallback(Function0<Unit> function0, Rect rect, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05) {
        this.onActionModeDestroy = function0;
        this.rect = rect;
        this.onCopyRequested = function02;
        this.onPasteRequested = function03;
        this.onCutRequested = function04;
        this.onSelectAllRequested = function05;
    }

    private final void addOrRemoveMenuItem(Menu menu, MenuItemOption item, Function0<Unit> callback) {
        if (callback != null && menu.findItem(item.getId()) == null) {
            addMenuItem$ui_release(menu, item);
        } else {
            if (callback != null || menu.findItem(item.getId()) == null) {
                return;
            }
            menu.removeItem(item.getId());
        }
    }

    public final void addMenuItem$ui_release(Menu menu, MenuItemOption item) {
        menu.add(0, item.getId(), item.getOrder(), item.getTitleResource()).setShowAsAction(1);
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        Intrinsics.checkNotNull(item);
        int itemId = item.getItemId();
        if (itemId == MenuItemOption.Copy.getId()) {
            Function0<Unit> function0 = this.onCopyRequested;
            if (function0 != null) {
                function0.invoke();
            }
        } else if (itemId == MenuItemOption.Paste.getId()) {
            Function0<Unit> function02 = this.onPasteRequested;
            if (function02 != null) {
                function02.invoke();
            }
        } else if (itemId == MenuItemOption.Cut.getId()) {
            Function0<Unit> function03 = this.onCutRequested;
            if (function03 != null) {
                function03.invoke();
            }
        } else {
            if (itemId != MenuItemOption.SelectAll.getId()) {
                return false;
            }
            Function0<Unit> function04 = this.onSelectAllRequested;
            if (function04 != null) {
                function04.invoke();
            }
        }
        if (mode == null) {
            return true;
        }
        mode.finish();
        return true;
    }

    public final boolean onCreateActionMode(ActionMode mode, Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null menu");
        }
        if (mode == null) {
            throw new IllegalArgumentException("onCreateActionMode requires a non-null mode");
        }
        if (this.onCopyRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Copy);
        }
        if (this.onPasteRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Paste);
        }
        if (this.onCutRequested != null) {
            addMenuItem$ui_release(menu, MenuItemOption.Cut);
        }
        if (this.onSelectAllRequested == null) {
            return true;
        }
        addMenuItem$ui_release(menu, MenuItemOption.SelectAll);
        return true;
    }

    public final void onDestroyActionMode() {
        Function0<Unit> function0 = this.onActionModeDestroy;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        if (mode == null || menu == null) {
            return false;
        }
        updateMenuItems$ui_release(menu);
        return true;
    }

    public final void setOnCopyRequested(Function0<Unit> function0) {
        this.onCopyRequested = function0;
    }

    public final void setOnCutRequested(Function0<Unit> function0) {
        this.onCutRequested = function0;
    }

    public final void setOnPasteRequested(Function0<Unit> function0) {
        this.onPasteRequested = function0;
    }

    public final void setOnSelectAllRequested(Function0<Unit> function0) {
        this.onSelectAllRequested = function0;
    }

    public final void setRect(Rect rect) {
        this.rect = rect;
    }

    public final void updateMenuItems$ui_release(Menu menu) {
        addOrRemoveMenuItem(menu, MenuItemOption.Copy, this.onCopyRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Paste, this.onPasteRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.Cut, this.onCutRequested);
        addOrRemoveMenuItem(menu, MenuItemOption.SelectAll, this.onSelectAllRequested);
    }

    public /* synthetic */ TextActionModeCallback(Function0 function0, Rect rect, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : function0, (i5 & 2) != 0 ? Rect.INSTANCE.getZero() : rect, (i5 & 4) != 0 ? null : function02, (i5 & 8) != 0 ? null : function03, (i5 & 16) != 0 ? null : function04, (i5 & 32) != 0 ? null : function05);
    }
}
