package dk.molslinjen.ui.views.reusable.input.phoneNumberCode;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$PhoneNumberCodeSelectionScreenKt {
    public static final ComposableSingletons$PhoneNumberCodeSelectionScreenKt INSTANCE = new ComposableSingletons$PhoneNumberCodeSelectionScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f156lambda1 = ComposableLambdaKt.composableLambdaInstance(1310998576, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.ComposableSingletons$PhoneNumberCodeSelectionScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(1310998576, i5, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.ComposableSingletons$PhoneNumberCodeSelectionScreenKt.lambda-1.<anonymous> (PhoneNumberCodeSelectionScreen.kt:67)");
            }
            PhoneNumberCodeSelectionScreenKt.access$PhoneNumberCodeHeader(R.string.phoneNumberCodeSelection_frequentlyUsed, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f157lambda2 = ComposableLambdaKt.composableLambdaInstance(2071784423, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.ComposableSingletons$PhoneNumberCodeSelectionScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(2071784423, i5, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.ComposableSingletons$PhoneNumberCodeSelectionScreenKt.lambda-2.<anonymous> (PhoneNumberCodeSelectionScreen.kt:78)");
            }
            PhoneNumberCodeSelectionScreenKt.access$PhoneNumberCodeHeader(R.string.phoneNumberCodeSelection_all, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3421getLambda1$app_kombardoProd() {
        return f156lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3422getLambda2$app_kombardoProd() {
        return f157lambda2;
    }
}
