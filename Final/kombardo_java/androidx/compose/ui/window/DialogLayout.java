package androidx.compose.ui.window;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AbstractComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\fH\u0017¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R7\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u000e\u0010)R\"\u0010*\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00168\u0014@RX\u0094\u000e¢\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-R\u0014\u00104\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0014\u00106\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u00103¨\u00067"}, d2 = {"Landroidx/compose/ui/window/DialogLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/window/DialogWindowProvider;", "Landroid/content/Context;", "context", "Landroid/view/Window;", "window", "<init>", "(Landroid/content/Context;Landroid/view/Window;)V", "Landroidx/compose/runtime/CompositionContext;", "parent", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "setContent", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure$ui_release", "(II)V", "internalOnMeasure", BuildConfig.FLAVOR, "changed", "left", "top", "right", "bottom", "internalOnLayout$ui_release", "(ZIIII)V", "internalOnLayout", "Content", "(Landroidx/compose/runtime/Composer;I)V", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "<set-?>", "content$delegate", "Landroidx/compose/runtime/MutableState;", "getContent", "()Lkotlin/jvm/functions/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "usePlatformDefaultWidth", "Z", "getUsePlatformDefaultWidth", "()Z", "setUsePlatformDefaultWidth", "(Z)V", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "getDisplayWidth", "()I", "displayWidth", "getDisplayHeight", "displayHeight", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DialogLayout extends AbstractComposeView implements DialogWindowProvider {

    /* renamed from: content$delegate, reason: from kotlin metadata */
    private final MutableState content;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private boolean usePlatformDefaultWidth;
    private final Window window;

    public DialogLayout(Context context, Window window) {
        super(context, null, 0, 6, null);
        MutableState mutableStateOf$default;
        this.window = window;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$AndroidDialog_androidKt.INSTANCE.m2717getLambda1$ui_release(), null, 2, null);
        this.content = mutableStateOf$default;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content.getValue();
    }

    private final int getDisplayHeight() {
        return Math.round(getContext().getResources().getConfiguration().screenHeightDp * getContext().getResources().getDisplayMetrics().density);
    }

    private final int getDisplayWidth() {
        return Math.round(getContext().getResources().getConfiguration().screenWidthDp * getContext().getResources().getDisplayMetrics().density);
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content.setValue(function2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1735448596);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1735448596, i6, -1, "androidx.compose.ui.window.DialogLayout.Content (AndroidDialog.android.kt:280)");
            }
            getContent().invoke(startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.DialogLayout$Content$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    DialogLayout.this.Content(composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final boolean getUsePlatformDefaultWidth() {
        return this.usePlatformDefaultWidth;
    }

    @Override // androidx.compose.ui.window.DialogWindowProvider
    public Window getWindow() {
        return this.window;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnLayout$ui_release(boolean changed, int left, int top, int right, int bottom) {
        View childAt;
        super.internalOnLayout$ui_release(changed, left, top, right, bottom);
        if (this.usePlatformDefaultWidth || (childAt = getChildAt(0)) == null) {
            return;
        }
        getWindow().setLayout(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui_release(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.usePlatformDefaultWidth) {
            super.internalOnMeasure$ui_release(widthMeasureSpec, heightMeasureSpec);
        } else {
            super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(getDisplayWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getDisplayHeight(), Integer.MIN_VALUE));
        }
    }

    public final void setUsePlatformDefaultWidth(boolean z5) {
        this.usePlatformDefaultWidth = z5;
    }

    public final void setContent(CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
        createComposition();
    }
}
