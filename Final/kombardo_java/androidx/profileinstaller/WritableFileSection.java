package androidx.profileinstaller;

/* loaded from: classes.dex */
class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WritableFileSection(FileSectionType fileSectionType, int i5, byte[] bArr, boolean z5) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i5;
        this.mContents = bArr;
        this.mNeedsCompression = z5;
    }
}
