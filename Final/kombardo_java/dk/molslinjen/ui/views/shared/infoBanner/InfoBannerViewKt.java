package dk.molslinjen.ui.views.shared.infoBanner;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
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
import dev.jeziellago.compose.markdowntext.MarkdownTextKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.shared.infoBanner.InfoBannerViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\b\u001a1\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0003¢\u0006\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "icon", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "InfoBannerView", "(Landroidx/compose/ui/Modifier;ILjava/lang/String;Landroidx/compose/runtime/Composer;II)V", "markdownText", "InfoBannerMarkdownView", "Lkotlin/Function0;", "textComponent", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class InfoBannerViewKt {
    public static final void InfoBannerMarkdownView(Modifier modifier, final int i5, final String markdownText, Composer composer, final int i6, final int i7) {
        int i8;
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        Composer startRestartGroup = composer.startRestartGroup(294007351);
        int i9 = i7 & 1;
        if (i9 != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
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
            i8 |= startRestartGroup.changed(markdownText) ? 256 : 128;
        }
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i9 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(294007351, i8, -1, "dk.molslinjen.ui.views.shared.infoBanner.InfoBannerMarkdownView (InfoBannerView.kt:38)");
            }
            InfoBannerView(modifier, i5, ComposableLambdaKt.rememberComposableLambda(-597116667, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.infoBanner.InfoBannerViewKt$InfoBannerMarkdownView$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-597116667, i10, -1, "dk.molslinjen.ui.views.shared.infoBanner.InfoBannerMarkdownView.<anonymous> (InfoBannerView.kt:43)");
                    }
                    MarkdownTextKt.m3186MarkdownTextnAGSkkc(markdownText, null, 0L, 0L, null, 0, null, TypographyKt.getSub(), null, null, false, null, null, null, composer2, 12582912, 0, 16254);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i8 & 14) | 384 | (i8 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoBannerMarkdownView$lambda$1;
                    InfoBannerMarkdownView$lambda$1 = InfoBannerViewKt.InfoBannerMarkdownView$lambda$1(Modifier.this, i5, markdownText, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoBannerMarkdownView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoBannerMarkdownView$lambda$1(Modifier modifier, int i5, String str, int i6, int i7, Composer composer, int i8) {
        InfoBannerMarkdownView(modifier, i5, str, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    public static final void InfoBannerView(Modifier modifier, final int i5, final String text, Composer composer, final int i6, final int i7) {
        int i8;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(1053742438);
        int i9 = i7 & 1;
        if (i9 != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
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
            i8 |= startRestartGroup.changed(text) ? 256 : 128;
        }
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i9 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1053742438, i8, -1, "dk.molslinjen.ui.views.shared.infoBanner.InfoBannerView (InfoBannerView.kt:24)");
            }
            InfoBannerView(modifier, i5, ComposableLambdaKt.rememberComposableLambda(-384562636, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.infoBanner.InfoBannerViewKt$InfoBannerView$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-384562636, i10, -1, "dk.molslinjen.ui.views.shared.infoBanner.InfoBannerView.<anonymous> (InfoBannerView.kt:29)");
                    }
                    TextKt.m940Text4IGK_g(text, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, (i8 & 14) | 384 | (i8 & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoBannerView$lambda$0;
                    InfoBannerView$lambda$0 = InfoBannerViewKt.InfoBannerView$lambda$0(Modifier.this, i5, text, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoBannerView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoBannerView$lambda$0(Modifier modifier, int i5, String str, int i6, int i7, Composer composer, int i8) {
        InfoBannerView(modifier, i5, str, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoBannerView$lambda$3(Modifier modifier, int i5, Function2 function2, int i6, int i7, Composer composer, int i8) {
        InfoBannerView(modifier, i5, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final void InfoBannerView(Modifier modifier, final int i5, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        final Modifier modifier3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1770332870);
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
            i8 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        int i10 = i8;
        if ((i10 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = startRestartGroup;
        } else {
            modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1770332870, i10, -1, "dk.molslinjen.ui.views.shared.infoBanner.InfoBannerView (InfoBannerView.kt:52)");
            }
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 12;
            float f6 = 16;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m314paddingqDBjuR0(BackgroundKt.m103backgroundbw27NRU(modifier3, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6)), 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            composer2 = startRestartGroup;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i5, startRestartGroup, (i10 >> 3) & 14), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(f6)), appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer2, 6);
            function2.invoke(composer2, Integer.valueOf((i10 >> 6) & 14));
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InfoBannerView$lambda$3;
                    InfoBannerView$lambda$3 = InfoBannerViewKt.InfoBannerView$lambda$3(Modifier.this, i5, function2, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return InfoBannerView$lambda$3;
                }
            });
        }
    }
}
