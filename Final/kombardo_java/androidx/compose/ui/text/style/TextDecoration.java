package androidx.compose.ui.text.style;

import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/style/TextDecoration;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mask", "<init>", "(I)V", "other", BuildConfig.FLAVOR, "contains", "(Landroidx/compose/ui/text/style/TextDecoration;)Z", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "getMask", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextDecoration {
    private final int mask;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextDecoration None = new TextDecoration(0);
    private static final TextDecoration Underline = new TextDecoration(1);
    private static final TextDecoration LineThrough = new TextDecoration(2);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR \u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\n\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u000f\u0010\fR \u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\n\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/style/TextDecoration$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/style/TextDecoration;", "decorations", "combine", "(Ljava/util/List;)Landroidx/compose/ui/text/style/TextDecoration;", "None", "Landroidx/compose/ui/text/style/TextDecoration;", "getNone", "()Landroidx/compose/ui/text/style/TextDecoration;", "getNone$annotations", "Underline", "getUnderline", "getUnderline$annotations", "LineThrough", "getLineThrough", "getLineThrough$annotations", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextDecoration combine(List<TextDecoration> decorations) {
            Integer num = 0;
            int size = decorations.size();
            for (int i5 = 0; i5 < size; i5++) {
                num = Integer.valueOf(num.intValue() | decorations.get(i5).getMask());
            }
            return new TextDecoration(num.intValue());
        }

        public final TextDecoration getLineThrough() {
            return TextDecoration.LineThrough;
        }

        public final TextDecoration getNone() {
            return TextDecoration.None;
        }

        public final TextDecoration getUnderline() {
            return TextDecoration.Underline;
        }

        private Companion() {
        }
    }

    public TextDecoration(int i5) {
        this.mask = i5;
    }

    public final boolean contains(TextDecoration other) {
        int i5 = this.mask;
        return (other.mask | i5) == i5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TextDecoration) && this.mask == ((TextDecoration) other).mask;
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return this.mask;
    }

    public String toString() {
        if (this.mask == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((this.mask & Underline.mask) != 0) {
            arrayList.add("Underline");
        }
        if ((this.mask & LineThrough.mask) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + ListUtilsKt.fastJoinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
