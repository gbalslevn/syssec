package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b(\b\u0007\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B%\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nB×\u0001\b\u0017\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b\b\u0010,B\u0097\u0002\b\u0016\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010)\u001a\u00020\r\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\b\u0002\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\b\b\u00107J\u000f\u00108\u001a\u00020\u0002H\u0007¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0004H\u0007¢\u0006\u0004\b:\u0010;J\u001b\u0010=\u001a\u00020\u00002\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b=\u0010>J \u0002\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/2\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00104\u001a\u0002032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00106\u001a\u0004\u0018\u000105H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u0017\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0004H\u0007¢\u0006\u0004\b=\u0010AJ\u009e\u0002\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00100\u001a\u0004\u0018\u00010/2\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00104\u001a\u0002032\n\b\u0002\u00106\u001a\u0004\u0018\u000105ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010F\u001a\u00020E2\b\u0010<\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bF\u0010GJ\u0015\u0010H\u001a\u00020E2\u0006\u0010<\u001a\u00020\u0000¢\u0006\u0004\bH\u0010IJ\u0015\u0010J\u001a\u00020E2\u0006\u0010<\u001a\u00020\u0000¢\u0006\u0004\bJ\u0010IJ\u000f\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0017H\u0016¢\u0006\u0004\bN\u0010OR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010P\u001a\u0004\bQ\u00109R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010R\u001a\u0004\bS\u0010;R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010T\u001a\u0004\bU\u0010VR\u0013\u0010Z\u001a\u0004\u0018\u00010W8F¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0017\u0010\f\u001a\u00020\u000b8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0011\u0010`\u001a\u00020]8F¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0017\u0010\u000e\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\ba\u0010\\R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\bj\u0010OR\u0017\u0010\u0019\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bk\u0010\\R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0017\u0010 \u001a\u00020\u000b8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\br\u0010\\R\u0013\u0010\"\u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0013\u0010$\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0013\u0010.\u001a\u0004\u0018\u00010-8F¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0017\u0010&\u001a\u00020%8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\by\u0010MR\u0017\u0010(\u001a\u00020'8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bz\u0010MR\u0017\u0010)\u001a\u00020\r8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b{\u0010\\R\u0013\u0010+\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0013\u00100\u001a\u0004\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0018\u00104\u001a\u0002038Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010MR\u0018\u00102\u001a\u0002018Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010MR\u0015\u00106\u001a\u0004\u0018\u0001058F¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0085\u0001"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/SpanStyle;", "spanStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "paragraphStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "platformStyle", "<init>", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/unit/TextUnit;", "fontSize", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontFamily;", "fontFamily", BuildConfig.FLAVOR, "fontFeatureSettings", "letterSpacing", "Landroidx/compose/ui/text/style/BaselineShift;", "baselineShift", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textGeometricTransform", "Landroidx/compose/ui/text/intl/LocaleList;", "localeList", "background", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", "Landroidx/compose/ui/text/style/TextDirection;", "textDirection", "lineHeight", "Landroidx/compose/ui/text/style/TextIndent;", "textIndent", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineBreak;", "lineBreak", "Landroidx/compose/ui/text/style/Hyphens;", "hyphens", "Landroidx/compose/ui/text/style/TextMotion;", "textMotion", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "toSpanStyle", "()Landroidx/compose/ui/text/SpanStyle;", "toParagraphStyle", "()Landroidx/compose/ui/text/ParagraphStyle;", "other", "merge", "(Landroidx/compose/ui/text/TextStyle;)Landroidx/compose/ui/text/TextStyle;", "merge-dA7vx0o", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "(Landroidx/compose/ui/text/ParagraphStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-p1EtxEg", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/graphics/drawscope/DrawStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/TextStyle;", "copy", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hasSameLayoutAffectingAttributes", "(Landroidx/compose/ui/text/TextStyle;)Z", "hasSameDrawAffectingAttributes", BuildConfig.FLAVOR, "hashCode", "()I", "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyle$ui_text_release", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyle$ui_text_release", "Landroidx/compose/ui/text/PlatformTextStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "brush", "getColor-0d7_KjU", "()J", BuildConfig.FLAVOR, "getAlpha", "()F", "alpha", "getFontSize-XSAIIZE", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "getLetterSpacing-XSAIIZE", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getBackground-0d7_KjU", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "getTextAlign-e0LSkKk", "getTextDirection-s_7X-co", "getLineHeight-XSAIIZE", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getHyphens-vmbZdU8", "getLineBreak-rAG3T2k", "getTextMotion", "()Landroidx/compose/ui/text/style/TextMotion;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextStyle Default = new TextStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777215, null);
    private final ParagraphStyle paragraphStyle;
    private final PlatformTextStyle platformStyle;
    private final SpanStyle spanStyle;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/text/TextStyle;", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextStyle getDefault() {
            return TextStyle.Default;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i5, int i6, long j9, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i7, int i8, TextMotion textMotion, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j7, baselineShift, textGeometricTransform, localeList, j8, textDecoration, shadow, drawStyle, i5, i6, j9, textIndent, platformTextStyle, lineHeightStyle, i7, i8, textMotion);
    }

    /* renamed from: copy-p1EtxEg, reason: not valid java name */
    public final TextStyle m2295copyp1EtxEg(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, PlatformTextStyle platformStyle, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, TextMotion textMotion) {
        return new TextStyle(new SpanStyle(Color.m1487equalsimpl0(color, this.spanStyle.m2255getColor0d7_KjU()) ? this.spanStyle.getTextForegroundStyle() : TextForegroundStyle.INSTANCE.m2549from8_81llA(color), fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(textAlign, textDirection, lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphSyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion, null), platformStyle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) other;
        return Intrinsics.areEqual(this.spanStyle, textStyle.spanStyle) && Intrinsics.areEqual(this.paragraphStyle, textStyle.paragraphStyle) && Intrinsics.areEqual(this.platformStyle, textStyle.platformStyle);
    }

    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m2296getBackground0d7_KjU() {
        return this.spanStyle.getBackground();
    }

    /* renamed from: getBaselineShift-5SSeXJ0, reason: not valid java name */
    public final BaselineShift m2297getBaselineShift5SSeXJ0() {
        return this.spanStyle.getBaselineShift();
    }

    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m2298getColor0d7_KjU() {
        return this.spanStyle.m2255getColor0d7_KjU();
    }

    public final DrawStyle getDrawStyle() {
        return this.spanStyle.getDrawStyle();
    }

    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* renamed from: getFontSize-XSAIIZE, reason: not valid java name */
    public final long m2299getFontSizeXSAIIZE() {
        return this.spanStyle.getFontSize();
    }

    /* renamed from: getFontStyle-4Lr2A7w, reason: not valid java name */
    public final FontStyle m2300getFontStyle4Lr2A7w() {
        return this.spanStyle.getFontStyle();
    }

    /* renamed from: getFontSynthesis-ZQGJjVo, reason: not valid java name */
    public final FontSynthesis m2301getFontSynthesisZQGJjVo() {
        return this.spanStyle.getFontSynthesis();
    }

    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    /* renamed from: getHyphens-vmbZdU8, reason: not valid java name */
    public final int m2302getHyphensvmbZdU8() {
        return this.paragraphStyle.getHyphens();
    }

    /* renamed from: getLetterSpacing-XSAIIZE, reason: not valid java name */
    public final long m2303getLetterSpacingXSAIIZE() {
        return this.spanStyle.getLetterSpacing();
    }

    /* renamed from: getLineBreak-rAG3T2k, reason: not valid java name */
    public final int m2304getLineBreakrAG3T2k() {
        return this.paragraphStyle.getLineBreak();
    }

    /* renamed from: getLineHeight-XSAIIZE, reason: not valid java name */
    public final long m2305getLineHeightXSAIIZE() {
        return this.paragraphStyle.getLineHeight();
    }

    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    /* renamed from: getParagraphStyle$ui_text_release, reason: from getter */
    public final ParagraphStyle getParagraphStyle() {
        return this.paragraphStyle;
    }

    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    /* renamed from: getSpanStyle$ui_text_release, reason: from getter */
    public final SpanStyle getSpanStyle() {
        return this.spanStyle;
    }

    /* renamed from: getTextAlign-e0LSkKk, reason: not valid java name */
    public final int m2306getTextAligne0LSkKk() {
        return this.paragraphStyle.getTextAlign();
    }

    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    /* renamed from: getTextDirection-s_7X-co, reason: not valid java name */
    public final int m2307getTextDirections_7Xco() {
        return this.paragraphStyle.getTextDirection();
    }

    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final TextMotion getTextMotion() {
        return this.paragraphStyle.getTextMotion();
    }

    public final boolean hasSameDrawAffectingAttributes(TextStyle other) {
        return this == other || this.spanStyle.hasSameNonLayoutAttributes$ui_text_release(other.spanStyle);
    }

    public final boolean hasSameLayoutAffectingAttributes(TextStyle other) {
        return this == other || (Intrinsics.areEqual(this.paragraphStyle, other.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(other.spanStyle));
    }

    public int hashCode() {
        int hashCode = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        return hashCode + (platformTextStyle != null ? platformTextStyle.hashCode() : 0);
    }

    public final TextStyle merge(TextStyle other) {
        return (other == null || Intrinsics.areEqual(other, Default)) ? this : new TextStyle(toSpanStyle().merge(other.toSpanStyle()), toParagraphStyle().merge(other.toParagraphStyle()));
    }

    /* renamed from: merge-dA7vx0o, reason: not valid java name */
    public final TextStyle m2308mergedA7vx0o(long color, long fontSize, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String fontFeatureSettings, long letterSpacing, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long background, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int textAlign, int textDirection, long lineHeight, TextIndent textIndent, LineHeightStyle lineHeightStyle, int lineBreak, int hyphens, PlatformTextStyle platformStyle, TextMotion textMotion) {
        SpanStyle m2260fastMergedSHsh3o = SpanStyleKt.m2260fastMergedSHsh3o(this.spanStyle, color, null, Float.NaN, fontSize, fontWeight, fontStyle, fontSynthesis, fontFamily, fontFeatureSettings, letterSpacing, baselineShift, textGeometricTransform, localeList, background, textDecoration, shadow, platformStyle != null ? platformStyle.getSpanStyle() : null, drawStyle);
        ParagraphStyle m2239fastMergej5T8yCg = ParagraphStyleKt.m2239fastMergej5T8yCg(this.paragraphStyle, textAlign, textDirection, lineHeight, textIndent, platformStyle != null ? platformStyle.getParagraphSyle() : null, lineHeightStyle, lineBreak, hyphens, textMotion);
        return (this.spanStyle == m2260fastMergedSHsh3o && this.paragraphStyle == m2239fastMergej5T8yCg) ? this : new TextStyle(m2260fastMergedSHsh3o, m2239fastMergej5T8yCg);
    }

    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    public String toString() {
        return "TextStyle(color=" + ((Object) Color.m1494toStringimpl(m2298getColor0d7_KjU())) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + ((Object) TextUnit.m2677toStringimpl(m2299getFontSizeXSAIIZE())) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m2300getFontStyle4Lr2A7w() + ", fontSynthesis=" + m2301getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + ((Object) TextUnit.m2677toStringimpl(m2303getLetterSpacingXSAIIZE())) + ", baselineShift=" + m2297getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + ((Object) Color.m1494toStringimpl(m2296getBackground0d7_KjU())) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", drawStyle=" + getDrawStyle() + ", textAlign=" + ((Object) TextAlign.m2526toStringimpl(m2306getTextAligne0LSkKk())) + ", textDirection=" + ((Object) TextDirection.m2540toStringimpl(m2307getTextDirections_7Xco())) + ", lineHeight=" + ((Object) TextUnit.m2677toStringimpl(m2305getLineHeightXSAIIZE())) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + getLineHeightStyle() + ", lineBreak=" + ((Object) LineBreak.m2483toStringimpl(m2304getLineBreakrAG3T2k())) + ", hyphens=" + ((Object) Hyphens.m2470toStringimpl(m2302getHyphensvmbZdU8())) + ", textMotion=" + getTextMotion() + ')';
    }

    @Deprecated
    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j9, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j7, baselineShift, textGeometricTransform, localeList, j8, textDecoration, shadow, textAlign, textDirection, j9, textIndent);
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle, PlatformTextStyle platformTextStyle) {
        this.spanStyle = spanStyle;
        this.paragraphStyle = paragraphStyle;
        this.platformStyle = platformTextStyle;
    }

    public final TextStyle merge(ParagraphStyle other) {
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(other));
    }

    public TextStyle(SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        this(spanStyle, paragraphStyle, TextStyleKt.access$createPlatformTextStyleInternal(spanStyle.getPlatformStyle(), paragraphStyle.getPlatformStyle()));
    }

    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j9, TextIndent textIndent, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5, (i5 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j6, (i5 & 4) != 0 ? null : fontWeight, (i5 & 8) != 0 ? null : fontStyle, (i5 & 16) != 0 ? null : fontSynthesis, (i5 & 32) != 0 ? null : fontFamily, (i5 & 64) != 0 ? null : str, (i5 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j7, (i5 & 256) != 0 ? null : baselineShift, (i5 & 512) != 0 ? null : textGeometricTransform, (i5 & 1024) != 0 ? null : localeList, (i5 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j8, (i5 & 4096) != 0 ? null : textDecoration, (i5 & 8192) != 0 ? null : shadow, (i5 & 16384) != 0 ? null : textAlign, (i5 & 32768) != 0 ? null : textDirection, (i5 & 65536) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j9, (i5 & 131072) != 0 ? null : textIndent, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j9, TextIndent textIndent) {
        this(r0, new ParagraphStyle(textAlign != null ? textAlign.getValue() : TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk(), textDirection != null ? textDirection.getValue() : TextDirection.INSTANCE.m2547getUnspecifieds_7Xco(), j9, textIndent, null, null, LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k(), Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8(), null, null), null);
        SpanStyle spanStyle = new SpanStyle(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j7, baselineShift, textGeometricTransform, localeList, j8, textDecoration, shadow, (PlatformSpanStyle) null, (DrawStyle) null, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i5, int i6, long j9, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i7, int i8, TextMotion textMotion, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j5, (i9 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j6, (i9 & 4) != 0 ? null : fontWeight, (i9 & 8) != 0 ? null : fontStyle, (i9 & 16) != 0 ? null : fontSynthesis, (i9 & 32) != 0 ? null : fontFamily, (i9 & 64) != 0 ? null : str, (i9 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j7, (i9 & 256) != 0 ? null : baselineShift, (i9 & 512) != 0 ? null : textGeometricTransform, (i9 & 1024) != 0 ? null : localeList, (i9 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : j8, (i9 & 4096) != 0 ? null : textDecoration, (i9 & 8192) != 0 ? null : shadow, (i9 & 16384) != 0 ? null : drawStyle, (i9 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : i5, (i9 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : i6, (i9 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : j9, (i9 & 262144) != 0 ? null : textIndent, (i9 & 524288) != 0 ? null : platformTextStyle, (i9 & 1048576) != 0 ? null : lineHeightStyle, (i9 & 2097152) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : i7, (i9 & 4194304) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : i8, (i9 & 8388608) != 0 ? null : textMotion, null);
    }

    private TextStyle(long j5, long j6, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j7, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j8, TextDecoration textDecoration, Shadow shadow, DrawStyle drawStyle, int i5, int i6, long j9, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i7, int i8, TextMotion textMotion) {
        this(new SpanStyle(j5, j6, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j7, baselineShift, textGeometricTransform, localeList, j8, textDecoration, shadow, platformTextStyle != null ? platformTextStyle.getSpanStyle() : null, drawStyle, (DefaultConstructorMarker) null), new ParagraphStyle(i5, i6, j9, textIndent, platformTextStyle != null ? platformTextStyle.getParagraphSyle() : null, lineHeightStyle, i7, i8, textMotion, null), platformTextStyle);
    }
}
