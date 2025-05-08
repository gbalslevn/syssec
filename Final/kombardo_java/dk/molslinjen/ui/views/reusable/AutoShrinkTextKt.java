package dk.molslinjen.ui.views.reusable;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.views.reusable.AutoShrinkTextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a·\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 ¨\u0006!²\u0006\n\u0010\"\u001a\u00020\u001eX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u0007X\u008a\u008e\u0002"}, d2 = {"AutoShrinkText", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "modifier", "Landroidx/compose/ui/Modifier;", "autoShrink", BuildConfig.FLAVOR, "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "maxLines", BuildConfig.FLAVOR, "style", "Landroidx/compose/ui/text/TextStyle;", "AutoShrinkText-woKQQ-c", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILandroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "app_kombardoProd", "textStyle", "readyToDraw"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AutoShrinkTextKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0459  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0386  */
    /* renamed from: AutoShrinkText-woKQQ-c, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3384AutoShrinkTextwoKQQc(final String text, Modifier modifier, boolean z5, long j5, long j6, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j7, TextDecoration textDecoration, TextAlign textAlign, long j8, int i5, boolean z6, int i6, TextStyle textStyle, Composer composer, final int i7, final int i8, final int i9) {
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
        int i26;
        long m2679getUnspecifiedXSAIIZE;
        FontFamily fontFamily2;
        TextDecoration textDecoration2;
        TextAlign textAlign2;
        Modifier modifier2;
        long j9;
        int i27;
        boolean z7;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        int i28;
        long j10;
        final TextStyle textStyle2;
        final boolean z8;
        long j11;
        int i29;
        boolean z9;
        Object rememberedValue;
        MutableState mutableStateOf$default;
        final MutableState mutableState;
        Object rememberedValue2;
        Composer.Companion companion;
        final MutableState mutableState2;
        Object rememberedValue3;
        boolean z10;
        Object rememberedValue4;
        Composer composer2;
        final long j12;
        final TextStyle textStyle3;
        final FontStyle fontStyle3;
        final boolean z11;
        final Modifier modifier3;
        final long j13;
        final FontWeight fontWeight3;
        final FontFamily fontFamily3;
        final long j14;
        final TextDecoration textDecoration3;
        final TextAlign textAlign3;
        final long j15;
        final int i30;
        final boolean z12;
        final int i31;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(883672358);
        if ((i9 & 1) != 0) {
            i10 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i10 = (startRestartGroup.changed(text) ? 4 : 2) | i7;
        } else {
            i10 = i7;
        }
        int i32 = i9 & 2;
        if (i32 != 0) {
            i10 |= 48;
        } else if ((i7 & 48) == 0) {
            i10 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i11 = i9 & 4;
            if (i11 == 0) {
                i10 |= 384;
            } else if ((i7 & 384) == 0) {
                i10 |= startRestartGroup.changed(z5) ? 256 : 128;
                i12 = i9 & 8;
                if (i12 != 0) {
                    i10 |= 3072;
                } else if ((i7 & 3072) == 0) {
                    i10 |= startRestartGroup.changed(j5) ? 2048 : 1024;
                }
                i13 = i9 & 16;
                if (i13 != 0) {
                    i10 |= 24576;
                } else if ((i7 & 24576) == 0) {
                    i10 |= startRestartGroup.changed(j6) ? 16384 : 8192;
                }
                i14 = i9 & 32;
                if (i14 != 0) {
                    i10 |= 196608;
                } else if ((i7 & 196608) == 0) {
                    i10 |= startRestartGroup.changed(fontStyle) ? 131072 : 65536;
                }
                i15 = i9 & 64;
                if (i15 != 0) {
                    i10 |= 1572864;
                } else if ((i7 & 1572864) == 0) {
                    i10 |= startRestartGroup.changed(fontWeight) ? 1048576 : 524288;
                }
                i16 = i9 & 128;
                if (i16 != 0) {
                    i10 |= 12582912;
                } else if ((i7 & 12582912) == 0) {
                    i10 |= startRestartGroup.changed(fontFamily) ? 8388608 : 4194304;
                }
                i17 = i9 & 256;
                if (i17 != 0) {
                    i10 |= 100663296;
                } else if ((i7 & 100663296) == 0) {
                    i10 |= startRestartGroup.changed(j7) ? 67108864 : 33554432;
                }
                i18 = i9 & 512;
                if (i18 != 0) {
                    i10 |= 805306368;
                } else if ((i7 & 805306368) == 0) {
                    i10 |= startRestartGroup.changed(textDecoration) ? 536870912 : 268435456;
                }
                i19 = i9 & 1024;
                if (i19 != 0) {
                    i20 = i8 | 6;
                } else if ((i8 & 6) == 0) {
                    i20 = i8 | (startRestartGroup.changed(textAlign) ? 4 : 2);
                } else {
                    i20 = i8;
                }
                i21 = i9 & 2048;
                if (i21 != 0) {
                    i20 |= 48;
                } else if ((i8 & 48) == 0) {
                    i20 |= startRestartGroup.changed(j8) ? 32 : 16;
                }
                i22 = i20;
                i23 = i9 & 4096;
                if (i23 != 0) {
                    i22 |= 384;
                } else if ((i8 & 384) == 0) {
                    i22 |= startRestartGroup.changed(i5) ? 256 : 128;
                    i24 = i9 & 8192;
                    if (i24 == 0) {
                        i22 |= 3072;
                    } else if ((i8 & 3072) == 0) {
                        i22 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                        i25 = i9 & 16384;
                        if (i25 != 0) {
                            i22 |= 24576;
                            i26 = i25;
                        } else {
                            i26 = i25;
                            if ((i8 & 24576) == 0) {
                                i22 |= startRestartGroup.changed(i6) ? 16384 : 8192;
                                if ((i8 & 196608) == 0) {
                                    i22 |= ((i9 & 32768) == 0 && startRestartGroup.changed(textStyle)) ? 131072 : 65536;
                                }
                                if ((i10 & 306783379) != 306783378 && (74899 & i22) == 74898 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier3 = modifier;
                                    z11 = z5;
                                    j12 = j5;
                                    j13 = j6;
                                    fontStyle3 = fontStyle;
                                    fontWeight3 = fontWeight;
                                    fontFamily3 = fontFamily;
                                    textDecoration3 = textDecoration;
                                    textAlign3 = textAlign;
                                    j15 = j8;
                                    i30 = i5;
                                    z12 = z6;
                                    i31 = i6;
                                    textStyle3 = textStyle;
                                    composer2 = startRestartGroup;
                                    j14 = j7;
                                } else {
                                    startRestartGroup.startDefaults();
                                    boolean z13 = true;
                                    if ((i7 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier modifier4 = i32 == 0 ? Modifier.INSTANCE : modifier;
                                        boolean z14 = i11 == 0 ? true : z5;
                                        long m1501getUnspecified0d7_KjU = i12 == 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
                                        m2679getUnspecifiedXSAIIZE = i13 == 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j6;
                                        FontStyle fontStyle4 = i14 == 0 ? null : fontStyle;
                                        FontWeight fontWeight4 = i15 == 0 ? null : fontWeight;
                                        FontFamily fontFamily4 = i16 == 0 ? null : fontFamily;
                                        long m2679getUnspecifiedXSAIIZE2 = i17 == 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j7;
                                        TextDecoration textDecoration4 = i18 == 0 ? null : textDecoration;
                                        TextAlign textAlign4 = i19 == 0 ? null : textAlign;
                                        long m2679getUnspecifiedXSAIIZE3 = i21 == 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j8;
                                        int m2563getClipgIe3tQ8 = i23 == 0 ? TextOverflow.INSTANCE.m2563getClipgIe3tQ8() : i5;
                                        boolean z15 = i24 == 0 ? true : z6;
                                        int i33 = i26 == 0 ? Integer.MAX_VALUE : i6;
                                        if ((i9 & 32768) == 0) {
                                            i22 &= -458753;
                                            fontFamily2 = fontFamily4;
                                            textDecoration2 = textDecoration4;
                                            textAlign2 = textAlign4;
                                            j9 = m2679getUnspecifiedXSAIIZE3;
                                            i27 = m2563getClipgIe3tQ8;
                                            z7 = z15;
                                            fontStyle2 = fontStyle4;
                                            textStyle2 = (TextStyle) startRestartGroup.consume(TextKt.getLocalTextStyle());
                                            fontWeight2 = fontWeight4;
                                            i28 = i33;
                                            j10 = m2679getUnspecifiedXSAIIZE2;
                                            modifier2 = modifier4;
                                        } else {
                                            fontFamily2 = fontFamily4;
                                            textDecoration2 = textDecoration4;
                                            textAlign2 = textAlign4;
                                            modifier2 = modifier4;
                                            j9 = m2679getUnspecifiedXSAIIZE3;
                                            i27 = m2563getClipgIe3tQ8;
                                            z7 = z15;
                                            fontStyle2 = fontStyle4;
                                            fontWeight2 = fontWeight4;
                                            i28 = i33;
                                            j10 = m2679getUnspecifiedXSAIIZE2;
                                            textStyle2 = textStyle;
                                        }
                                        z8 = z14;
                                        j11 = m1501getUnspecified0d7_KjU;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i9 & 32768) != 0) {
                                            i22 &= -458753;
                                        }
                                        modifier2 = modifier;
                                        z8 = z5;
                                        j11 = j5;
                                        m2679getUnspecifiedXSAIIZE = j6;
                                        fontStyle2 = fontStyle;
                                        fontWeight2 = fontWeight;
                                        fontFamily2 = fontFamily;
                                        j10 = j7;
                                        textDecoration2 = textDecoration;
                                        textAlign2 = textAlign;
                                        j9 = j8;
                                        i27 = i5;
                                        z7 = z6;
                                        i28 = i6;
                                        textStyle2 = textStyle;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(883672358, i10, i22, "dk.molslinjen.ui.views.reusable.AutoShrinkText (AutoShrinkText.kt:36)");
                                    }
                                    startRestartGroup.startReplaceGroup(1983078003);
                                    i29 = (458752 & i22) ^ 196608;
                                    z9 = (i29 <= 131072 && startRestartGroup.changed(textStyle2)) || (i22 & 196608) == 131072;
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!z9 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textStyle2, null, 2, null);
                                        startRestartGroup.updateRememberedValue(mutableStateOf$default);
                                        rememberedValue = mutableStateOf$default;
                                    }
                                    mutableState = (MutableState) rememberedValue;
                                    startRestartGroup.endReplaceGroup();
                                    startRestartGroup.startReplaceGroup(1983080076);
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue2 == companion.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    mutableState2 = (MutableState) rememberedValue2;
                                    startRestartGroup.endReplaceGroup();
                                    TextStyle AutoShrinkText_woKQQ_c$lambda$1 = !z8 ? AutoShrinkText_woKQQ_c$lambda$1(mutableState) : textStyle2;
                                    startRestartGroup.startReplaceGroup(1983095828);
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (rememberedValue3 == companion.getEmpty()) {
                                        rememberedValue3 = new Function1() { // from class: W1.b
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                Modifier AutoShrinkText_woKQQ_c$lambda$8$lambda$7;
                                                AutoShrinkText_woKQQ_c$lambda$8$lambda$7 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$8$lambda$7(MutableState.this, (Modifier) obj);
                                                return AutoShrinkText_woKQQ_c$lambda$8$lambda$7;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    Modifier applyIf = ModifierExtensionsKt.applyIf(modifier2, z8, (Function1) rememberedValue3);
                                    int i34 = !z8 ? 1 : i28;
                                    boolean z16 = !z8 ? false : z7;
                                    startRestartGroup.startReplaceGroup(1983102672);
                                    boolean changed = ((i10 & 896) != 256) | startRestartGroup.changed(mutableState);
                                    if ((i29 > 131072 || !startRestartGroup.changed(textStyle2)) && (i22 & 196608) != 131072) {
                                        z13 = false;
                                    }
                                    z10 = changed | z13;
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (!z10 || rememberedValue4 == companion.getEmpty()) {
                                        rememberedValue4 = new Function1() { // from class: W1.c
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                Unit AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                                                AutoShrinkText_woKQQ_c$lambda$10$lambda$9 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$10$lambda$9(z8, textStyle2, mutableState, mutableState2, (TextLayoutResult) obj);
                                                return AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    int i35 = i10 & 14;
                                    int i36 = i10 >> 3;
                                    TextStyle textStyle4 = textStyle2;
                                    composer2 = startRestartGroup;
                                    boolean z17 = z8;
                                    Modifier modifier5 = modifier2;
                                    TextKt.m940Text4IGK_g(text, applyIf, j11, m2679getUnspecifiedXSAIIZE, fontStyle2, fontWeight2, fontFamily2, j10, textDecoration2, textAlign2, j9, i27, z16, i34, 0, (Function1) rememberedValue4, AutoShrinkText_woKQQ_c$lambda$1, composer2, i35 | (i36 & 896) | (i36 & 7168) | (57344 & i36) | (458752 & i36) | (3670016 & i36) | (29360128 & i36) | (i36 & 234881024) | ((i22 << 27) & 1879048192), (i22 >> 3) & 126, 16384);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    j12 = j11;
                                    textStyle3 = textStyle4;
                                    fontStyle3 = fontStyle2;
                                    z11 = z17;
                                    modifier3 = modifier5;
                                    j13 = m2679getUnspecifiedXSAIIZE;
                                    fontWeight3 = fontWeight2;
                                    fontFamily3 = fontFamily2;
                                    j14 = j10;
                                    textDecoration3 = textDecoration2;
                                    textAlign3 = textAlign2;
                                    j15 = j9;
                                    i30 = i27;
                                    z12 = z7;
                                    i31 = i28;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: W1.d
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit AutoShrinkText_woKQQ_c$lambda$11;
                                            AutoShrinkText_woKQQ_c$lambda$11 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$11(text, modifier3, z11, j12, j13, fontStyle3, fontWeight3, fontFamily3, j14, textDecoration3, textAlign3, j15, i30, z12, i31, textStyle3, i7, i8, i9, (Composer) obj, ((Integer) obj2).intValue());
                                            return AutoShrinkText_woKQQ_c$lambda$11;
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
                        boolean z132 = true;
                        if ((i7 & 1) != 0) {
                        }
                        if (i32 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if (i23 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if ((i9 & 32768) == 0) {
                        }
                        z8 = z14;
                        j11 = m1501getUnspecified0d7_KjU;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceGroup(1983078003);
                        i29 = (458752 & i22) ^ 196608;
                        if (i29 <= 131072) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z9) {
                        }
                        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textStyle2, null, 2, null);
                        startRestartGroup.updateRememberedValue(mutableStateOf$default);
                        rememberedValue = mutableStateOf$default;
                        mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(1983080076);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue2 == companion.getEmpty()) {
                        }
                        mutableState2 = (MutableState) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        if (!z8) {
                        }
                        startRestartGroup.startReplaceGroup(1983095828);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == companion.getEmpty()) {
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier applyIf2 = ModifierExtensionsKt.applyIf(modifier2, z8, (Function1) rememberedValue3);
                        if (!z8) {
                        }
                        if (!z8) {
                        }
                        startRestartGroup.startReplaceGroup(1983102672);
                        boolean changed2 = ((i10 & 896) != 256) | startRestartGroup.changed(mutableState);
                        if (i29 > 131072) {
                        }
                        z132 = false;
                        z10 = changed2 | z132;
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!z10) {
                        }
                        rememberedValue4 = new Function1() { // from class: W1.c
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                                AutoShrinkText_woKQQ_c$lambda$10$lambda$9 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$10$lambda$9(z8, textStyle2, mutableState, mutableState2, (TextLayoutResult) obj);
                                return AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceGroup();
                        int i352 = i10 & 14;
                        int i362 = i10 >> 3;
                        TextStyle textStyle42 = textStyle2;
                        composer2 = startRestartGroup;
                        boolean z172 = z8;
                        Modifier modifier52 = modifier2;
                        TextKt.m940Text4IGK_g(text, applyIf2, j11, m2679getUnspecifiedXSAIIZE, fontStyle2, fontWeight2, fontFamily2, j10, textDecoration2, textAlign2, j9, i27, z16, i34, 0, (Function1) rememberedValue4, AutoShrinkText_woKQQ_c$lambda$1, composer2, i352 | (i362 & 896) | (i362 & 7168) | (57344 & i362) | (458752 & i362) | (3670016 & i362) | (29360128 & i362) | (i362 & 234881024) | ((i22 << 27) & 1879048192), (i22 >> 3) & 126, 16384);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j12 = j11;
                        textStyle3 = textStyle42;
                        fontStyle3 = fontStyle2;
                        z11 = z172;
                        modifier3 = modifier52;
                        j13 = m2679getUnspecifiedXSAIIZE;
                        fontWeight3 = fontWeight2;
                        fontFamily3 = fontFamily2;
                        j14 = j10;
                        textDecoration3 = textDecoration2;
                        textAlign3 = textAlign2;
                        j15 = j9;
                        i30 = i27;
                        z12 = z7;
                        i31 = i28;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i25 = i9 & 16384;
                    if (i25 != 0) {
                    }
                    if ((i8 & 196608) == 0) {
                    }
                    if ((i10 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    boolean z1322 = true;
                    if ((i7 & 1) != 0) {
                    }
                    if (i32 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if (i23 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if ((i9 & 32768) == 0) {
                    }
                    z8 = z14;
                    j11 = m1501getUnspecified0d7_KjU;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(1983078003);
                    i29 = (458752 & i22) ^ 196608;
                    if (i29 <= 131072) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z9) {
                    }
                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textStyle2, null, 2, null);
                    startRestartGroup.updateRememberedValue(mutableStateOf$default);
                    rememberedValue = mutableStateOf$default;
                    mutableState = (MutableState) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(1983080076);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    mutableState2 = (MutableState) rememberedValue2;
                    startRestartGroup.endReplaceGroup();
                    if (!z8) {
                    }
                    startRestartGroup.startReplaceGroup(1983095828);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier applyIf22 = ModifierExtensionsKt.applyIf(modifier2, z8, (Function1) rememberedValue3);
                    if (!z8) {
                    }
                    if (!z8) {
                    }
                    startRestartGroup.startReplaceGroup(1983102672);
                    boolean changed22 = ((i10 & 896) != 256) | startRestartGroup.changed(mutableState);
                    if (i29 > 131072) {
                    }
                    z1322 = false;
                    z10 = changed22 | z1322;
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!z10) {
                    }
                    rememberedValue4 = new Function1() { // from class: W1.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                            AutoShrinkText_woKQQ_c$lambda$10$lambda$9 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$10$lambda$9(z8, textStyle2, mutableState, mutableState2, (TextLayoutResult) obj);
                            return AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceGroup();
                    int i3522 = i10 & 14;
                    int i3622 = i10 >> 3;
                    TextStyle textStyle422 = textStyle2;
                    composer2 = startRestartGroup;
                    boolean z1722 = z8;
                    Modifier modifier522 = modifier2;
                    TextKt.m940Text4IGK_g(text, applyIf22, j11, m2679getUnspecifiedXSAIIZE, fontStyle2, fontWeight2, fontFamily2, j10, textDecoration2, textAlign2, j9, i27, z16, i34, 0, (Function1) rememberedValue4, AutoShrinkText_woKQQ_c$lambda$1, composer2, i3522 | (i3622 & 896) | (i3622 & 7168) | (57344 & i3622) | (458752 & i3622) | (3670016 & i3622) | (29360128 & i3622) | (i3622 & 234881024) | ((i22 << 27) & 1879048192), (i22 >> 3) & 126, 16384);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j12 = j11;
                    textStyle3 = textStyle422;
                    fontStyle3 = fontStyle2;
                    z11 = z1722;
                    modifier3 = modifier522;
                    j13 = m2679getUnspecifiedXSAIIZE;
                    fontWeight3 = fontWeight2;
                    fontFamily3 = fontFamily2;
                    j14 = j10;
                    textDecoration3 = textDecoration2;
                    textAlign3 = textAlign2;
                    j15 = j9;
                    i30 = i27;
                    z12 = z7;
                    i31 = i28;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i24 = i9 & 8192;
                if (i24 == 0) {
                }
                i25 = i9 & 16384;
                if (i25 != 0) {
                }
                if ((i8 & 196608) == 0) {
                }
                if ((i10 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                boolean z13222 = true;
                if ((i7 & 1) != 0) {
                }
                if (i32 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                if (i17 == 0) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (i21 == 0) {
                }
                if (i23 == 0) {
                }
                if (i24 == 0) {
                }
                if (i26 == 0) {
                }
                if ((i9 & 32768) == 0) {
                }
                z8 = z14;
                j11 = m1501getUnspecified0d7_KjU;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(1983078003);
                i29 = (458752 & i22) ^ 196608;
                if (i29 <= 131072) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z9) {
                }
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textStyle2, null, 2, null);
                startRestartGroup.updateRememberedValue(mutableStateOf$default);
                rememberedValue = mutableStateOf$default;
                mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1983080076);
                rememberedValue2 = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue2 == companion.getEmpty()) {
                }
                mutableState2 = (MutableState) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                if (!z8) {
                }
                startRestartGroup.startReplaceGroup(1983095828);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier applyIf222 = ModifierExtensionsKt.applyIf(modifier2, z8, (Function1) rememberedValue3);
                if (!z8) {
                }
                if (!z8) {
                }
                startRestartGroup.startReplaceGroup(1983102672);
                boolean changed222 = ((i10 & 896) != 256) | startRestartGroup.changed(mutableState);
                if (i29 > 131072) {
                }
                z13222 = false;
                z10 = changed222 | z13222;
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!z10) {
                }
                rememberedValue4 = new Function1() { // from class: W1.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                        AutoShrinkText_woKQQ_c$lambda$10$lambda$9 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$10$lambda$9(z8, textStyle2, mutableState, mutableState2, (TextLayoutResult) obj);
                        return AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceGroup();
                int i35222 = i10 & 14;
                int i36222 = i10 >> 3;
                TextStyle textStyle4222 = textStyle2;
                composer2 = startRestartGroup;
                boolean z17222 = z8;
                Modifier modifier5222 = modifier2;
                TextKt.m940Text4IGK_g(text, applyIf222, j11, m2679getUnspecifiedXSAIIZE, fontStyle2, fontWeight2, fontFamily2, j10, textDecoration2, textAlign2, j9, i27, z16, i34, 0, (Function1) rememberedValue4, AutoShrinkText_woKQQ_c$lambda$1, composer2, i35222 | (i36222 & 896) | (i36222 & 7168) | (57344 & i36222) | (458752 & i36222) | (3670016 & i36222) | (29360128 & i36222) | (i36222 & 234881024) | ((i22 << 27) & 1879048192), (i22 >> 3) & 126, 16384);
                if (ComposerKt.isTraceInProgress()) {
                }
                j12 = j11;
                textStyle3 = textStyle4222;
                fontStyle3 = fontStyle2;
                z11 = z17222;
                modifier3 = modifier5222;
                j13 = m2679getUnspecifiedXSAIIZE;
                fontWeight3 = fontWeight2;
                fontFamily3 = fontFamily2;
                j14 = j10;
                textDecoration3 = textDecoration2;
                textAlign3 = textAlign2;
                j15 = j9;
                i30 = i27;
                z12 = z7;
                i31 = i28;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i12 = i9 & 8;
            if (i12 != 0) {
            }
            i13 = i9 & 16;
            if (i13 != 0) {
            }
            i14 = i9 & 32;
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
            if (i18 != 0) {
            }
            i19 = i9 & 1024;
            if (i19 != 0) {
            }
            i21 = i9 & 2048;
            if (i21 != 0) {
            }
            i22 = i20;
            i23 = i9 & 4096;
            if (i23 != 0) {
            }
            i24 = i9 & 8192;
            if (i24 == 0) {
            }
            i25 = i9 & 16384;
            if (i25 != 0) {
            }
            if ((i8 & 196608) == 0) {
            }
            if ((i10 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            boolean z132222 = true;
            if ((i7 & 1) != 0) {
            }
            if (i32 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            if (i17 == 0) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (i21 == 0) {
            }
            if (i23 == 0) {
            }
            if (i24 == 0) {
            }
            if (i26 == 0) {
            }
            if ((i9 & 32768) == 0) {
            }
            z8 = z14;
            j11 = m1501getUnspecified0d7_KjU;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(1983078003);
            i29 = (458752 & i22) ^ 196608;
            if (i29 <= 131072) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z9) {
            }
            mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textStyle2, null, 2, null);
            startRestartGroup.updateRememberedValue(mutableStateOf$default);
            rememberedValue = mutableStateOf$default;
            mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1983080076);
            rememberedValue2 = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
            }
            mutableState2 = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            if (!z8) {
            }
            startRestartGroup.startReplaceGroup(1983095828);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier applyIf2222 = ModifierExtensionsKt.applyIf(modifier2, z8, (Function1) rememberedValue3);
            if (!z8) {
            }
            if (!z8) {
            }
            startRestartGroup.startReplaceGroup(1983102672);
            boolean changed2222 = ((i10 & 896) != 256) | startRestartGroup.changed(mutableState);
            if (i29 > 131072) {
            }
            z132222 = false;
            z10 = changed2222 | z132222;
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!z10) {
            }
            rememberedValue4 = new Function1() { // from class: W1.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                    AutoShrinkText_woKQQ_c$lambda$10$lambda$9 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$10$lambda$9(z8, textStyle2, mutableState, mutableState2, (TextLayoutResult) obj);
                    return AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceGroup();
            int i352222 = i10 & 14;
            int i362222 = i10 >> 3;
            TextStyle textStyle42222 = textStyle2;
            composer2 = startRestartGroup;
            boolean z172222 = z8;
            Modifier modifier52222 = modifier2;
            TextKt.m940Text4IGK_g(text, applyIf2222, j11, m2679getUnspecifiedXSAIIZE, fontStyle2, fontWeight2, fontFamily2, j10, textDecoration2, textAlign2, j9, i27, z16, i34, 0, (Function1) rememberedValue4, AutoShrinkText_woKQQ_c$lambda$1, composer2, i352222 | (i362222 & 896) | (i362222 & 7168) | (57344 & i362222) | (458752 & i362222) | (3670016 & i362222) | (29360128 & i362222) | (i362222 & 234881024) | ((i22 << 27) & 1879048192), (i22 >> 3) & 126, 16384);
            if (ComposerKt.isTraceInProgress()) {
            }
            j12 = j11;
            textStyle3 = textStyle42222;
            fontStyle3 = fontStyle2;
            z11 = z172222;
            modifier3 = modifier52222;
            j13 = m2679getUnspecifiedXSAIIZE;
            fontWeight3 = fontWeight2;
            fontFamily3 = fontFamily2;
            j14 = j10;
            textDecoration3 = textDecoration2;
            textAlign3 = textAlign2;
            j15 = j9;
            i30 = i27;
            z12 = z7;
            i31 = i28;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i11 = i9 & 4;
        if (i11 == 0) {
        }
        i12 = i9 & 8;
        if (i12 != 0) {
        }
        i13 = i9 & 16;
        if (i13 != 0) {
        }
        i14 = i9 & 32;
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
        if (i18 != 0) {
        }
        i19 = i9 & 1024;
        if (i19 != 0) {
        }
        i21 = i9 & 2048;
        if (i21 != 0) {
        }
        i22 = i20;
        i23 = i9 & 4096;
        if (i23 != 0) {
        }
        i24 = i9 & 8192;
        if (i24 == 0) {
        }
        i25 = i9 & 16384;
        if (i25 != 0) {
        }
        if ((i8 & 196608) == 0) {
        }
        if ((i10 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        boolean z1322222 = true;
        if ((i7 & 1) != 0) {
        }
        if (i32 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (i21 == 0) {
        }
        if (i23 == 0) {
        }
        if (i24 == 0) {
        }
        if (i26 == 0) {
        }
        if ((i9 & 32768) == 0) {
        }
        z8 = z14;
        j11 = m1501getUnspecified0d7_KjU;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(1983078003);
        i29 = (458752 & i22) ^ 196608;
        if (i29 <= 131072) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z9) {
        }
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(textStyle2, null, 2, null);
        startRestartGroup.updateRememberedValue(mutableStateOf$default);
        rememberedValue = mutableStateOf$default;
        mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(1983080076);
        rememberedValue2 = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
        }
        mutableState2 = (MutableState) rememberedValue2;
        startRestartGroup.endReplaceGroup();
        if (!z8) {
        }
        startRestartGroup.startReplaceGroup(1983095828);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier applyIf22222 = ModifierExtensionsKt.applyIf(modifier2, z8, (Function1) rememberedValue3);
        if (!z8) {
        }
        if (!z8) {
        }
        startRestartGroup.startReplaceGroup(1983102672);
        boolean changed22222 = ((i10 & 896) != 256) | startRestartGroup.changed(mutableState);
        if (i29 > 131072) {
        }
        z1322222 = false;
        z10 = changed22222 | z1322222;
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!z10) {
        }
        rememberedValue4 = new Function1() { // from class: W1.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
                AutoShrinkText_woKQQ_c$lambda$10$lambda$9 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$10$lambda$9(z8, textStyle2, mutableState, mutableState2, (TextLayoutResult) obj);
                return AutoShrinkText_woKQQ_c$lambda$10$lambda$9;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceGroup();
        int i3522222 = i10 & 14;
        int i3622222 = i10 >> 3;
        TextStyle textStyle422222 = textStyle2;
        composer2 = startRestartGroup;
        boolean z1722222 = z8;
        Modifier modifier522222 = modifier2;
        TextKt.m940Text4IGK_g(text, applyIf22222, j11, m2679getUnspecifiedXSAIIZE, fontStyle2, fontWeight2, fontFamily2, j10, textDecoration2, textAlign2, j9, i27, z16, i34, 0, (Function1) rememberedValue4, AutoShrinkText_woKQQ_c$lambda$1, composer2, i3522222 | (i3622222 & 896) | (i3622222 & 7168) | (57344 & i3622222) | (458752 & i3622222) | (3670016 & i3622222) | (29360128 & i3622222) | (i3622222 & 234881024) | ((i22 << 27) & 1879048192), (i22 >> 3) & 126, 16384);
        if (ComposerKt.isTraceInProgress()) {
        }
        j12 = j11;
        textStyle3 = textStyle422222;
        fontStyle3 = fontStyle2;
        z11 = z1722222;
        modifier3 = modifier522222;
        j13 = m2679getUnspecifiedXSAIIZE;
        fontWeight3 = fontWeight2;
        fontFamily3 = fontFamily2;
        j14 = j10;
        textDecoration3 = textDecoration2;
        textAlign3 = textAlign2;
        j15 = j9;
        i30 = i27;
        z12 = z7;
        i31 = i28;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final TextStyle AutoShrinkText_woKQQ_c$lambda$1(MutableState<TextStyle> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoShrinkText_woKQQ_c$lambda$10$lambda$9(boolean z5, TextStyle textStyle, MutableState mutableState, MutableState mutableState2, TextLayoutResult textLayoutResult) {
        TextStyle m2295copyp1EtxEg;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        if (z5) {
            if (textLayoutResult.getDidOverflowWidth()) {
                long m2299getFontSizeXSAIIZE = AutoShrinkText_woKQQ_c$lambda$1(mutableState).m2299getFontSizeXSAIIZE();
                TextUnitKt.m2681checkArithmeticR2X_6o(m2299getFontSizeXSAIIZE);
                m2295copyp1EtxEg = textStyle.m2295copyp1EtxEg((r48 & 1) != 0 ? textStyle.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? textStyle.spanStyle.getFontSize() : TextUnitKt.pack(TextUnit.m2673getRawTypeimpl(m2299getFontSizeXSAIIZE), (float) (TextUnit.m2675getValueimpl(m2299getFontSizeXSAIIZE) * 0.9d)), (r48 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? textStyle.platformStyle : null, (r48 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
                mutableState.setValue(m2295copyp1EtxEg);
            } else {
                AutoShrinkText_woKQQ_c$lambda$5(mutableState2, true);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoShrinkText_woKQQ_c$lambda$11(String str, Modifier modifier, boolean z5, long j5, long j6, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j7, TextDecoration textDecoration, TextAlign textAlign, long j8, int i5, boolean z6, int i6, TextStyle textStyle, int i7, int i8, int i9, Composer composer, int i10) {
        m3384AutoShrinkTextwoKQQc(str, modifier, z5, j5, j6, fontStyle, fontWeight, fontFamily, j7, textDecoration, textAlign, j8, i5, z6, i6, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), RecomposeScopeImplKt.updateChangedFlags(i8), i9);
        return Unit.INSTANCE;
    }

    private static final boolean AutoShrinkText_woKQQ_c$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AutoShrinkText_woKQQ_c$lambda$5(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier AutoShrinkText_woKQQ_c$lambda$8$lambda$7(final MutableState mutableState, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return DrawModifierKt.drawWithContent(applyIf, new Function1() { // from class: W1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit AutoShrinkText_woKQQ_c$lambda$8$lambda$7$lambda$6;
                AutoShrinkText_woKQQ_c$lambda$8$lambda$7$lambda$6 = AutoShrinkTextKt.AutoShrinkText_woKQQ_c$lambda$8$lambda$7$lambda$6(MutableState.this, (ContentDrawScope) obj);
                return AutoShrinkText_woKQQ_c$lambda$8$lambda$7$lambda$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AutoShrinkText_woKQQ_c$lambda$8$lambda$7$lambda$6(MutableState mutableState, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        if (AutoShrinkText_woKQQ_c$lambda$4(mutableState)) {
            drawWithContent.drawContent();
        }
        return Unit.INSTANCE;
    }
}
