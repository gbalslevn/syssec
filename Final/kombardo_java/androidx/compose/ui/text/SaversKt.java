package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0084\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\t\u001a\u00020\b\"\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a]\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\b2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000b2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0011\"&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\".\u0010\u0019\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00180\u0017\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014\".\u0010\u001a\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u0012\u0004\b\u001b\u0010\u001c\" \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014\"&\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\f\n\u0004\b \u0010\u0014\u0012\u0004\b!\u0010\u001c\" \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0014\" \u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0014\"&\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\b0\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016\"&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\b0\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010\u0014\u001a\u0004\b+\u0010\u0016\"&\u0010-\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\b0\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010\u0014\u001a\u0004\b.\u0010\u0016\" \u00100\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0014\" \u00102\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010\u0014\" \u00104\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010\u0014\" \u00106\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010\u0014\" \u00108\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010\u0014\" \u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010\u0014\" \u0010<\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010\u0014\" \u0010>\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?\" \u0010A\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010?\" \u0010C\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010?\" \u0010E\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010\u0014\" \u0010G\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\b0\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010\u0014\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\b0\u0000*\u00020H8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\b0\u0000*\u00020L8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010M\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\b0\u0000*\u00020N8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010O\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\b0\u0000*\u00020P8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010Q\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\b0\u0000*\u00020R8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010S\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\b0\u0000*\u00020T8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010U\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\b0\u0000*\u00020V8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010W\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\b0\u0000*\u00020X8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010Y\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\b0\u0000*\u00020Z8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010[\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\b0\u0000*\u00020\\8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010]\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\b0\u0000*\u00020^8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010_\"$\u0010K\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\b0\u0000*\u00020`8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u0010a¨\u0006b"}, d2 = {"Landroidx/compose/runtime/saveable/Saver;", "T", "Original", "Saveable", "value", "saver", "Landroidx/compose/runtime/saveable/SaverScope;", "scope", BuildConfig.FLAVOR, "save", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/Function1;", "restore", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "NonNullValueClassSaver", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/text/NonNullValueClassSaver;", "(Ljava/lang/Object;)Ljava/lang/Object;", "Landroidx/compose/ui/text/AnnotatedString;", "AnnotatedStringSaver", "Landroidx/compose/runtime/saveable/Saver;", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeListSaver", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "UrlAnnotationSaver", "getUrlAnnotationSaver$annotations", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ClickableSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "ParagraphStyleSaver", "getParagraphStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "SpanStyleSaver", "getSpanStyleSaver", "Landroidx/compose/ui/text/TextLinkStyles;", "TextLinkStylesSaver", "getTextLinkStylesSaver", "Landroidx/compose/ui/text/style/TextDecoration;", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextIndent;", "TextIndentSaver", "Landroidx/compose/ui/text/font/FontWeight;", "FontWeightSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "BaselineShiftSaver", "Landroidx/compose/ui/text/TextRange;", "TextRangeSaver", "Landroidx/compose/ui/graphics/Shadow;", "ShadowSaver", "Landroidx/compose/ui/graphics/Color;", "ColorSaver", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "Landroidx/compose/ui/unit/TextUnit;", "TextUnitSaver", "Landroidx/compose/ui/geometry/Offset;", "OffsetSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/Locale;", "LocaleSaver", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "getSaver", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Saver", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SaversKt {
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, AnnotatedString annotatedString) {
            Saver saver;
            Saver saver2;
            Saver saver3;
            Object save = SaversKt.save(annotatedString.getText());
            List<AnnotatedString.Range<SpanStyle>> spanStyles = annotatedString.getSpanStyles();
            saver = SaversKt.AnnotationRangeListSaver;
            Object save2 = SaversKt.save(spanStyles, saver, saverScope);
            List<AnnotatedString.Range<ParagraphStyle>> paragraphStyles = annotatedString.getParagraphStyles();
            saver2 = SaversKt.AnnotationRangeListSaver;
            Object save3 = SaversKt.save(paragraphStyles, saver2, saverScope);
            List<AnnotatedString.Range<? extends Object>> annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
            saver3 = SaversKt.AnnotationRangeListSaver;
            return CollectionsKt.arrayListOf(save, save2, save3, SaversKt.save(annotations$ui_text_release, saver3, saverScope));
        }
    }, new Function1<Object, AnnotatedString>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString invoke(Object obj) {
            Saver saver;
            Saver saver2;
            List list;
            List list2;
            Saver saver3;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list3 = (List) obj;
            Object obj2 = list3.get(1);
            saver = SaversKt.AnnotationRangeListSaver;
            Boolean bool = Boolean.FALSE;
            List list4 = null;
            List list5 = ((!Intrinsics.areEqual(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? (List) saver.restore(obj2) : null;
            Object obj3 = list3.get(2);
            saver2 = SaversKt.AnnotationRangeListSaver;
            List list6 = ((!Intrinsics.areEqual(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? (List) saver2.restore(obj3) : null;
            Object obj4 = list3.get(0);
            String str = obj4 != null ? (String) obj4 : null;
            Intrinsics.checkNotNull(str);
            if (list5 != null) {
                List list7 = list5;
                if (list7.isEmpty()) {
                    list7 = null;
                }
                list = list7;
            } else {
                list = null;
            }
            if (list6 != null) {
                List list8 = list6;
                if (list8.isEmpty()) {
                    list8 = null;
                }
                list2 = list8;
            } else {
                list2 = null;
            }
            Object obj5 = list3.get(3);
            saver3 = SaversKt.AnnotationRangeListSaver;
            if ((!Intrinsics.areEqual(obj5, bool) || (saver3 instanceof NonNullValueClassSaver)) && obj5 != null) {
                list4 = (List) saver3.restore(obj5);
            }
            return new AnnotatedString(str, list, list2, list4);
        }
    });
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(new Function2<SaverScope, List<? extends AnnotatedString.Range<? extends Object>>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, List<? extends AnnotatedString.Range<? extends Object>> list) {
            Saver saver;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                AnnotatedString.Range<? extends Object> range = list.get(i5);
                saver = SaversKt.AnnotationRangeSaver;
                arrayList.add(SaversKt.save(range, saver, saverScope));
            }
            return arrayList;
        }
    }, new Function1<Object, List<? extends AnnotatedString.Range<? extends Object>>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final List<? extends AnnotatedString.Range<? extends Object>> invoke(Object obj) {
            Saver saver;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = list.get(i5);
                saver = SaversKt.AnnotationRangeSaver;
                AnnotatedString.Range range = null;
                if ((!Intrinsics.areEqual(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                    range = (AnnotatedString.Range) saver.restore(obj2);
                }
                Intrinsics.checkNotNull(range);
                arrayList.add(range);
            }
            return arrayList;
        }
    });
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(new Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, AnnotatedString.Range<? extends Object> range) {
            AnnotationType annotationType;
            Object save;
            Saver saver;
            Saver saver2;
            Saver saver3;
            Saver saver4;
            Object item = range.getItem();
            if (item instanceof ParagraphStyle) {
                annotationType = AnnotationType.Paragraph;
            } else if (item instanceof SpanStyle) {
                annotationType = AnnotationType.Span;
            } else if (item instanceof VerbatimTtsAnnotation) {
                annotationType = AnnotationType.VerbatimTts;
            } else if (item instanceof UrlAnnotation) {
                annotationType = AnnotationType.Url;
            } else if (item instanceof LinkAnnotation.Url) {
                annotationType = AnnotationType.Link;
            } else {
                annotationType = item instanceof LinkAnnotation.Clickable ? AnnotationType.Clickable : AnnotationType.String;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
                case 1:
                    Object item2 = range.getItem();
                    Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                    save = SaversKt.save((ParagraphStyle) item2, SaversKt.getParagraphStyleSaver(), saverScope);
                    break;
                case 2:
                    Object item3 = range.getItem();
                    Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                    save = SaversKt.save((SpanStyle) item3, SaversKt.getSpanStyleSaver(), saverScope);
                    break;
                case 3:
                    Object item4 = range.getItem();
                    Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                    saver = SaversKt.VerbatimTtsAnnotationSaver;
                    save = SaversKt.save((VerbatimTtsAnnotation) item4, saver, saverScope);
                    break;
                case 4:
                    Object item5 = range.getItem();
                    Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                    saver2 = SaversKt.UrlAnnotationSaver;
                    save = SaversKt.save((UrlAnnotation) item5, saver2, saverScope);
                    break;
                case 5:
                    Object item6 = range.getItem();
                    Intrinsics.checkNotNull(item6, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                    saver3 = SaversKt.LinkSaver;
                    save = SaversKt.save((LinkAnnotation.Url) item6, saver3, saverScope);
                    break;
                case 6:
                    Object item7 = range.getItem();
                    Intrinsics.checkNotNull(item7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                    saver4 = SaversKt.ClickableSaver;
                    save = SaversKt.save((LinkAnnotation.Clickable) item7, saver4, saverScope);
                    break;
                case 7:
                    save = SaversKt.save(range.getItem());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return CollectionsKt.arrayListOf(SaversKt.save(annotationType), save, SaversKt.save(Integer.valueOf(range.getStart())), SaversKt.save(Integer.valueOf(range.getEnd())), SaversKt.save(range.getTag()));
        }
    }, new Function1<Object, AnnotatedString.Range<? extends Object>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.Link.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.Clickable.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString.Range<? extends Object> invoke(Object obj) {
            Saver saver;
            Saver saver2;
            Saver saver3;
            Saver saver4;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
            Intrinsics.checkNotNull(annotationType);
            Object obj3 = list.get(2);
            Integer num = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Object obj4 = list.get(3);
            Integer num2 = obj4 != null ? (Integer) obj4 : null;
            Intrinsics.checkNotNull(num2);
            int intValue2 = num2.intValue();
            Object obj5 = list.get(4);
            String str = obj5 != null ? (String) obj5 : null;
            Intrinsics.checkNotNull(str);
            switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
                case 1:
                    Object obj6 = list.get(1);
                    Saver<ParagraphStyle, Object> paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
                    if ((!Intrinsics.areEqual(obj6, Boolean.FALSE) || (paragraphStyleSaver instanceof NonNullValueClassSaver)) && obj6 != null) {
                        r1 = paragraphStyleSaver.restore(obj6);
                    }
                    Intrinsics.checkNotNull(r1);
                    return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
                case 2:
                    Object obj7 = list.get(1);
                    Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
                    if ((!Intrinsics.areEqual(obj7, Boolean.FALSE) || (spanStyleSaver instanceof NonNullValueClassSaver)) && obj7 != null) {
                        r1 = spanStyleSaver.restore(obj7);
                    }
                    Intrinsics.checkNotNull(r1);
                    return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
                case 3:
                    Object obj8 = list.get(1);
                    saver = SaversKt.VerbatimTtsAnnotationSaver;
                    if ((!Intrinsics.areEqual(obj8, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj8 != null) {
                        r1 = (VerbatimTtsAnnotation) saver.restore(obj8);
                    }
                    Intrinsics.checkNotNull(r1);
                    return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
                case 4:
                    Object obj9 = list.get(1);
                    saver2 = SaversKt.UrlAnnotationSaver;
                    if ((!Intrinsics.areEqual(obj9, Boolean.FALSE) || (saver2 instanceof NonNullValueClassSaver)) && obj9 != null) {
                        r1 = (UrlAnnotation) saver2.restore(obj9);
                    }
                    Intrinsics.checkNotNull(r1);
                    return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
                case 5:
                    Object obj10 = list.get(1);
                    saver3 = SaversKt.LinkSaver;
                    if ((!Intrinsics.areEqual(obj10, Boolean.FALSE) || (saver3 instanceof NonNullValueClassSaver)) && obj10 != null) {
                        r1 = (LinkAnnotation.Url) saver3.restore(obj10);
                    }
                    Intrinsics.checkNotNull(r1);
                    return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
                case 6:
                    Object obj11 = list.get(1);
                    saver4 = SaversKt.ClickableSaver;
                    if ((!Intrinsics.areEqual(obj11, Boolean.FALSE) || (saver4 instanceof NonNullValueClassSaver)) && obj11 != null) {
                        r1 = (LinkAnnotation.Clickable) saver4.restore(obj11);
                    }
                    Intrinsics.checkNotNull(r1);
                    return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
                case 7:
                    Object obj12 = list.get(1);
                    r1 = obj12 != null ? (String) obj12 : null;
                    Intrinsics.checkNotNull(r1);
                    return new AnnotatedString.Range<>(r1, intValue, intValue2, str);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    });
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, VerbatimTtsAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, VerbatimTtsAnnotation verbatimTtsAnnotation) {
            return SaversKt.save(verbatimTtsAnnotation.getVerbatim());
        }
    }, new Function1<Object, VerbatimTtsAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final VerbatimTtsAnnotation invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.checkNotNull(str);
            return new VerbatimTtsAnnotation(str);
        }
    });
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(new Function2<SaverScope, UrlAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, UrlAnnotation urlAnnotation) {
            return SaversKt.save(urlAnnotation.getUrl());
        }
    }, new Function1<Object, UrlAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final UrlAnnotation invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.checkNotNull(str);
            return new UrlAnnotation(str);
        }
    });
    private static final Saver<LinkAnnotation.Url, Object> LinkSaver = SaverKt.Saver(new Function2<SaverScope, LinkAnnotation.Url, Object>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, LinkAnnotation.Url url) {
            return CollectionsKt.arrayListOf(SaversKt.save(url.getUrl()), SaversKt.save(url.getStyles(), SaversKt.getTextLinkStylesSaver(), saverScope));
        }
    }, new Function1<Object, LinkAnnotation.Url>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final LinkAnnotation.Url invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextLinkStyles textLinkStyles = null;
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.checkNotNull(str);
            Object obj3 = list.get(1);
            Saver<TextLinkStyles, Object> textLinkStylesSaver = SaversKt.getTextLinkStylesSaver();
            if ((!Intrinsics.areEqual(obj3, Boolean.FALSE) || (textLinkStylesSaver instanceof NonNullValueClassSaver)) && obj3 != null) {
                textLinkStyles = textLinkStylesSaver.restore(obj3);
            }
            return new LinkAnnotation.Url(str, textLinkStyles, null, 4, null);
        }
    });
    private static final Saver<LinkAnnotation.Clickable, Object> ClickableSaver = SaverKt.Saver(new Function2<SaverScope, LinkAnnotation.Clickable, Object>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, LinkAnnotation.Clickable clickable) {
            return CollectionsKt.arrayListOf(SaversKt.save(clickable.getTag()), SaversKt.save(clickable.getStyles(), SaversKt.getTextLinkStylesSaver(), saverScope));
        }
    }, new Function1<Object, LinkAnnotation.Clickable>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final LinkAnnotation.Clickable invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.checkNotNull(str);
            Object obj3 = list.get(1);
            Saver<TextLinkStyles, Object> textLinkStylesSaver = SaversKt.getTextLinkStylesSaver();
            return new LinkAnnotation.Clickable(str, ((!Intrinsics.areEqual(obj3, Boolean.FALSE) || (textLinkStylesSaver instanceof NonNullValueClassSaver)) && obj3 != null) ? textLinkStylesSaver.restore(obj3) : null, null);
        }
    });
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new Function2<SaverScope, ParagraphStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, ParagraphStyle paragraphStyle) {
            return CollectionsKt.arrayListOf(SaversKt.save(TextAlign.m2521boximpl(paragraphStyle.getTextAlign())), SaversKt.save(TextDirection.m2535boximpl(paragraphStyle.getTextDirection())), SaversKt.save(TextUnit.m2669boximpl(paragraphStyle.getLineHeight()), SaversKt.getSaver(TextUnit.INSTANCE), saverScope), SaversKt.save(paragraphStyle.getTextIndent(), SaversKt.getSaver(TextIndent.INSTANCE), saverScope));
        }
    }, new Function1<Object, ParagraphStyle>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final ParagraphStyle invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
            Intrinsics.checkNotNull(textAlign);
            int value = textAlign.getValue();
            Object obj3 = list.get(1);
            TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
            Intrinsics.checkNotNull(textDirection);
            int value2 = textDirection.getValue();
            Object obj4 = list.get(2);
            Saver<TextUnit, Object> saver = SaversKt.getSaver(TextUnit.INSTANCE);
            Boolean bool = Boolean.FALSE;
            TextUnit restore = ((!Intrinsics.areEqual(obj4, bool) || (saver instanceof NonNullValueClassSaver)) && obj4 != null) ? saver.restore(obj4) : null;
            Intrinsics.checkNotNull(restore);
            long packedValue = restore.getPackedValue();
            Object obj5 = list.get(3);
            Saver<TextIndent, Object> saver2 = SaversKt.getSaver(TextIndent.INSTANCE);
            return new ParagraphStyle(value, value2, packedValue, ((!Intrinsics.areEqual(obj5, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj5 != null) ? saver2.restore(obj5) : null, null, null, 0, 0, null, 496, null);
        }
    });
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(new Function2<SaverScope, SpanStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, SpanStyle spanStyle) {
            Color m1481boximpl = Color.m1481boximpl(spanStyle.m2255getColor0d7_KjU());
            Color.Companion companion = Color.INSTANCE;
            Object save = SaversKt.save(m1481boximpl, SaversKt.getSaver(companion), saverScope);
            TextUnit m2669boximpl = TextUnit.m2669boximpl(spanStyle.getFontSize());
            TextUnit.Companion companion2 = TextUnit.INSTANCE;
            return CollectionsKt.arrayListOf(save, SaversKt.save(m2669boximpl, SaversKt.getSaver(companion2), saverScope), SaversKt.save(spanStyle.getFontWeight(), SaversKt.getSaver(FontWeight.INSTANCE), saverScope), SaversKt.save(spanStyle.getFontStyle()), SaversKt.save(spanStyle.getFontSynthesis()), SaversKt.save(-1), SaversKt.save(spanStyle.getFontFeatureSettings()), SaversKt.save(TextUnit.m2669boximpl(spanStyle.getLetterSpacing()), SaversKt.getSaver(companion2), saverScope), SaversKt.save(spanStyle.getBaselineShift(), SaversKt.getSaver(BaselineShift.INSTANCE), saverScope), SaversKt.save(spanStyle.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.INSTANCE), saverScope), SaversKt.save(spanStyle.getLocaleList(), SaversKt.getSaver(LocaleList.INSTANCE), saverScope), SaversKt.save(Color.m1481boximpl(spanStyle.getBackground()), SaversKt.getSaver(companion), saverScope), SaversKt.save(spanStyle.getTextDecoration(), SaversKt.getSaver(TextDecoration.INSTANCE), saverScope), SaversKt.save(spanStyle.getShadow(), SaversKt.getSaver(Shadow.INSTANCE), saverScope));
        }
    }, new Function1<Object, SpanStyle>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final SpanStyle invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Color.Companion companion = Color.INSTANCE;
            Saver<Color, Object> saver = SaversKt.getSaver(companion);
            Boolean bool = Boolean.FALSE;
            Color restore = ((!Intrinsics.areEqual(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
            Intrinsics.checkNotNull(restore);
            long value = restore.getValue();
            Object obj3 = list.get(1);
            TextUnit.Companion companion2 = TextUnit.INSTANCE;
            Saver<TextUnit, Object> saver2 = SaversKt.getSaver(companion2);
            TextUnit restore2 = ((!Intrinsics.areEqual(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
            Intrinsics.checkNotNull(restore2);
            long packedValue = restore2.getPackedValue();
            Object obj4 = list.get(2);
            Saver<FontWeight, Object> saver3 = SaversKt.getSaver(FontWeight.INSTANCE);
            FontWeight restore3 = ((!Intrinsics.areEqual(obj4, bool) || (saver3 instanceof NonNullValueClassSaver)) && obj4 != null) ? saver3.restore(obj4) : null;
            Object obj5 = list.get(3);
            FontStyle fontStyle = obj5 != null ? (FontStyle) obj5 : null;
            Object obj6 = list.get(4);
            FontSynthesis fontSynthesis = obj6 != null ? (FontSynthesis) obj6 : null;
            Object obj7 = list.get(6);
            String str = obj7 != null ? (String) obj7 : null;
            Object obj8 = list.get(7);
            Saver<TextUnit, Object> saver4 = SaversKt.getSaver(companion2);
            TextUnit restore4 = ((!Intrinsics.areEqual(obj8, bool) || (saver4 instanceof NonNullValueClassSaver)) && obj8 != null) ? saver4.restore(obj8) : null;
            Intrinsics.checkNotNull(restore4);
            long packedValue2 = restore4.getPackedValue();
            Object obj9 = list.get(8);
            Saver<BaselineShift, Object> saver5 = SaversKt.getSaver(BaselineShift.INSTANCE);
            BaselineShift restore5 = ((!Intrinsics.areEqual(obj9, bool) || (saver5 instanceof NonNullValueClassSaver)) && obj9 != null) ? saver5.restore(obj9) : null;
            Object obj10 = list.get(9);
            Saver<TextGeometricTransform, Object> saver6 = SaversKt.getSaver(TextGeometricTransform.INSTANCE);
            TextGeometricTransform restore6 = ((!Intrinsics.areEqual(obj10, bool) || (saver6 instanceof NonNullValueClassSaver)) && obj10 != null) ? saver6.restore(obj10) : null;
            Object obj11 = list.get(10);
            Saver<LocaleList, Object> saver7 = SaversKt.getSaver(LocaleList.INSTANCE);
            LocaleList restore7 = ((!Intrinsics.areEqual(obj11, bool) || (saver7 instanceof NonNullValueClassSaver)) && obj11 != null) ? saver7.restore(obj11) : null;
            Object obj12 = list.get(11);
            Saver<Color, Object> saver8 = SaversKt.getSaver(companion);
            Color restore8 = ((!Intrinsics.areEqual(obj12, bool) || (saver8 instanceof NonNullValueClassSaver)) && obj12 != null) ? saver8.restore(obj12) : null;
            Intrinsics.checkNotNull(restore8);
            long value2 = restore8.getValue();
            Object obj13 = list.get(12);
            Saver<TextDecoration, Object> saver9 = SaversKt.getSaver(TextDecoration.INSTANCE);
            TextDecoration restore9 = ((!Intrinsics.areEqual(obj13, bool) || (saver9 instanceof NonNullValueClassSaver)) && obj13 != null) ? saver9.restore(obj13) : null;
            Object obj14 = list.get(13);
            Saver<Shadow, Object> saver10 = SaversKt.getSaver(Shadow.INSTANCE);
            return new SpanStyle(value, packedValue, restore3, fontStyle, fontSynthesis, null, str, packedValue2, restore5, restore6, restore7, value2, restore9, ((!Intrinsics.areEqual(obj14, bool) || (saver10 instanceof NonNullValueClassSaver)) && obj14 != null) ? saver10.restore(obj14) : null, null, null, 49184, null);
        }
    });
    private static final Saver<TextLinkStyles, Object> TextLinkStylesSaver = SaverKt.Saver(new Function2<SaverScope, TextLinkStyles, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextLinkStyles textLinkStyles) {
            return CollectionsKt.arrayListOf(SaversKt.save(textLinkStyles.getStyle(), SaversKt.getSpanStyleSaver(), saverScope), SaversKt.save(textLinkStyles.getFocusedStyle(), SaversKt.getSpanStyleSaver(), saverScope), SaversKt.save(textLinkStyles.getHoveredStyle(), SaversKt.getSpanStyleSaver(), saverScope), SaversKt.save(textLinkStyles.getPressedStyle(), SaversKt.getSpanStyleSaver(), saverScope));
        }
    }, new Function1<Object, TextLinkStyles>() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextLinkStyles invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver<SpanStyle, Object> spanStyleSaver = SaversKt.getSpanStyleSaver();
            Boolean bool = Boolean.FALSE;
            SpanStyle spanStyle = null;
            SpanStyle restore = ((!Intrinsics.areEqual(obj2, bool) || (spanStyleSaver instanceof NonNullValueClassSaver)) && obj2 != null) ? spanStyleSaver.restore(obj2) : null;
            Object obj3 = list.get(1);
            Saver<SpanStyle, Object> spanStyleSaver2 = SaversKt.getSpanStyleSaver();
            SpanStyle restore2 = ((!Intrinsics.areEqual(obj3, bool) || (spanStyleSaver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? spanStyleSaver2.restore(obj3) : null;
            Object obj4 = list.get(2);
            Saver<SpanStyle, Object> spanStyleSaver3 = SaversKt.getSpanStyleSaver();
            SpanStyle restore3 = ((!Intrinsics.areEqual(obj4, bool) || (spanStyleSaver3 instanceof NonNullValueClassSaver)) && obj4 != null) ? spanStyleSaver3.restore(obj4) : null;
            Object obj5 = list.get(3);
            Saver<SpanStyle, Object> spanStyleSaver4 = SaversKt.getSpanStyleSaver();
            if ((!Intrinsics.areEqual(obj5, bool) || (spanStyleSaver4 instanceof NonNullValueClassSaver)) && obj5 != null) {
                spanStyle = spanStyleSaver4.restore(obj5);
            }
            return new TextLinkStyles(restore, restore2, restore3, spanStyle);
        }
    });
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(new Function2<SaverScope, TextDecoration, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextDecoration textDecoration) {
            return Integer.valueOf(textDecoration.getMask());
        }
    }, new Function1<Object, TextDecoration>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextDecoration invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return new TextDecoration(((Integer) obj).intValue());
        }
    });
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(new Function2<SaverScope, TextGeometricTransform, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
            return CollectionsKt.arrayListOf(Float.valueOf(textGeometricTransform.getScaleX()), Float.valueOf(textGeometricTransform.getSkewX()));
        }
    }, new Function1<Object, TextGeometricTransform>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextGeometricTransform invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
            List list = (List) obj;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(new Function2<SaverScope, TextIndent, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, TextIndent textIndent) {
            TextUnit m2669boximpl = TextUnit.m2669boximpl(textIndent.getFirstLine());
            TextUnit.Companion companion = TextUnit.INSTANCE;
            return CollectionsKt.arrayListOf(SaversKt.save(m2669boximpl, SaversKt.getSaver(companion), saverScope), SaversKt.save(TextUnit.m2669boximpl(textIndent.getRestLine()), SaversKt.getSaver(companion), saverScope));
        }
    }, new Function1<Object, TextIndent>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final TextIndent invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextUnit.Companion companion = TextUnit.INSTANCE;
            Saver<TextUnit, Object> saver = SaversKt.getSaver(companion);
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit = null;
            TextUnit restore = ((!Intrinsics.areEqual(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
            Intrinsics.checkNotNull(restore);
            long packedValue = restore.getPackedValue();
            Object obj3 = list.get(1);
            Saver<TextUnit, Object> saver2 = SaversKt.getSaver(companion);
            if ((!Intrinsics.areEqual(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) {
                textUnit = saver2.restore(obj3);
            }
            Intrinsics.checkNotNull(textUnit);
            return new TextIndent(packedValue, textUnit.getPackedValue(), null);
        }
    });
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(new Function2<SaverScope, FontWeight, Object>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, FontWeight fontWeight) {
            return Integer.valueOf(fontWeight.getWeight());
        }
    }, new Function1<Object, FontWeight>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final FontWeight invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return new FontWeight(((Integer) obj).intValue());
        }
    });
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new Function2<SaverScope, BaselineShift, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, BaselineShift baselineShift) {
            return m2241invoke8a2Sb4w(saverScope, baselineShift.getMultiplier());
        }

        /* renamed from: invoke-8a2Sb4w, reason: not valid java name */
        public final Object m2241invoke8a2Sb4w(SaverScope saverScope, float f5) {
            return Float.valueOf(f5);
        }
    }, new Function1<Object, BaselineShift>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
        public final BaselineShift invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            return BaselineShift.m2455boximpl(BaselineShift.m2456constructorimpl(((Float) obj).floatValue()));
        }
    });
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new Function2<SaverScope, TextRange, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, TextRange textRange) {
            return m2247invokeFDrldGo(saverScope, textRange.getPackedValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke-FDrldGo, reason: not valid java name */
        public final Object m2247invokeFDrldGo(SaverScope saverScope, long j5) {
            return CollectionsKt.arrayListOf(SaversKt.save(Integer.valueOf(TextRange.m2285getStartimpl(j5))), SaversKt.save(Integer.valueOf(TextRange.m2280getEndimpl(j5))));
        }
    }, new Function1<Object, TextRange>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-VqIyPBM, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextRange invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Integer num = obj2 != null ? (Integer) obj2 : null;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Object obj3 = list.get(1);
            Integer num2 = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.checkNotNull(num2);
            return TextRange.m2273boximpl(TextRangeKt.TextRange(intValue, num2.intValue()));
        }
    });
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(new Function2<SaverScope, Shadow, Object>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Shadow shadow) {
            return CollectionsKt.arrayListOf(SaversKt.save(Color.m1481boximpl(shadow.getColor()), SaversKt.getSaver(Color.INSTANCE), saverScope), SaversKt.save(Offset.m1328boximpl(shadow.getOffset()), SaversKt.getSaver(Offset.INSTANCE), saverScope), SaversKt.save(Float.valueOf(shadow.getBlurRadius())));
        }
    }, new Function1<Object, Shadow>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Shadow invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver<Color, Object> saver = SaversKt.getSaver(Color.INSTANCE);
            Boolean bool = Boolean.FALSE;
            Color restore = ((!Intrinsics.areEqual(obj2, bool) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
            Intrinsics.checkNotNull(restore);
            long value = restore.getValue();
            Object obj3 = list.get(1);
            Saver<Offset, Object> saver2 = SaversKt.getSaver(Offset.INSTANCE);
            Offset restore2 = ((!Intrinsics.areEqual(obj3, bool) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
            Intrinsics.checkNotNull(restore2);
            long packedValue = restore2.getPackedValue();
            Object obj4 = list.get(2);
            Float f5 = obj4 != null ? (Float) obj4 : null;
            Intrinsics.checkNotNull(f5);
            return new Shadow(value, packedValue, f5.floatValue(), null);
        }
    });
    private static final NonNullValueClassSaver<Color, Object> ColorSaver = NonNullValueClassSaver(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Color color) {
            return m2243invoke4WTKRHQ(saverScope, color.getValue());
        }

        /* renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m2243invoke4WTKRHQ(SaverScope saverScope, long j5) {
            return j5 == 16 ? Boolean.FALSE : Integer.valueOf(ColorKt.m1508toArgb8_81llA(j5));
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Color invoke(Object obj) {
            long Color;
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                Color = Color.INSTANCE.m1501getUnspecified0d7_KjU();
            } else {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                Color = ColorKt.Color(((Integer) obj).intValue());
            }
            return Color.m1481boximpl(Color);
        }
    });
    private static final NonNullValueClassSaver<TextUnit, Object> TextUnitSaver = NonNullValueClassSaver(new Function2<SaverScope, TextUnit, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, TextUnit textUnit) {
            return m2249invokempE4wyQ(saverScope, textUnit.getPackedValue());
        }

        /* renamed from: invoke-mpE4wyQ, reason: not valid java name */
        public final Object m2249invokempE4wyQ(SaverScope saverScope, long j5) {
            return TextUnit.m2672equalsimpl0(j5, TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE()) ? Boolean.FALSE : CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(TextUnit.m2675getValueimpl(j5))), SaversKt.save(TextUnitType.m2685boximpl(TextUnit.m2674getTypeUIouoOA(j5))));
        }
    }, new Function1<Object, TextUnit>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-XNhUCwk, reason: not valid java name and merged with bridge method [inline-methods] */
        public final TextUnit invoke(Object obj) {
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return TextUnit.m2669boximpl(TextUnit.INSTANCE.m2679getUnspecifiedXSAIIZE());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f5 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f5);
            float floatValue = f5.floatValue();
            Object obj3 = list.get(1);
            TextUnitType textUnitType = obj3 != null ? (TextUnitType) obj3 : null;
            Intrinsics.checkNotNull(textUnitType);
            return TextUnit.m2669boximpl(TextUnitKt.m2680TextUnitanM5pPY(floatValue, textUnitType.getType()));
        }
    });
    private static final NonNullValueClassSaver<Offset, Object> OffsetSaver = NonNullValueClassSaver(new Function2<SaverScope, Offset, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Offset offset) {
            return m2245invokeUv8p0NA(saverScope, offset.getPackedValue());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
        public final Object m2245invokeUv8p0NA(SaverScope saverScope, long j5) {
            return Offset.m1334equalsimpl0(j5, Offset.INSTANCE.m1348getUnspecifiedF1C5BW0()) ? Boolean.FALSE : CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(Offset.m1337getXimpl(j5))), SaversKt.save(Float.valueOf(Offset.m1338getYimpl(j5))));
        }
    }, new Function1<Object, Offset>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Offset invoke(Object obj) {
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return Offset.m1328boximpl(Offset.INSTANCE.m1348getUnspecifiedF1C5BW0());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f5 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f5);
            float floatValue = f5.floatValue();
            Object obj3 = list.get(1);
            Float f6 = obj3 != null ? (Float) obj3 : null;
            Intrinsics.checkNotNull(f6);
            return Offset.m1328boximpl(OffsetKt.Offset(floatValue, f6.floatValue()));
        }
    });
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(new Function2<SaverScope, LocaleList, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, LocaleList localeList) {
            List<Locale> localeList2 = localeList.getLocaleList();
            ArrayList arrayList = new ArrayList(localeList2.size());
            int size = localeList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.add(SaversKt.save(localeList2.get(i5), SaversKt.getSaver(Locale.INSTANCE), saverScope));
            }
            return arrayList;
        }
    }, new Function1<Object, LocaleList>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final LocaleList invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj2 = list.get(i5);
                Saver<Locale, Object> saver = SaversKt.getSaver(Locale.INSTANCE);
                Locale locale = null;
                if ((!Intrinsics.areEqual(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                    locale = saver.restore(obj2);
                }
                Intrinsics.checkNotNull(locale);
                arrayList.add(locale);
            }
            return new LocaleList(arrayList);
        }
    });
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(new Function2<SaverScope, Locale, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope saverScope, Locale locale) {
            return locale.toLanguageTag();
        }
    }, new Function1<Object, Locale>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Locale invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return new Locale((String) obj);
        }
    });

    private static final <Original, Saveable> NonNullValueClassSaver<Original, Saveable> NonNullValueClassSaver(final Function2<? super SaverScope, ? super Original, ? extends Saveable> function2, final Function1<? super Saveable, ? extends Original> function1) {
        return new NonNullValueClassSaver<Original, Saveable>() { // from class: androidx.compose.ui.text.SaversKt$NonNullValueClassSaver$1
            @Override // androidx.compose.runtime.saveable.Saver
            public Original restore(Saveable value) {
                return function1.invoke(value);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Saveable save(SaverScope saverScope, Original original) {
                return function2.invoke(saverScope, original);
            }
        };
    }

    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion companion) {
        return TextDecorationSaver;
    }

    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    public static final Saver<TextLinkStyles, Object> getTextLinkStylesSaver() {
        return TextLinkStylesSaver;
    }

    public static final <T> T save(T t5) {
        return t5;
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion companion) {
        return TextGeometricTransformSaver;
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original original, T t5, SaverScope saverScope) {
        Object save;
        return (original == null || (save = t5.save(saverScope, original)) == null) ? Boolean.FALSE : save;
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion companion) {
        return TextIndentSaver;
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion companion) {
        return FontWeightSaver;
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion companion) {
        return BaselineShiftSaver;
    }

    public static final Saver<TextRange, Object> getSaver(TextRange.Companion companion) {
        return TextRangeSaver;
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion companion) {
        return ShadowSaver;
    }

    public static final Saver<Color, Object> getSaver(Color.Companion companion) {
        return ColorSaver;
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion companion) {
        return TextUnitSaver;
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion companion) {
        return OffsetSaver;
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion companion) {
        return LocaleListSaver;
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion companion) {
        return LocaleSaver;
    }
}
