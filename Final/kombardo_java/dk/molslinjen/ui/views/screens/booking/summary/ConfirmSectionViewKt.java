package dk.molslinjen.ui.views.screens.booking.summary;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.site.SiteInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.ButtonWithPriceKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import dk.molslinjen.ui.views.screens.booking.summary.ConfirmSectionViewKt;
import dk.molslinjen.ui.views.screens.profile.newsletters.NewsletterAgreementTextViewKt;
import dk.molslinjen.ui.views.shared.TermsAndLicenseCheckboxKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\u001aÑ\u0001\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010#\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0003¢\u0006\u0004\b#\u0010$\u001ag\u0010&\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00182\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0004\b&\u0010'\u001aW\u0010(\u001a\u00020\u00152\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u00182\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Ldk/molslinjen/domain/model/site/SiteInfo;", "siteInfo", BuildConfig.FLAVOR, "readyToProceed", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "totalPrice", "signedUpForNewsletter", "acceptedMarketing", "termsAccepted", "isEarlyCheckInPossible", "makeEarlyCheckIn", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/model/account/UserVehicle;", "selectedVehicle", "Ldk/molslinjen/domain/model/booking/Departure;", "outboundDeparture", "returnDeparture", "Lkotlin/Function0;", BuildConfig.FLAVOR, "toggleNewsletterSignup", "toggleAcceptedMarketing", "Lkotlin/Function1;", "onTermsAcceptChange", "onEarlyCheckInChange", "proceed", "ConfirmSection", "(Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ldk/molslinjen/domain/model/site/SiteInfo;ZLdk/molslinjen/domain/managers/checkout/PriceTotal;ZZZZZLdk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/account/UserVehicle;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/Departure;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "toggleSelected", "selected", BuildConfig.FLAVOR, "text", "descriptionContent", "CheckboxNoBoxBackground", "(Lkotlin/jvm/functions/Function0;ZLjava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "forcedButtonText", "TermsAndButtonSection", "(ZLdk/molslinjen/domain/model/site/SiteInfo;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ldk/molslinjen/domain/managers/checkout/PriceTotal;ZLjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "EarlyCheckInSection", "(Lkotlin/jvm/functions/Function1;ZLdk/molslinjen/domain/model/account/UserVehicle;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/booking/Departure;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ConfirmSectionViewKt {
    private static final void CheckboxNoBoxBackground(final Function0<Unit> function0, final boolean z5, final String str, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(487156883);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(487156883, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.CheckboxNoBoxBackground (ConfirmSectionView.kt:127)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(135324045);
            int i7 = i6 & 14;
            boolean changedInstance = startRestartGroup.changedInstance(focusManager) | (i7 == 4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: h3.A
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckboxNoBoxBackground$lambda$4$lambda$3;
                        CheckboxNoBoxBackground$lambda$4$lambda$3 = ConfirmSectionViewKt.CheckboxNoBoxBackground$lambda$4$lambda$3(FocusManager.this, function0, ((Boolean) obj).booleanValue());
                        return CheckboxNoBoxBackground$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(ToggleableKt.m455toggleableXHw0xAI$default(companion, z5, false, null, (Function1) rememberedValue, 6, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-344831571);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: h3.B
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckboxNoBoxBackground$lambda$10$lambda$6$lambda$5;
                        CheckboxNoBoxBackground$lambda$10$lambda$6$lambda$5 = ConfirmSectionViewKt.CheckboxNoBoxBackground$lambda$10$lambda$6$lambda$5((SemanticsPropertyReceiver) obj);
                        return CheckboxNoBoxBackground$lambda$10$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue2);
            startRestartGroup.startReplaceGroup(-344828596);
            boolean changedInstance2 = startRestartGroup.changedInstance(focusManager) | (i7 == 4);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: h3.C
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckboxNoBoxBackground$lambda$10$lambda$8$lambda$7;
                        CheckboxNoBoxBackground$lambda$10$lambda$8$lambda$7 = ConfirmSectionViewKt.CheckboxNoBoxBackground$lambda$10$lambda$8$lambda$7(FocusManager.this, function0, ((Boolean) obj).booleanValue());
                        return CheckboxNoBoxBackground$lambda$10$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(clearAndSetSemantics, z5, (Function1) rememberedValue3, null, false, null, SelectionControlStyle.Checkbox, false, startRestartGroup, (i6 & 112) | 1572864, 184);
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(4), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, ((i6 >> 6) & 14) | 48, 1572864, 65532);
            function2.invoke(startRestartGroup, Integer.valueOf((i6 >> 9) & 14));
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.D
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckboxNoBoxBackground$lambda$11;
                    CheckboxNoBoxBackground$lambda$11 = ConfirmSectionViewKt.CheckboxNoBoxBackground$lambda$11(Function0.this, z5, str, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckboxNoBoxBackground$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxNoBoxBackground$lambda$10$lambda$6$lambda$5(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, BuildConfig.FLAVOR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxNoBoxBackground$lambda$10$lambda$8$lambda$7(FocusManager focusManager, Function0 function0, boolean z5) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxNoBoxBackground$lambda$11(Function0 function0, boolean z5, String str, Function2 function2, int i5, Composer composer, int i6) {
        CheckboxNoBoxBackground(function0, z5, str, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxNoBoxBackground$lambda$4$lambda$3(FocusManager focusManager, Function0 function0, boolean z5) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0313  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ConfirmSection(final IFormValidator validator, final SiteInfo siteInfo, final boolean z5, final PriceTotal totalPrice, final boolean z6, final boolean z7, final boolean z8, final boolean z9, final boolean z10, final Transportation transportation, UserVehicle userVehicle, final Departure outboundDeparture, final Departure departure, final Function0<Unit> toggleNewsletterSignup, final Function0<Unit> toggleAcceptedMarketing, final Function1<? super Boolean, Unit> onTermsAcceptChange, final Function1<? super Boolean, Unit> onEarlyCheckInChange, final Function0<Unit> proceed, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        Composer composer3;
        final UserVehicle userVehicle2;
        ScopeUpdateScope endRestartGroup;
        int i13;
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(outboundDeparture, "outboundDeparture");
        Intrinsics.checkNotNullParameter(toggleNewsletterSignup, "toggleNewsletterSignup");
        Intrinsics.checkNotNullParameter(toggleAcceptedMarketing, "toggleAcceptedMarketing");
        Intrinsics.checkNotNullParameter(onTermsAcceptChange, "onTermsAcceptChange");
        Intrinsics.checkNotNullParameter(onEarlyCheckInChange, "onEarlyCheckInChange");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Composer startRestartGroup = composer.startRestartGroup(1450797265);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = i5 | ((i5 & 8) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 4 : 2);
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(siteInfo) ? 32 : 16;
        }
        int i14 = i8;
        if ((i7 & 4) != 0) {
            i14 |= 384;
        } else if ((i5 & 384) == 0) {
            i14 |= startRestartGroup.changed(z5) ? 256 : 128;
            if ((i7 & 8) == 0) {
                i14 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i14 |= startRestartGroup.changedInstance(totalPrice) ? 2048 : 1024;
            }
            if ((i7 & 16) == 0) {
                i14 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i14 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                if ((i7 & 32) != 0) {
                    i14 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i14 |= startRestartGroup.changed(z7) ? 131072 : 65536;
                }
                if ((i7 & 64) != 0) {
                    i14 |= 1572864;
                } else if ((i5 & 1572864) == 0) {
                    i14 |= startRestartGroup.changed(z8) ? 1048576 : 524288;
                }
                if ((i7 & 128) != 0) {
                    i14 |= 12582912;
                } else if ((i5 & 12582912) == 0) {
                    i14 |= startRestartGroup.changed(z9) ? 8388608 : 4194304;
                }
                if ((i7 & 256) != 0) {
                    i14 |= 100663296;
                } else if ((100663296 & i5) == 0) {
                    i14 |= startRestartGroup.changed(z10) ? 67108864 : 33554432;
                    if ((i7 & 512) != 0) {
                        i13 = (805306368 & i5) == 0 ? startRestartGroup.changedInstance(transportation) ? 536870912 : 268435456 : 805306368;
                        i9 = i14;
                        i10 = i7 & 1024;
                        if (i10 != 0) {
                            i11 = i6 | 6;
                        } else if ((i6 & 6) == 0) {
                            i11 = i6 | (startRestartGroup.changedInstance(userVehicle) ? 4 : 2);
                        } else {
                            i11 = i6;
                        }
                        if ((i7 & 2048) != 0) {
                            i11 |= 48;
                        } else if ((i6 & 48) == 0) {
                            i11 |= startRestartGroup.changedInstance(outboundDeparture) ? 32 : 16;
                        }
                        i12 = i11;
                        if ((i7 & 4096) != 0) {
                            i12 |= 384;
                        } else if ((i6 & 384) == 0) {
                            i12 |= startRestartGroup.changedInstance(departure) ? 256 : 128;
                        }
                        if ((i7 & 8192) != 0) {
                            i12 |= 3072;
                        } else if ((i6 & 3072) == 0) {
                            i12 |= startRestartGroup.changedInstance(toggleNewsletterSignup) ? 2048 : 1024;
                        }
                        if ((i7 & 16384) != 0) {
                            i12 |= 24576;
                        } else if ((i6 & 24576) == 0) {
                            i12 |= startRestartGroup.changedInstance(toggleAcceptedMarketing) ? 16384 : 8192;
                        }
                        if ((32768 & i7) != 0) {
                            i12 |= 196608;
                        } else if ((i6 & 196608) == 0) {
                            i12 |= startRestartGroup.changedInstance(onTermsAcceptChange) ? 131072 : 65536;
                        }
                        if ((i7 & 65536) != 0) {
                            i12 |= 1572864;
                        } else if ((i6 & 1572864) == 0) {
                            i12 |= startRestartGroup.changedInstance(onEarlyCheckInChange) ? 1048576 : 524288;
                        }
                        if ((i7 & 131072) != 0) {
                            i12 |= 12582912;
                        } else if ((i6 & 12582912) == 0) {
                            i12 |= startRestartGroup.changedInstance(proceed) ? 8388608 : 4194304;
                        }
                        if ((306783379 & i9) != 306783378 && (4793491 & i12) == 4793490 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            userVehicle2 = userVehicle;
                            composer3 = startRestartGroup;
                        } else {
                            UserVehicle userVehicle3 = i10 != 0 ? null : userVehicle;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1450797265, i9, i12, "dk.molslinjen.ui.views.screens.booking.summary.ConfirmSection (ConfirmSectionView.kt:68)");
                            }
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
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
                            startRestartGroup.startReplaceGroup(600445740);
                            if (siteInfo == null) {
                                composer2 = startRestartGroup;
                            } else {
                                composer2 = startRestartGroup;
                                CheckboxNoBoxBackground(toggleNewsletterSignup, z6, StringResources_androidKt.stringResource(R.string.bookingSummary_newsletter_signup, new Object[]{siteInfo.getSiteName()}, startRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(-650007066, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.ConfirmSectionViewKt$ConfirmSection$1$1$1
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i15) {
                                        if ((i15 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-650007066, i15, -1, "dk.molslinjen.ui.views.screens.booking.summary.ConfirmSection.<anonymous>.<anonymous>.<anonymous> (ConfirmSectionView.kt:76)");
                                        }
                                        NewsletterAgreementTextViewKt.m3513NewsletterAgreementTextViewcf5BqRc(SiteInfo.this, null, 0L, R.string.bookingSummary_newsletter_terms, composer4, 3072, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), composer2, ((i9 >> 9) & 112) | ((i12 >> 9) & 14) | 3072);
                                CheckboxNoBoxBackground(toggleAcceptedMarketing, z7, StringResources_androidKt.stringResource(R.string.profile_newsletter_promotionsTitle, composer2, 6), ComposableLambdaKt.rememberComposableLambda(-381075825, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.ConfirmSectionViewKt$ConfirmSection$1$1$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i15) {
                                        if ((i15 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-381075825, i15, -1, "dk.molslinjen.ui.views.screens.booking.summary.ConfirmSection.<anonymous>.<anonymous>.<anonymous> (ConfirmSectionView.kt:88)");
                                        }
                                        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_newsletter_promotionsDescription, new Object[]{SiteInfo.this.getSiteName()}, composer4, 6), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer4, 384, 1572864, 65530);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, ((i12 >> 12) & 14) | 3072 | ((i9 >> 12) & 112));
                                Unit unit = Unit.INSTANCE;
                            }
                            composer2.endReplaceGroup();
                            Composer composer4 = composer2;
                            composer4.startReplaceGroup(600480419);
                            if (z9) {
                                int i15 = i12 << 12;
                                composer3 = composer4;
                                EarlyCheckInSection(onEarlyCheckInChange, z10, userVehicle3, validator, transportation, outboundDeparture, departure, composer3, ((i12 >> 18) & 14) | ((i9 >> 21) & 112) | ((i12 << 6) & 896) | ((i9 << 9) & 7168) | ((i9 >> 15) & 57344) | (458752 & i15) | (i15 & 3670016));
                            } else {
                                composer3 = composer4;
                            }
                            composer3.endReplaceGroup();
                            int i16 = i9 << 9;
                            TermsAndButtonSection(z8, siteInfo, onTermsAcceptChange, validator, totalPrice, z5, null, proceed, composer3, ((i9 >> 18) & 14) | (i9 & 112) | ((i12 >> 9) & 896) | (i16 & 7168) | ((i9 << 3) & 57344) | (i16 & 458752) | (29360128 & i12), 64);
                            composer3.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            userVehicle2 = userVehicle3;
                        }
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: h3.z
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit ConfirmSection$lambda$2;
                                    ConfirmSection$lambda$2 = ConfirmSectionViewKt.ConfirmSection$lambda$2(IFormValidator.this, siteInfo, z5, totalPrice, z6, z7, z8, z9, z10, transportation, userVehicle2, outboundDeparture, departure, toggleNewsletterSignup, toggleAcceptedMarketing, onTermsAcceptChange, onEarlyCheckInChange, proceed, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                    return ConfirmSection$lambda$2;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i14 |= i13;
                    i9 = i14;
                    i10 = i7 & 1024;
                    if (i10 != 0) {
                    }
                    if ((i7 & 2048) != 0) {
                    }
                    i12 = i11;
                    if ((i7 & 4096) != 0) {
                    }
                    if ((i7 & 8192) != 0) {
                    }
                    if ((i7 & 16384) != 0) {
                    }
                    if ((32768 & i7) != 0) {
                    }
                    if ((i7 & 65536) != 0) {
                    }
                    if ((i7 & 131072) != 0) {
                    }
                    if ((306783379 & i9) != 306783378) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
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
                    startRestartGroup.startReplaceGroup(600445740);
                    if (siteInfo == null) {
                    }
                    composer2.endReplaceGroup();
                    Composer composer42 = composer2;
                    composer42.startReplaceGroup(600480419);
                    if (z9) {
                    }
                    composer3.endReplaceGroup();
                    int i162 = i9 << 9;
                    TermsAndButtonSection(z8, siteInfo, onTermsAcceptChange, validator, totalPrice, z5, null, proceed, composer3, ((i9 >> 18) & 14) | (i9 & 112) | ((i12 >> 9) & 896) | (i162 & 7168) | ((i9 << 3) & 57344) | (i162 & 458752) | (29360128 & i12), 64);
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    userVehicle2 = userVehicle3;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i7 & 512) != 0) {
                }
                i14 |= i13;
                i9 = i14;
                i10 = i7 & 1024;
                if (i10 != 0) {
                }
                if ((i7 & 2048) != 0) {
                }
                i12 = i11;
                if ((i7 & 4096) != 0) {
                }
                if ((i7 & 8192) != 0) {
                }
                if ((i7 & 16384) != 0) {
                }
                if ((32768 & i7) != 0) {
                }
                if ((i7 & 65536) != 0) {
                }
                if ((i7 & 131072) != 0) {
                }
                if ((306783379 & i9) != 306783378) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier.Companion companion32 = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion32);
                ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor22 = companion222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion222.getSetModifier());
                ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(600445740);
                if (siteInfo == null) {
                }
                composer2.endReplaceGroup();
                Composer composer422 = composer2;
                composer422.startReplaceGroup(600480419);
                if (z9) {
                }
                composer3.endReplaceGroup();
                int i1622 = i9 << 9;
                TermsAndButtonSection(z8, siteInfo, onTermsAcceptChange, validator, totalPrice, z5, null, proceed, composer3, ((i9 >> 18) & 14) | (i9 & 112) | ((i12 >> 9) & 896) | (i1622 & 7168) | ((i9 << 3) & 57344) | (i1622 & 458752) | (29360128 & i12), 64);
                composer3.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                userVehicle2 = userVehicle3;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i7 & 32) != 0) {
            }
            if ((i7 & 64) != 0) {
            }
            if ((i7 & 128) != 0) {
            }
            if ((i7 & 256) != 0) {
            }
            if ((i7 & 512) != 0) {
            }
            i14 |= i13;
            i9 = i14;
            i10 = i7 & 1024;
            if (i10 != 0) {
            }
            if ((i7 & 2048) != 0) {
            }
            i12 = i11;
            if ((i7 & 4096) != 0) {
            }
            if ((i7 & 8192) != 0) {
            }
            if ((i7 & 16384) != 0) {
            }
            if ((32768 & i7) != 0) {
            }
            if ((i7 & 65536) != 0) {
            }
            if ((i7 & 131072) != 0) {
            }
            if ((306783379 & i9) != 306783378) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier.Companion companion322 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion322);
            ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor222 = companion2222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222, companion2222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion2222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion2222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion2222.getSetModifier());
            ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(600445740);
            if (siteInfo == null) {
            }
            composer2.endReplaceGroup();
            Composer composer4222 = composer2;
            composer4222.startReplaceGroup(600480419);
            if (z9) {
            }
            composer3.endReplaceGroup();
            int i16222 = i9 << 9;
            TermsAndButtonSection(z8, siteInfo, onTermsAcceptChange, validator, totalPrice, z5, null, proceed, composer3, ((i9 >> 18) & 14) | (i9 & 112) | ((i12 >> 9) & 896) | (i16222 & 7168) | ((i9 << 3) & 57344) | (i16222 & 458752) | (29360128 & i12), 64);
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            userVehicle2 = userVehicle3;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i7 & 8) == 0) {
        }
        if ((i7 & 16) == 0) {
        }
        if ((i7 & 32) != 0) {
        }
        if ((i7 & 64) != 0) {
        }
        if ((i7 & 128) != 0) {
        }
        if ((i7 & 256) != 0) {
        }
        if ((i7 & 512) != 0) {
        }
        i14 |= i13;
        i9 = i14;
        i10 = i7 & 1024;
        if (i10 != 0) {
        }
        if ((i7 & 2048) != 0) {
        }
        i12 = i11;
        if ((i7 & 4096) != 0) {
        }
        if ((i7 & 8192) != 0) {
        }
        if ((i7 & 16384) != 0) {
        }
        if ((32768 & i7) != 0) {
        }
        if ((i7 & 65536) != 0) {
        }
        if ((i7 & 131072) != 0) {
        }
        if ((306783379 & i9) != 306783378) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion3222 = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3222);
        ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2222 = companion22222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2222, companion22222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion22222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion22222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion22222.getSetModifier());
        ColumnScopeInstance columnScopeInstance2222 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(600445740);
        if (siteInfo == null) {
        }
        composer2.endReplaceGroup();
        Composer composer42222 = composer2;
        composer42222.startReplaceGroup(600480419);
        if (z9) {
        }
        composer3.endReplaceGroup();
        int i162222 = i9 << 9;
        TermsAndButtonSection(z8, siteInfo, onTermsAcceptChange, validator, totalPrice, z5, null, proceed, composer3, ((i9 >> 18) & 14) | (i9 & 112) | ((i12 >> 9) & 896) | (i162222 & 7168) | ((i9 << 3) & 57344) | (i162222 & 458752) | (29360128 & i12), 64);
        composer3.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        userVehicle2 = userVehicle3;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ConfirmSection$lambda$2(IFormValidator iFormValidator, SiteInfo siteInfo, boolean z5, PriceTotal priceTotal, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, Transportation transportation, UserVehicle userVehicle, Departure departure, Departure departure2, Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function0 function03, int i5, int i6, int i7, Composer composer, int i8) {
        ConfirmSection(iFormValidator, siteInfo, z5, priceTotal, z6, z7, z8, z9, z10, transportation, userVehicle, departure, departure2, function0, function02, function1, function12, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }

    private static final void EarlyCheckInSection(final Function1<? super Boolean, Unit> function1, final boolean z5, final UserVehicle userVehicle, final IFormValidator iFormValidator, final Transportation transportation, final Departure departure, final Departure departure2, Composer composer, final int i5) {
        int i6;
        int i7;
        boolean z6;
        Composer composer2;
        LocalDateTime departureDateTime;
        Composer startRestartGroup = composer.startRestartGroup(-1180149226);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function1) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(userVehicle) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= (i5 & 4096) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(transportation) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i6 |= startRestartGroup.changedInstance(departure) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(departure2) ? 1048576 : 524288;
        }
        if ((i6 & 599187) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1180149226, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.EarlyCheckInSection (ConfirmSectionView.kt:206)");
            }
            if (!departure.getDepartureDateTime().isBefore(LocalDateTime.now().plusDays(2L))) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: h3.E
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit EarlyCheckInSection$lambda$15;
                            EarlyCheckInSection$lambda$15 = ConfirmSectionViewKt.EarlyCheckInSection$lambda$15(Function1.this, z5, userVehicle, iFormValidator, transportation, departure, departure2, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return EarlyCheckInSection$lambda$15;
                        }
                    });
                    return;
                }
                return;
            }
            boolean isBefore = (departure2 == null || (departureDateTime = departure2.getDepartureDateTime()) == null) ? false : departureDateTime.isBefore(LocalDateTime.now().plusDays(2L));
            final BookingSummaryFormField bookingSummaryFormField = BookingSummaryFormField.EarlyCheckIn;
            iFormValidator.set(bookingSummaryFormField, EarlyCheckInValidator.INSTANCE.validateInput(userVehicle, z5, transportation.getAllowLicensePlate()));
            InputValidationError inputValidationError = (InputValidationError) ((Map) SnapshotStateKt.collectAsState(iFormValidator.getSubmittedErrors(), null, startRestartGroup, 0, 1).getValue()).get(bookingSummaryFormField);
            startRestartGroup.startReplaceGroup(563623148);
            String errorMessage = inputValidationError == null ? null : inputValidationError.toErrorMessage((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), bookingSummaryFormField);
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(companion, ThemeShapesKt.getThemeShapes().getMedium()), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null);
            startRestartGroup.startReplaceGroup(563630192);
            int i8 = i6 & 7168;
            int i9 = i6 & 14;
            final String str = errorMessage;
            boolean z7 = (i8 == 2048 || ((i6 & 4096) != 0 && startRestartGroup.changedInstance(iFormValidator))) | (i9 == 4);
            int i10 = i6 & 112;
            boolean z8 = (i10 == 32) | z7;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: h3.F
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit EarlyCheckInSection$lambda$17$lambda$16;
                        EarlyCheckInSection$lambda$17$lambda$16 = ConfirmSectionViewKt.EarlyCheckInSection$lambda$17$lambda$16(IFormValidator.this, bookingSummaryFormField, function1, z5, ((Boolean) obj).booleanValue());
                        return EarlyCheckInSection$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i11 = i6;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(ToggleableKt.m455toggleableXHw0xAI$default(m104backgroundbw27NRU$default, z5, false, null, (Function1) rememberedValue, 6, null), Dp.m2599constructorimpl(f5));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-228996333);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: h3.G
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit EarlyCheckInSection$lambda$23$lambda$19$lambda$18;
                        EarlyCheckInSection$lambda$23$lambda$19$lambda$18 = ConfirmSectionViewKt.EarlyCheckInSection$lambda$23$lambda$19$lambda$18((SemanticsPropertyReceiver) obj);
                        return EarlyCheckInSection$lambda$23$lambda$19$lambda$18;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier align = rowScopeInstance.align(PaddingKt.m315paddingqDBjuR0$default(SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue2), 0.0f, Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(f5), 0.0f, 9, null), companion2.getTop());
            startRestartGroup.startReplaceGroup(-228990272);
            if (i8 == 2048 || ((i11 & 4096) != 0 && startRestartGroup.changedInstance(iFormValidator))) {
                i7 = 4;
                z6 = true;
            } else {
                i7 = 4;
                z6 = false;
            }
            boolean z9 = (i9 == i7) | z6;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: h3.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit EarlyCheckInSection$lambda$23$lambda$21$lambda$20;
                        EarlyCheckInSection$lambda$23$lambda$21$lambda$20 = ConfirmSectionViewKt.EarlyCheckInSection$lambda$23$lambda$21$lambda$20(IFormValidator.this, bookingSummaryFormField, function1, ((Boolean) obj).booleanValue());
                        return EarlyCheckInSection$lambda$23$lambda$21$lambda$20;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            SelectionControlKt.SelectionControl(align, z5, (Function1) rememberedValue3, null, false, null, SelectionControlStyle.Checkbox, false, startRestartGroup, i10 | 1572864, 184);
            composer2 = startRestartGroup;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_earlyCheckIn_title, composer2, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), composer2, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(isBefore ? R.string.bookingSummary_earlyCheckIn_description_includingReturn : departure2 != null ? R.string.bookingSummary_earlyCheckIn_description_excludingReturn : transportation.isWalking() ? R.string.bookingSummary_earlyCheckIn_description_walking : R.string.bookingSummary_earlyCheckIn_description, composer2, 0), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 48, 1572864, 65532);
            composer2.endNode();
            composer2.endNode();
            boolean z10 = str != null;
            composer2.startReplaceGroup(563680790);
            Object rememberedValue4 = composer2.rememberedValue();
            if (rememberedValue4 == companion4.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: h3.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit EarlyCheckInSection$lambda$25$lambda$24;
                        EarlyCheckInSection$lambda$25$lambda$24 = ConfirmSectionViewKt.EarlyCheckInSection$lambda$25$lambda$24((SemanticsPropertyReceiver) obj);
                        return EarlyCheckInSection$lambda$25$lambda$24;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility(z10, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue4, 1, null), null, null, null, ComposableLambdaKt.rememberComposableLambda(-149473218, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.summary.ConfirmSectionViewKt$EarlyCheckInSection$5
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                    invoke(animatedVisibilityScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i12) {
                    TextStyle m2295copyp1EtxEg;
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-149473218, i12, -1, "dk.molslinjen.ui.views.screens.booking.summary.EarlyCheckInSection.<anonymous> (ConfirmSectionView.kt:277)");
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
            }, composer2, 54), composer2, 196608, 28);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: h3.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInSection$lambda$26;
                    EarlyCheckInSection$lambda$26 = ConfirmSectionViewKt.EarlyCheckInSection$lambda$26(Function1.this, z5, userVehicle, iFormValidator, transportation, departure, departure2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInSection$lambda$26;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInSection$lambda$15(Function1 function1, boolean z5, UserVehicle userVehicle, IFormValidator iFormValidator, Transportation transportation, Departure departure, Departure departure2, int i5, Composer composer, int i6) {
        EarlyCheckInSection(function1, z5, userVehicle, iFormValidator, transportation, departure, departure2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInSection$lambda$17$lambda$16(IFormValidator iFormValidator, BookingSummaryFormField bookingSummaryFormField, Function1 function1, boolean z5, boolean z6) {
        iFormValidator.submit(bookingSummaryFormField);
        function1.invoke(Boolean.valueOf(!z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInSection$lambda$23$lambda$19$lambda$18(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, BuildConfig.FLAVOR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInSection$lambda$23$lambda$21$lambda$20(IFormValidator iFormValidator, BookingSummaryFormField bookingSummaryFormField, Function1 function1, boolean z5) {
        iFormValidator.submit(bookingSummaryFormField);
        function1.invoke(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInSection$lambda$25$lambda$24(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2161getAssertive0phEisY());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInSection$lambda$26(Function1 function1, boolean z5, UserVehicle userVehicle, IFormValidator iFormValidator, Transportation transportation, Departure departure, Departure departure2, int i5, Composer composer, int i6) {
        EarlyCheckInSection(function1, z5, userVehicle, iFormValidator, transportation, departure, departure2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TermsAndButtonSection(final boolean z5, final SiteInfo siteInfo, final Function1<? super Boolean, Unit> onTermsAcceptChange, final IFormValidator validator, final PriceTotal totalPrice, final boolean z6, String str, final Function0<Unit> proceed, Composer composer, final int i5, final int i6) {
        int i7;
        String str2;
        Composer composer2;
        String stringResource;
        String str3;
        final String str4;
        SiteSupportInfo supportInfo;
        SiteSupportInfo supportInfo2;
        Intrinsics.checkNotNullParameter(onTermsAcceptChange, "onTermsAcceptChange");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Composer startRestartGroup = composer.startRestartGroup(-566287874);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(siteInfo) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onTermsAcceptChange) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= (i5 & 4096) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 2048 : 1024;
        }
        if ((i6 & 16) != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(totalPrice) ? 16384 : 8192;
        }
        if ((i6 & 32) != 0) {
            i7 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 131072 : 65536;
        }
        int i8 = i6 & 64;
        if (i8 != 0) {
            i7 |= 1572864;
            str2 = str;
        } else {
            str2 = str;
            if ((i5 & 1572864) == 0) {
                i7 |= startRestartGroup.changed(str2) ? 1048576 : 524288;
            }
        }
        if ((i6 & 128) != 0) {
            i7 |= 12582912;
        } else if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(proceed) ? 8388608 : 4194304;
        }
        int i9 = i7;
        if ((4793491 & i9) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            str4 = str2;
            composer2 = startRestartGroup;
        } else {
            String str5 = i8 != 0 ? null : str2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-566287874, i9, -1, "dk.molslinjen.ui.views.screens.booking.summary.TermsAndButtonSection (ConfirmSectionView.kt:168)");
            }
            TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox(null, z5, (siteInfo == null || (supportInfo2 = siteInfo.getSupportInfo()) == null) ? null : supportInfo2.getPrivacyPolicyPageUrl(), (siteInfo == null || (supportInfo = siteInfo.getSupportInfo()) == null) ? null : supportInfo.getTermsAndConditionsPageUrl(), false, onTermsAcceptChange, BookingSummaryFormField.Terms, validator, startRestartGroup, ((i9 << 3) & 112) | 1572864 | ((i9 << 9) & 458752) | ((i9 << 12) & 29360128), 17);
            boolean z7 = false;
            if (str5 != null) {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-624571983);
                composer2.endReplaceGroup();
                str3 = str5;
            } else {
                composer2 = startRestartGroup;
                if (totalPrice.compareTo(0) < 0) {
                    composer2.startReplaceGroup(-624570569);
                    stringResource = StringResources_androidKt.stringResource(R.string.bookingSummary_proceed_refund, composer2, 6);
                    composer2.endReplaceGroup();
                } else if (totalPrice.equals(0)) {
                    composer2.startReplaceGroup(-624567787);
                    stringResource = StringResources_androidKt.stringResource(R.string.bookingSummary_proceed_free, composer2, 6);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-624565584);
                    stringResource = StringResources_androidKt.stringResource(R.string.bookingSummary_proceed, composer2, 6);
                    composer2.endReplaceGroup();
                }
                str3 = stringResource;
            }
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(32), 0.0f, 0.0f, 13, null);
            composer2.startReplaceGroup(-624556844);
            if ((i9 & 7168) == 2048 || ((i9 & 4096) != 0 && composer2.changedInstance(validator))) {
                z7 = true;
            }
            Object rememberedValue = composer2.rememberedValue();
            if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: h3.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TermsAndButtonSection$lambda$13$lambda$12;
                        TermsAndButtonSection$lambda$13$lambda$12 = ConfirmSectionViewKt.TermsAndButtonSection$lambda$13$lambda$12(IFormValidator.this);
                        return TermsAndButtonSection$lambda$13$lambda$12;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            ButtonWithPriceKt.ButtonWithPrice(m315paddingqDBjuR0$default, proceed, str3, totalPrice, (String) null, z6, (Function0<Unit>) rememberedValue, (ButtonConfig) null, false, composer2, ((i9 >> 18) & 112) | 6 | ((i9 >> 3) & 7168) | (i9 & 458752), Constants.MINIMAL_ERROR_STATUS_CODE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str4 = str5;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TermsAndButtonSection$lambda$14;
                    TermsAndButtonSection$lambda$14 = ConfirmSectionViewKt.TermsAndButtonSection$lambda$14(z5, siteInfo, onTermsAcceptChange, validator, totalPrice, z6, str4, proceed, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return TermsAndButtonSection$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndButtonSection$lambda$13$lambda$12(IFormValidator iFormValidator) {
        iFormValidator.submitAllFields();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndButtonSection$lambda$14(boolean z5, SiteInfo siteInfo, Function1 function1, IFormValidator iFormValidator, PriceTotal priceTotal, boolean z6, String str, Function0 function0, int i5, int i6, Composer composer, int i7) {
        TermsAndButtonSection(z5, siteInfo, function1, iFormValidator, priceTotal, z6, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
