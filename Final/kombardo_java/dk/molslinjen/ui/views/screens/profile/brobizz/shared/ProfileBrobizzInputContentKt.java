package dk.molslinjen.ui.views.screens.profile.brobizz.shared;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.transformations.AddSpacesVisualTransformation;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.BrobizzInputFormField;
import dk.molslinjen.ui.views.screens.profile.brobizz.shared.ProfileBrobizzInputContentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\n\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScope;", BuildConfig.FLAVOR, "input", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onValueChange", BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "ProfileBrobizzInputContent", "(Landroidx/compose/foundation/layout/ColumnScope;Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLdk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileBrobizzInputContentKt {
    public static final void ProfileBrobizzInputContent(final ColumnScope columnScope, final String input, final Function1<? super String, Unit> onValueChange, final boolean z5, final IFormValidator validator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Composer startRestartGroup = composer.startRestartGroup(1608237038);
        if ((i5 & 48) == 0) {
            i6 = (startRestartGroup.changed(input) ? 32 : 16) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onValueChange) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= (32768 & i5) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 16384 : 8192;
        }
        if ((i6 & 9361) == 9360 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1608237038, i6, -1, "dk.molslinjen.ui.views.screens.profile.brobizz.shared.ProfileBrobizzInputContent (ProfileBrobizzInputContent.kt:26)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(24), 0.0f, 2, null);
            boolean z6 = !z5;
            AddSpacesVisualTransformation addSpacesVisualTransformation = new AddSpacesVisualTransformation(4);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, KeyboardType.INSTANCE.m2417getNumberPjHm6EE(), ImeAction.INSTANCE.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 113, (DefaultConstructorMarker) null);
            BrobizzInputFormField brobizzInputFormField = BrobizzInputFormField.BrobizzNumber;
            List emptyList = CollectionsKt.emptyList();
            Integer valueOf = Integer.valueOf(R.string.profile_brobizz_register_label);
            Integer valueOf2 = Integer.valueOf(R.string.profile_brobizz_register_placehodler);
            startRestartGroup.startReplaceGroup(-639780492);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: F3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileBrobizzInputContent$lambda$1$lambda$0;
                        ProfileBrobizzInputContent$lambda$1$lambda$0 = ProfileBrobizzInputContentKt.ProfileBrobizzInputContent$lambda$1$lambda$0(FocusManager.this);
                        return ProfileBrobizzInputContent$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m313paddingVpY3zN4$default, false, 0.0f, emptyList, valueOf, valueOf2, null, onValueChange, (Function0) rememberedValue, input, false, addSpacesVisualTransformation, z6, false, 0, brobizzInputFormField, validator, keyboardOptions, null, null, 0L, null, false, 0, composer2, ((i6 << 15) & 29360128) | 224262 | ((i6 << 24) & 1879048192), ((i6 << 6) & 3670016) | 12779520, 0, 16540742);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: F3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileBrobizzInputContent$lambda$2;
                    ProfileBrobizzInputContent$lambda$2 = ProfileBrobizzInputContentKt.ProfileBrobizzInputContent$lambda$2(ColumnScope.this, input, onValueChange, z5, validator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileBrobizzInputContent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzInputContent$lambda$1$lambda$0(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzInputContent$lambda$2(ColumnScope columnScope, String str, Function1 function1, boolean z5, IFormValidator iFormValidator, int i5, Composer composer, int i6) {
        ProfileBrobizzInputContent(columnScope, str, function1, z5, iFormValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
