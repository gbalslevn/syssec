package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.MetadataItem;

/* loaded from: classes.dex */
public class TypefaceEmojiRasterizer {
    private static final ThreadLocal<MetadataItem> sMetadataItem = new ThreadLocal<>();
    private volatile int mCache = 0;
    private final int mIndex;
    private final MetadataRepo mMetadataRepo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypefaceEmojiRasterizer(MetadataRepo metadataRepo, int i5) {
        this.mMetadataRepo = metadataRepo;
        this.mIndex = i5;
    }

    private MetadataItem getMetadataItem() {
        ThreadLocal<MetadataItem> threadLocal = sMetadataItem;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.mMetadataRepo.getMetadataList().list(metadataItem, this.mIndex);
        return metadataItem;
    }

    public void draw(Canvas canvas, float f5, float f6, Paint paint) {
        Typeface typeface = this.mMetadataRepo.getTypeface();
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText(this.mMetadataRepo.getEmojiCharArray(), this.mIndex * 2, 2, f5, f6, paint);
        paint.setTypeface(typeface2);
    }

    public int getCodepointAt(int i5) {
        return getMetadataItem().codepoints(i5);
    }

    public int getCodepointsLength() {
        return getMetadataItem().codepointsLength();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getHasGlyph() {
        return this.mCache & 3;
    }

    public int getHeight() {
        return getMetadataItem().height();
    }

    public int getId() {
        return getMetadataItem().id();
    }

    public short getSdkAdded() {
        return getMetadataItem().sdkAdded();
    }

    public int getWidth() {
        return getMetadataItem().width();
    }

    public boolean isDefaultEmoji() {
        return getMetadataItem().emojiStyle();
    }

    public boolean isPreferredSystemRender() {
        return (this.mCache & 4) > 0;
    }

    public void setExclusion(boolean z5) {
        int hasGlyph = getHasGlyph();
        if (z5) {
            this.mCache = hasGlyph | 4;
        } else {
            this.mCache = hasGlyph;
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setHasGlyph(boolean z5) {
        int i5 = this.mCache & 4;
        this.mCache = z5 ? i5 | 2 : i5 | 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(getId()));
        sb.append(", codepoints:");
        int codepointsLength = getCodepointsLength();
        for (int i5 = 0; i5 < codepointsLength; i5++) {
            sb.append(Integer.toHexString(getCodepointAt(i5)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
