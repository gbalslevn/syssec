package androidx.compose.foundation;

import android.support.v4.media.session.a;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a2\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t\u001a6\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002\u001a2\u0010\u0010\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\t¨\u0006\u0011"}, d2 = {"rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", BuildConfig.FLAVOR, "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "horizontalScroll", "Landroidx/compose/ui/Modifier;", "state", "enabled", BuildConfig.FLAVOR, "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "scroll", "isScrollable", "isVertical", "verticalScroll", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScrollKt {
    public static final Modifier horizontalScroll(Modifier modifier, ScrollState scrollState, boolean z5, FlingBehavior flingBehavior, boolean z6) {
        return scroll(modifier, scrollState, z6, flingBehavior, z5, false);
    }

    public static /* synthetic */ Modifier horizontalScroll$default(Modifier modifier, ScrollState scrollState, boolean z5, FlingBehavior flingBehavior, boolean z6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        if ((i5 & 4) != 0) {
            flingBehavior = null;
        }
        if ((i5 & 8) != 0) {
            z6 = false;
        }
        return horizontalScroll(modifier, scrollState, z5, flingBehavior, z6);
    }

    public static final ScrollState rememberScrollState(final int i5, Composer composer, int i6, int i7) {
        boolean z5 = true;
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1464256199, i6, -1, "androidx.compose.foundation.rememberScrollState (Scroll.kt:69)");
        }
        Object[] objArr = new Object[0];
        Saver<ScrollState, ?> saver = ScrollState.INSTANCE.getSaver();
        if ((((i6 & 14) ^ 6) <= 4 || !composer.changed(i5)) && (i6 & 6) != 4) {
            z5 = false;
        }
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0<ScrollState>() { // from class: androidx.compose.foundation.ScrollKt$rememberScrollState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final ScrollState invoke() {
                    return new ScrollState(i5);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        ScrollState scrollState = (ScrollState) RememberSaveableKt.rememberSaveable(objArr, saver, null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return scrollState;
    }

    private static final Modifier scroll(Modifier modifier, final ScrollState scrollState, final boolean z5, final FlingBehavior flingBehavior, final boolean z6, final boolean z7) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ScrollKt$scroll$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i5) {
                composer.startReplaceGroup(1478351300);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1478351300, i5, -1, "androidx.compose.foundation.scroll.<anonymous> (Scroll.kt:276)");
                }
                Modifier then = Modifier.INSTANCE.then(new ScrollSemanticsElement(ScrollState.this, z5, flingBehavior, z6, z7));
                ScrollState scrollState2 = ScrollState.this;
                Modifier then2 = ScrollingContainerKt.scrollingContainer(then, scrollState2, z7 ? Orientation.Vertical : Orientation.Horizontal, z6, z5, flingBehavior, scrollState2.getInternalInteractionSource(), null, composer, 0, 64).then(new ScrollingLayoutElement(ScrollState.this, z5, z7));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return then2;
            }
        });
    }

    public static final Modifier verticalScroll(Modifier modifier, ScrollState scrollState, boolean z5, FlingBehavior flingBehavior, boolean z6) {
        return scroll(modifier, scrollState, z6, flingBehavior, z5, true);
    }

    public static /* synthetic */ Modifier verticalScroll$default(Modifier modifier, ScrollState scrollState, boolean z5, FlingBehavior flingBehavior, boolean z6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        if ((i5 & 4) != 0) {
            flingBehavior = null;
        }
        if ((i5 & 8) != 0) {
            z6 = false;
        }
        return verticalScroll(modifier, scrollState, z5, flingBehavior, z6);
    }
}
