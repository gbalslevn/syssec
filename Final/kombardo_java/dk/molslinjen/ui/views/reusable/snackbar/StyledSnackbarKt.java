package dk.molslinjen.ui.views.reusable.snackbar;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.snackbar.SnackbarStyle;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.views.reusable.snackbar.StyledSnackbarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aO\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {BuildConfig.FLAVOR, "message", "actionLabel", "Lkotlin/Function0;", BuildConfig.FLAVOR, "performAction", "dismiss", BuildConfig.FLAVOR, "showDismiss", "Ldk/molslinjen/core/snackbar/SnackbarStyle;", "snackbarStyle", "StyledSnackbar", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLdk/molslinjen/core/snackbar/SnackbarStyle;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StyledSnackbarKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void StyledSnackbar(final String message, String str, final Function0<Unit> performAction, final Function0<Unit> dismiss, final boolean z5, final SnackbarStyle snackbarStyle, Composer composer, final int i5, final int i6) {
        int i7;
        String str2;
        Object rememberedValue;
        Composer composer2;
        final String str3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(performAction, "performAction");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Intrinsics.checkNotNullParameter(snackbarStyle, "snackbarStyle");
        Composer startRestartGroup = composer.startRestartGroup(469621522);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(message) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            str2 = str;
            i7 |= startRestartGroup.changed(str2) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changedInstance(performAction) ? 256 : 128;
            }
            if ((i6 & 8) == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i7 |= startRestartGroup.changedInstance(dismiss) ? 2048 : 1024;
            }
            if ((i6 & 16) == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changed(z5) ? 16384 : 8192;
            }
            if ((i6 & 32) == 0) {
                i7 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i7 |= startRestartGroup.changed(snackbarStyle) ? 131072 : 65536;
            }
            if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                String str4 = i8 == 0 ? null : str2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(469621522, i7, -1, "dk.molslinjen.ui.views.reusable.snackbar.StyledSnackbar (StyledSnackbar.kt:40)");
                }
                CornerBasedShape medium = ThemeShapesKt.getThemeShapes().getMedium();
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(ZIndexModifierKt.zIndex(Modifier.INSTANCE, 2.0f), Dp.m2599constructorimpl(16));
                startRestartGroup.startReplaceGroup(576014277);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function1() { // from class: k2.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit StyledSnackbar$lambda$1$lambda$0;
                            StyledSnackbar$lambda$1$lambda$0 = StyledSnackbarKt.StyledSnackbar$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                            return StyledSnackbar$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                SurfaceKt.m900SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(m311padding3ABfNKs, false, (Function1) rememberedValue, 1, null), medium, 0L, 0L, 0.0f, Dp.m2599constructorimpl(6), null, ComposableLambdaKt.rememberComposableLambda(-45810579, true, new StyledSnackbarKt$StyledSnackbar$2(snackbarStyle, medium, message, str4, performAction, dismiss, z5), startRestartGroup, 54), composer2, 12779520, 92);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str3 = str4;
            } else {
                startRestartGroup.skipToGroupEnd();
                str3 = str2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: k2.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit StyledSnackbar$lambda$2;
                        StyledSnackbar$lambda$2 = StyledSnackbarKt.StyledSnackbar$lambda$2(message, str3, performAction, dismiss, z5, snackbarStyle, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return StyledSnackbar$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        str2 = str;
        if ((i6 & 4) == 0) {
        }
        if ((i6 & 8) == 0) {
        }
        if ((i6 & 16) == 0) {
        }
        if ((i6 & 32) == 0) {
        }
        if ((74899 & i7) == 74898) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        CornerBasedShape medium2 = ThemeShapesKt.getThemeShapes().getMedium();
        Modifier m311padding3ABfNKs2 = PaddingKt.m311padding3ABfNKs(ZIndexModifierKt.zIndex(Modifier.INSTANCE, 2.0f), Dp.m2599constructorimpl(16));
        startRestartGroup.startReplaceGroup(576014277);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        composer2 = startRestartGroup;
        SurfaceKt.m900SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(m311padding3ABfNKs2, false, (Function1) rememberedValue, 1, null), medium2, 0L, 0L, 0.0f, Dp.m2599constructorimpl(6), null, ComposableLambdaKt.rememberComposableLambda(-45810579, true, new StyledSnackbarKt$StyledSnackbar$2(snackbarStyle, medium2, message, str4, performAction, dismiss, z5), startRestartGroup, 54), composer2, 12779520, 92);
        if (ComposerKt.isTraceInProgress()) {
        }
        str3 = str4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyledSnackbar$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2161getAssertive0phEisY());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyledSnackbar$lambda$2(String str, String str2, Function0 function0, Function0 function02, boolean z5, SnackbarStyle snackbarStyle, int i5, int i6, Composer composer, int i7) {
        StyledSnackbar(str, str2, function0, function02, z5, snackbarStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
