package dk.molslinjen.ui.views.screens.profile.contact;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.screens.profile.contact.LargeContactItemViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001ai\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "icon", Constants.IntentExtra.PushTitle, "description", "buttonIcon", BuildConfig.FLAVOR, "buttonText", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "extraContent", "LargeContactItemView", "(Landroidx/compose/ui/Modifier;IIIILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LargeContactItemViewKt {
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LargeContactItemView(Modifier modifier, final int i5, final int i6, final int i7, final int i8, final String buttonText, final Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i9, final int i10) {
        Modifier modifier2;
        int i11;
        int i12;
        Function2<? super Composer, ? super Integer, Unit> function22;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final Modifier modifier3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-408581961);
        int i13 = i10 & 1;
        if (i13 != 0) {
            i11 = i9 | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i9 & 6) == 0) {
                i11 = i9 | (startRestartGroup.changed(modifier2) ? 4 : 2);
            } else {
                i11 = i9;
            }
        }
        if ((2 & i10) != 0) {
            i11 |= 48;
        } else if ((i9 & 48) == 0) {
            i11 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        int i14 = i11;
        if ((4 & i10) != 0) {
            i14 |= 384;
        } else if ((i9 & 384) == 0) {
            i14 |= startRestartGroup.changed(i6) ? 256 : 128;
        }
        if ((i10 & 8) != 0) {
            i14 |= 3072;
        } else if ((i9 & 3072) == 0) {
            i14 |= startRestartGroup.changed(i7) ? 2048 : 1024;
        }
        if ((i10 & 16) != 0) {
            i14 |= 24576;
        } else if ((i9 & 24576) == 0) {
            i14 |= startRestartGroup.changed(i8) ? 16384 : 8192;
            if ((32 & i10) == 0) {
                i14 |= 196608;
            } else if ((i9 & 196608) == 0) {
                i14 |= startRestartGroup.changed(buttonText) ? 131072 : 65536;
            }
            if ((i10 & 64) == 0) {
                i14 |= 1572864;
            } else if ((i9 & 1572864) == 0) {
                i14 |= startRestartGroup.changedInstance(onClick) ? 1048576 : 524288;
            }
            i12 = 128 & i10;
            if (i12 == 0) {
                i14 |= 12582912;
            } else if ((12582912 & i9) == 0) {
                function22 = function2;
                i14 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                if ((i14 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function25 = i12 != 0 ? null : function22;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-408581961, i14, -1, "dk.molslinjen.ui.views.screens.profile.contact.LargeContactItemView (LargeContactItemView.kt:36)");
                    }
                    AppColor appColor = AppColor.INSTANCE;
                    long m3269getGrey60d7_KjU = appColor.m3269getGrey60d7_KjU();
                    MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                    int i15 = MaterialTheme.$stable;
                    function23 = function25;
                    float f5 = 24;
                    Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(modifier2, m3269getGrey60d7_KjU, materialTheme.getShapes(startRestartGroup, i15).getMedium()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), materialTheme.getShapes(startRestartGroup, i15).getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(42));
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
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
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Modifier modifier4 = modifier2;
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Painter painterResource = PainterResources_androidKt.painterResource(i5, startRestartGroup, (i14 >> 3) & 14);
                    String skip = Accessibility.INSTANCE.getSkip();
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    float f6 = 8;
                    ImageKt.Image(painterResource, skip, PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
                    String stringResource = StringResources_androidKt.stringResource(i6, startRestartGroup, (i14 >> 6) & 14);
                    TextStyle paragraphBold = TypographyKt.getParagraphBold();
                    long m3254getBrandBlack20d7_KjU = appColor.m3254getBrandBlack20d7_KjU();
                    TextAlign.Companion companion3 = TextAlign.INSTANCE;
                    TextKt.m940Text4IGK_g(stringResource, PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), m3254getBrandBlack20d7_KjU, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold, startRestartGroup, 432, 1572864, 65016);
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i7, startRestartGroup, (i14 >> 9) & 14), PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), appColor.m3254getBrandBlack20d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 432, 1572864, 65016);
                    int i16 = i14 >> 12;
                    int i17 = (i16 & 896) | (i16 & 112) | 805502982 | (29360128 & (i14 << 9));
                    int i18 = i14;
                    modifier3 = modifier4;
                    SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), 0.0f, 1, null), buttonText, onClick, null, false, ButtonConfig.Regular, false, Integer.valueOf(i8), null, appColor.m3269getGrey60d7_KjU(), false, startRestartGroup, i17, 0, 1368);
                    composer2 = startRestartGroup;
                    composer2.startReplaceGroup(1611998204);
                    if (function23 != null) {
                        function23.invoke(composer2, Integer.valueOf((i18 >> 21) & 14));
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function24 = function23;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    function24 = function22;
                    modifier3 = modifier2;
                    composer2 = startRestartGroup;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: H3.o
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit LargeContactItemView$lambda$1;
                            LargeContactItemView$lambda$1 = LargeContactItemViewKt.LargeContactItemView$lambda$1(Modifier.this, i5, i6, i7, i8, buttonText, onClick, function24, i9, i10, (Composer) obj, ((Integer) obj2).intValue());
                            return LargeContactItemView$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            function22 = function2;
            if ((i14 & 4793491) == 4793490) {
            }
            if (i13 != 0) {
            }
            if (i12 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            AppColor appColor2 = AppColor.INSTANCE;
            long m3269getGrey60d7_KjU2 = appColor2.m3269getGrey60d7_KjU();
            MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
            int i152 = MaterialTheme.$stable;
            function23 = function25;
            float f52 = 24;
            Modifier m314paddingqDBjuR02 = PaddingKt.m314paddingqDBjuR0(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(modifier2, m3269getGrey60d7_KjU2, materialTheme2.getShapes(startRestartGroup, i152).getMedium()), Dp.m2599constructorimpl(1), appColor2.m3268getGrey50d7_KjU(), materialTheme2.getShapes(startRestartGroup, i152).getMedium()), Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(f52), Dp.m2599constructorimpl(42));
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR02);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Modifier modifier42 = modifier2;
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            Painter painterResource2 = PainterResources_androidKt.painterResource(i5, startRestartGroup, (i14 >> 3) & 14);
            String skip2 = Accessibility.INSTANCE.getSkip();
            Modifier.Companion companion22 = Modifier.INSTANCE;
            float f62 = 8;
            ImageKt.Image(painterResource2, skip2, PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, Dp.m2599constructorimpl(f62), 0.0f, 0.0f, 13, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
            String stringResource2 = StringResources_androidKt.stringResource(i6, startRestartGroup, (i14 >> 6) & 14);
            TextStyle paragraphBold2 = TypographyKt.getParagraphBold();
            long m3254getBrandBlack20d7_KjU2 = appColor2.m3254getBrandBlack20d7_KjU();
            TextAlign.Companion companion32 = TextAlign.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource2, PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), m3254getBrandBlack20d7_KjU2, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion32.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold2, startRestartGroup, 432, 1572864, 65016);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i7, startRestartGroup, (i14 >> 9) & 14), PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, Dp.m2599constructorimpl(f62), 0.0f, 0.0f, 13, null), appColor2.m3254getBrandBlack20d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion32.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 432, 1572864, 65016);
            int i162 = i14 >> 12;
            int i172 = (i162 & 896) | (i162 & 112) | 805502982 | (29360128 & (i14 << 9));
            int i182 = i14;
            modifier3 = modifier42;
            SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, Dp.m2599constructorimpl(f52), 0.0f, 0.0f, 13, null), 0.0f, 1, null), buttonText, onClick, null, false, ButtonConfig.Regular, false, Integer.valueOf(i8), null, appColor2.m3269getGrey60d7_KjU(), false, startRestartGroup, i172, 0, 1368);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(1611998204);
            if (function23 != null) {
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            function24 = function23;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((32 & i10) == 0) {
        }
        if ((i10 & 64) == 0) {
        }
        i12 = 128 & i10;
        if (i12 == 0) {
        }
        function22 = function2;
        if ((i14 & 4793491) == 4793490) {
        }
        if (i13 != 0) {
        }
        if (i12 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        AppColor appColor22 = AppColor.INSTANCE;
        long m3269getGrey60d7_KjU22 = appColor22.m3269getGrey60d7_KjU();
        MaterialTheme materialTheme22 = MaterialTheme.INSTANCE;
        int i1522 = MaterialTheme.$stable;
        function23 = function25;
        float f522 = 24;
        Modifier m314paddingqDBjuR022 = PaddingKt.m314paddingqDBjuR0(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(modifier2, m3269getGrey60d7_KjU22, materialTheme22.getShapes(startRestartGroup, i1522).getMedium()), Dp.m2599constructorimpl(1), appColor22.m3268getGrey50d7_KjU(), materialTheme22.getShapes(startRestartGroup, i1522).getMedium()), Dp.m2599constructorimpl(f522), Dp.m2599constructorimpl(f522), Dp.m2599constructorimpl(f522), Dp.m2599constructorimpl(42));
        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR022);
        ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Modifier modifier422 = modifier2;
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion42.getSetModifier());
        ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
        Painter painterResource22 = PainterResources_androidKt.painterResource(i5, startRestartGroup, (i14 >> 3) & 14);
        String skip22 = Accessibility.INSTANCE.getSkip();
        Modifier.Companion companion222 = Modifier.INSTANCE;
        float f622 = 8;
        ImageKt.Image(painterResource22, skip22, PaddingKt.m315paddingqDBjuR0$default(companion222, 0.0f, Dp.m2599constructorimpl(f622), 0.0f, 0.0f, 13, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
        String stringResource22 = StringResources_androidKt.stringResource(i6, startRestartGroup, (i14 >> 6) & 14);
        TextStyle paragraphBold22 = TypographyKt.getParagraphBold();
        long m3254getBrandBlack20d7_KjU22 = appColor22.m3254getBrandBlack20d7_KjU();
        TextAlign.Companion companion322 = TextAlign.INSTANCE;
        TextKt.m940Text4IGK_g(stringResource22, PaddingKt.m315paddingqDBjuR0$default(companion222, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), m3254getBrandBlack20d7_KjU22, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion322.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphBold22, startRestartGroup, 432, 1572864, 65016);
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i7, startRestartGroup, (i14 >> 9) & 14), PaddingKt.m315paddingqDBjuR0$default(companion222, 0.0f, Dp.m2599constructorimpl(f622), 0.0f, 0.0f, 13, null), appColor22.m3254getBrandBlack20d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion322.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 432, 1572864, 65016);
        int i1622 = i14 >> 12;
        int i1722 = (i1622 & 896) | (i1622 & 112) | 805502982 | (29360128 & (i14 << 9));
        int i1822 = i14;
        modifier3 = modifier422;
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion222, 0.0f, Dp.m2599constructorimpl(f522), 0.0f, 0.0f, 13, null), 0.0f, 1, null), buttonText, onClick, null, false, ButtonConfig.Regular, false, Integer.valueOf(i8), null, appColor22.m3269getGrey60d7_KjU(), false, startRestartGroup, i1722, 0, 1368);
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(1611998204);
        if (function23 != null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function24 = function23;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LargeContactItemView$lambda$1(Modifier modifier, int i5, int i6, int i7, int i8, String str, Function0 function0, Function2 function2, int i9, int i10, Composer composer, int i11) {
        LargeContactItemView(modifier, i5, i6, i7, i8, str, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i9 | 1), i10);
        return Unit.INSTANCE;
    }
}
