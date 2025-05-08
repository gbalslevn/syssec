package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.input.StyledSwitchKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a-\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {BuildConfig.FLAVOR, "checked", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onCheckedChange", "StyledSwitch", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StyledSwitchKt {
    public static final void StyledSwitch(final boolean z5, final Function1<? super Boolean, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(929567950);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(z5) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(929567950, i6, -1, "dk.molslinjen.ui.views.reusable.input.StyledSwitch (StyledSwitch.kt:8)");
            }
            SwitchDefaults switchDefaults = SwitchDefaults.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            composer2 = startRestartGroup;
            SwitchKt.Switch(z5, function1, null, null, false, switchDefaults.m912colorsV1nXRL4(appColor.m3281getWhite0d7_KjU(), appColor.m3255getBrandBlue10d7_KjU(), appColor.m3255getBrandBlue10d7_KjU(), 0L, appColor.m3281getWhite0d7_KjU(), appColor.m3267getGrey40d7_KjU(), appColor.m3267getGrey40d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 1794486, SwitchDefaults.$stable << 18, 65416), null, startRestartGroup, i6 & 126, 92);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: c2.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit StyledSwitch$lambda$0;
                    StyledSwitch$lambda$0 = StyledSwitchKt.StyledSwitch$lambda$0(z5, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return StyledSwitch$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyledSwitch$lambda$0(boolean z5, Function1 function1, int i5, Composer composer, int i6) {
        StyledSwitch(z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
