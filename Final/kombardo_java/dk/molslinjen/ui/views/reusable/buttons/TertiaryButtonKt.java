package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import dk.molslinjen.ui.views.reusable.buttons.ButtonStyle;
import dk.molslinjen.ui.views.reusable.buttons.TertiaryButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a_\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "text", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "leftContent", "rightContent", "TertiaryButton", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TertiaryButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TertiaryButton(Modifier modifier, final String text, final Function0<Unit> onClick, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        int i8;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        int i9;
        Composer composer2;
        final Modifier modifier3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function35;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function36;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(806117460);
        int i10 = i6 & 1;
        if (i10 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i11 = i6 & 8;
        if (i11 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            function33 = function3;
            i7 |= startRestartGroup.changedInstance(function33) ? 2048 : 1024;
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                function34 = function32;
                i7 |= startRestartGroup.changedInstance(function34) ? 16384 : 8192;
                i9 = i7;
                if ((i9 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    Modifier modifier4 = i10 != 0 ? Modifier.INSTANCE : modifier2;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function37 = i11 != 0 ? null : function33;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function38 = i8 != 0 ? null : function34;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(806117460, i9, -1, "dk.molslinjen.ui.views.reusable.buttons.TertiaryButton (TertiaryButton.kt:14)");
                    }
                    composer2 = startRestartGroup;
                    BaseButtonKt.BaseButton(modifier4, text, onClick, null, ButtonStyle.Tertiary.INSTANCE, ButtonConfig.Small, false, false, null, null, function37, function38, false, false, composer2, (i9 & 14) | 224256 | (i9 & 112) | (i9 & 896), (i9 >> 9) & 126, 13248);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function35 = function37;
                    function36 = function38;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    function35 = function33;
                    function36 = function34;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: Z1.m
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TertiaryButton$lambda$0;
                            TertiaryButton$lambda$0 = TertiaryButtonKt.TertiaryButton$lambda$0(Modifier.this, text, onClick, function35, function36, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return TertiaryButton$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            function34 = function32;
            i9 = i7;
            if ((i9 & 9363) == 9362) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            BaseButtonKt.BaseButton(modifier4, text, onClick, null, ButtonStyle.Tertiary.INSTANCE, ButtonConfig.Small, false, false, null, null, function37, function38, false, false, composer2, (i9 & 14) | 224256 | (i9 & 112) | (i9 & 896), (i9 >> 9) & 126, 13248);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4;
            function35 = function37;
            function36 = function38;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function33 = function3;
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        function34 = function32;
        i9 = i7;
        if ((i9 & 9363) == 9362) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        BaseButtonKt.BaseButton(modifier4, text, onClick, null, ButtonStyle.Tertiary.INSTANCE, ButtonConfig.Small, false, false, null, null, function37, function38, false, false, composer2, (i9 & 14) | 224256 | (i9 & 112) | (i9 & 896), (i9 >> 9) & 126, 13248);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        function35 = function37;
        function36 = function38;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TertiaryButton$lambda$0(Modifier modifier, String str, Function0 function0, Function3 function3, Function3 function32, int i5, int i6, Composer composer, int i7) {
        TertiaryButton(modifier, str, function0, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
