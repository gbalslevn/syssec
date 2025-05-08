package dk.molslinjen.ui.views.reusable.clickableText;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aU\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "mainText", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/clickableText/ClickableTextData;", "clickableTexts", "Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/graphics/Color;", "color", "Lkotlin/Function0;", BuildConfig.FLAVOR, "defaultOnClick", "ClickableText-FHprtrg", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/util/List;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ClickableText", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ClickableTextKt {
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* renamed from: ClickableText-FHprtrg, reason: not valid java name */
    public static final void m3408ClickableTextFHprtrg(androidx.compose.ui.Modifier r56, java.lang.String r57, java.util.List<dk.molslinjen.ui.views.reusable.clickableText.ClickableTextData> r58, androidx.compose.ui.text.TextStyle r59, long r60, kotlin.jvm.functions.Function0<kotlin.Unit> r62, androidx.compose.runtime.Composer r63, int r64, int r65) {
        /*
            Method dump skipped, instructions count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.reusable.clickableText.ClickableTextKt.m3408ClickableTextFHprtrg(androidx.compose.ui.Modifier, java.lang.String, java.util.List, androidx.compose.ui.text.TextStyle, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_FHprtrg$lambda$5$lambda$4(AnnotatedString annotatedString, List list, Function0 function0, int i5) {
        Object obj;
        Function0<Unit> callback;
        List<AnnotatedString.Range<String>> stringAnnotations = annotatedString.getStringAnnotations(i5, i5);
        Iterator it = list.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ClickableTextData clickableTextData = (ClickableTextData) obj;
            List<AnnotatedString.Range<String>> list2 = stringAnnotations;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((AnnotatedString.Range) it2.next()).getTag(), clickableTextData.getText())) {
                        break loop0;
                    }
                }
            }
        }
        ClickableTextData clickableTextData2 = (ClickableTextData) obj;
        if (clickableTextData2 != null && (callback = clickableTextData2.getCallback()) != null) {
            callback.invoke();
        } else if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClickableText_FHprtrg$lambda$6(Modifier modifier, String str, List list, TextStyle textStyle, long j5, Function0 function0, int i5, int i6, Composer composer, int i7) {
        m3408ClickableTextFHprtrg(modifier, str, list, textStyle, j5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
