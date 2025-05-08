package dk.molslinjen.ui.views.screens.profile;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.screens.profile.ProfileLoginHeaderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a+\u0010\u0004\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "navigateToLogin", "navigateToCreateProfile", "ProfileLoginHeader", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileLoginHeaderKt {
    public static final void ProfileLoginHeader(final Function0<Unit> navigateToLogin, Function0<Unit> navigateToCreateProfile, Composer composer, int i5) {
        int i6;
        Composer composer2;
        final int i7;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(navigateToLogin, "navigateToLogin");
        Intrinsics.checkNotNullParameter(navigateToCreateProfile, "navigateToCreateProfile");
        Composer startRestartGroup = composer.startRestartGroup(1951471978);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(navigateToLogin) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToCreateProfile) ? 32 : 16;
        }
        int i8 = i6;
        if ((i8 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            i7 = i5;
            function0 = navigateToCreateProfile;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1951471978, i8, -1, "dk.molslinjen.ui.views.screens.profile.ProfileLoginHeader (ProfileLoginHeader.kt:22)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(32), 5, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f6 = 16;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_login_description, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            PrimaryButtonKt.PrimaryButton(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), StringResources_androidKt.stringResource(R.string.login_cta, startRestartGroup, 6), navigateToLogin, null, null, false, false, false, startRestartGroup, (i8 << 6) & 896, 248);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            i7 = i5;
            function0 = navigateToCreateProfile;
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), StringResources_androidKt.stringResource(R.string.createProfile_cta, startRestartGroup, 6), navigateToCreateProfile, null, false, null, false, null, null, 0L, false, composer2, (i8 << 3) & 896, 0, 2040);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileLoginHeader$lambda$2;
                    ProfileLoginHeader$lambda$2 = ProfileLoginHeaderKt.ProfileLoginHeader$lambda$2(Function0.this, function0, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileLoginHeader$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileLoginHeader$lambda$2(Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        ProfileLoginHeader(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
