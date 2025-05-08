package dk.molslinjen.ui.views.screens.profile.authentication.register;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SignupScreenKt$SignupContainer$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ SignupScreenPage $currentPage;
    final /* synthetic */ IFormValidator $currentValidator;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ State<Boolean> $isButtonEnabled$delegate;
    final /* synthetic */ boolean $isShowingAuthenticationScreen;
    final /* synthetic */ int $lastPageIndex;
    final /* synthetic */ Function0<Unit> $onSubmit;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ ScrollState $scrollState;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SignupScreenPage.values().length];
            try {
                iArr[SignupScreenPage.PasswordAndTerms.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignupScreenKt$SignupContainer$2(boolean z5, SignupScreenPage signupScreenPage, IFormValidator iFormValidator, FocusManager focusManager, CoroutineScope coroutineScope, ScrollState scrollState, Function0<Unit> function0, PagerState pagerState, int i5, State<Boolean> state) {
        this.$isShowingAuthenticationScreen = z5;
        this.$currentPage = signupScreenPage;
        this.$currentValidator = iFormValidator;
        this.$focusManager = focusManager;
        this.$coroutineScope = coroutineScope;
        this.$scrollState = scrollState;
        this.$onSubmit = function0;
        this.$pagerState = pagerState;
        this.$lastPageIndex = i5;
        this.$isButtonEnabled$delegate = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(IFormValidator iFormValidator) {
        if (iFormValidator != null) {
            iFormValidator.submitAllFields();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(FocusManager focusManager, SignupScreenPage signupScreenPage, CoroutineScope coroutineScope, Function0 function0, ScrollState scrollState, PagerState pagerState, int i5) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1281getExitdhqQ8s());
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        if (WhenMappings.$EnumSwitchMapping$0[signupScreenPage.ordinal()] == 1) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SignupScreenKt$SignupContainer$2$2$1$1(scrollState, null), 3, null);
            function0.invoke();
        } else {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SignupScreenKt$SignupContainer$2$2$1$2(pagerState, signupScreenPage, i5, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        boolean SignupContainer$lambda$3;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(349995931, i5, -1, "dk.molslinjen.ui.views.screens.profile.authentication.register.SignupContainer.<anonymous> (SignupScreen.kt:230)");
        }
        if (!this.$isShowingAuthenticationScreen) {
            String stringResource = StringResources_androidKt.stringResource(this.$currentPage.getPageButtonText(), composer, 0);
            SignupContainer$lambda$3 = SignupScreenKt.SignupContainer$lambda$3(this.$isButtonEnabled$delegate);
            composer.startReplaceGroup(1249100092);
            boolean changedInstance = composer.changedInstance(this.$currentValidator);
            final IFormValidator iFormValidator = this.$currentValidator;
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = SignupScreenKt$SignupContainer$2.invoke$lambda$1$lambda$0(IFormValidator.this);
                        return invoke$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            composer.endReplaceGroup();
            composer.startReplaceGroup(1249073014);
            boolean changedInstance2 = composer.changedInstance(this.$focusManager) | composer.changed(this.$currentPage) | composer.changedInstance(this.$coroutineScope) | composer.changed(this.$scrollState) | composer.changed(this.$onSubmit) | composer.changed(this.$pagerState) | composer.changed(this.$lastPageIndex);
            final FocusManager focusManager = this.$focusManager;
            final SignupScreenPage signupScreenPage = this.$currentPage;
            final CoroutineScope coroutineScope = this.$coroutineScope;
            final Function0<Unit> function02 = this.$onSubmit;
            final ScrollState scrollState = this.$scrollState;
            final PagerState pagerState = this.$pagerState;
            final int i6 = this.$lastPageIndex;
            Object rememberedValue2 = composer.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.authentication.register.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$3$lambda$2;
                        invoke$lambda$3$lambda$2 = SignupScreenKt$SignupContainer$2.invoke$lambda$3$lambda$2(FocusManager.this, signupScreenPage, coroutineScope, function02, scrollState, pagerState, i6);
                        return invoke$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(stringResource, null, SignupContainer$lambda$3, false, false, 0L, function0, (Function0) rememberedValue2, composer, 0, 58);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
