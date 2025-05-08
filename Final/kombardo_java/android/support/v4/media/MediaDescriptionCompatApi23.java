package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* loaded from: classes.dex */
abstract class MediaDescriptionCompatApi23 {

    /* loaded from: classes.dex */
    static class Builder {
        public static void setMediaUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
