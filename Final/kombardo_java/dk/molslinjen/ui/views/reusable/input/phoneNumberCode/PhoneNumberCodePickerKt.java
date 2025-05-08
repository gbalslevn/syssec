package dk.molslinjen.ui.views.reusable.input.phoneNumberCode;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.extensions.domain.PhoneNumberExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.input.TextBoxKt;
import dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodePickerKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aI\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showSelectionScreen", BuildConfig.FLAVOR, "inputEnabled", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "PhoneNumberCodePicker", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/shared/PhoneNumber;Lkotlin/jvm/functions/Function0;ZLdk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PhoneNumberCodePickerKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PhoneNumberCodePicker(Modifier modifier, final PhoneNumber phoneNumber, final Function0<Unit> showSelectionScreen, boolean z5, final IFormValidator.ValidationKey validationKey, final IFormValidator validator, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        boolean z6;
        Modifier modifier3;
        boolean changedInstance;
        Object rememberedValue;
        Integer countryCodeFlag;
        ComposableLambda rememberComposableLambda;
        Composer composer2;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(showSelectionScreen, "showSelectionScreen");
        Intrinsics.checkNotNullParameter(validationKey, "validationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Composer startRestartGroup = composer.startRestartGroup(-2051900266);
        int i8 = i6 & 1;
        if (i8 != 0) {
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
            i7 |= startRestartGroup.changedInstance(phoneNumber) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(showSelectionScreen) ? 256 : 128;
        }
        int i9 = i6 & 8;
        if (i9 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
            if ((i6 & 16) == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= (i5 & 32768) == 0 ? startRestartGroup.changed(validationKey) : startRestartGroup.changedInstance(validationKey) ? 16384 : 8192;
            }
            if ((i6 & 32) == 0) {
                i7 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i7 |= (i5 & 262144) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 131072 : 65536;
            }
            if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                modifier3 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                boolean z8 = i9 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2051900266, i7, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodePicker (PhoneNumberCodePicker.kt:26)");
                }
                String countryCode = phoneNumber.getCountryCode();
                startRestartGroup.startReplaceGroup(-936679703);
                changedInstance = ((i7 & 458752) != 131072 || ((i7 & 262144) != 0 && startRestartGroup.changedInstance(validator))) | ((i7 & 57344) != 16384 || ((32768 & i7) != 0 && startRestartGroup.changedInstance(validationKey))) | startRestartGroup.changedInstance(phoneNumber);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new PhoneNumberCodePickerKt$PhoneNumberCodePicker$1$1(validator, validationKey, phoneNumber, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(countryCode, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
                String countryCode2 = phoneNumber.getCountryCode();
                long m3253getBrandBlack10d7_KjU = AppColor.INSTANCE.m3253getBrandBlack10d7_KjU();
                countryCodeFlag = PhoneNumberExtensionsKt.getCountryCodeFlag(phoneNumber);
                startRestartGroup.startReplaceGroup(-936669113);
                if (countryCodeFlag != null) {
                    rememberComposableLambda = null;
                } else {
                    final int intValue = countryCodeFlag.intValue();
                    rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(542469105, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodePickerKt$PhoneNumberCodePicker$2$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i10) {
                            if ((i10 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(542469105, i10, -1, "dk.molslinjen.ui.views.reusable.input.phoneNumberCode.PhoneNumberCodePicker.<anonymous>.<anonymous> (PhoneNumberCodePicker.kt:39)");
                            }
                            ImageKt.Image(PainterResources_androidKt.painterResource(intValue, composer3, 0), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, composer3, 0, 124);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                TextBoxKt.m3414TextBoxNpQZenA(modifier3, countryCode2, null, null, z8, showSelectionScreen, false, false, 0L, m3253getBrandBlack10d7_KjU, 0L, rememberComposableLambda, null, composer2, (i7 & 14) | 805306368 | ((i7 << 3) & 57344) | ((i7 << 9) & 458752), 0, 5580);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z7 = z8;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = startRestartGroup;
                z7 = z6;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier4 = modifier3;
                endRestartGroup.updateScope(new Function2() { // from class: h2.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit PhoneNumberCodePicker$lambda$2;
                        PhoneNumberCodePicker$lambda$2 = PhoneNumberCodePickerKt.PhoneNumberCodePicker$lambda$2(Modifier.this, phoneNumber, showSelectionScreen, z7, validationKey, validator, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return PhoneNumberCodePicker$lambda$2;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((i6 & 16) == 0) {
        }
        if ((i6 & 32) == 0) {
        }
        if ((74899 & i7) == 74898) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        String countryCode3 = phoneNumber.getCountryCode();
        startRestartGroup.startReplaceGroup(-936679703);
        changedInstance = ((i7 & 458752) != 131072 || ((i7 & 262144) != 0 && startRestartGroup.changedInstance(validator))) | ((i7 & 57344) != 16384 || ((32768 & i7) != 0 && startRestartGroup.changedInstance(validationKey))) | startRestartGroup.changedInstance(phoneNumber);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new PhoneNumberCodePickerKt$PhoneNumberCodePicker$1$1(validator, validationKey, phoneNumber, null);
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        EffectsKt.LaunchedEffect(countryCode3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
        String countryCode22 = phoneNumber.getCountryCode();
        long m3253getBrandBlack10d7_KjU2 = AppColor.INSTANCE.m3253getBrandBlack10d7_KjU();
        countryCodeFlag = PhoneNumberExtensionsKt.getCountryCodeFlag(phoneNumber);
        startRestartGroup.startReplaceGroup(-936669113);
        if (countryCodeFlag != null) {
        }
        startRestartGroup.endReplaceGroup();
        composer2 = startRestartGroup;
        TextBoxKt.m3414TextBoxNpQZenA(modifier3, countryCode22, null, null, z8, showSelectionScreen, false, false, 0L, m3253getBrandBlack10d7_KjU2, 0L, rememberComposableLambda, null, composer2, (i7 & 14) | 805306368 | ((i7 << 3) & 57344) | ((i7 << 9) & 458752), 0, 5580);
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z8;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PhoneNumberCodePicker$lambda$2(Modifier modifier, PhoneNumber phoneNumber, Function0 function0, boolean z5, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, int i5, int i6, Composer composer, int i7) {
        PhoneNumberCodePicker(modifier, phoneNumber, function0, z5, validationKey, iFormValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
