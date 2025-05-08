package dk.molslinjen.ui.views.screens.developer.inputs;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.snackbar.SnackbarAction;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.SegmentedControlKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.reusable.input.BirthdateInputKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.GenderPickerKt;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalityPickerKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonNullCustomValidator;
import dk.molslinjen.ui.views.reusable.modifiers.SkeletonKt;
import dk.molslinjen.ui.views.reusable.swipe.SwipeToDeleteKt;
import dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputOthersKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u000f\u0010\u0006\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u000f\u0010\b\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\b\u0010\u0007\u001a\u000f\u0010\t\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\t\u0010\u0007\u001a#\u0010\n\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\u0003¢\u0006\u0004\b\n\u0010\u0005\u001a\u000f\u0010\u000b\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u000f\u0010\f\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\f\u0010\u0007¨\u0006\u0017²\u0006\u000e\u0010\u000e\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u000f\u001a\u00020\r8\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00108\n@\nX\u008a\u008e\u0002²\u0006\u0016\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\n@\nX\u008a\u008e\u0002²\u0006\u0016\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00150\u00158\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function1;", "Ldk/molslinjen/core/snackbar/SnackbarEvent;", BuildConfig.FLAVOR, "showSnackbar", "DeveloperInputOthers", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SegmentedControls", "(Landroidx/compose/runtime/Composer;I)V", "SkeletonSections", "SwipeToDeleteSection", "SnackbarSection", "DividerSection", "PickerControls", BuildConfig.FLAVOR, "dualSegmentedSelectedIndex", "tripleSegmentedSelectedIndex", "Ldk/molslinjen/domain/model/account/Gender;", "gender", "Ljava/util/Locale;", "kotlin.jvm.PlatformType", "nationalityLocale", "Lorg/threeten/bp/LocalDate;", "birthdate", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeveloperInputOthersKt {
    public static final void DeveloperInputOthers(final Function1<? super SnackbarEvent, Unit> showSnackbar, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(showSnackbar, "showSnackbar");
        Composer startRestartGroup = composer.startRestartGroup(1552120645);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(showSnackbar) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1552120645, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputOthers (DeveloperInputOthers.kt:34)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("SegmentedControl", startRestartGroup, 6);
            SegmentedControls(startRestartGroup, 0);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Skeleton", startRestartGroup, 6);
            SkeletonSections(startRestartGroup, 0);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Swipe to ...", startRestartGroup, 6);
            SwipeToDeleteSection(startRestartGroup, 0);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Snackbar (Click text to show)", startRestartGroup, 6);
            SnackbarSection(showSnackbar, startRestartGroup, i6 & 14);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Dividers", startRestartGroup, 6);
            DividerSection(startRestartGroup, 0);
            DeveloperInputComponentsScreenKt.DeveloperSectionHeader("Pickers", startRestartGroup, 6);
            PickerControls(startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.F
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeveloperInputOthers$lambda$1;
                    DeveloperInputOthers$lambda$1 = DeveloperInputOthersKt.DeveloperInputOthers$lambda$1(Function1.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeveloperInputOthers$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeveloperInputOthers$lambda$1(Function1 function1, int i5, Composer composer, int i6) {
        DeveloperInputOthers(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void DividerSection(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(417665489);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(417665489, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.DividerSection (DeveloperInputOthers.kt:263)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(56)), 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            startRestartGroup.startReplaceGroup(-1020708102);
            IntRange intRange = new IntRange(0, 3);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
                ArrayList arrayList2 = arrayList;
                VerticalDividerKt.m3394VerticalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
                arrayList2.add(Unit.INSTANCE);
                arrayList = arrayList2;
            }
            startRestartGroup.endReplaceGroup();
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.V
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DividerSection$lambda$48;
                    DividerSection$lambda$48 = DeveloperInputOthersKt.DividerSection$lambda$48(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DividerSection$lambda$48;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DividerSection$lambda$48(int i5, Composer composer, int i6) {
        DividerSection(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void PickerControls(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(1862090489);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1862090489, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.PickerControls (DeveloperInputOthers.kt:280)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-1692388325);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(DeveloperPickerControlFields.Gender, NonNullCustomValidator.Gender.INSTANCE), TuplesKt.to(DeveloperPickerControlFields.Birthdate, NonNullCustomValidator.Birthdate.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16));
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m265spacedBy0680j_4, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            startRestartGroup.startReplaceGroup(-1521142624);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Gender PickerControls$lambda$65$lambda$51 = PickerControls$lambda$65$lambda$51(mutableState);
            startRestartGroup.startReplaceGroup(-1521138738);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: m3.Y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PickerControls$lambda$65$lambda$54$lambda$53;
                        PickerControls$lambda$65$lambda$54$lambda$53 = DeveloperInputOthersKt.PickerControls$lambda$65$lambda$54$lambda$53(MutableState.this, (Gender) obj);
                        return PickerControls$lambda$65$lambda$54$lambda$53;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            GenderPickerKt.GenderPicker(null, PickerControls$lambda$65$lambda$51, (Function1) rememberedValue4, true, DeveloperPickerControlFields.Gender, formValidator, startRestartGroup, 28032, 1);
            startRestartGroup.startReplaceGroup(-1521132529);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Locale.getDefault(), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            Locale PickerControls$lambda$65$lambda$56 = PickerControls$lambda$65$lambda$56((MutableState) rememberedValue5);
            startRestartGroup.startReplaceGroup(-1521128415);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: m3.Z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            NationalityPickerKt.NationalityPicker(null, PickerControls$lambda$65$lambda$56, (Function0) rememberedValue6, null, true, startRestartGroup, 24960, 9);
            startRestartGroup.startReplaceGroup(-1521126726);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LocalDate.now().minusYears(30L), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            LocalDate PickerControls$lambda$65$lambda$61 = PickerControls$lambda$65$lambda$61(mutableState2);
            startRestartGroup.startReplaceGroup(-1521121935);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: m3.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PickerControls$lambda$65$lambda$64$lambda$63;
                        PickerControls$lambda$65$lambda$64$lambda$63 = DeveloperInputOthersKt.PickerControls$lambda$65$lambda$64$lambda$63(MutableState.this, (LocalDate) obj);
                        return PickerControls$lambda$65$lambda$64$lambda$63;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            BirthdateInputKt.BirthdateInput(null, PickerControls$lambda$65$lambda$61, null, null, null, (Function1) rememberedValue8, true, false, DeveloperPickerControlFields.Birthdate, formValidator, startRestartGroup, 102432768, 157);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PickerControls$lambda$66;
                    PickerControls$lambda$66 = DeveloperInputOthersKt.PickerControls$lambda$66(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PickerControls$lambda$66;
                }
            });
        }
    }

    private static final Gender PickerControls$lambda$65$lambda$51(MutableState<Gender> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PickerControls$lambda$65$lambda$54$lambda$53(MutableState mutableState, Gender gender) {
        mutableState.setValue(gender);
        return Unit.INSTANCE;
    }

    private static final Locale PickerControls$lambda$65$lambda$56(MutableState<Locale> mutableState) {
        return mutableState.getValue();
    }

    private static final LocalDate PickerControls$lambda$65$lambda$61(MutableState<LocalDate> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PickerControls$lambda$65$lambda$64$lambda$63(MutableState mutableState, LocalDate localDate) {
        mutableState.setValue(localDate);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PickerControls$lambda$66(int i5, Composer composer, int i6) {
        PickerControls(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void SegmentedControls(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(1453776529);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1453776529, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.SegmentedControls (DeveloperInputOthers.kt:57)");
            }
            startRestartGroup.startReplaceGroup(280361514);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            List listOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.ticketsScreen_title), Integer.valueOf(R.string.departuresScreen_title)});
            int SegmentedControls$lambda$3 = SegmentedControls$lambda$3(mutableState);
            startRestartGroup.startReplaceGroup(280370603);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: m3.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SegmentedControls$lambda$6$lambda$5;
                        SegmentedControls$lambda$6$lambda$5 = DeveloperInputOthersKt.SegmentedControls$lambda$6$lambda$5(MutableState.this, ((Integer) obj).intValue());
                        return SegmentedControls$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            SegmentedControlKt.SegmentedControlStringRes(m315paddingqDBjuR0$default, listOf, SegmentedControls$lambda$3, (Function1) rememberedValue2, startRestartGroup, 3126, 0);
            startRestartGroup.startReplaceGroup(280374122);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            List listOf2 = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.ticketsScreen_title), Integer.valueOf(R.string.departuresScreen_title), Integer.valueOf(R.string.cateringScreen_title)});
            int SegmentedControls$lambda$8 = SegmentedControls$lambda$8(mutableState2);
            startRestartGroup.startReplaceGroup(280384269);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: m3.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SegmentedControls$lambda$11$lambda$10;
                        SegmentedControls$lambda$11$lambda$10 = DeveloperInputOthersKt.SegmentedControls$lambda$11$lambda$10(MutableState.this, ((Integer) obj).intValue());
                        return SegmentedControls$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            SegmentedControlKt.SegmentedControlStringRes(m315paddingqDBjuR0$default2, listOf2, SegmentedControls$lambda$8, (Function1) rememberedValue4, startRestartGroup, 3126, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.G
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SegmentedControls$lambda$12;
                    SegmentedControls$lambda$12 = DeveloperInputOthersKt.SegmentedControls$lambda$12(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SegmentedControls$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedControls$lambda$11$lambda$10(MutableState mutableState, int i5) {
        SegmentedControls$lambda$9(mutableState, i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedControls$lambda$12(int i5, Composer composer, int i6) {
        SegmentedControls(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final int SegmentedControls$lambda$3(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void SegmentedControls$lambda$4(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SegmentedControls$lambda$6$lambda$5(MutableState mutableState, int i5) {
        SegmentedControls$lambda$4(mutableState, i5);
        return Unit.INSTANCE;
    }

    private static final int SegmentedControls$lambda$8(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    private static final void SegmentedControls$lambda$9(MutableState<Integer> mutableState, int i5) {
        mutableState.setValue(Integer.valueOf(i5));
    }

    private static final void SkeletonSections(Composer composer, final int i5) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1490162786);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1490162786, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.SkeletonSections (DeveloperInputOthers.kt:78)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(companion, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(24));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
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
            TextKt.m940Text4IGK_g("This is the title", SkeletonKt.m3425skeletont9lfQc4$default(companion, true, null, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131068);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), startRestartGroup, 6);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            TextKt.m940Text4IGK_g("Text 1", SkeletonKt.m3425skeletont9lfQc4$default(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), true, null, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 6, 0, 131068);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
            Modifier m3425skeletont9lfQc4$default = SkeletonKt.m3425skeletont9lfQc4$default(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), true, null, 2, null);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g("Text 2", m3425skeletont9lfQc4$default, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 6, 0, 131068);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.X
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SkeletonSections$lambda$15;
                    SkeletonSections$lambda$15 = DeveloperInputOthersKt.SkeletonSections$lambda$15(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SkeletonSections$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SkeletonSections$lambda$15(int i5, Composer composer, int i6) {
        SkeletonSections(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void SnackbarSection(final Function1<? super SnackbarEvent, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1593113510);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1593113510, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.SnackbarSection (DeveloperInputOthers.kt:140)");
            }
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16));
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m265spacedBy0680j_4, Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1738885427);
            int i7 = i6 & 14;
            boolean z5 = i7 == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: m3.H
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$23$lambda$22;
                        SnackbarSection$lambda$44$lambda$23$lambda$22 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$23$lambda$22(Function1.this);
                        return SnackbarSection$lambda$44$lambda$23$lambda$22;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue, 7, null);
            TextDecoration.Companion companion3 = TextDecoration.INSTANCE;
            TextKt.m940Text4IGK_g("Default snackbar", m122clickableXHw0xAI$default, 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1738899348);
            boolean z6 = i7 == 4;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: m3.K
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$25$lambda$24;
                        SnackbarSection$lambda$44$lambda$25$lambda$24 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$25$lambda$24(Function1.this);
                        return SnackbarSection$lambda$44$lambda$25$lambda$24;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Default snackbar + icon", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue2, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1738915751);
            boolean z7 = i7 == 4;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: m3.L
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$27$lambda$26;
                        SnackbarSection$lambda$44$lambda$27$lambda$26 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$27$lambda$26(Function1.this);
                        return SnackbarSection$lambda$44$lambda$27$lambda$26;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Default snackbar + action", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue3, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1738939401);
            boolean z8 = i7 == 4;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: m3.M
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$29$lambda$28;
                        SnackbarSection$lambda$44$lambda$29$lambda$28 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$29$lambda$28(Function1.this);
                        return SnackbarSection$lambda$44$lambda$29$lambda$28;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Information snackbar", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue4, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1738952249);
            boolean z9 = i7 == 4;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: m3.N
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$31$lambda$30;
                        SnackbarSection$lambda$44$lambda$31$lambda$30 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$31$lambda$30(Function1.this);
                        return SnackbarSection$lambda$44$lambda$31$lambda$30;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Information snackbar + action", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue5, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1738971679);
            boolean z10 = i7 == 4;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: m3.O
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$33$lambda$32;
                        SnackbarSection$lambda$44$lambda$33$lambda$32 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$33$lambda$32(Function1.this);
                        return SnackbarSection$lambda$44$lambda$33$lambda$32;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Complete update", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue6, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1738985687);
            boolean z11 = i7 == 4;
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: m3.P
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$35$lambda$34;
                        SnackbarSection$lambda$44$lambda$35$lambda$34 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$35$lambda$34(Function1.this);
                        return SnackbarSection$lambda$44$lambda$35$lambda$34;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Update download in progress", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue7, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1738993873);
            boolean z12 = i7 == 4;
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (z12 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: m3.S
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$37$lambda$36;
                        SnackbarSection$lambda$44$lambda$37$lambda$36 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$37$lambda$36(Function1.this);
                        return SnackbarSection$lambda$44$lambda$37$lambda$36;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Network error (Default error)", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue8, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1739002017);
            boolean z13 = i7 == 4;
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (z13 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new Function0() { // from class: m3.T
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$39$lambda$38;
                        SnackbarSection$lambda$44$lambda$39$lambda$38 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$39$lambda$38(Function1.this);
                        return SnackbarSection$lambda$44$lambda$39$lambda$38;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Network error (Custom error)", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue9, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1739012522);
            boolean z14 = i7 == 4;
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (z14 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new Function0() { // from class: m3.U
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$41$lambda$40;
                        SnackbarSection$lambda$44$lambda$41$lambda$40 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$41$lambda$40(Function1.this);
                        return SnackbarSection$lambda$44$lambda$41$lambda$40;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceGroup();
            TextKt.m940Text4IGK_g("Error default", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue10, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 100663302, 0, 130812);
            startRestartGroup.startReplaceGroup(1739019922);
            boolean z15 = i7 == 4;
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (z15 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: m3.I
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SnackbarSection$lambda$44$lambda$43$lambda$42;
                        SnackbarSection$lambda$44$lambda$43$lambda$42 = DeveloperInputOthersKt.SnackbarSection$lambda$44$lambda$43$lambda$42(Function1.this);
                        return SnackbarSection$lambda$44$lambda$43$lambda$42;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g("Error default", ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue11, 7, null), 0L, 0L, null, null, null, 0L, companion3.getUnderline(), null, 0L, 0, false, 0, 0, null, null, composer2, 100663302, 0, 130812);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.J
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SnackbarSection$lambda$45;
                    SnackbarSection$lambda$45 = DeveloperInputOthersKt.SnackbarSection$lambda$45(Function1.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SnackbarSection$lambda$45;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$23$lambda$22(Function1 function1) {
        function1.invoke(new SnackbarEvent.Default(new SnackbarText.StringText("This is a snackbar"), null, false, SnackbarDuration.Short, null, 22, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$25$lambda$24(Function1 function1) {
        function1.invoke(new SnackbarEvent.Default(new SnackbarText.StringText("This is a snackbar"), null, false, SnackbarDuration.Short, Integer.valueOf(R.drawable.icon_alert_warning), 6, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$27$lambda$26(Function1 function1) {
        function1.invoke(new SnackbarEvent.Default(new SnackbarText.StringText("This is a default snackbar. So long that it will wrap over multiple lines."), new SnackbarAction(new SnackbarText.StringText("Undo"), new DeveloperInputOthersKt$SnackbarSection$1$3$1$1(null)), false, SnackbarDuration.Short, Integer.valueOf(R.drawable.icon_delete), 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$29$lambda$28(Function1 function1) {
        function1.invoke(new SnackbarEvent.Information(new SnackbarText.StringText("This is an information snackbar"), null, false, 6, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$31$lambda$30(Function1 function1) {
        function1.invoke(new SnackbarEvent.Information(new SnackbarText.StringText("This is an information snackbar with an action"), new SnackbarAction(new SnackbarText.StringText("Undo"), new DeveloperInputOthersKt$SnackbarSection$1$5$1$1(null)), false, 4, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$33$lambda$32(Function1 function1) {
        function1.invoke(new SnackbarEvent.CompleteUpdate(new SnackbarAction(new SnackbarText.ResourceText(R.string.forceUpdate_restart), new DeveloperInputOthersKt$SnackbarSection$1$6$1$1(null))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$35$lambda$34(Function1 function1) {
        function1.invoke(SnackbarEvent.UpdateDownloadInProgress.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$37$lambda$36(Function1 function1) {
        function1.invoke(new SnackbarEvent.NetworkError(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$39$lambda$38(Function1 function1) {
        function1.invoke(new SnackbarEvent.NetworkError(new SnackbarText.StringText("This is a snackbar network error with a provided message.")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$41$lambda$40(Function1 function1) {
        function1.invoke(new SnackbarEvent.Error(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$44$lambda$43$lambda$42(Function1 function1) {
        function1.invoke(new SnackbarEvent.Error(new SnackbarText.StringText("This is a snackbar error with a provided message.")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SnackbarSection$lambda$45(Function1 function1, int i5, Composer composer, int i6) {
        SnackbarSection(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void SwipeToDeleteSection(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(1287273560);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1287273560, i5, -1, "dk.molslinjen.ui.views.screens.developer.inputs.SwipeToDeleteSection (DeveloperInputOthers.kt:110)");
            }
            startRestartGroup.startReplaceGroup(860234814);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5");
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final SnapshotStateList<String> snapshotStateList = (SnapshotStateList) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-701235982);
            for (final String str : snapshotStateList) {
                startRestartGroup.startMovableGroup(-45223287, str);
                startRestartGroup.startReplaceGroup(-45220323);
                boolean changed = startRestartGroup.changed(str);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: m3.Q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SwipeToDeleteSection$lambda$20$lambda$19$lambda$18$lambda$17;
                            SwipeToDeleteSection$lambda$20$lambda$19$lambda$18$lambda$17 = DeveloperInputOthersKt.SwipeToDeleteSection$lambda$20$lambda$19$lambda$18$lambda$17(SnapshotStateList.this, str);
                            return SwipeToDeleteSection$lambda$20$lambda$19$lambda$18$lambda$17;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                SwipeToDeleteKt.SwipeToDelete((Function0) rememberedValue2, false, ComposableLambdaKt.rememberComposableLambda(-617733482, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.inputs.DeveloperInputOthersKt$SwipeToDeleteSection$1$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                        invoke(rowScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope SwipeToDelete, Composer composer2, int i6) {
                        Intrinsics.checkNotNullParameter(SwipeToDelete, "$this$SwipeToDelete");
                        if ((i6 & 17) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-617733482, i6, -1, "dk.molslinjen.ui.views.screens.developer.inputs.SwipeToDeleteSection.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeveloperInputOthers.kt:123)");
                        }
                        Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), 0.0f, 1, null), Dp.m2599constructorimpl(24));
                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        String str2 = str;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m311padding3ABfNKs);
                        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                        if (composer2.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        TextKt.m940Text4IGK_g(str2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 384, 2);
                startRestartGroup.endMovableGroup();
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: m3.W
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SwipeToDeleteSection$lambda$21;
                    SwipeToDeleteSection$lambda$21 = DeveloperInputOthersKt.SwipeToDeleteSection$lambda$21(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SwipeToDeleteSection$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDeleteSection$lambda$20$lambda$19$lambda$18$lambda$17(SnapshotStateList snapshotStateList, String str) {
        snapshotStateList.remove(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwipeToDeleteSection$lambda$21(int i5, Composer composer, int i6) {
        SwipeToDeleteSection(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
