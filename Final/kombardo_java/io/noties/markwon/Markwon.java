package io.noties.markwon;

import android.content.Context;
import android.widget.TextView;
import io.noties.markwon.core.CorePlugin;

/* loaded from: classes2.dex */
public abstract class Markwon {

    /* loaded from: classes2.dex */
    public interface Builder {
        Markwon build();

        Builder usePlugin(MarkwonPlugin markwonPlugin);
    }

    /* loaded from: classes2.dex */
    public interface TextSetter {
    }

    public static Builder builder(Context context) {
        return new MarkwonBuilderImpl(context).usePlugin(CorePlugin.create());
    }

    public abstract void setMarkdown(TextView textView, String str);
}
