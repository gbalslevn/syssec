package androidx.compose.foundation.text;

import android.support.v4.media.session.a;
import androidx.compose.foundation.text.modifiers.SelectionController;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringElement;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode;
import androidx.compose.foundation.text.modifiers.TextAnnotatedStringNodeKt;
import androidx.compose.foundation.text.modifiers.TextStringSimpleElement;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001az\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0090\u0001\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u00172\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aG\u0010$\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001f0!\u0018\u00010\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001fH\u0002¢\u0006\u0004\b$\u0010%\u001aÂ\u0001\u00103\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&2\u0014\u0010*\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0018\u00010\u001c2\u001c\u0010,\u001a\u0018\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u001c\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a°\u0001\u00107\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00162\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u00104\u001a\u00020\f2\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b5\u00106\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069²\u0006\u000e\u00108\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002"}, d2 = {BuildConfig.FLAVOR, "text", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/text/TextStyle;", "style", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", BuildConfig.FLAVOR, "onTextLayout", "Landroidx/compose/ui/text/style/TextOverflow;", "overflow", BuildConfig.FLAVOR, "softWrap", BuildConfig.FLAVOR, "maxLines", "minLines", "Landroidx/compose/ui/graphics/ColorProducer;", "color", "BasicText-VhcvRP8", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", "BasicText", "Landroidx/compose/ui/text/AnnotatedString;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "inlineContent", "BasicText-RWo7tUw", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILjava/util/Map;Landroidx/compose/ui/graphics/ColorProducer;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Measurable;", "measurables", "Lkotlin/Function0;", "shouldMeasureLinks", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/unit/IntOffset;", "measureWithTextRangeMeasureConstraints", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "Landroidx/compose/ui/geometry/Rect;", "onPlaceholderLayout", "Landroidx/compose/foundation/text/modifiers/SelectionController;", "selectionController", "Landroidx/compose/foundation/text/modifiers/TextAnnotatedStringNode$TextSubstitutionValue;", "onShowTranslation", "textModifier-cFh6CEA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/Modifier;", "textModifier", "hasInlineContent", "LayoutWithLinksAndInlineContent-vOo2fZY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;Lkotlin/jvm/functions/Function1;ZLjava/util/Map;Landroidx/compose/ui/text/TextStyle;IZIILandroidx/compose/ui/text/font/FontFamily$Resolver;Landroidx/compose/foundation/text/modifiers/SelectionController;Landroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LayoutWithLinksAndInlineContent", "displayedText", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BasicTextKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02f9  */
    /* renamed from: BasicText-RWo7tUw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m464BasicTextRWo7tUw(final AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i5, boolean z5, int i6, int i7, Map<String, Object> map, ColorProducer colorProducer, Composer composer, final int i8, final int i9) {
        int i10;
        int i11;
        int i12;
        Function1<? super TextLayoutResult, Unit> function12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Modifier modifier2;
        TextStyle textStyle2;
        Function1<? super TextLayoutResult, Unit> function13;
        int m2563getClipgIe3tQ8;
        boolean z6;
        int i20;
        int i21;
        Map<String, Object> emptyMap;
        ColorProducer colorProducer2;
        boolean hasInlineContent;
        int i22;
        int i23;
        Composer composer2;
        boolean z7;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        final int i24;
        final int i25;
        final TextStyle textStyle3;
        final Function1<? super TextLayoutResult, Unit> function14;
        final int i26;
        final boolean z8;
        final Map<String, Object> map2;
        final ColorProducer colorProducer3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1064305212);
        if ((i9 & 1) != 0) {
            i10 = i8 | 6;
        } else if ((i8 & 6) == 0) {
            i10 = (startRestartGroup.changed(annotatedString) ? 4 : 2) | i8;
        } else {
            i10 = i8;
        }
        int i27 = i9 & 2;
        if (i27 != 0) {
            i10 |= 48;
        } else if ((i8 & 48) == 0) {
            i10 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i11 = i9 & 4;
            if (i11 == 0) {
                i10 |= 384;
            } else if ((i8 & 384) == 0) {
                i10 |= startRestartGroup.changed(textStyle) ? 256 : 128;
                i12 = i9 & 8;
                if (i12 != 0) {
                    i10 |= 3072;
                } else if ((i8 & 3072) == 0) {
                    function12 = function1;
                    i10 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    i13 = i9 & 16;
                    if (i13 == 0) {
                        i10 |= 24576;
                    } else if ((i8 & 24576) == 0) {
                        i14 = i5;
                        i10 |= startRestartGroup.changed(i14) ? 16384 : 8192;
                        i15 = i9 & 32;
                        if (i15 != 0) {
                            i10 |= 196608;
                        } else if ((i8 & 196608) == 0) {
                            i10 |= startRestartGroup.changed(z5) ? 131072 : 65536;
                        }
                        i16 = i9 & 64;
                        if (i16 != 0) {
                            i10 |= 1572864;
                        } else if ((i8 & 1572864) == 0) {
                            i10 |= startRestartGroup.changed(i6) ? 1048576 : 524288;
                        }
                        i17 = i9 & 128;
                        if (i17 != 0) {
                            i10 |= 12582912;
                        } else if ((i8 & 12582912) == 0) {
                            i10 |= startRestartGroup.changed(i7) ? 8388608 : 4194304;
                        }
                        i18 = i9 & 256;
                        if (i18 != 0) {
                            i10 |= 100663296;
                        } else if ((i8 & 100663296) == 0) {
                            i10 |= startRestartGroup.changedInstance(map) ? 67108864 : 33554432;
                        }
                        i19 = i9 & 512;
                        if (i19 != 0) {
                            i10 |= 805306368;
                        } else if ((i8 & 805306368) == 0) {
                            i10 |= startRestartGroup.changedInstance(colorProducer) ? 536870912 : 268435456;
                        }
                        if ((i10 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            modifier2 = i27 != 0 ? Modifier.INSTANCE : modifier;
                            textStyle2 = i11 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                            function13 = i12 != 0 ? null : function12;
                            m2563getClipgIe3tQ8 = i13 != 0 ? TextOverflow.INSTANCE.m2563getClipgIe3tQ8() : i14;
                            z6 = i15 != 0 ? true : z5;
                            i20 = i16 != 0 ? Integer.MAX_VALUE : i6;
                            i21 = i17 != 0 ? 1 : i7;
                            emptyMap = i18 != 0 ? MapsKt.emptyMap() : map;
                            colorProducer2 = i19 != 0 ? null : colorProducer;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1064305212, i10, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:191)");
                            }
                            HeightInLinesModifierKt.validateMinMaxLines(i21, i20);
                            a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
                            startRestartGroup.startReplaceGroup(-1584467526);
                            startRestartGroup.endReplaceGroup();
                            hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
                            boolean hasLinks = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
                            if (!hasInlineContent || hasLinks) {
                                i22 = i21;
                                i23 = i20;
                                composer2 = startRestartGroup;
                                composer2.startReplaceGroup(-1583391888);
                                z7 = (i10 & 14) == 4;
                                rememberedValue = composer2.rememberedValue();
                                if (!z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString, null, 2, null);
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                final MutableState mutableState = (MutableState) rememberedValue;
                                AnnotatedString BasicText_RWo7tUw$lambda$5 = BasicText_RWo7tUw$lambda$5(mutableState);
                                FontFamily.Resolver resolver = (FontFamily.Resolver) composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                changed = composer2.changed(mutableState);
                                rememberedValue2 = composer2.rememberedValue();
                                if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                                            invoke2(textSubstitutionValue);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                                            AnnotatedString original;
                                            MutableState<AnnotatedString> mutableState2 = mutableState;
                                            if (textSubstitutionValue.getIsShowingSubstitution()) {
                                                original = textSubstitutionValue.getSubstitution();
                                            } else {
                                                original = textSubstitutionValue.getOriginal();
                                            }
                                            mutableState2.setValue(original);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                int i28 = i10 << 6;
                                m466LayoutWithLinksAndInlineContentvOo2fZY(modifier2, BasicText_RWo7tUw$lambda$5, function13, hasInlineContent, emptyMap, textStyle2, m2563getClipgIe3tQ8, z6, i23, i22, resolver, null, colorProducer2, (Function1) rememberedValue2, composer2, ((i10 >> 3) & 910) | ((i10 >> 12) & 57344) | ((i10 << 9) & 458752) | (3670016 & i28) | (29360128 & i28) | (234881024 & i28) | (i28 & 1879048192), (i10 >> 21) & 896, 0);
                                composer2.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(-1584294453);
                                i22 = i21;
                                i23 = i20;
                                Modifier m468textModifiercFh6CEA = m468textModifiercFh6CEA(GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), annotatedString, textStyle2, function13, m2563getClipgIe3tQ8, z6, i20, i21, (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver()), null, null, null, colorProducer2, null);
                                EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                composer2 = startRestartGroup;
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m468textModifiercFh6CEA);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                if (composer2.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                                Updater.m1227setimpl(m1226constructorimpl, emptyMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                composer2.endNode();
                                composer2.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i24 = i22;
                            i25 = i23;
                            textStyle3 = textStyle2;
                            function14 = function13;
                            i26 = m2563getClipgIe3tQ8;
                            z8 = z6;
                            map2 = emptyMap;
                            colorProducer3 = colorProducer2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            textStyle3 = textStyle;
                            z8 = z5;
                            i25 = i6;
                            i24 = i7;
                            colorProducer3 = colorProducer;
                            function14 = function12;
                            i26 = i14;
                            composer2 = startRestartGroup;
                            map2 = map;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$3
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

                                public final void invoke(Composer composer3, int i29) {
                                    BasicTextKt.m464BasicTextRWo7tUw(AnnotatedString.this, modifier3, textStyle3, function14, i26, z8, i25, i24, map2, colorProducer3, composer3, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), i9);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i14 = i5;
                    i15 = i9 & 32;
                    if (i15 != 0) {
                    }
                    i16 = i9 & 64;
                    if (i16 != 0) {
                    }
                    i17 = i9 & 128;
                    if (i17 != 0) {
                    }
                    i18 = i9 & 256;
                    if (i18 != 0) {
                    }
                    i19 = i9 & 512;
                    if (i19 != 0) {
                    }
                    if ((i10 & 306783379) == 306783378) {
                    }
                    if (i27 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
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
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    HeightInLinesModifierKt.validateMinMaxLines(i21, i20);
                    a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
                    startRestartGroup.startReplaceGroup(-1584467526);
                    startRestartGroup.endReplaceGroup();
                    hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
                    boolean hasLinks2 = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
                    if (hasInlineContent) {
                    }
                    i22 = i21;
                    i23 = i20;
                    composer2 = startRestartGroup;
                    composer2.startReplaceGroup(-1583391888);
                    if ((i10 & 14) == 4) {
                    }
                    rememberedValue = composer2.rememberedValue();
                    if (!z7) {
                    }
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString, null, 2, null);
                    composer2.updateRememberedValue(rememberedValue);
                    final MutableState<AnnotatedString> mutableState2 = (MutableState) rememberedValue;
                    AnnotatedString BasicText_RWo7tUw$lambda$52 = BasicText_RWo7tUw$lambda$5(mutableState2);
                    FontFamily.Resolver resolver2 = (FontFamily.Resolver) composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                    changed = composer2.changed(mutableState2);
                    rememberedValue2 = composer2.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                            invoke2(textSubstitutionValue);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                            AnnotatedString original;
                            MutableState<AnnotatedString> mutableState22 = mutableState2;
                            if (textSubstitutionValue.getIsShowingSubstitution()) {
                                original = textSubstitutionValue.getSubstitution();
                            } else {
                                original = textSubstitutionValue.getOriginal();
                            }
                            mutableState22.setValue(original);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                    int i282 = i10 << 6;
                    m466LayoutWithLinksAndInlineContentvOo2fZY(modifier2, BasicText_RWo7tUw$lambda$52, function13, hasInlineContent, emptyMap, textStyle2, m2563getClipgIe3tQ8, z6, i23, i22, resolver2, null, colorProducer2, (Function1) rememberedValue2, composer2, ((i10 >> 3) & 910) | ((i10 >> 12) & 57344) | ((i10 << 9) & 458752) | (3670016 & i282) | (29360128 & i282) | (234881024 & i282) | (i282 & 1879048192), (i10 >> 21) & 896, 0);
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i24 = i22;
                    i25 = i23;
                    textStyle3 = textStyle2;
                    function14 = function13;
                    i26 = m2563getClipgIe3tQ8;
                    z8 = z6;
                    map2 = emptyMap;
                    colorProducer3 = colorProducer2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function12 = function1;
                i13 = i9 & 16;
                if (i13 == 0) {
                }
                i14 = i5;
                i15 = i9 & 32;
                if (i15 != 0) {
                }
                i16 = i9 & 64;
                if (i16 != 0) {
                }
                i17 = i9 & 128;
                if (i17 != 0) {
                }
                i18 = i9 & 256;
                if (i18 != 0) {
                }
                i19 = i9 & 512;
                if (i19 != 0) {
                }
                if ((i10 & 306783379) == 306783378) {
                }
                if (i27 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
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
                if (ComposerKt.isTraceInProgress()) {
                }
                HeightInLinesModifierKt.validateMinMaxLines(i21, i20);
                a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
                startRestartGroup.startReplaceGroup(-1584467526);
                startRestartGroup.endReplaceGroup();
                hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
                boolean hasLinks22 = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
                if (hasInlineContent) {
                }
                i22 = i21;
                i23 = i20;
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1583391888);
                if ((i10 & 14) == 4) {
                }
                rememberedValue = composer2.rememberedValue();
                if (!z7) {
                }
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString, null, 2, null);
                composer2.updateRememberedValue(rememberedValue);
                final MutableState<AnnotatedString> mutableState22 = (MutableState) rememberedValue;
                AnnotatedString BasicText_RWo7tUw$lambda$522 = BasicText_RWo7tUw$lambda$5(mutableState22);
                FontFamily.Resolver resolver22 = (FontFamily.Resolver) composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                changed = composer2.changed(mutableState22);
                rememberedValue2 = composer2.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                        invoke2(textSubstitutionValue);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                        AnnotatedString original;
                        MutableState<AnnotatedString> mutableState222 = mutableState22;
                        if (textSubstitutionValue.getIsShowingSubstitution()) {
                            original = textSubstitutionValue.getSubstitution();
                        } else {
                            original = textSubstitutionValue.getOriginal();
                        }
                        mutableState222.setValue(original);
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
                int i2822 = i10 << 6;
                m466LayoutWithLinksAndInlineContentvOo2fZY(modifier2, BasicText_RWo7tUw$lambda$522, function13, hasInlineContent, emptyMap, textStyle2, m2563getClipgIe3tQ8, z6, i23, i22, resolver22, null, colorProducer2, (Function1) rememberedValue2, composer2, ((i10 >> 3) & 910) | ((i10 >> 12) & 57344) | ((i10 << 9) & 458752) | (3670016 & i2822) | (29360128 & i2822) | (234881024 & i2822) | (i2822 & 1879048192), (i10 >> 21) & 896, 0);
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                i24 = i22;
                i25 = i23;
                textStyle3 = textStyle2;
                function14 = function13;
                i26 = m2563getClipgIe3tQ8;
                z8 = z6;
                map2 = emptyMap;
                colorProducer3 = colorProducer2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i12 = i9 & 8;
            if (i12 != 0) {
            }
            function12 = function1;
            i13 = i9 & 16;
            if (i13 == 0) {
            }
            i14 = i5;
            i15 = i9 & 32;
            if (i15 != 0) {
            }
            i16 = i9 & 64;
            if (i16 != 0) {
            }
            i17 = i9 & 128;
            if (i17 != 0) {
            }
            i18 = i9 & 256;
            if (i18 != 0) {
            }
            i19 = i9 & 512;
            if (i19 != 0) {
            }
            if ((i10 & 306783379) == 306783378) {
            }
            if (i27 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
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
            if (ComposerKt.isTraceInProgress()) {
            }
            HeightInLinesModifierKt.validateMinMaxLines(i21, i20);
            a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
            startRestartGroup.startReplaceGroup(-1584467526);
            startRestartGroup.endReplaceGroup();
            hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
            boolean hasLinks222 = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
            if (hasInlineContent) {
            }
            i22 = i21;
            i23 = i20;
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(-1583391888);
            if ((i10 & 14) == 4) {
            }
            rememberedValue = composer2.rememberedValue();
            if (!z7) {
            }
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString, null, 2, null);
            composer2.updateRememberedValue(rememberedValue);
            final MutableState<AnnotatedString> mutableState222 = (MutableState) rememberedValue;
            AnnotatedString BasicText_RWo7tUw$lambda$5222 = BasicText_RWo7tUw$lambda$5(mutableState222);
            FontFamily.Resolver resolver222 = (FontFamily.Resolver) composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            changed = composer2.changed(mutableState222);
            rememberedValue2 = composer2.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                    invoke2(textSubstitutionValue);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                    AnnotatedString original;
                    MutableState<AnnotatedString> mutableState2222 = mutableState222;
                    if (textSubstitutionValue.getIsShowingSubstitution()) {
                        original = textSubstitutionValue.getSubstitution();
                    } else {
                        original = textSubstitutionValue.getOriginal();
                    }
                    mutableState2222.setValue(original);
                }
            };
            composer2.updateRememberedValue(rememberedValue2);
            int i28222 = i10 << 6;
            m466LayoutWithLinksAndInlineContentvOo2fZY(modifier2, BasicText_RWo7tUw$lambda$5222, function13, hasInlineContent, emptyMap, textStyle2, m2563getClipgIe3tQ8, z6, i23, i22, resolver222, null, colorProducer2, (Function1) rememberedValue2, composer2, ((i10 >> 3) & 910) | ((i10 >> 12) & 57344) | ((i10 << 9) & 458752) | (3670016 & i28222) | (29360128 & i28222) | (234881024 & i28222) | (i28222 & 1879048192), (i10 >> 21) & 896, 0);
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            i24 = i22;
            i25 = i23;
            textStyle3 = textStyle2;
            function14 = function13;
            i26 = m2563getClipgIe3tQ8;
            z8 = z6;
            map2 = emptyMap;
            colorProducer3 = colorProducer2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i11 = i9 & 4;
        if (i11 == 0) {
        }
        i12 = i9 & 8;
        if (i12 != 0) {
        }
        function12 = function1;
        i13 = i9 & 16;
        if (i13 == 0) {
        }
        i14 = i5;
        i15 = i9 & 32;
        if (i15 != 0) {
        }
        i16 = i9 & 64;
        if (i16 != 0) {
        }
        i17 = i9 & 128;
        if (i17 != 0) {
        }
        i18 = i9 & 256;
        if (i18 != 0) {
        }
        i19 = i9 & 512;
        if (i19 != 0) {
        }
        if ((i10 & 306783379) == 306783378) {
        }
        if (i27 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
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
        if (ComposerKt.isTraceInProgress()) {
        }
        HeightInLinesModifierKt.validateMinMaxLines(i21, i20);
        a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
        startRestartGroup.startReplaceGroup(-1584467526);
        startRestartGroup.endReplaceGroup();
        hasInlineContent = AnnotatedStringResolveInlineContentKt.hasInlineContent(annotatedString);
        boolean hasLinks2222 = TextAnnotatedStringNodeKt.hasLinks(annotatedString);
        if (hasInlineContent) {
        }
        i22 = i21;
        i23 = i20;
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(-1583391888);
        if ((i10 & 14) == 4) {
        }
        rememberedValue = composer2.rememberedValue();
        if (!z7) {
        }
        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(annotatedString, null, 2, null);
        composer2.updateRememberedValue(rememberedValue);
        final MutableState<AnnotatedString> mutableState2222 = (MutableState) rememberedValue;
        AnnotatedString BasicText_RWo7tUw$lambda$52222 = BasicText_RWo7tUw$lambda$5(mutableState2222);
        FontFamily.Resolver resolver2222 = (FontFamily.Resolver) composer2.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        changed = composer2.changed(mutableState2222);
        rememberedValue2 = composer2.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                invoke2(textSubstitutionValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue) {
                AnnotatedString original;
                MutableState<AnnotatedString> mutableState22222 = mutableState2222;
                if (textSubstitutionValue.getIsShowingSubstitution()) {
                    original = textSubstitutionValue.getSubstitution();
                } else {
                    original = textSubstitutionValue.getOriginal();
                }
                mutableState22222.setValue(original);
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        int i282222 = i10 << 6;
        m466LayoutWithLinksAndInlineContentvOo2fZY(modifier2, BasicText_RWo7tUw$lambda$52222, function13, hasInlineContent, emptyMap, textStyle2, m2563getClipgIe3tQ8, z6, i23, i22, resolver2222, null, colorProducer2, (Function1) rememberedValue2, composer2, ((i10 >> 3) & 910) | ((i10 >> 12) & 57344) | ((i10 << 9) & 458752) | (3670016 & i282222) | (29360128 & i282222) | (234881024 & i282222) | (i282222 & 1879048192), (i10 >> 21) & 896, 0);
        composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        i24 = i22;
        i25 = i23;
        textStyle3 = textStyle2;
        function14 = function13;
        i26 = m2563getClipgIe3tQ8;
        z8 = z6;
        map2 = emptyMap;
        colorProducer3 = colorProducer2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00dc  */
    /* renamed from: BasicText-VhcvRP8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m465BasicTextVhcvRP8(final String str, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i5, boolean z5, int i6, int i7, ColorProducer colorProducer, Composer composer, final int i8, final int i9) {
        int i10;
        int i11;
        int i12;
        Function1<? super TextLayoutResult, Unit> function12;
        int i13;
        int i14;
        int i15;
        boolean z6;
        int i16;
        int i17;
        int i18;
        final int i19;
        int i20;
        Modifier then;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final int i21;
        final Function1<? super TextLayoutResult, Unit> function13;
        final int i22;
        final ColorProducer colorProducer2;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1186827822);
        if ((i9 & 1) != 0) {
            i10 = i8 | 6;
        } else if ((i8 & 6) == 0) {
            i10 = (startRestartGroup.changed(str) ? 4 : 2) | i8;
        } else {
            i10 = i8;
        }
        int i23 = i9 & 2;
        if (i23 != 0) {
            i10 |= 48;
        } else if ((i8 & 48) == 0) {
            i10 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i11 = i9 & 4;
            if (i11 == 0) {
                i10 |= 384;
            } else if ((i8 & 384) == 0) {
                i10 |= startRestartGroup.changed(textStyle) ? 256 : 128;
                i12 = i9 & 8;
                if (i12 != 0) {
                    i10 |= 3072;
                } else if ((i8 & 3072) == 0) {
                    function12 = function1;
                    i10 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                    i13 = i9 & 16;
                    if (i13 == 0) {
                        i10 |= 24576;
                    } else if ((i8 & 24576) == 0) {
                        i14 = i5;
                        i10 |= startRestartGroup.changed(i14) ? 16384 : 8192;
                        i15 = i9 & 32;
                        if (i15 != 0) {
                            i10 |= 196608;
                        } else if ((196608 & i8) == 0) {
                            z6 = z5;
                            i10 |= startRestartGroup.changed(z6) ? 131072 : 65536;
                            i16 = i9 & 64;
                            if (i16 == 0) {
                                i10 |= 1572864;
                            } else if ((i8 & 1572864) == 0) {
                                i10 |= startRestartGroup.changed(i6) ? 1048576 : 524288;
                            }
                            i17 = i9 & 128;
                            if (i17 == 0) {
                                i10 |= 12582912;
                            } else if ((i8 & 12582912) == 0) {
                                i10 |= startRestartGroup.changed(i7) ? 8388608 : 4194304;
                            }
                            i18 = i9 & 256;
                            if (i18 == 0) {
                                i10 |= 100663296;
                            } else if ((i8 & 100663296) == 0) {
                                i10 |= startRestartGroup.changedInstance(colorProducer) ? 67108864 : 33554432;
                            }
                            if ((i10 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                Modifier modifier3 = i23 == 0 ? Modifier.INSTANCE : modifier;
                                TextStyle textStyle3 = i11 == 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                                if (i12 != 0) {
                                    function12 = null;
                                }
                                int m2563getClipgIe3tQ8 = i13 == 0 ? TextOverflow.INSTANCE.m2563getClipgIe3tQ8() : i14;
                                boolean z8 = i15 == 0 ? true : z6;
                                int i24 = i16 == 0 ? Integer.MAX_VALUE : i6;
                                i19 = i17 == 0 ? i7 : 1;
                                ColorProducer colorProducer3 = i18 == 0 ? colorProducer : null;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1186827822, i10, -1, "androidx.compose.foundation.text.BasicText (BasicText.kt:96)");
                                }
                                HeightInLinesModifierKt.validateMinMaxLines(i19, i24);
                                a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
                                startRestartGroup.startReplaceGroup(-1588686502);
                                startRestartGroup.endReplaceGroup();
                                if (function12 == null) {
                                    startRestartGroup.startReplaceGroup(-1588564052);
                                    then = m468textModifiercFh6CEA(GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new AnnotatedString(str, null, null, 6, null), textStyle3, function12, m2563getClipgIe3tQ8, z8, i24, i19, (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver()), null, null, null, colorProducer3, null);
                                    startRestartGroup.endReplaceGroup();
                                    i20 = i24;
                                } else {
                                    startRestartGroup.startReplaceGroup(-1587866335);
                                    i20 = i24;
                                    then = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier3, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null).then(new TextStringSimpleElement(str, textStyle3, (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver()), m2563getClipgIe3tQ8, z8, i20, i19, colorProducer3, null));
                                    startRestartGroup.endReplaceGroup();
                                }
                                EmptyMeasurePolicy emptyMeasurePolicy = EmptyMeasurePolicy.INSTANCE;
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion.getConstructor();
                                if (startRestartGroup.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.useNode();
                                } else {
                                    startRestartGroup.createNode(constructor);
                                }
                                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                                Updater.m1227setimpl(m1226constructorimpl, emptyMeasurePolicy, companion.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                startRestartGroup.endNode();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                textStyle2 = textStyle3;
                                i21 = m2563getClipgIe3tQ8;
                                function13 = function12;
                                i22 = i20;
                                colorProducer2 = colorProducer3;
                                z7 = z8;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                textStyle2 = textStyle;
                                i22 = i6;
                                i19 = i7;
                                function13 = function12;
                                i21 = i14;
                                z7 = z6;
                                colorProducer2 = colorProducer;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$BasicText$1
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

                                    public final void invoke(Composer composer2, int i25) {
                                        BasicTextKt.m465BasicTextVhcvRP8(str, modifier2, textStyle2, function13, i21, z7, i22, i19, colorProducer2, composer2, RecomposeScopeImplKt.updateChangedFlags(i8 | 1), i9);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        z6 = z5;
                        i16 = i9 & 64;
                        if (i16 == 0) {
                        }
                        i17 = i9 & 128;
                        if (i17 == 0) {
                        }
                        i18 = i9 & 256;
                        if (i18 == 0) {
                        }
                        if ((i10 & 38347923) == 38347922) {
                        }
                        if (i23 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        HeightInLinesModifierKt.validateMinMaxLines(i19, i24);
                        a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
                        startRestartGroup.startReplaceGroup(-1588686502);
                        startRestartGroup.endReplaceGroup();
                        if (function12 == null) {
                        }
                        EmptyMeasurePolicy emptyMeasurePolicy2 = EmptyMeasurePolicy.INSTANCE;
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, emptyMeasurePolicy2, companion2.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting()) {
                        }
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier3;
                        textStyle2 = textStyle3;
                        i21 = m2563getClipgIe3tQ8;
                        function13 = function12;
                        i22 = i20;
                        colorProducer2 = colorProducer3;
                        z7 = z8;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i14 = i5;
                    i15 = i9 & 32;
                    if (i15 != 0) {
                    }
                    z6 = z5;
                    i16 = i9 & 64;
                    if (i16 == 0) {
                    }
                    i17 = i9 & 128;
                    if (i17 == 0) {
                    }
                    i18 = i9 & 256;
                    if (i18 == 0) {
                    }
                    if ((i10 & 38347923) == 38347922) {
                    }
                    if (i23 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    HeightInLinesModifierKt.validateMinMaxLines(i19, i24);
                    a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
                    startRestartGroup.startReplaceGroup(-1588686502);
                    startRestartGroup.endReplaceGroup();
                    if (function12 == null) {
                    }
                    EmptyMeasurePolicy emptyMeasurePolicy22 = EmptyMeasurePolicy.INSTANCE;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                    CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, emptyMeasurePolicy22, companion22.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier3;
                    textStyle2 = textStyle3;
                    i21 = m2563getClipgIe3tQ8;
                    function13 = function12;
                    i22 = i20;
                    colorProducer2 = colorProducer3;
                    z7 = z8;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function12 = function1;
                i13 = i9 & 16;
                if (i13 == 0) {
                }
                i14 = i5;
                i15 = i9 & 32;
                if (i15 != 0) {
                }
                z6 = z5;
                i16 = i9 & 64;
                if (i16 == 0) {
                }
                i17 = i9 & 128;
                if (i17 == 0) {
                }
                i18 = i9 & 256;
                if (i18 == 0) {
                }
                if ((i10 & 38347923) == 38347922) {
                }
                if (i23 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 != 0) {
                }
                if (i13 == 0) {
                }
                if (i15 == 0) {
                }
                if (i16 == 0) {
                }
                if (i17 == 0) {
                }
                if (i18 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                HeightInLinesModifierKt.validateMinMaxLines(i19, i24);
                a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
                startRestartGroup.startReplaceGroup(-1588686502);
                startRestartGroup.endReplaceGroup();
                if (function12 == null) {
                }
                EmptyMeasurePolicy emptyMeasurePolicy222 = EmptyMeasurePolicy.INSTANCE;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
                CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, emptyMeasurePolicy222, companion222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion222.getSetModifier());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                textStyle2 = textStyle3;
                i21 = m2563getClipgIe3tQ8;
                function13 = function12;
                i22 = i20;
                colorProducer2 = colorProducer3;
                z7 = z8;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i12 = i9 & 8;
            if (i12 != 0) {
            }
            function12 = function1;
            i13 = i9 & 16;
            if (i13 == 0) {
            }
            i14 = i5;
            i15 = i9 & 32;
            if (i15 != 0) {
            }
            z6 = z5;
            i16 = i9 & 64;
            if (i16 == 0) {
            }
            i17 = i9 & 128;
            if (i17 == 0) {
            }
            i18 = i9 & 256;
            if (i18 == 0) {
            }
            if ((i10 & 38347923) == 38347922) {
            }
            if (i23 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 != 0) {
            }
            if (i13 == 0) {
            }
            if (i15 == 0) {
            }
            if (i16 == 0) {
            }
            if (i17 == 0) {
            }
            if (i18 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            HeightInLinesModifierKt.validateMinMaxLines(i19, i24);
            a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
            startRestartGroup.startReplaceGroup(-1588686502);
            startRestartGroup.endReplaceGroup();
            if (function12 == null) {
            }
            EmptyMeasurePolicy emptyMeasurePolicy2222 = EmptyMeasurePolicy.INSTANCE;
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
            CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2222 = companion2222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, emptyMeasurePolicy2222, companion2222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion2222.getSetResolvedCompositionLocals());
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion2222.getSetModifier());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion2222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            textStyle2 = textStyle3;
            i21 = m2563getClipgIe3tQ8;
            function13 = function12;
            i22 = i20;
            colorProducer2 = colorProducer3;
            z7 = z8;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i11 = i9 & 4;
        if (i11 == 0) {
        }
        i12 = i9 & 8;
        if (i12 != 0) {
        }
        function12 = function1;
        i13 = i9 & 16;
        if (i13 == 0) {
        }
        i14 = i5;
        i15 = i9 & 32;
        if (i15 != 0) {
        }
        z6 = z5;
        i16 = i9 & 64;
        if (i16 == 0) {
        }
        i17 = i9 & 128;
        if (i17 == 0) {
        }
        i18 = i9 & 256;
        if (i18 == 0) {
        }
        if ((i10 & 38347923) == 38347922) {
        }
        if (i23 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 != 0) {
        }
        if (i13 == 0) {
        }
        if (i15 == 0) {
        }
        if (i16 == 0) {
        }
        if (i17 == 0) {
        }
        if (i18 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        HeightInLinesModifierKt.validateMinMaxLines(i19, i24);
        a.a(startRestartGroup.consume(SelectionRegistrarKt.getLocalSelectionRegistrar()));
        startRestartGroup.startReplaceGroup(-1588686502);
        startRestartGroup.endReplaceGroup();
        if (function12 == null) {
        }
        EmptyMeasurePolicy emptyMeasurePolicy22222 = EmptyMeasurePolicy.INSTANCE;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, then);
        CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
        ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor22222 = companion22222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, emptyMeasurePolicy22222, companion22222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22222, companion22222.getSetResolvedCompositionLocals());
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22222, companion22222.getSetModifier());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = companion22222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22222);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        textStyle2 = textStyle3;
        i21 = m2563getClipgIe3tQ8;
        function13 = function12;
        i22 = i20;
        colorProducer2 = colorProducer3;
        z7 = z8;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final AnnotatedString BasicText_RWo7tUw$lambda$5(MutableState<AnnotatedString> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02a8  */
    /* renamed from: LayoutWithLinksAndInlineContent-vOo2fZY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m466LayoutWithLinksAndInlineContentvOo2fZY(Modifier modifier, final AnnotatedString annotatedString, final Function1<? super TextLayoutResult, Unit> function1, boolean z5, Map<String, Object> map, TextStyle textStyle, int i5, boolean z6, int i6, int i7, FontFamily.Resolver resolver, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function12, Composer composer, int i8, int i9, int i10) {
        int i11;
        Map<String, Object> map2;
        int i12;
        final TextLinkScope textLinkScope;
        Function0 function0;
        List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>> component2;
        Map<String, Object> map3;
        final MutableState mutableState;
        boolean changedInstance;
        Object rememberedValue;
        Object textMeasurePolicy;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Object obj;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(645129368);
        if ((i10 & 1) != 0) {
            i11 = i8 | 6;
        } else if ((i8 & 6) == 0) {
            i11 = i8 | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i11 = i8;
        }
        if ((i10 & 2) != 0) {
            i11 |= 48;
        } else if ((i8 & 48) == 0) {
            i11 |= startRestartGroup.changed(annotatedString) ? 32 : 16;
        }
        int i13 = i11;
        if ((i10 & 4) != 0) {
            i13 |= 384;
        } else if ((i8 & 384) == 0) {
            i13 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i10 & 8) != 0) {
            i13 |= 3072;
        } else if ((i8 & 3072) == 0) {
            i13 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        int i14 = i10 & 16;
        if (i14 != 0) {
            i13 |= 24576;
        } else if ((i8 & 24576) == 0) {
            map2 = map;
            i13 |= startRestartGroup.changedInstance(map2) ? 16384 : 8192;
            if ((i10 & 32) == 0) {
                i13 |= 196608;
            } else if ((i8 & 196608) == 0) {
                i13 |= startRestartGroup.changed(textStyle) ? 131072 : 65536;
            }
            if ((i10 & 64) == 0) {
                i13 |= 1572864;
            } else if ((i8 & 1572864) == 0) {
                i13 |= startRestartGroup.changed(i5) ? 1048576 : 524288;
            }
            if ((i10 & 128) == 0) {
                i13 |= 12582912;
            } else if ((i8 & 12582912) == 0) {
                i13 |= startRestartGroup.changed(z6) ? 8388608 : 4194304;
                if ((i10 & 256) != 0) {
                    i13 |= 100663296;
                } else if ((100663296 & i8) == 0) {
                    i13 |= startRestartGroup.changed(i6) ? 67108864 : 33554432;
                    if ((i10 & 512) == 0) {
                        i13 |= 805306368;
                    } else if ((805306368 & i8) == 0) {
                        i13 |= startRestartGroup.changed(i7) ? 536870912 : 268435456;
                        if ((i10 & 1024) != 0) {
                            i12 = i9 | 6;
                        } else if ((i9 & 6) == 0) {
                            i12 = i9 | (startRestartGroup.changedInstance(resolver) ? 4 : 2);
                        } else {
                            i12 = i9;
                        }
                        if ((i10 & 2048) != 0) {
                            i12 |= 48;
                        } else if ((i9 & 48) == 0) {
                            i12 |= startRestartGroup.changedInstance(selectionController) ? 32 : 16;
                            int i15 = i12;
                            if ((i10 & 4096) == 0) {
                                i15 |= 384;
                            } else if ((i9 & 384) == 0) {
                                i15 |= startRestartGroup.changedInstance(colorProducer) ? 256 : 128;
                            }
                            if ((8192 & i10) == 0) {
                                i15 |= 3072;
                            } else if ((i9 & 3072) == 0) {
                                i15 |= startRestartGroup.changedInstance(function12) ? 2048 : 1024;
                                if ((i13 & 306783379) != 306783378 && (i15 & 1171) == 1170 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    map3 = map2;
                                } else {
                                    Map<String, Object> emptyMap = i14 != 0 ? MapsKt.emptyMap() : map2;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(645129368, i13, i15, "androidx.compose.foundation.text.LayoutWithLinksAndInlineContent (BasicText.kt:536)");
                                    }
                                    Function1 function13 = null;
                                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                                        startRestartGroup.startReplaceGroup(-619323167);
                                        boolean z7 = (i13 & 112) == 32;
                                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = new TextLinkScope(annotatedString);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        textLinkScope = (TextLinkScope) rememberedValue2;
                                    } else {
                                        startRestartGroup.startReplaceGroup(-619265198);
                                        startRestartGroup.endReplaceGroup();
                                        textLinkScope = null;
                                    }
                                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                                        startRestartGroup.startReplaceGroup(-619074547);
                                        boolean changed = ((i13 & 112) == 32) | startRestartGroup.changed(textLinkScope);
                                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = new Function0<AnnotatedString>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final AnnotatedString invoke() {
                                                    AnnotatedString applyAnnotators$foundation_release;
                                                    TextLinkScope textLinkScope2 = TextLinkScope.this;
                                                    return (textLinkScope2 == null || (applyAnnotators$foundation_release = textLinkScope2.applyAnnotators$foundation_release()) == null) ? annotatedString : applyAnnotators$foundation_release;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        function0 = (Function0) rememberedValue3;
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(-618966357);
                                        boolean z8 = (i13 & 112) == 32;
                                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = new Function0<AnnotatedString>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$styledText$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final AnnotatedString invoke() {
                                                    return AnnotatedString.this;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                        }
                                        function0 = (Function0) rememberedValue4;
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    Pair<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<Function3<String, Composer, Integer, Unit>>>> resolveInlineContent = z5 ? AnnotatedStringResolveInlineContentKt.resolveInlineContent(annotatedString, emptyMap) : new Pair<>(null, null);
                                    List<AnnotatedString.Range<Placeholder>> component1 = resolveInlineContent.component1();
                                    component2 = resolveInlineContent.component2();
                                    if (z5) {
                                        startRestartGroup.startReplaceGroup(-618671702);
                                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                                        map3 = emptyMap;
                                        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            function13 = null;
                                            obj = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                            startRestartGroup.updateRememberedValue(obj);
                                        } else {
                                            function13 = null;
                                            obj = rememberedValue5;
                                        }
                                        mutableState = (MutableState) obj;
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        map3 = emptyMap;
                                        startRestartGroup.startReplaceGroup(-618591630);
                                        startRestartGroup.endReplaceGroup();
                                        mutableState = null;
                                    }
                                    if (z5) {
                                        startRestartGroup.startReplaceGroup(-618506565);
                                        boolean changed2 = startRestartGroup.changed(mutableState);
                                        Object rememberedValue6 = startRestartGroup.rememberedValue();
                                        if (changed2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue6 = new Function1<List<? extends Rect>, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$onPlaceholderLayout$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(List<? extends Rect> list) {
                                                    invoke2((List<Rect>) list);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(List<Rect> list) {
                                                    MutableState<List<Rect>> mutableState2 = mutableState;
                                                    if (mutableState2 == null) {
                                                        return;
                                                    }
                                                    mutableState2.setValue(list);
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue6);
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        function13 = (Function1) rememberedValue6;
                                    } else {
                                        startRestartGroup.startReplaceGroup(-618442830);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    Modifier m1525graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                                    AnnotatedString annotatedString2 = (AnnotatedString) function0.invoke();
                                    changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i13 & 896) == 256);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                                invoke2(textLayoutResult);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(TextLayoutResult textLayoutResult) {
                                                TextLinkScope textLinkScope2 = TextLinkScope.this;
                                                if (textLinkScope2 != null) {
                                                    textLinkScope2.setTextLayoutResult(textLayoutResult);
                                                }
                                                Function1<TextLayoutResult, Unit> function14 = function1;
                                                if (function14 != null) {
                                                    function14.invoke(textLayoutResult);
                                                }
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    Modifier m468textModifiercFh6CEA = m468textModifiercFh6CEA(m1525graphicsLayerAp8cVGQ$default, annotatedString2, textStyle, (Function1) rememberedValue, i5, z6, i6, i7, resolver, component1, function13, selectionController, colorProducer, function12);
                                    if (z5) {
                                        startRestartGroup.startReplaceGroup(-617202116);
                                        boolean changedInstance2 = startRestartGroup.changedInstance(textLinkScope);
                                        Object rememberedValue7 = startRestartGroup.rememberedValue();
                                        if (changedInstance2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue7 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$4$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    TextLinkScope textLinkScope2 = TextLinkScope.this;
                                                    return Boolean.valueOf(textLinkScope2 != null ? textLinkScope2.getShouldMeasureLinks().invoke().booleanValue() : false);
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue7);
                                        }
                                        Function0 function02 = (Function0) rememberedValue7;
                                        boolean changed3 = startRestartGroup.changed(mutableState);
                                        Object rememberedValue8 = startRestartGroup.rememberedValue();
                                        if (changed3 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue8 = new Function0<List<? extends Rect>>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$5$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final List<? extends Rect> invoke() {
                                                    MutableState<List<Rect>> mutableState2 = mutableState;
                                                    if (mutableState2 != null) {
                                                        return mutableState2.getValue();
                                                    }
                                                    return null;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue8);
                                        }
                                        textMeasurePolicy = new TextMeasurePolicy(function02, (Function0) rememberedValue8);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(-617362851);
                                        boolean changedInstance3 = startRestartGroup.changedInstance(textLinkScope);
                                        Object rememberedValue9 = startRestartGroup.rememberedValue();
                                        if (changedInstance3 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue9 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$3$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    TextLinkScope textLinkScope2 = TextLinkScope.this;
                                                    return Boolean.valueOf(textLinkScope2 != null ? textLinkScope2.getShouldMeasureLinks().invoke().booleanValue() : false);
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue9);
                                        }
                                        textMeasurePolicy = new LinksTextMeasurePolicy((Function0) rememberedValue9);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m468textModifiercFh6CEA);
                                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                                    if (startRestartGroup.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    startRestartGroup.startReusableNode();
                                    if (startRestartGroup.getInserting()) {
                                        startRestartGroup.createNode(constructor);
                                    } else {
                                        startRestartGroup.useNode();
                                    }
                                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                                    Updater.m1227setimpl(m1226constructorimpl, textMeasurePolicy, companion.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                                    if (textLinkScope == null) {
                                        startRestartGroup.startReplaceGroup(-515480539);
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        startRestartGroup.startReplaceGroup(537560924);
                                        textLinkScope.LinksComposables(startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                        Unit unit = Unit.INSTANCE;
                                    }
                                    if (component2 == null) {
                                        startRestartGroup.startReplaceGroup(-515428893);
                                    } else {
                                        startRestartGroup.startReplaceGroup(-515428892);
                                        AnnotatedStringResolveInlineContentKt.InlineChildren(annotatedString, component2, startRestartGroup, (i13 >> 3) & 14);
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    startRestartGroup.endReplaceGroup();
                                    startRestartGroup.endNode();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>(annotatedString, function1, z5, map3, textStyle, i5, z6, i6, i7, resolver, selectionController, colorProducer, function12, i8, i9, i10) { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$6
                                        final /* synthetic */ int $$changed;
                                        final /* synthetic */ int $$changed1;
                                        final /* synthetic */ int $$default;
                                        final /* synthetic */ ColorProducer $color;
                                        final /* synthetic */ FontFamily.Resolver $fontFamilyResolver;
                                        final /* synthetic */ boolean $hasInlineContent;
                                        final /* synthetic */ Map<String, Object> $inlineContent;
                                        final /* synthetic */ int $maxLines;
                                        final /* synthetic */ int $minLines;
                                        final /* synthetic */ Function1<TextAnnotatedStringNode.TextSubstitutionValue, Unit> $onShowTranslation;
                                        final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
                                        final /* synthetic */ int $overflow;
                                        final /* synthetic */ SelectionController $selectionController;
                                        final /* synthetic */ boolean $softWrap;
                                        final /* synthetic */ TextStyle $style;
                                        final /* synthetic */ AnnotatedString $text;

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                            this.$color = colorProducer;
                                            this.$onShowTranslation = function12;
                                            this.$$changed = i8;
                                            this.$$changed1 = i9;
                                            this.$$default = i10;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i16) {
                                            BasicTextKt.m466LayoutWithLinksAndInlineContentvOo2fZY(Modifier.this, this.$text, this.$onTextLayout, this.$hasInlineContent, this.$inlineContent, this.$style, this.$overflow, this.$softWrap, this.$maxLines, this.$minLines, this.$fontFamilyResolver, this.$selectionController, this.$color, this.$onShowTranslation, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i13 & 306783379) != 306783378) {
                            }
                            if (i14 != 0) {
                            }
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Function1 function132 = null;
                            if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                            }
                            if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                            }
                            if (z5) {
                            }
                            List<AnnotatedString.Range<Placeholder>> component12 = resolveInlineContent.component1();
                            component2 = resolveInlineContent.component2();
                            if (z5) {
                            }
                            if (z5) {
                            }
                            Modifier m1525graphicsLayerAp8cVGQ$default2 = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                            AnnotatedString annotatedString22 = (AnnotatedString) function0.invoke();
                            changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i13 & 896) == 256);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changedInstance) {
                            }
                            rememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                    invoke2(textLayoutResult);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(TextLayoutResult textLayoutResult) {
                                    TextLinkScope textLinkScope2 = TextLinkScope.this;
                                    if (textLinkScope2 != null) {
                                        textLinkScope2.setTextLayoutResult(textLayoutResult);
                                    }
                                    Function1<TextLayoutResult, Unit> function14 = function1;
                                    if (function14 != null) {
                                        function14.invoke(textLayoutResult);
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            Modifier m468textModifiercFh6CEA2 = m468textModifiercFh6CEA(m1525graphicsLayerAp8cVGQ$default2, annotatedString22, textStyle, (Function1) rememberedValue, i5, z6, i6, i7, resolver, component12, function132, selectionController, colorProducer, function12);
                            if (z5) {
                            }
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m468textModifiercFh6CEA2);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                            }
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, textMeasurePolicy, companion2.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting()) {
                            }
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
                            if (textLinkScope == null) {
                            }
                            if (component2 == null) {
                            }
                            startRestartGroup.endReplaceGroup();
                            startRestartGroup.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        int i152 = i12;
                        if ((i10 & 4096) == 0) {
                        }
                        if ((8192 & i10) == 0) {
                        }
                        if ((i13 & 306783379) != 306783378) {
                        }
                        if (i14 != 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Function1 function1322 = null;
                        if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                        }
                        if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                        }
                        if (z5) {
                        }
                        List<AnnotatedString.Range<Placeholder>> component122 = resolveInlineContent.component1();
                        component2 = resolveInlineContent.component2();
                        if (z5) {
                        }
                        if (z5) {
                        }
                        Modifier m1525graphicsLayerAp8cVGQ$default22 = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                        AnnotatedString annotatedString222 = (AnnotatedString) function0.invoke();
                        changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i13 & 896) == 256);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        rememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                invoke2(textLayoutResult);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(TextLayoutResult textLayoutResult) {
                                TextLinkScope textLinkScope2 = TextLinkScope.this;
                                if (textLinkScope2 != null) {
                                    textLinkScope2.setTextLayoutResult(textLayoutResult);
                                }
                                Function1<TextLayoutResult, Unit> function14 = function1;
                                if (function14 != null) {
                                    function14.invoke(textLayoutResult);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        Modifier m468textModifiercFh6CEA22 = m468textModifiercFh6CEA(m1525graphicsLayerAp8cVGQ$default22, annotatedString222, textStyle, (Function1) rememberedValue, i5, z6, i6, i7, resolver, component122, function1322, selectionController, colorProducer, function12);
                        if (z5) {
                        }
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, m468textModifiercFh6CEA22);
                        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl, textMeasurePolicy, companion22.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting()) {
                        }
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
                        if (textLinkScope == null) {
                        }
                        if (component2 == null) {
                        }
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    if ((i10 & 1024) != 0) {
                    }
                    if ((i10 & 2048) != 0) {
                    }
                    int i1522 = i12;
                    if ((i10 & 4096) == 0) {
                    }
                    if ((8192 & i10) == 0) {
                    }
                    if ((i13 & 306783379) != 306783378) {
                    }
                    if (i14 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Function1 function13222 = null;
                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                    }
                    if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                    }
                    if (z5) {
                    }
                    List<AnnotatedString.Range<Placeholder>> component1222 = resolveInlineContent.component1();
                    component2 = resolveInlineContent.component2();
                    if (z5) {
                    }
                    if (z5) {
                    }
                    Modifier m1525graphicsLayerAp8cVGQ$default222 = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                    AnnotatedString annotatedString2222 = (AnnotatedString) function0.invoke();
                    changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i13 & 896) == 256);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    rememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                            invoke2(textLayoutResult);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(TextLayoutResult textLayoutResult) {
                            TextLinkScope textLinkScope2 = TextLinkScope.this;
                            if (textLinkScope2 != null) {
                                textLinkScope2.setTextLayoutResult(textLayoutResult);
                            }
                            Function1<TextLayoutResult, Unit> function14 = function1;
                            if (function14 != null) {
                                function14.invoke(textLayoutResult);
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    Modifier m468textModifiercFh6CEA222 = m468textModifiercFh6CEA(m1525graphicsLayerAp8cVGQ$default222, annotatedString2222, textStyle, (Function1) rememberedValue, i5, z6, i6, i7, resolver, component1222, function13222, selectionController, colorProducer, function12);
                    if (z5) {
                    }
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, m468textModifiercFh6CEA222);
                    ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    Updater.m1227setimpl(m1226constructorimpl, textMeasurePolicy, companion222.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting()) {
                    }
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion222.getSetModifier());
                    if (textLinkScope == null) {
                    }
                    if (component2 == null) {
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i10 & 512) == 0) {
                }
                if ((i10 & 1024) != 0) {
                }
                if ((i10 & 2048) != 0) {
                }
                int i15222 = i12;
                if ((i10 & 4096) == 0) {
                }
                if ((8192 & i10) == 0) {
                }
                if ((i13 & 306783379) != 306783378) {
                }
                if (i14 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Function1 function132222 = null;
                if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                }
                if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
                }
                if (z5) {
                }
                List<AnnotatedString.Range<Placeholder>> component12222 = resolveInlineContent.component1();
                component2 = resolveInlineContent.component2();
                if (z5) {
                }
                if (z5) {
                }
                Modifier m1525graphicsLayerAp8cVGQ$default2222 = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
                AnnotatedString annotatedString22222 = (AnnotatedString) function0.invoke();
                changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i13 & 896) == 256);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                        invoke2(textLayoutResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(TextLayoutResult textLayoutResult) {
                        TextLinkScope textLinkScope2 = TextLinkScope.this;
                        if (textLinkScope2 != null) {
                            textLinkScope2.setTextLayoutResult(textLayoutResult);
                        }
                        Function1<TextLayoutResult, Unit> function14 = function1;
                        if (function14 != null) {
                            function14.invoke(textLayoutResult);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                Modifier m468textModifiercFh6CEA2222 = m468textModifiercFh6CEA(m1525graphicsLayerAp8cVGQ$default2222, annotatedString22222, textStyle, (Function1) rememberedValue, i5, z6, i6, i7, resolver, component12222, function132222, selectionController, colorProducer, function12);
                if (z5) {
                }
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, m468textModifiercFh6CEA2222);
                ComposeUiNode.Companion companion2222 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2222 = companion2222.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, textMeasurePolicy, companion2222.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2222, companion2222.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion2222.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier2222, companion2222.getSetModifier());
                if (textLinkScope == null) {
                }
                if (component2 == null) {
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i10 & 256) != 0) {
            }
            if ((i10 & 512) == 0) {
            }
            if ((i10 & 1024) != 0) {
            }
            if ((i10 & 2048) != 0) {
            }
            int i152222 = i12;
            if ((i10 & 4096) == 0) {
            }
            if ((8192 & i10) == 0) {
            }
            if ((i13 & 306783379) != 306783378) {
            }
            if (i14 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Function1 function1322222 = null;
            if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
            }
            if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
            }
            if (z5) {
            }
            List<AnnotatedString.Range<Placeholder>> component122222 = resolveInlineContent.component1();
            component2 = resolveInlineContent.component2();
            if (z5) {
            }
            if (z5) {
            }
            Modifier m1525graphicsLayerAp8cVGQ$default22222 = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
            AnnotatedString annotatedString222222 = (AnnotatedString) function0.invoke();
            changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i13 & 896) == 256);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                    invoke2(textLayoutResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextLayoutResult textLayoutResult) {
                    TextLinkScope textLinkScope2 = TextLinkScope.this;
                    if (textLinkScope2 != null) {
                        textLinkScope2.setTextLayoutResult(textLayoutResult);
                    }
                    Function1<TextLayoutResult, Unit> function14 = function1;
                    if (function14 != null) {
                        function14.invoke(textLayoutResult);
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            Modifier m468textModifiercFh6CEA22222 = m468textModifiercFh6CEA(m1525graphicsLayerAp8cVGQ$default22222, annotatedString222222, textStyle, (Function1) rememberedValue, i5, z6, i6, i7, resolver, component122222, function1322222, selectionController, colorProducer, function12);
            if (z5) {
            }
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22222 = ComposedModifierKt.materializeModifier(startRestartGroup, m468textModifiercFh6CEA22222);
            ComposeUiNode.Companion companion22222 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor22222 = companion22222.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, textMeasurePolicy, companion22222.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22222, companion22222.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22222 = companion22222.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22222);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier22222, companion22222.getSetModifier());
            if (textLinkScope == null) {
            }
            if (component2 == null) {
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        map2 = map;
        if ((i10 & 32) == 0) {
        }
        if ((i10 & 64) == 0) {
        }
        if ((i10 & 128) == 0) {
        }
        if ((i10 & 256) != 0) {
        }
        if ((i10 & 512) == 0) {
        }
        if ((i10 & 1024) != 0) {
        }
        if ((i10 & 2048) != 0) {
        }
        int i1522222 = i12;
        if ((i10 & 4096) == 0) {
        }
        if ((8192 & i10) == 0) {
        }
        if ((i13 & 306783379) != 306783378) {
        }
        if (i14 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Function1 function13222222 = null;
        if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
        }
        if (TextAnnotatedStringNodeKt.hasLinks(annotatedString)) {
        }
        if (z5) {
        }
        List<AnnotatedString.Range<Placeholder>> component1222222 = resolveInlineContent.component1();
        component2 = resolveInlineContent.component2();
        if (z5) {
        }
        if (z5) {
        }
        Modifier m1525graphicsLayerAp8cVGQ$default222222 = GraphicsLayerModifierKt.m1525graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null);
        AnnotatedString annotatedString2222222 = (AnnotatedString) function0.invoke();
        changedInstance = startRestartGroup.changedInstance(textLinkScope) | ((i13 & 896) == 256);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.BasicTextKt$LayoutWithLinksAndInlineContent$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                invoke2(textLayoutResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextLayoutResult textLayoutResult) {
                TextLinkScope textLinkScope2 = TextLinkScope.this;
                if (textLinkScope2 != null) {
                    textLinkScope2.setTextLayoutResult(textLayoutResult);
                }
                Function1<TextLayoutResult, Unit> function14 = function1;
                if (function14 != null) {
                    function14.invoke(textLayoutResult);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        Modifier m468textModifiercFh6CEA222222 = m468textModifiercFh6CEA(m1525graphicsLayerAp8cVGQ$default222222, annotatedString2222222, textStyle, (Function1) rememberedValue, i5, z6, i6, i7, resolver, component1222222, function13222222, selectionController, colorProducer, function12);
        if (z5) {
        }
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222222 = ComposedModifierKt.materializeModifier(startRestartGroup, m468textModifiercFh6CEA222222);
        ComposeUiNode.Companion companion222222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor222222 = companion222222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, textMeasurePolicy, companion222222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222222, companion222222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222222 = companion222222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier222222, companion222222.getSetModifier());
        if (textLinkScope == null) {
        }
        if (component2 == null) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final /* synthetic */ List access$measureWithTextRangeMeasureConstraints(List list, Function0 function0) {
        return measureWithTextRangeMeasureConstraints(list, function0);
    }

    public static final List<Pair<Placeable, Function0<IntOffset>>> measureWithTextRangeMeasureConstraints(List<? extends Measurable> list, Function0<Boolean> function0) {
        if (!function0.invoke().booleanValue()) {
            return null;
        }
        TextRangeLayoutMeasureScope textRangeLayoutMeasureScope = new TextRangeLayoutMeasureScope();
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Measurable measurable = list.get(i5);
            Object parentData = measurable.getParentData();
            Intrinsics.checkNotNull(parentData, "null cannot be cast to non-null type androidx.compose.foundation.text.TextRangeLayoutModifier");
            TextRangeLayoutMeasureResult measure = ((TextRangeLayoutModifier) parentData).getMeasurePolicy().measure(textRangeLayoutMeasureScope);
            arrayList.add(new Pair(measurable.mo1946measureBRTryo0(Constraints.INSTANCE.m2586fitPrioritizingWidthZbe2FdA(measure.getWidth(), measure.getWidth(), measure.getHeight(), measure.getHeight())), measure.getPlace()));
        }
        return arrayList;
    }

    /* renamed from: textModifier-cFh6CEA */
    private static final Modifier m468textModifiercFh6CEA(Modifier modifier, AnnotatedString annotatedString, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i5, boolean z5, int i6, int i7, FontFamily.Resolver resolver, List<AnnotatedString.Range<Placeholder>> list, Function1<? super List<Rect>, Unit> function12, SelectionController selectionController, ColorProducer colorProducer, Function1<? super TextAnnotatedStringNode.TextSubstitutionValue, Unit> function13) {
        return modifier.then(Modifier.INSTANCE).then(new TextAnnotatedStringElement(annotatedString, textStyle, resolver, function1, i5, z5, i6, i7, list, function12, null, colorProducer, function13, null));
    }
}
