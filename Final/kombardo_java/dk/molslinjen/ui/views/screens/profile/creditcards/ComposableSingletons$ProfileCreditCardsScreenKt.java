package dk.molslinjen.ui.views.screens.profile.creditcards;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$ProfileCreditCardsScreenKt {
    public static final ComposableSingletons$ProfileCreditCardsScreenKt INSTANCE = new ComposableSingletons$ProfileCreditCardsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f211lambda1 = ComposableLambdaKt.composableLambdaInstance(1514267505, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.creditcards.ComposableSingletons$ProfileCreditCardsScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(1514267505, i5, -1, "dk.molslinjen.ui.views.screens.profile.creditcards.ComposableSingletons$ProfileCreditCardsScreenKt.lambda-1.<anonymous> (ProfileCreditCardsScreen.kt:85)");
            }
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_creditCard_description, composer, 6), PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 432, 1572864, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f212lambda2 = ComposableLambdaKt.composableLambdaInstance(-1584948824, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.creditcards.ComposableSingletons$ProfileCreditCardsScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(-1584948824, i5, -1, "dk.molslinjen.ui.views.screens.profile.creditcards.ComposableSingletons$ProfileCreditCardsScreenKt.lambda-2.<anonymous> (ProfileCreditCardsScreen.kt:93)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3504getLambda1$app_kombardoProd() {
        return f211lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3505getLambda2$app_kombardoProd() {
        return f212lambda2;
    }
}
