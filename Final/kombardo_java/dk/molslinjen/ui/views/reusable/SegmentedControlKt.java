package dk.molslinjen.ui.views.reusable;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.SegmentedControlKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001aE\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\n\u001a9\u0010\u0017\u001a\u00020\u0007*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "controlTextResources", "selectedIndex", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onItemSelected", "SegmentedControlStringRes", "(Landroidx/compose/ui/Modifier;Ljava/util/List;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SegmentedControl", BuildConfig.FLAVOR, "controlTexts", "SegmentedControlStrings", "Landroidx/compose/foundation/layout/RowScope;", Constants.IntentExtra.PushTitle, "Ldk/molslinjen/ui/views/reusable/SegmentedControlTabPosition;", "position", BuildConfig.FLAVOR, "isSelected", "Lkotlin/Function0;", "onClick", "SegmentedControlButton", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/SegmentedControlTabPosition;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SegmentedControlKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SegmentedControlTabPosition.values().length];
            try {
                iArr[SegmentedControlTabPosition.Start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SegmentedControlTabPosition.Middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SegmentedControlTabPosition.End.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedControl$lambda$1(Modifier modifier, List list, int i5, Function1 function1, int i6, int i7, Composer composer, int i8) {
        SegmentedControlStringRes(modifier, list, i5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedControl$lambda$5$lambda$4$lambda$3$lambda$2(Function1 function1, int i5) {
        function1.invoke(Integer.valueOf(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedControl$lambda$6(Modifier modifier, List list, int i5, Function1 function1, int i6, int i7, Composer composer, int i8) {
        SegmentedControlStrings(modifier, list, i5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final void SegmentedControlButton(final RowScope rowScope, final String str, final SegmentedControlTabPosition segmentedControlTabPosition, final boolean z5, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Shape m461RoundedCornerShapea9UjIt4;
        Composer startRestartGroup = composer.startRestartGroup(1386465257);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(segmentedControlTabPosition) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1386465257, i7, -1, "dk.molslinjen.ui.views.reusable.SegmentedControlButton (SegmentedControl.kt:82)");
            }
            final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_selected, startRestartGroup, 6);
            final String stringResource2 = StringResources_androidKt.stringResource(R.string.accessibilityLabel_unselected, startRestartGroup, 6);
            Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
            startRestartGroup.startReplaceGroup(-782435251);
            boolean changed = ((i7 & 7168) == 2048) | startRestartGroup.changed(stringResource) | startRestartGroup.changed(stringResource2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: W1.F
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SegmentedControlButton$lambda$8$lambda$7;
                        SegmentedControlButton$lambda$8$lambda$7 = SegmentedControlKt.SegmentedControlButton$lambda$8$lambda$7(z5, stringResource, stringResource2, (SemanticsPropertyReceiver) obj);
                        return SegmentedControlButton$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(weight$default, false, (Function1) rememberedValue, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            long m3255getBrandBlue10d7_KjU = z5 ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3281getWhite0d7_KjU();
            int i8 = WhenMappings.$EnumSwitchMapping$0[segmentedControlTabPosition.ordinal()];
            if (i8 == 1) {
                float f5 = 8;
                float f6 = 0;
                m461RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5));
            } else if (i8 == 2) {
                m461RoundedCornerShapea9UjIt4 = RectangleShapeKt.getRectangleShape();
            } else {
                if (i8 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                float f7 = 0;
                float f8 = 8;
                m461RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f7));
            }
            ButtonKt.TextButton(function0, BackgroundKt.m103backgroundbw27NRU(semantics$default, m3255getBrandBlue10d7_KjU, m461RoundedCornerShapea9UjIt4), false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(786112716, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.SegmentedControlKt$SegmentedControlButton$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope2, Composer composer2, Integer num) {
                    invoke(rowScope2, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer composer2, int i9) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    if ((i9 & 17) == 16 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(786112716, i9, -1, "dk.molslinjen.ui.views.reusable.SegmentedControlButton.<anonymous> (SegmentedControl.kt:103)");
                    }
                    TextKt.m940Text4IGK_g(str, PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 1, null), z5 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : AppColor.INSTANCE.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, TypographyKt.getParagraph(), composer2, 48, 1575936, 57336);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i7 >> 12) & 14) | 805306368, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: dk.molslinjen.ui.views.reusable.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SegmentedControlButton$lambda$9;
                    SegmentedControlButton$lambda$9 = SegmentedControlKt.SegmentedControlButton$lambda$9(RowScope.this, str, segmentedControlTabPosition, z5, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SegmentedControlButton$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedControlButton$lambda$8$lambda$7(boolean z5, String str, String str2, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2184setRolekuIjeqM(semantics, Role.INSTANCE.m2174getRadioButtono7Vup1c());
        if (!z5) {
            str = str2;
        }
        SemanticsPropertiesKt.setStateDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedControlButton$lambda$9(RowScope rowScope, String str, SegmentedControlTabPosition segmentedControlTabPosition, boolean z5, Function0 function0, int i5, Composer composer, int i6) {
        SegmentedControlButton(rowScope, str, segmentedControlTabPosition, z5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SegmentedControlStringRes(Modifier modifier, final List<Integer> controlTextResources, int i5, final Function1<? super Integer, Unit> onItemSelected, Composer composer, final int i6, final int i7) {
        int i8;
        Intrinsics.checkNotNullParameter(controlTextResources, "controlTextResources");
        Intrinsics.checkNotNullParameter(onItemSelected, "onItemSelected");
        Composer startRestartGroup = composer.startRestartGroup(-877553960);
        int i9 = i7 & 1;
        if (i9 != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(controlTextResources) ? 32 : 16;
        }
        int i10 = i7 & 4;
        if (i10 != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(onItemSelected) ? 2048 : 1024;
        }
        if ((i8 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i9 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i10 != 0) {
                i5 = 0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-877553960, i8, -1, "dk.molslinjen.ui.views.reusable.SegmentedControl (SegmentedControl.kt:35)");
            }
            startRestartGroup.startReplaceGroup(-1663378646);
            List<Integer> list = controlTextResources;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(StringResources_androidKt.stringResource(((Number) it.next()).intValue(), startRestartGroup, 0));
            }
            startRestartGroup.endReplaceGroup();
            SegmentedControlStrings(modifier, arrayList, i5, onItemSelected, startRestartGroup, i8 & 8078, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final int i11 = i5;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: W1.E
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SegmentedControl$lambda$1;
                    SegmentedControl$lambda$1 = SegmentedControlKt.SegmentedControl$lambda$1(Modifier.this, controlTextResources, i11, onItemSelected, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return SegmentedControl$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SegmentedControlStrings(Modifier modifier, final List<String> controlTexts, int i5, final Function1<? super Integer, Unit> onItemSelected, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        int i9;
        int i10;
        Modifier modifier3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(controlTexts, "controlTexts");
        Intrinsics.checkNotNullParameter(onItemSelected, "onItemSelected");
        Composer startRestartGroup = composer.startRestartGroup(-877553960);
        int i11 = i7 & 1;
        if (i11 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(controlTexts) ? 32 : 16;
        }
        int i12 = i7 & 4;
        if (i12 != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i9 = i5;
            i8 |= startRestartGroup.changed(i9) ? 256 : 128;
            if ((i7 & 8) == 0) {
                i8 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i8 |= startRestartGroup.changedInstance(onItemSelected) ? 2048 : 1024;
            }
            i10 = i8;
            if ((i10 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                modifier3 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                boolean z5 = false;
                int i13 = i12 == 0 ? 0 : i9;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-877553960, i10, -1, "dk.molslinjen.ui.views.reusable.SegmentedControl (SegmentedControl.kt:51)");
                }
                Modifier m1270shadows4CzXII$default = ShadowKt.m1270shadows4CzXII$default(modifier3, Dp.m2599constructorimpl(10), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium(), false, ColorKt.Color(2701137489L), ColorKt.Color(2701137489L), 4, null);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m1270shadows4CzXII$default);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(978526929);
                final int i14 = 0;
                for (Object obj : controlTexts) {
                    int i15 = i14 + 1;
                    if (i14 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str = (String) obj;
                    SegmentedControlTabPosition segmentedControlTabPosition = i14 == 0 ? SegmentedControlTabPosition.Start : i14 == CollectionsKt.getLastIndex(controlTexts) ? SegmentedControlTabPosition.End : SegmentedControlTabPosition.Middle;
                    boolean z6 = i14 == i13 ? true : z5;
                    startRestartGroup.startReplaceGroup(1663126183);
                    boolean changed = ((i10 & 7168) == 2048 ? true : z5) | startRestartGroup.changed(i14);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: W1.C
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SegmentedControl$lambda$5$lambda$4$lambda$3$lambda$2;
                                SegmentedControl$lambda$5$lambda$4$lambda$3$lambda$2 = SegmentedControlKt.SegmentedControl$lambda$5$lambda$4$lambda$3$lambda$2(Function1.this, i14);
                                return SegmentedControl$lambda$5$lambda$4$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceGroup();
                    SegmentedControlButton(rowScopeInstance, str, segmentedControlTabPosition, z6, (Function0) rememberedValue, startRestartGroup, 6);
                    i14 = i15;
                    i13 = i13;
                    z5 = false;
                }
                int i16 = i13;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = i16;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                final int i17 = i9;
                endRestartGroup.updateScope(new Function2() { // from class: W1.D
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit SegmentedControl$lambda$6;
                        SegmentedControl$lambda$6 = SegmentedControlKt.SegmentedControl$lambda$6(Modifier.this, controlTexts, i17, onItemSelected, i6, i7, (Composer) obj2, ((Integer) obj3).intValue());
                        return SegmentedControl$lambda$6;
                    }
                });
                return;
            }
            return;
        }
        i9 = i5;
        if ((i7 & 8) == 0) {
        }
        i10 = i8;
        if ((i10 & 1171) == 1170) {
        }
        if (i11 == 0) {
        }
        boolean z52 = false;
        if (i12 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m1270shadows4CzXII$default2 = ShadowKt.m1270shadows4CzXII$default(modifier3, Dp.m2599constructorimpl(10), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium(), false, ColorKt.Color(2701137489L), ColorKt.Color(2701137489L), 4, null);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m1270shadows4CzXII$default2);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(978526929);
        final int i142 = 0;
        while (r15.hasNext()) {
        }
        int i162 = i13;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        i9 = i162;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
