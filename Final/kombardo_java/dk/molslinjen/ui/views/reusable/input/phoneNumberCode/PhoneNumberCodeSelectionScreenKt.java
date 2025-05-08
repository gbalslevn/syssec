package dk.molslinjen.ui.views.reusable.input.phoneNumberCode;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.LocaleExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.LocaleWithPhoneNumberCode;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionScreenKt;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001aM\u0010\u0010\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0014\u001a\u00020\u00052\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a3\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/phoneNumberCode/PhoneNumberCodeSelectionViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/result/ResultBackNavigator;", BuildConfig.FLAVOR, "resultNavigator", BuildConfig.FLAVOR, "PhoneNumberCodeSelectionScreen", "(Ldk/molslinjen/ui/views/reusable/input/phoneNumberCode/PhoneNumberCodeSelectionViewModel;Lcom/ramcosta/composedestinations/result/ResultBackNavigator;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/phoneNumberCode/LocaleWithPhoneNumberCode;", "frequentlyUsed", "others", "Lkotlin/Function1;", "onPhoneNumberCodeSelected", "Lkotlin/Function0;", "onDismiss", "PhoneNumberCodeSelectionContent", "(Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "textRes", "PhoneNumberCodeHeader", "(ILandroidx/compose/runtime/Composer;I)V", "localeWithPhoneNumberCode", BuildConfig.FLAVOR, "showFlag", "PhoneNumberCodeItem", "(Ldk/molslinjen/ui/views/reusable/input/phoneNumberCode/LocaleWithPhoneNumberCode;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PhoneNumberCodeSelectionScreenKt {
    public static final void PhoneNumberCodeHeader(final int i5, Composer composer, final int i6) {
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(897119955);
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
                ComposerKt.traceEventStart(897119955, i7, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeHeader (PhoneNumberCodeSelectionScreen.kt:95)");
            }
            float f5 = 24;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i5, startRestartGroup, i7 & 14), PaddingKt.m312paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 48, 1572864, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PhoneNumberCodeHeader$lambda$4;
                    PhoneNumberCodeHeader$lambda$4 = PhoneNumberCodeSelectionScreenKt.PhoneNumberCodeHeader$lambda$4(i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PhoneNumberCodeHeader$lambda$4;
                }
            });
        }
    }

    public static final Unit PhoneNumberCodeHeader$lambda$4(int i5, int i6, Composer composer, int i7) {
        PhoneNumberCodeHeader(i5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }

    public static final void PhoneNumberCodeItem(final LocaleWithPhoneNumberCode localeWithPhoneNumberCode, final Function1<? super String, Unit> function1, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer composer3;
        Integer flag;
        Composer startRestartGroup = composer.startRestartGroup(584264023);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(localeWithPhoneNumberCode) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(584264023, i6, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeItem (PhoneNumberCodeSelectionScreen.kt:110)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(-463656186);
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(localeWithPhoneNumberCode);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: h2.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PhoneNumberCodeItem$lambda$6$lambda$5;
                        PhoneNumberCodeItem$lambda$6$lambda$5 = PhoneNumberCodeSelectionScreenKt.PhoneNumberCodeItem$lambda$6$lambda$5(Function1.this, localeWithPhoneNumberCode);
                        return PhoneNumberCodeItem$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue, 7, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f5 = 16;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion, Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(f5));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1935850782);
            if (!z5 || (flag = LocaleExtensionsKt.getFlag(localeWithPhoneNumberCode.getLocale())) == null) {
                composer2 = startRestartGroup;
            } else {
                composer2 = startRestartGroup;
                ImageKt.Image(PainterResources_androidKt.painterResource(flag.intValue(), startRestartGroup, 0), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
            }
            composer2.endReplaceGroup();
            String displayCountry = localeWithPhoneNumberCode.getLocale().getDisplayCountry();
            Intrinsics.checkNotNullExpressionValue(displayCountry, "getDisplayCountry(...)");
            TextKt.m940Text4IGK_g(displayCountry, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 0, 1572864, 65534);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            composer3 = composer2;
            SpacerKt.Spacer(weight$default, composer3, 0);
            TextKt.m940Text4IGK_g("+" + localeWithPhoneNumberCode.getPhoneNumberCode(), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer3, 384, 1572864, 65530);
            composer3.endNode();
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer3, 0, 15);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PhoneNumberCodeItem$lambda$10;
                    PhoneNumberCodeItem$lambda$10 = PhoneNumberCodeSelectionScreenKt.PhoneNumberCodeItem$lambda$10(LocaleWithPhoneNumberCode.this, function1, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PhoneNumberCodeItem$lambda$10;
                }
            });
        }
    }

    public static final Unit PhoneNumberCodeItem$lambda$10(LocaleWithPhoneNumberCode localeWithPhoneNumberCode, Function1 function1, boolean z5, int i5, Composer composer, int i6) {
        PhoneNumberCodeItem(localeWithPhoneNumberCode, function1, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final Unit PhoneNumberCodeItem$lambda$6$lambda$5(Function1 function1, LocaleWithPhoneNumberCode localeWithPhoneNumberCode) {
        function1.invoke("+" + localeWithPhoneNumberCode.getPhoneNumberCode());
        return Unit.INSTANCE;
    }

    private static final void PhoneNumberCodeSelectionContent(final List<LocaleWithPhoneNumberCode> list, final List<LocaleWithPhoneNumberCode> list2, final Function1<? super String, Unit> function1, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-2015501879);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(list2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2015501879, i6, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionContent (PhoneNumberCodeSelectionScreen.kt:57)");
            }
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(null, 0.0f, StringResources_androidKt.stringResource(R.string.phoneNumberCodeSelection_title, startRestartGroup, 6), null, 0L, null, function0, rememberLazyListState, null, ComposableLambdaKt.rememberComposableLambda(-843341924, true, new PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionContent$1(rememberLazyListState, list, function1, list2), startRestartGroup, 54), startRestartGroup, ((i6 << 9) & 3670016) | 805306368, 315);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PhoneNumberCodeSelectionContent$lambda$3;
                    PhoneNumberCodeSelectionContent$lambda$3 = PhoneNumberCodeSelectionScreenKt.PhoneNumberCodeSelectionContent$lambda$3(list, list2, function1, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PhoneNumberCodeSelectionContent$lambda$3;
                }
            });
        }
    }

    public static final Unit PhoneNumberCodeSelectionContent$lambda$3(List list, List list2, Function1 function1, Function0 function0, int i5, Composer composer, int i6) {
        PhoneNumberCodeSelectionContent(list, list2, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PhoneNumberCodeSelectionScreen(final PhoneNumberCodeSelectionViewModel viewModel, final ResultBackNavigator<String> resultNavigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(resultNavigator, "resultNavigator");
        Composer startRestartGroup = composer.startRestartGroup(-1325733018);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(resultNavigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1325733018, i6, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodeSelectionScreen (PhoneNumberCodeSelectionScreen.kt:40)");
            }
            PhoneNumberCodeSelectionViewModel.ViewState viewState = (PhoneNumberCodeSelectionViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            List<LocaleWithPhoneNumberCode> frequentlyUsed = viewState.getFrequentlyUsed();
            List<LocaleWithPhoneNumberCode> others = viewState.getOthers();
            startRestartGroup.startReplaceGroup(-210866908);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionScreen$1$1(resultNavigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(-210865276);
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new PhoneNumberCodeSelectionScreenKt$PhoneNumberCodeSelectionScreen$2$1(resultNavigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            PhoneNumberCodeSelectionContent(frequentlyUsed, others, function1, (Function0) ((KFunction) rememberedValue2), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PhoneNumberCodeSelectionScreen$lambda$2;
                    PhoneNumberCodeSelectionScreen$lambda$2 = PhoneNumberCodeSelectionScreenKt.PhoneNumberCodeSelectionScreen$lambda$2(PhoneNumberCodeSelectionViewModel.this, resultNavigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PhoneNumberCodeSelectionScreen$lambda$2;
                }
            });
        }
    }

    public static final Unit PhoneNumberCodeSelectionScreen$lambda$2(PhoneNumberCodeSelectionViewModel phoneNumberCodeSelectionViewModel, ResultBackNavigator resultBackNavigator, int i5, Composer composer, int i6) {
        PhoneNumberCodeSelectionScreen(phoneNumberCodeSelectionViewModel, resultBackNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$PhoneNumberCodeHeader(int i5, Composer composer, int i6) {
        PhoneNumberCodeHeader(i5, composer, i6);
    }

    public static final /* synthetic */ void access$PhoneNumberCodeItem(LocaleWithPhoneNumberCode localeWithPhoneNumberCode, Function1 function1, boolean z5, Composer composer, int i5) {
        PhoneNumberCodeItem(localeWithPhoneNumberCode, function1, z5, composer, i5);
    }
}
