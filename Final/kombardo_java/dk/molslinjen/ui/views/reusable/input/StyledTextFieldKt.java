package dk.molslinjen.ui.views.reusable.input;

import android.content.Context;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.InputValidationError;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a»\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\u0018\b\u0002\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010#\u001a\u00020\"2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)¨\u0006.²\u0006\u000e\u0010+\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010,\u001a\u00020\u00028\n@\nX\u008a\u008e\u0002²\u0006\u0010\u0010-\u001a\u0004\u0018\u00010\t8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "fillMaxWidth", "Landroidx/compose/ui/unit/Dp;", "minWidth", BuildConfig.FLAVOR, "Landroidx/compose/ui/autofill/AutofillType;", "autofillTypes", BuildConfig.FLAVOR, "label", "placeholder", BuildConfig.FLAVOR, "description", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onValueChange", "Lkotlin/Function0;", "onImeKeyAction", "input", "isPasswordField", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "enabled", "readOnly", "maxLines", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardOptions", "textPrefix", "leadingContent", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "onFocusChange", "allowShowErrorMessage", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", "StyledTextField-qgfaCVY", "(Landroidx/compose/ui/Modifier;ZFLjava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLandroidx/compose/ui/text/input/VisualTransformation;ZZILdk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/foundation/text/KeyboardOptions;Ljava/lang/String;Lkotlin/jvm/functions/Function3;JLkotlin/jvm/functions/Function1;ZILandroidx/compose/runtime/Composer;IIII)V", "StyledTextField", "textVisible", "isFocused", "textFieldHeight", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StyledTextFieldKt {
    /* JADX WARN: Code restructure failed: missing block: B:88:0x030a, code lost:
    
        if (r8.changed(r82) == false) goto L265;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0478 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0573  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0320  */
    /* renamed from: StyledTextField-qgfaCVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3412StyledTextFieldqgfaCVY(Modifier modifier, boolean z5, float f5, final List<? extends AutofillType> autofillTypes, final Integer num, Integer num2, String str, final Function1<? super String, Unit> onValueChange, final Function0<Unit> onImeKeyAction, final String input, boolean z6, VisualTransformation visualTransformation, boolean z7, boolean z8, int i5, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, KeyboardOptions keyboardOptions, String str2, Function3<? super Dp, ? super Composer, ? super Integer, Unit> function3, long j5, Function1<? super Boolean, Unit> function1, boolean z9, int i6, Composer composer, final int i7, final int i8, final int i9, final int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Modifier modifier2;
        final boolean z10;
        int i32;
        VisualTransformation visualTransformation2;
        boolean z11;
        boolean z12;
        int i33;
        boolean z13;
        Function3<? super Dp, ? super Composer, ? super Integer, Unit> function32;
        Function1<? super Boolean, Unit> function12;
        IFormValidator iFormValidator2;
        KeyboardOptions keyboardOptions2;
        boolean z14;
        String str3;
        float f6;
        String str4;
        long j6;
        IFormValidator.ValidationKey validationKey2;
        Integer num3;
        String str5;
        boolean z15;
        Object rememberedValue;
        Object rememberedValue2;
        Composer.Companion companion;
        Object rememberedValue3;
        Object rememberedValue4;
        Composer composer2;
        Integer num4;
        final VisualTransformation visualTransformation3;
        final boolean z16;
        final boolean z17;
        final int i34;
        final KeyboardOptions keyboardOptions3;
        final String str6;
        final Function3<? super Dp, ? super Composer, ? super Integer, Unit> function33;
        final long j7;
        final Function1<? super Boolean, Unit> function13;
        final boolean z18;
        final int i35;
        final IFormValidator iFormValidator3;
        final IFormValidator.ValidationKey validationKey3;
        final boolean z19;
        float f7;
        boolean z20;
        Modifier modifier3;
        Map map;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(autofillTypes, "autofillTypes");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(onImeKeyAction, "onImeKeyAction");
        Intrinsics.checkNotNullParameter(input, "input");
        Composer startRestartGroup = composer.startRestartGroup(622080500);
        int i36 = i10 & 1;
        if (i36 != 0) {
            i11 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i11 = i7 | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i11 = i7;
        }
        int i37 = i10 & 2;
        if (i37 != 0) {
            i11 |= 48;
        } else if ((i7 & 48) == 0) {
            i11 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        int i38 = i11;
        int i39 = i10 & 4;
        if (i39 != 0) {
            i38 |= 384;
        } else if ((i7 & 384) == 0) {
            i38 |= startRestartGroup.changed(f5) ? 256 : 128;
            int i40 = 2048;
            if ((i10 & 8) == 0) {
                i38 |= 3072;
            } else if ((i7 & 3072) == 0) {
                i38 |= startRestartGroup.changedInstance(autofillTypes) ? 2048 : 1024;
            }
            if ((i10 & 16) == 0) {
                i38 |= 24576;
            } else if ((i7 & 24576) == 0) {
                i38 |= startRestartGroup.changed(num) ? 16384 : 8192;
                i12 = i10 & 32;
                if (i12 != 0) {
                    i38 |= 196608;
                } else if ((i7 & 196608) == 0) {
                    i38 |= startRestartGroup.changed(num2) ? 131072 : 65536;
                }
                i13 = i10 & 64;
                if (i13 != 0) {
                    i38 |= 1572864;
                } else if ((i7 & 1572864) == 0) {
                    i38 |= startRestartGroup.changed(str) ? 1048576 : 524288;
                }
                if ((i10 & 128) != 0) {
                    i38 |= 12582912;
                } else if ((i7 & 12582912) == 0) {
                    i38 |= startRestartGroup.changedInstance(onValueChange) ? 8388608 : 4194304;
                }
                if ((i10 & 256) != 0) {
                    i38 |= 100663296;
                } else if ((i7 & 100663296) == 0) {
                    i38 |= startRestartGroup.changedInstance(onImeKeyAction) ? 67108864 : 33554432;
                }
                if ((i10 & 512) != 0) {
                    i38 |= 805306368;
                } else if ((i7 & 805306368) == 0) {
                    i38 |= startRestartGroup.changed(input) ? 536870912 : 268435456;
                }
                i14 = i38;
                i15 = i10 & 1024;
                if (i15 != 0) {
                    i16 = i8 | 6;
                } else if ((i8 & 6) == 0) {
                    i16 = i8 | (startRestartGroup.changed(z6) ? 4 : 2);
                } else {
                    i16 = i8;
                }
                i17 = i10 & 2048;
                if (i17 != 0) {
                    i16 |= 48;
                } else if ((i8 & 48) == 0) {
                    i16 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                }
                i18 = i16;
                i19 = i10 & 4096;
                if (i19 != 0) {
                    i18 |= 384;
                } else if ((i8 & 384) == 0) {
                    i18 |= startRestartGroup.changed(z7) ? 256 : 128;
                }
                i20 = i10 & 8192;
                if (i20 != 0) {
                    i18 |= 3072;
                } else if ((i8 & 3072) == 0) {
                    i18 |= startRestartGroup.changed(z8) ? 2048 : 1024;
                }
                i21 = i10 & 16384;
                if (i21 != 0) {
                    i18 |= 24576;
                } else if ((i8 & 24576) == 0) {
                    i22 = i5;
                    i18 |= startRestartGroup.changed(i22) ? 16384 : 8192;
                    i23 = i10 & 32768;
                    if (i23 == 0) {
                        i18 |= 196608;
                    } else if ((i8 & 196608) == 0) {
                        i18 |= (i8 & 262144) == 0 ? startRestartGroup.changed(validationKey) : startRestartGroup.changedInstance(validationKey) ? 131072 : 65536;
                    }
                    i24 = i10 & 65536;
                    if (i24 == 0) {
                        i18 |= 1572864;
                    } else if ((i8 & 1572864) == 0) {
                        i18 |= (i8 & 2097152) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 1048576 : 524288;
                    }
                    i25 = i10 & 131072;
                    if (i25 == 0) {
                        i18 |= 12582912;
                    } else if ((i8 & 12582912) == 0) {
                        i18 |= startRestartGroup.changed(keyboardOptions) ? 8388608 : 4194304;
                    }
                    i26 = i10 & 262144;
                    if (i26 == 0) {
                        i18 |= 100663296;
                    } else if ((i8 & 100663296) == 0) {
                        i18 |= startRestartGroup.changed(str2) ? 67108864 : 33554432;
                    }
                    i27 = i10 & 524288;
                    if (i27 == 0) {
                        i18 |= 805306368;
                    } else if ((i8 & 805306368) == 0) {
                        i18 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                    }
                    i28 = i10 & 1048576;
                    if (i28 == 0) {
                        i29 = i9 | 6;
                    } else if ((i9 & 6) == 0) {
                        i29 = i9 | (startRestartGroup.changed(j5) ? 4 : 2);
                    } else {
                        i29 = i9;
                    }
                    i30 = i10 & 2097152;
                    if (i30 == 0) {
                        i29 |= 48;
                    } else if ((i9 & 48) == 0) {
                        i29 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
                    }
                    int i41 = i29;
                    i31 = i10 & 4194304;
                    if (i31 == 0) {
                        i41 |= 384;
                    } else if ((i9 & 384) == 0) {
                        i41 |= startRestartGroup.changed(z9) ? 256 : 128;
                    }
                    if ((i9 & 3072) == 0) {
                        if ((i10 & 8388608) != 0) {
                        }
                        i40 = 1024;
                        i41 |= i40;
                    }
                    if ((i14 & 306783379) != 306783378 && (306783379 & i18) == 306783378 && (i41 & 1171) == 1170 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        z20 = z5;
                        f7 = f5;
                        str4 = str;
                        z19 = z6;
                        visualTransformation3 = visualTransformation;
                        z16 = z7;
                        validationKey3 = validationKey;
                        iFormValidator3 = iFormValidator;
                        keyboardOptions3 = keyboardOptions;
                        str6 = str2;
                        function33 = function3;
                        j7 = j5;
                        function13 = function1;
                        z18 = z9;
                        i35 = i6;
                        composer2 = startRestartGroup;
                        i34 = i22;
                        num4 = num2;
                        z17 = z8;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i7 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            modifier2 = i36 == 0 ? Modifier.INSTANCE : modifier;
                            boolean z21 = i37 == 0 ? true : z5;
                            float m2608getUnspecifiedD9Ej5fM = i39 == 0 ? Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM() : f5;
                            Integer num5 = i12 == 0 ? null : num2;
                            String str7 = i13 == 0 ? null : str;
                            z10 = i15 == 0 ? false : z6;
                            VisualTransformation visualTransformation4 = i17 == 0 ? null : visualTransformation;
                            boolean z22 = i19 == 0 ? true : z7;
                            boolean z23 = i20 == 0 ? false : z8;
                            if (i21 != 0) {
                                i22 = 1;
                            }
                            IFormValidator.ValidationKey validationKey4 = i23 == 0 ? null : validationKey;
                            IFormValidator iFormValidator4 = i24 == 0 ? null : iFormValidator;
                            KeyboardOptions keyboardOptions4 = i25 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                            String str8 = i26 == 0 ? null : str2;
                            Function3<? super Dp, ? super Composer, ? super Integer, Unit> function34 = i27 == 0 ? null : function3;
                            long m3281getWhite0d7_KjU = i28 == 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j5;
                            Function1<? super Boolean, Unit> function14 = i30 == 0 ? null : function1;
                            boolean z24 = i31 == 0 ? true : z9;
                            if ((i10 & 8388608) == 0) {
                                visualTransformation2 = visualTransformation4;
                                z11 = z23;
                                z12 = z22;
                                i33 = i22;
                                z13 = z24;
                                function32 = function34;
                                function12 = function14;
                                iFormValidator2 = iFormValidator4;
                                keyboardOptions2 = keyboardOptions4;
                                z14 = z21;
                                str3 = str8;
                                i32 = TextAlign.INSTANCE.m2533getStarte0LSkKk();
                            } else {
                                i32 = i6;
                                visualTransformation2 = visualTransformation4;
                                z11 = z23;
                                z12 = z22;
                                i33 = i22;
                                z13 = z24;
                                function32 = function34;
                                function12 = function14;
                                iFormValidator2 = iFormValidator4;
                                keyboardOptions2 = keyboardOptions4;
                                z14 = z21;
                                str3 = str8;
                            }
                            f6 = m2608getUnspecifiedD9Ej5fM;
                            str4 = str7;
                            j6 = m3281getWhite0d7_KjU;
                            validationKey2 = validationKey4;
                            num3 = num5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z14 = z5;
                            f6 = f5;
                            num3 = num2;
                            str4 = str;
                            z10 = z6;
                            visualTransformation2 = visualTransformation;
                            z12 = z7;
                            z11 = z8;
                            iFormValidator2 = iFormValidator;
                            keyboardOptions2 = keyboardOptions;
                            str3 = str2;
                            function32 = function3;
                            j6 = j5;
                            function12 = function1;
                            z13 = z9;
                            i32 = i6;
                            i33 = i22;
                            validationKey2 = validationKey;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(622080500, i14, i18, "dk.molslinjen.ui.views.reusable.input.StyledTextField (StyledTextField.kt:79)");
                        }
                        if (validationKey2 == null && iFormValidator2 != null) {
                            iFormValidator2.validate(validationKey2, input);
                            Unit unit = Unit.INSTANCE;
                        }
                        StateFlow<Map<IFormValidator.ValidationKey, InputValidationError>> submittedErrors = iFormValidator2 == null ? iFormValidator2.getSubmittedErrors() : null;
                        startRestartGroup.startReplaceGroup(1280942241);
                        State collectAsState = submittedErrors != null ? null : SnapshotStateKt.collectAsState(submittedErrors, null, startRestartGroup, 0, 1);
                        startRestartGroup.endReplaceGroup();
                        InputValidationError inputValidationError = (collectAsState != null || (map = (Map) collectAsState.getValue()) == null) ? null : (InputValidationError) map.get(validationKey2);
                        startRestartGroup.startReplaceGroup(1280945533);
                        if (validationKey2 != null) {
                            str5 = null;
                        } else {
                            startRestartGroup.startReplaceGroup(1280946457);
                            String errorMessage = inputValidationError == null ? null : inputValidationError.toErrorMessage((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), validationKey2);
                            startRestartGroup.endReplaceGroup();
                            str5 = errorMessage;
                        }
                        startRestartGroup.endReplaceGroup();
                        Object[] objArr = new Object[0];
                        startRestartGroup.startReplaceGroup(1280949269);
                        z15 = (i18 & 14) == 4;
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z15 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new Function0() { // from class: c2.v
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    MutableState StyledTextField_qgfaCVY$lambda$3$lambda$2;
                                    StyledTextField_qgfaCVY$lambda$3$lambda$2 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$3$lambda$2(z10);
                                    return StyledTextField_qgfaCVY$lambda$3$lambda$2;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 0, 6);
                        startRestartGroup.startReplaceGroup(1280951123);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        MutableState mutableState2 = (MutableState) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(1280953334);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == companion.getEmpty()) {
                            rememberedValue3 = BringIntoViewRequesterKt.BringIntoViewRequester();
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) rememberedValue3;
                        startRestartGroup.endReplaceGroup();
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (rememberedValue4 == companion.getEmpty()) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue4 = compositionScopedCoroutineScopeCanceller;
                        }
                        IFormValidator iFormValidator5 = iFormValidator2;
                        IFormValidator.ValidationKey validationKey5 = validationKey2;
                        Modifier modifier4 = modifier2;
                        boolean z25 = z10;
                        Modifier modifier5 = modifier2;
                        composer2 = startRestartGroup;
                        AutofillBoxKt.AutofillBox(autofillTypes, onValueChange, ComposableLambdaKt.rememberComposableLambda(-617688140, true, new StyledTextFieldKt$StyledTextField$2(modifier4, bringIntoViewRequester, num, z14, f6, RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)), onImeKeyAction, ((CompositionScopedCoroutineScopeCanceller) rememberedValue4).getCoroutineScope(), (Autofill) startRestartGroup.consume(CompositionLocalsKt.getLocalAutofill()), validationKey5, iFormValidator5, input, onValueChange, function12, z12, z11, TypographyKt.getParagraphSmall(), i32, i33, visualTransformation2, keyboardOptions2, z13, str5, str4, mutableState2, mutableState, j6, function32, z25, num3, str3), composer2, 54), composer2, ((i14 >> 9) & 14) | 384 | ((i14 >> 18) & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        num4 = num3;
                        visualTransformation3 = visualTransformation2;
                        z16 = z12;
                        z17 = z11;
                        i34 = i33;
                        keyboardOptions3 = keyboardOptions2;
                        str6 = str3;
                        function33 = function32;
                        j7 = j6;
                        function13 = function12;
                        z18 = z13;
                        i35 = i32;
                        iFormValidator3 = iFormValidator5;
                        validationKey3 = validationKey5;
                        z19 = z25;
                        f7 = f6;
                        z20 = z14;
                        modifier3 = modifier5;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier6 = modifier3;
                        final boolean z26 = z20;
                        final float f8 = f7;
                        final Integer num6 = num4;
                        final String str9 = str4;
                        endRestartGroup.updateScope(new Function2() { // from class: c2.w
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit StyledTextField_qgfaCVY$lambda$10;
                                StyledTextField_qgfaCVY$lambda$10 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$10(Modifier.this, z26, f8, autofillTypes, num, num6, str9, onValueChange, onImeKeyAction, input, z19, visualTransformation3, z16, z17, i34, validationKey3, iFormValidator3, keyboardOptions3, str6, function33, j7, function13, z18, i35, i7, i8, i9, i10, (Composer) obj, ((Integer) obj2).intValue());
                                return StyledTextField_qgfaCVY$lambda$10;
                            }
                        });
                        return;
                    }
                    return;
                }
                i22 = i5;
                i23 = i10 & 32768;
                if (i23 == 0) {
                }
                i24 = i10 & 65536;
                if (i24 == 0) {
                }
                i25 = i10 & 131072;
                if (i25 == 0) {
                }
                i26 = i10 & 262144;
                if (i26 == 0) {
                }
                i27 = i10 & 524288;
                if (i27 == 0) {
                }
                i28 = i10 & 1048576;
                if (i28 == 0) {
                }
                i30 = i10 & 2097152;
                if (i30 == 0) {
                }
                int i412 = i29;
                i31 = i10 & 4194304;
                if (i31 == 0) {
                }
                if ((i9 & 3072) == 0) {
                }
                if ((i14 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i7 & 1) != 0) {
                }
                if (i36 == 0) {
                }
                if (i37 == 0) {
                }
                if (i39 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if (i17 == 0) {
                }
                if (i19 == 0) {
                }
                if (i20 == 0) {
                }
                if (i21 != 0) {
                }
                if (i23 == 0) {
                }
                if (i24 == 0) {
                }
                if (i25 == 0) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                if (i28 == 0) {
                }
                if (i30 == 0) {
                }
                if (i31 == 0) {
                }
                if ((i10 & 8388608) == 0) {
                }
                f6 = m2608getUnspecifiedD9Ej5fM;
                str4 = str7;
                j6 = m3281getWhite0d7_KjU;
                validationKey2 = validationKey4;
                num3 = num5;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (validationKey2 == null) {
                }
                if (iFormValidator2 == null) {
                }
                startRestartGroup.startReplaceGroup(1280942241);
                if (submittedErrors != null) {
                }
                startRestartGroup.endReplaceGroup();
                if (collectAsState != null) {
                }
                startRestartGroup.startReplaceGroup(1280945533);
                if (validationKey2 != null) {
                }
                startRestartGroup.endReplaceGroup();
                Object[] objArr2 = new Object[0];
                startRestartGroup.startReplaceGroup(1280949269);
                if ((i18 & 14) == 4) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z15) {
                }
                rememberedValue = new Function0() { // from class: c2.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState StyledTextField_qgfaCVY$lambda$3$lambda$2;
                        StyledTextField_qgfaCVY$lambda$3$lambda$2 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$3$lambda$2(z10);
                        return StyledTextField_qgfaCVY$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, null, null, (Function0) rememberedValue, startRestartGroup, 0, 6);
                startRestartGroup.startReplaceGroup(1280951123);
                rememberedValue2 = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue2 == companion.getEmpty()) {
                }
                MutableState mutableState22 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1280953334);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                }
                BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                }
                IFormValidator iFormValidator52 = iFormValidator2;
                IFormValidator.ValidationKey validationKey52 = validationKey2;
                Modifier modifier42 = modifier2;
                boolean z252 = z10;
                Modifier modifier52 = modifier2;
                composer2 = startRestartGroup;
                AutofillBoxKt.AutofillBox(autofillTypes, onValueChange, ComposableLambdaKt.rememberComposableLambda(-617688140, true, new StyledTextFieldKt$StyledTextField$2(modifier42, bringIntoViewRequester2, num, z14, f6, RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)), onImeKeyAction, ((CompositionScopedCoroutineScopeCanceller) rememberedValue4).getCoroutineScope(), (Autofill) startRestartGroup.consume(CompositionLocalsKt.getLocalAutofill()), validationKey52, iFormValidator52, input, onValueChange, function12, z12, z11, TypographyKt.getParagraphSmall(), i32, i33, visualTransformation2, keyboardOptions2, z13, str5, str4, mutableState22, mutableState3, j6, function32, z252, num3, str3), composer2, 54), composer2, ((i14 >> 9) & 14) | 384 | ((i14 >> 18) & 112));
                if (ComposerKt.isTraceInProgress()) {
                }
                num4 = num3;
                visualTransformation3 = visualTransformation2;
                z16 = z12;
                z17 = z11;
                i34 = i33;
                keyboardOptions3 = keyboardOptions2;
                str6 = str3;
                function33 = function32;
                j7 = j6;
                function13 = function12;
                z18 = z13;
                i35 = i32;
                iFormValidator3 = iFormValidator52;
                validationKey3 = validationKey52;
                z19 = z252;
                f7 = f6;
                z20 = z14;
                modifier3 = modifier52;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i12 = i10 & 32;
            if (i12 != 0) {
            }
            i13 = i10 & 64;
            if (i13 != 0) {
            }
            if ((i10 & 128) != 0) {
            }
            if ((i10 & 256) != 0) {
            }
            if ((i10 & 512) != 0) {
            }
            i14 = i38;
            i15 = i10 & 1024;
            if (i15 != 0) {
            }
            i17 = i10 & 2048;
            if (i17 != 0) {
            }
            i18 = i16;
            i19 = i10 & 4096;
            if (i19 != 0) {
            }
            i20 = i10 & 8192;
            if (i20 != 0) {
            }
            i21 = i10 & 16384;
            if (i21 != 0) {
            }
            i22 = i5;
            i23 = i10 & 32768;
            if (i23 == 0) {
            }
            i24 = i10 & 65536;
            if (i24 == 0) {
            }
            i25 = i10 & 131072;
            if (i25 == 0) {
            }
            i26 = i10 & 262144;
            if (i26 == 0) {
            }
            i27 = i10 & 524288;
            if (i27 == 0) {
            }
            i28 = i10 & 1048576;
            if (i28 == 0) {
            }
            i30 = i10 & 2097152;
            if (i30 == 0) {
            }
            int i4122 = i29;
            i31 = i10 & 4194304;
            if (i31 == 0) {
            }
            if ((i9 & 3072) == 0) {
            }
            if ((i14 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i7 & 1) != 0) {
            }
            if (i36 == 0) {
            }
            if (i37 == 0) {
            }
            if (i39 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i15 == 0) {
            }
            if (i17 == 0) {
            }
            if (i19 == 0) {
            }
            if (i20 == 0) {
            }
            if (i21 != 0) {
            }
            if (i23 == 0) {
            }
            if (i24 == 0) {
            }
            if (i25 == 0) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            if (i28 == 0) {
            }
            if (i30 == 0) {
            }
            if (i31 == 0) {
            }
            if ((i10 & 8388608) == 0) {
            }
            f6 = m2608getUnspecifiedD9Ej5fM;
            str4 = str7;
            j6 = m3281getWhite0d7_KjU;
            validationKey2 = validationKey4;
            num3 = num5;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (validationKey2 == null) {
            }
            if (iFormValidator2 == null) {
            }
            startRestartGroup.startReplaceGroup(1280942241);
            if (submittedErrors != null) {
            }
            startRestartGroup.endReplaceGroup();
            if (collectAsState != null) {
            }
            startRestartGroup.startReplaceGroup(1280945533);
            if (validationKey2 != null) {
            }
            startRestartGroup.endReplaceGroup();
            Object[] objArr22 = new Object[0];
            startRestartGroup.startReplaceGroup(1280949269);
            if ((i18 & 14) == 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z15) {
            }
            rememberedValue = new Function0() { // from class: c2.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    MutableState StyledTextField_qgfaCVY$lambda$3$lambda$2;
                    StyledTextField_qgfaCVY$lambda$3$lambda$2 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$3$lambda$2(z10);
                    return StyledTextField_qgfaCVY$lambda$3$lambda$2;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            MutableState mutableState32 = (MutableState) RememberSaveableKt.rememberSaveable(objArr22, null, null, (Function0) rememberedValue, startRestartGroup, 0, 6);
            startRestartGroup.startReplaceGroup(1280951123);
            rememberedValue2 = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
            }
            MutableState mutableState222 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1280953334);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            BringIntoViewRequester bringIntoViewRequester22 = (BringIntoViewRequester) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
            }
            IFormValidator iFormValidator522 = iFormValidator2;
            IFormValidator.ValidationKey validationKey522 = validationKey2;
            Modifier modifier422 = modifier2;
            boolean z2522 = z10;
            Modifier modifier522 = modifier2;
            composer2 = startRestartGroup;
            AutofillBoxKt.AutofillBox(autofillTypes, onValueChange, ComposableLambdaKt.rememberComposableLambda(-617688140, true, new StyledTextFieldKt$StyledTextField$2(modifier422, bringIntoViewRequester22, num, z14, f6, RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)), onImeKeyAction, ((CompositionScopedCoroutineScopeCanceller) rememberedValue4).getCoroutineScope(), (Autofill) startRestartGroup.consume(CompositionLocalsKt.getLocalAutofill()), validationKey522, iFormValidator522, input, onValueChange, function12, z12, z11, TypographyKt.getParagraphSmall(), i32, i33, visualTransformation2, keyboardOptions2, z13, str5, str4, mutableState222, mutableState32, j6, function32, z2522, num3, str3), composer2, 54), composer2, ((i14 >> 9) & 14) | 384 | ((i14 >> 18) & 112));
            if (ComposerKt.isTraceInProgress()) {
            }
            num4 = num3;
            visualTransformation3 = visualTransformation2;
            z16 = z12;
            z17 = z11;
            i34 = i33;
            keyboardOptions3 = keyboardOptions2;
            str6 = str3;
            function33 = function32;
            j7 = j6;
            function13 = function12;
            z18 = z13;
            i35 = i32;
            iFormValidator3 = iFormValidator522;
            validationKey3 = validationKey522;
            z19 = z2522;
            f7 = f6;
            z20 = z14;
            modifier3 = modifier522;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        int i402 = 2048;
        if ((i10 & 8) == 0) {
        }
        if ((i10 & 16) == 0) {
        }
        i12 = i10 & 32;
        if (i12 != 0) {
        }
        i13 = i10 & 64;
        if (i13 != 0) {
        }
        if ((i10 & 128) != 0) {
        }
        if ((i10 & 256) != 0) {
        }
        if ((i10 & 512) != 0) {
        }
        i14 = i38;
        i15 = i10 & 1024;
        if (i15 != 0) {
        }
        i17 = i10 & 2048;
        if (i17 != 0) {
        }
        i18 = i16;
        i19 = i10 & 4096;
        if (i19 != 0) {
        }
        i20 = i10 & 8192;
        if (i20 != 0) {
        }
        i21 = i10 & 16384;
        if (i21 != 0) {
        }
        i22 = i5;
        i23 = i10 & 32768;
        if (i23 == 0) {
        }
        i24 = i10 & 65536;
        if (i24 == 0) {
        }
        i25 = i10 & 131072;
        if (i25 == 0) {
        }
        i26 = i10 & 262144;
        if (i26 == 0) {
        }
        i27 = i10 & 524288;
        if (i27 == 0) {
        }
        i28 = i10 & 1048576;
        if (i28 == 0) {
        }
        i30 = i10 & 2097152;
        if (i30 == 0) {
        }
        int i41222 = i29;
        i31 = i10 & 4194304;
        if (i31 == 0) {
        }
        if ((i9 & 3072) == 0) {
        }
        if ((i14 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i7 & 1) != 0) {
        }
        if (i36 == 0) {
        }
        if (i37 == 0) {
        }
        if (i39 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if (i17 == 0) {
        }
        if (i19 == 0) {
        }
        if (i20 == 0) {
        }
        if (i21 != 0) {
        }
        if (i23 == 0) {
        }
        if (i24 == 0) {
        }
        if (i25 == 0) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        if (i28 == 0) {
        }
        if (i30 == 0) {
        }
        if (i31 == 0) {
        }
        if ((i10 & 8388608) == 0) {
        }
        f6 = m2608getUnspecifiedD9Ej5fM;
        str4 = str7;
        j6 = m3281getWhite0d7_KjU;
        validationKey2 = validationKey4;
        num3 = num5;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (validationKey2 == null) {
        }
        if (iFormValidator2 == null) {
        }
        startRestartGroup.startReplaceGroup(1280942241);
        if (submittedErrors != null) {
        }
        startRestartGroup.endReplaceGroup();
        if (collectAsState != null) {
        }
        startRestartGroup.startReplaceGroup(1280945533);
        if (validationKey2 != null) {
        }
        startRestartGroup.endReplaceGroup();
        Object[] objArr222 = new Object[0];
        startRestartGroup.startReplaceGroup(1280949269);
        if ((i18 & 14) == 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z15) {
        }
        rememberedValue = new Function0() { // from class: c2.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MutableState StyledTextField_qgfaCVY$lambda$3$lambda$2;
                StyledTextField_qgfaCVY$lambda$3$lambda$2 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$3$lambda$2(z10);
                return StyledTextField_qgfaCVY$lambda$3$lambda$2;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        MutableState mutableState322 = (MutableState) RememberSaveableKt.rememberSaveable(objArr222, null, null, (Function0) rememberedValue, startRestartGroup, 0, 6);
        startRestartGroup.startReplaceGroup(1280951123);
        rememberedValue2 = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
        }
        MutableState mutableState2222 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1280953334);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        BringIntoViewRequester bringIntoViewRequester222 = (BringIntoViewRequester) rememberedValue3;
        startRestartGroup.endReplaceGroup();
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
        }
        IFormValidator iFormValidator5222 = iFormValidator2;
        IFormValidator.ValidationKey validationKey5222 = validationKey2;
        Modifier modifier4222 = modifier2;
        boolean z25222 = z10;
        Modifier modifier5222 = modifier2;
        composer2 = startRestartGroup;
        AutofillBoxKt.AutofillBox(autofillTypes, onValueChange, ComposableLambdaKt.rememberComposableLambda(-617688140, true, new StyledTextFieldKt$StyledTextField$2(modifier4222, bringIntoViewRequester222, num, z14, f6, RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)), onImeKeyAction, ((CompositionScopedCoroutineScopeCanceller) rememberedValue4).getCoroutineScope(), (Autofill) startRestartGroup.consume(CompositionLocalsKt.getLocalAutofill()), validationKey5222, iFormValidator5222, input, onValueChange, function12, z12, z11, TypographyKt.getParagraphSmall(), i32, i33, visualTransformation2, keyboardOptions2, z13, str5, str4, mutableState2222, mutableState322, j6, function32, z25222, num3, str3), composer2, 54), composer2, ((i14 >> 9) & 14) | 384 | ((i14 >> 18) & 112));
        if (ComposerKt.isTraceInProgress()) {
        }
        num4 = num3;
        visualTransformation3 = visualTransformation2;
        z16 = z12;
        z17 = z11;
        i34 = i33;
        keyboardOptions3 = keyboardOptions2;
        str6 = str3;
        function33 = function32;
        j7 = j6;
        function13 = function12;
        z18 = z13;
        i35 = i32;
        iFormValidator3 = iFormValidator5222;
        validationKey3 = validationKey5222;
        z19 = z25222;
        f7 = f6;
        z20 = z14;
        modifier3 = modifier5222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit StyledTextField_qgfaCVY$lambda$10(Modifier modifier, boolean z5, float f5, List list, Integer num, Integer num2, String str, Function1 function1, Function0 function0, String str2, boolean z6, VisualTransformation visualTransformation, boolean z7, boolean z8, int i5, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, KeyboardOptions keyboardOptions, String str3, Function3 function3, long j5, Function1 function12, boolean z9, int i6, int i7, int i8, int i9, int i10, Composer composer, int i11) {
        m3412StyledTextFieldqgfaCVY(modifier, z5, f5, list, num, num2, str, function1, function0, str2, z6, visualTransformation, z7, z8, i5, validationKey, iFormValidator, keyboardOptions, str3, function3, j5, function12, z9, i6, composer, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), RecomposeScopeImplKt.updateChangedFlags(i8), RecomposeScopeImplKt.updateChangedFlags(i9), i10);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState StyledTextField_qgfaCVY$lambda$3$lambda$2(boolean z5) {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(!z5), null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StyledTextField_qgfaCVY$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StyledTextField_qgfaCVY$lambda$5(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean StyledTextField_qgfaCVY$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StyledTextField_qgfaCVY$lambda$8(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }
}
