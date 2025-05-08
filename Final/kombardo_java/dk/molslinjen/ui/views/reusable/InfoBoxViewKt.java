package dk.molslinjen.ui.views.reusable;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.Shapes;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextData;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001aC\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\t\u0010\u000f\u001a;\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "icon", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "slimPaddings", BuildConfig.FLAVOR, "InfoBoxView", "(Landroidx/compose/ui/Modifier;ILjava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "mainText", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/clickableText/ClickableTextData;", "clickableTexts", "(Landroidx/compose/ui/Modifier;IZLjava/lang/String;Ljava/util/List;Landroidx/compose/runtime/Composer;II)V", "Lkotlin/Function0;", "textView", "Base", "(Landroidx/compose/ui/Modifier;IZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class InfoBoxViewKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Base(Modifier modifier, final int i5, boolean z5, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        final boolean z6;
        int i9;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1019452927);
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
        int i11 = i7 & 4;
        if (i11 != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            z6 = z5;
            i8 |= startRestartGroup.changed(z6) ? 256 : 128;
            if ((i7 & 8) == 0) {
                i8 |= 3072;
            } else if ((i6 & 3072) == 0) {
                i8 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
            }
            i9 = i8;
            if ((i9 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                if (i11 != 0) {
                    z6 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1019452927, i9, -1, "dk.molslinjen.ui.views.reusable.Base (InfoBoxView.kt:77)");
                }
                AppColor appColor = AppColor.INSTANCE;
                long m3268getGrey50d7_KjU = appColor.m3268getGrey50d7_KjU();
                Shapes themeShapes = ThemeShapesKt.getThemeShapes();
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(modifier4, m3268getGrey50d7_KjU, !z6 ? themeShapes.getSmall() : themeShapes.getMedium()), Dp.m2599constructorimpl(!z6 ? 6 : 16));
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
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
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifier5 = modifier4;
                composer2 = startRestartGroup;
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i9 >> 3) & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(16)), appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(8)), composer2, 6);
                function2.invoke(composer2, Integer.valueOf((i9 >> 9) & 14));
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: W1.m
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit Base$lambda$3;
                        Base$lambda$3 = InfoBoxViewKt.Base$lambda$3(Modifier.this, i5, z6, function2, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return Base$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((i7 & 8) == 0) {
        }
        i9 = i8;
        if ((i9 & 1171) == 1170) {
        }
        if (i10 == 0) {
        }
        if (i11 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        AppColor appColor2 = AppColor.INSTANCE;
        long m3268getGrey50d7_KjU2 = appColor2.m3268getGrey50d7_KjU();
        Shapes themeShapes2 = ThemeShapesKt.getThemeShapes();
        Modifier m311padding3ABfNKs2 = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(modifier4, m3268getGrey50d7_KjU2, !z6 ? themeShapes2.getSmall() : themeShapes2.getMedium()), Dp.m2599constructorimpl(!z6 ? 6 : 16));
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs2);
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
        Modifier.Companion companion22 = Modifier.INSTANCE;
        Modifier modifier52 = modifier4;
        composer2 = startRestartGroup;
        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i9 >> 3) & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(companion22, Dp.m2599constructorimpl(16)), appColor2.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion22, Dp.m2599constructorimpl(8)), composer2, 6);
        function2.invoke(composer2, Integer.valueOf((i9 >> 9) & 14));
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier52;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Base$lambda$3(Modifier modifier, int i5, boolean z5, Function2 function2, int i6, int i7, Composer composer, int i8) {
        Base(modifier, i5, z5, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    public static final void InfoBoxView(Modifier modifier, int i5, final String text, boolean z5, Composer composer, final int i6, final int i7) {
        int i8;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(-762866222);
        int i9 = i7 & 1;
        if (i9 != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        int i10 = i7 & 2;
        if (i10 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(text) ? 256 : 128;
        }
        int i11 = i7 & 8;
        if (i11 != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i8 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i9 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (i10 != 0) {
                i5 = R.drawable.icon_alert_warning;
            }
            if (i11 != 0) {
                z5 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-762866222, i8, -1, "dk.molslinjen.ui.views.reusable.InfoBoxView (InfoBoxView.kt:34)");
            }
            Base(modifier, i5, z5, ComposableLambdaKt.rememberComposableLambda(931544657, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.InfoBoxViewKt$InfoBoxView$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i12) {
                    if ((i12 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(931544657, i12, -1, "dk.molslinjen.ui.views.reusable.InfoBoxView.<anonymous> (InfoBoxView.kt:40)");
                    }
                    TextKt.m940Text4IGK_g(text, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i8 & 14) | 3072 | (i8 & 112) | ((i8 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final int i12 = i5;
        final boolean z6 = z5;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: W1.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoBoxView$lambda$0;
                    InfoBoxView$lambda$0 = InfoBoxViewKt.InfoBoxView$lambda$0(Modifier.this, i12, text, z6, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoBoxView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoBoxView$lambda$0(Modifier modifier, int i5, String str, boolean z5, int i6, int i7, Composer composer, int i8) {
        InfoBoxView(modifier, i5, str, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoBoxView$lambda$1(Modifier modifier, int i5, boolean z5, String str, List list, int i6, int i7, Composer composer, int i8) {
        InfoBoxView(modifier, i5, z5, str, list, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InfoBoxView(Modifier modifier, int i5, boolean z5, final String mainText, final List<ClickableTextData> clickableTexts, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        int i9;
        int i10;
        boolean z6;
        Modifier modifier3;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        Intrinsics.checkNotNullParameter(clickableTexts, "clickableTexts");
        Composer startRestartGroup = composer.startRestartGroup(782276326);
        int i11 = i7 & 1;
        if (i11 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i8 = i6;
        }
        int i12 = i7 & 2;
        if (i12 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 = i5;
            i8 |= startRestartGroup.changed(i9) ? 32 : 16;
            i10 = i7 & 4;
            if (i10 == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                z6 = z5;
                i8 |= startRestartGroup.changed(z6) ? 256 : 128;
                if ((i7 & 8) != 0) {
                    i8 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i8 |= startRestartGroup.changed(mainText) ? 2048 : 1024;
                }
                if ((i7 & 16) != 0) {
                    i8 |= 24576;
                } else if ((i6 & 24576) == 0) {
                    i8 |= startRestartGroup.changedInstance(clickableTexts) ? 16384 : 8192;
                }
                if ((i8 & 9363) != 9362 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z7 = z6;
                } else {
                    modifier3 = i11 != 0 ? Modifier.INSTANCE : modifier2;
                    int i13 = i12 != 0 ? R.drawable.icon_alert_warning : i9;
                    boolean z8 = i10 != 0 ? false : z6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(782276326, i8, -1, "dk.molslinjen.ui.views.reusable.InfoBoxView (InfoBoxView.kt:57)");
                    }
                    Base(modifier3, i13, z8, ComposableLambdaKt.rememberComposableLambda(-1086167609, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.InfoBoxViewKt$InfoBoxView$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i14) {
                            if ((i14 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1086167609, i14, -1, "dk.molslinjen.ui.views.reusable.InfoBoxView.<anonymous> (InfoBoxView.kt:63)");
                            }
                            ClickableTextKt.m3408ClickableTextFHprtrg(null, mainText, clickableTexts, TypographyKt.getSub(), 0L, null, composer2, 3072, 49);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, (i8 & 14) | 3072 | (i8 & 112) | (i8 & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i9 = i13;
                    z7 = z8;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final int i14 = i9;
                    endRestartGroup.updateScope(new Function2() { // from class: W1.n
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit InfoBoxView$lambda$1;
                            InfoBoxView$lambda$1 = InfoBoxViewKt.InfoBoxView$lambda$1(Modifier.this, i14, z7, mainText, clickableTexts, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                            return InfoBoxView$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            z6 = z5;
            if ((i7 & 8) != 0) {
            }
            if ((i7 & 16) != 0) {
            }
            if ((i8 & 9363) != 9362) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Base(modifier3, i13, z8, ComposableLambdaKt.rememberComposableLambda(-1086167609, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.InfoBoxViewKt$InfoBoxView$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i142) {
                    if ((i142 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1086167609, i142, -1, "dk.molslinjen.ui.views.reusable.InfoBoxView.<anonymous> (InfoBoxView.kt:63)");
                    }
                    ClickableTextKt.m3408ClickableTextFHprtrg(null, mainText, clickableTexts, TypographyKt.getSub(), 0L, null, composer2, 3072, 49);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i8 & 14) | 3072 | (i8 & 112) | (i8 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            i9 = i13;
            z7 = z8;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i9 = i5;
        i10 = i7 & 4;
        if (i10 == 0) {
        }
        z6 = z5;
        if ((i7 & 8) != 0) {
        }
        if ((i7 & 16) != 0) {
        }
        if ((i8 & 9363) != 9362) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Base(modifier3, i13, z8, ComposableLambdaKt.rememberComposableLambda(-1086167609, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.InfoBoxViewKt$InfoBoxView$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i142) {
                if ((i142 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1086167609, i142, -1, "dk.molslinjen.ui.views.reusable.InfoBoxView.<anonymous> (InfoBoxView.kt:63)");
                }
                ClickableTextKt.m3408ClickableTextFHprtrg(null, mainText, clickableTexts, TypographyKt.getSub(), 0L, null, composer2, 3072, 49);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i8 & 14) | 3072 | (i8 & 112) | (i8 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        i9 = i13;
        z7 = z8;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
