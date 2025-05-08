package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.IconTextButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aM\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", BuildConfig.FLAVOR, "icon", "text", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/ui/graphics/Color;", "tint", "IconTextButton-V-9fs2A", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;IIZJLandroidx/compose/runtime/Composer;II)V", "IconTextButton", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IconTextButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* renamed from: IconTextButton-V-9fs2A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3404IconTextButtonV9fs2A(Modifier modifier, final Function0<Unit> onClick, final int i5, final int i6, boolean z5, final long j5, Composer composer, final int i7, final int i8) {
        Modifier modifier2;
        int i9;
        boolean z6;
        long j6;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        final Modifier modifier3;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1552109310);
        int i10 = i8 & 1;
        if (i10 != 0) {
            i9 = i7 | 6;
            modifier2 = modifier;
        } else if ((i7 & 6) == 0) {
            modifier2 = modifier;
            i9 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i7;
        } else {
            modifier2 = modifier;
            i9 = i7;
        }
        if ((i8 & 2) != 0) {
            i9 |= 48;
        } else if ((i7 & 48) == 0) {
            i9 |= startRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i8 & 4) != 0) {
            i9 |= 384;
        } else if ((i7 & 384) == 0) {
            i9 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        if ((i8 & 8) != 0) {
            i9 |= 3072;
        } else if ((i7 & 3072) == 0) {
            i9 |= startRestartGroup.changed(i6) ? 2048 : 1024;
        }
        int i11 = i8 & 16;
        if (i11 != 0) {
            i9 |= 24576;
        } else if ((i7 & 24576) == 0) {
            z6 = z5;
            i9 |= startRestartGroup.changed(z6) ? 16384 : 8192;
            if ((i8 & 32) == 0) {
                i9 |= 196608;
                j6 = j5;
            } else {
                j6 = j5;
                if ((i7 & 196608) == 0) {
                    i9 |= startRestartGroup.changed(j6) ? 131072 : 65536;
                }
            }
            if ((74899 & i9) == 74898 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                boolean z8 = i11 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1552109310, i9, -1, "dk.molslinjen.ui.views.reusable.buttons.IconTextButton (IconTextButton.kt:31)");
                }
                Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(modifier4, z8, null, null, onClick, 6, null);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
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
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                long m3268getGrey50d7_KjU = !z8 ? j6 : AppColor.INSTANCE.m3268getGrey50d7_KjU();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                composer2 = startRestartGroup;
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i9 >> 6) & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(16)), m3268getGrey50d7_KjU, composer2, 384, 0);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i6, composer2, (i9 >> 9) & 14), PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), m3268getGrey50d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 48, 1572864, 65528);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z7 = z8;
            } else {
                startRestartGroup.skipToGroupEnd();
                z7 = z6;
                modifier3 = modifier2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: Z1.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit IconTextButton_V_9fs2A$lambda$1;
                        IconTextButton_V_9fs2A$lambda$1 = IconTextButtonKt.IconTextButton_V_9fs2A$lambda$1(Modifier.this, onClick, i5, i6, z7, j5, i7, i8, (Composer) obj, ((Integer) obj2).intValue());
                        return IconTextButton_V_9fs2A$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((i8 & 32) == 0) {
        }
        if ((74899 & i9) == 74898) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(modifier4, z8, null, null, onClick, 6, null);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default2);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        if (!z8) {
        }
        Modifier.Companion companion22 = Modifier.INSTANCE;
        composer2 = startRestartGroup;
        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i9 >> 6) & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion22, Dp.m2599constructorimpl(16)), m3268getGrey50d7_KjU, composer2, 384, 0);
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i6, composer2, (i9 >> 9) & 14), PaddingKt.m315paddingqDBjuR0$default(companion22, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), m3268getGrey50d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 48, 1572864, 65528);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        z7 = z8;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconTextButton_V_9fs2A$lambda$1(Modifier modifier, Function0 function0, int i5, int i6, boolean z5, long j5, int i7, int i8, Composer composer, int i9) {
        m3404IconTextButtonV9fs2A(modifier, function0, i5, i6, z5, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), i8);
        return Unit.INSTANCE;
    }
}
