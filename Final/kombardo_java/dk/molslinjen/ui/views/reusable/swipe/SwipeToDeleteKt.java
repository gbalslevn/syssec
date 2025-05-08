package dk.molslinjen.ui.views.reusable.swipe;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.DismissDirection;
import androidx.compose.material.DismissState;
import androidx.compose.material.DismissValue;
import androidx.compose.material.FractionalThreshold;
import androidx.compose.material.SwipeToDismissKt;
import androidx.compose.material.ThresholdConfig;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.swipe.SwipeToDeleteKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u0013²\u0006\f\u0010\u000f\u001a\u00020\u000e8\nX\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u00020\u00108\nX\u008a\u0084\u0002²\u0006\f\u0010\u0012\u001a\u00020\u00108\nX\u008a\u0084\u0002"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "onDelete", BuildConfig.FLAVOR, "commitOnSwipe", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "content", "SwipeToDelete", "(Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material/DismissValue;", "targetValue", "DeleteSwipeBackground", "(Landroidx/compose/material/DismissValue;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "iconScale", "Landroidx/compose/ui/graphics/Color;", "iconColor", "backgroundColor", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SwipeToDeleteKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void DeleteSwipeBackground(final DismissValue dismissValue, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-820939861);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(dismissValue) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-820939861, i6, -1, "dk.molslinjen.ui.views.reusable.swipe.DeleteSwipeBackground (SwipeToDelete.kt:56)");
            }
            DismissValue dismissValue2 = DismissValue.Default;
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(dismissValue == dismissValue2 ? 1.0f : 1.5f, null, 0.0f, null, null, startRestartGroup, 0, 30);
            AppColor appColor = AppColor.INSTANCE;
            State<Color> m54animateColorAsStateeuL9pac = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(dismissValue == dismissValue2 ? appColor.m3272getSignalRed0d7_KjU() : appColor.m3281getWhite0d7_KjU(), null, null, null, startRestartGroup, 0, 14);
            State<Color> m54animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m54animateColorAsStateeuL9pac(dismissValue == dismissValue2 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : AppColor.INSTANCE.m3272getSignalRed0d7_KjU(), null, null, null, startRestartGroup, 0, 14);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), DeleteSwipeBackground$lambda$7(m54animateColorAsStateeuL9pac2), null, 2, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenterEnd(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_delete, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_remove, startRestartGroup, 6), ScaleKt.scale(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 0.0f, 11, null), DeleteSwipeBackground$lambda$5(animateFloatAsState)), DeleteSwipeBackground$lambda$6(m54animateColorAsStateeuL9pac), startRestartGroup, 0, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeleteSwipeBackground$lambda$9;
                    DeleteSwipeBackground$lambda$9 = SwipeToDeleteKt.DeleteSwipeBackground$lambda$9(DismissValue.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeleteSwipeBackground$lambda$9;
                }
            });
        }
    }

    private static final float DeleteSwipeBackground$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long DeleteSwipeBackground$lambda$6(State<Color> state) {
        return state.getValue().getValue();
    }

    private static final long DeleteSwipeBackground$lambda$7(State<Color> state) {
        return state.getValue().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteSwipeBackground$lambda$9(DismissValue dismissValue, int i5, Composer composer, int i6) {
        DeleteSwipeBackground(dismissValue, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SwipeToDelete(final Function0<Unit> onDelete, final boolean z5, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i5, final int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(onDelete, "onDelete");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(257931725);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(onDelete) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                z5 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(257931725, i7, -1, "dk.molslinjen.ui.views.reusable.swipe.SwipeToDelete (SwipeToDelete.kt:32)");
            }
            startRestartGroup.startReplaceGroup(-2089229569);
            boolean z6 = ((i7 & 14) == 4) | ((i7 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: l2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        boolean SwipeToDelete$lambda$1$lambda$0;
                        SwipeToDelete$lambda$1$lambda$0 = SwipeToDeleteKt.SwipeToDelete$lambda$1$lambda$0(Function0.this, z5, (DismissValue) obj);
                        return Boolean.valueOf(SwipeToDelete$lambda$1$lambda$0);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final DismissState rememberDismissState = SwipeToDismissKt.rememberDismissState(null, (Function1) rememberedValue, startRestartGroup, 0, 1);
            Set of = SetsKt.setOf(DismissDirection.EndToStart);
            startRestartGroup.startReplaceGroup(-2089220424);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: l2.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        ThresholdConfig SwipeToDelete$lambda$3$lambda$2;
                        SwipeToDelete$lambda$3$lambda$2 = SwipeToDeleteKt.SwipeToDelete$lambda$3$lambda$2((DismissDirection) obj);
                        return SwipeToDelete$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SwipeToDismissKt.SwipeToDismiss(rememberDismissState, null, of, (Function1) rememberedValue2, ComposableLambdaKt.rememberComposableLambda(167524063, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.swipe.SwipeToDeleteKt$SwipeToDelete$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope SwipeToDismiss, Composer composer2, int i9) {
                    Intrinsics.checkNotNullParameter(SwipeToDismiss, "$this$SwipeToDismiss");
                    if ((i9 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(167524063, i9, -1, "dk.molslinjen.ui.views.reusable.swipe.SwipeToDelete.<anonymous> (SwipeToDelete.kt:49)");
                    }
                    SwipeToDeleteKt.DeleteSwipeBackground(DismissState.this.getTargetValue(), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-494065410, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.swipe.SwipeToDeleteKt$SwipeToDelete$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope SwipeToDismiss, Composer composer2, int i9) {
                    Intrinsics.checkNotNullParameter(SwipeToDismiss, "$this$SwipeToDismiss");
                    if ((i9 & 6) == 0) {
                        i9 |= composer2.changed(SwipeToDismiss) ? 4 : 2;
                    }
                    if ((i9 & 19) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-494065410, i9, -1, "dk.molslinjen.ui.views.reusable.swipe.SwipeToDelete.<anonymous> (SwipeToDelete.kt:51)");
                    }
                    content.invoke(SwipeToDismiss, composer2, Integer.valueOf(i9 & 14));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 224640, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final boolean z7 = z5;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SwipeToDelete$lambda$4;
                    SwipeToDelete$lambda$4 = SwipeToDeleteKt.SwipeToDelete$lambda$4(Function0.this, z7, content, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return SwipeToDelete$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SwipeToDelete$lambda$1$lambda$0(Function0 function0, boolean z5, DismissValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it != DismissValue.DismissedToStart) {
            return false;
        }
        function0.invoke();
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThresholdConfig SwipeToDelete$lambda$3$lambda$2(DismissDirection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new FractionalThreshold(0.2f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDelete$lambda$4(Function0 function0, boolean z5, Function3 function3, int i5, int i6, Composer composer, int i7) {
        SwipeToDelete(function0, z5, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
