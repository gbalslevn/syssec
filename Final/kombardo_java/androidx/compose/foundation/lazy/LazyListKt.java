package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0095\u0001\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0097\u0001\u0010(\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0$2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006H\u0003¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/lazy/LazyListState;", "state", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", BuildConfig.FLAVOR, "reverseLayout", "isVertical", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "userScrollEnabled", BuildConfig.FLAVOR, "beyondBoundsItemCount", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "content", "LazyList", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "itemProviderLambda", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "stickyHeadersEnabled", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "rememberLazyListMeasurePolicy", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;ZLandroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyList(final Modifier modifier, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z5, final boolean z6, final FlingBehavior flingBehavior, final boolean z7, int i5, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Object rememberedValue;
        Composer composer2;
        final int i17;
        final Alignment.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        final Alignment.Vertical vertical4;
        final Arrangement.Horizontal horizontal4;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(620764179);
        if ((i8 & 1) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i9 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i9 = i6;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i8 & 4) != 0) {
            i9 |= 384;
        } else if ((i6 & 384) == 0) {
            i9 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
            if ((i8 & 8) == 0) {
                i9 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i9 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                if ((i8 & 16) != 0) {
                    i9 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    i9 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                }
                if ((i8 & 32) != 0) {
                    i9 |= 196608;
                } else if ((i6 & 196608) == 0) {
                    i9 |= startRestartGroup.changed(flingBehavior) ? 131072 : 65536;
                    if ((i8 & 64) == 0) {
                        i9 |= 1572864;
                    } else if ((i6 & 1572864) == 0) {
                        i9 |= startRestartGroup.changed(z7) ? 1048576 : 524288;
                    }
                    i10 = i8 & 128;
                    if (i10 == 0) {
                        i9 |= 12582912;
                    } else if ((i6 & 12582912) == 0) {
                        i9 |= startRestartGroup.changed(i5) ? 8388608 : 4194304;
                    }
                    i11 = i8 & 256;
                    if (i11 == 0) {
                        i9 |= 100663296;
                    } else if ((i6 & 100663296) == 0) {
                        i9 |= startRestartGroup.changed(horizontal) ? 67108864 : 33554432;
                    }
                    i12 = i8 & 512;
                    if (i12 == 0) {
                        i9 |= 805306368;
                    } else if ((i6 & 805306368) == 0) {
                        i9 |= startRestartGroup.changed(vertical) ? 536870912 : 268435456;
                    }
                    i13 = i8 & 1024;
                    if (i13 == 0) {
                        i14 = i7 | 6;
                    } else if ((i7 & 6) == 0) {
                        i14 = i7 | (startRestartGroup.changed(vertical2) ? 4 : 2);
                    } else {
                        i14 = i7;
                    }
                    i15 = i8 & 2048;
                    if (i15 == 0) {
                        i14 |= 48;
                    } else if ((i7 & 48) == 0) {
                        i14 |= startRestartGroup.changed(horizontal2) ? 32 : 16;
                    }
                    i16 = i14;
                    if ((i8 & 4096) == 0) {
                        i16 |= 384;
                    } else if ((i7 & 384) == 0) {
                        i16 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
                    }
                    if ((306783379 & i9) != 306783378 && (i16 & 147) == 146 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        i17 = i5;
                        horizontal3 = horizontal;
                        vertical4 = vertical2;
                        horizontal4 = horizontal2;
                        composer2 = startRestartGroup;
                        vertical3 = vertical;
                    } else {
                        int i18 = i10 == 0 ? 0 : i5;
                        Alignment.Horizontal horizontal5 = i11 == 0 ? null : horizontal;
                        Arrangement.Vertical vertical5 = i12 == 0 ? null : vertical;
                        Alignment.Vertical vertical6 = i13 == 0 ? null : vertical2;
                        Arrangement.Horizontal horizontal6 = i15 == 0 ? null : horizontal2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(620764179, i9, i16, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:80)");
                        }
                        int i19 = (i9 >> 3) & 14;
                        Function0<LazyListItemProvider> rememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i19 | ((i16 >> 3) & 112));
                        int i20 = i9 >> 9;
                        LazyLayoutSemanticState rememberLazyListSemanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z6, startRestartGroup, i19 | (i20 & 112));
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        int i21 = i9 & 112;
                        int i22 = i9 & 7168;
                        int i23 = i9 >> 6;
                        int i24 = i16 << 21;
                        int i25 = i9;
                        int i26 = i18;
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda, lazyListState, paddingValues, z5, z6, i18, horizontal5, vertical6, horizontal6, vertical5, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), !((Boolean) startRestartGroup.consume(CompositionLocalsKt.getLocalScrollCaptureInProgress())).booleanValue(), startRestartGroup, (65520 & i9) | (i23 & 458752) | (i23 & 3670016) | (29360128 & i24) | (i24 & 234881024) | (1879048192 & i9), 0);
                        Orientation orientation = !z6 ? Orientation.Vertical : Orientation.Horizontal;
                        composer2 = startRestartGroup;
                        LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda, rememberLazyListSemanticState, orientation, z7, z5, startRestartGroup, (i23 & 57344) | ((i25 << 6) & 458752)), LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i26, composer2, i19 | ((i25 >> 18) & 112)), lazyListState.getBeyondBoundsInfo(), z5, (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation, z7, composer2, (MutableVector.$stable << 6) | i22 | (i25 & 3670016)).then(lazyListState.getItemAnimator$foundation_release().getModifier()), lazyListState, orientation, z7, z5, flingBehavior, lazyListState.getInternalInteractionSource(), null, composer2, i21 | (i20 & 7168) | (57344 & (i25 << 3)) | (i25 & 458752), 64), lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        i17 = i26;
                        horizontal3 = horizontal5;
                        vertical3 = vertical5;
                        vertical4 = vertical6;
                        horizontal4 = horizontal6;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt$LazyList$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i27) {
                                LazyListKt.LazyList(Modifier.this, lazyListState, paddingValues, z5, z6, flingBehavior, z7, i17, horizontal3, vertical3, vertical4, horizontal4, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), RecomposeScopeImplKt.updateChangedFlags(i7), i8);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i8 & 64) == 0) {
                }
                i10 = i8 & 128;
                if (i10 == 0) {
                }
                i11 = i8 & 256;
                if (i11 == 0) {
                }
                i12 = i8 & 512;
                if (i12 == 0) {
                }
                i13 = i8 & 1024;
                if (i13 == 0) {
                }
                i15 = i8 & 2048;
                if (i15 == 0) {
                }
                i16 = i14;
                if ((i8 & 4096) == 0) {
                }
                if ((306783379 & i9) != 306783378) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i192 = (i9 >> 3) & 14;
                Function0<LazyListItemProvider> rememberLazyListItemProviderLambda2 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i192 | ((i16 >> 3) & 112));
                int i202 = i9 >> 9;
                LazyLayoutSemanticState rememberLazyListSemanticState2 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z6, startRestartGroup, i192 | (i202 & 112));
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                int i212 = i9 & 112;
                int i222 = i9 & 7168;
                int i232 = i9 >> 6;
                int i242 = i16 << 21;
                int i252 = i9;
                int i262 = i18;
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy2 = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda2, lazyListState, paddingValues, z5, z6, i18, horizontal5, vertical6, horizontal6, vertical5, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), !((Boolean) startRestartGroup.consume(CompositionLocalsKt.getLocalScrollCaptureInProgress())).booleanValue(), startRestartGroup, (65520 & i9) | (i232 & 458752) | (i232 & 3670016) | (29360128 & i242) | (i242 & 234881024) | (1879048192 & i9), 0);
                Orientation orientation2 = !z6 ? Orientation.Vertical : Orientation.Horizontal;
                composer2 = startRestartGroup;
                LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda2, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda2, rememberLazyListSemanticState2, orientation2, z7, z5, startRestartGroup, (i232 & 57344) | ((i252 << 6) & 458752)), LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i262, composer2, i192 | ((i252 >> 18) & 112)), lazyListState.getBeyondBoundsInfo(), z5, (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation2, z7, composer2, (MutableVector.$stable << 6) | i222 | (i252 & 3670016)).then(lazyListState.getItemAnimator$foundation_release().getModifier()), lazyListState, orientation2, z7, z5, flingBehavior, lazyListState.getInternalInteractionSource(), null, composer2, i212 | (i202 & 7168) | (57344 & (i252 << 3)) | (i252 & 458752), 64), lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy2, composer2, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                i17 = i262;
                horizontal3 = horizontal5;
                vertical3 = vertical5;
                vertical4 = vertical6;
                horizontal4 = horizontal6;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i8 & 16) != 0) {
            }
            if ((i8 & 32) != 0) {
            }
            if ((i8 & 64) == 0) {
            }
            i10 = i8 & 128;
            if (i10 == 0) {
            }
            i11 = i8 & 256;
            if (i11 == 0) {
            }
            i12 = i8 & 512;
            if (i12 == 0) {
            }
            i13 = i8 & 1024;
            if (i13 == 0) {
            }
            i15 = i8 & 2048;
            if (i15 == 0) {
            }
            i16 = i14;
            if ((i8 & 4096) == 0) {
            }
            if ((306783379 & i9) != 306783378) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i15 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1922 = (i9 >> 3) & 14;
            Function0<LazyListItemProvider> rememberLazyListItemProviderLambda22 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i1922 | ((i16 >> 3) & 112));
            int i2022 = i9 >> 9;
            LazyLayoutSemanticState rememberLazyListSemanticState22 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z6, startRestartGroup, i1922 | (i2022 & 112));
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            int i2122 = i9 & 112;
            int i2222 = i9 & 7168;
            int i2322 = i9 >> 6;
            int i2422 = i16 << 21;
            int i2522 = i9;
            int i2622 = i18;
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy22 = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda22, lazyListState, paddingValues, z5, z6, i18, horizontal5, vertical6, horizontal6, vertical5, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), !((Boolean) startRestartGroup.consume(CompositionLocalsKt.getLocalScrollCaptureInProgress())).booleanValue(), startRestartGroup, (65520 & i9) | (i2322 & 458752) | (i2322 & 3670016) | (29360128 & i2422) | (i2422 & 234881024) | (1879048192 & i9), 0);
            Orientation orientation22 = !z6 ? Orientation.Vertical : Orientation.Horizontal;
            composer2 = startRestartGroup;
            LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda22, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda22, rememberLazyListSemanticState22, orientation22, z7, z5, startRestartGroup, (i2322 & 57344) | ((i2522 << 6) & 458752)), LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i2622, composer2, i1922 | ((i2522 >> 18) & 112)), lazyListState.getBeyondBoundsInfo(), z5, (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation22, z7, composer2, (MutableVector.$stable << 6) | i2222 | (i2522 & 3670016)).then(lazyListState.getItemAnimator$foundation_release().getModifier()), lazyListState, orientation22, z7, z5, flingBehavior, lazyListState.getInternalInteractionSource(), null, composer2, i2122 | (i2022 & 7168) | (57344 & (i2522 << 3)) | (i2522 & 458752), 64), lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy22, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            i17 = i2622;
            horizontal3 = horizontal5;
            vertical3 = vertical5;
            vertical4 = vertical6;
            horizontal4 = horizontal6;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i8 & 8) == 0) {
        }
        if ((i8 & 16) != 0) {
        }
        if ((i8 & 32) != 0) {
        }
        if ((i8 & 64) == 0) {
        }
        i10 = i8 & 128;
        if (i10 == 0) {
        }
        i11 = i8 & 256;
        if (i11 == 0) {
        }
        i12 = i8 & 512;
        if (i12 == 0) {
        }
        i13 = i8 & 1024;
        if (i13 == 0) {
        }
        i15 = i8 & 2048;
        if (i15 == 0) {
        }
        i16 = i14;
        if ((i8 & 4096) == 0) {
        }
        if ((306783379 & i9) != 306783378) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i19222 = (i9 >> 3) & 14;
        Function0<LazyListItemProvider> rememberLazyListItemProviderLambda222 = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i19222 | ((i16 >> 3) & 112));
        int i20222 = i9 >> 9;
        LazyLayoutSemanticState rememberLazyListSemanticState222 = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z6, startRestartGroup, i19222 | (i20222 & 112));
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        int i21222 = i9 & 112;
        int i22222 = i9 & 7168;
        int i23222 = i9 >> 6;
        int i24222 = i16 << 21;
        int i25222 = i9;
        int i26222 = i18;
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy222 = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda222, lazyListState, paddingValues, z5, z6, i18, horizontal5, vertical6, horizontal6, vertical5, ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope(), (GraphicsContext) startRestartGroup.consume(CompositionLocalsKt.getLocalGraphicsContext()), !((Boolean) startRestartGroup.consume(CompositionLocalsKt.getLocalScrollCaptureInProgress())).booleanValue(), startRestartGroup, (65520 & i9) | (i23222 & 458752) | (i23222 & 3670016) | (29360128 & i24222) | (i24222 & 234881024) | (1879048192 & i9), 0);
        Orientation orientation222 = !z6 ? Orientation.Vertical : Orientation.Horizontal;
        composer2 = startRestartGroup;
        LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda222, ScrollingContainerKt.scrollingContainer(LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda222, rememberLazyListSemanticState222, orientation222, z7, z5, startRestartGroup, (i23222 & 57344) | ((i25222 << 6) & 458752)), LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i26222, composer2, i19222 | ((i25222 >> 18) & 112)), lazyListState.getBeyondBoundsInfo(), z5, (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()), orientation222, z7, composer2, (MutableVector.$stable << 6) | i22222 | (i25222 & 3670016)).then(lazyListState.getItemAnimator$foundation_release().getModifier()), lazyListState, orientation222, z7, z5, flingBehavior, lazyListState.getInternalInteractionSource(), null, composer2, i21222 | (i20222 & 7168) | (57344 & (i25222 << 3)) | (i25222 & 458752), 64), lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy222, composer2, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        i17 = i26222;
        horizontal3 = horizontal5;
        vertical3 = vertical5;
        vertical4 = vertical6;
        horizontal4 = horizontal6;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bd, code lost:
    
        if (r34.changed(r29) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d9, code lost:
    
        if (r34.changed(r30) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f8, code lost:
    
        if (r34.changed(r33) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
    
        if (r34.changed(r22) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final Function0<? extends LazyListItemProvider> function0, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z5, final boolean z6, final int i5, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final Arrangement.Horizontal horizontal2, final Arrangement.Vertical vertical2, final CoroutineScope coroutineScope, final GraphicsContext graphicsContext, final boolean z7, Composer composer, int i6, int i7) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        Object rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1972347046, i6, i7, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:170)");
        }
        if (((i6 & 112) ^ 48) <= 32) {
        }
        if ((i6 & 48) != 32) {
            z8 = false;
            boolean z13 = z8 | ((((i6 & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i6 & 384) == 256) | ((((i6 & 7168) ^ 3072) <= 2048 && composer.changed(z5)) || (i6 & 3072) == 2048) | ((((57344 & i6) ^ 24576) <= 16384 && composer.changed(z6)) || (i6 & 24576) == 16384) | ((((3670016 & i6) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i6 & 1572864) == 1048576) | ((((29360128 & i6) ^ 12582912) <= 8388608 && composer.changed(vertical)) || (i6 & 12582912) == 8388608);
            if (((234881024 & i6) ^ 100663296) <= 67108864) {
            }
            if ((100663296 & i6) != 67108864) {
                z9 = false;
                boolean z14 = z13 | z9;
                if (((1879048192 & i6) ^ 805306368) <= 536870912) {
                }
                if ((i6 & 805306368) != 536870912) {
                    z10 = false;
                    boolean changed = z10 | z14 | composer.changed(graphicsContext);
                    if (((i7 & 896) ^ 384) <= 256) {
                    }
                    if ((i7 & 384) != 256) {
                        z11 = false;
                        z12 = changed | z11;
                        rememberedValue = composer.rememberedValue();
                        if (!z12 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                                    return m366invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                                }

                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final LazyListMeasureResult m366invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                                    float spacing;
                                    long IntOffset;
                                    ObservableScopeInvalidator.m425attachToScopeimpl(LazyListState.this.m378getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                                    boolean z15 = LazyListState.this.getHasLookaheadPassOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                                    CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z6 ? Orientation.Vertical : Orientation.Horizontal);
                                    int mo206roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    int mo206roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                                    int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                                    int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                                    final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                                    final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                                    boolean z16 = z6;
                                    int i10 = z16 ? i8 : i9;
                                    int i11 = (!z16 || z5) ? (z16 && z5) ? mo206roundToPx0680j_44 : (z16 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                                    final int i12 = i10 - i11;
                                    final long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                                    final LazyListItemProvider invoke = function0.invoke();
                                    invoke.getItemScope().setMaxSize(Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU), Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU));
                                    if (z6) {
                                        Arrangement.Vertical vertical3 = vertical2;
                                        if (vertical3 == null) {
                                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                                        }
                                        spacing = vertical3.getSpacing();
                                    } else {
                                        Arrangement.Horizontal horizontal3 = horizontal2;
                                        if (horizontal3 == null) {
                                            throw new IllegalArgumentException("null horizontalAlignment when isVertical == false");
                                        }
                                        spacing = horizontal3.getSpacing();
                                    }
                                    final int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(spacing);
                                    final int itemCount = invoke.getItemCount();
                                    int m2577getMaxHeightimpl = z6 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                                    if (!z5 || m2577getMaxHeightimpl > 0) {
                                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                                    } else {
                                        boolean z17 = z6;
                                        if (!z17) {
                                            mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                                        }
                                        if (z17) {
                                            mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                                        }
                                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                                    }
                                    final long j6 = IntOffset;
                                    final boolean z18 = z6;
                                    final Alignment.Horizontal horizontal4 = horizontal;
                                    final Alignment.Vertical vertical4 = vertical;
                                    final boolean z19 = z5;
                                    final LazyListState lazyListState2 = LazyListState.this;
                                    final int i13 = i11;
                                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m2595offsetNN6EwU, z18, invoke, lazyLayoutMeasureScope, itemCount, mo206roundToPx0680j_45, horizontal4, vertical4, z19, i13, i12, j6, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                                        final /* synthetic */ int $afterContentPadding;
                                        final /* synthetic */ int $beforeContentPadding;
                                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                                        final /* synthetic */ boolean $isVertical;
                                        final /* synthetic */ int $itemsCount;
                                        final /* synthetic */ boolean $reverseLayout;
                                        final /* synthetic */ int $spaceBetweenItems;
                                        final /* synthetic */ LazyListState $state;
                                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                                        final /* synthetic */ long $visualItemOffset;

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            this.$isVertical = z18;
                                            this.$this_null = lazyLayoutMeasureScope;
                                            this.$itemsCount = itemCount;
                                            this.$spaceBetweenItems = mo206roundToPx0680j_45;
                                            this.$horizontalAlignment = horizontal4;
                                            this.$verticalAlignment = vertical4;
                                            this.$reverseLayout = z19;
                                            this.$beforeContentPadding = i13;
                                            this.$afterContentPadding = i12;
                                            this.$visualItemOffset = j6;
                                            this.$state = lazyListState2;
                                        }

                                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                                        /* renamed from: createItem-X9ElhV4, reason: not valid java name */
                                        public LazyListMeasuredItem mo367createItemX9ElhV4(int index, Object key, Object contentType, List<? extends Placeable> placeables, long constraints) {
                                            return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation_release(), constraints, null);
                                        }
                                    };
                                    Snapshot.Companion companion = Snapshot.INSTANCE;
                                    LazyListState lazyListState3 = LazyListState.this;
                                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                                    try {
                                        int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyListState3.getFirstVisibleItemIndex());
                                        int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                                        Unit unit = Unit.INSTANCE;
                                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                        LazyListMeasureResult m369measureLazyListx0Ok8Vo = LazyListMeasureKt.m369measureLazyListx0Ok8Vo(itemCount, lazyListMeasuredItemProvider, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z15) ? LazyListState.this.getScrollToBeConsumed() : LazyListState.this.getScrollDeltaBetweenPasses$foundation_release(), m2595offsetNN6EwU, z6, z7 ? invoke.getHeaderIndexes() : CollectionsKt.emptyList(), vertical2, horizontal2, z5, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyListState.this.getPinnedItems(), LazyListState.this.getBeyondBoundsInfo()), z15, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getPostLookaheadLayoutInfo(), coroutineScope, LazyListState.this.m379getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                            }

                                            public final MeasureResult invoke(int i14, int i15, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i14 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i15 + i8), MapsKt.emptyMap(), function1);
                                            }
                                        });
                                        LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m369measureLazyListx0Ok8Vo, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                        return m369measureLazyListx0Ok8Vo;
                                    } catch (Throwable th) {
                                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                        throw th;
                                    }
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return function2;
                    }
                    z11 = true;
                    z12 = changed | z11;
                    rememberedValue = composer.rememberedValue();
                    if (!z12) {
                    }
                    rememberedValue = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                            return m366invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                        }

                        /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                        public final LazyListMeasureResult m366invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                            float spacing;
                            long IntOffset;
                            ObservableScopeInvalidator.m425attachToScopeimpl(LazyListState.this.m378getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                            boolean z15 = LazyListState.this.getHasLookaheadPassOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                            CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z6 ? Orientation.Vertical : Orientation.Horizontal);
                            int mo206roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                            int mo206roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                            int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                            int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                            final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                            final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                            boolean z16 = z6;
                            int i10 = z16 ? i8 : i9;
                            int i11 = (!z16 || z5) ? (z16 && z5) ? mo206roundToPx0680j_44 : (z16 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                            final int i12 = i10 - i11;
                            final long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                            final LazyListItemProvider invoke = function0.invoke();
                            invoke.getItemScope().setMaxSize(Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU), Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU));
                            if (z6) {
                                Arrangement.Vertical vertical3 = vertical2;
                                if (vertical3 == null) {
                                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                                }
                                spacing = vertical3.getSpacing();
                            } else {
                                Arrangement.Horizontal horizontal3 = horizontal2;
                                if (horizontal3 == null) {
                                    throw new IllegalArgumentException("null horizontalAlignment when isVertical == false");
                                }
                                spacing = horizontal3.getSpacing();
                            }
                            final int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(spacing);
                            final int itemCount = invoke.getItemCount();
                            int m2577getMaxHeightimpl = z6 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                            if (!z5 || m2577getMaxHeightimpl > 0) {
                                IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                            } else {
                                boolean z17 = z6;
                                if (!z17) {
                                    mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                                }
                                if (z17) {
                                    mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                                }
                                IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                            }
                            final long j6 = IntOffset;
                            final boolean z18 = z6;
                            final Alignment.Horizontal horizontal4 = horizontal;
                            final Alignment.Vertical vertical4 = vertical;
                            final boolean z19 = z5;
                            final LazyListState lazyListState2 = LazyListState.this;
                            final int i13 = i11;
                            LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m2595offsetNN6EwU, z18, invoke, lazyLayoutMeasureScope, itemCount, mo206roundToPx0680j_45, horizontal4, vertical4, z19, i13, i12, j6, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                                final /* synthetic */ int $afterContentPadding;
                                final /* synthetic */ int $beforeContentPadding;
                                final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                                final /* synthetic */ boolean $isVertical;
                                final /* synthetic */ int $itemsCount;
                                final /* synthetic */ boolean $reverseLayout;
                                final /* synthetic */ int $spaceBetweenItems;
                                final /* synthetic */ LazyListState $state;
                                final /* synthetic */ LazyLayoutMeasureScope $this_null;
                                final /* synthetic */ Alignment.Vertical $verticalAlignment;
                                final /* synthetic */ long $visualItemOffset;

                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    this.$isVertical = z18;
                                    this.$this_null = lazyLayoutMeasureScope;
                                    this.$itemsCount = itemCount;
                                    this.$spaceBetweenItems = mo206roundToPx0680j_45;
                                    this.$horizontalAlignment = horizontal4;
                                    this.$verticalAlignment = vertical4;
                                    this.$reverseLayout = z19;
                                    this.$beforeContentPadding = i13;
                                    this.$afterContentPadding = i12;
                                    this.$visualItemOffset = j6;
                                    this.$state = lazyListState2;
                                }

                                @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                                /* renamed from: createItem-X9ElhV4, reason: not valid java name */
                                public LazyListMeasuredItem mo367createItemX9ElhV4(int index, Object key, Object contentType, List<? extends Placeable> placeables, long constraints) {
                                    return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation_release(), constraints, null);
                                }
                            };
                            Snapshot.Companion companion = Snapshot.INSTANCE;
                            LazyListState lazyListState3 = LazyListState.this;
                            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyListState3.getFirstVisibleItemIndex());
                                int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                                Unit unit = Unit.INSTANCE;
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                LazyListMeasureResult m369measureLazyListx0Ok8Vo = LazyListMeasureKt.m369measureLazyListx0Ok8Vo(itemCount, lazyListMeasuredItemProvider, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z15) ? LazyListState.this.getScrollToBeConsumed() : LazyListState.this.getScrollDeltaBetweenPasses$foundation_release(), m2595offsetNN6EwU, z6, z7 ? invoke.getHeaderIndexes() : CollectionsKt.emptyList(), vertical2, horizontal2, z5, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyListState.this.getPinnedItems(), LazyListState.this.getBeyondBoundsInfo()), z15, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getPostLookaheadLayoutInfo(), coroutineScope, LazyListState.this.m379getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                        return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                    }

                                    public final MeasureResult invoke(int i14, int i15, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                        return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i14 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i15 + i8), MapsKt.emptyMap(), function1);
                                    }
                                });
                                LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m369measureLazyListx0Ok8Vo, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                                return m369measureLazyListx0Ok8Vo;
                            } catch (Throwable th) {
                                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                    Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) rememberedValue;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    return function22;
                }
                z10 = true;
                boolean changed2 = z10 | z14 | composer.changed(graphicsContext);
                if (((i7 & 896) ^ 384) <= 256) {
                }
                if ((i7 & 384) != 256) {
                }
                z11 = true;
                z12 = changed2 | z11;
                rememberedValue = composer.rememberedValue();
                if (!z12) {
                }
                rememberedValue = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                        return m366invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final LazyListMeasureResult m366invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                        float spacing;
                        long IntOffset;
                        ObservableScopeInvalidator.m425attachToScopeimpl(LazyListState.this.m378getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                        boolean z15 = LazyListState.this.getHasLookaheadPassOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                        CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z6 ? Orientation.Vertical : Orientation.Horizontal);
                        int mo206roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        int mo206roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                        int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                        int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                        final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                        final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                        boolean z16 = z6;
                        int i10 = z16 ? i8 : i9;
                        int i11 = (!z16 || z5) ? (z16 && z5) ? mo206roundToPx0680j_44 : (z16 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                        final int i12 = i10 - i11;
                        final long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                        final LazyListItemProvider invoke = function0.invoke();
                        invoke.getItemScope().setMaxSize(Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU), Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU));
                        if (z6) {
                            Arrangement.Vertical vertical3 = vertical2;
                            if (vertical3 == null) {
                                throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                            }
                            spacing = vertical3.getSpacing();
                        } else {
                            Arrangement.Horizontal horizontal3 = horizontal2;
                            if (horizontal3 == null) {
                                throw new IllegalArgumentException("null horizontalAlignment when isVertical == false");
                            }
                            spacing = horizontal3.getSpacing();
                        }
                        final int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(spacing);
                        final int itemCount = invoke.getItemCount();
                        int m2577getMaxHeightimpl = z6 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                        if (!z5 || m2577getMaxHeightimpl > 0) {
                            IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                        } else {
                            boolean z17 = z6;
                            if (!z17) {
                                mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                            }
                            if (z17) {
                                mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                            }
                            IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                        }
                        final long j6 = IntOffset;
                        final boolean z18 = z6;
                        final Alignment.Horizontal horizontal4 = horizontal;
                        final Alignment.Vertical vertical4 = vertical;
                        final boolean z19 = z5;
                        final LazyListState lazyListState2 = LazyListState.this;
                        final int i13 = i11;
                        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m2595offsetNN6EwU, z18, invoke, lazyLayoutMeasureScope, itemCount, mo206roundToPx0680j_45, horizontal4, vertical4, z19, i13, i12, j6, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                            final /* synthetic */ int $afterContentPadding;
                            final /* synthetic */ int $beforeContentPadding;
                            final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                            final /* synthetic */ boolean $isVertical;
                            final /* synthetic */ int $itemsCount;
                            final /* synthetic */ boolean $reverseLayout;
                            final /* synthetic */ int $spaceBetweenItems;
                            final /* synthetic */ LazyListState $state;
                            final /* synthetic */ LazyLayoutMeasureScope $this_null;
                            final /* synthetic */ Alignment.Vertical $verticalAlignment;
                            final /* synthetic */ long $visualItemOffset;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.$isVertical = z18;
                                this.$this_null = lazyLayoutMeasureScope;
                                this.$itemsCount = itemCount;
                                this.$spaceBetweenItems = mo206roundToPx0680j_45;
                                this.$horizontalAlignment = horizontal4;
                                this.$verticalAlignment = vertical4;
                                this.$reverseLayout = z19;
                                this.$beforeContentPadding = i13;
                                this.$afterContentPadding = i12;
                                this.$visualItemOffset = j6;
                                this.$state = lazyListState2;
                            }

                            @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                            /* renamed from: createItem-X9ElhV4, reason: not valid java name */
                            public LazyListMeasuredItem mo367createItemX9ElhV4(int index, Object key, Object contentType, List<? extends Placeable> placeables, long constraints) {
                                return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation_release(), constraints, null);
                            }
                        };
                        Snapshot.Companion companion = Snapshot.INSTANCE;
                        LazyListState lazyListState3 = LazyListState.this;
                        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyListState3.getFirstVisibleItemIndex());
                            int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                            Unit unit = Unit.INSTANCE;
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            LazyListMeasureResult m369measureLazyListx0Ok8Vo = LazyListMeasureKt.m369measureLazyListx0Ok8Vo(itemCount, lazyListMeasuredItemProvider, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z15) ? LazyListState.this.getScrollToBeConsumed() : LazyListState.this.getScrollDeltaBetweenPasses$foundation_release(), m2595offsetNN6EwU, z6, z7 ? invoke.getHeaderIndexes() : CollectionsKt.emptyList(), vertical2, horizontal2, z5, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyListState.this.getPinnedItems(), LazyListState.this.getBeyondBoundsInfo()), z15, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getPostLookaheadLayoutInfo(), coroutineScope, LazyListState.this.m379getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i14, int i15, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                    return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i14 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i15 + i8), MapsKt.emptyMap(), function1);
                                }
                            });
                            LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m369measureLazyListx0Ok8Vo, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                            return m369measureLazyListx0Ok8Vo;
                        } catch (Throwable th) {
                            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                };
                composer.updateRememberedValue(rememberedValue);
                Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function222 = (Function2) rememberedValue;
                if (ComposerKt.isTraceInProgress()) {
                }
                return function222;
            }
            z9 = true;
            boolean z142 = z13 | z9;
            if (((1879048192 & i6) ^ 805306368) <= 536870912) {
            }
            if ((i6 & 805306368) != 536870912) {
            }
            z10 = true;
            boolean changed22 = z10 | z142 | composer.changed(graphicsContext);
            if (((i7 & 896) ^ 384) <= 256) {
            }
            if ((i7 & 384) != 256) {
            }
            z11 = true;
            z12 = changed22 | z11;
            rememberedValue = composer.rememberedValue();
            if (!z12) {
            }
            rememberedValue = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m366invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyListMeasureResult m366invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                    float spacing;
                    long IntOffset;
                    ObservableScopeInvalidator.m425attachToScopeimpl(LazyListState.this.m378getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    boolean z15 = LazyListState.this.getHasLookaheadPassOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                    CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z6 ? Orientation.Vertical : Orientation.Horizontal);
                    int mo206roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    int mo206roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                    int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                    final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                    final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                    boolean z16 = z6;
                    int i10 = z16 ? i8 : i9;
                    int i11 = (!z16 || z5) ? (z16 && z5) ? mo206roundToPx0680j_44 : (z16 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                    final int i12 = i10 - i11;
                    final long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                    final LazyListItemProvider invoke = function0.invoke();
                    invoke.getItemScope().setMaxSize(Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU), Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU));
                    if (z6) {
                        Arrangement.Vertical vertical3 = vertical2;
                        if (vertical3 == null) {
                            throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                        }
                        spacing = vertical3.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal3 = horizontal2;
                        if (horizontal3 == null) {
                            throw new IllegalArgumentException("null horizontalAlignment when isVertical == false");
                        }
                        spacing = horizontal3.getSpacing();
                    }
                    final int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(spacing);
                    final int itemCount = invoke.getItemCount();
                    int m2577getMaxHeightimpl = z6 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                    if (!z5 || m2577getMaxHeightimpl > 0) {
                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                    } else {
                        boolean z17 = z6;
                        if (!z17) {
                            mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                        }
                        if (z17) {
                            mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                        }
                        IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                    }
                    final long j6 = IntOffset;
                    final boolean z18 = z6;
                    final Alignment.Horizontal horizontal4 = horizontal;
                    final Alignment.Vertical vertical4 = vertical;
                    final boolean z19 = z5;
                    final LazyListState lazyListState2 = LazyListState.this;
                    final int i13 = i11;
                    LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m2595offsetNN6EwU, z18, invoke, lazyLayoutMeasureScope, itemCount, mo206roundToPx0680j_45, horizontal4, vertical4, z19, i13, i12, j6, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        final /* synthetic */ int $afterContentPadding;
                        final /* synthetic */ int $beforeContentPadding;
                        final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                        final /* synthetic */ boolean $isVertical;
                        final /* synthetic */ int $itemsCount;
                        final /* synthetic */ boolean $reverseLayout;
                        final /* synthetic */ int $spaceBetweenItems;
                        final /* synthetic */ LazyListState $state;
                        final /* synthetic */ LazyLayoutMeasureScope $this_null;
                        final /* synthetic */ Alignment.Vertical $verticalAlignment;
                        final /* synthetic */ long $visualItemOffset;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.$isVertical = z18;
                            this.$this_null = lazyLayoutMeasureScope;
                            this.$itemsCount = itemCount;
                            this.$spaceBetweenItems = mo206roundToPx0680j_45;
                            this.$horizontalAlignment = horizontal4;
                            this.$verticalAlignment = vertical4;
                            this.$reverseLayout = z19;
                            this.$beforeContentPadding = i13;
                            this.$afterContentPadding = i12;
                            this.$visualItemOffset = j6;
                            this.$state = lazyListState2;
                        }

                        @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                        /* renamed from: createItem-X9ElhV4, reason: not valid java name */
                        public LazyListMeasuredItem mo367createItemX9ElhV4(int index, Object key, Object contentType, List<? extends Placeable> placeables, long constraints) {
                            return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation_release(), constraints, null);
                        }
                    };
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyListState lazyListState3 = LazyListState.this;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyListState3.getFirstVisibleItemIndex());
                        int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                        Unit unit = Unit.INSTANCE;
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        LazyListMeasureResult m369measureLazyListx0Ok8Vo = LazyListMeasureKt.m369measureLazyListx0Ok8Vo(itemCount, lazyListMeasuredItemProvider, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z15) ? LazyListState.this.getScrollToBeConsumed() : LazyListState.this.getScrollDeltaBetweenPasses$foundation_release(), m2595offsetNN6EwU, z6, z7 ? invoke.getHeaderIndexes() : CollectionsKt.emptyList(), vertical2, horizontal2, z5, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyListState.this.getPinnedItems(), LazyListState.this.getBeyondBoundsInfo()), z15, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getPostLookaheadLayoutInfo(), coroutineScope, LazyListState.this.m379getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                            }

                            public final MeasureResult invoke(int i14, int i15, Function1<? super Placeable.PlacementScope, Unit> function1) {
                                return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i14 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i15 + i8), MapsKt.emptyMap(), function1);
                            }
                        });
                        LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m369measureLazyListx0Ok8Vo, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                        return m369measureLazyListx0Ok8Vo;
                    } catch (Throwable th) {
                        companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(rememberedValue);
            Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2222 = (Function2) rememberedValue;
            if (ComposerKt.isTraceInProgress()) {
            }
            return function2222;
        }
        z8 = true;
        boolean z132 = z8 | ((((i6 & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i6 & 384) == 256) | ((((i6 & 7168) ^ 3072) <= 2048 && composer.changed(z5)) || (i6 & 3072) == 2048) | ((((57344 & i6) ^ 24576) <= 16384 && composer.changed(z6)) || (i6 & 24576) == 16384) | ((((3670016 & i6) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i6 & 1572864) == 1048576) | ((((29360128 & i6) ^ 12582912) <= 8388608 && composer.changed(vertical)) || (i6 & 12582912) == 8388608);
        if (((234881024 & i6) ^ 100663296) <= 67108864) {
        }
        if ((100663296 & i6) != 67108864) {
        }
        z9 = true;
        boolean z1422 = z132 | z9;
        if (((1879048192 & i6) ^ 805306368) <= 536870912) {
        }
        if ((i6 & 805306368) != 536870912) {
        }
        z10 = true;
        boolean changed222 = z10 | z1422 | composer.changed(graphicsContext);
        if (((i7 & 896) ^ 384) <= 256) {
        }
        if ((i7 & 384) != 256) {
        }
        z11 = true;
        z12 = changed222 | z11;
        rememberedValue = composer.rememberedValue();
        if (!z12) {
        }
        rememberedValue = new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                return m366invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
            }

            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
            public final LazyListMeasureResult m366invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j5) {
                float spacing;
                long IntOffset;
                ObservableScopeInvalidator.m425attachToScopeimpl(LazyListState.this.m378getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                boolean z15 = LazyListState.this.getHasLookaheadPassOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                CheckScrollableContainerConstraintsKt.m118checkScrollableContainerConstraintsK40F9xA(j5, z6 ? Orientation.Vertical : Orientation.Horizontal);
                int mo206roundToPx0680j_4 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo290calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                int mo206roundToPx0680j_42 = z6 ? lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.mo291calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection())) : lazyLayoutMeasureScope.mo206roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                int mo206roundToPx0680j_43 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getTop());
                int mo206roundToPx0680j_44 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(paddingValues.getBottom());
                final int i8 = mo206roundToPx0680j_43 + mo206roundToPx0680j_44;
                final int i9 = mo206roundToPx0680j_4 + mo206roundToPx0680j_42;
                boolean z16 = z6;
                int i10 = z16 ? i8 : i9;
                int i11 = (!z16 || z5) ? (z16 && z5) ? mo206roundToPx0680j_44 : (z16 || z5) ? mo206roundToPx0680j_42 : mo206roundToPx0680j_4 : mo206roundToPx0680j_43;
                final int i12 = i10 - i11;
                final long m2595offsetNN6EwU = ConstraintsKt.m2595offsetNN6EwU(j5, -i9, -i8);
                final LazyListItemProvider invoke = function0.invoke();
                invoke.getItemScope().setMaxSize(Constraints.m2578getMaxWidthimpl(m2595offsetNN6EwU), Constraints.m2577getMaxHeightimpl(m2595offsetNN6EwU));
                if (z6) {
                    Arrangement.Vertical vertical3 = vertical2;
                    if (vertical3 == null) {
                        throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                    }
                    spacing = vertical3.getSpacing();
                } else {
                    Arrangement.Horizontal horizontal3 = horizontal2;
                    if (horizontal3 == null) {
                        throw new IllegalArgumentException("null horizontalAlignment when isVertical == false");
                    }
                    spacing = horizontal3.getSpacing();
                }
                final int mo206roundToPx0680j_45 = lazyLayoutMeasureScope.mo206roundToPx0680j_4(spacing);
                final int itemCount = invoke.getItemCount();
                int m2577getMaxHeightimpl = z6 ? Constraints.m2577getMaxHeightimpl(j5) - i8 : Constraints.m2578getMaxWidthimpl(j5) - i9;
                if (!z5 || m2577getMaxHeightimpl > 0) {
                    IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                } else {
                    boolean z17 = z6;
                    if (!z17) {
                        mo206roundToPx0680j_4 += m2577getMaxHeightimpl;
                    }
                    if (z17) {
                        mo206roundToPx0680j_43 += m2577getMaxHeightimpl;
                    }
                    IntOffset = IntOffsetKt.IntOffset(mo206roundToPx0680j_4, mo206roundToPx0680j_43);
                }
                final long j6 = IntOffset;
                final boolean z18 = z6;
                final Alignment.Horizontal horizontal4 = horizontal;
                final Alignment.Vertical vertical4 = vertical;
                final boolean z19 = z5;
                final LazyListState lazyListState2 = LazyListState.this;
                final int i13 = i11;
                LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m2595offsetNN6EwU, z18, invoke, lazyLayoutMeasureScope, itemCount, mo206roundToPx0680j_45, horizontal4, vertical4, z19, i13, i12, j6, lazyListState2) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                    final /* synthetic */ int $afterContentPadding;
                    final /* synthetic */ int $beforeContentPadding;
                    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
                    final /* synthetic */ boolean $isVertical;
                    final /* synthetic */ int $itemsCount;
                    final /* synthetic */ boolean $reverseLayout;
                    final /* synthetic */ int $spaceBetweenItems;
                    final /* synthetic */ LazyListState $state;
                    final /* synthetic */ LazyLayoutMeasureScope $this_null;
                    final /* synthetic */ Alignment.Vertical $verticalAlignment;
                    final /* synthetic */ long $visualItemOffset;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$isVertical = z18;
                        this.$this_null = lazyLayoutMeasureScope;
                        this.$itemsCount = itemCount;
                        this.$spaceBetweenItems = mo206roundToPx0680j_45;
                        this.$horizontalAlignment = horizontal4;
                        this.$verticalAlignment = vertical4;
                        this.$reverseLayout = z19;
                        this.$beforeContentPadding = i13;
                        this.$afterContentPadding = i12;
                        this.$visualItemOffset = j6;
                        this.$state = lazyListState2;
                    }

                    @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
                    /* renamed from: createItem-X9ElhV4, reason: not valid java name */
                    public LazyListMeasuredItem mo367createItemX9ElhV4(int index, Object key, Object contentType, List<? extends Placeable> placeables, long constraints) {
                        return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_null.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation_release(), constraints, null);
                    }
                };
                Snapshot.Companion companion = Snapshot.INSTANCE;
                LazyListState lazyListState3 = LazyListState.this;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState3.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(invoke, lazyListState3.getFirstVisibleItemIndex());
                    int firstVisibleItemScrollOffset = lazyListState3.getFirstVisibleItemScrollOffset();
                    Unit unit = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    LazyListMeasureResult m369measureLazyListx0Ok8Vo = LazyListMeasureKt.m369measureLazyListx0Ok8Vo(itemCount, lazyListMeasuredItemProvider, m2577getMaxHeightimpl, i11, i12, mo206roundToPx0680j_45, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, (lazyLayoutMeasureScope.isLookingAhead() || !z15) ? LazyListState.this.getScrollToBeConsumed() : LazyListState.this.getScrollDeltaBetweenPasses$foundation_release(), m2595offsetNN6EwU, z6, z7 ? invoke.getHeaderIndexes() : CollectionsKt.emptyList(), vertical2, horizontal2, z5, lazyLayoutMeasureScope, LazyListState.this.getItemAnimator$foundation_release(), i5, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, LazyListState.this.getPinnedItems(), LazyListState.this.getBeyondBoundsInfo()), z15, lazyLayoutMeasureScope.isLookingAhead(), LazyListState.this.getPostLookaheadLayoutInfo(), coroutineScope, LazyListState.this.m379getPlacementScopeInvalidatorzYiylxw$foundation_release(), graphicsContext, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measureResult$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                            return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                        }

                        public final MeasureResult invoke(int i14, int i15, Function1<? super Placeable.PlacementScope, Unit> function1) {
                            return LazyLayoutMeasureScope.this.layout(ConstraintsKt.m2593constrainWidthK40F9xA(j5, i14 + i9), ConstraintsKt.m2592constrainHeightK40F9xA(j5, i15 + i8), MapsKt.emptyMap(), function1);
                        }
                    });
                    LazyListState.applyMeasureResult$foundation_release$default(LazyListState.this, m369measureLazyListx0Ok8Vo, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                    return m369measureLazyListx0Ok8Vo;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
        };
        composer.updateRememberedValue(rememberedValue);
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22222 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
        }
        return function22222;
    }
}
