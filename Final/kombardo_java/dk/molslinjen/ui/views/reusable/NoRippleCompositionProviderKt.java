package dk.molslinjen.ui.views.reusable;

import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.ui.views.reusable.NoRippleCompositionProviderKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "NoRippleCompositionProvider", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NoRippleCompositionProviderKt {
    public static final void NoRippleCompositionProvider(final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(710974518);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(content) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(710974518, i6, -1, "dk.molslinjen.ui.views.reusable.NoRippleCompositionProvider (NoRippleCompositionProvider.kt:9)");
            }
            CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(1591136118, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.NoRippleCompositionProviderKt$NoRippleCompositionProvider$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1591136118, i7, -1, "dk.molslinjen.ui.views.reusable.NoRippleCompositionProvider.<anonymous> (NoRippleCompositionProvider.kt:11)");
                    }
                    content.invoke(composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: W1.B
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NoRippleCompositionProvider$lambda$0;
                    NoRippleCompositionProvider$lambda$0 = NoRippleCompositionProviderKt.NoRippleCompositionProvider$lambda$0(Function2.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return NoRippleCompositionProvider$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoRippleCompositionProvider$lambda$0(Function2 function2, int i5, Composer composer, int i6) {
        NoRippleCompositionProvider(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
