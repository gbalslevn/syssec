package dk.molslinjen.ui.views.screens.booking.departures.selectPassengers;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.reusable.input.PluralText;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.WalkingPassengerSelectionViewKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u001au\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$ViewState;", "viewState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$PassengerSelectionState;", "passengerState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountFormField;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", BuildConfig.FLAVOR, "enabled", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onAdultsChange", "onChildrenChange", "onInfantsChange", "WalkingPassengerSelectionView", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$ViewState;Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$PassengerSelectionState;Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountFormField;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class WalkingPassengerSelectionViewKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WalkingPassengerSelectionView(final PassengerCountSelectorViewModel.ViewState viewState, final PassengerCountSelectorViewModel.PassengerSelectionState passengerState, final PassengerCountFormField validationKey, final IFormValidator validator, boolean z5, final Function1<? super Integer, Unit> onAdultsChange, final Function1<? super Integer, Unit> onChildrenChange, final Function1<? super Integer, Unit> onInfantsChange, Composer composer, final int i5, final int i6) {
        int i7;
        boolean z6;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        Object rememberedValue;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(passengerState, "passengerState");
        Intrinsics.checkNotNullParameter(validationKey, "validationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(onAdultsChange, "onAdultsChange");
        Intrinsics.checkNotNullParameter(onChildrenChange, "onChildrenChange");
        Intrinsics.checkNotNullParameter(onInfantsChange, "onInfantsChange");
        Composer startRestartGroup = composer.startRestartGroup(2060989628);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(passengerState) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(validationKey) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= (i5 & 4096) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 2048 : 1024;
        }
        int i8 = i6 & 16;
        if (i8 != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
            if ((i6 & 32) == 0) {
                i7 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i7 |= startRestartGroup.changedInstance(onAdultsChange) ? 131072 : 65536;
            }
            if ((i6 & 64) == 0) {
                i7 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i7 |= startRestartGroup.changedInstance(onChildrenChange) ? 1048576 : 524288;
            }
            if ((i6 & 128) == 0) {
                i7 |= 12582912;
            } else if ((i5 & 12582912) == 0) {
                i7 |= startRestartGroup.changedInstance(onInfantsChange) ? 8388608 : 4194304;
            }
            if ((4793491 & i7) == 4793490 || !startRestartGroup.getSkipping()) {
                boolean z8 = i8 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2060989628, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.WalkingPassengerSelectionView (WalkingPassengerSelectionView.kt:41)");
                }
                validator.set(validationKey, PassengerCountValidator.INSTANCE.validateInput(passengerState.getAdults(), passengerState.getChildren(), passengerState.getInfants(), viewState.getTransportation().getAdultRequiredForInfants()));
                InputValidationError inputValidationError = (InputValidationError) ((Map) SnapshotStateKt.collectAsState(validator.getSubmittedErrors(), null, startRestartGroup, 0, 1).getValue()).get(validationKey);
                startRestartGroup.startReplaceGroup(1760030815);
                String errorMessage = inputValidationError != null ? null : inputValidationError.toErrorMessage((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), validationKey);
                startRestartGroup.endReplaceGroup();
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i9 = i7 << 9;
                int i10 = ((i7 >> 3) & 7168) | 48;
                final String str = errorMessage;
                int i11 = i7;
                NumberSelectorKt.NumberSelector(null, passengerState.getAdults(), 0, viewState.getTransportation().getAdultRequired() ? 1 : 0, viewState.getTransportation().getMaxPassengers(), new PluralText.Resource(R.plurals.passengers_adult), StringResources_androidKt.stringResource(R.string.passengers_adult_title, startRestartGroup, 6), null, onAdultsChange, onAdultsChange, null, true, false, z8, false, startRestartGroup, (i9 & 234881024) | ((i7 << 12) & 1879048192), i10, 21637);
                boolean z9 = str == null;
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(134057200);
                rememberedValue = composer2.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: O2.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit WalkingPassengerSelectionView$lambda$2$lambda$1$lambda$0;
                            WalkingPassengerSelectionView$lambda$2$lambda$1$lambda$0 = WalkingPassengerSelectionViewKt.WalkingPassengerSelectionView$lambda$2$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                            return WalkingPassengerSelectionView$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceGroup();
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z9, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1392138798, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.WalkingPassengerSelectionViewKt$WalkingPassengerSelectionView$1$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                        invoke(animatedVisibilityScope, composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i12) {
                        TextStyle m2295copyp1EtxEg;
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1392138798, i12, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.WalkingPassengerSelectionView.<anonymous>.<anonymous> (WalkingPassengerSelectionView.kt:75)");
                        }
                        String str2 = str;
                        if (str2 == null) {
                            str2 = BuildConfig.FLAVOR;
                        }
                        m2295copyp1EtxEg = r3.m2295copyp1EtxEg((r48 & 1) != 0 ? r3.spanStyle.m2255getColor0d7_KjU() : AppColor.INSTANCE.m3272getSignalRed0d7_KjU(), (r48 & 2) != 0 ? r3.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r3.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r3.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r3.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r3.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r3.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r3.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r3.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r3.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r3.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r3.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r3.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r3.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r3.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r3.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r3.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r3.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r3.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r3.platformStyle : null, (r48 & 1048576) != 0 ? r3.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r3.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r3.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSub().paragraphStyle.getTextMotion() : null);
                        TextKt.m940Text4IGK_g(str2, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer3, 48, 0, 65532);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 1572870, 28);
                float f5 = 16;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
                int i12 = i11 << 6;
                boolean z10 = z8;
                NumberSelectorKt.NumberSelector(null, passengerState.getChildren(), 0, 0, viewState.getTransportation().getMaxPassengers(), new PluralText.Resource(R.plurals.passengers_child), StringResources_androidKt.stringResource(R.string.passengers_child_title, new Object[]{viewState.getChildAgeRange()}, composer2, 6), null, onChildrenChange, onChildrenChange, null, true, false, z10, false, composer2, (i12 & 234881024) | 3072 | (i9 & 1879048192), i10, 21637);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
                NumberSelectorKt.NumberSelector(null, passengerState.getInfants(), 0, 0, viewState.getTransportation().getMaxPassengers(), new PluralText.Resource(R.plurals.passengers_infant), StringResources_androidKt.stringResource(R.string.passengers_infant_title, new Object[]{viewState.getInfantAgeRange()}, composer2, 6), null, onInfantsChange, onInfantsChange, null, true, false, z10, false, composer2, ((i11 << 3) & 234881024) | 3072 | (i12 & 1879048192), i10, 21637);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z8;
            } else {
                startRestartGroup.skipToGroupEnd();
                z7 = z6;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: O2.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit WalkingPassengerSelectionView$lambda$3;
                        WalkingPassengerSelectionView$lambda$3 = WalkingPassengerSelectionViewKt.WalkingPassengerSelectionView$lambda$3(PassengerCountSelectorViewModel.ViewState.this, passengerState, validationKey, validator, z7, onAdultsChange, onChildrenChange, onInfantsChange, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return WalkingPassengerSelectionView$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((i6 & 32) == 0) {
        }
        if ((i6 & 64) == 0) {
        }
        if ((i6 & 128) == 0) {
        }
        if ((4793491 & i7) == 4793490) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        validator.set(validationKey, PassengerCountValidator.INSTANCE.validateInput(passengerState.getAdults(), passengerState.getChildren(), passengerState.getInfants(), viewState.getTransportation().getAdultRequiredForInfants()));
        InputValidationError inputValidationError2 = (InputValidationError) ((Map) SnapshotStateKt.collectAsState(validator.getSubmittedErrors(), null, startRestartGroup, 0, 1).getValue()).get(validationKey);
        startRestartGroup.startReplaceGroup(1760030815);
        if (inputValidationError2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier.Companion companion3 = Modifier.INSTANCE;
        Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        int i92 = i7 << 9;
        int i102 = ((i7 >> 3) & 7168) | 48;
        final String str2 = errorMessage;
        int i112 = i7;
        NumberSelectorKt.NumberSelector(null, passengerState.getAdults(), 0, viewState.getTransportation().getAdultRequired() ? 1 : 0, viewState.getTransportation().getMaxPassengers(), new PluralText.Resource(R.plurals.passengers_adult), StringResources_androidKt.stringResource(R.string.passengers_adult_title, startRestartGroup, 6), null, onAdultsChange, onAdultsChange, null, true, false, z8, false, startRestartGroup, (i92 & 234881024) | ((i7 << 12) & 1879048192), i102, 21637);
        if (str2 == null) {
        }
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(134057200);
        rememberedValue = composer2.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        composer2.endReplaceGroup();
        AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance2, z9, SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue, 1, null), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1392138798, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.WalkingPassengerSelectionViewKt$WalkingPassengerSelectionView$1$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                invoke(animatedVisibilityScope, composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i122) {
                TextStyle m2295copyp1EtxEg;
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1392138798, i122, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.WalkingPassengerSelectionView.<anonymous>.<anonymous> (WalkingPassengerSelectionView.kt:75)");
                }
                String str22 = str2;
                if (str22 == null) {
                    str22 = BuildConfig.FLAVOR;
                }
                m2295copyp1EtxEg = r3.m2295copyp1EtxEg((r48 & 1) != 0 ? r3.spanStyle.m2255getColor0d7_KjU() : AppColor.INSTANCE.m3272getSignalRed0d7_KjU(), (r48 & 2) != 0 ? r3.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r3.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r3.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r3.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r3.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r3.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r3.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r3.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r3.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r3.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r3.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r3.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r3.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r3.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r3.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r3.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r3.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r3.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r3.platformStyle : null, (r48 & 1048576) != 0 ? r3.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r3.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r3.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSub().paragraphStyle.getTextMotion() : null);
                TextKt.m940Text4IGK_g(str22, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer3, 48, 0, 65532);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer2, 54), composer2, 1572870, 28);
        float f52 = 16;
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(f52)), composer2, 6);
        int i122 = i112 << 6;
        boolean z102 = z8;
        NumberSelectorKt.NumberSelector(null, passengerState.getChildren(), 0, 0, viewState.getTransportation().getMaxPassengers(), new PluralText.Resource(R.plurals.passengers_child), StringResources_androidKt.stringResource(R.string.passengers_child_title, new Object[]{viewState.getChildAgeRange()}, composer2, 6), null, onChildrenChange, onChildrenChange, null, true, false, z102, false, composer2, (i122 & 234881024) | 3072 | (i92 & 1879048192), i102, 21637);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(f52)), composer2, 6);
        NumberSelectorKt.NumberSelector(null, passengerState.getInfants(), 0, 0, viewState.getTransportation().getMaxPassengers(), new PluralText.Resource(R.plurals.passengers_infant), StringResources_androidKt.stringResource(R.string.passengers_infant_title, new Object[]{viewState.getInfantAgeRange()}, composer2, 6), null, onInfantsChange, onInfantsChange, null, true, false, z102, false, composer2, ((i112 << 3) & 234881024) | 3072 | (i122 & 1879048192), i102, 21637);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z8;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WalkingPassengerSelectionView$lambda$2$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2161getAssertive0phEisY());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WalkingPassengerSelectionView$lambda$3(PassengerCountSelectorViewModel.ViewState viewState, PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState, PassengerCountFormField passengerCountFormField, IFormValidator iFormValidator, boolean z5, Function1 function1, Function1 function12, Function1 function13, int i5, int i6, Composer composer, int i7) {
        WalkingPassengerSelectionView(viewState, passengerSelectionState, passengerCountFormField, iFormValidator, z5, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
