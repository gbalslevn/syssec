package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.ui.R$id;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\f\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0004\b\f\u0010\r\u001a-\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "container", "Landroidx/compose/runtime/CompositionContext;", "parent", "Landroidx/compose/runtime/ReusableComposition;", "createSubcomposition", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/runtime/CompositionContext;)Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "Landroidx/compose/runtime/Composition;", "setContent", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "Landroidx/compose/ui/platform/AndroidComposeView;", "owner", "doSetContent", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "Landroid/view/ViewGroup$LayoutParams;", "DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Wrapper_androidKt {
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static final ReusableComposition createSubcomposition(LayoutNode layoutNode, CompositionContext compositionContext) {
        return CompositionKt.ReusableComposition(new UiApplier(layoutNode), compositionContext);
    }

    private static final Composition doSetContent(AndroidComposeView androidComposeView, CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            int i5 = R$id.inspection_slot_table_set;
            if (androidComposeView.getTag(i5) == null) {
                androidComposeView.setTag(i5, Collections.newSetFromMap(new WeakHashMap()));
            }
        }
        Composition Composition = CompositionKt.Composition(new UiApplier(androidComposeView.getRoot()), compositionContext);
        View view = androidComposeView.getView();
        int i6 = R$id.wrapped_composition_tag;
        Object tag = view.getTag(i6);
        WrappedComposition wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, Composition);
            androidComposeView.getView().setTag(i6, wrappedComposition);
        }
        wrappedComposition.setContent(function2);
        if (!Intrinsics.areEqual(androidComposeView.getCoroutineContext(), compositionContext.getEffectCoroutineContext())) {
            androidComposeView.setCoroutineContext(compositionContext.getEffectCoroutineContext());
        }
        return wrappedComposition;
    }

    public static final Composition setContent(AbstractComposeView abstractComposeView, CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        AndroidComposeView androidComposeView = null;
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            if (childAt instanceof AndroidComposeView) {
                androidComposeView = (AndroidComposeView) childAt;
            }
        } else {
            abstractComposeView.removeAllViews();
        }
        if (androidComposeView == null) {
            androidComposeView = new AndroidComposeView(abstractComposeView.getContext(), compositionContext.getEffectCoroutineContext());
            abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
        }
        return doSetContent(androidComposeView, compositionContext, function2);
    }
}
