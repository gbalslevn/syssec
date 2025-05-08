package dk.molslinjen.ui.views.screens.profile.shared;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountActivationPendingCardKt;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountCardData;
import dk.molslinjen.ui.views.screens.profile.shared.accountCard.AccountSignupCardKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ AccountCardData $accountCardData;
    final /* synthetic */ Function0<Unit> $onSignup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1(AccountCardData accountCardData, Function0<Unit> function0) {
        this.$accountCardData = accountCardData;
        this.$onSignup = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2001337579, i5, -1, "dk.molslinjen.ui.views.screens.profile.shared.ProfileAssetsListContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProfileAssetsContainer.kt:63)");
        }
        Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(24), 0.0f, 2, null);
        AccountCardData accountCardData = this.$accountCardData;
        if (accountCardData instanceof AccountCardData.Signup) {
            composer.startReplaceGroup(1927643172);
            AccountCardData.Signup signup = (AccountCardData.Signup) this.$accountCardData;
            composer.startReplaceGroup(1927648039);
            boolean changed = composer.changed(this.$onSignup);
            final Function0<Unit> function0 = this.$onSignup;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.profile.shared.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$1$lambda$0;
                        invoke$lambda$1$lambda$0 = ProfileAssetsContainerKt$ProfileAssetsListContainer$1$1$1$1$1.invoke$lambda$1$lambda$0(Function0.this);
                        return invoke$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            AccountSignupCardKt.AccountSignupCard(m313paddingVpY3zN4$default, signup, (Function0) rememberedValue, composer, 6, 0);
            composer.endReplaceGroup();
        } else if (accountCardData instanceof AccountCardData.ActivationPending) {
            composer.startReplaceGroup(1927651128);
            AccountActivationPendingCardKt.AccountActivationPendingCard(m313paddingVpY3zN4$default, (AccountCardData.ActivationPending) this.$accountCardData, null, composer, 6, 4);
            composer.endReplaceGroup();
        } else {
            if (accountCardData != null) {
                composer.startReplaceGroup(1927640932);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(-372159921);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
