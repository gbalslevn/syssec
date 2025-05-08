package dk.molslinjen.ui.views.screens.profile.shared.accountCard;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InitialsViewKt;
import dk.molslinjen.ui.views.reusable.InitialsViewSize;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountActivationPendingCardKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a3\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;", "data", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onIgnore", "AccountActivationPendingCard", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AccountActivationPendingCardKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AccountActivationPendingCard(Modifier modifier, final AccountCardData.ActivationPending data, Function0<Unit> function0, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Function0<Unit> function02;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        Function0<Unit> function03;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer startRestartGroup = composer.startRestartGroup(-1948746748);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(data) ? 32 : 16;
        }
        int i9 = i6 & 4;
        if (i9 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                if (i9 != 0) {
                    function02 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1948746748, i7, -1, "dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountActivationPendingCard (AccountActivationPendingCard.kt:27)");
                }
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
                AppColor appColor = AppColor.INSTANCE;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(24));
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                InitialsViewSize initialsViewSize = InitialsViewSize.Small;
                String initials = data.getInitials();
                Color m1481boximpl = Color.m1481boximpl(appColor.m3255getBrandBlue10d7_KjU());
                Modifier modifier5 = modifier4;
                composer2 = startRestartGroup;
                InitialsViewKt.m3389InitialsViewgPmlwdY(null, initialsViewSize, m1481boximpl, null, initials, false, false, false, startRestartGroup, 432, 233);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                float f5 = 16;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer2, 6);
                String stringResource = StringResources_androidKt.stringResource(R.string.profile_activation_pending_title, composer2, 6);
                TextStyle paragraphBold = TypographyKt.getParagraphBold();
                TextAlign.Companion companion3 = TextAlign.INSTANCE;
                TextKt.m940Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, composer2, 0, 1572864, 65022);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(8)), composer2, 6);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_activation_pending_text, new Object[]{data.getEmail()}, composer2, 6), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65022);
                composer2.startReplaceGroup(-1505560991);
                if (function02 != null) {
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer2, 6);
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.button_ignore, composer2, 6), ClickableKt.m122clickableXHw0xAI$default(companion2, false, null, null, function02, 7, null), 0L, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 100663296, 1572864, 64764);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function03 = function02;
                modifier3 = modifier5;
            } else {
                startRestartGroup.skipToGroupEnd();
                function03 = function02;
                modifier3 = modifier2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final Function0<Unit> function04 = function03;
                endRestartGroup.updateScope(new Function2() { // from class: X3.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit AccountActivationPendingCard$lambda$1;
                        AccountActivationPendingCard$lambda$1 = AccountActivationPendingCardKt.AccountActivationPendingCard$lambda$1(Modifier.this, data, function04, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return AccountActivationPendingCard$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        function02 = function0;
        if ((i7 & 147) == 146) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null);
        AppColor appColor2 = AppColor.INSTANCE;
        Modifier m311padding3ABfNKs2 = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default2, appColor2.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(24));
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs2);
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion4.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        InitialsViewSize initialsViewSize2 = InitialsViewSize.Small;
        String initials2 = data.getInitials();
        Color m1481boximpl2 = Color.m1481boximpl(appColor2.m3255getBrandBlue10d7_KjU());
        Modifier modifier52 = modifier4;
        composer2 = startRestartGroup;
        InitialsViewKt.m3389InitialsViewgPmlwdY(null, initialsViewSize2, m1481boximpl2, null, initials2, false, false, false, startRestartGroup, 432, 233);
        Modifier.Companion companion22 = Modifier.INSTANCE;
        float f52 = 16;
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion22, Dp.m2599constructorimpl(f52)), composer2, 6);
        String stringResource2 = StringResources_androidKt.stringResource(R.string.profile_activation_pending_title, composer2, 6);
        TextStyle paragraphBold2 = TypographyKt.getParagraphBold();
        TextAlign.Companion companion32 = TextAlign.INSTANCE;
        TextKt.m940Text4IGK_g(stringResource2, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion32.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold2, composer2, 0, 1572864, 65022);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion22, Dp.m2599constructorimpl(8)), composer2, 6);
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_activation_pending_text, new Object[]{data.getEmail()}, composer2, 6), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion32.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65022);
        composer2.startReplaceGroup(-1505560991);
        if (function02 != null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function03 = function02;
        modifier3 = modifier52;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountActivationPendingCard$lambda$1(Modifier modifier, AccountCardData.ActivationPending activationPending, Function0 function0, int i5, int i6, Composer composer, int i7) {
        AccountActivationPendingCard(modifier, activationPending, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
