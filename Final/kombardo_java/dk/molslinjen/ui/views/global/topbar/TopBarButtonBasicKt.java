package dk.molslinjen.ui.views.global.topbar;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.views.global.topbar.TopBarButtonBasicKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a5\u0010\u0006\u001a\u00020\u00042\b\b\u0001\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {BuildConfig.FLAVOR, "iconRes", "contentDescriptionRes", "Lkotlin/Function0;", BuildConfig.FLAVOR, "action", "TopBarButtonBasic", "(ILjava/lang/Integer;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TopBarButtonBasicKt {
    public static final void TopBarButtonBasic(final int i5, final Integer num, final Function0<Unit> function0, Composer composer, final int i6, final int i7) {
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-488246929);
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
            i8 |= startRestartGroup.changed(num) ? 32 : 16;
        }
        int i9 = i7 & 4;
        if (i9 != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i9 != 0) {
                function0 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-488246929, i8, -1, "dk.molslinjen.ui.views.global.topbar.TopBarButtonBasic (TopBarButtonBasic.kt:21)");
            }
            startRestartGroup.startReplaceGroup(-1470975249);
            boolean z5 = (i8 & 896) == 256;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: V1.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit TopBarButtonBasic$lambda$1$lambda$0;
                        TopBarButtonBasic$lambda$1$lambda$0 = TopBarButtonBasicKt.TopBarButtonBasic$lambda$1$lambda$0(Function0.this);
                        return TopBarButtonBasic$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function02 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            IconButtonKt.IconButton(function02, null, function0 != null, null, null, ComposableLambdaKt.rememberComposableLambda(-1634490612, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.global.topbar.TopBarButtonBasicKt$TopBarButtonBasic$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                    invoke(composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1634490612, i10, -1, "dk.molslinjen.ui.views.global.topbar.TopBarButtonBasic.<anonymous> (TopBarButtonBasic.kt:26)");
                    }
                    Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24));
                    Painter painterResource = PainterResources_androidKt.painterResource(i5, composer2, 0);
                    Integer num2 = num;
                    composer2.startReplaceGroup(1232253268);
                    String stringResource = num2 == null ? null : StringResources_androidKt.stringResource(num2.intValue(), composer2, 0);
                    composer2.endReplaceGroup();
                    IconKt.m857Iconww6aTOc(painterResource, stringResource, m331size3ABfNKs, Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer2, 3456, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 196608, 26);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Function0<Unit> function03 = function0;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V1.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TopBarButtonBasic$lambda$2;
                    TopBarButtonBasic$lambda$2 = TopBarButtonBasicKt.TopBarButtonBasic$lambda$2(i5, num, function03, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                    return TopBarButtonBasic$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarButtonBasic$lambda$1$lambda$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TopBarButtonBasic$lambda$2(int i5, Integer num, Function0 function0, int i6, int i7, Composer composer, int i8) {
        TopBarButtonBasic(i5, num, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
