package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\rH\u0096\u0002J\t\u0010\u000e\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/text/LinesIterator;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "string", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/CharSequence;)V", "state", BuildConfig.FLAVOR, "tokenStartIndex", "delimiterStartIndex", "delimiterLength", "hasNext", BuildConfig.FLAVOR, "next", "State", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class LinesIterator implements Iterator<String>, KMappedMarker {
    private static final State State = new State(null);
    private int delimiterLength;
    private int delimiterStartIndex;
    private int state;
    private final CharSequence string;
    private int tokenStartIndex;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/text/LinesIterator$State;", BuildConfig.FLAVOR, "<init>", "()V", "UNKNOWN", BuildConfig.FLAVOR, "HAS_NEXT", "EXHAUSTED", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class State {
        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private State() {
        }
    }

    public LinesIterator(CharSequence string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i5;
        int i6;
        int i7 = this.state;
        if (i7 != 0) {
            return i7 == 1;
        }
        if (this.delimiterLength < 0) {
            this.state = 2;
            return false;
        }
        int length = this.string.length();
        int length2 = this.string.length();
        for (int i8 = this.tokenStartIndex; i8 < length2; i8++) {
            char charAt = this.string.charAt(i8);
            if (charAt == '\n' || charAt == '\r') {
                i5 = (charAt == '\r' && (i6 = i8 + 1) < this.string.length() && this.string.charAt(i6) == '\n') ? 2 : 1;
                length = i8;
                this.state = 1;
                this.delimiterLength = i5;
                this.delimiterStartIndex = length;
                return true;
            }
        }
        i5 = -1;
        this.state = 1;
        this.delimiterLength = i5;
        this.delimiterStartIndex = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public String next() {
        if (hasNext()) {
            this.state = 0;
            int i5 = this.delimiterStartIndex;
            int i6 = this.tokenStartIndex;
            this.tokenStartIndex = this.delimiterLength + i5;
            return this.string.subSequence(i6, i5).toString();
        }
        throw new NoSuchElementException();
    }
}
