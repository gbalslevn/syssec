package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.material3.tokens.TypographyTokensKt;
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
import androidx.compose.ui.text.AnnotatedString;
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
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÒ\u0001\u0010#\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001b2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aæ\u0001\u0010#\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020$2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020&0%2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a%\u0010-\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001d0+H\u0007¢\u0006\u0004\b-\u0010.\"\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0/8\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {BuildConfig.FLAVOR, "text", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/unit/TextUnit;", "fontSize", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", "letterSpacing", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", "lineHeight", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", BuildConfig.FLAVOR, "softWrap", BuildConfig.FLAVOR, "maxLines", "minLines", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", BuildConfig.FLAVOR, "onTextLayout", "Landroidx/compose/ui/text/TextStyle;", "style", "Text--4IGK_g", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text", "Landroidx/compose/ui/text/AnnotatedString;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "inlineContent", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "value", "Lkotlin/Function0;", "content", "ProvideTextStyle", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material3.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyTokensKt.getDefaultTextStyle();
        }
    });

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-460300127);
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
                ComposerKt.traceEventStart(-460300127, i6, -1, "androidx.compose.material3.ProvideTextStyle (Text.kt:346)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(((TextStyle) startRestartGroup.consume(providableCompositionLocal)).merge(textStyle)), function2, startRestartGroup, (i6 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$ProvideTextStyle$1
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

    /* JADX WARN: Removed duplicated region for block: B:100:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0051  */
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
    /* JADX WARN: Removed duplicated region for block: B:73:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03e2  */
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m940Text4IGK_g(final String str, Modifier modifier, long j5, long j6, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j7, TextDecoration textDecoration, TextAlign textAlign, long j8, int i5, boolean z5, int i6, int i7, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i8, final int i9, final int i10) {
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
        long m1501getUnspecified0d7_KjU;
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
        final int i32;
        final TextDecoration textDecoration3;
        final TextAlign textAlign3;
        final Modifier modifier3;
        final int i33;
        final FontStyle fontStyle3;
        final long j10;
        final int i34;
        final boolean z7;
        final Function1<? super TextLayoutResult, Unit> function13;
        final FontFamily fontFamily3;
        final long j11;
        final long j12;
        final long j13;
        final TextStyle textStyle3;
        final FontWeight fontWeight3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-2055108902);
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
                                        j12 = j5;
                                        j10 = j6;
                                        fontStyle3 = fontStyle;
                                        fontWeight3 = fontWeight;
                                        fontFamily3 = fontFamily;
                                        j13 = j7;
                                        textDecoration3 = textDecoration;
                                        textAlign3 = textAlign;
                                        j11 = j8;
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
                                                    ComposerKt.traceEventStart(-2055108902, i11, i30, "androidx.compose.material3.Text (Text.kt:109)");
                                                }
                                                startRestartGroup.startReplaceGroup(-1827892941);
                                                if (m1501getUnspecified0d7_KjU == 16) {
                                                    j9 = m1501getUnspecified0d7_KjU;
                                                } else {
                                                    startRestartGroup.startReplaceGroup(-1827892168);
                                                    long m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
                                                    if (m2298getColor0d7_KjU == 16) {
                                                        m2298getColor0d7_KjU = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                                                    }
                                                    startRestartGroup.endReplaceGroup();
                                                    j9 = m2298getColor0d7_KjU;
                                                }
                                                startRestartGroup.endReplaceGroup();
                                                m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                                                int i37 = (i11 & 126) | ((i30 >> 6) & 7168);
                                                int i38 = i30 << 9;
                                                BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, null, startRestartGroup, i37 | (57344 & i38) | (458752 & i38) | (3670016 & i38) | (i38 & 29360128), 256);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                i32 = i31;
                                                textDecoration3 = textDecoration2;
                                                textAlign3 = textAlign2;
                                                modifier3 = modifier2;
                                                i33 = m2563getClipgIe3tQ8;
                                                fontStyle3 = fontStyle2;
                                                j10 = m2679getUnspecifiedXSAIIZE;
                                                i34 = i29;
                                                z7 = z6;
                                                function13 = function12;
                                                fontFamily3 = fontFamily2;
                                                j11 = m2679getUnspecifiedXSAIIZE3;
                                                j12 = m1501getUnspecified0d7_KjU;
                                                j13 = m2679getUnspecifiedXSAIIZE2;
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
                                        startRestartGroup.startReplaceGroup(-1827892941);
                                        if (m1501getUnspecified0d7_KjU == 16) {
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                                        int i372 = (i11 & 126) | ((i30 >> 6) & 7168);
                                        int i382 = i30 << 9;
                                        BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, null, startRestartGroup, i372 | (57344 & i382) | (458752 & i382) | (3670016 & i382) | (i382 & 29360128), 256);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        i32 = i31;
                                        textDecoration3 = textDecoration2;
                                        textAlign3 = textAlign2;
                                        modifier3 = modifier2;
                                        i33 = m2563getClipgIe3tQ8;
                                        fontStyle3 = fontStyle2;
                                        j10 = m2679getUnspecifiedXSAIIZE;
                                        i34 = i29;
                                        z7 = z6;
                                        function13 = function12;
                                        fontFamily3 = fontFamily2;
                                        j11 = m2679getUnspecifiedXSAIIZE3;
                                        j12 = m1501getUnspecified0d7_KjU;
                                        j13 = m2679getUnspecifiedXSAIIZE2;
                                        FontWeight fontWeight42 = fontWeight2;
                                        textStyle3 = textStyle2;
                                        fontWeight3 = fontWeight42;
                                    }
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$1
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

                                            public final void invoke(Composer composer2, int i39) {
                                                TextKt.m940Text4IGK_g(str, modifier3, j12, j10, fontStyle3, fontWeight3, fontFamily3, j13, textDecoration3, textAlign3, j11, i33, z7, i32, i34, function13, textStyle3, composer2, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), RecomposeScopeImplKt.updateChangedFlags(i9), i10);
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
                            startRestartGroup.startReplaceGroup(-1827892941);
                            if (m1501getUnspecified0d7_KjU == 16) {
                            }
                            startRestartGroup.endReplaceGroup();
                            m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                            int i3722 = (i11 & 126) | ((i30 >> 6) & 7168);
                            int i3822 = i30 << 9;
                            BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, null, startRestartGroup, i3722 | (57344 & i3822) | (458752 & i3822) | (3670016 & i3822) | (i3822 & 29360128), 256);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i32 = i31;
                            textDecoration3 = textDecoration2;
                            textAlign3 = textAlign2;
                            modifier3 = modifier2;
                            i33 = m2563getClipgIe3tQ8;
                            fontStyle3 = fontStyle2;
                            j10 = m2679getUnspecifiedXSAIIZE;
                            i34 = i29;
                            z7 = z6;
                            function13 = function12;
                            fontFamily3 = fontFamily2;
                            j11 = m2679getUnspecifiedXSAIIZE3;
                            j12 = m1501getUnspecified0d7_KjU;
                            j13 = m2679getUnspecifiedXSAIIZE2;
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
                        startRestartGroup.startReplaceGroup(-1827892941);
                        if (m1501getUnspecified0d7_KjU == 16) {
                        }
                        startRestartGroup.endReplaceGroup();
                        m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                        int i37222 = (i11 & 126) | ((i30 >> 6) & 7168);
                        int i38222 = i30 << 9;
                        BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, null, startRestartGroup, i37222 | (57344 & i38222) | (458752 & i38222) | (3670016 & i38222) | (i38222 & 29360128), 256);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        i32 = i31;
                        textDecoration3 = textDecoration2;
                        textAlign3 = textAlign2;
                        modifier3 = modifier2;
                        i33 = m2563getClipgIe3tQ8;
                        fontStyle3 = fontStyle2;
                        j10 = m2679getUnspecifiedXSAIIZE;
                        i34 = i29;
                        z7 = z6;
                        function13 = function12;
                        fontFamily3 = fontFamily2;
                        j11 = m2679getUnspecifiedXSAIIZE3;
                        j12 = m1501getUnspecified0d7_KjU;
                        j13 = m2679getUnspecifiedXSAIIZE2;
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
                    startRestartGroup.startReplaceGroup(-1827892941);
                    if (m1501getUnspecified0d7_KjU == 16) {
                    }
                    startRestartGroup.endReplaceGroup();
                    m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                    int i372222 = (i11 & 126) | ((i30 >> 6) & 7168);
                    int i382222 = i30 << 9;
                    BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, null, startRestartGroup, i372222 | (57344 & i382222) | (458752 & i382222) | (3670016 & i382222) | (i382222 & 29360128), 256);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i32 = i31;
                    textDecoration3 = textDecoration2;
                    textAlign3 = textAlign2;
                    modifier3 = modifier2;
                    i33 = m2563getClipgIe3tQ8;
                    fontStyle3 = fontStyle2;
                    j10 = m2679getUnspecifiedXSAIIZE;
                    i34 = i29;
                    z7 = z6;
                    function13 = function12;
                    fontFamily3 = fontFamily2;
                    j11 = m2679getUnspecifiedXSAIIZE3;
                    j12 = m1501getUnspecified0d7_KjU;
                    j13 = m2679getUnspecifiedXSAIIZE2;
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
                startRestartGroup.startReplaceGroup(-1827892941);
                if (m1501getUnspecified0d7_KjU == 16) {
                }
                startRestartGroup.endReplaceGroup();
                m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                int i3722222 = (i11 & 126) | ((i30 >> 6) & 7168);
                int i3822222 = i30 << 9;
                BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, null, startRestartGroup, i3722222 | (57344 & i3822222) | (458752 & i3822222) | (3670016 & i3822222) | (i3822222 & 29360128), 256);
                if (ComposerKt.isTraceInProgress()) {
                }
                i32 = i31;
                textDecoration3 = textDecoration2;
                textAlign3 = textAlign2;
                modifier3 = modifier2;
                i33 = m2563getClipgIe3tQ8;
                fontStyle3 = fontStyle2;
                j10 = m2679getUnspecifiedXSAIIZE;
                i34 = i29;
                z7 = z6;
                function13 = function12;
                fontFamily3 = fontFamily2;
                j11 = m2679getUnspecifiedXSAIIZE3;
                j12 = m1501getUnspecified0d7_KjU;
                j13 = m2679getUnspecifiedXSAIIZE2;
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
            startRestartGroup.startReplaceGroup(-1827892941);
            if (m1501getUnspecified0d7_KjU == 16) {
            }
            startRestartGroup.endReplaceGroup();
            m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
            int i37222222 = (i11 & 126) | ((i30 >> 6) & 7168);
            int i38222222 = i30 << 9;
            BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, null, startRestartGroup, i37222222 | (57344 & i38222222) | (458752 & i38222222) | (3670016 & i38222222) | (i38222222 & 29360128), 256);
            if (ComposerKt.isTraceInProgress()) {
            }
            i32 = i31;
            textDecoration3 = textDecoration2;
            textAlign3 = textAlign2;
            modifier3 = modifier2;
            i33 = m2563getClipgIe3tQ8;
            fontStyle3 = fontStyle2;
            j10 = m2679getUnspecifiedXSAIIZE;
            i34 = i29;
            z7 = z6;
            function13 = function12;
            fontFamily3 = fontFamily2;
            j11 = m2679getUnspecifiedXSAIIZE3;
            j12 = m1501getUnspecified0d7_KjU;
            j13 = m2679getUnspecifiedXSAIIZE2;
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
        startRestartGroup.startReplaceGroup(-1827892941);
        if (m1501getUnspecified0d7_KjU == 16) {
        }
        startRestartGroup.endReplaceGroup();
        m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j9, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE2, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE3, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
        int i372222222 = (i11 & 126) | ((i30 >> 6) & 7168);
        int i382222222 = i30 << 9;
        BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, m2308mergedA7vx0o, function12, m2563getClipgIe3tQ8, z6, i31, i29, null, startRestartGroup, i372222222 | (57344 & i382222222) | (458752 & i382222222) | (3670016 & i382222222) | (i382222222 & 29360128), 256);
        if (ComposerKt.isTraceInProgress()) {
        }
        i32 = i31;
        textDecoration3 = textDecoration2;
        textAlign3 = textAlign2;
        modifier3 = modifier2;
        i33 = m2563getClipgIe3tQ8;
        fontStyle3 = fontStyle2;
        j10 = m2679getUnspecifiedXSAIIZE;
        i34 = i29;
        z7 = z6;
        function13 = function12;
        fontFamily3 = fontFamily2;
        j11 = m2679getUnspecifiedXSAIIZE3;
        j12 = m1501getUnspecified0d7_KjU;
        j13 = m2679getUnspecifiedXSAIIZE2;
        FontWeight fontWeight42222222 = fontWeight2;
        textStyle3 = textStyle2;
        fontWeight3 = fontWeight42222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0423  */
    /* renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m941TextIbK3jfQ(final AnnotatedString annotatedString, Modifier modifier, long j5, long j6, FontStyle fontStyle, FontWeight fontWeight, FontFamily fontFamily, long j7, TextDecoration textDecoration, TextAlign textAlign, long j8, int i5, boolean z5, int i6, int i7, Map<String, Object> map, Function1<? super TextLayoutResult, Unit> function1, TextStyle textStyle, Composer composer, final int i8, final int i9, final int i10) {
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
        Modifier modifier2;
        long m1501getUnspecified0d7_KjU;
        long m2679getUnspecifiedXSAIIZE;
        FontStyle fontStyle2;
        FontWeight fontWeight2;
        TextAlign textAlign2;
        TextStyle textStyle2;
        int i29;
        Map<String, Object> map2;
        Function1<? super TextLayoutResult, Unit> function12;
        FontFamily fontFamily2;
        int i30;
        int i31;
        boolean z6;
        int i32;
        long j9;
        TextDecoration textDecoration2;
        long j10;
        boolean z7;
        long j11;
        TextStyle m2308mergedA7vx0o;
        final TextDecoration textDecoration3;
        final TextAlign textAlign3;
        final FontFamily fontFamily3;
        int i33;
        final boolean z8;
        final Modifier modifier3;
        final long j12;
        final long j13;
        final Function1<? super TextLayoutResult, Unit> function13;
        final TextStyle textStyle3;
        final long j14;
        final int i34;
        final FontStyle fontStyle3;
        final FontWeight fontWeight3;
        final long j15;
        final Map<String, Object> map3;
        final int i35;
        final int i36;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2027001676);
        if ((i10 & 1) != 0) {
            i11 = i8 | 6;
        } else if ((i8 & 6) == 0) {
            i11 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i8;
        } else {
            i11 = i8;
        }
        int i37 = i10 & 2;
        if (i37 != 0) {
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
                } else if ((i8 & 100663296) == 0) {
                    i11 |= startRestartGroup.changed(textDecoration) ? 67108864 : 33554432;
                }
                i19 = i10 & 512;
                if (i19 != 0) {
                    i11 |= 805306368;
                } else if ((i8 & 805306368) == 0) {
                    i11 |= startRestartGroup.changed(textAlign) ? 536870912 : 268435456;
                }
                i20 = i10 & 1024;
                if (i20 != 0) {
                    i21 = i9 | 6;
                } else if ((i9 & 6) == 0) {
                    i21 = i9 | (startRestartGroup.changed(j8) ? 4 : 2);
                } else {
                    i21 = i9;
                }
                i22 = i10 & 2048;
                if (i22 != 0) {
                    i21 |= 48;
                } else if ((i9 & 48) == 0) {
                    i21 |= startRestartGroup.changed(i5) ? 32 : 16;
                }
                int i38 = i21;
                i23 = i10 & 4096;
                if (i23 != 0) {
                    i38 |= 384;
                } else if ((i9 & 384) == 0) {
                    i38 |= startRestartGroup.changed(z5) ? 256 : 128;
                    i24 = i10 & 8192;
                    if (i24 == 0) {
                        i38 |= 3072;
                    } else if ((i9 & 3072) == 0) {
                        i38 |= startRestartGroup.changed(i6) ? 2048 : 1024;
                        i25 = i10 & 16384;
                        if (i25 != 0) {
                            i38 |= 24576;
                            i26 = i25;
                        } else {
                            i26 = i25;
                            if ((i9 & 24576) == 0) {
                                i38 |= startRestartGroup.changed(i7) ? 16384 : 8192;
                                i27 = i10 & 32768;
                                if (i27 == 0) {
                                    i38 |= 196608;
                                } else if ((i9 & 196608) == 0) {
                                    i38 |= startRestartGroup.changedInstance(map) ? 131072 : 65536;
                                }
                                i28 = i10 & 65536;
                                if (i28 == 0) {
                                    i38 |= 1572864;
                                } else if ((i9 & 1572864) == 0) {
                                    i38 |= startRestartGroup.changedInstance(function1) ? 1048576 : 524288;
                                }
                                if ((i9 & 12582912) == 0) {
                                    i38 |= ((i10 & 131072) == 0 && startRestartGroup.changed(textStyle)) ? 8388608 : 4194304;
                                }
                                if ((i11 & 306783379) != 306783378 && (4793491 & i38) == 4793490 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier3 = modifier;
                                    j13 = j5;
                                    j12 = j6;
                                    fontStyle3 = fontStyle;
                                    fontWeight3 = fontWeight;
                                    fontFamily3 = fontFamily;
                                    j15 = j7;
                                    textDecoration3 = textDecoration;
                                    textAlign3 = textAlign;
                                    j14 = j8;
                                    i34 = i5;
                                    z8 = z5;
                                    i36 = i6;
                                    i35 = i7;
                                    map3 = map;
                                    function13 = function1;
                                    textStyle3 = textStyle;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i8 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        modifier2 = i37 == 0 ? Modifier.INSTANCE : modifier;
                                        m1501getUnspecified0d7_KjU = i12 == 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
                                        m2679getUnspecifiedXSAIIZE = i13 == 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j6;
                                        fontStyle2 = i14 == 0 ? null : fontStyle;
                                        fontWeight2 = i15 == 0 ? null : fontWeight;
                                        FontFamily fontFamily4 = i16 == 0 ? null : fontFamily;
                                        long m2679getUnspecifiedXSAIIZE2 = i17 == 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j7;
                                        TextDecoration textDecoration4 = i18 == 0 ? null : textDecoration;
                                        textAlign2 = i19 == 0 ? textAlign : null;
                                        long m2679getUnspecifiedXSAIIZE3 = i20 == 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j8;
                                        int m2563getClipgIe3tQ8 = i22 == 0 ? TextOverflow.INSTANCE.m2563getClipgIe3tQ8() : i5;
                                        boolean z9 = i23 == 0 ? true : z5;
                                        int i39 = i24 == 0 ? Integer.MAX_VALUE : i6;
                                        int i40 = i26 == 0 ? i7 : 1;
                                        Map<String, Object> emptyMap = i27 == 0 ? MapsKt.emptyMap() : map;
                                        Function1<? super TextLayoutResult, Unit> function14 = i28 == 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.material3.TextKt$Text$4
                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(TextLayoutResult textLayoutResult) {
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                                invoke2(textLayoutResult);
                                                return Unit.INSTANCE;
                                            }
                                        } : function1;
                                        long j16 = m2679getUnspecifiedXSAIIZE3;
                                        if ((i10 & 131072) == 0) {
                                            i38 &= -29360129;
                                            textStyle2 = (TextStyle) startRestartGroup.consume(LocalTextStyle);
                                        } else {
                                            textStyle2 = textStyle;
                                        }
                                        i29 = i38;
                                        map2 = emptyMap;
                                        function12 = function14;
                                        fontFamily2 = fontFamily4;
                                        i30 = i39;
                                        i31 = i40;
                                        z6 = z9;
                                        i32 = m2563getClipgIe3tQ8;
                                        j9 = j16;
                                        textDecoration2 = textDecoration4;
                                        j10 = m2679getUnspecifiedXSAIIZE2;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i10 & 131072) != 0) {
                                            i38 &= -29360129;
                                        }
                                        modifier2 = modifier;
                                        m1501getUnspecified0d7_KjU = j5;
                                        m2679getUnspecifiedXSAIIZE = j6;
                                        fontStyle2 = fontStyle;
                                        fontWeight2 = fontWeight;
                                        fontFamily2 = fontFamily;
                                        j10 = j7;
                                        textDecoration2 = textDecoration;
                                        textAlign2 = textAlign;
                                        i32 = i5;
                                        z6 = z5;
                                        i30 = i6;
                                        i31 = i7;
                                        map2 = map;
                                        function12 = function1;
                                        textStyle2 = textStyle;
                                        i29 = i38;
                                        j9 = j8;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        z7 = z6;
                                    } else {
                                        z7 = z6;
                                        ComposerKt.traceEventStart(2027001676, i11, i29, "androidx.compose.material3.Text (Text.kt:255)");
                                    }
                                    startRestartGroup.startReplaceGroup(-1827697581);
                                    if (m1501getUnspecified0d7_KjU == 16) {
                                        j11 = m1501getUnspecified0d7_KjU;
                                    } else {
                                        startRestartGroup.startReplaceGroup(-1827696808);
                                        long m2298getColor0d7_KjU = textStyle2.m2298getColor0d7_KjU();
                                        if (m2298getColor0d7_KjU == 16) {
                                            m2298getColor0d7_KjU = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue();
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        j11 = m2298getColor0d7_KjU;
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j11, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j10, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j9, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                                    int i41 = (i11 & 126) | ((i29 >> 9) & 7168);
                                    int i42 = i29 << 9;
                                    BasicTextKt.m464BasicTextRWo7tUw(annotatedString, modifier2, m2308mergedA7vx0o, function12, i32, z7, i30, i31, map2, null, startRestartGroup, i41 | (57344 & i42) | (458752 & i42) | (3670016 & i42) | (29360128 & i42) | (i42 & 234881024), 512);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    textDecoration3 = textDecoration2;
                                    textAlign3 = textAlign2;
                                    fontFamily3 = fontFamily2;
                                    i33 = i30;
                                    z8 = z7;
                                    long j17 = j10;
                                    modifier3 = modifier2;
                                    j12 = m2679getUnspecifiedXSAIIZE;
                                    j13 = m1501getUnspecified0d7_KjU;
                                    function13 = function12;
                                    textStyle3 = textStyle2;
                                    j14 = j9;
                                    i34 = i32;
                                    fontStyle3 = fontStyle2;
                                    fontWeight3 = fontWeight2;
                                    j15 = j17;
                                    map3 = map2;
                                    i35 = i31;
                                    i36 = i33;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextKt$Text$5
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

                                        public final void invoke(Composer composer2, int i43) {
                                            TextKt.m941TextIbK3jfQ(AnnotatedString.this, modifier3, j13, j12, fontStyle3, fontWeight3, fontFamily3, j15, textDecoration3, textAlign3, j14, i34, z8, i36, i35, map3, function13, textStyle3, composer2, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), RecomposeScopeImplKt.updateChangedFlags(i9), i10);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                        i27 = i10 & 32768;
                        if (i27 == 0) {
                        }
                        i28 = i10 & 65536;
                        if (i28 == 0) {
                        }
                        if ((i9 & 12582912) == 0) {
                        }
                        if ((i11 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i8 & 1) != 0) {
                        }
                        if (i37 == 0) {
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
                        if (i20 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i23 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i27 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        long j162 = m2679getUnspecifiedXSAIIZE3;
                        if ((i10 & 131072) == 0) {
                        }
                        i29 = i38;
                        map2 = emptyMap;
                        function12 = function14;
                        fontFamily2 = fontFamily4;
                        i30 = i39;
                        i31 = i40;
                        z6 = z9;
                        i32 = m2563getClipgIe3tQ8;
                        j9 = j162;
                        textDecoration2 = textDecoration4;
                        j10 = m2679getUnspecifiedXSAIIZE2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceGroup(-1827697581);
                        if (m1501getUnspecified0d7_KjU == 16) {
                        }
                        startRestartGroup.endReplaceGroup();
                        m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j11, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j10, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j9, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                        int i412 = (i11 & 126) | ((i29 >> 9) & 7168);
                        int i422 = i29 << 9;
                        BasicTextKt.m464BasicTextRWo7tUw(annotatedString, modifier2, m2308mergedA7vx0o, function12, i32, z7, i30, i31, map2, null, startRestartGroup, i412 | (57344 & i422) | (458752 & i422) | (3670016 & i422) | (29360128 & i422) | (i422 & 234881024), 512);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        textDecoration3 = textDecoration2;
                        textAlign3 = textAlign2;
                        fontFamily3 = fontFamily2;
                        i33 = i30;
                        z8 = z7;
                        long j172 = j10;
                        modifier3 = modifier2;
                        j12 = m2679getUnspecifiedXSAIIZE;
                        j13 = m1501getUnspecified0d7_KjU;
                        function13 = function12;
                        textStyle3 = textStyle2;
                        j14 = j9;
                        i34 = i32;
                        fontStyle3 = fontStyle2;
                        fontWeight3 = fontWeight2;
                        j15 = j172;
                        map3 = map2;
                        i35 = i31;
                        i36 = i33;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i25 = i10 & 16384;
                    if (i25 != 0) {
                    }
                    i27 = i10 & 32768;
                    if (i27 == 0) {
                    }
                    i28 = i10 & 65536;
                    if (i28 == 0) {
                    }
                    if ((i9 & 12582912) == 0) {
                    }
                    if ((i11 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i8 & 1) != 0) {
                    }
                    if (i37 == 0) {
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
                    if (i20 == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i23 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i27 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    long j1622 = m2679getUnspecifiedXSAIIZE3;
                    if ((i10 & 131072) == 0) {
                    }
                    i29 = i38;
                    map2 = emptyMap;
                    function12 = function14;
                    fontFamily2 = fontFamily4;
                    i30 = i39;
                    i31 = i40;
                    z6 = z9;
                    i32 = m2563getClipgIe3tQ8;
                    j9 = j1622;
                    textDecoration2 = textDecoration4;
                    j10 = m2679getUnspecifiedXSAIIZE2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceGroup(-1827697581);
                    if (m1501getUnspecified0d7_KjU == 16) {
                    }
                    startRestartGroup.endReplaceGroup();
                    m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j11, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j10, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j9, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                    int i4122 = (i11 & 126) | ((i29 >> 9) & 7168);
                    int i4222 = i29 << 9;
                    BasicTextKt.m464BasicTextRWo7tUw(annotatedString, modifier2, m2308mergedA7vx0o, function12, i32, z7, i30, i31, map2, null, startRestartGroup, i4122 | (57344 & i4222) | (458752 & i4222) | (3670016 & i4222) | (29360128 & i4222) | (i4222 & 234881024), 512);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    textDecoration3 = textDecoration2;
                    textAlign3 = textAlign2;
                    fontFamily3 = fontFamily2;
                    i33 = i30;
                    z8 = z7;
                    long j1722 = j10;
                    modifier3 = modifier2;
                    j12 = m2679getUnspecifiedXSAIIZE;
                    j13 = m1501getUnspecified0d7_KjU;
                    function13 = function12;
                    textStyle3 = textStyle2;
                    j14 = j9;
                    i34 = i32;
                    fontStyle3 = fontStyle2;
                    fontWeight3 = fontWeight2;
                    j15 = j1722;
                    map3 = map2;
                    i35 = i31;
                    i36 = i33;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i24 = i10 & 8192;
                if (i24 == 0) {
                }
                i25 = i10 & 16384;
                if (i25 != 0) {
                }
                i27 = i10 & 32768;
                if (i27 == 0) {
                }
                i28 = i10 & 65536;
                if (i28 == 0) {
                }
                if ((i9 & 12582912) == 0) {
                }
                if ((i11 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i8 & 1) != 0) {
                }
                if (i37 == 0) {
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
                if (i20 == 0) {
                }
                if (i22 == 0) {
                }
                if (i23 == 0) {
                }
                if (i24 == 0) {
                }
                if (i26 == 0) {
                }
                if (i27 == 0) {
                }
                if (i28 == 0) {
                }
                long j16222 = m2679getUnspecifiedXSAIIZE3;
                if ((i10 & 131072) == 0) {
                }
                i29 = i38;
                map2 = emptyMap;
                function12 = function14;
                fontFamily2 = fontFamily4;
                i30 = i39;
                i31 = i40;
                z6 = z9;
                i32 = m2563getClipgIe3tQ8;
                j9 = j16222;
                textDecoration2 = textDecoration4;
                j10 = m2679getUnspecifiedXSAIIZE2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceGroup(-1827697581);
                if (m1501getUnspecified0d7_KjU == 16) {
                }
                startRestartGroup.endReplaceGroup();
                m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j11, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j10, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j9, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                int i41222 = (i11 & 126) | ((i29 >> 9) & 7168);
                int i42222 = i29 << 9;
                BasicTextKt.m464BasicTextRWo7tUw(annotatedString, modifier2, m2308mergedA7vx0o, function12, i32, z7, i30, i31, map2, null, startRestartGroup, i41222 | (57344 & i42222) | (458752 & i42222) | (3670016 & i42222) | (29360128 & i42222) | (i42222 & 234881024), 512);
                if (ComposerKt.isTraceInProgress()) {
                }
                textDecoration3 = textDecoration2;
                textAlign3 = textAlign2;
                fontFamily3 = fontFamily2;
                i33 = i30;
                z8 = z7;
                long j17222 = j10;
                modifier3 = modifier2;
                j12 = m2679getUnspecifiedXSAIIZE;
                j13 = m1501getUnspecified0d7_KjU;
                function13 = function12;
                textStyle3 = textStyle2;
                j14 = j9;
                i34 = i32;
                fontStyle3 = fontStyle2;
                fontWeight3 = fontWeight2;
                j15 = j17222;
                map3 = map2;
                i35 = i31;
                i36 = i33;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
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
            if (i19 != 0) {
            }
            i20 = i10 & 1024;
            if (i20 != 0) {
            }
            i22 = i10 & 2048;
            if (i22 != 0) {
            }
            int i382 = i21;
            i23 = i10 & 4096;
            if (i23 != 0) {
            }
            i24 = i10 & 8192;
            if (i24 == 0) {
            }
            i25 = i10 & 16384;
            if (i25 != 0) {
            }
            i27 = i10 & 32768;
            if (i27 == 0) {
            }
            i28 = i10 & 65536;
            if (i28 == 0) {
            }
            if ((i9 & 12582912) == 0) {
            }
            if ((i11 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i8 & 1) != 0) {
            }
            if (i37 == 0) {
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
            if (i20 == 0) {
            }
            if (i22 == 0) {
            }
            if (i23 == 0) {
            }
            if (i24 == 0) {
            }
            if (i26 == 0) {
            }
            if (i27 == 0) {
            }
            if (i28 == 0) {
            }
            long j162222 = m2679getUnspecifiedXSAIIZE3;
            if ((i10 & 131072) == 0) {
            }
            i29 = i382;
            map2 = emptyMap;
            function12 = function14;
            fontFamily2 = fontFamily4;
            i30 = i39;
            i31 = i40;
            z6 = z9;
            i32 = m2563getClipgIe3tQ8;
            j9 = j162222;
            textDecoration2 = textDecoration4;
            j10 = m2679getUnspecifiedXSAIIZE2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-1827697581);
            if (m1501getUnspecified0d7_KjU == 16) {
            }
            startRestartGroup.endReplaceGroup();
            m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j11, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j10, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j9, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
            int i412222 = (i11 & 126) | ((i29 >> 9) & 7168);
            int i422222 = i29 << 9;
            BasicTextKt.m464BasicTextRWo7tUw(annotatedString, modifier2, m2308mergedA7vx0o, function12, i32, z7, i30, i31, map2, null, startRestartGroup, i412222 | (57344 & i422222) | (458752 & i422222) | (3670016 & i422222) | (29360128 & i422222) | (i422222 & 234881024), 512);
            if (ComposerKt.isTraceInProgress()) {
            }
            textDecoration3 = textDecoration2;
            textAlign3 = textAlign2;
            fontFamily3 = fontFamily2;
            i33 = i30;
            z8 = z7;
            long j172222 = j10;
            modifier3 = modifier2;
            j12 = m2679getUnspecifiedXSAIIZE;
            j13 = m1501getUnspecified0d7_KjU;
            function13 = function12;
            textStyle3 = textStyle2;
            j14 = j9;
            i34 = i32;
            fontStyle3 = fontStyle2;
            fontWeight3 = fontWeight2;
            j15 = j172222;
            map3 = map2;
            i35 = i31;
            i36 = i33;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
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
        if (i19 != 0) {
        }
        i20 = i10 & 1024;
        if (i20 != 0) {
        }
        i22 = i10 & 2048;
        if (i22 != 0) {
        }
        int i3822 = i21;
        i23 = i10 & 4096;
        if (i23 != 0) {
        }
        i24 = i10 & 8192;
        if (i24 == 0) {
        }
        i25 = i10 & 16384;
        if (i25 != 0) {
        }
        i27 = i10 & 32768;
        if (i27 == 0) {
        }
        i28 = i10 & 65536;
        if (i28 == 0) {
        }
        if ((i9 & 12582912) == 0) {
        }
        if ((i11 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i8 & 1) != 0) {
        }
        if (i37 == 0) {
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
        if (i20 == 0) {
        }
        if (i22 == 0) {
        }
        if (i23 == 0) {
        }
        if (i24 == 0) {
        }
        if (i26 == 0) {
        }
        if (i27 == 0) {
        }
        if (i28 == 0) {
        }
        long j1622222 = m2679getUnspecifiedXSAIIZE3;
        if ((i10 & 131072) == 0) {
        }
        i29 = i3822;
        map2 = emptyMap;
        function12 = function14;
        fontFamily2 = fontFamily4;
        i30 = i39;
        i31 = i40;
        z6 = z9;
        i32 = m2563getClipgIe3tQ8;
        j9 = j1622222;
        textDecoration2 = textDecoration4;
        j10 = m2679getUnspecifiedXSAIIZE2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-1827697581);
        if (m1501getUnspecified0d7_KjU == 16) {
        }
        startRestartGroup.endReplaceGroup();
        m2308mergedA7vx0o = textStyle2.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j11, (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : m2679getUnspecifiedXSAIIZE, (r58 & 4) != 0 ? null : fontWeight2, (r58 & 8) != 0 ? null : fontStyle2, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : fontFamily2, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j10, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : textDecoration2, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : textAlign2 == null ? textAlign2.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j9, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
        int i4122222 = (i11 & 126) | ((i29 >> 9) & 7168);
        int i4222222 = i29 << 9;
        BasicTextKt.m464BasicTextRWo7tUw(annotatedString, modifier2, m2308mergedA7vx0o, function12, i32, z7, i30, i31, map2, null, startRestartGroup, i4122222 | (57344 & i4222222) | (458752 & i4222222) | (3670016 & i4222222) | (29360128 & i4222222) | (i4222222 & 234881024), 512);
        if (ComposerKt.isTraceInProgress()) {
        }
        textDecoration3 = textDecoration2;
        textAlign3 = textAlign2;
        fontFamily3 = fontFamily2;
        i33 = i30;
        z8 = z7;
        long j1722222 = j10;
        modifier3 = modifier2;
        j12 = m2679getUnspecifiedXSAIIZE;
        j13 = m1501getUnspecified0d7_KjU;
        function13 = function12;
        textStyle3 = textStyle2;
        j14 = j9;
        i34 = i32;
        fontStyle3 = fontStyle2;
        fontWeight3 = fontWeight2;
        j15 = j1722222;
        map3 = map2;
        i35 = i31;
        i36 = i33;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }
}
