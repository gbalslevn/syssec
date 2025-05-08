package androidx.compose.ui.text.platform.extensions;

import android.support.v4.media.session.a;
import android.text.Spannable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.unit.Density;
import androidx.emoji2.text.EmojiSpan;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a/\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\u000e\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroid/text/Spannable;", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "placeholders", "Landroidx/compose/ui/unit/Density;", "density", BuildConfig.FLAVOR, "setPlaceholders", "(Landroid/text/Spannable;Ljava/util/List;Landroidx/compose/ui/unit/Density;)V", "placeholder", BuildConfig.FLAVOR, "start", "end", "setPlaceholder", "(Landroid/text/Spannable;Landroidx/compose/ui/text/Placeholder;IILandroidx/compose/ui/unit/Density;)V", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PlaceholderExtensions_androidKt {
    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i5, int i6, Density density) {
        Object[] spans = spannable.getSpans(i5, i6, EmojiSpan.class);
        for (Object obj : spans) {
            spannable.removeSpan((EmojiSpan) obj);
        }
        throw null;
    }

    public static final void setPlaceholders(Spannable spannable, List<AnnotatedString.Range<Placeholder>> list, Density density) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            AnnotatedString.Range<Placeholder> range = list.get(i5);
            a.a(range.component1());
            setPlaceholder(spannable, null, range.getStart(), range.getEnd(), density);
        }
    }
}
