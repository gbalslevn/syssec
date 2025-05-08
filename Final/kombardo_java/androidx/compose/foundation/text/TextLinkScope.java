package androidx.compose.foundation.text;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.TextLinkScope;
import androidx.compose.foundation.text.TextRangeLayoutMeasureResult;
import androidx.compose.foundation.text.TextRangeLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\u00020\u0006*\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\r\u0010\fJ#\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\t2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u0004\u0018\u00010\u0018*\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J;\u0010&\u001a\u00020\u001e2\u0016\u0010\"\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010!\"\u0004\u0018\u00010\u00012\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e0#H\u0003¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001eH\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010,\u001a\u00020\u0002H\u0000¢\u0006\u0004\b*\u0010+R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010+R/\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010/\u001a\u0004\u0018\u00010\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u0010-\u001a\u0004\b7\u0010+\"\u0004\b8\u0010\u0005R&\u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u001e0#098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020=0<8F¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Landroidx/compose/foundation/text/TextLinkScope;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString;", "initialText", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;)V", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "Landroidx/compose/foundation/text/LinkRange;", "link", "textRange", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString$Range;)Landroidx/compose/ui/Modifier;", "clipLink", "Landroidx/compose/ui/graphics/Shape;", "shapeForRange", "(Landroidx/compose/ui/text/AnnotatedString$Range;)Landroidx/compose/ui/graphics/Shape;", "Landroidx/compose/ui/graphics/Path;", "pathForRangeInRangeCoordinates", "(Landroidx/compose/ui/text/AnnotatedString$Range;)Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "calculateVisibleLinkRange", "(Landroidx/compose/ui/text/AnnotatedString$Range;Landroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "other", "mergeOrUse", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/platform/UriHandler;", "uriHandler", BuildConfig.FLAVOR, "handleLink", "(Landroidx/compose/ui/text/LinkAnnotation;Landroidx/compose/ui/platform/UriHandler;)V", BuildConfig.FLAVOR, "keys", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/TextAnnotatorScope;", "block", "StyleAnnotation", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LinksComposables", "(Landroidx/compose/runtime/Composer;I)V", "applyAnnotators$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "applyAnnotators", "Landroidx/compose/ui/text/AnnotatedString;", "getInitialText$foundation_release", "<set-?>", "textLayoutResult$delegate", "Landroidx/compose/runtime/MutableState;", "getTextLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setTextLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "text", "getText$foundation_release", "setText$foundation_release", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "annotators", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "getShouldMeasureLinks", "()Lkotlin/jvm/functions/Function0;", "shouldMeasureLinks", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextLinkScope {
    private final SnapshotStateList<Function1<TextAnnotatorScope, Unit>> annotators;
    private final AnnotatedString initialText;
    private AnnotatedString text;

    /* renamed from: textLayoutResult$delegate, reason: from kotlin metadata */
    private final MutableState textLayoutResult;

    public TextLinkScope(AnnotatedString annotatedString) {
        MutableState mutableStateOf$default;
        SpanStyle style;
        this.initialText = annotatedString;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.textLayoutResult = mutableStateOf$default;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(annotatedString);
        List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
        int size = linkAnnotations.size();
        for (int i5 = 0; i5 < size; i5++) {
            AnnotatedString.Range<LinkAnnotation> range = linkAnnotations.get(i5);
            TextLinkStyles styles = range.getItem().getStyles();
            if (styles != null && (style = styles.getStyle()) != null) {
                builder.addStyle(style, range.getStart(), range.getEnd());
            }
        }
        this.text = builder.toAnnotatedString();
        this.annotators = SnapshotStateKt.mutableStateListOf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void StyleAnnotation(final Object[] objArr, final Function1<? super TextAnnotatorScope, Unit> function1, Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(-2083052099);
        int i6 = (i5 & 48) == 0 ? (startRestartGroup.changedInstance(function1) ? 32 : 16) | i5 : i5;
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(this) ? 256 : 128;
        }
        startRestartGroup.startMovableGroup(-416630839, Integer.valueOf(objArr.length));
        for (Object obj : objArr) {
            i6 |= startRestartGroup.changedInstance(obj) ? 4 : 0;
        }
        startRestartGroup.endMovableGroup();
        if ((i6 & 14) == 0) {
            i6 |= 2;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2083052099, i6, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:298)");
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(function1);
            spreadBuilder.addSpread(objArr);
            Object[] array = spreadBuilder.toArray(new Object[spreadBuilder.size()]);
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(this);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        SnapshotStateList snapshotStateList;
                        snapshotStateList = TextLinkScope.this.annotators;
                        snapshotStateList.add(function1);
                        final TextLinkScope textLinkScope = TextLinkScope.this;
                        final Function1<TextAnnotatorScope, Unit> function12 = function1;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                SnapshotStateList snapshotStateList2;
                                snapshotStateList2 = TextLinkScope.this.annotators;
                                snapshotStateList2.remove(function12);
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            EffectsKt.DisposableEffect(array, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$StyleAnnotation$2
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
                    TextLinkScope textLinkScope = TextLinkScope.this;
                    Object[] objArr2 = objArr;
                    textLinkScope.StyleAnnotation(Arrays.copyOf(objArr2, objArr2.length), function1, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    private final AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange(AnnotatedString.Range<LinkAnnotation> link, TextLayoutResult textLayoutResult) {
        int lineEnd$default = TextLayoutResult.getLineEnd$default(textLayoutResult, textLayoutResult.getLineCount() - 1, false, 2, null);
        if (link.getStart() < lineEnd$default) {
            return AnnotatedString.Range.copy$default(link, null, 0, Math.min(link.getEnd(), lineEnd$default), null, 11, null);
        }
        return null;
    }

    private final Modifier clipLink(Modifier modifier, final AnnotatedString.Range<LinkAnnotation> range) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$clipLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                Shape shapeForRange;
                shapeForRange = TextLinkScope.this.shapeForRange(range);
                if (shapeForRange != null) {
                    graphicsLayerScope.setShape(shapeForRange);
                    graphicsLayerScope.setClip(true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleLink(LinkAnnotation link, UriHandler uriHandler) {
        if (link instanceof LinkAnnotation.Url) {
            link.getLinkInteractionListener();
            try {
                uriHandler.openUri(((LinkAnnotation.Url) link).getUrl());
            } catch (IllegalArgumentException unused) {
            }
        } else if (link instanceof LinkAnnotation.Clickable) {
            link.getLinkInteractionListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SpanStyle mergeOrUse(SpanStyle spanStyle, SpanStyle spanStyle2) {
        SpanStyle merge;
        return (spanStyle == null || (merge = spanStyle.merge(spanStyle2)) == null) ? spanStyle2 : merge;
    }

    private final Path pathForRangeInRangeCoordinates(AnnotatedString.Range<LinkAnnotation> link) {
        TextLayoutResult textLayoutResult;
        Path path = null;
        if (getShouldMeasureLinks().invoke().booleanValue() && (textLayoutResult = getTextLayoutResult()) != null) {
            AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange = calculateVisibleLinkRange(link, textLayoutResult);
            if (calculateVisibleLinkRange == null) {
                return null;
            }
            path = textLayoutResult.getPathForRange(calculateVisibleLinkRange.getStart(), calculateVisibleLinkRange.getEnd());
            Rect boundingBox = textLayoutResult.getBoundingBox(calculateVisibleLinkRange.getStart());
            path.mo1424translatek4lQ0M(Offset.m1345unaryMinusF1C5BW0(OffsetKt.Offset(textLayoutResult.getLineForOffset(calculateVisibleLinkRange.getStart()) == textLayoutResult.getLineForOffset(calculateVisibleLinkRange.getEnd() + (-1)) ? Math.min(textLayoutResult.getBoundingBox(calculateVisibleLinkRange.getEnd() - 1).getLeft(), boundingBox.getLeft()) : 0.0f, boundingBox.getTop())));
        }
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Shape shapeForRange(AnnotatedString.Range<LinkAnnotation> link) {
        final Path pathForRangeInRangeCoordinates = pathForRangeInRangeCoordinates(link);
        if (pathForRangeInRangeCoordinates != null) {
            return new Shape() { // from class: androidx.compose.foundation.text.TextLinkScope$shapeForRange$1$1
                @Override // androidx.compose.ui.graphics.Shape
                /* renamed from: createOutline-Pq9zytI */
                public Outline mo131createOutlinePq9zytI(long size, LayoutDirection layoutDirection, Density density) {
                    return new Outline.Generic(Path.this);
                }
            };
        }
        return null;
    }

    private final Modifier textRange(Modifier modifier, final AnnotatedString.Range<LinkAnnotation> range) {
        return modifier.then(new TextRangeLayoutModifier(new TextRangeScopeMeasurePolicy() { // from class: g.a
            @Override // androidx.compose.foundation.text.TextRangeScopeMeasurePolicy
            public final TextRangeLayoutMeasureResult measure(TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
                TextRangeLayoutMeasureResult textRange$lambda$3;
                textRange$lambda$3 = TextLinkScope.textRange$lambda$3(TextLinkScope.this, range, textRangeLayoutMeasureScope);
                return textRange$lambda$3;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRangeLayoutMeasureResult textRange$lambda$3(TextLinkScope textLinkScope, AnnotatedString.Range range, TextRangeLayoutMeasureScope textRangeLayoutMeasureScope) {
        TextLayoutResult textLayoutResult = textLinkScope.getTextLayoutResult();
        if (textLayoutResult == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$layoutResult$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ IntOffset invoke() {
                    return IntOffset.m2632boximpl(m559invokenOccac());
                }

                /* renamed from: invoke-nOcc-ac, reason: not valid java name */
                public final long m559invokenOccac() {
                    return IntOffset.INSTANCE.m2648getZeronOccac();
                }
            });
        }
        AnnotatedString.Range<LinkAnnotation> calculateVisibleLinkRange = textLinkScope.calculateVisibleLinkRange(range, textLayoutResult);
        if (calculateVisibleLinkRange == null) {
            return textRangeLayoutMeasureScope.layout(0, 0, new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$updatedRange$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ IntOffset invoke() {
                    return IntOffset.m2632boximpl(m560invokenOccac());
                }

                /* renamed from: invoke-nOcc-ac, reason: not valid java name */
                public final long m560invokenOccac() {
                    return IntOffset.INSTANCE.m2648getZeronOccac();
                }
            });
        }
        final IntRect roundToIntRect = IntRectKt.roundToIntRect(textLayoutResult.getPathForRange(calculateVisibleLinkRange.getStart(), calculateVisibleLinkRange.getEnd()).getBounds());
        return textRangeLayoutMeasureScope.layout(roundToIntRect.getWidth(), roundToIntRect.getHeight(), new Function0<IntOffset>() { // from class: androidx.compose.foundation.text.TextLinkScope$textRange$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ IntOffset invoke() {
                return IntOffset.m2632boximpl(m558invokenOccac());
            }

            /* renamed from: invoke-nOcc-ac, reason: not valid java name */
            public final long m558invokenOccac() {
                return IntRect.this.m2654getTopLeftnOccac();
            }
        });
    }

    public final void LinksComposables(Composer composer, final int i5) {
        int i6;
        Modifier m123combinedClickableXVZzFYc;
        boolean isNullOrEmpty;
        SpanStyle spanStyle;
        Composer startRestartGroup = composer.startRestartGroup(1154651354);
        int i7 = 2;
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(this) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1154651354, i6, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:200)");
            }
            final UriHandler uriHandler = (UriHandler) startRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
            AnnotatedString annotatedString = this.text;
            List<AnnotatedString.Range<LinkAnnotation>> linkAnnotations = annotatedString.getLinkAnnotations(0, annotatedString.length());
            int size = linkAnnotations.size();
            int i8 = 0;
            while (i8 < size) {
                final AnnotatedString.Range<LinkAnnotation> range = linkAnnotations.get(i8);
                if (range.getStart() != range.getEnd()) {
                    startRestartGroup.startReplaceGroup(1385536272);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                    Modifier semantics$default = SemanticsModifierKt.semantics$default(PointerIconKt.pointerHoverIcon$default(HoverableKt.hoverable$default(textRange(clipLink(Modifier.INSTANCE, range), range), mutableInteractionSource, false, i7, null), PointerIcon.INSTANCE.getHand(), false, i7, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.invisibleToUser(semanticsPropertyReceiver);
                        }
                    }, 1, null);
                    boolean changedInstance = startRestartGroup.changedInstance(this) | startRestartGroup.changed(range) | startRestartGroup.changedInstance(uriHandler);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                        rememberedValue2 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$2$1
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
                                TextLinkScope.this.handleLink(range.getItem(), uriHandler);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    m123combinedClickableXVZzFYc = ClickableKt.m123combinedClickableXVZzFYc(semantics$default, mutableInteractionSource, null, (r22 & 4) != 0, (r22 & 8) != 0 ? null : null, (r22 & 16) != 0 ? null : null, (r22 & 32) != 0 ? null : null, (r22 & 64) != 0 ? null : null, (r22 & 128) != 0 ? null : null, (Function0) rememberedValue2);
                    BoxKt.Box(m123combinedClickableXVZzFYc, startRestartGroup, 0);
                    isNullOrEmpty = TextLinkScopeKt.isNullOrEmpty(range.getItem().getStyles());
                    if (isNullOrEmpty) {
                        startRestartGroup.startReplaceGroup(1388165134);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(1386296950);
                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == companion.getEmpty()) {
                            rememberedValue3 = new LinkStateInteractionSourceObserver();
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        final LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = (LinkStateInteractionSourceObserver) rememberedValue3;
                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                        if (rememberedValue4 == companion.getEmpty()) {
                            spanStyle = null;
                            rememberedValue4 = new TextLinkScope$LinksComposables$1$3$1(linkStateInteractionSourceObserver, mutableInteractionSource, null);
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        } else {
                            spanStyle = null;
                        }
                        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, 6);
                        Boolean valueOf = Boolean.valueOf(linkStateInteractionSourceObserver.isHovered());
                        Boolean valueOf2 = Boolean.valueOf(linkStateInteractionSourceObserver.isFocused());
                        Boolean valueOf3 = Boolean.valueOf(linkStateInteractionSourceObserver.isPressed());
                        TextLinkStyles styles = range.getItem().getStyles();
                        SpanStyle style = styles != null ? styles.getStyle() : spanStyle;
                        TextLinkStyles styles2 = range.getItem().getStyles();
                        SpanStyle focusedStyle = styles2 != null ? styles2.getFocusedStyle() : spanStyle;
                        TextLinkStyles styles3 = range.getItem().getStyles();
                        SpanStyle hoveredStyle = styles3 != null ? styles3.getHoveredStyle() : spanStyle;
                        TextLinkStyles styles4 = range.getItem().getStyles();
                        Object[] objArr = {valueOf, valueOf2, valueOf3, style, focusedStyle, hoveredStyle, styles4 != null ? styles4.getPressedStyle() : spanStyle};
                        boolean changedInstance2 = startRestartGroup.changedInstance(this) | startRestartGroup.changed(range);
                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                        if (changedInstance2 || rememberedValue5 == companion.getEmpty()) {
                            rememberedValue5 = new Function1<TextAnnotatorScope, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$1$4$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatorScope textAnnotatorScope) {
                                    invoke2(textAnnotatorScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextAnnotatorScope textAnnotatorScope) {
                                    SpanStyle mergeOrUse;
                                    SpanStyle mergeOrUse2;
                                    SpanStyle mergeOrUse3;
                                    TextLinkStyles styles5;
                                    TextLinkStyles styles6;
                                    TextLinkStyles styles7;
                                    TextLinkScope textLinkScope = TextLinkScope.this;
                                    TextLinkStyles styles8 = range.getItem().getStyles();
                                    SpanStyle spanStyle2 = null;
                                    mergeOrUse = textLinkScope.mergeOrUse(styles8 != null ? styles8.getStyle() : null, (!linkStateInteractionSourceObserver.isFocused() || (styles7 = range.getItem().getStyles()) == null) ? null : styles7.getFocusedStyle());
                                    mergeOrUse2 = textLinkScope.mergeOrUse(mergeOrUse, (!linkStateInteractionSourceObserver.isHovered() || (styles6 = range.getItem().getStyles()) == null) ? null : styles6.getHoveredStyle());
                                    if (linkStateInteractionSourceObserver.isPressed() && (styles5 = range.getItem().getStyles()) != null) {
                                        spanStyle2 = styles5.getPressedStyle();
                                    }
                                    mergeOrUse3 = textLinkScope.mergeOrUse(mergeOrUse2, spanStyle2);
                                    if (mergeOrUse3 != null) {
                                        AnnotatedString.Range<LinkAnnotation> range2 = range;
                                        textAnnotatorScope.replaceStyle(mergeOrUse3, range2.getStart(), range2.getEnd());
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                        }
                        StyleAnnotation(objArr, (Function1) rememberedValue5, startRestartGroup, (i6 << 6) & 896);
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1388179022);
                    startRestartGroup.endReplaceGroup();
                }
                i8++;
                i7 = 2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.TextLinkScope$LinksComposables$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    TextLinkScope.this.LinksComposables(composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public final AnnotatedString applyAnnotators$foundation_release() {
        AnnotatedString annotatedString;
        if (this.annotators.isEmpty()) {
            annotatedString = this.text;
        } else {
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            builder.append(this.initialText);
            TextAnnotatorScope textAnnotatorScope = new TextAnnotatorScope(builder);
            SnapshotStateList<Function1<TextAnnotatorScope, Unit>> snapshotStateList = this.annotators;
            int size = snapshotStateList.size();
            for (int i5 = 0; i5 < size; i5++) {
                snapshotStateList.get(i5).invoke(textAnnotatorScope);
            }
            annotatedString = builder.toAnnotatedString();
        }
        this.text = annotatedString;
        return annotatedString;
    }

    public final Function0<Boolean> getShouldMeasureLinks() {
        return new Function0<Boolean>() { // from class: androidx.compose.foundation.text.TextLinkScope$shouldMeasureLinks$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                TextLayoutInput layoutInput;
                AnnotatedString text = TextLinkScope.this.getText();
                TextLayoutResult textLayoutResult = TextLinkScope.this.getTextLayoutResult();
                return Boolean.valueOf(Intrinsics.areEqual(text, (textLayoutResult == null || (layoutInput = textLayoutResult.getLayoutInput()) == null) ? null : layoutInput.getText()));
            }
        };
    }

    /* renamed from: getText$foundation_release, reason: from getter */
    public final AnnotatedString getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextLayoutResult getTextLayoutResult() {
        return (TextLayoutResult) this.textLayoutResult.getValue();
    }

    public final void setTextLayoutResult(TextLayoutResult textLayoutResult) {
        this.textLayoutResult.setValue(textLayoutResult);
    }
}
