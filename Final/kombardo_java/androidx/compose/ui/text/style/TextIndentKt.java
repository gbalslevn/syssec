package androidx.compose.ui.text.style;

import androidx.compose.ui.text.SpanStyleKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextIndent;", "start", "stop", "fraction", BuildConfig.FLAVOR, "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextIndentKt {
    public static final TextIndent lerp(TextIndent textIndent, TextIndent textIndent2, float f5) {
        return new TextIndent(SpanStyleKt.m2261lerpTextUnitInheritableC3pnCVY(textIndent.getFirstLine(), textIndent2.getFirstLine(), f5), SpanStyleKt.m2261lerpTextUnitInheritableC3pnCVY(textIndent.getRestLine(), textIndent2.getRestLine(), f5), null);
    }
}
