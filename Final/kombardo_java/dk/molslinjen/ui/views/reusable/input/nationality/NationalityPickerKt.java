package dk.molslinjen.ui.views.reusable.input.nationality;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.LocaleExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.input.TextBoxKt;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalityPickerKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aM\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ljava/util/Locale;", "nationality", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showSelectionScreen", "clearSelection", BuildConfig.FLAVOR, "inputEnabled", "NationalityPicker", "(Landroidx/compose/ui/Modifier;Ljava/util/Locale;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NationalityPickerKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NationalityPicker(Modifier modifier, final Locale locale, final Function0<Unit> showSelectionScreen, Function0<Unit> function0, boolean z5, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Function0<Unit> function02;
        int i8;
        boolean z6;
        final Function0<Unit> function03;
        boolean z7;
        long m3264getGrey10d7_KjU;
        String stringResource;
        Integer flag;
        ComposableLambda rememberComposableLambda;
        Composer composer2;
        final Function0<Unit> function04;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(showSelectionScreen, "showSelectionScreen");
        Composer startRestartGroup = composer.startRestartGroup(-1172716728);
        int i9 = i6 & 1;
        if (i9 != 0) {
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
            i7 |= startRestartGroup.changedInstance(locale) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(showSelectionScreen) ? 256 : 128;
        }
        int i10 = i6 & 8;
        if (i10 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                z6 = z5;
                i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    Modifier modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier2;
                    function03 = i10 != 0 ? null : function02;
                    z7 = i8 != 0 ? true : z6;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1172716728, i7, -1, "dk.molslinjen.ui.views.reusable.input.nationality.NationalityPicker (NationalityPicker.kt:24)");
                    }
                    boolean z8 = locale == null && function03 != null && z7;
                    startRestartGroup.startReplaceGroup(-694058349);
                    if (locale != null) {
                        m3264getGrey10d7_KjU = AppColor.INSTANCE.m3253getBrandBlack10d7_KjU();
                        stringResource = locale.getDisplayCountry();
                    } else {
                        m3264getGrey10d7_KjU = AppColor.INSTANCE.m3264getGrey10d7_KjU();
                        stringResource = StringResources_androidKt.stringResource(R.string.common_noneSelected, startRestartGroup, 6);
                    }
                    long j5 = m3264getGrey10d7_KjU;
                    String str = stringResource;
                    startRestartGroup.endReplaceGroup();
                    String stringResource2 = StringResources_androidKt.stringResource(R.string.textField_label_nationality, startRestartGroup, 6);
                    flag = locale != null ? LocaleExtensionsKt.getFlag(locale) : null;
                    startRestartGroup.startReplaceGroup(-694041705);
                    if (flag == null) {
                        rememberComposableLambda = null;
                    } else {
                        final int intValue = flag.intValue();
                        rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1900631196, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.nationality.NationalityPickerKt$NationalityPicker$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i11) {
                                if ((i11 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1900631196, i11, -1, "dk.molslinjen.ui.views.reusable.input.nationality.NationalityPicker.<anonymous>.<anonymous> (NationalityPicker.kt:47)");
                                }
                                ImageKt.Image(PainterResources_androidKt.painterResource(intValue, composer3, 0), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, composer3, 0, 124);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54);
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-694033662);
                    if (function03 != null) {
                        startRestartGroup.startReplaceGroup(-694033114);
                        r4 = z8 ? ComposableLambdaKt.rememberComposableLambda(1399701141, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.nationality.NationalityPickerKt$NationalityPicker$2$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i11) {
                                if ((i11 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1399701141, i11, -1, "dk.molslinjen.ui.views.reusable.input.nationality.NationalityPicker.<anonymous>.<anonymous> (NationalityPicker.kt:56)");
                                }
                                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_close, composer3, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_remove, composer3, 6), ClickableKt.m122clickableXHw0xAI$default(Modifier.INSTANCE, false, null, null, function03, 7, null), null, null, 0.0f, null, composer3, 0, 120);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54) : null;
                        startRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambda = r4;
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                    Function0<Unit> function05 = function03;
                    TextBoxKt.m3414TextBoxNpQZenA(modifier3, str, stringResource2, null, z7, showSelectionScreen, false, false, 0L, j5, 0L, rememberComposableLambda, composableLambda, composer2, (57358 & i7) | ((i7 << 9) & 458752), 0, 1480);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    function04 = function05;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    function04 = function02;
                    z7 = z6;
                    composer2 = startRestartGroup;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final boolean z9 = z7;
                    endRestartGroup.updateScope(new Function2() { // from class: g2.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit NationalityPicker$lambda$2;
                            NationalityPicker$lambda$2 = NationalityPickerKt.NationalityPicker$lambda$2(Modifier.this, locale, showSelectionScreen, function04, z9, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                            return NationalityPicker$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            z6 = z5;
            if ((i7 & 9363) == 9362) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (locale == null) {
            }
            startRestartGroup.startReplaceGroup(-694058349);
            if (locale != null) {
            }
            long j52 = m3264getGrey10d7_KjU;
            String str2 = stringResource;
            startRestartGroup.endReplaceGroup();
            String stringResource22 = StringResources_androidKt.stringResource(R.string.textField_label_nationality, startRestartGroup, 6);
            if (locale != null) {
            }
            startRestartGroup.startReplaceGroup(-694041705);
            if (flag == null) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-694033662);
            if (function03 != null) {
            }
            ComposableLambda composableLambda2 = r4;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            Function0<Unit> function052 = function03;
            TextBoxKt.m3414TextBoxNpQZenA(modifier3, str2, stringResource22, null, z7, showSelectionScreen, false, false, 0L, j52, 0L, rememberComposableLambda, composableLambda2, composer2, (57358 & i7) | ((i7 << 9) & 458752), 0, 1480);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            function04 = function052;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function02 = function0;
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        z6 = z5;
        if ((i7 & 9363) == 9362) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (locale == null) {
        }
        startRestartGroup.startReplaceGroup(-694058349);
        if (locale != null) {
        }
        long j522 = m3264getGrey10d7_KjU;
        String str22 = stringResource;
        startRestartGroup.endReplaceGroup();
        String stringResource222 = StringResources_androidKt.stringResource(R.string.textField_label_nationality, startRestartGroup, 6);
        if (locale != null) {
        }
        startRestartGroup.startReplaceGroup(-694041705);
        if (flag == null) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-694033662);
        if (function03 != null) {
        }
        ComposableLambda composableLambda22 = r4;
        startRestartGroup.endReplaceGroup();
        composer2 = startRestartGroup;
        Function0<Unit> function0522 = function03;
        TextBoxKt.m3414TextBoxNpQZenA(modifier3, str22, stringResource222, null, z7, showSelectionScreen, false, false, 0L, j522, 0L, rememberComposableLambda, composableLambda22, composer2, (57358 & i7) | ((i7 << 9) & 458752), 0, 1480);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        function04 = function0522;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NationalityPicker$lambda$2(Modifier modifier, Locale locale, Function0 function0, Function0 function02, boolean z5, int i5, int i6, Composer composer, int i7) {
        NationalityPicker(modifier, locale, function0, function02, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
