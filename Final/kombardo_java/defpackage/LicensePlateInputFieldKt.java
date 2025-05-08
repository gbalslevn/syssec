package defpackage;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aQ\u0010\r\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {BuildConfig.FLAVOR, "input", BuildConfig.FLAVOR, "enabled", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onValueChange", "Lkotlin/Function0;", "onImeKeyAction", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "LicensePlateInputField", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LicensePlateInputFieldKt {
    public static final void LicensePlateInputField(final String input, final boolean z5, final Function1<? super String, Unit> onValueChange, final Function0<Unit> onImeKeyAction, final IFormValidator.ValidationKey validationKey, final IFormValidator validator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(onImeKeyAction, "onImeKeyAction");
        Intrinsics.checkNotNullParameter(validationKey, "validationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Composer startRestartGroup = composer.startRestartGroup(-583443919);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(input) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onValueChange) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onImeKeyAction) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= (32768 & i5) == 0 ? startRestartGroup.changed(validationKey) : startRestartGroup.changedInstance(validationKey) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= (262144 & i5) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-583443919, i6, -1, "LicensePlateInputField (LicensePlateInputField.kt:26)");
            }
            int i7 = i6 << 15;
            int i8 = (i7 & 234881024) | (29360128 & i7) | 224256 | ((i6 << 27) & 1879048192);
            int i9 = i6 << 3;
            composer2 = startRestartGroup;
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, CollectionsKt.emptyList(), Integer.valueOf(R.string.textField_label_licensePlate), Integer.valueOf(R.string.profile_vehicle_register_licensePlate_placeholder), null, onValueChange, onImeKeyAction, input, false, null, z5, false, 0, validationKey, validator, new KeyboardOptions(KeyboardCapitalization.INSTANCE.m2402getCharactersIUNYP9k(), (Boolean) null, 0, ImeAction.INSTANCE.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null), null, ComposableSingletons$LicensePlateInputFieldKt.INSTANCE.m0getLambda1$app_kombardoProd(), 0L, null, false, 0, composer2, i8, (i9 & 896) | 805306368 | (458752 & i9) | (i9 & 3670016), 0, 16018503);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LicensePlateInputField$lambda$0;
                    LicensePlateInputField$lambda$0 = LicensePlateInputFieldKt.LicensePlateInputField$lambda$0(input, z5, onValueChange, onImeKeyAction, validationKey, validator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return LicensePlateInputField$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LicensePlateInputField$lambda$0(String str, boolean z5, Function1 function1, Function0 function0, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, int i5, Composer composer, int i6) {
        LicensePlateInputField(str, z5, function1, function0, validationKey, iFormValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
