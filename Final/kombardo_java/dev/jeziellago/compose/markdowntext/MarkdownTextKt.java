package dev.jeziellago.compose.markdowntext;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.compose.material.ContentAlphaKt;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.content.res.ResourcesCompat;
import coil.ImageLoader;
import io.noties.markwon.Markwon;
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin;
import io.noties.markwon.ext.tables.TablePlugin;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.image.coil.CoilImagesPlugin;
import io.noties.markwon.linkify.LinkifyPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aË\u0001\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0081\u0001\u0010#\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a9\u0010%\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017H\u0002¢\u0006\u0004\b%\u0010&\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006'"}, d2 = {BuildConfig.FLAVOR, "markdown", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/unit/TextUnit;", "fontSize", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", BuildConfig.FLAVOR, "maxLines", "fontResource", "Landroidx/compose/ui/text/TextStyle;", "style", "viewId", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", BuildConfig.FLAVOR, "disableLinkMovementMethod", "Lcoil/ImageLoader;", "imageLoader", "Lkotlin/Function1;", "onLinkClicked", "onTextLayout", "MarkdownText-nAGSkkc", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/style/TextAlign;ILjava/lang/Integer;Landroidx/compose/ui/text/TextStyle;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;ZLcoil/ImageLoader;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "MarkdownText", "Landroid/content/Context;", "context", "defaultColor", "Landroid/widget/TextView;", "createTextView-EZCrcA4", "(Landroid/content/Context;JJJLandroidx/compose/ui/text/style/TextAlign;ILjava/lang/Integer;Landroidx/compose/ui/text/TextStyle;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Landroid/widget/TextView;", "createTextView", "Lio/noties/markwon/Markwon;", "createMarkdownRender", "(Landroid/content/Context;Lcoil/ImageLoader;Lkotlin/jvm/functions/Function1;)Lio/noties/markwon/Markwon;", "markdowntext_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MarkdownTextKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x030b A[LOOP:0: B:79:0x0307->B:81:0x030b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0231  */
    /* renamed from: MarkdownText-nAGSkkc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3186MarkdownTextnAGSkkc(final String markdown, Modifier modifier, long j5, long j6, TextAlign textAlign, int i5, Integer num, TextStyle textStyle, Integer num2, Function0<Unit> function0, boolean z5, ImageLoader imageLoader, Function1<? super String, Unit> function1, Function1<? super Integer, Unit> function12, Composer composer, final int i6, final int i7, final int i8) {
        int i9;
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
        Modifier modifier2;
        long m1501getUnspecified0d7_KjU;
        long m2679getUnspecifiedXSAIIZE;
        TextAlign textAlign2;
        int i22;
        Integer num3;
        TextStyle textStyle2;
        Integer num4;
        Function0<Unit> function02;
        boolean z6;
        ImageLoader imageLoader2;
        Function1<? super String, Unit> function13;
        int i23;
        Function1<? super Integer, Unit> function14;
        Object rememberedValue;
        int i24;
        boolean z7;
        Object rememberedValue2;
        final Integer num5;
        final boolean z8;
        final TextStyle textStyle3;
        final ImageLoader imageLoader3;
        final Function0<Unit> function03;
        final long j7;
        final TextAlign textAlign3;
        final int i25;
        Function1<? super Integer, Unit> function15;
        final Modifier modifier3;
        Function1<? super String, Unit> function16;
        final long j8;
        final Integer num6;
        ScopeUpdateScope endRestartGroup;
        int i26;
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        Composer startRestartGroup = composer.startRestartGroup(1899177664);
        if ((i8 & 1) != 0) {
            i9 = i6 | 6;
        } else if ((i6 & 14) == 0) {
            i9 = (startRestartGroup.changed(markdown) ? 4 : 2) | i6;
        } else {
            i9 = i6;
        }
        int i27 = i8 & 2;
        if (i27 != 0) {
            i9 |= 48;
        } else if ((i6 & 112) == 0) {
            i9 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i10 = i8 & 4;
            if (i10 == 0) {
                i9 |= 384;
            } else if ((i6 & 896) == 0) {
                i9 |= startRestartGroup.changed(j5) ? 256 : 128;
                i11 = i8 & 8;
                if (i11 != 0) {
                    i9 |= 3072;
                } else if ((i6 & 7168) == 0) {
                    i9 |= startRestartGroup.changed(j6) ? 2048 : 1024;
                }
                i12 = i8 & 16;
                if (i12 != 0) {
                    i9 |= 24576;
                } else if ((i6 & 57344) == 0) {
                    i9 |= startRestartGroup.changed(textAlign) ? 16384 : 8192;
                }
                i13 = i8 & 32;
                if (i13 != 0) {
                    i9 |= 196608;
                } else if ((i6 & 458752) == 0) {
                    i9 |= startRestartGroup.changed(i5) ? 131072 : 65536;
                }
                i14 = i8 & 64;
                if (i14 != 0) {
                    i9 |= 1572864;
                } else if ((i6 & 3670016) == 0) {
                    i9 |= startRestartGroup.changed(num) ? 1048576 : 524288;
                }
                if ((i6 & 29360128) == 0) {
                    if ((i8 & 128) == 0 && startRestartGroup.changed(textStyle)) {
                        i26 = 8388608;
                        i9 |= i26;
                    }
                    i26 = 4194304;
                    i9 |= i26;
                }
                i15 = i8 & 256;
                if (i15 != 0) {
                    i9 |= 100663296;
                } else if ((i6 & 234881024) == 0) {
                    i9 |= startRestartGroup.changed(num2) ? 67108864 : 33554432;
                }
                i16 = i8 & 512;
                if (i16 != 0) {
                    i9 |= 805306368;
                } else if ((i6 & 1879048192) == 0) {
                    i9 |= startRestartGroup.changed(function0) ? 536870912 : 268435456;
                }
                i17 = i8 & 1024;
                if (i17 != 0) {
                    i18 = i7 | 6;
                } else if ((i7 & 14) == 0) {
                    i18 = i7 | (startRestartGroup.changed(z5) ? 4 : 2);
                } else {
                    i18 = i7;
                }
                i19 = i8 & 2048;
                if (i19 != 0) {
                    i18 |= 16;
                }
                int i28 = i18;
                i20 = i8 & 4096;
                if (i20 != 0) {
                    i28 |= 384;
                } else if ((i7 & 896) == 0) {
                    i28 |= startRestartGroup.changed(function1) ? 256 : 128;
                    i21 = i8 & 8192;
                    if (i21 == 0) {
                        i28 |= 3072;
                    } else if ((i7 & 7168) == 0) {
                        i28 |= startRestartGroup.changed(function12) ? 2048 : 1024;
                    }
                    if (i19 != 2048 && (1533916891 & i9) == 306783378 && (i28 & 5851) == 1170 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        j7 = j5;
                        j8 = j6;
                        textAlign3 = textAlign;
                        i25 = i5;
                        num6 = num;
                        textStyle3 = textStyle;
                        num5 = num2;
                        function03 = function0;
                        z8 = z5;
                        imageLoader3 = imageLoader;
                        function16 = function1;
                        function15 = function12;
                    } else {
                        startRestartGroup.startDefaults();
                        if ((i6 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            modifier2 = i27 == 0 ? Modifier.INSTANCE : modifier;
                            m1501getUnspecified0d7_KjU = i10 == 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5;
                            m2679getUnspecifiedXSAIIZE = i11 == 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j6;
                            textAlign2 = i12 == 0 ? null : textAlign;
                            i22 = i13 == 0 ? Integer.MAX_VALUE : i5;
                            num3 = i14 == 0 ? null : num;
                            if ((i8 & 128) == 0) {
                                textStyle2 = (TextStyle) startRestartGroup.consume(TextKt.getLocalTextStyle());
                                i9 &= -29360129;
                            } else {
                                textStyle2 = textStyle;
                            }
                            num4 = i15 == 0 ? null : num2;
                            function02 = i16 == 0 ? null : function0;
                            z6 = i17 == 0 ? false : z5;
                            imageLoader2 = i19 == 0 ? null : imageLoader;
                            function13 = i20 == 0 ? null : function1;
                            i23 = i9;
                            if (i21 != 0) {
                                function14 = null;
                                startRestartGroup.endDefaults();
                                final long m1485copywmQWz5c$default = Color.m1485copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                                Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                                startRestartGroup.startReplaceableGroup(-492369756);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = createMarkdownRender(context, imageLoader2, function13);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Markwon markwon = (Markwon) rememberedValue;
                                Object[] objArr = {Color.m1481boximpl(m1501getUnspecified0d7_KjU), Color.m1481boximpl(m1485copywmQWz5c$default), TextUnit.m2669boximpl(m2679getUnspecifiedXSAIIZE), textAlign2, Integer.valueOf(i22), num3, textStyle2, num4, function02};
                                startRestartGroup.startReplaceableGroup(-568225417);
                                ImageLoader imageLoader4 = imageLoader2;
                                z7 = false;
                                for (i24 = 0; i24 < 9; i24++) {
                                    z7 |= startRestartGroup.changed(objArr[i24]);
                                }
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    final long j9 = m1501getUnspecified0d7_KjU;
                                    final long j10 = m2679getUnspecifiedXSAIIZE;
                                    final TextAlign textAlign4 = textAlign2;
                                    final int i29 = i22;
                                    final Integer num7 = num3;
                                    final TextStyle textStyle4 = textStyle2;
                                    final Integer num8 = num4;
                                    final Function0<Unit> function04 = function02;
                                    rememberedValue2 = new Function1<Context, TextView>() { // from class: dev.jeziellago.compose.markdowntext.MarkdownTextKt$MarkdownText$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final TextView invoke(Context ctx) {
                                            TextView m3188createTextViewEZCrcA4;
                                            Intrinsics.checkNotNullParameter(ctx, "ctx");
                                            m3188createTextViewEZCrcA4 = MarkdownTextKt.m3188createTextViewEZCrcA4(ctx, j9, m1485copywmQWz5c$default, j10, textAlign4, i29, num7, textStyle4, num8, function04);
                                            return m3188createTextViewEZCrcA4;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                AndroidView_androidKt.AndroidView((Function1) rememberedValue2, modifier2, new MarkdownTextKt$MarkdownText$2(markwon, markdown, z6, function14, i22), startRestartGroup, i23 & 112, 0);
                                num5 = num4;
                                z8 = z6;
                                textStyle3 = textStyle2;
                                imageLoader3 = imageLoader4;
                                function03 = function02;
                                j7 = m1501getUnspecified0d7_KjU;
                                textAlign3 = textAlign2;
                                i25 = i22;
                                long j11 = m2679getUnspecifiedXSAIIZE;
                                function15 = function14;
                                modifier3 = modifier2;
                                function16 = function13;
                                j8 = j11;
                                num6 = num3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i8 & 128) != 0) {
                                i9 &= -29360129;
                            }
                            modifier2 = modifier;
                            m1501getUnspecified0d7_KjU = j5;
                            m2679getUnspecifiedXSAIIZE = j6;
                            textAlign2 = textAlign;
                            i22 = i5;
                            num3 = num;
                            textStyle2 = textStyle;
                            num4 = num2;
                            function02 = function0;
                            z6 = z5;
                            imageLoader2 = imageLoader;
                            function13 = function1;
                            i23 = i9;
                        }
                        function14 = function12;
                        startRestartGroup.endDefaults();
                        final long m1485copywmQWz5c$default2 = Color.m1485copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                        Context context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        startRestartGroup.startReplaceableGroup(-492369756);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        Markwon markwon2 = (Markwon) rememberedValue;
                        Object[] objArr2 = {Color.m1481boximpl(m1501getUnspecified0d7_KjU), Color.m1481boximpl(m1485copywmQWz5c$default2), TextUnit.m2669boximpl(m2679getUnspecifiedXSAIIZE), textAlign2, Integer.valueOf(i22), num3, textStyle2, num4, function02};
                        startRestartGroup.startReplaceableGroup(-568225417);
                        ImageLoader imageLoader42 = imageLoader2;
                        z7 = false;
                        while (i24 < 9) {
                        }
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z7) {
                        }
                        final long j92 = m1501getUnspecified0d7_KjU;
                        final long j102 = m2679getUnspecifiedXSAIIZE;
                        final TextAlign textAlign42 = textAlign2;
                        final int i292 = i22;
                        final Integer num72 = num3;
                        final TextStyle textStyle42 = textStyle2;
                        final Integer num82 = num4;
                        final Function0<Unit> function042 = function02;
                        rememberedValue2 = new Function1<Context, TextView>() { // from class: dev.jeziellago.compose.markdowntext.MarkdownTextKt$MarkdownText$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final TextView invoke(Context ctx) {
                                TextView m3188createTextViewEZCrcA4;
                                Intrinsics.checkNotNullParameter(ctx, "ctx");
                                m3188createTextViewEZCrcA4 = MarkdownTextKt.m3188createTextViewEZCrcA4(ctx, j92, m1485copywmQWz5c$default2, j102, textAlign42, i292, num72, textStyle42, num82, function042);
                                return m3188createTextViewEZCrcA4;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        AndroidView_androidKt.AndroidView((Function1) rememberedValue2, modifier2, new MarkdownTextKt$MarkdownText$2(markwon2, markdown, z6, function14, i22), startRestartGroup, i23 & 112, 0);
                        num5 = num4;
                        z8 = z6;
                        textStyle3 = textStyle2;
                        imageLoader3 = imageLoader42;
                        function03 = function02;
                        j7 = m1501getUnspecified0d7_KjU;
                        textAlign3 = textAlign2;
                        i25 = i22;
                        long j112 = m2679getUnspecifiedXSAIIZE;
                        function15 = function14;
                        modifier3 = modifier2;
                        function16 = function13;
                        j8 = j112;
                        num6 = num3;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        return;
                    }
                    final Function1<? super String, Unit> function17 = function16;
                    final Function1<? super Integer, Unit> function18 = function15;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: dev.jeziellago.compose.markdowntext.MarkdownTextKt$MarkdownText$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num9) {
                            invoke(composer2, num9.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i30) {
                            MarkdownTextKt.m3186MarkdownTextnAGSkkc(markdown, modifier3, j7, j8, textAlign3, i25, num6, textStyle3, num5, function03, z8, imageLoader3, function17, function18, composer2, i6 | 1, i7, i8);
                        }
                    });
                    return;
                }
                i21 = i8 & 8192;
                if (i21 == 0) {
                }
                if (i19 != 2048) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) != 0) {
                }
                if (i27 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if ((i8 & 128) == 0) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                if (i17 == 0) {
                }
                if (i19 == 0) {
                }
                if (i20 == 0) {
                }
                i23 = i9;
                if (i21 != 0) {
                }
                function14 = function12;
                startRestartGroup.endDefaults();
                final long m1485copywmQWz5c$default22 = Color.m1485copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
                Context context22 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                startRestartGroup.startReplaceableGroup(-492369756);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                Markwon markwon22 = (Markwon) rememberedValue;
                Object[] objArr22 = {Color.m1481boximpl(m1501getUnspecified0d7_KjU), Color.m1481boximpl(m1485copywmQWz5c$default22), TextUnit.m2669boximpl(m2679getUnspecifiedXSAIIZE), textAlign2, Integer.valueOf(i22), num3, textStyle2, num4, function02};
                startRestartGroup.startReplaceableGroup(-568225417);
                ImageLoader imageLoader422 = imageLoader2;
                z7 = false;
                while (i24 < 9) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z7) {
                }
                final long j922 = m1501getUnspecified0d7_KjU;
                final long j1022 = m2679getUnspecifiedXSAIIZE;
                final TextAlign textAlign422 = textAlign2;
                final int i2922 = i22;
                final Integer num722 = num3;
                final TextStyle textStyle422 = textStyle2;
                final Integer num822 = num4;
                final Function0<Unit> function0422 = function02;
                rememberedValue2 = new Function1<Context, TextView>() { // from class: dev.jeziellago.compose.markdowntext.MarkdownTextKt$MarkdownText$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final TextView invoke(Context ctx) {
                        TextView m3188createTextViewEZCrcA4;
                        Intrinsics.checkNotNullParameter(ctx, "ctx");
                        m3188createTextViewEZCrcA4 = MarkdownTextKt.m3188createTextViewEZCrcA4(ctx, j922, m1485copywmQWz5c$default22, j1022, textAlign422, i2922, num722, textStyle422, num822, function0422);
                        return m3188createTextViewEZCrcA4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                AndroidView_androidKt.AndroidView((Function1) rememberedValue2, modifier2, new MarkdownTextKt$MarkdownText$2(markwon22, markdown, z6, function14, i22), startRestartGroup, i23 & 112, 0);
                num5 = num4;
                z8 = z6;
                textStyle3 = textStyle2;
                imageLoader3 = imageLoader422;
                function03 = function02;
                j7 = m1501getUnspecified0d7_KjU;
                textAlign3 = textAlign2;
                i25 = i22;
                long j1122 = m2679getUnspecifiedXSAIIZE;
                function15 = function14;
                modifier3 = modifier2;
                function16 = function13;
                j8 = j1122;
                num6 = num3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i11 = i8 & 8;
            if (i11 != 0) {
            }
            i12 = i8 & 16;
            if (i12 != 0) {
            }
            i13 = i8 & 32;
            if (i13 != 0) {
            }
            i14 = i8 & 64;
            if (i14 != 0) {
            }
            if ((i6 & 29360128) == 0) {
            }
            i15 = i8 & 256;
            if (i15 != 0) {
            }
            i16 = i8 & 512;
            if (i16 != 0) {
            }
            i17 = i8 & 1024;
            if (i17 != 0) {
            }
            i19 = i8 & 2048;
            if (i19 != 0) {
            }
            int i282 = i18;
            i20 = i8 & 4096;
            if (i20 != 0) {
            }
            i21 = i8 & 8192;
            if (i21 == 0) {
            }
            if (i19 != 2048) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) != 0) {
            }
            if (i27 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if ((i8 & 128) == 0) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            if (i17 == 0) {
            }
            if (i19 == 0) {
            }
            if (i20 == 0) {
            }
            i23 = i9;
            if (i21 != 0) {
            }
            function14 = function12;
            startRestartGroup.endDefaults();
            final long m1485copywmQWz5c$default222 = Color.m1485copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
            Context context222 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            startRestartGroup.startReplaceableGroup(-492369756);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            Markwon markwon222 = (Markwon) rememberedValue;
            Object[] objArr222 = {Color.m1481boximpl(m1501getUnspecified0d7_KjU), Color.m1481boximpl(m1485copywmQWz5c$default222), TextUnit.m2669boximpl(m2679getUnspecifiedXSAIIZE), textAlign2, Integer.valueOf(i22), num3, textStyle2, num4, function02};
            startRestartGroup.startReplaceableGroup(-568225417);
            ImageLoader imageLoader4222 = imageLoader2;
            z7 = false;
            while (i24 < 9) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z7) {
            }
            final long j9222 = m1501getUnspecified0d7_KjU;
            final long j10222 = m2679getUnspecifiedXSAIIZE;
            final TextAlign textAlign4222 = textAlign2;
            final int i29222 = i22;
            final Integer num7222 = num3;
            final TextStyle textStyle4222 = textStyle2;
            final Integer num8222 = num4;
            final Function0<Unit> function04222 = function02;
            rememberedValue2 = new Function1<Context, TextView>() { // from class: dev.jeziellago.compose.markdowntext.MarkdownTextKt$MarkdownText$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final TextView invoke(Context ctx) {
                    TextView m3188createTextViewEZCrcA4;
                    Intrinsics.checkNotNullParameter(ctx, "ctx");
                    m3188createTextViewEZCrcA4 = MarkdownTextKt.m3188createTextViewEZCrcA4(ctx, j9222, m1485copywmQWz5c$default222, j10222, textAlign4222, i29222, num7222, textStyle4222, num8222, function04222);
                    return m3188createTextViewEZCrcA4;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            AndroidView_androidKt.AndroidView((Function1) rememberedValue2, modifier2, new MarkdownTextKt$MarkdownText$2(markwon222, markdown, z6, function14, i22), startRestartGroup, i23 & 112, 0);
            num5 = num4;
            z8 = z6;
            textStyle3 = textStyle2;
            imageLoader3 = imageLoader4222;
            function03 = function02;
            j7 = m1501getUnspecified0d7_KjU;
            textAlign3 = textAlign2;
            i25 = i22;
            long j11222 = m2679getUnspecifiedXSAIIZE;
            function15 = function14;
            modifier3 = modifier2;
            function16 = function13;
            j8 = j11222;
            num6 = num3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i10 = i8 & 4;
        if (i10 == 0) {
        }
        i11 = i8 & 8;
        if (i11 != 0) {
        }
        i12 = i8 & 16;
        if (i12 != 0) {
        }
        i13 = i8 & 32;
        if (i13 != 0) {
        }
        i14 = i8 & 64;
        if (i14 != 0) {
        }
        if ((i6 & 29360128) == 0) {
        }
        i15 = i8 & 256;
        if (i15 != 0) {
        }
        i16 = i8 & 512;
        if (i16 != 0) {
        }
        i17 = i8 & 1024;
        if (i17 != 0) {
        }
        i19 = i8 & 2048;
        if (i19 != 0) {
        }
        int i2822 = i18;
        i20 = i8 & 4096;
        if (i20 != 0) {
        }
        i21 = i8 & 8192;
        if (i21 == 0) {
        }
        if (i19 != 2048) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) != 0) {
        }
        if (i27 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if ((i8 & 128) == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (i17 == 0) {
        }
        if (i19 == 0) {
        }
        if (i20 == 0) {
        }
        i23 = i9;
        if (i21 != 0) {
        }
        function14 = function12;
        startRestartGroup.endDefaults();
        final long m1485copywmQWz5c$default2222 = Color.m1485copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).getValue(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        Context context2222 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        startRestartGroup.startReplaceableGroup(-492369756);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        Markwon markwon2222 = (Markwon) rememberedValue;
        Object[] objArr2222 = {Color.m1481boximpl(m1501getUnspecified0d7_KjU), Color.m1481boximpl(m1485copywmQWz5c$default2222), TextUnit.m2669boximpl(m2679getUnspecifiedXSAIIZE), textAlign2, Integer.valueOf(i22), num3, textStyle2, num4, function02};
        startRestartGroup.startReplaceableGroup(-568225417);
        ImageLoader imageLoader42222 = imageLoader2;
        z7 = false;
        while (i24 < 9) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z7) {
        }
        final long j92222 = m1501getUnspecified0d7_KjU;
        final long j102222 = m2679getUnspecifiedXSAIIZE;
        final TextAlign textAlign42222 = textAlign2;
        final int i292222 = i22;
        final Integer num72222 = num3;
        final TextStyle textStyle42222 = textStyle2;
        final Integer num82222 = num4;
        final Function0<Unit> function042222 = function02;
        rememberedValue2 = new Function1<Context, TextView>() { // from class: dev.jeziellago.compose.markdowntext.MarkdownTextKt$MarkdownText$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TextView invoke(Context ctx) {
                TextView m3188createTextViewEZCrcA4;
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                m3188createTextViewEZCrcA4 = MarkdownTextKt.m3188createTextViewEZCrcA4(ctx, j92222, m1485copywmQWz5c$default2222, j102222, textAlign42222, i292222, num72222, textStyle42222, num82222, function042222);
                return m3188createTextViewEZCrcA4;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        AndroidView_androidKt.AndroidView((Function1) rememberedValue2, modifier2, new MarkdownTextKt$MarkdownText$2(markwon2222, markdown, z6, function14, i22), startRestartGroup, i23 & 112, 0);
        num5 = num4;
        z8 = z6;
        textStyle3 = textStyle2;
        imageLoader3 = imageLoader42222;
        function03 = function02;
        j7 = m1501getUnspecified0d7_KjU;
        textAlign3 = textAlign2;
        i25 = i22;
        long j112222 = m2679getUnspecifiedXSAIIZE;
        function15 = function14;
        modifier3 = modifier2;
        function16 = function13;
        j8 = j112222;
        num6 = num3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final Markwon createMarkdownRender(Context context, ImageLoader imageLoader, Function1<? super String, Unit> function1) {
        if (imageLoader == null) {
            ImageLoader.Builder builder = new ImageLoader.Builder(context);
            builder.crossfade(true);
            imageLoader = builder.build();
        }
        Markwon build = Markwon.builder(context).usePlugin(HtmlPlugin.create()).usePlugin(CoilImagesPlugin.create(context, imageLoader)).usePlugin(StrikethroughPlugin.create()).usePlugin(TablePlugin.create(context)).usePlugin(LinkifyPlugin.create()).usePlugin(new MarkdownTextKt$createMarkdownRender$1(function1)).build();
        Intrinsics.checkNotNullExpressionValue(build, "onLinkClicked: ((String)…      })\n        .build()");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextView-EZCrcA4, reason: not valid java name */
    public static final TextView m3188createTextViewEZCrcA4(Context context, long j5, long j6, long j7, TextAlign textAlign, int i5, Integer num, TextStyle textStyle, Integer num2, final Function0<Unit> function0) {
        long m2298getColor0d7_KjU;
        Color.Companion companion = Color.INSTANCE;
        if (j5 != companion.m1501getUnspecified0d7_KjU()) {
            m2298getColor0d7_KjU = j5;
        } else {
            m2298getColor0d7_KjU = textStyle.m2298getColor0d7_KjU();
            if (m2298getColor0d7_KjU == companion.m1501getUnspecified0d7_KjU()) {
                m2298getColor0d7_KjU = j6;
            }
        }
        TextStyle merge = textStyle.merge(new TextStyle(m2298getColor0d7_KjU, !TextUnit.m2672equalsimpl0(j7, TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE()) ? j7 : textStyle.m2299getFontSizeXSAIIZE(), null, null, null, null, null, 0L, null, null, null, 0L, null, null, textAlign, null, 0L, null, 245756, null));
        TextView textView = new TextView(context);
        if (function0 != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: m1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function0.this.invoke();
                }
            });
        }
        textView.setTextColor(ColorKt.m1508toArgb8_81llA(m2298getColor0d7_KjU));
        textView.setMaxLines(i5);
        textView.setTextSize(1, TextUnit.m2675getValueimpl(merge.m2299getFontSizeXSAIIZE()));
        if (num2 != null) {
            textView.setId(num2.intValue());
        }
        if (textAlign != null) {
            int value = textAlign.getValue();
            TextAlign.Companion companion2 = TextAlign.INSTANCE;
            int i6 = 2;
            if (!(TextAlign.m2524equalsimpl0(value, companion2.m2531getLefte0LSkKk()) ? true : TextAlign.m2524equalsimpl0(value, companion2.m2533getStarte0LSkKk()))) {
                if (TextAlign.m2524equalsimpl0(value, companion2.m2532getRighte0LSkKk()) ? true : TextAlign.m2524equalsimpl0(value, companion2.m2529getEnde0LSkKk())) {
                    i6 = 3;
                } else if (TextAlign.m2524equalsimpl0(value, companion2.m2528getCentere0LSkKk())) {
                    i6 = 4;
                }
            }
            textView.setTextAlignment(i6);
        }
        if (Intrinsics.areEqual(merge.getTextDecoration(), TextDecoration.INSTANCE.getLineThrough())) {
            textView.setPaintFlags(16);
        }
        if (num != null) {
            textView.setTypeface(ResourcesCompat.getFont(context, num.intValue()));
        }
        return textView;
    }
}
