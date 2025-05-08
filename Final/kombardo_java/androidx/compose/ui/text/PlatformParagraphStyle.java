package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0013\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006B\u001d\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0012\n\u0004\b\u0003\u0010\u0015\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\b\u001a\u00020\u00078\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/text/PlatformParagraphStyle;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "includeFontPadding", "<init>", "(Z)V", "()V", "Landroidx/compose/ui/text/EmojiSupportMatch;", "emojiSupportMatch", "(IZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "merge", "(Landroidx/compose/ui/text/PlatformParagraphStyle;)Landroidx/compose/ui/text/PlatformParagraphStyle;", "Z", "getIncludeFontPadding", "()Z", "getIncludeFontPadding$annotations", "I", "getEmojiSupportMatch-_3YsG6Y", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PlatformParagraphStyle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PlatformParagraphStyle Default = new PlatformParagraphStyle();
    private final int emojiSupportMatch;
    private final boolean includeFontPadding;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/PlatformParagraphStyle$Companion;", BuildConfig.FLAVOR, "()V", "Default", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "getDefault", "()Landroidx/compose/ui/text/PlatformParagraphStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlatformParagraphStyle getDefault() {
            return PlatformParagraphStyle.Default;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PlatformParagraphStyle(int i5, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, z5);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlatformParagraphStyle)) {
            return false;
        }
        PlatformParagraphStyle platformParagraphStyle = (PlatformParagraphStyle) other;
        return this.includeFontPadding == platformParagraphStyle.includeFontPadding && EmojiSupportMatch.m2208equalsimpl0(this.emojiSupportMatch, platformParagraphStyle.emojiSupportMatch);
    }

    /* renamed from: getEmojiSupportMatch-_3YsG6Y, reason: not valid java name and from getter */
    public final int getEmojiSupportMatch() {
        return this.emojiSupportMatch;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.includeFontPadding) * 31) + EmojiSupportMatch.m2209hashCodeimpl(this.emojiSupportMatch);
    }

    public final PlatformParagraphStyle merge(PlatformParagraphStyle other) {
        return other == null ? this : other;
    }

    public String toString() {
        return "PlatformParagraphStyle(includeFontPadding=" + this.includeFontPadding + ", emojiSupportMatch=" + ((Object) EmojiSupportMatch.m2210toStringimpl(this.emojiSupportMatch)) + ')';
    }

    public PlatformParagraphStyle(boolean z5) {
        this.includeFontPadding = z5;
        this.emojiSupportMatch = EmojiSupportMatch.INSTANCE.m2213getDefault_3YsG6Y();
    }

    private PlatformParagraphStyle(int i5, boolean z5) {
        this.includeFontPadding = z5;
        this.emojiSupportMatch = i5;
    }

    public PlatformParagraphStyle() {
        this(EmojiSupportMatch.INSTANCE.m2213getDefault_3YsG6Y(), false, null);
    }
}
