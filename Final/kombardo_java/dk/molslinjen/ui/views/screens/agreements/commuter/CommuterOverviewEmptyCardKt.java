package dk.molslinjen.ui.views.screens.agreements.commuter;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewEmptyCardKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a5\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "description", "actionButtonText", "Lkotlin/Function0;", BuildConfig.FLAVOR, "action", "CommuterOverviewEmptyCard", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CommuterOverviewEmptyCardKt {
    public static final void CommuterOverviewEmptyCard(final String title, final String description, final String actionButtonText, final Function0<Unit> action, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(actionButtonText, "actionButtonText");
        Intrinsics.checkNotNullParameter(action, "action");
        Composer startRestartGroup = composer.startRestartGroup(632483311);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(title) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(description) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(actionButtonText) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(action) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(632483311, i7, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewEmptyCard (CommuterOverviewEmptyCard.kt:29)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(ModifierExtensionsKt.defaultShadow(companion, ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 16;
            float f6 = 24;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            TextStyle paragraph = TypographyKt.getParagraph();
            TextAlign.Companion companion3 = TextAlign.INSTANCE;
            TextKt.m940Text4IGK_g(title, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraph, startRestartGroup, i7 & 14, 1572864, 65022);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            int i8 = i7 >> 3;
            TextKt.m940Text4IGK_g(description, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, (i8 & 14) | 384, 1572864, 65018);
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), composer2, 6);
            PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), actionButtonText, action, null, ButtonConfig.Regular, false, false, false, composer2, (i8 & 112) | 24582 | (i8 & 896), 232);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommuterOverviewEmptyCard$lambda$1;
                    CommuterOverviewEmptyCard$lambda$1 = CommuterOverviewEmptyCardKt.CommuterOverviewEmptyCard$lambda$1(title, description, actionButtonText, action, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CommuterOverviewEmptyCard$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommuterOverviewEmptyCard$lambda$1(String str, String str2, String str3, Function0 function0, int i5, Composer composer, int i6) {
        CommuterOverviewEmptyCard(str, str2, str3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
