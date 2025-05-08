package dk.molslinjen.ui.views.screens.profile.authentication.login;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.ForgotPasswordScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.login.LoginViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginScreenKt$LoginScreen$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ FormValidator $validator;
    final /* synthetic */ LoginViewModel $viewModel;
    final /* synthetic */ LoginViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginScreenKt$LoginScreen$3(LoginViewModel loginViewModel, DestinationsNavigator destinationsNavigator, LoginViewModel.ViewState viewState, FormValidator formValidator, ScrollState scrollState) {
        this.$viewModel = loginViewModel;
        this.$navigator = destinationsNavigator;
        this.$viewState = viewState;
        this.$validator = formValidator;
        this.$scrollState = scrollState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$9$lambda$8$lambda$7(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, ForgotPasswordScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1491054073, i5, -1, "dk.molslinjen.ui.views.screens.profile.authentication.login.LoginScreen.<anonymous> (LoginScreen.kt:79)");
        }
        float f5 = 24;
        Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(32), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(16));
        Object obj = this.$viewModel;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        LoginViewModel.ViewState viewState = this.$viewState;
        FormValidator formValidator = this.$validator;
        ScrollState scrollState = this.$scrollState;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m314paddingqDBjuR0);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceGroup(-3790280);
        boolean changedInstance = composer.changedInstance(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LoginScreenKt$LoginScreen$3$1$1$1(obj);
            composer.updateRememberedValue(rememberedValue);
        }
        KFunction kFunction = (KFunction) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-3788453);
        boolean changedInstance2 = composer.changedInstance(obj);
        Object rememberedValue2 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new LoginScreenKt$LoginScreen$3$1$2$1(obj);
            composer.updateRememberedValue(rememberedValue2);
        }
        KFunction kFunction2 = (KFunction) rememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-3786599);
        boolean changedInstance3 = composer.changedInstance(obj);
        Object rememberedValue3 = composer.rememberedValue();
        if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new LoginScreenKt$LoginScreen$3$1$3$1(obj);
            composer.updateRememberedValue(rememberedValue3);
        }
        KFunction kFunction3 = (KFunction) rememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-3784840);
        boolean changedInstance4 = composer.changedInstance(obj);
        Object rememberedValue4 = composer.rememberedValue();
        if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new LoginScreenKt$LoginScreen$3$1$4$1(obj);
            composer.updateRememberedValue(rememberedValue4);
        }
        KFunction kFunction4 = (KFunction) rememberedValue4;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-3783175);
        boolean changedInstance5 = composer.changedInstance(obj);
        Object rememberedValue5 = composer.rememberedValue();
        if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
            rememberedValue5 = new LoginScreenKt$LoginScreen$3$1$5$1(obj);
            composer.updateRememberedValue(rememberedValue5);
        }
        KFunction kFunction5 = (KFunction) rememberedValue5;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-3781479);
        boolean changed = composer.changed(destinationsNavigator);
        Object rememberedValue6 = composer.rememberedValue();
        if (changed || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
            rememberedValue6 = new LoginScreenKt$LoginScreen$3$1$6$1(destinationsNavigator);
            composer.updateRememberedValue(rememberedValue6);
        }
        Function0 function0 = (Function0) rememberedValue6;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-3776454);
        boolean changedInstance6 = composer.changedInstance(obj);
        Object rememberedValue7 = composer.rememberedValue();
        if (changedInstance6 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
            rememberedValue7 = new LoginScreenKt$LoginScreen$3$1$7$1(obj);
            composer.updateRememberedValue(rememberedValue7);
        }
        KFunction kFunction6 = (KFunction) rememberedValue7;
        composer.endReplaceGroup();
        Function1 function1 = (Function1) kFunction;
        Function1 function12 = (Function1) kFunction2;
        Function0 function02 = (Function0) kFunction3;
        Function1 function13 = (Function1) kFunction4;
        Function2 function2 = (Function2) kFunction5;
        composer.startReplaceGroup(-3779271);
        boolean changed2 = composer.changed(destinationsNavigator);
        Object rememberedValue8 = composer.rememberedValue();
        if (changed2 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
            rememberedValue8 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.login.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$9$lambda$8$lambda$7;
                    invoke$lambda$9$lambda$8$lambda$7 = LoginScreenKt$LoginScreen$3.invoke$lambda$9$lambda$8$lambda$7(DestinationsNavigator.this);
                    return invoke$lambda$9$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue8);
        }
        composer.endReplaceGroup();
        LoginScreenKt.LoginContent(viewState, formValidator, function1, function12, function02, function13, function2, (Function0) rememberedValue8, function0, (Function0) kFunction6, scrollState, composer, 0, 0);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
