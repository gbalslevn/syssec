package dk.molslinjen.ui.views.screens.onboarding;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.LottieDynamicProperties;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.screens.onboarding.OnboardingBaseScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aE\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a+\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013²\u0006\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\nX\u008a\u0084\u0002"}, d2 = {BuildConfig.FLAVOR, "lottieResource", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "dynamicProperties", BuildConfig.FLAVOR, "header", "description", "Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;", "primaryButton", "secondaryButton", BuildConfig.FLAVOR, "OnboardingBaseView", "(ILcom/airbnb/lottie/compose/LottieDynamicProperties;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/ui/Modifier;", "modifier", "OnboardingLottie", "(Landroidx/compose/ui/Modifier;ILcom/airbnb/lottie/compose/LottieDynamicProperties;Landroidx/compose/runtime/Composer;II)V", "Lcom/airbnb/lottie/LottieComposition;", "composition", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OnboardingBaseScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:28:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OnboardingBaseView(final int i5, final LottieDynamicProperties dynamicProperties, final String header, final String description, final SimpleButtonData primaryButton, SimpleButtonData simpleButtonData, Composer composer, final int i6, final int i7) {
        int i8;
        SimpleButtonData simpleButtonData2;
        int i9;
        SimpleButtonData simpleButtonData3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Composer composer2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(dynamicProperties, "dynamicProperties");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(primaryButton, "primaryButton");
        Composer startRestartGroup = composer.startRestartGroup(-1801047251);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changed(i5) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= (i6 & 64) == 0 ? startRestartGroup.changed(dynamicProperties) : startRestartGroup.changedInstance(dynamicProperties) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changed(header) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changed(description) ? 2048 : 1024;
        }
        if ((i7 & 16) != 0) {
            i8 |= 24576;
        } else if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changed(primaryButton) ? 16384 : 8192;
        }
        int i10 = i7 & 32;
        if (i10 != 0) {
            i8 |= 196608;
        } else if ((196608 & i6) == 0) {
            simpleButtonData2 = simpleButtonData;
            i8 |= startRestartGroup.changed(simpleButtonData2) ? 131072 : 65536;
            i9 = i8;
            if ((74899 & i9) == 74898 || !startRestartGroup.getSkipping()) {
                simpleButtonData3 = i10 == 0 ? null : simpleButtonData2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1801047251, i9, -1, "dk.molslinjen.ui.views.screens.onboarding.OnboardingBaseView (OnboardingBaseScreen.kt:45)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(24), 0.0f, 2, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                SpacerKt.Spacer(ColumnScope.weight$default(ColumnScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), startRestartGroup, 0);
                int i11 = i9 << 3;
                OnboardingLottie(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), 1.0f, false, 2, null), i5, dynamicProperties, startRestartGroup, (i11 & 112) | 6 | (LottieDynamicProperties.$stable << 6) | (i11 & 896), 0);
                TextStyle h1Bold = TypographyKt.getH1Bold();
                TextAlign.Companion companion3 = TextAlign.INSTANCE;
                TextKt.m940Text4IGK_g(header, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, h1Bold, startRestartGroup, (i9 >> 6) & 14, 1572864, 65022);
                float f5 = 16;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
                AppColor appColor = AppColor.INSTANCE;
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(description, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphSmall, composer2, ((i9 >> 9) & 14) | 384, 1572864, 65018);
                SpacerKt.Spacer(SizeKt.m327heightInVpY3zN4$default(companion, Dp.m2599constructorimpl(56), 0.0f, 2, null), composer2, 6);
                ButtonConfig buttonConfig = simpleButtonData3 != null ? ButtonConfig.Large : ButtonConfig.Regular;
                PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), primaryButton.getText(), primaryButton.getOnClick(), null, buttonConfig, false, false, false, composer2, 6, 232);
                composer2.startReplaceGroup(-503587385);
                if (simpleButtonData3 != null) {
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
                    SecondaryButtonKt.m3406SecondaryButtonbZJ32A(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), simpleButtonData3.getText(), simpleButtonData3.getOnClick(), null, false, buttonConfig, false, null, null, 0L, false, composer2, 6, 0, 2008);
                }
                composer2.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(40)), composer2, 6);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.onboarding_common_changeInSettings, composer2, 6), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65530);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(50)), composer2, 6);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                simpleButtonData3 = simpleButtonData2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final SimpleButtonData simpleButtonData4 = simpleButtonData3;
                endRestartGroup.updateScope(new Function2() { // from class: q3.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit OnboardingBaseView$lambda$1;
                        OnboardingBaseView$lambda$1 = OnboardingBaseScreenKt.OnboardingBaseView$lambda$1(i5, dynamicProperties, header, description, primaryButton, simpleButtonData4, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return OnboardingBaseView$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        simpleButtonData2 = simpleButtonData;
        i9 = i8;
        if ((74899 & i9) == 74898) {
        }
        if (i10 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion4 = Modifier.INSTANCE;
        Modifier verticalScroll$default2 = ScrollKt.verticalScroll$default(PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion4, 0.0f, 1, null), Dp.m2599constructorimpl(24), 0.0f, 2, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default2);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
        SpacerKt.Spacer(ColumnScope.weight$default(ColumnScopeInstance.INSTANCE, companion4, 1.0f, false, 2, null), startRestartGroup, 0);
        int i112 = i9 << 3;
        OnboardingLottie(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), 1.0f, false, 2, null), i5, dynamicProperties, startRestartGroup, (i112 & 112) | 6 | (LottieDynamicProperties.$stable << 6) | (i112 & 896), 0);
        TextStyle h1Bold2 = TypographyKt.getH1Bold();
        TextAlign.Companion companion32 = TextAlign.INSTANCE;
        TextKt.m940Text4IGK_g(header, null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion32.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, h1Bold2, startRestartGroup, (i9 >> 6) & 14, 1572864, 65022);
        float f52 = 16;
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion4, Dp.m2599constructorimpl(f52)), startRestartGroup, 6);
        TextStyle paragraphSmall2 = TypographyKt.getParagraphSmall();
        AppColor appColor2 = AppColor.INSTANCE;
        composer2 = startRestartGroup;
        TextKt.m940Text4IGK_g(description, null, appColor2.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion32.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphSmall2, composer2, ((i9 >> 9) & 14) | 384, 1572864, 65018);
        SpacerKt.Spacer(SizeKt.m327heightInVpY3zN4$default(companion4, Dp.m2599constructorimpl(56), 0.0f, 2, null), composer2, 6);
        ButtonConfig buttonConfig2 = simpleButtonData3 != null ? ButtonConfig.Large : ButtonConfig.Regular;
        PrimaryButtonKt.PrimaryButton(SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), primaryButton.getText(), primaryButton.getOnClick(), null, buttonConfig2, false, false, false, composer2, 6, 232);
        composer2.startReplaceGroup(-503587385);
        if (simpleButtonData3 != null) {
        }
        composer2.endReplaceGroup();
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion4, Dp.m2599constructorimpl(40)), composer2, 6);
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.onboarding_common_changeInSettings, composer2, 6), null, appColor2.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65530);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion4, Dp.m2599constructorimpl(50)), composer2, 6);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingBaseView$lambda$1(int i5, LottieDynamicProperties lottieDynamicProperties, String str, String str2, SimpleButtonData simpleButtonData, SimpleButtonData simpleButtonData2, int i6, int i7, Composer composer, int i8) {
        OnboardingBaseView(i5, lottieDynamicProperties, str, str2, simpleButtonData, simpleButtonData2, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final void OnboardingLottie(Modifier modifier, final int i5, final LottieDynamicProperties lottieDynamicProperties, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        Composer composer2;
        final Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(-490762655);
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
            i8 |= (i6 & 512) == 0 ? startRestartGroup.changed(lottieDynamicProperties) : startRestartGroup.changedInstance(lottieDynamicProperties) ? 256 : 128;
        }
        int i10 = i8;
        if ((i10 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = startRestartGroup;
        } else {
            Modifier modifier4 = i9 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-490762655, i10, -1, "dk.molslinjen.ui.views.screens.onboarding.OnboardingLottie (OnboardingBaseScreen.kt:109)");
            }
            int i11 = i10 << 3;
            composer2 = startRestartGroup;
            LottieAnimationKt.LottieAnimation(OnboardingLottie$lambda$2(RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(i5)), null, null, null, null, null, startRestartGroup, 0, 62)), modifier4, false, false, null, 0.0f, 1, false, true, false, null, false, false, lottieDynamicProperties, null, null, false, null, composer2, (i11 & 112) | 102236160, (LottieDynamicProperties.$stable << 9) | (i11 & 7168), 253628);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: q3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnboardingLottie$lambda$3;
                    OnboardingLottie$lambda$3 = OnboardingBaseScreenKt.OnboardingLottie$lambda$3(Modifier.this, i5, lottieDynamicProperties, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return OnboardingLottie$lambda$3;
                }
            });
        }
    }

    private static final LottieComposition OnboardingLottie$lambda$2(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLottie$lambda$3(Modifier modifier, int i5, LottieDynamicProperties lottieDynamicProperties, int i6, int i7, Composer composer, int i8) {
        OnboardingLottie(modifier, i5, lottieDynamicProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
