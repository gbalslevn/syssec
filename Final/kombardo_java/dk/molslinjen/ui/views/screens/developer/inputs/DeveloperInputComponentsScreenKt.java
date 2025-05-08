package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsScreenKt;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"DeveloperInputComponentsScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/developer/inputs/DeveloperInputComponentsViewModel;", "(Ldk/molslinjen/ui/views/screens/developer/inputs/DeveloperInputComponentsViewModel;Landroidx/compose/runtime/Composer;I)V", "DeveloperSectionHeader", Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd", "typeToShow", "Ldk/molslinjen/ui/views/screens/developer/inputs/InputType;"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperInputComponentsScreenKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputType.values().length];
            try {
                iArr[InputType.Buttons.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputType.TextField.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputType.PhoneNumbers.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InputType.Others.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[InputType.TickersAndCheckboxes.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void DeveloperInputComponentsScreen(final DeveloperInputComponentsViewModel viewModel, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer startRestartGroup = composer.startRestartGroup(-914907942);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(viewModel) : startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-914907942, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputComponentsScreen (DeveloperInputComponentsScreen.kt:31)");
            }
            startRestartGroup.startReplaceGroup(1897363180);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputType.Buttons, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null), Dp.m2599constructorimpl(16));
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            int i7 = i6;
            TextKt.m940Text4IGK_g("Inputs", PaddingKt.m311padding3ABfNKs(companion2, Dp.m2599constructorimpl(12)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 54, 1572864, 65532);
            composer2 = startRestartGroup;
            FlowLayoutKt.FlowRow(null, arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(8)), null, 0, 0, null, ComposableLambdaKt.rememberComposableLambda(885332767, true, new DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$1(mutableState), composer2, 54), composer2, 1572912, 61);
            int i8 = WhenMappings.$EnumSwitchMapping$0[DeveloperInputComponentsScreen$lambda$1(mutableState).ordinal()];
            if (i8 == 1) {
                composer2.startReplaceGroup(2131507627);
                composer2.startReplaceGroup(2131508308);
                boolean z5 = (i7 & 14) == 4 || ((i7 & 8) != 0 && composer2.changedInstance(viewModel));
                Object rememberedValue2 = composer2.rememberedValue();
                if (z5 || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$2$1(viewModel);
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceGroup();
                DeveloperInputButtonsKt.DeveloperInputButtons((Function1) ((KFunction) rememberedValue2), composer2, 0);
                composer2.endReplaceGroup();
            } else if (i8 == 2) {
                composer2.startReplaceGroup(2131510231);
                DeveloperInputTextFieldsKt.DeveloperInputTextFields(composer2, 0);
                composer2.endReplaceGroup();
            } else if (i8 == 3) {
                composer2.startReplaceGroup(2131512318);
                DeveloperInputPhoneNumberFieldsKt.DeveloperInputPhoneNumberFields(composer2, 0);
                composer2.endReplaceGroup();
            } else if (i8 == 4) {
                composer2.startReplaceGroup(2131514442);
                composer2.startReplaceGroup(2131515092);
                boolean z6 = (i7 & 14) == 4 || ((i7 & 8) != 0 && composer2.changedInstance(viewModel));
                Object rememberedValue3 = composer2.rememberedValue();
                if (z6 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$3$1(viewModel);
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceGroup();
                DeveloperInputOthersKt.DeveloperInputOthers((Function1) ((KFunction) rememberedValue3), composer2, 0);
                composer2.endReplaceGroup();
            } else {
                if (i8 != 5) {
                    composer2.startReplaceGroup(2131506312);
                    composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer2.startReplaceGroup(2131517400);
                composer2.startReplaceGroup(2131518484);
                boolean z7 = (i7 & 14) == 4 || ((i7 & 8) != 0 && composer2.changedInstance(viewModel));
                Object rememberedValue4 = composer2.rememberedValue();
                if (z7 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new DeveloperInputComponentsScreenKt$DeveloperInputComponentsScreen$1$4$1(viewModel);
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceGroup();
                DeveloperInputTickersAndCheckboxesKt.DeveloperInputTickersAndCheckboxes((Function1) ((KFunction) rememberedValue4), composer2, 0);
                composer2.endReplaceGroup();
            }
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.D
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperInputComponentsScreen$lambda$7;
                    DeveloperInputComponentsScreen$lambda$7 = DeveloperInputComponentsScreenKt.DeveloperInputComponentsScreen$lambda$7(DeveloperInputComponentsViewModel.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperInputComponentsScreen$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputType DeveloperInputComponentsScreen$lambda$1(MutableState<InputType> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputComponentsScreen$lambda$7(DeveloperInputComponentsViewModel developerInputComponentsViewModel, int i5, Composer composer, int i6) {
        DeveloperInputComponentsScreen(developerInputComponentsViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void DeveloperSectionHeader(final String title, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer startRestartGroup = composer.startRestartGroup(376503559);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(title) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(376503559, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperSectionHeader (DeveloperInputComponentsScreen.kt:81)");
            }
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(title, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer2, (i6 & 14) | 48, 1572864, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.E
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperSectionHeader$lambda$8;
                    DeveloperSectionHeader$lambda$8 = DeveloperInputComponentsScreenKt.DeveloperSectionHeader$lambda$8(title, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperSectionHeader$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperSectionHeader$lambda$8(String str, int i5, Composer composer, int i6) {
        DeveloperSectionHeader(str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
