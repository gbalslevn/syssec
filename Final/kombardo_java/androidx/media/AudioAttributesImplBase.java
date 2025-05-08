package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    int mUsage = 0;
    int mContentType = 0;
    int mFlags = 0;
    int mLegacyStream = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.mContentType == audioAttributesImplBase.getContentType() && this.mFlags == audioAttributesImplBase.getFlags() && this.mUsage == audioAttributesImplBase.getUsage() && this.mLegacyStream == audioAttributesImplBase.mLegacyStream;
    }

    public int getContentType() {
        return this.mContentType;
    }

    public int getFlags() {
        int i5 = this.mFlags;
        int legacyStreamType = getLegacyStreamType();
        if (legacyStreamType == 6) {
            i5 |= 4;
        } else if (legacyStreamType == 7) {
            i5 |= 1;
        }
        return i5 & 273;
    }

    public int getLegacyStreamType() {
        int i5 = this.mLegacyStream;
        return i5 != -1 ? i5 : AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage);
    }

    public int getUsage() {
        return this.mUsage;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mContentType), Integer.valueOf(this.mFlags), Integer.valueOf(this.mUsage), Integer.valueOf(this.mLegacyStream)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.mLegacyStream != -1) {
            sb.append(" stream=");
            sb.append(this.mLegacyStream);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.usageToString(this.mUsage));
        sb.append(" content=");
        sb.append(this.mContentType);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.mFlags).toUpperCase());
        return sb.toString();
    }
}
