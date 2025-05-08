package androidx.compose.material;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÒ\u0001\u0010#\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aÆ\u0001\u0010#\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a%\u0010)\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001f2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0'H\u0007¢\u0006\u0004\b)\u0010*\"\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {BuildConfig.FLAVOR, "text", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/unit/TextUnit;", "fontSize", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "letterSpacing", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", "lineHeight", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", BuildConfig.FLAVOR, "softWrap", BuildConfig.FLAVOR, "maxLines", "minLines", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", BuildConfig.FLAVOR, "onTextLayout", "Landroidx/compose/ui/text/TextStyle;", "style", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "value", "Lkotlin/Function0;", "content", "ProvideTextStyle", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyKt.getDefaultTextStyle();
        }
    });

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1772272796);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(textStyle) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, i6, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:396)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(((TextStyle) startRestartGroup.consume(providableCompositionLocal)).merge(textStyle)), function2, startRestartGroup, (i6 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$ProvideTextStyle$1
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

                public final void invoke(Composer composer2, int i7) {
                    TextKt.ProvideTextStyle(TextStyle.this, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03d1  */
    /* renamed from: Text--4IGK_g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m746Text4IGK_g(final String str, Modifier modifier, long j5, long j6, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j7, TextDecoration textDecoration, TextAlign textAlign, long j8, int i5, boolean z5, int i6, int i7, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i8, final int i9, final int i10) {
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
        Modifier modifier2;
        final long m1501getUnspecified0d7_KjU;
        long m2679getUnspecifiedXSAIIZE;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long m2679getUnspecifiedXSAIIZE2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        long m2679getUnspecifiedXSAIIZE3;
        int m2563getClipgIe3tQ8;
        boolean z6;
        int i28;
        int i29;
        Function1<? super TextLayoutResult, Unit> function12;
        int i30;
        TextStyle textStyle2;
        int i31;
        long j9;
        TextStyle m2308mergedA7vx0o;
        boolean changed;
        Object rememberedValue;
        final int i32;
        final TextDecoration textDecoration3;
        final TextAlign textAlign3;
        final Modifier modifier3;
        final int i33;
        final FontStyle fontStyle3;
        final long j10;
        final long j11;
        final int i34;
        final boolean z7;
        final Function1<? super TextLayoutResult, Unit> function13;
        final FontFamily fontFamily3;
        final long j12;
        final long j13;
        final TextStyle textStyle3;
        final FontWeight fontWeight3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1028090691);
        if ((i10 & 1) != 0) {
            i11 = i8 | 6;
        } else if ((i8 & 6) == 0) {
            i11 = (startRestartGroup.changed(str) ? 4 : 2) | i8;
        } else {
            i11 = i8;
        }
        int i35 = i10 & 2;
        if (i35 != 0) {
            i11 |= 48;
        } else if ((i8 & 48) == 0) {
            i11 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i12 = i10 & 4;
            if (i12 == 0) {
                i11 |= 384;
            } else if ((i8 & 384) == 0) {
                i11 |= startRestartGroup.changed(j5) ? 256 : 128;
            }
            i13 = i10 & 8;
            if (i13 == 0) {
                i11 |= 3072;
            } else if ((i8 & 3072) == 0) {
                i11 |= startRestartGroup.changed(j6) ? 2048 : 1024;
            }
            i14 = i10 & 16;
            if (i14 == 0) {
                i11 |= 24576;
            } else if ((i8 & 24576) == 0) {
                i11 |= startRestartGroup.changed(fontStyle) ? 16384 : 8192;
                i15 = i10 & 32;
                if (i15 != 0) {
                    i11 |= 196608;
                } else if ((i8 & 196608) == 0) {
                    i11 |= startRestartGroup.changed(fontWeight) ? 131072 : 65536;
                }
                i16 = i10 & 64;
                if (i16 != 0) {
                    i11 |= 1572864;
                } else if ((i8 & 1572864) == 0) {
                    i11 |= startRestartGroup.changed(fontFamily) ? 1048576 : 524288;
                }
                i17 = i10 & 128;
                if (i17 != 0) {
                    i11 |= 12582912;
                } else if ((i8 & 12582912) == 0) {
                    i11 |= startRestartGroup.changed(j7) ? 8388608 : 4194304;
                }
                i18 = i10 & 256;
                if (i18 != 0) {
                    i11 |= 100663296;
                } else if ((100663296 & i8) == 0) {
                    i11 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                    i19 = i10 & 512;
                    if (i19 == 0) {
                        i11 |= 805306368;
                    } else if ((i8 & 805306368) == 0) {
                        i11 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    }
                    i20 = i10 & 1024;
                    if (i20 == 0) {
                        i21 = i9 | 6;
                    } else if ((i9 & 6) == 0) {
                        i21 = i9 | (startRestartGroup.changed(j8) ? 4 : 2);
                    } else {
                        i21 = i9;
                    }
                    i22 = i10 & 2048;
                    if (i22 == 0) {
                        i21 |= 48;
                    } else if ((i9 & 48) == 0) {
                        i21 |= startRestartGroup.changed(i5) ? 32 : 16;
                    }
                    int i36 = i21;
                    i23 = i10 & 4096;
                    if (i23 == 0) {
                        i36 |= 384;
                    } else if ((i9 & 384) == 0) {
                        i36 |= startRestartGroup.changed(z5) ? 256 : 128;
                        i24 = i10 & 8192;
                        if (i24 != 0) {
                            i36 |= 3072;
                        } else if ((i9 & 3072) == 0) {
                            i36 |= startRestartGroup.changed(i6) ? 2048 : 1024;
                            i25 = i10 & 16384;
                            if (i25 == 0) {
                                i36 |= 24576;
                                i26 = i25;
                            } else {
                                i26 = i25;
                                if ((i9 & 24576) == 0) {
                                    i36 |= startRestartGroup.changed(i7) ? 16384 : 8192;
                                    i27 = i10 & 32768;
                                    if (i27 != 0) {
                                        i36 |= 196608;
                                    } else if ((i9 & 196608) == 0) {
                                        i36 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
                                    }
                                    if ((i9 & 1572864) == 0) {
                                        i36 |= ((i10 & 65536) == 0 && startRestartGroup.changed(textStyle)) ? 1048576 : 524288;
                                    }
                                    if ((i11 & 306783379) != 306783378 && (599187 & i36) == 599186 && startRestartGroup.getSkipping()) {
                                        startRestartGroup.skipToGroupEnd();
                                        modifier3 = modifier;
                                        j13 = j5;
                                        j10 = j6;
                                        fontStyle3 = fontStyle;
                                        fontWeight3 = fontWeight;
                                        fontFamily3 = fontFamily;
                                        j11 = j7;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j12 = j8;
                                        i33 = i5;
                                        z7 = z5;
                                        i32 = i6;
                                        i34 = i7;
                                        function13 = function1;
                                        textStyle3 = textStyle;
                                    } else {
                                        startRestartGroup.startDefaults();
                                        if ((i8 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            modifier2 = i35 != 0 ? Modifier.INSTANCE : modifier;
                                            m1501getUnspecified0d7_KjU = i12 != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
                                            m2679getUnspecifiedXSAIIZE = i13 != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j6;
                                            fontStyle2 = i14 != 0 ? null : fontStyle;
                                            fontWeight2 = i15 != 0 ? null : fontWeight;
                                            fontFamily2 = i16 != 0 ? null : fontFamily;
                                            m2679getUnspecifiedXSAIIZE2 = i17 != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j7;
                                            textDecoration2 = i18 != 0 ? null : textDecoration;
                                            textAlign2 = i19 != 0 ? null : textAlign;
                                            m2679getUnspecifiedXSAIIZE3 = i20 != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j8;
                                            m2563getClipgIe3tQ8 = i22 != 0 ? TextOverflow.INSTANCE.m2563getClipgIe3tQ8() : i5;
                                            z6 = i23 != 0 ? true : z5;
                                            i28 = i24 != 0 ? Integer.MAX_VALUE : i6;
                                            i29 = i26 == 0 ? i7 : 1;
                                            function12 = i27 == 0 ? function1 : null;
                                            TextDecoration textDecoration4 = textDecoration2;
                                            if ((i10 & 65536) != 0) {
                                                i30 = i36 & (-3670017);
                                                textStyle2 = (TextStyle) startRestartGroup.consume(LocalTextStyle);
                                                textDecoration2 = textDecoration4;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    i31 = i28;
                                                } else {
                                                    i31 = i28;
                                                    ComposerKt.traceEventStart(1028090691, i11, i30, "androidx.compose.material.Text (Text.kt:110)");
                                                }
                                                long value = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                                                float floatValue = ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                                                if (m1501getUnspecified0d7_KjU == 16) {
                                                    j9 = m1501getUnspecified0d7_KjU;
                                                } else {
                                                    j9 = m1501getUnspecified0d7_KjU;
                                                    m1501getUnspecified0d7_KjU = textStyle2.m2298getColor0d7_KjU() != 16 ? textStyle2.m2298getColor0d7_KjU() : Color.m1485copywmQWz5c$default(value, floatValue, 0.0f, 0.0f, 0.0f, 14, null);
                                                }
                                                m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                                                changed = startRestartGroup.changed(m1501getUnspecified0d7_KjU);
                                                TextDecoration textDecoration5 = textDecoration2;
                                                rememberedValue = startRestartGroup.rememberedValue();
                                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                                                        @Override // androidx.compose.ui.graphics.ColorProducer
                                                        /* renamed from: invoke-0d7_KjU */
                                                        public final long mo687invoke0d7_KjU() {
                                                            return m1501getUnspecified0d7_KjU;
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                int i37 = i30 << 9;
                                                BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, (ColorProducer) rememberedValue, startRestartGroup, (i11 & 126) | ((i30 >> 6) & 7168) | (57344 & i37) | (458752 & i37) | (3670016 & i37) | (i37 & 29360128), 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                i32 = i31;
                                                textDecoration3 = textDecoration5;
                                                textAlign3 = textAlign2;
                                                modifier3 = modifier2;
                                                i33 = m2563getClipgIe3tQ8;
                                                fontStyle3 = fontStyle2;
                                                j10 = m2679getUnspecifiedXSAIIZE;
                                                j11 = m2679getUnspecifiedXSAIIZE2;
                                                i34 = i29;
                                                z7 = z6;
                                                function13 = function12;
                                                fontFamily3 = fontFamily2;
                                                j12 = m2679getUnspecifiedXSAIIZE3;
                                                j13 = j9;
                                                FontWeight fontWeight4 = fontWeight2;
                                                textStyle3 = textStyle2;
                                                fontWeight3 = fontWeight4;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i10 & 65536) != 0) {
                                                i36 &= -3670017;
                                            }
                                            modifier2 = modifier;
                                            m1501getUnspecified0d7_KjU = j5;
                                            m2679getUnspecifiedXSAIIZE = j6;
                                            fontStyle2 = fontStyle;
                                            fontWeight2 = fontWeight;
                                            fontFamily2 = fontFamily;
                                            m2679getUnspecifiedXSAIIZE2 = j7;
                                            textDecoration2 = textDecoration;
                                            textAlign2 = textAlign;
                                            m2679getUnspecifiedXSAIIZE3 = j8;
                                            m2563getClipgIe3tQ8 = i5;
                                            z6 = z5;
                                            i28 = i6;
                                            i29 = i7;
                                            function12 = function1;
                                        }
                                        i30 = i36;
                                        textStyle2 = textStyle;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        long value2 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                                        float floatValue2 = ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                                        if (m1501getUnspecified0d7_KjU == 16) {
                                        }
                                        m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                                        changed = startRestartGroup.changed(m1501getUnspecified0d7_KjU);
                                        TextDecoration textDecoration52 = textDecoration2;
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (!changed) {
                                        }
                                        rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                                            @Override // androidx.compose.ui.graphics.ColorProducer
                                            /* renamed from: invoke-0d7_KjU */
                                            public final long mo687invoke0d7_KjU() {
                                                return m1501getUnspecified0d7_KjU;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                        int i372 = i30 << 9;
                                        BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, (ColorProducer) rememberedValue, startRestartGroup, (i11 & 126) | ((i30 >> 6) & 7168) | (57344 & i372) | (458752 & i372) | (3670016 & i372) | (i372 & 29360128), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        i32 = i31;
                                        textDecoration3 = textDecoration52;
                                        textAlign3 = textAlign2;
                                        modifier3 = modifier2;
                                        i33 = m2563getClipgIe3tQ8;
                                        fontStyle3 = fontStyle2;
                                        j10 = m2679getUnspecifiedXSAIIZE;
                                        j11 = m2679getUnspecifiedXSAIIZE2;
                                        i34 = i29;
                                        z7 = z6;
                                        function13 = function12;
                                        fontFamily3 = fontFamily2;
                                        j12 = m2679getUnspecifiedXSAIIZE3;
                                        j13 = j9;
                                        FontWeight fontWeight42 = fontWeight2;
                                        textStyle3 = textStyle2;
                                        fontWeight3 = fontWeight42;
                                    }
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$2
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

                                            public final void invoke(Composer composer2, int i38) {
                                                TextKt.m746Text4IGK_g(str, modifier3, j13, j10, fontStyle3, fontWeight3, fontFamily3, j11, textDecoration3, textAlign3, j12, i33, z7, i32, i34, function13, textStyle3, composer2, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), RecomposeScopeImplKt.updateChangedFlags(i9), i10);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i27 = i10 & 32768;
                            if (i27 != 0) {
                            }
                            if ((i9 & 1572864) == 0) {
                            }
                            if ((i11 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i8 & 1) != 0) {
                            }
                            if (i35 != 0) {
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
                            if (i17 != 0) {
                            }
                            if (i18 != 0) {
                            }
                            if (i19 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i23 != 0) {
                            }
                            if (i24 != 0) {
                            }
                            if (i26 == 0) {
                            }
                            if (i27 == 0) {
                            }
                            TextDecoration textDecoration42 = textDecoration2;
                            if ((i10 & 65536) != 0) {
                            }
                            i30 = i36;
                            textStyle2 = textStyle;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            long value22 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                            float floatValue22 = ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                            if (m1501getUnspecified0d7_KjU == 16) {
                            }
                            m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                            changed = startRestartGroup.changed(m1501getUnspecified0d7_KjU);
                            TextDecoration textDecoration522 = textDecoration2;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                                @Override // androidx.compose.ui.graphics.ColorProducer
                                /* renamed from: invoke-0d7_KjU */
                                public final long mo687invoke0d7_KjU() {
                                    return m1501getUnspecified0d7_KjU;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            int i3722 = i30 << 9;
                            BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, (ColorProducer) rememberedValue, startRestartGroup, (i11 & 126) | ((i30 >> 6) & 7168) | (57344 & i3722) | (458752 & i3722) | (3670016 & i3722) | (i3722 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i32 = i31;
                            textDecoration3 = textDecoration522;
                            textAlign3 = textAlign2;
                            modifier3 = modifier2;
                            i33 = m2563getClipgIe3tQ8;
                            fontStyle3 = fontStyle2;
                            j10 = m2679getUnspecifiedXSAIIZE;
                            j11 = m2679getUnspecifiedXSAIIZE2;
                            i34 = i29;
                            z7 = z6;
                            function13 = function12;
                            fontFamily3 = fontFamily2;
                            j12 = m2679getUnspecifiedXSAIIZE3;
                            j13 = j9;
                            FontWeight fontWeight422 = fontWeight2;
                            textStyle3 = textStyle2;
                            fontWeight3 = fontWeight422;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i25 = i10 & 16384;
                        if (i25 == 0) {
                        }
                        i27 = i10 & 32768;
                        if (i27 != 0) {
                        }
                        if ((i9 & 1572864) == 0) {
                        }
                        if ((i11 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i8 & 1) != 0) {
                        }
                        if (i35 != 0) {
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
                        if (i17 != 0) {
                        }
                        if (i18 != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i23 != 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i27 == 0) {
                        }
                        TextDecoration textDecoration422 = textDecoration2;
                        if ((i10 & 65536) != 0) {
                        }
                        i30 = i36;
                        textStyle2 = textStyle;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        long value222 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                        float floatValue222 = ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                        if (m1501getUnspecified0d7_KjU == 16) {
                        }
                        m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                        changed = startRestartGroup.changed(m1501getUnspecified0d7_KjU);
                        TextDecoration textDecoration5222 = textDecoration2;
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                            @Override // androidx.compose.ui.graphics.ColorProducer
                            /* renamed from: invoke-0d7_KjU */
                            public final long mo687invoke0d7_KjU() {
                                return m1501getUnspecified0d7_KjU;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        int i37222 = i30 << 9;
                        BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, (ColorProducer) rememberedValue, startRestartGroup, (i11 & 126) | ((i30 >> 6) & 7168) | (57344 & i37222) | (458752 & i37222) | (3670016 & i37222) | (i37222 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i32 = i31;
                        textDecoration3 = textDecoration5222;
                        textAlign3 = textAlign2;
                        modifier3 = modifier2;
                        i33 = m2563getClipgIe3tQ8;
                        fontStyle3 = fontStyle2;
                        j10 = m2679getUnspecifiedXSAIIZE;
                        j11 = m2679getUnspecifiedXSAIIZE2;
                        i34 = i29;
                        z7 = z6;
                        function13 = function12;
                        fontFamily3 = fontFamily2;
                        j12 = m2679getUnspecifiedXSAIIZE3;
                        j13 = j9;
                        FontWeight fontWeight4222 = fontWeight2;
                        textStyle3 = textStyle2;
                        fontWeight3 = fontWeight4222;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i24 = i10 & 8192;
                    if (i24 != 0) {
                    }
                    i25 = i10 & 16384;
                    if (i25 == 0) {
                    }
                    i27 = i10 & 32768;
                    if (i27 != 0) {
                    }
                    if ((i9 & 1572864) == 0) {
                    }
                    if ((i11 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i8 & 1) != 0) {
                    }
                    if (i35 != 0) {
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
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i23 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i27 == 0) {
                    }
                    TextDecoration textDecoration4222 = textDecoration2;
                    if ((i10 & 65536) != 0) {
                    }
                    i30 = i36;
                    textStyle2 = textStyle;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    long value2222 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                    float floatValue2222 = ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                    if (m1501getUnspecified0d7_KjU == 16) {
                    }
                    m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                    changed = startRestartGroup.changed(m1501getUnspecified0d7_KjU);
                    TextDecoration textDecoration52222 = textDecoration2;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                        @Override // androidx.compose.ui.graphics.ColorProducer
                        /* renamed from: invoke-0d7_KjU */
                        public final long mo687invoke0d7_KjU() {
                            return m1501getUnspecified0d7_KjU;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    int i372222 = i30 << 9;
                    BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, (ColorProducer) rememberedValue, startRestartGroup, (i11 & 126) | ((i30 >> 6) & 7168) | (57344 & i372222) | (458752 & i372222) | (3670016 & i372222) | (i372222 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i32 = i31;
                    textDecoration3 = textDecoration52222;
                    textAlign3 = textAlign2;
                    modifier3 = modifier2;
                    i33 = m2563getClipgIe3tQ8;
                    fontStyle3 = fontStyle2;
                    j10 = m2679getUnspecifiedXSAIIZE;
                    j11 = m2679getUnspecifiedXSAIIZE2;
                    i34 = i29;
                    z7 = z6;
                    function13 = function12;
                    fontFamily3 = fontFamily2;
                    j12 = m2679getUnspecifiedXSAIIZE3;
                    j13 = j9;
                    FontWeight fontWeight42222 = fontWeight2;
                    textStyle3 = textStyle2;
                    fontWeight3 = fontWeight42222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i19 = i10 & 512;
                if (i19 == 0) {
                }
                i20 = i10 & 1024;
                if (i20 == 0) {
                }
                i22 = i10 & 2048;
                if (i22 == 0) {
                }
                int i362 = i21;
                i23 = i10 & 4096;
                if (i23 == 0) {
                }
                i24 = i10 & 8192;
                if (i24 != 0) {
                }
                i25 = i10 & 16384;
                if (i25 == 0) {
                }
                i27 = i10 & 32768;
                if (i27 != 0) {
                }
                if ((i9 & 1572864) == 0) {
                }
                if ((i11 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i8 & 1) != 0) {
                }
                if (i35 != 0) {
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
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if (i19 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 != 0) {
                }
                if (i23 != 0) {
                }
                if (i24 != 0) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                TextDecoration textDecoration42222 = textDecoration2;
                if ((i10 & 65536) != 0) {
                }
                i30 = i362;
                textStyle2 = textStyle;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                long value22222 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                float floatValue22222 = ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
                if (m1501getUnspecified0d7_KjU == 16) {
                }
                m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                changed = startRestartGroup.changed(m1501getUnspecified0d7_KjU);
                TextDecoration textDecoration522222 = textDecoration2;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                    @Override // androidx.compose.ui.graphics.ColorProducer
                    /* renamed from: invoke-0d7_KjU */
                    public final long mo687invoke0d7_KjU() {
                        return m1501getUnspecified0d7_KjU;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                int i3722222 = i30 << 9;
                BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, (ColorProducer) rememberedValue, startRestartGroup, (i11 & 126) | ((i30 >> 6) & 7168) | (57344 & i3722222) | (458752 & i3722222) | (3670016 & i3722222) | (i3722222 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                i32 = i31;
                textDecoration3 = textDecoration522222;
                textAlign3 = textAlign2;
                modifier3 = modifier2;
                i33 = m2563getClipgIe3tQ8;
                fontStyle3 = fontStyle2;
                j10 = m2679getUnspecifiedXSAIIZE;
                j11 = m2679getUnspecifiedXSAIIZE2;
                i34 = i29;
                z7 = z6;
                function13 = function12;
                fontFamily3 = fontFamily2;
                j12 = m2679getUnspecifiedXSAIIZE3;
                j13 = j9;
                FontWeight fontWeight422222 = fontWeight2;
                textStyle3 = textStyle2;
                fontWeight3 = fontWeight422222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i15 = i10 & 32;
            if (i15 != 0) {
            }
            i16 = i10 & 64;
            if (i16 != 0) {
            }
            i17 = i10 & 128;
            if (i17 != 0) {
            }
            i18 = i10 & 256;
            if (i18 != 0) {
            }
            i19 = i10 & 512;
            if (i19 == 0) {
            }
            i20 = i10 & 1024;
            if (i20 == 0) {
            }
            i22 = i10 & 2048;
            if (i22 == 0) {
            }
            int i3622 = i21;
            i23 = i10 & 4096;
            if (i23 == 0) {
            }
            i24 = i10 & 8192;
            if (i24 != 0) {
            }
            i25 = i10 & 16384;
            if (i25 == 0) {
            }
            i27 = i10 & 32768;
            if (i27 != 0) {
            }
            if ((i9 & 1572864) == 0) {
            }
            if ((i11 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i8 & 1) != 0) {
            }
            if (i35 != 0) {
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
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if (i19 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 != 0) {
            }
            if (i23 != 0) {
            }
            if (i24 != 0) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            TextDecoration textDecoration422222 = textDecoration2;
            if ((i10 & 65536) != 0) {
            }
            i30 = i3622;
            textStyle2 = textStyle;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            long value222222 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
            float floatValue222222 = ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
            if (m1501getUnspecified0d7_KjU == 16) {
            }
            m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
            changed = startRestartGroup.changed(m1501getUnspecified0d7_KjU);
            TextDecoration textDecoration5222222 = textDecoration2;
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
                @Override // androidx.compose.ui.graphics.ColorProducer
                /* renamed from: invoke-0d7_KjU */
                public final long mo687invoke0d7_KjU() {
                    return m1501getUnspecified0d7_KjU;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            int i37222222 = i30 << 9;
            BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, (ColorProducer) rememberedValue, startRestartGroup, (i11 & 126) | ((i30 >> 6) & 7168) | (57344 & i37222222) | (458752 & i37222222) | (3670016 & i37222222) | (i37222222 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            i32 = i31;
            textDecoration3 = textDecoration5222222;
            textAlign3 = textAlign2;
            modifier3 = modifier2;
            i33 = m2563getClipgIe3tQ8;
            fontStyle3 = fontStyle2;
            j10 = m2679getUnspecifiedXSAIIZE;
            j11 = m2679getUnspecifiedXSAIIZE2;
            i34 = i29;
            z7 = z6;
            function13 = function12;
            fontFamily3 = fontFamily2;
            j12 = m2679getUnspecifiedXSAIIZE3;
            j13 = j9;
            FontWeight fontWeight4222222 = fontWeight2;
            textStyle3 = textStyle2;
            fontWeight3 = fontWeight4222222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i12 = i10 & 4;
        if (i12 == 0) {
        }
        i13 = i10 & 8;
        if (i13 == 0) {
        }
        i14 = i10 & 16;
        if (i14 == 0) {
        }
        i15 = i10 & 32;
        if (i15 != 0) {
        }
        i16 = i10 & 64;
        if (i16 != 0) {
        }
        i17 = i10 & 128;
        if (i17 != 0) {
        }
        i18 = i10 & 256;
        if (i18 != 0) {
        }
        i19 = i10 & 512;
        if (i19 == 0) {
        }
        i20 = i10 & 1024;
        if (i20 == 0) {
        }
        i22 = i10 & 2048;
        if (i22 == 0) {
        }
        int i36222 = i21;
        i23 = i10 & 4096;
        if (i23 == 0) {
        }
        i24 = i10 & 8192;
        if (i24 != 0) {
        }
        i25 = i10 & 16384;
        if (i25 == 0) {
        }
        i27 = i10 & 32768;
        if (i27 != 0) {
        }
        if ((i9 & 1572864) == 0) {
        }
        if ((i11 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i8 & 1) != 0) {
        }
        if (i35 != 0) {
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
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if (i19 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 != 0) {
        }
        if (i23 != 0) {
        }
        if (i24 != 0) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        TextDecoration textDecoration4222222 = textDecoration2;
        if ((i10 & 65536) != 0) {
        }
        i30 = i36222;
        textStyle2 = textStyle;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        long value2222222 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
        float floatValue2222222 = ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue();
        if (m1501getUnspecified0d7_KjU == 16) {
        }
        m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
        changed = startRestartGroup.changed(m1501getUnspecified0d7_KjU);
        TextDecoration textDecoration52222222 = textDecoration2;
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new ColorProducer() { // from class: androidx.compose.material.TextKt$Text$1$1
            @Override // androidx.compose.ui.graphics.ColorProducer
            /* renamed from: invoke-0d7_KjU */
            public final long mo687invoke0d7_KjU() {
                return m1501getUnspecified0d7_KjU;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        int i372222222 = i30 << 9;
        BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, (ColorProducer) rememberedValue, startRestartGroup, (i11 & 126) | ((i30 >> 6) & 7168) | (57344 & i372222222) | (458752 & i372222222) | (3670016 & i372222222) | (i372222222 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        i32 = i31;
        textDecoration3 = textDecoration52222222;
        textAlign3 = textAlign2;
        modifier3 = modifier2;
        i33 = m2563getClipgIe3tQ8;
        fontStyle3 = fontStyle2;
        j10 = m2679getUnspecifiedXSAIIZE;
        j11 = m2679getUnspecifiedXSAIIZE2;
        i34 = i29;
        z7 = z6;
        function13 = function12;
        fontFamily3 = fontFamily2;
        j12 = m2679getUnspecifiedXSAIIZE3;
        j13 = j9;
        FontWeight fontWeight42222222 = fontWeight2;
        textStyle3 = textStyle2;
        fontWeight3 = fontWeight42222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0280  */
    @Deprecated
    /* renamed from: Text-fLXpl1I */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m747TextfLXpl1I(final String str, Modifier modifier, long j5, long j6, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j7, TextDecoration textDecoration, TextAlign textAlign, long j8, int i5, boolean z5, int i6, Function1 function1, TextStyle textStyle, Composer composer, final int i7, final int i8, final int i9) {
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
        int i24;
        int i25;
        Modifier modifier2;
        long m1501getUnspecified0d7_KjU;
        TextAlign textAlign2;
        TextStyle textStyle2;
        long j9;
        int i26;
        boolean z6;
        int i27;
        int i28;
        Function1 function12;
        long j10;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        long j11;
        final TextDecoration textDecoration2;
        Composer composer2;
        final TextAlign textAlign3;
        final long j12;
        final int i29;
        final boolean z7;
        final int i30;
        final Function1 function13;
        final TextStyle textStyle3;
        final FontStyle fontStyle3;
        final FontWeight fontWeight3;
        final FontFamily fontFamily3;
        final Modifier modifier3;
        final long j13;
        final long j14;
        final long j15;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-366126944);
        if ((i9 & 1) != 0) {
            i10 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i10 = (startRestartGroup.changed(str) ? 4 : 2) | i7;
        } else {
            i10 = i7;
        }
        int i31 = i9 & 2;
        if (i31 != 0) {
            i10 |= 48;
        } else if ((i7 & 48) == 0) {
            i10 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i11 = i9 & 4;
            if (i11 == 0) {
                i10 |= 384;
            } else if ((i7 & 384) == 0) {
                i10 |= startRestartGroup.changed(j5) ? 256 : 128;
            }
            i12 = i9 & 8;
            if (i12 == 0) {
                i10 |= 3072;
            } else if ((i7 & 3072) == 0) {
                i10 |= startRestartGroup.changed(j6) ? 2048 : 1024;
            }
            i13 = i9 & 16;
            if (i13 == 0) {
                i10 |= 24576;
            } else if ((i7 & 24576) == 0) {
                i10 |= startRestartGroup.changed(fontStyle) ? 16384 : 8192;
                i14 = i9 & 32;
                int i32 = 65536;
                if (i14 != 0) {
                    i10 |= 196608;
                } else if ((i7 & 196608) == 0) {
                    i10 |= startRestartGroup.changed(fontWeight) ? 131072 : 65536;
                }
                i15 = i9 & 64;
                if (i15 != 0) {
                    i10 |= 1572864;
                } else if ((i7 & 1572864) == 0) {
                    i10 |= startRestartGroup.changed(fontFamily) ? 1048576 : 524288;
                }
                i16 = i9 & 128;
                if (i16 != 0) {
                    i10 |= 12582912;
                } else if ((i7 & 12582912) == 0) {
                    i10 |= startRestartGroup.changed(j7) ? 8388608 : 4194304;
                }
                i17 = i9 & 256;
                if (i17 != 0) {
                    i10 |= 100663296;
                } else if ((100663296 & i7) == 0) {
                    i10 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                    i18 = i9 & 512;
                    if (i18 == 0) {
                        i10 |= 805306368;
                    } else if ((i7 & 805306368) == 0) {
                        i10 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                    }
                    i19 = i9 & 1024;
                    if (i19 == 0) {
                        i20 = i8 | 6;
                    } else if ((i8 & 6) == 0) {
                        i20 = i8 | (startRestartGroup.changed(j8) ? 4 : 2);
                    } else {
                        i20 = i8;
                    }
                    i21 = i9 & 2048;
                    if (i21 == 0) {
                        i20 |= 48;
                    } else if ((i8 & 48) == 0) {
                        i20 |= startRestartGroup.changed(i5) ? 32 : 16;
                    }
                    int i33 = i20;
                    i22 = i9 & 4096;
                    if (i22 == 0) {
                        i33 |= 384;
                    } else if ((i8 & 384) == 0) {
                        i33 |= startRestartGroup.changed(z5) ? 256 : 128;
                        i23 = i9 & 8192;
                        if (i23 != 0) {
                            i33 |= 3072;
                        } else if ((i8 & 3072) == 0) {
                            i33 |= startRestartGroup.changed(i6) ? 2048 : 1024;
                            i24 = i9 & 16384;
                            if (i24 == 0) {
                                i33 |= 24576;
                                i25 = i24;
                            } else {
                                i25 = i24;
                                if ((i8 & 24576) == 0) {
                                    i33 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
                                    if ((i8 & 196608) == 0) {
                                        if ((i9 & 32768) == 0 && startRestartGroup.changed(textStyle)) {
                                            i32 = 131072;
                                        }
                                        i33 |= i32;
                                    }
                                    if ((i10 & 306783379) != 306783378 && (74899 & i33) == 74898 && startRestartGroup.getSkipping()) {
                                        startRestartGroup.skipToGroupEnd();
                                        modifier3 = modifier;
                                        j14 = j5;
                                        j13 = j6;
                                        fontStyle3 = fontStyle;
                                        fontWeight3 = fontWeight;
                                        fontFamily3 = fontFamily;
                                        j15 = j7;
                                        textDecoration2 = textDecoration;
                                        textAlign3 = textAlign;
                                        j12 = j8;
                                        i29 = i5;
                                        z7 = z5;
                                        i30 = i6;
                                        function13 = function1;
                                        textStyle3 = textStyle;
                                        composer2 = startRestartGroup;
                                    } else {
                                        startRestartGroup.startDefaults();
                                        if ((i7 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            modifier2 = i31 != 0 ? Modifier.INSTANCE : modifier;
                                            m1501getUnspecified0d7_KjU = i11 != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
                                            long m2679getUnspecifiedXSAIIZE = i12 != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j6;
                                            FontStyle fontStyle4 = i13 != 0 ? null : fontStyle;
                                            FontWeight fontWeight4 = i14 != 0 ? null : fontWeight;
                                            FontFamily fontFamily4 = i15 != 0 ? null : fontFamily;
                                            long m2679getUnspecifiedXSAIIZE2 = i16 != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j7;
                                            TextDecoration textDecoration3 = i17 != 0 ? null : textDecoration;
                                            textAlign2 = i18 == 0 ? textAlign : null;
                                            long m2679getUnspecifiedXSAIIZE3 = i19 != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j8;
                                            int m2563getClipgIe3tQ8 = i21 != 0 ? TextOverflow.INSTANCE.m2563getClipgIe3tQ8() : i5;
                                            boolean z8 = i22 != 0 ? true : z5;
                                            int i34 = i23 != 0 ? Integer.MAX_VALUE : i6;
                                            Function1 function14 = i25 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material.TextKt$Text$3
                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(TextLayoutResult textLayoutResult) {
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                                    invoke2(textLayoutResult);
                                                    return Unit.INSTANCE;
                                                }
                                            } : function1;
                                            TextDecoration textDecoration4 = textDecoration3;
                                            if ((i9 & 32768) != 0) {
                                                i33 &= -458753;
                                                textStyle2 = (TextStyle) startRestartGroup.consume(LocalTextStyle);
                                            } else {
                                                textStyle2 = textStyle;
                                            }
                                            j9 = m2679getUnspecifiedXSAIIZE3;
                                            i26 = m2563getClipgIe3tQ8;
                                            z6 = z8;
                                            i27 = i33;
                                            i28 = i34;
                                            function12 = function14;
                                            j10 = m2679getUnspecifiedXSAIIZE;
                                            fontStyle2 = fontStyle4;
                                            fontWeight2 = fontWeight4;
                                            fontFamily2 = fontFamily4;
                                            j11 = m2679getUnspecifiedXSAIIZE2;
                                            textDecoration2 = textDecoration4;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i9 & 32768) != 0) {
                                                i33 &= -458753;
                                            }
                                            modifier2 = modifier;
                                            m1501getUnspecified0d7_KjU = j5;
                                            j10 = j6;
                                            fontStyle2 = fontStyle;
                                            fontWeight2 = fontWeight;
                                            fontFamily2 = fontFamily;
                                            textDecoration2 = textDecoration;
                                            textAlign2 = textAlign;
                                            j9 = j8;
                                            i26 = i5;
                                            z6 = z5;
                                            i28 = i6;
                                            function12 = function1;
                                            textStyle2 = textStyle;
                                            i27 = i33;
                                            j11 = j7;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            composer2 = startRestartGroup;
                                            ComposerKt.traceEventStart(-366126944, i10, i27, "androidx.compose.material.Text (Text.kt:182)");
                                        } else {
                                            composer2 = startRestartGroup;
                                        }
                                        int i35 = i27 << 3;
                                        m746Text4IGK_g(str, modifier2, m1501getUnspecified0d7_KjU, j10, fontStyle2, fontWeight2, fontFamily2, j11, textDecoration2, textAlign2, j9, i26, z6, i28, 1, function12, textStyle2, composer2, i10 & 2147483646, (i27 & 14) | 24576 | (i27 & 112) | (i27 & 896) | (i27 & 7168) | (458752 & i35) | (i35 & 3670016), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        textAlign3 = textAlign2;
                                        j12 = j9;
                                        i29 = i26;
                                        z7 = z6;
                                        i30 = i28;
                                        function13 = function12;
                                        textStyle3 = textStyle2;
                                        FontFamily fontFamily5 = fontFamily2;
                                        fontStyle3 = fontStyle2;
                                        long j16 = j11;
                                        fontWeight3 = fontWeight2;
                                        fontFamily3 = fontFamily5;
                                        long j17 = j10;
                                        modifier3 = modifier2;
                                        j13 = j17;
                                        j14 = m1501getUnspecified0d7_KjU;
                                        j15 = j16;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt$Text$4
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i36) {
                                                TextKt.m747TextfLXpl1I(str, modifier3, j14, j13, fontStyle3, fontWeight3, fontFamily3, j15, textDecoration2, textAlign3, j12, i29, z7, i30, function13, textStyle3, composer3, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), RecomposeScopeImplKt.updateChangedFlags(i8), i9);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            if ((i8 & 196608) == 0) {
                            }
                            if ((i10 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i7 & 1) != 0) {
                            }
                            if (i31 != 0) {
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
                            if (i17 != 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i19 != 0) {
                            }
                            if (i21 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i23 != 0) {
                            }
                            if (i25 != 0) {
                            }
                            TextDecoration textDecoration42 = textDecoration3;
                            if ((i9 & 32768) != 0) {
                            }
                            j9 = m2679getUnspecifiedXSAIIZE3;
                            i26 = m2563getClipgIe3tQ8;
                            z6 = z8;
                            i27 = i33;
                            i28 = i34;
                            function12 = function14;
                            j10 = m2679getUnspecifiedXSAIIZE;
                            fontStyle2 = fontStyle4;
                            fontWeight2 = fontWeight4;
                            fontFamily2 = fontFamily4;
                            j11 = m2679getUnspecifiedXSAIIZE2;
                            textDecoration2 = textDecoration42;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i352 = i27 << 3;
                            m746Text4IGK_g(str, modifier2, m1501getUnspecified0d7_KjU, j10, fontStyle2, fontWeight2, fontFamily2, j11, textDecoration2, textAlign2, j9, i26, z6, i28, 1, function12, textStyle2, composer2, i10 & 2147483646, (i27 & 14) | 24576 | (i27 & 112) | (i27 & 896) | (i27 & 7168) | (458752 & i352) | (i352 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            textAlign3 = textAlign2;
                            j12 = j9;
                            i29 = i26;
                            z7 = z6;
                            i30 = i28;
                            function13 = function12;
                            textStyle3 = textStyle2;
                            FontFamily fontFamily52 = fontFamily2;
                            fontStyle3 = fontStyle2;
                            long j162 = j11;
                            fontWeight3 = fontWeight2;
                            fontFamily3 = fontFamily52;
                            long j172 = j10;
                            modifier3 = modifier2;
                            j13 = j172;
                            j14 = m1501getUnspecified0d7_KjU;
                            j15 = j162;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i24 = i9 & 16384;
                        if (i24 == 0) {
                        }
                        if ((i8 & 196608) == 0) {
                        }
                        if ((i10 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i7 & 1) != 0) {
                        }
                        if (i31 != 0) {
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
                        if (i17 != 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i23 != 0) {
                        }
                        if (i25 != 0) {
                        }
                        TextDecoration textDecoration422 = textDecoration3;
                        if ((i9 & 32768) != 0) {
                        }
                        j9 = m2679getUnspecifiedXSAIIZE3;
                        i26 = m2563getClipgIe3tQ8;
                        z6 = z8;
                        i27 = i33;
                        i28 = i34;
                        function12 = function14;
                        j10 = m2679getUnspecifiedXSAIIZE;
                        fontStyle2 = fontStyle4;
                        fontWeight2 = fontWeight4;
                        fontFamily2 = fontFamily4;
                        j11 = m2679getUnspecifiedXSAIIZE2;
                        textDecoration2 = textDecoration422;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i3522 = i27 << 3;
                        m746Text4IGK_g(str, modifier2, m1501getUnspecified0d7_KjU, j10, fontStyle2, fontWeight2, fontFamily2, j11, textDecoration2, textAlign2, j9, i26, z6, i28, 1, function12, textStyle2, composer2, i10 & 2147483646, (i27 & 14) | 24576 | (i27 & 112) | (i27 & 896) | (i27 & 7168) | (458752 & i3522) | (i3522 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        textAlign3 = textAlign2;
                        j12 = j9;
                        i29 = i26;
                        z7 = z6;
                        i30 = i28;
                        function13 = function12;
                        textStyle3 = textStyle2;
                        FontFamily fontFamily522 = fontFamily2;
                        fontStyle3 = fontStyle2;
                        long j1622 = j11;
                        fontWeight3 = fontWeight2;
                        fontFamily3 = fontFamily522;
                        long j1722 = j10;
                        modifier3 = modifier2;
                        j13 = j1722;
                        j14 = m1501getUnspecified0d7_KjU;
                        j15 = j1622;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i23 = i9 & 8192;
                    if (i23 != 0) {
                    }
                    i24 = i9 & 16384;
                    if (i24 == 0) {
                    }
                    if ((i8 & 196608) == 0) {
                    }
                    if ((i10 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i7 & 1) != 0) {
                    }
                    if (i31 != 0) {
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
                    if (i17 != 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i23 != 0) {
                    }
                    if (i25 != 0) {
                    }
                    TextDecoration textDecoration4222 = textDecoration3;
                    if ((i9 & 32768) != 0) {
                    }
                    j9 = m2679getUnspecifiedXSAIIZE3;
                    i26 = m2563getClipgIe3tQ8;
                    z6 = z8;
                    i27 = i33;
                    i28 = i34;
                    function12 = function14;
                    j10 = m2679getUnspecifiedXSAIIZE;
                    fontStyle2 = fontStyle4;
                    fontWeight2 = fontWeight4;
                    fontFamily2 = fontFamily4;
                    j11 = m2679getUnspecifiedXSAIIZE2;
                    textDecoration2 = textDecoration4222;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i35222 = i27 << 3;
                    m746Text4IGK_g(str, modifier2, m1501getUnspecified0d7_KjU, j10, fontStyle2, fontWeight2, fontFamily2, j11, textDecoration2, textAlign2, j9, i26, z6, i28, 1, function12, textStyle2, composer2, i10 & 2147483646, (i27 & 14) | 24576 | (i27 & 112) | (i27 & 896) | (i27 & 7168) | (458752 & i35222) | (i35222 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    textAlign3 = textAlign2;
                    j12 = j9;
                    i29 = i26;
                    z7 = z6;
                    i30 = i28;
                    function13 = function12;
                    textStyle3 = textStyle2;
                    FontFamily fontFamily5222 = fontFamily2;
                    fontStyle3 = fontStyle2;
                    long j16222 = j11;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily5222;
                    long j17222 = j10;
                    modifier3 = modifier2;
                    j13 = j17222;
                    j14 = m1501getUnspecified0d7_KjU;
                    j15 = j16222;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i18 = i9 & 512;
                if (i18 == 0) {
                }
                i19 = i9 & 1024;
                if (i19 == 0) {
                }
                i21 = i9 & 2048;
                if (i21 == 0) {
                }
                int i332 = i20;
                i22 = i9 & 4096;
                if (i22 == 0) {
                }
                i23 = i9 & 8192;
                if (i23 != 0) {
                }
                i24 = i9 & 16384;
                if (i24 == 0) {
                }
                if ((i8 & 196608) == 0) {
                }
                if ((i10 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i7 & 1) != 0) {
                }
                if (i31 != 0) {
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
                if (i17 != 0) {
                }
                if (i18 == 0) {
                }
                if (i19 != 0) {
                }
                if (i21 != 0) {
                }
                if (i22 != 0) {
                }
                if (i23 != 0) {
                }
                if (i25 != 0) {
                }
                TextDecoration textDecoration42222 = textDecoration3;
                if ((i9 & 32768) != 0) {
                }
                j9 = m2679getUnspecifiedXSAIIZE3;
                i26 = m2563getClipgIe3tQ8;
                z6 = z8;
                i27 = i332;
                i28 = i34;
                function12 = function14;
                j10 = m2679getUnspecifiedXSAIIZE;
                fontStyle2 = fontStyle4;
                fontWeight2 = fontWeight4;
                fontFamily2 = fontFamily4;
                j11 = m2679getUnspecifiedXSAIIZE2;
                textDecoration2 = textDecoration42222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i352222 = i27 << 3;
                m746Text4IGK_g(str, modifier2, m1501getUnspecified0d7_KjU, j10, fontStyle2, fontWeight2, fontFamily2, j11, textDecoration2, textAlign2, j9, i26, z6, i28, 1, function12, textStyle2, composer2, i10 & 2147483646, (i27 & 14) | 24576 | (i27 & 112) | (i27 & 896) | (i27 & 7168) | (458752 & i352222) | (i352222 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                textAlign3 = textAlign2;
                j12 = j9;
                i29 = i26;
                z7 = z6;
                i30 = i28;
                function13 = function12;
                textStyle3 = textStyle2;
                FontFamily fontFamily52222 = fontFamily2;
                fontStyle3 = fontStyle2;
                long j162222 = j11;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily52222;
                long j172222 = j10;
                modifier3 = modifier2;
                j13 = j172222;
                j14 = m1501getUnspecified0d7_KjU;
                j15 = j162222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i14 = i9 & 32;
            int i322 = 65536;
            if (i14 != 0) {
            }
            i15 = i9 & 64;
            if (i15 != 0) {
            }
            i16 = i9 & 128;
            if (i16 != 0) {
            }
            i17 = i9 & 256;
            if (i17 != 0) {
            }
            i18 = i9 & 512;
            if (i18 == 0) {
            }
            i19 = i9 & 1024;
            if (i19 == 0) {
            }
            i21 = i9 & 2048;
            if (i21 == 0) {
            }
            int i3322 = i20;
            i22 = i9 & 4096;
            if (i22 == 0) {
            }
            i23 = i9 & 8192;
            if (i23 != 0) {
            }
            i24 = i9 & 16384;
            if (i24 == 0) {
            }
            if ((i8 & 196608) == 0) {
            }
            if ((i10 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i7 & 1) != 0) {
            }
            if (i31 != 0) {
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
            if (i17 != 0) {
            }
            if (i18 == 0) {
            }
            if (i19 != 0) {
            }
            if (i21 != 0) {
            }
            if (i22 != 0) {
            }
            if (i23 != 0) {
            }
            if (i25 != 0) {
            }
            TextDecoration textDecoration422222 = textDecoration3;
            if ((i9 & 32768) != 0) {
            }
            j9 = m2679getUnspecifiedXSAIIZE3;
            i26 = m2563getClipgIe3tQ8;
            z6 = z8;
            i27 = i3322;
            i28 = i34;
            function12 = function14;
            j10 = m2679getUnspecifiedXSAIIZE;
            fontStyle2 = fontStyle4;
            fontWeight2 = fontWeight4;
            fontFamily2 = fontFamily4;
            j11 = m2679getUnspecifiedXSAIIZE2;
            textDecoration2 = textDecoration422222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i3522222 = i27 << 3;
            m746Text4IGK_g(str, modifier2, m1501getUnspecified0d7_KjU, j10, fontStyle2, fontWeight2, fontFamily2, j11, textDecoration2, textAlign2, j9, i26, z6, i28, 1, function12, textStyle2, composer2, i10 & 2147483646, (i27 & 14) | 24576 | (i27 & 112) | (i27 & 896) | (i27 & 7168) | (458752 & i3522222) | (i3522222 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            textAlign3 = textAlign2;
            j12 = j9;
            i29 = i26;
            z7 = z6;
            i30 = i28;
            function13 = function12;
            textStyle3 = textStyle2;
            FontFamily fontFamily522222 = fontFamily2;
            fontStyle3 = fontStyle2;
            long j1622222 = j11;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily522222;
            long j1722222 = j10;
            modifier3 = modifier2;
            j13 = j1722222;
            j14 = m1501getUnspecified0d7_KjU;
            j15 = j1622222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i11 = i9 & 4;
        if (i11 == 0) {
        }
        i12 = i9 & 8;
        if (i12 == 0) {
        }
        i13 = i9 & 16;
        if (i13 == 0) {
        }
        i14 = i9 & 32;
        int i3222 = 65536;
        if (i14 != 0) {
        }
        i15 = i9 & 64;
        if (i15 != 0) {
        }
        i16 = i9 & 128;
        if (i16 != 0) {
        }
        i17 = i9 & 256;
        if (i17 != 0) {
        }
        i18 = i9 & 512;
        if (i18 == 0) {
        }
        i19 = i9 & 1024;
        if (i19 == 0) {
        }
        i21 = i9 & 2048;
        if (i21 == 0) {
        }
        int i33222 = i20;
        i22 = i9 & 4096;
        if (i22 == 0) {
        }
        i23 = i9 & 8192;
        if (i23 != 0) {
        }
        i24 = i9 & 16384;
        if (i24 == 0) {
        }
        if ((i8 & 196608) == 0) {
        }
        if ((i10 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i7 & 1) != 0) {
        }
        if (i31 != 0) {
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
        if (i17 != 0) {
        }
        if (i18 == 0) {
        }
        if (i19 != 0) {
        }
        if (i21 != 0) {
        }
        if (i22 != 0) {
        }
        if (i23 != 0) {
        }
        if (i25 != 0) {
        }
        TextDecoration textDecoration4222222 = textDecoration3;
        if ((i9 & 32768) != 0) {
        }
        j9 = m2679getUnspecifiedXSAIIZE3;
        i26 = m2563getClipgIe3tQ8;
        z6 = z8;
        i27 = i33222;
        i28 = i34;
        function12 = function14;
        j10 = m2679getUnspecifiedXSAIIZE;
        fontStyle2 = fontStyle4;
        fontWeight2 = fontWeight4;
        fontFamily2 = fontFamily4;
        j11 = m2679getUnspecifiedXSAIIZE2;
        textDecoration2 = textDecoration4222222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i35222222 = i27 << 3;
        m746Text4IGK_g(str, modifier2, m1501getUnspecified0d7_KjU, j10, fontStyle2, fontWeight2, fontFamily2, j11, textDecoration2, textAlign2, j9, i26, z6, i28, 1, function12, textStyle2, composer2, i10 & 2147483646, (i27 & 14) | 24576 | (i27 & 112) | (i27 & 896) | (i27 & 7168) | (458752 & i35222222) | (i35222222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        textAlign3 = textAlign2;
        j12 = j9;
        i29 = i26;
        z7 = z6;
        i30 = i28;
        function13 = function12;
        textStyle3 = textStyle2;
        FontFamily fontFamily5222222 = fontFamily2;
        fontStyle3 = fontStyle2;
        long j16222222 = j11;
        fontWeight3 = fontWeight2;
        fontFamily3 = fontFamily5222222;
        long j17222222 = j10;
        modifier3 = modifier2;
        j13 = j17222222;
        j14 = m1501getUnspecified0d7_KjU;
        j15 = j16222222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }
}
