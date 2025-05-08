package dk.molslinjen.ui.views.screens.profile.contact;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.profile.contact.SmallContactItemViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"SmallContactItemView", BuildConfig.FLAVOR, "modifier", "Landroidx/compose/ui/Modifier;", Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "buttonText", BuildConfig.FLAVOR, "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;ILjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SmallContactItemViewKt {
    public static final void SmallContactItemView(Modifier modifier, final int i5, final String buttonText, final Function0<Unit> onClick, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        Composer composer2;
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(233559237);
        int i9 = i7 & 1;
        if (i9 != 0) {
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
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(buttonText) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(onClick) ? 2048 : 1024;
        }
        int i10 = i8;
        if ((i10 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (i9 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(233559237, i10, -1, "dk.molslinjen.ui.views.screens.profile.contact.SmallContactItemView (SmallContactItemView.kt:28)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
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
            Modifier modifier3 = modifier2;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i5, startRestartGroup, (i10 >> 3) & 14), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 384, 1572864, 65530);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null);
            startRestartGroup.startReplaceGroup(1411379893);
            boolean z5 = (i10 & 7168) == 2048;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: H3.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SmallContactItemView$lambda$3$lambda$1$lambda$0;
                        SmallContactItemView$lambda$3$lambda$1$lambda$0 = SmallContactItemViewKt.SmallContactItemView$lambda$3$lambda$1$lambda$0(Function0.this);
                        return SmallContactItemView$lambda$3$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(m315paddingqDBjuR0$default, false, null, null, (Function0) rememberedValue, 7, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_open_external_link, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(buttonText, PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, ((i10 >> 6) & 14) | 100663344, 1572864, 65276);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: H3.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SmallContactItemView$lambda$4;
                    SmallContactItemView$lambda$4 = SmallContactItemViewKt.SmallContactItemView$lambda$4(Modifier.this, i5, buttonText, onClick, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return SmallContactItemView$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmallContactItemView$lambda$3$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SmallContactItemView$lambda$4(Modifier modifier, int i5, String str, Function0 function0, int i6, int i7, Composer composer, int i8) {
        SmallContactItemView(modifier, i5, str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
