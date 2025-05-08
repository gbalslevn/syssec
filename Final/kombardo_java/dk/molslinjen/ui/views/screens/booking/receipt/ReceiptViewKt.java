package dk.molslinjen.ui.views.screens.booking.receipt;

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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.lottie.ShrinkingCheckmarkAnimationViewKt;
import dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u001ac\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u0010\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "Landroidx/compose/ui/text/AnnotatedString;", "description", "buttonText", "Lkotlin/Function0;", BuildConfig.FLAVOR, "dismiss", "buttonAction", "bannerContent", "detailsContent", "ReceiptView", "(Ljava/lang/String;Landroidx/compose/ui/text/AnnotatedString;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "formatText", "email", "buildReceiptDescription", "(ILjava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ReceiptViewKt {
    public static final void ReceiptView(final String title, final AnnotatedString description, final String str, final Function0<Unit> dismiss, final Function0<Unit> buttonAction, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> detailsContent, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Intrinsics.checkNotNullParameter(buttonAction, "buttonAction");
        Intrinsics.checkNotNullParameter(detailsContent, "detailsContent");
        Composer startRestartGroup = composer.startRestartGroup(1822880777);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(title) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(description) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(dismiss) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(buttonAction) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(detailsContent) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1822880777, i7, -1, "dk.molslinjen.ui.views.screens.booking.receipt.ReceiptView (ReceiptView.kt:35)");
            }
            composer2 = startRestartGroup;
            ShrinkingCheckmarkAnimationViewKt.m3423ShrinkingCheckmarkAnimationVieweuL9pac(AppColor.INSTANCE.m3269getGrey60d7_KjU(), true, dismiss, ComposableLambdaKt.rememberComposableLambda(133360776, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.receipt.ReceiptViewKt$ReceiptView$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i8) {
                    float f5;
                    Modifier.Companion companion;
                    Composer composer4;
                    int i9;
                    if ((i8 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(133360776, i8, -1, "dk.molslinjen.ui.views.screens.booking.receipt.ReceiptView.<anonymous> (ReceiptView.kt:41)");
                    }
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    float f6 = 16;
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(companion2, 0.0f, 1, null), Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(40), 2, null);
                    Function2<Composer, Integer, Unit> function22 = function2;
                    String str2 = str;
                    Function2<Composer, Integer, Unit> function23 = detailsContent;
                    String str3 = title;
                    AnnotatedString annotatedString = description;
                    Function0<Unit> function0 = buttonAction;
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.Vertical top = arrangement.getTop();
                    Alignment.Companion companion3 = Alignment.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composer3, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m315paddingqDBjuR0$default);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Alignment.Horizontal centerHorizontally = companion3.getCenterHorizontally();
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, composer3, 48);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, fillMaxWidth$default);
                    Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor2);
                    } else {
                        composer3.useNode();
                    }
                    Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer3);
                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                    TextKt.m940Text4IGK_g(str3, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), composer3, 0, 1572864, 65534);
                    TextKt.m941TextIbK3jfQ(annotatedString, PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, TypographyKt.getParagraphSmall(), composer3, 48, 12582912, 130556);
                    composer3.endNode();
                    float f7 = 24;
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f7)), composer3, 6);
                    composer3.startReplaceGroup(1810727864);
                    if (function22 != null) {
                        function22.invoke(composer3, 0);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f7)), composer3, 6);
                    }
                    composer3.endReplaceGroup();
                    composer3.startReplaceGroup(1810732365);
                    if (str2 == null) {
                        composer4 = composer3;
                        i9 = 6;
                        companion = companion2;
                        f5 = f7;
                    } else {
                        f5 = f7;
                        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), str2, function0, null, false, null, false, null, null, AppColor.INSTANCE.m3280getTransparent0d7_KjU(), false, composer3, 805306374, 0, 1528);
                        companion = companion2;
                        composer4 = composer3;
                        i9 = 6;
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(32)), composer4, 6);
                    }
                    composer3.endReplaceGroup();
                    function23.invoke(composer4, 0);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer4, i9);
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, ((i7 >> 3) & 896) | 3126, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Z2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ReceiptView$lambda$0;
                    ReceiptView$lambda$0 = ReceiptViewKt.ReceiptView$lambda$0(title, description, str, dismiss, buttonAction, function2, detailsContent, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ReceiptView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ReceiptView$lambda$0(String str, AnnotatedString annotatedString, String str2, Function0 function0, Function0 function02, Function2 function2, Function2 function22, int i5, Composer composer, int i6) {
        ReceiptView(str, annotatedString, str2, function0, function02, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final AnnotatedString buildReceiptDescription(int i5, String email, Composer composer, int i6) {
        Intrinsics.checkNotNullParameter(email, "email");
        composer.startReplaceGroup(-1543517384);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1543517384, i6, -1, "dk.molslinjen.ui.views.screens.booking.receipt.buildReceiptDescription (ReceiptView.kt:88)");
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        String stringResource = StringResources_androidKt.stringResource(i5, new Object[]{email}, composer, i6 & 14);
        builder.append(stringResource);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) stringResource, email, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            builder.addStyle(new SpanStyle(0L, TypographyKt.getParagraphSmallBold().m2299getFontSizeXSAIIZE(), TypographyKt.getParagraphSmallBold().getFontWeight(), null, null, TypographyKt.getParagraphSmallBold().getFontFamily(), null, 0L, null, null, null, 0L, null, null, null, null, 65497, null), indexOf$default, email.length() + indexOf$default);
        } else {
            Logger.log$default(Logger.INSTANCE, "Error adding annotation: " + email + " was not part of " + stringResource, null, 0, 6, null);
        }
        AnnotatedString annotatedString = builder.toAnnotatedString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return annotatedString;
    }
}
