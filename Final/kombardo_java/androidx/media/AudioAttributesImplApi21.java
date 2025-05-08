package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* loaded from: classes.dex */
class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";
    AudioAttributes mAudioAttributes;
    int mLegacyStreamType = -1;

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.mAudioAttributes.equals(((AudioAttributesImplApi21) obj).mAudioAttributes);
        }
        return false;
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }
}
