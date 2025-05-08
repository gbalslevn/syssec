package dk.molslinjen.ui.views.screens.profile.shared;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsEmptyCardKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a7\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "icon", BuildConfig.FLAVOR, "description", "subDescription", BuildConfig.FLAVOR, "ProfileItemsEmptyCard", "(Landroidx/compose/ui/Modifier;ILjava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileAssetsEmptyCardKt {
    /* JADX WARN: Removed duplicated region for block: B:22:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProfileItemsEmptyCard(Modifier modifier, final int i5, final String description, String str, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        String str2;
        int i9;
        String str3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(description, "description");
        Composer startRestartGroup = composer.startRestartGroup(-4925438);
        int i10 = i7 & 1;
        if (i10 != 0) {
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
            i8 |= startRestartGroup.changed(description) ? 256 : 128;
        }
        int i11 = i7 & 8;
        if (i11 != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            str2 = str;
            i8 |= startRestartGroup.changed(str2) ? 2048 : 1024;
            i9 = i8;
            if ((i9 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                Modifier modifier3 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                str3 = i11 == 0 ? null : str2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-4925438, i9, -1, "dk.molslinjen.ui.views.screens.profile.shared.ProfileItemsEmptyCard (ProfileAssetsEmptyCard.kt:32)");
                }
                float f5 = 24;
                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null);
                AppColor appColor = AppColor.INSTANCE;
                float f6 = 48;
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(m313paddingVpY3zN4$default, appColor.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6));
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifier4 = modifier3;
                ImageKt.Image(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i9 >> 3) & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(f6)), null, null, 0.0f, null, startRestartGroup, 384, 120);
                float f7 = 16;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null);
                TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
                TextAlign.Companion companion3 = TextAlign.INSTANCE;
                TextKt.m940Text4IGK_g(description, m315paddingqDBjuR0$default, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphSmall, startRestartGroup, ((i9 >> 6) & 14) | 432, 1572864, 65016);
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(563943068);
                if (str3 != null) {
                    TextKt.m940Text4IGK_g(str3, PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 432, 1572864, 65016);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier2 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier5 = modifier2;
                final String str4 = str2;
                endRestartGroup.updateScope(new Function2() { // from class: W3.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ProfileItemsEmptyCard$lambda$2;
                        ProfileItemsEmptyCard$lambda$2 = ProfileAssetsEmptyCardKt.ProfileItemsEmptyCard$lambda$2(Modifier.this, i5, description, str4, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return ProfileItemsEmptyCard$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        str2 = str;
        i9 = i8;
        if ((i9 & 1171) == 1170) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        float f52 = 24;
        Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), Dp.m2599constructorimpl(f52), 0.0f, 2, null);
        AppColor appColor2 = AppColor.INSTANCE;
        float f62 = 48;
        Modifier m312paddingVpY3zN42 = PaddingKt.m312paddingVpY3zN4(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(m313paddingVpY3zN4$default2, appColor2.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(1), appColor2.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getLarge()), Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(f62));
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN42);
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
        Modifier.Companion companion22 = Modifier.INSTANCE;
        Modifier modifier42 = modifier3;
        ImageKt.Image(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i9 >> 3) & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion22, Dp.m2599constructorimpl(f62)), null, null, 0.0f, null, startRestartGroup, 384, 120);
        float f72 = 16;
        Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, Dp.m2599constructorimpl(f72), 0.0f, 0.0f, 13, null);
        TextStyle paragraphSmall2 = TypographyKt.getParagraphSmall();
        TextAlign.Companion companion32 = TextAlign.INSTANCE;
        TextKt.m940Text4IGK_g(description, m315paddingqDBjuR0$default2, appColor2.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion32.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphSmall2, startRestartGroup, ((i9 >> 6) & 14) | 432, 1572864, 65016);
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(563943068);
        if (str3 != null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        str2 = str3;
        modifier2 = modifier42;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileItemsEmptyCard$lambda$2(Modifier modifier, int i5, String str, String str2, int i6, int i7, Composer composer, int i8) {
        ProfileItemsEmptyCard(modifier, i5, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
