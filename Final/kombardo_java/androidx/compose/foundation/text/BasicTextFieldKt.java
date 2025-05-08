package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000z\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a×\u0001\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\"\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\"\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006-²\u0006\f\u0010'\u001a\u00020&8\nX\u008a\u0084\u0002²\u0006\f\u0010(\u001a\u00020&8\nX\u008a\u0084\u0002²\u0006\f\u0010)\u001a\u00020&8\nX\u008a\u0084\u0002²\u0006\u000e\u0010+\u001a\u00020*8\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010,\u001a\u00020\u00008\n@\nX\u008a\u008e\u0002"}, d2 = {BuildConfig.FLAVOR, "value", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onValueChange", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "enabled", "readOnly", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "singleLine", BuildConfig.FLAVOR, "maxLines", "minLines", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/ui/text/TextLayoutResult;", "onTextLayout", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/ui/graphics/Brush;", "cursorBrush", "Lkotlin/Function0;", "decorationBox", "BasicTextField", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "DefaultTextFieldDecorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "Landroidx/compose/ui/unit/DpSize;", "MinTouchTargetSizeForHandles", "J", BuildConfig.FLAVOR, "cursorHandleState", "startHandleState", "endHandleState", "Landroidx/compose/ui/text/input/TextFieldValue;", "textFieldValueState", "lastTextValue", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = new TextFieldDecorator() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$DefaultTextFieldDecorator$1
    };
    private static final long MinTouchTargetSizeForHandles;

    static {
        float f5 = 40;
        MinTouchTargetSizeForHandles = DpKt.m2610DpSizeYgX7TsA(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5));
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0395  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z5, boolean z6, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z7, int i5, int i6, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i7, final int i8, final int i9) {
        int i10;
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
        Modifier modifier2;
        boolean z8;
        int i24;
        boolean z9;
        int i25;
        KeyboardActions keyboardActions2;
        Brush brush2;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> m471getLambda1$foundation_release;
        int i26;
        MutableInteractionSource mutableInteractionSource2;
        Brush brush3;
        boolean z10;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions3;
        VisualTransformation visualTransformation2;
        Function1<? super TextLayoutResult, Unit> function13;
        int i27;
        boolean z11;
        int i28;
        Object rememberedValue;
        Composer.Companion companion;
        boolean z12;
        boolean changed;
        Object rememberedValue2;
        boolean z13;
        Object rememberedValue3;
        boolean changed2;
        Object rememberedValue4;
        boolean z14;
        KeyboardOptions keyboardOptions3;
        int i29;
        KeyboardActions keyboardActions4;
        VisualTransformation visualTransformation3;
        Function1<? super TextLayoutResult, Unit> function14;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        int i30;
        boolean z15;
        boolean z16;
        TextStyle textStyle3;
        Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i31;
        Composer startRestartGroup = composer.startRestartGroup(945255183);
        if ((i9 & 1) != 0) {
            i10 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i10 = (startRestartGroup.changed(str) ? 4 : 2) | i7;
        } else {
            i10 = i7;
        }
        if ((i9 & 2) != 0) {
            i10 |= 48;
        } else if ((i7 & 48) == 0) {
            i10 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i32 = i9 & 4;
        if (i32 != 0) {
            i10 |= 384;
        } else if ((i7 & 384) == 0) {
            i10 |= startRestartGroup.changed(modifier) ? 256 : 128;
            i11 = i9 & 8;
            if (i11 == 0) {
                i10 |= 3072;
            } else if ((i7 & 3072) == 0) {
                i10 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                i12 = i9 & 16;
                if (i12 != 0) {
                    i10 |= 24576;
                } else if ((i7 & 24576) == 0) {
                    i10 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                    i13 = i9 & 32;
                    if (i13 == 0) {
                        i10 |= 196608;
                    } else if ((i7 & 196608) == 0) {
                        i10 |= startRestartGroup.changed(textStyle) ? 131072 : 65536;
                    }
                    i14 = i9 & 64;
                    if (i14 == 0) {
                        i10 |= 1572864;
                    } else if ((i7 & 1572864) == 0) {
                        i10 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : 524288;
                    }
                    i15 = i9 & 128;
                    if (i15 == 0) {
                        i10 |= 12582912;
                    } else if ((i7 & 12582912) == 0) {
                        i10 |= startRestartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                    }
                    i16 = i9 & 256;
                    if (i16 == 0) {
                        i10 |= 100663296;
                    } else if ((i7 & 100663296) == 0) {
                        i10 |= startRestartGroup.changed(z7) ? 67108864 : 33554432;
                    }
                    if ((i7 & 805306368) == 0) {
                        if ((i9 & 512) == 0 && startRestartGroup.changed(i5)) {
                            i31 = 536870912;
                            i10 |= i31;
                        }
                        i31 = 268435456;
                        i10 |= i31;
                    }
                    i17 = i9 & 1024;
                    if (i17 == 0) {
                        i18 = i8 | 6;
                    } else if ((i8 & 6) == 0) {
                        i18 = i8 | (startRestartGroup.changed(i6) ? 4 : 2);
                    } else {
                        i18 = i8;
                    }
                    i19 = i9 & 2048;
                    if (i19 == 0) {
                        i18 |= 48;
                    } else if ((i8 & 48) == 0) {
                        i18 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                    }
                    int i33 = i18;
                    i20 = i9 & 4096;
                    if (i20 == 0) {
                        i33 |= 384;
                    } else if ((i8 & 384) == 0) {
                        i33 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
                        i21 = i9 & 8192;
                        if (i21 != 0) {
                            i33 |= 3072;
                        } else if ((i8 & 3072) == 0) {
                            i33 |= startRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
                            i22 = i9 & 16384;
                            if (i22 == 0) {
                                i33 |= 24576;
                            } else if ((i8 & 24576) == 0) {
                                i33 |= startRestartGroup.changed(brush) ? 16384 : 8192;
                                i23 = i9 & 32768;
                                if (i23 != 0) {
                                    i33 |= 196608;
                                } else if ((i8 & 196608) == 0) {
                                    i33 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                                }
                                if ((i10 & 306783379) != 306783378 && (74899 & i33) == 74898 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier3 = modifier;
                                    z14 = z5;
                                    z15 = z6;
                                    textStyle3 = textStyle;
                                    keyboardOptions3 = keyboardOptions;
                                    keyboardActions4 = keyboardActions;
                                    z16 = z7;
                                    i30 = i5;
                                    i29 = i6;
                                    visualTransformation3 = visualTransformation;
                                    function14 = function12;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    brush3 = brush;
                                    function32 = function3;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i7 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        modifier2 = i32 != 0 ? Modifier.INSTANCE : modifier;
                                        z8 = i11 != 0 ? true : z5;
                                        boolean z17 = i12 != 0 ? false : z6;
                                        TextStyle textStyle4 = i13 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                                        KeyboardOptions keyboardOptions4 = i14 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions5 = i15 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z18 = i16 != 0 ? false : z7;
                                        if ((i9 & 512) != 0) {
                                            i24 = z18 ? 1 : Integer.MAX_VALUE;
                                            i10 &= -1879048193;
                                        } else {
                                            i24 = i5;
                                        }
                                        int i34 = i17 != 0 ? 1 : i6;
                                        VisualTransformation none = i19 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        Function1<? super TextLayoutResult, Unit> function15 = i20 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6
                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(TextLayoutResult textLayoutResult) {
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                                invoke2(textLayoutResult);
                                                return Unit.INSTANCE;
                                            }
                                        } : function12;
                                        MutableInteractionSource mutableInteractionSource3 = i21 != 0 ? null : mutableInteractionSource;
                                        if (i22 != 0) {
                                            i25 = i10;
                                            keyboardActions2 = keyboardActions5;
                                            z9 = z18;
                                            brush2 = new SolidColor(Color.INSTANCE.m1496getBlack0d7_KjU(), null);
                                        } else {
                                            z9 = z18;
                                            i25 = i10;
                                            keyboardActions2 = keyboardActions5;
                                            brush2 = brush;
                                        }
                                        m471getLambda1$foundation_release = i23 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m471getLambda1$foundation_release() : function3;
                                        i26 = i34;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        brush3 = brush2;
                                        z10 = z17;
                                        textStyle2 = textStyle4;
                                        keyboardOptions2 = keyboardOptions4;
                                        keyboardActions3 = keyboardActions2;
                                        visualTransformation2 = none;
                                        function13 = function15;
                                        i27 = i25;
                                        z11 = z9;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i9 & 512) != 0) {
                                            i10 &= -1879048193;
                                        }
                                        modifier2 = modifier;
                                        z8 = z5;
                                        z10 = z6;
                                        keyboardOptions2 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        z11 = z7;
                                        i24 = i5;
                                        i26 = i6;
                                        visualTransformation2 = visualTransformation;
                                        function13 = function12;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush3 = brush;
                                        m471getLambda1$foundation_release = function3;
                                        i27 = i10;
                                        textStyle2 = textStyle;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        i28 = i24;
                                        ComposerKt.traceEventStart(945255183, i27, i33, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:610)");
                                    } else {
                                        i28 = i24;
                                    }
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue == companion.getEmpty()) {
                                        z12 = z10;
                                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    } else {
                                        z12 = z10;
                                    }
                                    final MutableState mutableState = (MutableState) rememberedValue;
                                    final TextFieldValue m2425copy3r_uNRQ$default = TextFieldValue.m2425copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState), str, 0L, (TextRange) null, 6, (Object) null);
                                    changed = startRestartGroup.changed(m2425copy3r_uNRQ$default);
                                    boolean z19 = z8;
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (!changed || rememberedValue2 == companion.getEmpty()) {
                                        rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public /* bridge */ /* synthetic */ Unit invoke() {
                                                invoke2();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2() {
                                                TextFieldValue BasicTextField$lambda$21;
                                                TextFieldValue BasicTextField$lambda$212;
                                                long selection = TextFieldValue.this.getSelection();
                                                BasicTextField$lambda$21 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState);
                                                if (TextRange.m2278equalsimpl0(selection, BasicTextField$lambda$21.getSelection())) {
                                                    TextRange composition = TextFieldValue.this.getComposition();
                                                    BasicTextField$lambda$212 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState);
                                                    if (Intrinsics.areEqual(composition, BasicTextField$lambda$212.getComposition())) {
                                                        return;
                                                    }
                                                }
                                                mutableState.setValue(TextFieldValue.this);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                                    z13 = (i27 & 14) == 4;
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (!z13 || rememberedValue3 == companion.getEmpty()) {
                                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    final MutableState mutableState2 = (MutableState) rememberedValue3;
                                    ImeOptions imeOptions$foundation_release = keyboardOptions2.toImeOptions$foundation_release(z11);
                                    boolean z20 = !z11;
                                    int i35 = z11 ? 1 : i26;
                                    int i36 = z11 ? 1 : i28;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                    changed2 = startRestartGroup.changed(mutableState2) | ((i27 & 112) == 32);
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (!changed2 || rememberedValue4 == companion.getEmpty()) {
                                        rememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                                invoke2(textFieldValue);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(TextFieldValue textFieldValue) {
                                                String BasicTextField$lambda$25;
                                                mutableState.setValue(textFieldValue);
                                                BasicTextField$lambda$25 = BasicTextFieldKt.BasicTextField$lambda$25(mutableState2);
                                                boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$25, textFieldValue.getText());
                                                mutableState2.setValue(textFieldValue.getText());
                                                if (areEqual) {
                                                    return;
                                                }
                                                function1.invoke(textFieldValue.getText());
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    int i37 = i33 << 9;
                                    CoreTextFieldKt.CoreTextField(m2425copy3r_uNRQ$default, (Function1) rememberedValue4, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush3, z20, i36, i35, imeOptions$foundation_release, keyboardActions3, z19, z12, m471getLambda1$foundation_release, startRestartGroup, (i27 & 896) | ((i27 >> 6) & 7168) | (57344 & i37) | (458752 & i37) | (3670016 & i37) | (i37 & 29360128), ((i27 >> 15) & 896) | (i27 & 7168) | (57344 & i27) | (458752 & i33), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z14 = z19;
                                    keyboardOptions3 = keyboardOptions5;
                                    i29 = i26;
                                    keyboardActions4 = keyboardActions3;
                                    visualTransformation3 = visualTransformation2;
                                    function14 = function13;
                                    function32 = m471getLambda1$foundation_release;
                                    i30 = i28;
                                    z15 = z12;
                                    z16 = z11;
                                    textStyle3 = textStyle2;
                                    modifier3 = modifier2;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final Modifier modifier4 = modifier3;
                                    final boolean z21 = z14;
                                    final boolean z22 = z15;
                                    final TextStyle textStyle5 = textStyle3;
                                    final KeyboardOptions keyboardOptions6 = keyboardOptions3;
                                    final KeyboardActions keyboardActions6 = keyboardActions4;
                                    final boolean z23 = z16;
                                    final int i38 = i30;
                                    final int i39 = i29;
                                    final VisualTransformation visualTransformation4 = visualTransformation3;
                                    final Function1<? super TextLayoutResult, Unit> function16 = function14;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    final Brush brush4 = brush3;
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i40) {
                                            BasicTextFieldKt.BasicTextField(str, function1, modifier4, z21, z22, textStyle5, keyboardOptions6, keyboardActions6, z23, i38, i39, visualTransformation4, function16, mutableInteractionSource4, brush4, function32, composer2, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), RecomposeScopeImplKt.updateChangedFlags(i8), i9);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i23 = i9 & 32768;
                            if (i23 != 0) {
                            }
                            if ((i10 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i7 & 1) != 0) {
                            }
                            if (i32 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if ((i9 & 512) != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i19 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i21 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i23 != 0) {
                            }
                            i26 = i34;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            brush3 = brush2;
                            z10 = z17;
                            textStyle2 = textStyle4;
                            keyboardOptions2 = keyboardOptions4;
                            keyboardActions3 = keyboardActions2;
                            visualTransformation2 = none;
                            function13 = function15;
                            i27 = i25;
                            z11 = z9;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                            }
                            final MutableState<TextFieldValue> mutableState3 = (MutableState) rememberedValue;
                            final TextFieldValue m2425copy3r_uNRQ$default2 = TextFieldValue.m2425copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState3), str, 0L, (TextRange) null, 6, (Object) null);
                            changed = startRestartGroup.changed(m2425copy3r_uNRQ$default2);
                            boolean z192 = z8;
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    TextFieldValue BasicTextField$lambda$21;
                                    TextFieldValue BasicTextField$lambda$212;
                                    long selection = TextFieldValue.this.getSelection();
                                    BasicTextField$lambda$21 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState3);
                                    if (TextRange.m2278equalsimpl0(selection, BasicTextField$lambda$21.getSelection())) {
                                        TextRange composition = TextFieldValue.this.getComposition();
                                        BasicTextField$lambda$212 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState3);
                                        if (Intrinsics.areEqual(composition, BasicTextField$lambda$212.getComposition())) {
                                            return;
                                        }
                                    }
                                    mutableState3.setValue(TextFieldValue.this);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                            EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                            if ((i27 & 14) == 4) {
                            }
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (!z13) {
                            }
                            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                            final MutableState<String> mutableState22 = (MutableState) rememberedValue3;
                            ImeOptions imeOptions$foundation_release2 = keyboardOptions2.toImeOptions$foundation_release(z11);
                            boolean z202 = !z11;
                            if (z11) {
                            }
                            if (z11) {
                            }
                            KeyboardOptions keyboardOptions52 = keyboardOptions2;
                            changed2 = startRestartGroup.changed(mutableState22) | ((i27 & 112) == 32);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changed2) {
                            }
                            rememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                    invoke2(textFieldValue);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextFieldValue textFieldValue) {
                                    String BasicTextField$lambda$25;
                                    mutableState3.setValue(textFieldValue);
                                    BasicTextField$lambda$25 = BasicTextFieldKt.BasicTextField$lambda$25(mutableState22);
                                    boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$25, textFieldValue.getText());
                                    mutableState22.setValue(textFieldValue.getText());
                                    if (areEqual) {
                                        return;
                                    }
                                    function1.invoke(textFieldValue.getText());
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                            int i372 = i33 << 9;
                            CoreTextFieldKt.CoreTextField(m2425copy3r_uNRQ$default2, (Function1) rememberedValue4, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush3, z202, i36, i35, imeOptions$foundation_release2, keyboardActions3, z192, z12, m471getLambda1$foundation_release, startRestartGroup, (i27 & 896) | ((i27 >> 6) & 7168) | (57344 & i372) | (458752 & i372) | (3670016 & i372) | (i372 & 29360128), ((i27 >> 15) & 896) | (i27 & 7168) | (57344 & i27) | (458752 & i33), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z14 = z192;
                            keyboardOptions3 = keyboardOptions52;
                            i29 = i26;
                            keyboardActions4 = keyboardActions3;
                            visualTransformation3 = visualTransformation2;
                            function14 = function13;
                            function32 = m471getLambda1$foundation_release;
                            i30 = i28;
                            z15 = z12;
                            z16 = z11;
                            textStyle3 = textStyle2;
                            modifier3 = modifier2;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i22 = i9 & 16384;
                        if (i22 == 0) {
                        }
                        i23 = i9 & 32768;
                        if (i23 != 0) {
                        }
                        if ((i10 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i7 & 1) != 0) {
                        }
                        if (i32 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if ((i9 & 512) != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i23 != 0) {
                        }
                        i26 = i34;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        brush3 = brush2;
                        z10 = z17;
                        textStyle2 = textStyle4;
                        keyboardOptions2 = keyboardOptions4;
                        keyboardActions3 = keyboardActions2;
                        visualTransformation2 = none;
                        function13 = function15;
                        i27 = i25;
                        z11 = z9;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                        }
                        final MutableState<TextFieldValue> mutableState32 = (MutableState) rememberedValue;
                        final TextFieldValue m2425copy3r_uNRQ$default22 = TextFieldValue.m2425copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState32), str, 0L, (TextRange) null, 6, (Object) null);
                        changed = startRestartGroup.changed(m2425copy3r_uNRQ$default22);
                        boolean z1922 = z8;
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                TextFieldValue BasicTextField$lambda$21;
                                TextFieldValue BasicTextField$lambda$212;
                                long selection = TextFieldValue.this.getSelection();
                                BasicTextField$lambda$21 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState32);
                                if (TextRange.m2278equalsimpl0(selection, BasicTextField$lambda$21.getSelection())) {
                                    TextRange composition = TextFieldValue.this.getComposition();
                                    BasicTextField$lambda$212 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState32);
                                    if (Intrinsics.areEqual(composition, BasicTextField$lambda$212.getComposition())) {
                                        return;
                                    }
                                }
                                mutableState32.setValue(TextFieldValue.this);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                        if ((i27 & 14) == 4) {
                        }
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!z13) {
                        }
                        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        final MutableState<String> mutableState222 = (MutableState) rememberedValue3;
                        ImeOptions imeOptions$foundation_release22 = keyboardOptions2.toImeOptions$foundation_release(z11);
                        boolean z2022 = !z11;
                        if (z11) {
                        }
                        if (z11) {
                        }
                        KeyboardOptions keyboardOptions522 = keyboardOptions2;
                        changed2 = startRestartGroup.changed(mutableState222) | ((i27 & 112) == 32);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                                invoke2(textFieldValue);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextFieldValue textFieldValue) {
                                String BasicTextField$lambda$25;
                                mutableState32.setValue(textFieldValue);
                                BasicTextField$lambda$25 = BasicTextFieldKt.BasicTextField$lambda$25(mutableState222);
                                boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$25, textFieldValue.getText());
                                mutableState222.setValue(textFieldValue.getText());
                                if (areEqual) {
                                    return;
                                }
                                function1.invoke(textFieldValue.getText());
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        int i3722 = i33 << 9;
                        CoreTextFieldKt.CoreTextField(m2425copy3r_uNRQ$default22, (Function1) rememberedValue4, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush3, z2022, i36, i35, imeOptions$foundation_release22, keyboardActions3, z1922, z12, m471getLambda1$foundation_release, startRestartGroup, (i27 & 896) | ((i27 >> 6) & 7168) | (57344 & i3722) | (458752 & i3722) | (3670016 & i3722) | (i3722 & 29360128), ((i27 >> 15) & 896) | (i27 & 7168) | (57344 & i27) | (458752 & i33), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z14 = z1922;
                        keyboardOptions3 = keyboardOptions522;
                        i29 = i26;
                        keyboardActions4 = keyboardActions3;
                        visualTransformation3 = visualTransformation2;
                        function14 = function13;
                        function32 = m471getLambda1$foundation_release;
                        i30 = i28;
                        z15 = z12;
                        z16 = z11;
                        textStyle3 = textStyle2;
                        modifier3 = modifier2;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i21 = i9 & 8192;
                    if (i21 != 0) {
                    }
                    i22 = i9 & 16384;
                    if (i22 == 0) {
                    }
                    i23 = i9 & 32768;
                    if (i23 != 0) {
                    }
                    if ((i10 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i7 & 1) != 0) {
                    }
                    if (i32 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if ((i9 & 512) != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i23 != 0) {
                    }
                    i26 = i34;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    brush3 = brush2;
                    z10 = z17;
                    textStyle2 = textStyle4;
                    keyboardOptions2 = keyboardOptions4;
                    keyboardActions3 = keyboardActions2;
                    visualTransformation2 = none;
                    function13 = function15;
                    i27 = i25;
                    z11 = z9;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    final MutableState<TextFieldValue> mutableState322 = (MutableState) rememberedValue;
                    final TextFieldValue m2425copy3r_uNRQ$default222 = TextFieldValue.m2425copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState322), str, 0L, (TextRange) null, 6, (Object) null);
                    changed = startRestartGroup.changed(m2425copy3r_uNRQ$default222);
                    boolean z19222 = z8;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            TextFieldValue BasicTextField$lambda$21;
                            TextFieldValue BasicTextField$lambda$212;
                            long selection = TextFieldValue.this.getSelection();
                            BasicTextField$lambda$21 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState322);
                            if (TextRange.m2278equalsimpl0(selection, BasicTextField$lambda$21.getSelection())) {
                                TextRange composition = TextFieldValue.this.getComposition();
                                BasicTextField$lambda$212 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState322);
                                if (Intrinsics.areEqual(composition, BasicTextField$lambda$212.getComposition())) {
                                    return;
                                }
                            }
                            mutableState322.setValue(TextFieldValue.this);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                    if ((i27 & 14) == 4) {
                    }
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z13) {
                    }
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                    final MutableState<String> mutableState2222 = (MutableState) rememberedValue3;
                    ImeOptions imeOptions$foundation_release222 = keyboardOptions2.toImeOptions$foundation_release(z11);
                    boolean z20222 = !z11;
                    if (z11) {
                    }
                    if (z11) {
                    }
                    KeyboardOptions keyboardOptions5222 = keyboardOptions2;
                    changed2 = startRestartGroup.changed(mutableState2222) | ((i27 & 112) == 32);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                            invoke2(textFieldValue);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextFieldValue textFieldValue) {
                            String BasicTextField$lambda$25;
                            mutableState322.setValue(textFieldValue);
                            BasicTextField$lambda$25 = BasicTextFieldKt.BasicTextField$lambda$25(mutableState2222);
                            boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$25, textFieldValue.getText());
                            mutableState2222.setValue(textFieldValue.getText());
                            if (areEqual) {
                                return;
                            }
                            function1.invoke(textFieldValue.getText());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    int i37222 = i33 << 9;
                    CoreTextFieldKt.CoreTextField(m2425copy3r_uNRQ$default222, (Function1) rememberedValue4, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush3, z20222, i36, i35, imeOptions$foundation_release222, keyboardActions3, z19222, z12, m471getLambda1$foundation_release, startRestartGroup, (i27 & 896) | ((i27 >> 6) & 7168) | (57344 & i37222) | (458752 & i37222) | (3670016 & i37222) | (i37222 & 29360128), ((i27 >> 15) & 896) | (i27 & 7168) | (57344 & i27) | (458752 & i33), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z14 = z19222;
                    keyboardOptions3 = keyboardOptions5222;
                    i29 = i26;
                    keyboardActions4 = keyboardActions3;
                    visualTransformation3 = visualTransformation2;
                    function14 = function13;
                    function32 = m471getLambda1$foundation_release;
                    i30 = i28;
                    z15 = z12;
                    z16 = z11;
                    textStyle3 = textStyle2;
                    modifier3 = modifier2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i13 = i9 & 32;
                if (i13 == 0) {
                }
                i14 = i9 & 64;
                if (i14 == 0) {
                }
                i15 = i9 & 128;
                if (i15 == 0) {
                }
                i16 = i9 & 256;
                if (i16 == 0) {
                }
                if ((i7 & 805306368) == 0) {
                }
                i17 = i9 & 1024;
                if (i17 == 0) {
                }
                i19 = i9 & 2048;
                if (i19 == 0) {
                }
                int i332 = i18;
                i20 = i9 & 4096;
                if (i20 == 0) {
                }
                i21 = i9 & 8192;
                if (i21 != 0) {
                }
                i22 = i9 & 16384;
                if (i22 == 0) {
                }
                i23 = i9 & 32768;
                if (i23 != 0) {
                }
                if ((i10 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i7 & 1) != 0) {
                }
                if (i32 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 != 0) {
                }
                if ((i9 & 512) != 0) {
                }
                if (i17 != 0) {
                }
                if (i19 != 0) {
                }
                if (i20 != 0) {
                }
                if (i21 != 0) {
                }
                if (i22 != 0) {
                }
                if (i23 != 0) {
                }
                i26 = i34;
                mutableInteractionSource2 = mutableInteractionSource3;
                brush3 = brush2;
                z10 = z17;
                textStyle2 = textStyle4;
                keyboardOptions2 = keyboardOptions4;
                keyboardActions3 = keyboardActions2;
                visualTransformation2 = none;
                function13 = function15;
                i27 = i25;
                z11 = z9;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                final MutableState<TextFieldValue> mutableState3222 = (MutableState) rememberedValue;
                final TextFieldValue m2425copy3r_uNRQ$default2222 = TextFieldValue.m2425copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState3222), str, 0L, (TextRange) null, 6, (Object) null);
                changed = startRestartGroup.changed(m2425copy3r_uNRQ$default2222);
                boolean z192222 = z8;
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TextFieldValue BasicTextField$lambda$21;
                        TextFieldValue BasicTextField$lambda$212;
                        long selection = TextFieldValue.this.getSelection();
                        BasicTextField$lambda$21 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState3222);
                        if (TextRange.m2278equalsimpl0(selection, BasicTextField$lambda$21.getSelection())) {
                            TextRange composition = TextFieldValue.this.getComposition();
                            BasicTextField$lambda$212 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState3222);
                            if (Intrinsics.areEqual(composition, BasicTextField$lambda$212.getComposition())) {
                                return;
                            }
                        }
                        mutableState3222.setValue(TextFieldValue.this);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                if ((i27 & 14) == 4) {
                }
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!z13) {
                }
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                final MutableState<String> mutableState22222 = (MutableState) rememberedValue3;
                ImeOptions imeOptions$foundation_release2222 = keyboardOptions2.toImeOptions$foundation_release(z11);
                boolean z202222 = !z11;
                if (z11) {
                }
                if (z11) {
                }
                KeyboardOptions keyboardOptions52222 = keyboardOptions2;
                changed2 = startRestartGroup.changed(mutableState22222) | ((i27 & 112) == 32);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                        invoke2(textFieldValue);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextFieldValue textFieldValue) {
                        String BasicTextField$lambda$25;
                        mutableState3222.setValue(textFieldValue);
                        BasicTextField$lambda$25 = BasicTextFieldKt.BasicTextField$lambda$25(mutableState22222);
                        boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$25, textFieldValue.getText());
                        mutableState22222.setValue(textFieldValue.getText());
                        if (areEqual) {
                            return;
                        }
                        function1.invoke(textFieldValue.getText());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                int i372222 = i332 << 9;
                CoreTextFieldKt.CoreTextField(m2425copy3r_uNRQ$default2222, (Function1) rememberedValue4, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush3, z202222, i36, i35, imeOptions$foundation_release2222, keyboardActions3, z192222, z12, m471getLambda1$foundation_release, startRestartGroup, (i27 & 896) | ((i27 >> 6) & 7168) | (57344 & i372222) | (458752 & i372222) | (3670016 & i372222) | (i372222 & 29360128), ((i27 >> 15) & 896) | (i27 & 7168) | (57344 & i27) | (458752 & i332), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z14 = z192222;
                keyboardOptions3 = keyboardOptions52222;
                i29 = i26;
                keyboardActions4 = keyboardActions3;
                visualTransformation3 = visualTransformation2;
                function14 = function13;
                function32 = m471getLambda1$foundation_release;
                i30 = i28;
                z15 = z12;
                z16 = z11;
                textStyle3 = textStyle2;
                modifier3 = modifier2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i12 = i9 & 16;
            if (i12 != 0) {
            }
            i13 = i9 & 32;
            if (i13 == 0) {
            }
            i14 = i9 & 64;
            if (i14 == 0) {
            }
            i15 = i9 & 128;
            if (i15 == 0) {
            }
            i16 = i9 & 256;
            if (i16 == 0) {
            }
            if ((i7 & 805306368) == 0) {
            }
            i17 = i9 & 1024;
            if (i17 == 0) {
            }
            i19 = i9 & 2048;
            if (i19 == 0) {
            }
            int i3322 = i18;
            i20 = i9 & 4096;
            if (i20 == 0) {
            }
            i21 = i9 & 8192;
            if (i21 != 0) {
            }
            i22 = i9 & 16384;
            if (i22 == 0) {
            }
            i23 = i9 & 32768;
            if (i23 != 0) {
            }
            if ((i10 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i7 & 1) != 0) {
            }
            if (i32 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 != 0) {
            }
            if ((i9 & 512) != 0) {
            }
            if (i17 != 0) {
            }
            if (i19 != 0) {
            }
            if (i20 != 0) {
            }
            if (i21 != 0) {
            }
            if (i22 != 0) {
            }
            if (i23 != 0) {
            }
            i26 = i34;
            mutableInteractionSource2 = mutableInteractionSource3;
            brush3 = brush2;
            z10 = z17;
            textStyle2 = textStyle4;
            keyboardOptions2 = keyboardOptions4;
            keyboardActions3 = keyboardActions2;
            visualTransformation2 = none;
            function13 = function15;
            i27 = i25;
            z11 = z9;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            final MutableState<TextFieldValue> mutableState32222 = (MutableState) rememberedValue;
            final TextFieldValue m2425copy3r_uNRQ$default22222 = TextFieldValue.m2425copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState32222), str, 0L, (TextRange) null, 6, (Object) null);
            changed = startRestartGroup.changed(m2425copy3r_uNRQ$default22222);
            boolean z1922222 = z8;
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TextFieldValue BasicTextField$lambda$21;
                    TextFieldValue BasicTextField$lambda$212;
                    long selection = TextFieldValue.this.getSelection();
                    BasicTextField$lambda$21 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState32222);
                    if (TextRange.m2278equalsimpl0(selection, BasicTextField$lambda$21.getSelection())) {
                        TextRange composition = TextFieldValue.this.getComposition();
                        BasicTextField$lambda$212 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState32222);
                        if (Intrinsics.areEqual(composition, BasicTextField$lambda$212.getComposition())) {
                            return;
                        }
                    }
                    mutableState32222.setValue(TextFieldValue.this);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
            if ((i27 & 14) == 4) {
            }
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z13) {
            }
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            final MutableState<String> mutableState222222 = (MutableState) rememberedValue3;
            ImeOptions imeOptions$foundation_release22222 = keyboardOptions2.toImeOptions$foundation_release(z11);
            boolean z2022222 = !z11;
            if (z11) {
            }
            if (z11) {
            }
            KeyboardOptions keyboardOptions522222 = keyboardOptions2;
            changed2 = startRestartGroup.changed(mutableState222222) | ((i27 & 112) == 32);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                    invoke2(textFieldValue);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextFieldValue textFieldValue) {
                    String BasicTextField$lambda$25;
                    mutableState32222.setValue(textFieldValue);
                    BasicTextField$lambda$25 = BasicTextFieldKt.BasicTextField$lambda$25(mutableState222222);
                    boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$25, textFieldValue.getText());
                    mutableState222222.setValue(textFieldValue.getText());
                    if (areEqual) {
                        return;
                    }
                    function1.invoke(textFieldValue.getText());
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            int i3722222 = i3322 << 9;
            CoreTextFieldKt.CoreTextField(m2425copy3r_uNRQ$default22222, (Function1) rememberedValue4, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush3, z2022222, i36, i35, imeOptions$foundation_release22222, keyboardActions3, z1922222, z12, m471getLambda1$foundation_release, startRestartGroup, (i27 & 896) | ((i27 >> 6) & 7168) | (57344 & i3722222) | (458752 & i3722222) | (3670016 & i3722222) | (i3722222 & 29360128), ((i27 >> 15) & 896) | (i27 & 7168) | (57344 & i27) | (458752 & i3322), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z14 = z1922222;
            keyboardOptions3 = keyboardOptions522222;
            i29 = i26;
            keyboardActions4 = keyboardActions3;
            visualTransformation3 = visualTransformation2;
            function14 = function13;
            function32 = m471getLambda1$foundation_release;
            i30 = i28;
            z15 = z12;
            z16 = z11;
            textStyle3 = textStyle2;
            modifier3 = modifier2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i11 = i9 & 8;
        if (i11 == 0) {
        }
        i12 = i9 & 16;
        if (i12 != 0) {
        }
        i13 = i9 & 32;
        if (i13 == 0) {
        }
        i14 = i9 & 64;
        if (i14 == 0) {
        }
        i15 = i9 & 128;
        if (i15 == 0) {
        }
        i16 = i9 & 256;
        if (i16 == 0) {
        }
        if ((i7 & 805306368) == 0) {
        }
        i17 = i9 & 1024;
        if (i17 == 0) {
        }
        i19 = i9 & 2048;
        if (i19 == 0) {
        }
        int i33222 = i18;
        i20 = i9 & 4096;
        if (i20 == 0) {
        }
        i21 = i9 & 8192;
        if (i21 != 0) {
        }
        i22 = i9 & 16384;
        if (i22 == 0) {
        }
        i23 = i9 & 32768;
        if (i23 != 0) {
        }
        if ((i10 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i7 & 1) != 0) {
        }
        if (i32 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 != 0) {
        }
        if ((i9 & 512) != 0) {
        }
        if (i17 != 0) {
        }
        if (i19 != 0) {
        }
        if (i20 != 0) {
        }
        if (i21 != 0) {
        }
        if (i22 != 0) {
        }
        if (i23 != 0) {
        }
        i26 = i34;
        mutableInteractionSource2 = mutableInteractionSource3;
        brush3 = brush2;
        z10 = z17;
        textStyle2 = textStyle4;
        keyboardOptions2 = keyboardOptions4;
        keyboardActions3 = keyboardActions2;
        visualTransformation2 = none;
        function13 = function15;
        i27 = i25;
        z11 = z9;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final MutableState<TextFieldValue> mutableState322222 = (MutableState) rememberedValue;
        final TextFieldValue m2425copy3r_uNRQ$default222222 = TextFieldValue.m2425copy3r_uNRQ$default(BasicTextField$lambda$21(mutableState322222), str, 0L, (TextRange) null, 6, (Object) null);
        changed = startRestartGroup.changed(m2425copy3r_uNRQ$default222222);
        boolean z19222222 = z8;
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$7$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                TextFieldValue BasicTextField$lambda$21;
                TextFieldValue BasicTextField$lambda$212;
                long selection = TextFieldValue.this.getSelection();
                BasicTextField$lambda$21 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState322222);
                if (TextRange.m2278equalsimpl0(selection, BasicTextField$lambda$21.getSelection())) {
                    TextRange composition = TextFieldValue.this.getComposition();
                    BasicTextField$lambda$212 = BasicTextFieldKt.BasicTextField$lambda$21(mutableState322222);
                    if (Intrinsics.areEqual(composition, BasicTextField$lambda$212.getComposition())) {
                        return;
                    }
                }
                mutableState322222.setValue(TextFieldValue.this);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
        if ((i27 & 14) == 4) {
        }
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!z13) {
        }
        rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        final MutableState<String> mutableState2222222 = (MutableState) rememberedValue3;
        ImeOptions imeOptions$foundation_release222222 = keyboardOptions2.toImeOptions$foundation_release(z11);
        boolean z20222222 = !z11;
        if (z11) {
        }
        if (z11) {
        }
        KeyboardOptions keyboardOptions5222222 = keyboardOptions2;
        changed2 = startRestartGroup.changed(mutableState2222222) | ((i27 & 112) == 32);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue4 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue textFieldValue) {
                String BasicTextField$lambda$25;
                mutableState322222.setValue(textFieldValue);
                BasicTextField$lambda$25 = BasicTextFieldKt.BasicTextField$lambda$25(mutableState2222222);
                boolean areEqual = Intrinsics.areEqual(BasicTextField$lambda$25, textFieldValue.getText());
                mutableState2222222.setValue(textFieldValue.getText());
                if (areEqual) {
                    return;
                }
                function1.invoke(textFieldValue.getText());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        int i37222222 = i33222 << 9;
        CoreTextFieldKt.CoreTextField(m2425copy3r_uNRQ$default222222, (Function1) rememberedValue4, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush3, z20222222, i36, i35, imeOptions$foundation_release222222, keyboardActions3, z19222222, z12, m471getLambda1$foundation_release, startRestartGroup, (i27 & 896) | ((i27 >> 6) & 7168) | (57344 & i37222222) | (458752 & i37222222) | (3670016 & i37222222) | (i37222222 & 29360128), ((i27 >> 15) & 896) | (i27 & 7168) | (57344 & i27) | (458752 & i33222), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z14 = z19222222;
        keyboardOptions3 = keyboardOptions5222222;
        i29 = i26;
        keyboardActions4 = keyboardActions3;
        visualTransformation3 = visualTransformation2;
        function14 = function13;
        function32 = m471getLambda1$foundation_release;
        i30 = i28;
        z15 = z12;
        z16 = z11;
        textStyle3 = textStyle2;
        modifier3 = modifier2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$21(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String BasicTextField$lambda$25(MutableState<String> mutableState) {
        return mutableState.getValue();
    }
}
