package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.register.SignupViewModel;
import dk.molslinjen.ui.views.screens.profile.shared.userInfo.IUserInfoInputHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SignupScreenKt$SignupContainer$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $navigateToNationalitySelection;
    final /* synthetic */ Function0<Unit> $navigateToPhoneNumberCodeSelection;
    final /* synthetic */ Function1<Boolean, Unit> $onDismiss;
    final /* synthetic */ Function1<Boolean, Unit> $onTermsAndLicenseAcceptChange;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ IUserInfoInputHandler $userInfoInputHandler;
    final /* synthetic */ Map<SignupScreenPage, IFormValidator> $validators;
    final /* synthetic */ SignupViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SignupScreenKt$SignupContainer$3(ScrollState scrollState, Map<SignupScreenPage, ? extends IFormValidator> map, SignupViewModel.ViewState viewState, PagerState pagerState, IUserInfoInputHandler iUserInfoInputHandler, Function1<? super Boolean, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function1<? super Boolean, Unit> function12) {
        this.$scrollState = scrollState;
        this.$validators = map;
        this.$viewState = viewState;
        this.$pagerState = pagerState;
        this.$userInfoInputHandler = iUserInfoInputHandler;
        this.$onTermsAndLicenseAcceptChange = function1;
        this.$navigateToNationalitySelection = function0;
        this.$navigateToPhoneNumberCodeSelection = function02;
        this.$onDismiss = function12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changed(BottomSheetContainer) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1188978964, i6, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupContainer.<anonymous> (SignupScreen.kt:260)");
        }
        ScrollState scrollState = this.$scrollState;
        Map<SignupScreenPage, IFormValidator> map = this.$validators;
        SignupViewModel.ViewState viewState = this.$viewState;
        PagerState pagerState = this.$pagerState;
        IUserInfoInputHandler iUserInfoInputHandler = this.$userInfoInputHandler;
        Function1<Boolean, Unit> function1 = this.$onTermsAndLicenseAcceptChange;
        Function0<Unit> function0 = this.$navigateToNationalitySelection;
        Function0<Unit> function02 = this.$navigateToPhoneNumberCodeSelection;
        composer.startReplaceGroup(1249120060);
        boolean changed = composer.changed(this.$onDismiss);
        final Function1<Boolean, Unit> function12 = this.$onDismiss;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SignupScreenKt$SignupContainer$3.invoke$lambda$1$lambda$0(Function1.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SignupScreenKt.SignupContent(BottomSheetContainer, scrollState, map, viewState, pagerState, iUserInfoInputHandler, function1, function0, function02, (Function0) rememberedValue, composer, i6 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
