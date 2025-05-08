package dk.molslinjen.ui.views.screens.profile;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import dk.molslinjen.ui.views.reusable.input.SwitchRowKt;
import dk.molslinjen.ui.views.screens.profile.ProfileDeveloperMenuRowKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a5\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "shouldShowDeveloperMenu", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onCheckChange", "ProfileDeveloperMenuRow", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileDeveloperMenuRowKt {
    public static final void ProfileDeveloperMenuRow(Modifier modifier, final boolean z5, final Function1<? super Boolean, Unit> onCheckChange, Composer composer, final int i5, final int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(onCheckChange, "onCheckChange");
        Composer startRestartGroup = composer.startRestartGroup(888124994);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onCheckChange) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(888124994, i7, -1, "dk.molslinjen.ui.views.screens.profile.ProfileDeveloperMenuRow (ProfileDeveloperMenuRow.kt:9)");
            }
            String upperCase = "Show developer menu".toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            int i9 = i7 & 14;
            int i10 = i7 << 3;
            SwitchRowKt.SwitchRow(modifier, upperCase, z5, onCheckChange, startRestartGroup, i9 | (i10 & 896) | (i10 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: v3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileDeveloperMenuRow$lambda$0;
                    ProfileDeveloperMenuRow$lambda$0 = ProfileDeveloperMenuRowKt.ProfileDeveloperMenuRow$lambda$0(Modifier.this, z5, onCheckChange, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileDeveloperMenuRow$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileDeveloperMenuRow$lambda$0(Modifier modifier, boolean z5, Function1 function1, int i5, int i6, Composer composer, int i7) {
        ProfileDeveloperMenuRow(modifier, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
