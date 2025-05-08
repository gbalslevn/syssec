package dk.molslinjen.ui.views.screens.booking.payment;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavOptions;
import androidx.view.compose.BackHandlerKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.google.accompanist.web.AccompanistWebViewClient;
import com.google.accompanist.web.WebViewKt;
import com.google.accompanist.web.WebViewState;
import com.ramcosta.composedestinations.generated.destinations.AgreementsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.BornholmCommuterDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PaymentBottomSheetScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.ReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SaleOnBoardScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.spec.RouteOrDirection;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.managers.checkout.PaymentManager;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.lottie.FixedSizeLottieAnimationKt;
import dk.molslinjen.ui.views.screens.booking.payment.PaymentScreenKt;
import dk.molslinjen.ui.views.screens.booking.payment.PaymentViewModel;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u001c\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001aO\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a9\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00132\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010#\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$¨\u0006)²\u0006\u000e\u0010&\u001a\u0004\u0018\u00010%8\nX\u008a\u0084\u0002²\u0006\f\u0010(\u001a\u00020'8\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "checkoutExpirationDialogHandler", BuildConfig.FLAVOR, "PaymentScreen", "(Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", BuildConfig.FLAVOR, "proceed", "Lkotlin/Function0;", "dismiss", "PaymentScreenShared", "(Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/PaymentManager$PaymentState;", "paymentState", "showPaymentError", "Lkotlin/Function1;", "updateWebViewBackNavigationAllowed", "switchToFallbackPaymentUrl", "PaymentContent", "(Ldk/molslinjen/ui/views/screens/booking/payment/PaymentViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/PaymentManager$PaymentState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "updateBackNavigationAllowed", "dk/molslinjen/ui/views/screens/booking/payment/PaymentScreenKt$webViewClient$1", "webViewClient", "(Ldk/molslinjen/domain/managers/checkout/PaymentManager$PaymentState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Ldk/molslinjen/ui/views/screens/booking/payment/PaymentScreenKt$webViewClient$1;", BuildConfig.FLAVOR, "url", "Landroid/content/Context;", "context", "launchExternalApp", "(Ljava/lang/String;Landroid/content/Context;)Z", "Lcom/airbnb/lottie/LottieComposition;", "composition", BuildConfig.FLAVOR, "progress", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PaymentScreenKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentOrigin.values().length];
            try {
                iArr[PaymentOrigin.Ticket.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentOrigin.TicketChange.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaymentOrigin.MultiRideTicketFromAgreements.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaymentOrigin.CommuterTicketFromAgreements.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PaymentOrigin.MultiRideTicketFromDetails.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PaymentOrigin.CommuterTicketFromDetails.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PaymentOrigin.SaleOnBoard.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PaymentOrigin.SimpleChangeOrEarlyCheckInTicket.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PaymentOrigin.MultiRideCardFromDetails.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PaymentOrigin.MultiRideCardFromAgreements.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private static final void PaymentContent(final PaymentViewModel.ViewState viewState, final PaymentManager.PaymentState paymentState, final Function0<Unit> function0, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1254365363);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(paymentState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1254365363, i6, -1, "dk.molslinjen.ui.views.screens.booking.payment.PaymentContent (PaymentScreen.kt:148)");
            }
            boolean z5 = !viewState.getIsBackNavigationAllowed();
            startRestartGroup.startReplaceGroup(1366884000);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new Function0() { // from class: Y2.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            BackHandlerKt.BackHandler(z5, (Function0) rememberedValue, startRestartGroup, 48, 0);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            String paymentWindowUrl = viewState.getPaymentWindowUrl();
            if (paymentWindowUrl == null) {
                paymentWindowUrl = BuildConfig.FLAVOR;
            }
            WebViewState rememberWebViewState = WebViewKt.rememberWebViewState(paymentWindowUrl, null, startRestartGroup, 0, 2);
            String paymentWindowUrl2 = viewState.getPaymentWindowUrl();
            boolean z6 = (paymentWindowUrl2 == null || StringsKt.startsWith$default(paymentWindowUrl2, "http", false, 2, (Object) null)) ? false : true;
            if (viewState.getPaymentWindowUrl() == null || z6 || (paymentState.getPaymentCallbackReceived() && !Intrinsics.areEqual(paymentState.getPaymentSucceeded(), Boolean.FALSE))) {
                startRestartGroup.startReplaceGroup(-1379670075);
                Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                Boolean valueOf = Boolean.valueOf(z6);
                startRestartGroup.startReplaceGroup(-737239750);
                boolean changed = startRestartGroup.changed(z6) | ((i6 & 14) == 4) | startRestartGroup.changedInstance(context) | ((i6 & 57344) == 16384);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == companion.getEmpty()) {
                    i7 = 0;
                    rememberedValue2 = new PaymentScreenKt$PaymentContent$2$2$1(z6, viewState, context, function02, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                } else {
                    i7 = 0;
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i7);
                LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(R.raw.animation_lottie_full_width_spinner)), null, null, null, null, null, startRestartGroup, 6, 62);
                final LottieAnimationState animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(PaymentContent$lambda$20$lambda$16(rememberLottieComposition), false, false, false, null, 0.0f, Integer.MAX_VALUE, null, false, false, startRestartGroup, 1572864, 958);
                LottieComposition PaymentContent$lambda$20$lambda$16 = PaymentContent$lambda$20$lambda$16(rememberLottieComposition);
                startRestartGroup.startReplaceGroup(-737208128);
                boolean changed2 = startRestartGroup.changed(animateLottieCompositionAsState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: Y2.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            float PaymentContent$lambda$20$lambda$17;
                            PaymentContent$lambda$20$lambda$17 = PaymentScreenKt.PaymentContent$lambda$20$lambda$17(LottieAnimationState.this);
                            return Float.valueOf(PaymentContent$lambda$20$lambda$17);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                FixedSizeLottieAnimationKt.FixedSizeLottieAnimation(PaymentContent$lambda$20$lambda$16, (Function0) rememberedValue3, null, Accessibility.INSTANCE.getSkip(), startRestartGroup, 0, 4);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1380226184);
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
                PaymentScreenKt$webViewClient$1 webViewClient = webViewClient(paymentState, function1, function0, startRestartGroup, ((i6 >> 3) & 14) | ((i6 >> 6) & 112) | (i6 & 896));
                startRestartGroup.startReplaceGroup(-737254656);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: Y2.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PaymentContent$lambda$20$lambda$14$lambda$13;
                            PaymentContent$lambda$20$lambda$14$lambda$13 = PaymentScreenKt.PaymentContent$lambda$20$lambda$14$lambda$13((WebView) obj);
                            return PaymentContent$lambda$20$lambda$14$lambda$13;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                WebViewKt.WebView(rememberWebViewState, fillMaxSize$default, false, null, (Function1) rememberedValue4, null, webViewClient, null, null, startRestartGroup, 25008, 424);
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Y2.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PaymentContent$lambda$21;
                    PaymentContent$lambda$21 = PaymentScreenKt.PaymentContent$lambda$21(PaymentViewModel.ViewState.this, paymentState, function0, function1, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PaymentContent$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentContent$lambda$20$lambda$14$lambda$13(WebView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.getSettings().setJavaScriptEnabled(true);
        return Unit.INSTANCE;
    }

    private static final LottieComposition PaymentContent$lambda$20$lambda$16(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float PaymentContent$lambda$20$lambda$17(LottieAnimationState lottieAnimationState) {
        return lottieAnimationState.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentContent$lambda$21(PaymentViewModel.ViewState viewState, PaymentManager.PaymentState paymentState, Function0 function0, Function1 function1, Function0 function02, int i5, Composer composer, int i6) {
        PaymentContent(viewState, paymentState, function0, function1, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PaymentScreen(final PaymentViewModel viewModel, final DestinationsNavigator navigator, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(909122302);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= (i5 & 512) == 0 ? startRestartGroup.changed(checkoutExpirationDialogHandler) : startRestartGroup.changedInstance(checkoutExpirationDialogHandler) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(909122302, i6, -1, "dk.molslinjen.ui.views.screens.booking.payment.PaymentScreen (PaymentScreen.kt:62)");
            }
            int i7 = i6 & 14;
            int i8 = i6 & 112;
            checkoutExpirationDialogHandler.HandleDepartureExpiration(viewModel, navigator, startRestartGroup, i6 & 1022);
            startRestartGroup.startReplaceGroup(-769922280);
            boolean z5 = i8 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function2() { // from class: Y2.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit PaymentScreen$lambda$1$lambda$0;
                        PaymentScreen$lambda$1$lambda$0 = PaymentScreenKt.PaymentScreen$lambda$1$lambda$0(DestinationsNavigator.this, (PaymentOrigin) obj, ((Boolean) obj2).booleanValue());
                        return PaymentScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function2 function2 = (Function2) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-769869785);
            boolean z6 = i8 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new PaymentScreenKt$PaymentScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            PaymentScreenShared(viewModel, function2, (Function0) rememberedValue2, startRestartGroup, i7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Y2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PaymentScreen$lambda$3;
                    PaymentScreen$lambda$3 = PaymentScreenKt.PaymentScreen$lambda$3(PaymentViewModel.this, navigator, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PaymentScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentScreen$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator, PaymentOrigin paymentOrigin, boolean z5) {
        RouteOrDirection routeOrDirection;
        Intrinsics.checkNotNullParameter(paymentOrigin, "paymentOrigin");
        switch (WhenMappings.$EnumSwitchMapping$0[paymentOrigin.ordinal()]) {
            case 1:
                routeOrDirection = DeparturesScreenDestination.INSTANCE;
                break;
            case 2:
                routeOrDirection = TicketDetailsScreenDestination.INSTANCE;
                break;
            case 3:
                routeOrDirection = AgreementsScreenDestination.INSTANCE;
                break;
            case 4:
                routeOrDirection = AgreementsScreenDestination.INSTANCE;
                break;
            case 5:
                routeOrDirection = MultiRideDetailsScreenDestination.INSTANCE;
                break;
            case 6:
                routeOrDirection = BornholmCommuterDetailsScreenDestination.INSTANCE;
                break;
            case 7:
                routeOrDirection = SaleOnBoardScreenDestination.INSTANCE;
                break;
            case 8:
            case 9:
            case 10:
                Logger.INSTANCE.logCriticalThenFatalError(new CriticalLog("Should be using " + Reflection.getOrCreateKotlinClass(PaymentBottomSheetScreenDestination.class).getSimpleName() + " for " + paymentOrigin + " origin, and not PaymentScreenDestination"));
                return Unit.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, paymentOrigin == PaymentOrigin.SaleOnBoard ? SaleOnBoardReceiptScreenDestination.INSTANCE : ReceiptScreenDestination.INSTANCE, NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), routeOrDirection.getRoute(), false, false, 4, (Object) null).build(), null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentScreen$lambda$3(PaymentViewModel paymentViewModel, DestinationsNavigator destinationsNavigator, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        PaymentScreen(paymentViewModel, destinationsNavigator, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PaymentScreenShared(final PaymentViewModel viewModel, final Function2<? super PaymentOrigin, ? super Boolean, Unit> proceed, final Function0<Unit> dismiss, Composer composer, final int i5) {
        int i6;
        Boolean bool;
        PaymentManager.PaymentState paymentState;
        boolean z5;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Composer startRestartGroup = composer.startRestartGroup(1591801837);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(proceed) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(dismiss) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1591801837, i7, -1, "dk.molslinjen.ui.views.screens.booking.payment.PaymentScreenShared (PaymentScreen.kt:104)");
            }
            PaymentViewModel.ViewState viewState = (PaymentViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            PaymentManager.PaymentState paymentState2 = (PaymentManager.PaymentState) SnapshotStateKt.collectAsState(viewModel.getPaymentState(), null, startRestartGroup, 0, 1).getValue();
            Configuration configuration = (Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
            float m2599constructorimpl = Dp.m2599constructorimpl(configuration.screenWidthDp);
            float m2599constructorimpl2 = Dp.m2599constructorimpl(configuration.screenHeightDp);
            Boolean bool2 = Boolean.TRUE;
            startRestartGroup.startReplaceGroup(852825936);
            int i8 = i7 & 896;
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | (i8 == 256) | startRestartGroup.changed(m2599constructorimpl) | startRestartGroup.changed(m2599constructorimpl2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                bool = bool2;
                paymentState = paymentState2;
                z5 = true;
                PaymentScreenKt$PaymentScreenShared$1$1 paymentScreenKt$PaymentScreenShared$1$1 = new PaymentScreenKt$PaymentScreenShared$1$1(viewModel, dismiss, m2599constructorimpl, m2599constructorimpl2, null);
                startRestartGroup.updateRememberedValue(paymentScreenKt$PaymentScreenShared$1$1);
                rememberedValue = paymentScreenKt$PaymentScreenShared$1$1;
            } else {
                bool = bool2;
                paymentState = paymentState2;
                z5 = true;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 6);
            Boolean paymentSucceeded = paymentState.getPaymentSucceeded();
            startRestartGroup.startReplaceGroup(852831631);
            PaymentManager.PaymentState paymentState3 = paymentState;
            boolean changedInstance2 = startRestartGroup.changedInstance(paymentState3) | startRestartGroup.changedInstance(viewModel) | (i8 == 256 ? z5 : false);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new PaymentScreenKt$PaymentScreenShared$2$1(paymentState3, viewModel, dismiss, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(paymentSucceeded, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 0);
            Boolean paymentAndOrderCompleted = paymentState3.getPaymentAndOrderCompleted();
            startRestartGroup.startReplaceGroup(852840517);
            boolean changedInstance3 = startRestartGroup.changedInstance(paymentState3) | startRestartGroup.changedInstance(viewModel) | ((i7 & 112) == 32 ? z5 : false);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new PaymentScreenKt$PaymentScreenShared$3$1(paymentState3, viewModel, proceed, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(paymentAndOrderCompleted, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(852850480);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new PaymentScreenKt$PaymentScreenShared$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function0 = (Function0) ((KFunction) rememberedValue4);
            startRestartGroup.startReplaceGroup(852852866);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new PaymentScreenKt$PaymentScreenShared$5$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue5);
            startRestartGroup.startReplaceGroup(852855546);
            boolean changedInstance6 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new PaymentScreenKt$PaymentScreenShared$6$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            PaymentContent(viewState, paymentState3, function0, function1, (Function0) ((KFunction) rememberedValue6), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Y2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PaymentScreenShared$lambda$10;
                    PaymentScreenShared$lambda$10 = PaymentScreenKt.PaymentScreenShared$lambda$10(PaymentViewModel.this, proceed, dismiss, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PaymentScreenShared$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentScreenShared$lambda$10(PaymentViewModel paymentViewModel, Function2 function2, Function0 function0, int i5, Composer composer, int i6) {
        PaymentScreenShared(paymentViewModel, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean launchExternalApp(String str, Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e5) {
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "appswitch.mitid", false, 2, (Object) null)) {
                return true;
            }
            Logger.INSTANCE.logError(e5);
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [dk.molslinjen.ui.views.screens.booking.payment.PaymentScreenKt$webViewClient$1] */
    private static final PaymentScreenKt$webViewClient$1 webViewClient(final PaymentManager.PaymentState paymentState, final Function1<? super Boolean, Unit> function1, final Function0<Unit> function0, final Composer composer, int i5) {
        composer.startReplaceGroup(-128436889);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-128436889, i5, -1, "dk.molslinjen.ui.views.screens.booking.payment.webViewClient (PaymentScreen.kt:208)");
        }
        ?? r7 = new AccompanistWebViewClient(composer, function0, paymentState, function1) { // from class: dk.molslinjen.ui.views.screens.booking.payment.PaymentScreenKt$webViewClient$1
            final /* synthetic */ PaymentManager.PaymentState $paymentState;
            final /* synthetic */ Function0<Unit> $showPaymentError;
            final /* synthetic */ Function1<Boolean, Unit> $updateBackNavigationAllowed;
            private final Context context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$showPaymentError = function0;
                this.$paymentState = paymentState;
                this.$updateBackNavigationAllowed = function1;
                this.context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            }

            @Override // com.google.accompanist.web.AccompanistWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.$updateBackNavigationAllowed.invoke(Boolean.TRUE);
                super.onPageFinished(view, url);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                Uri url;
                String uri;
                if (this.$paymentState.getPaymentType() == PaymentType.MobilePay) {
                    return super.shouldInterceptRequest(view, request);
                }
                boolean z5 = false;
                if (request != null && (url = request.getUrl()) != null && (uri = url.toString()) != null && StringsKt.contains$default((CharSequence) uri, (CharSequence) "calculateSurcharge", false, 2, (Object) null)) {
                    z5 = true;
                }
                if (Intrinsics.areEqual(request != null ? request.getMethod() : null, "POST") && !z5) {
                    this.$updateBackNavigationAllowed.invoke(Boolean.FALSE);
                }
                return super.shouldInterceptRequest(view, request);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri url;
                String uri;
                if (request == null || (url = request.getUrl()) == null || (uri = url.toString()) == null) {
                    return super.shouldOverrideUrlLoading(view, request);
                }
                if (StringsKt.contains((CharSequence) uri, (CharSequence) "/500.html", true)) {
                    this.$showPaymentError.invoke();
                    return true;
                }
                if (StringsKt.startsWith$default(uri, "http", false, 2, (Object) null)) {
                    return super.shouldOverrideUrlLoading(view, request);
                }
                PaymentScreenKt.launchExternalApp(uri, this.context);
                return true;
            }
        };
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return r7;
    }
}
