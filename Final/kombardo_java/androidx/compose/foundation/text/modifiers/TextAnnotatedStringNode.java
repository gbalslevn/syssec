package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnit;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001|BÇ\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u0016\u0012\u001e\b\u0002\u0010\u001b\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\rH\u0002¢\u0006\u0004\b,\u0010-J\u001f\u0010/\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b1\u0010+JV\u00105\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0014\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b3\u00104Ja\u00106\u001a\u00020\u00112\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\u001c\u0010\u001b\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0004\b6\u00107J-\u0010<\u001a\u00020\r2\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u0011¢\u0006\u0004\b<\u0010=J\u000f\u0010?\u001a\u00020\rH\u0000¢\u0006\u0004\b>\u0010-J\u0013\u0010A\u001a\u00020\r*\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ(\u0010L\u001a\u00020I2\u0006\u0010D\u001a\u00020C2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020Gø\u0001\u0000¢\u0006\u0004\bJ\u0010KJ&\u0010N\u001a\u00020I*\u00020C2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020GH\u0016ø\u0001\u0000¢\u0006\u0004\bM\u0010KJ%\u0010S\u001a\u00020\u00132\u0006\u0010P\u001a\u00020O2\u0006\u0010F\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0013¢\u0006\u0004\bS\u0010TJ#\u0010U\u001a\u00020\u0013*\u00020O2\u0006\u0010F\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0013H\u0016¢\u0006\u0004\bU\u0010TJ%\u0010W\u001a\u00020\u00132\u0006\u0010P\u001a\u00020O2\u0006\u0010F\u001a\u00020Q2\u0006\u0010V\u001a\u00020\u0013¢\u0006\u0004\bW\u0010TJ#\u0010X\u001a\u00020\u0013*\u00020O2\u0006\u0010F\u001a\u00020Q2\u0006\u0010V\u001a\u00020\u0013H\u0016¢\u0006\u0004\bX\u0010TJ%\u0010Y\u001a\u00020\u00132\u0006\u0010P\u001a\u00020O2\u0006\u0010F\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0013¢\u0006\u0004\bY\u0010TJ#\u0010Z\u001a\u00020\u0013*\u00020O2\u0006\u0010F\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0013H\u0016¢\u0006\u0004\bZ\u0010TJ%\u0010[\u001a\u00020\u00132\u0006\u0010P\u001a\u00020O2\u0006\u0010F\u001a\u00020Q2\u0006\u0010V\u001a\u00020\u0013¢\u0006\u0004\b[\u0010TJ#\u0010\\\u001a\u00020\u0013*\u00020O2\u0006\u0010F\u001a\u00020Q2\u0006\u0010V\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\\\u0010TJ\u0015\u0010_\u001a\u00020\r2\u0006\u0010^\u001a\u00020]¢\u0006\u0004\b_\u0010`J\u0013\u0010a\u001a\u00020\r*\u00020]H\u0016¢\u0006\u0004\ba\u0010`R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010bR\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010cR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010dR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010eR\u001c\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0010\u0010fR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010gR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010fR\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010fR$\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010hR,\u0010\u001b\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010eR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010iR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010jR$\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010eR*\u0010m\u001a\u0010\u0012\u0004\u0012\u00020l\u0012\u0004\u0012\u00020\u0013\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bm\u0010n\u0012\u0004\bo\u0010-R\u0018\u0010p\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR*\u0010s\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0r\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010eR$\u0010t\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010z\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006}"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", BuildConfig.FLAVOR, "onTextLayout", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", BuildConfig.FLAVOR, "softWrap", BuildConfig.FLAVOR, "maxLines", "minLines", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "Landroidx/compose/ui/geometry/Rect;", "onPlaceholderLayout", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "selectionController", "Landroidx/compose/ui/graphics/ColorProducer;", "overrideColor", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "onShowTranslation", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily$Resolver;Lkotlin/jvm/functions/Function1;IZIILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "getLayoutCache", "(Landroidx/compose/ui/unit/Density;)Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "updatedText", "setSubstitution", "(Landroidx/compose/ui/text/AnnotatedString;)Z", "invalidateForTranslate", "()V", "color", "updateDraw", "(Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/ui/text/TextStyle;)Z", "updateText$foundation_release", "updateText", "updateLayoutRelatedArgs-MPT68mk", "(Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IIZLandroidx/compose/ui/text/font/FontFamily$Resolver;I)Z", "updateLayoutRelatedArgs", "updateCallbacks", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Lkotlin/jvm/functions/Function1;)Z", "drawChanged", "textChanged", "layoutChanged", "callbacksChanged", "doInvalidations", "(ZZZZ)V", "clearSubstitution$foundation_release", "clearSubstitution", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Landroidx/compose/ui/layout/MeasureScope;", "measureScope", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measureNonExtension-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measureNonExtension", "measure-3p2s80s", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "intrinsicMeasureScope", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidthNonExtension", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "minIntrinsicWidth", "width", "minIntrinsicHeightNonExtension", "minIntrinsicHeight", "maxIntrinsicWidthNonExtension", "maxIntrinsicWidth", "maxIntrinsicHeightNonExtension", "maxIntrinsicHeight", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "contentDrawScope", "drawNonExtension", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "draw", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "Lkotlin/jvm/functions/Function1;", "I", "Z", "Ljava/util/List;", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "Landroidx/compose/ui/graphics/ColorProducer;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/AlignmentLine;", "baselineCache", "Ljava/util/Map;", "getBaselineCache$annotations", "_layoutCache", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", BuildConfig.FLAVOR, "semanticsTextLayoutResult", "textSubstitution", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "getTextSubstitution$foundation_release", "()Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "setTextSubstitution$foundation_release", "(Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;)V", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "layoutCache", "TextSubstitutionValue", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    private MultiParagraphLayoutCache _layoutCache;
    private Map<AlignmentLine, Integer> baselineCache;
    private FontFamily.Resolver fontFamilyResolver;
    private int maxLines;
    private int minLines;
    private Function1<? super List<Rect>, Unit> onPlaceholderLayout;
    private Function1<? super TextSubstitutionValue, Unit> onShowTranslation;
    private Function1<? super TextLayoutResult, Unit> onTextLayout;
    private int overflow;
    private ColorProducer overrideColor;
    private List<AnnotatedString.Range<Placeholder>> placeholders;
    private SelectionController selectionController;
    private Function1<? super List<TextLayoutResult>, Boolean> semanticsTextLayoutResult;
    private boolean softWrap;
    private TextStyle style;
    private AnnotatedString text;
    private TextSubstitutionValue textSubstitution;

    public /* synthetic */ TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1 function1, int i5, boolean z5, int i6, int i7, List list, Function1 function12, SelectionController selectionController, ColorProducer colorProducer, Function1 function13, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, textStyle, resolver, function1, i5, z5, i6, i7, list, function12, selectionController, colorProducer, function13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, null);
        }
        MultiParagraphLayoutCache multiParagraphLayoutCache = this._layoutCache;
        Intrinsics.checkNotNull(multiParagraphLayoutCache);
        return multiParagraphLayoutCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateForTranslate() {
        SemanticsModifierNodeKt.invalidateSemantics(this);
        LayoutModifierNodeKt.invalidateMeasurement(this);
        DrawModifierNodeKt.invalidateDraw(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setSubstitution(AnnotatedString updatedText) {
        Unit unit;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue == null) {
            TextSubstitutionValue textSubstitutionValue2 = new TextSubstitutionValue(this.text, updatedText, false, null, 12, null);
            MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders, null);
            multiParagraphLayoutCache.setDensity$foundation_release(getLayoutCache().getDensity());
            textSubstitutionValue2.setLayoutCache(multiParagraphLayoutCache);
            this.textSubstitution = textSubstitutionValue2;
            return true;
        }
        if (Intrinsics.areEqual(updatedText, textSubstitutionValue.getSubstitution())) {
            return false;
        }
        textSubstitutionValue.setSubstitution(updatedText);
        MultiParagraphLayoutCache layoutCache = textSubstitutionValue.getLayoutCache();
        if (layoutCache != null) {
            layoutCache.m611updateZNqEYIc(updatedText, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit != null;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Function1 function1 = this.semanticsTextLayoutResult;
        if (function1 == null) {
            function1 = new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x00bb  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x00bd  */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Boolean invoke(List<TextLayoutResult> list) {
                    MultiParagraphLayoutCache layoutCache;
                    TextLayoutResult textLayoutResult;
                    TextStyle textStyle;
                    ColorProducer colorProducer;
                    TextStyle m2308mergedA7vx0o;
                    layoutCache = TextAnnotatedStringNode.this.getLayoutCache();
                    TextLayoutResult layoutCache2 = layoutCache.getLayoutCache();
                    if (layoutCache2 != null) {
                        AnnotatedString text = layoutCache2.getLayoutInput().getText();
                        textStyle = TextAnnotatedStringNode.this.style;
                        colorProducer = TextAnnotatedStringNode.this.overrideColor;
                        m2308mergedA7vx0o = textStyle.m2308mergedA7vx0o((r58 & 1) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : colorProducer != null ? colorProducer.mo687invoke0d7_KjU() : Color.INSTANCE.m1501getUnspecified0d7_KjU(), (r58 & 2) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : 0L, (r58 & 4) != 0 ? null : null, (r58 & 8) != 0 ? null : null, (r58 & 16) != 0 ? null : null, (r58 & 32) != 0 ? null : null, (r58 & 64) != 0 ? null : null, (r58 & 128) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : 0L, (r58 & 256) != 0 ? null : null, (r58 & 512) != 0 ? null : null, (r58 & 1024) != 0 ? null : null, (r58 & 2048) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : 0L, (r58 & 4096) != 0 ? null : null, (r58 & 8192) != 0 ? null : null, (r58 & 16384) != 0 ? null : null, (r58 & 32768) != 0 ? TextAlign.INSTANCE.m2534getUnspecifiede0LSkKk() : 0, (r58 & 65536) != 0 ? TextDirection.INSTANCE.m2547getUnspecifieds_7Xco() : 0, (r58 & 131072) != 0 ? TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE() : 0L, (r58 & 262144) != 0 ? null : null, (r58 & 524288) != 0 ? null : null, (r58 & 1048576) != 0 ? LineBreak.INSTANCE.m2486getUnspecifiedrAG3T2k() : 0, (r58 & 2097152) != 0 ? Hyphens.INSTANCE.m2474getUnspecifiedvmbZdU8() : 0, (r58 & 4194304) != 0 ? null : null, (r58 & 8388608) != 0 ? null : null);
                        textLayoutResult = TextLayoutResult.m2268copyO0kMr_c$default(layoutCache2, new TextLayoutInput(text, m2308mergedA7vx0o, layoutCache2.getLayoutInput().getPlaceholders(), layoutCache2.getLayoutInput().getMaxLines(), layoutCache2.getLayoutInput().getSoftWrap(), layoutCache2.getLayoutInput().getOverflow(), layoutCache2.getLayoutInput().getDensity(), layoutCache2.getLayoutInput().getLayoutDirection(), layoutCache2.getLayoutInput().getFontFamilyResolver(), layoutCache2.getLayoutInput().getConstraints(), (DefaultConstructorMarker) null), 0L, 2, null);
                        if (textLayoutResult != null) {
                            list.add(textLayoutResult);
                            return Boolean.valueOf(textLayoutResult == null);
                        }
                    }
                    textLayoutResult = null;
                    return Boolean.valueOf(textLayoutResult == null);
                }
            };
            this.semanticsTextLayoutResult = function1;
        }
        SemanticsPropertiesKt.setText(semanticsPropertyReceiver, this.text);
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null) {
            SemanticsPropertiesKt.setTextSubstitution(semanticsPropertyReceiver, textSubstitutionValue.getSubstitution());
            SemanticsPropertiesKt.setShowingTextSubstitution(semanticsPropertyReceiver, textSubstitutionValue.getIsShowingSubstitution());
        }
        SemanticsPropertiesKt.setTextSubstitution$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(AnnotatedString annotatedString) {
                TextAnnotatedStringNode.this.setSubstitution(annotatedString);
                TextAnnotatedStringNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.showTextSubstitution$default(semanticsPropertyReceiver, null, new Function1<Boolean, Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final Boolean invoke(boolean z5) {
                Function1 function12;
                if (TextAnnotatedStringNode.this.getTextSubstitution() == null) {
                    return Boolean.FALSE;
                }
                function12 = TextAnnotatedStringNode.this.onShowTranslation;
                if (function12 != null) {
                    TextAnnotatedStringNode.TextSubstitutionValue textSubstitution = TextAnnotatedStringNode.this.getTextSubstitution();
                    Intrinsics.checkNotNull(textSubstitution);
                    function12.invoke(textSubstitution);
                }
                TextAnnotatedStringNode.TextSubstitutionValue textSubstitution2 = TextAnnotatedStringNode.this.getTextSubstitution();
                if (textSubstitution2 != null) {
                    textSubstitution2.setShowingSubstitution(z5);
                }
                TextAnnotatedStringNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.clearTextSubstitution$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$applySemantics$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextAnnotatedStringNode.this.clearSubstitution$foundation_release();
                TextAnnotatedStringNode.this.invalidateForTranslate();
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, function1, 1, null);
    }

    public final void clearSubstitution$foundation_release() {
        this.textSubstitution = null;
    }

    public final void doInvalidations(boolean drawChanged, boolean textChanged, boolean layoutChanged, boolean callbacksChanged) {
        if (textChanged || layoutChanged || callbacksChanged) {
            getLayoutCache().m611updateZNqEYIc(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, this.placeholders);
        }
        if (getIsAttached()) {
            if (textChanged || (drawChanged && this.semanticsTextLayoutResult != null)) {
                SemanticsModifierNodeKt.invalidateSemantics(this);
            }
            if (textChanged || layoutChanged || callbacksChanged) {
                LayoutModifierNodeKt.invalidateMeasurement(this);
                DrawModifierNodeKt.invalidateDraw(this);
            }
            if (drawChanged) {
                DrawModifierNodeKt.invalidateDraw(this);
            }
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        if (getIsAttached()) {
            Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
            TextLayoutResult textLayoutResult = getLayoutCache(contentDrawScope).getTextLayoutResult();
            MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
            boolean z5 = true;
            boolean z6 = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m2560equalsimpl0(this.overflow, TextOverflow.INSTANCE.m2565getVisiblegIe3tQ8());
            if (z6) {
                Rect m1362Recttz77jQw = RectKt.m1362Recttz77jQw(Offset.INSTANCE.m1349getZeroF1C5BW0(), SizeKt.Size(IntSize.m2661getWidthimpl(textLayoutResult.getSize()), IntSize.m2660getHeightimpl(textLayoutResult.getSize())));
                canvas.save();
                Canvas.m1475clipRectmtrdDE$default(canvas, m1362Recttz77jQw, 0, 2, null);
            }
            try {
                TextDecoration textDecoration = this.style.getTextDecoration();
                if (textDecoration == null) {
                    textDecoration = TextDecoration.INSTANCE.getNone();
                }
                TextDecoration textDecoration2 = textDecoration;
                Shadow shadow = this.style.getShadow();
                if (shadow == null) {
                    shadow = Shadow.INSTANCE.getNone();
                }
                Shadow shadow2 = shadow;
                DrawStyle drawStyle = this.style.getDrawStyle();
                if (drawStyle == null) {
                    drawStyle = Fill.INSTANCE;
                }
                DrawStyle drawStyle2 = drawStyle;
                Brush brush = this.style.getBrush();
                if (brush != null) {
                    multiParagraph.m2222painthn5TExg(canvas, brush, (r17 & 4) != 0 ? Float.NaN : this.style.getAlpha(), (r17 & 8) != 0 ? null : shadow2, (r17 & 16) != 0 ? null : textDecoration2, (r17 & 32) != 0 ? null : drawStyle2, (r17 & 64) != 0 ? DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU() : 0);
                } else {
                    ColorProducer colorProducer = this.overrideColor;
                    long mo687invoke0d7_KjU = colorProducer != null ? colorProducer.mo687invoke0d7_KjU() : Color.INSTANCE.m1501getUnspecified0d7_KjU();
                    if (mo687invoke0d7_KjU == 16) {
                        mo687invoke0d7_KjU = this.style.m2298getColor0d7_KjU() != 16 ? this.style.m2298getColor0d7_KjU() : Color.INSTANCE.m1496getBlack0d7_KjU();
                    }
                    multiParagraph.m2221paintLG529CI(canvas, (r14 & 2) != 0 ? Color.INSTANCE.m1501getUnspecified0d7_KjU() : mo687invoke0d7_KjU, (r14 & 4) != 0 ? null : shadow2, (r14 & 8) != 0 ? null : textDecoration2, (r14 & 16) == 0 ? drawStyle2 : null, (r14 & 32) != 0 ? DrawScope.INSTANCE.m1704getDefaultBlendMode0nO6VwU() : 0);
                }
                if (z6) {
                    canvas.restore();
                }
                TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
                if (!((textSubstitutionValue == null || !textSubstitutionValue.getIsShowingSubstitution()) ? TextAnnotatedStringNodeKt.hasLinks(this.text) : false)) {
                    List<AnnotatedString.Range<Placeholder>> list = this.placeholders;
                    if (list != null && !list.isEmpty()) {
                        z5 = false;
                    }
                    if (z5) {
                        return;
                    }
                }
                contentDrawScope.drawContent();
            } catch (Throwable th) {
                if (z6) {
                    canvas.restore();
                }
                throw th;
            }
        }
    }

    public final void drawNonExtension(ContentDrawScope contentDrawScope) {
        draw(contentDrawScope);
    }

    /* renamed from: getTextSubstitution$foundation_release, reason: from getter */
    public final TextSubstitutionValue getTextSubstitution() {
        return this.textSubstitution;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i5, intrinsicMeasureScope.getLayoutDirection());
    }

    public final int maxIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        return maxIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return getLayoutCache(intrinsicMeasureScope).maxIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public final int maxIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        return maxIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo46measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        MultiParagraphLayoutCache layoutCache = getLayoutCache(measureScope);
        boolean m610layoutWithConstraintsK40F9xA = layoutCache.m610layoutWithConstraintsK40F9xA(j5, measureScope.getLayoutDirection());
        TextLayoutResult textLayoutResult = layoutCache.getTextLayoutResult();
        textLayoutResult.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts();
        if (m610layoutWithConstraintsK40F9xA) {
            LayoutModifierNodeKt.invalidateLayer(this);
            Function1<? super TextLayoutResult, Unit> function1 = this.onTextLayout;
            if (function1 != null) {
                function1.invoke(textLayoutResult);
            }
            Map<AlignmentLine, Integer> map = this.baselineCache;
            if (map == null) {
                map = new LinkedHashMap<>(2);
            }
            map.put(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(textLayoutResult.getFirstBaseline())));
            map.put(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(textLayoutResult.getLastBaseline())));
            this.baselineCache = map;
        }
        Function1<? super List<Rect>, Unit> function12 = this.onPlaceholderLayout;
        if (function12 != null) {
            function12.invoke(textLayoutResult.getPlaceholderRects());
        }
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(Constraints.INSTANCE.m2586fitPrioritizingWidthZbe2FdA(IntSize.m2661getWidthimpl(textLayoutResult.getSize()), IntSize.m2661getWidthimpl(textLayoutResult.getSize()), IntSize.m2660getHeightimpl(textLayoutResult.getSize()), IntSize.m2660getHeightimpl(textLayoutResult.getSize())));
        int m2661getWidthimpl = IntSize.m2661getWidthimpl(textLayoutResult.getSize());
        int m2660getHeightimpl = IntSize.m2660getHeightimpl(textLayoutResult.getSize());
        Map<AlignmentLine, Integer> map2 = this.baselineCache;
        Intrinsics.checkNotNull(map2);
        return measureScope.layout(m2661getWidthimpl, m2660getHeightimpl, map2, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        });
    }

    /* renamed from: measureNonExtension-3p2s80s, reason: not valid java name */
    public final MeasureResult m618measureNonExtension3p2s80s(MeasureScope measureScope, Measurable measurable, long constraints) {
        return mo46measure3p2s80s(measureScope, measurable, constraints);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return getLayoutCache(intrinsicMeasureScope).intrinsicHeight(i5, intrinsicMeasureScope.getLayoutDirection());
    }

    public final int minIntrinsicHeightNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int width) {
        return minIntrinsicHeight(intrinsicMeasureScope, measurable, width);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i5) {
        return getLayoutCache(intrinsicMeasureScope).minIntrinsicWidth(intrinsicMeasureScope.getLayoutDirection());
    }

    public final int minIntrinsicWidthNonExtension(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int height) {
        return minIntrinsicWidth(intrinsicMeasureScope, measurable, height);
    }

    public final boolean updateCallbacks(Function1<? super TextLayoutResult, Unit> onTextLayout, Function1<? super List<Rect>, Unit> onPlaceholderLayout, SelectionController selectionController, Function1<? super TextSubstitutionValue, Unit> onShowTranslation) {
        boolean z5;
        if (this.onTextLayout != onTextLayout) {
            this.onTextLayout = onTextLayout;
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.onPlaceholderLayout != onPlaceholderLayout) {
            this.onPlaceholderLayout = onPlaceholderLayout;
            z5 = true;
        }
        if (!Intrinsics.areEqual(this.selectionController, selectionController)) {
            z5 = true;
        }
        if (this.onShowTranslation == onShowTranslation) {
            return z5;
        }
        this.onShowTranslation = onShowTranslation;
        return true;
    }

    public final boolean updateDraw(ColorProducer color, TextStyle style) {
        boolean areEqual = Intrinsics.areEqual(color, this.overrideColor);
        this.overrideColor = color;
        return (areEqual && style.hasSameDrawAffectingAttributes(this.style)) ? false : true;
    }

    /* renamed from: updateLayoutRelatedArgs-MPT68mk, reason: not valid java name */
    public final boolean m619updateLayoutRelatedArgsMPT68mk(TextStyle style, List<AnnotatedString.Range<Placeholder>> placeholders, int minLines, int maxLines, boolean softWrap, FontFamily.Resolver fontFamilyResolver, int overflow) {
        boolean z5 = !this.style.hasSameLayoutAffectingAttributes(style);
        this.style = style;
        if (!Intrinsics.areEqual(this.placeholders, placeholders)) {
            this.placeholders = placeholders;
            z5 = true;
        }
        if (this.minLines != minLines) {
            this.minLines = minLines;
            z5 = true;
        }
        if (this.maxLines != maxLines) {
            this.maxLines = maxLines;
            z5 = true;
        }
        if (this.softWrap != softWrap) {
            this.softWrap = softWrap;
            z5 = true;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamilyResolver)) {
            this.fontFamilyResolver = fontFamilyResolver;
            z5 = true;
        }
        if (TextOverflow.m2560equalsimpl0(this.overflow, overflow)) {
            return z5;
        }
        this.overflow = overflow;
        return true;
    }

    public final boolean updateText$foundation_release(AnnotatedString text) {
        boolean areEqual = Intrinsics.areEqual(this.text.getText(), text.getText());
        boolean z5 = (areEqual && Intrinsics.areEqual(this.text.getSpanStyles(), text.getSpanStyles()) && Intrinsics.areEqual(this.text.getParagraphStyles(), text.getParagraphStyles()) && this.text.hasEqualAnnotations(text)) ? false : true;
        if (z5) {
            this.text = text;
        }
        if (!areEqual) {
            clearSubstitution$foundation_release();
        }
        return z5;
    }

    private TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily.Resolver resolver, Function1<? super TextLayoutResult, Unit> function1, int i5, boolean z5, int i6, int i7, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextSubstitutionValue, Unit> function13) {
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = resolver;
        this.onTextLayout = function1;
        this.overflow = i5;
        this.softWrap = z5;
        this.maxLines = i6;
        this.minLines = i7;
        this.placeholders = list;
        this.onPlaceholderLayout = function12;
        this.overrideColor = colorProducer;
        this.onShowTranslation = function13;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016\"\u0004\b\u0018\u0010\u0019R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u0006\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString;", "original", "substitution", BuildConfig.FLAVOR, "isShowingSubstitution", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "layoutCache", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/AnnotatedString;ZLandroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/text/AnnotatedString;", "getOriginal", "()Landroidx/compose/ui/text/AnnotatedString;", "getSubstitution", "setSubstitution", "(Landroidx/compose/ui/text/AnnotatedString;)V", "Z", "()Z", "setShowingSubstitution", "(Z)V", "Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "getLayoutCache", "()Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;", "setLayoutCache", "(Landroidx/compose/foundation/text/modifiers/MultiParagraphLayoutCache;)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class TextSubstitutionValue {
        private boolean isShowingSubstitution;
        private MultiParagraphLayoutCache layoutCache;
        private final AnnotatedString original;
        private AnnotatedString substitution;

        public TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z5, MultiParagraphLayoutCache multiParagraphLayoutCache) {
            this.original = annotatedString;
            this.substitution = annotatedString2;
            this.isShowingSubstitution = z5;
            this.layoutCache = multiParagraphLayoutCache;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) other;
            return Intrinsics.areEqual(this.original, textSubstitutionValue.original) && Intrinsics.areEqual(this.substitution, textSubstitutionValue.substitution) && this.isShowingSubstitution == textSubstitutionValue.isShowingSubstitution && Intrinsics.areEqual(this.layoutCache, textSubstitutionValue.layoutCache);
        }

        public final MultiParagraphLayoutCache getLayoutCache() {
            return this.layoutCache;
        }

        public final AnnotatedString getOriginal() {
            return this.original;
        }

        public final AnnotatedString getSubstitution() {
            return this.substitution;
        }

        public int hashCode() {
            int hashCode = ((((this.original.hashCode() * 31) + this.substitution.hashCode()) * 31) + Boolean.hashCode(this.isShowingSubstitution)) * 31;
            MultiParagraphLayoutCache multiParagraphLayoutCache = this.layoutCache;
            return hashCode + (multiParagraphLayoutCache == null ? 0 : multiParagraphLayoutCache.hashCode());
        }

        /* renamed from: isShowingSubstitution, reason: from getter */
        public final boolean getIsShowingSubstitution() {
            return this.isShowingSubstitution;
        }

        public final void setLayoutCache(MultiParagraphLayoutCache multiParagraphLayoutCache) {
            this.layoutCache = multiParagraphLayoutCache;
        }

        public final void setShowingSubstitution(boolean z5) {
            this.isShowingSubstitution = z5;
        }

        public final void setSubstitution(AnnotatedString annotatedString) {
            this.substitution = annotatedString;
        }

        public String toString() {
            return "TextSubstitutionValue(original=" + ((Object) this.original) + ", substitution=" + ((Object) this.substitution) + ", isShowingSubstitution=" + this.isShowingSubstitution + ", layoutCache=" + this.layoutCache + ')';
        }

        public /* synthetic */ TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2, boolean z5, MultiParagraphLayoutCache multiParagraphLayoutCache, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(annotatedString, annotatedString2, (i5 & 4) != 0 ? false : z5, (i5 & 8) != 0 ? null : multiParagraphLayoutCache);
        }
    }

    private final MultiParagraphLayoutCache getLayoutCache(Density density) {
        MultiParagraphLayoutCache layoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null && textSubstitutionValue.getIsShowingSubstitution() && (layoutCache = textSubstitutionValue.getLayoutCache()) != null) {
            layoutCache.setDensity$foundation_release(density);
            return layoutCache;
        }
        MultiParagraphLayoutCache layoutCache2 = getLayoutCache();
        layoutCache2.setDensity$foundation_release(density);
        return layoutCache2;
    }
}
