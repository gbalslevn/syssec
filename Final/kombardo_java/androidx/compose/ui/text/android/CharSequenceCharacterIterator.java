package androidx.compose.ui.text.android;

import java.text.CharacterIterator;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\t\u0010\u0013\u001a\u00020\rH\u0096\u0002J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/android/CharSequenceCharacterIterator;", "Ljava/lang/Object;", "Ljava/text/CharacterIterator;", "charSequence", BuildConfig.FLAVOR, "start", BuildConfig.FLAVOR, "end", "(Ljava/lang/CharSequence;II)V", "index", "clone", BuildConfig.FLAVOR, "current", BuildConfig.FLAVOR, "first", "getBeginIndex", "getEndIndex", "getIndex", "last", "next", "previous", "setIndex", "position", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CharSequenceCharacterIterator implements CharacterIterator {
    private final CharSequence charSequence;
    private final int end;
    private int index;
    private final int start;

    public CharSequenceCharacterIterator(CharSequence charSequence, int i5, int i6) {
        this.charSequence = charSequence;
        this.start = i5;
        this.end = i6;
        this.index = i5;
    }

    @Override // java.text.CharacterIterator
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    @Override // java.text.CharacterIterator
    public char current() {
        int i5 = this.index;
        if (i5 == this.end) {
            return (char) 65535;
        }
        return this.charSequence.charAt(i5);
    }

    @Override // java.text.CharacterIterator
    public char first() {
        this.index = this.start;
        return current();
    }

    @Override // java.text.CharacterIterator
    public int getBeginIndex() {
        return this.start;
    }

    @Override // java.text.CharacterIterator
    public int getEndIndex() {
        return this.end;
    }

    @Override // java.text.CharacterIterator
    public int getIndex() {
        return this.index;
    }

    @Override // java.text.CharacterIterator
    public char last() {
        int i5 = this.start;
        int i6 = this.end;
        if (i5 == i6) {
            this.index = i6;
            return (char) 65535;
        }
        int i7 = i6 - 1;
        this.index = i7;
        return this.charSequence.charAt(i7);
    }

    @Override // java.text.CharacterIterator
    public char next() {
        int i5 = this.index + 1;
        this.index = i5;
        int i6 = this.end;
        if (i5 < i6) {
            return this.charSequence.charAt(i5);
        }
        this.index = i6;
        return (char) 65535;
    }

    @Override // java.text.CharacterIterator
    public char previous() {
        int i5 = this.index;
        if (i5 <= this.start) {
            return (char) 65535;
        }
        int i6 = i5 - 1;
        this.index = i6;
        return this.charSequence.charAt(i6);
    }

    @Override // java.text.CharacterIterator
    public char setIndex(int position) {
        int i5 = this.start;
        if (position > this.end || i5 > position) {
            throw new IllegalArgumentException("invalid position");
        }
        this.index = position;
        return current();
    }
}
