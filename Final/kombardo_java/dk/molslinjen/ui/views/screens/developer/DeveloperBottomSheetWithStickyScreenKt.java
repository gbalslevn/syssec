package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.TextFieldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.sun.jna.Function;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.developer.DeveloperBottomSheetWithStickyScreenKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u000f\u0010\t\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011²\u0006\u000e\u0010\u0010\u001a\u00020\u000f8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "DeveloperBottomSheetWithStickyScreen", "(Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function0;", "dismiss", "DeveloperBottomSheetContent", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SheetContent", "(Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "item", "Row", "(ILandroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "showBackAction", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperBottomSheetWithStickyScreenKt {
    private static final void DeveloperBottomSheetContent(final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1532127273);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1532127273, i6, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperBottomSheetContent (DeveloperBottomSheetWithStickyScreen.kt:27)");
            }
            startRestartGroup.startReplaceGroup(896100359);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(null, 0.0f, "Sheet with sticky", null, 0L, function0, function0, null, ComposableLambdaKt.rememberComposableLambda(630901141, true, new DeveloperBottomSheetWithStickyScreenKt$DeveloperBottomSheetContent$1((MutableState) rememberedValue), startRestartGroup, 54), ComposableSingletons$DeveloperBottomSheetWithStickyScreenKt.INSTANCE.m3478getLambda1$app_kombardoProd(), startRestartGroup, ((i6 << 15) & 458752) | 905970048 | ((i6 << 18) & 3670016), 155);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperBottomSheetContent$lambda$5;
                    DeveloperBottomSheetContent$lambda$5 = DeveloperBottomSheetWithStickyScreenKt.DeveloperBottomSheetContent$lambda$5(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperBottomSheetContent$lambda$5;
                }
            });
        }
    }

    public static final boolean DeveloperBottomSheetContent$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    public static final void DeveloperBottomSheetContent$lambda$4(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    public static final Unit DeveloperBottomSheetContent$lambda$5(Function0 function0, int i5, Composer composer, int i6) {
        DeveloperBottomSheetContent(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void DeveloperBottomSheetWithStickyScreen(final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1066796459);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(navigator) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1066796459, i6, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperBottomSheetWithStickyScreen (DeveloperBottomSheetWithStickyScreen.kt:22)");
            }
            startRestartGroup.startReplaceGroup(1130112453);
            boolean z5 = (i6 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new DeveloperBottomSheetWithStickyScreenKt$DeveloperBottomSheetWithStickyScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            DeveloperBottomSheetContent((Function0) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperBottomSheetWithStickyScreen$lambda$1;
                    DeveloperBottomSheetWithStickyScreen$lambda$1 = DeveloperBottomSheetWithStickyScreenKt.DeveloperBottomSheetWithStickyScreen$lambda$1(DestinationsNavigator.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperBottomSheetWithStickyScreen$lambda$1;
                }
            });
        }
    }

    public static final Unit DeveloperBottomSheetWithStickyScreen$lambda$1(DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        DeveloperBottomSheetWithStickyScreen(destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void Row(final int i5, Composer composer, final int i6) {
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1361624267);
        if ((i6 & 6) == 0) {
            i7 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i7 = i6;
        }
        if ((i7 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1361624267, i7, -1, "dk.molslinjen.ui.views.screens.developer.Row (DeveloperBottomSheetWithStickyScreen.kt:63)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g("Item " + i5, PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 48, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Row$lambda$12;
                    Row$lambda$12 = DeveloperBottomSheetWithStickyScreenKt.Row$lambda$12(i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return Row$lambda$12;
                }
            });
        }
    }

    public static final Unit Row$lambda$12(int i5, int i6, Composer composer, int i7) {
        Row(i5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    public static final void SheetContent(Composer composer, final int i5) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-42396344);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-42396344, i5, -1, "dk.molslinjen.ui.views.screens.developer.SheetContent (DeveloperBottomSheetWithStickyScreen.kt:45)");
            }
            final List list = CollectionsKt.toList(new IntRange(0, 20));
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m2599constructorimpl(8));
            startRestartGroup.startReplaceGroup(-663120091);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: l3.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SheetContent$lambda$7$lambda$6;
                        SheetContent$lambda$7$lambda$6 = DeveloperBottomSheetWithStickyScreenKt.SheetContent$lambda$7$lambda$6((String) obj);
                        return SheetContent$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            TextFieldKt.TextField(BuildConfig.FLAVOR, (Function1) rememberedValue, m311padding3ABfNKs, false, false, null, null, null, null, null, null, null, null, false, null, null, null, false, 0, 0, null, null, null, startRestartGroup, 438, 0, 0, 8388600);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(-663119223);
            boolean changedInstance = composer2.changedInstance(list);
            Object rememberedValue2 = composer2.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: l3.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SheetContent$lambda$10$lambda$9;
                        SheetContent$lambda$10$lambda$9 = DeveloperBottomSheetWithStickyScreenKt.SheetContent$lambda$10$lambda$9(list, (LazyListScope) obj);
                        return SheetContent$lambda$10$lambda$9;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, (Function1) rememberedValue2, composer2, 0, Function.USE_VARARGS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SheetContent$lambda$11;
                    SheetContent$lambda$11 = DeveloperBottomSheetWithStickyScreenKt.SheetContent$lambda$11(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SheetContent$lambda$11;
                }
            });
        }
    }

    public static final Unit SheetContent$lambda$10$lambda$9(final List list, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final DeveloperBottomSheetWithStickyScreenKt$SheetContent$lambda$10$lambda$9$$inlined$items$default$1 developerBottomSheetWithStickyScreenKt$SheetContent$lambda$10$lambda$9$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.developer.DeveloperBottomSheetWithStickyScreenKt$SheetContent$lambda$10$lambda$9$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Integer num) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Integer) obj);
            }
        };
        LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.developer.DeveloperBottomSheetWithStickyScreenKt$SheetContent$lambda$10$lambda$9$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(list.get(i5));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.DeveloperBottomSheetWithStickyScreenKt$SheetContent$lambda$10$lambda$9$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                int intValue = ((Number) list.get(i5)).intValue();
                composer.startReplaceGroup(1954324538);
                DeveloperBottomSheetWithStickyScreenKt.Row(intValue, composer, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public static final Unit SheetContent$lambda$11(int i5, Composer composer, int i6) {
        SheetContent(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final Unit SheetContent$lambda$7$lambda$6(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$SheetContent(Composer composer, int i5) {
        SheetContent(composer, i5);
    }
}
