package io.noties.markwon.image.coil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.widget.TextView;
import coil.ImageLoader;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.target.Target;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.AsyncDrawableScheduler;
import io.noties.markwon.image.DrawableUtils;
import io.noties.markwon.image.ImageSpanFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.commonmark.node.Image;

/* loaded from: classes2.dex */
public class CoilImagesPlugin extends AbstractMarkwonPlugin {
    private final CoilAsyncDrawableLoader coilAsyncDrawableLoader;

    /* renamed from: io.noties.markwon.image.coil.CoilImagesPlugin$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    abstract class AnonymousClass1 implements CoilStore {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class CoilAsyncDrawableLoader extends AsyncDrawableLoader {
        private final Map<AsyncDrawable, Disposable> cache = new HashMap(2);
        private final CoilStore coilStore;
        private final ImageLoader imageLoader;

        /* loaded from: classes2.dex */
        private class AsyncDrawableTarget implements Target {
            private final AsyncDrawable drawable;
            private final AtomicBoolean loaded;

            /* synthetic */ AsyncDrawableTarget(CoilAsyncDrawableLoader coilAsyncDrawableLoader, AsyncDrawable asyncDrawable, AtomicBoolean atomicBoolean, AnonymousClass1 anonymousClass1) {
                this(asyncDrawable, atomicBoolean);
            }

            @Override // coil.target.Target
            public void onError(Drawable drawable) {
                if (CoilAsyncDrawableLoader.this.cache.remove(this.drawable) == null || drawable == null || !this.drawable.isAttached()) {
                    return;
                }
                DrawableUtils.applyIntrinsicBoundsIfEmpty(drawable);
                this.drawable.setResult(drawable);
            }

            @Override // coil.target.Target
            public void onStart(Drawable drawable) {
                if (drawable == null || !this.drawable.isAttached()) {
                    return;
                }
                DrawableUtils.applyIntrinsicBoundsIfEmpty(drawable);
                this.drawable.setResult(drawable);
            }

            @Override // coil.target.Target
            public void onSuccess(Drawable drawable) {
                if (CoilAsyncDrawableLoader.this.cache.remove(this.drawable) == null && this.loaded.get()) {
                    return;
                }
                this.loaded.set(true);
                if (this.drawable.isAttached()) {
                    DrawableUtils.applyIntrinsicBoundsIfEmpty(drawable);
                    this.drawable.setResult(drawable);
                }
            }

            private AsyncDrawableTarget(AsyncDrawable asyncDrawable, AtomicBoolean atomicBoolean) {
                this.drawable = asyncDrawable;
                this.loaded = atomicBoolean;
            }
        }

        CoilAsyncDrawableLoader(CoilStore coilStore, ImageLoader imageLoader) {
            this.coilStore = coilStore;
            this.imageLoader = imageLoader;
        }

        @Override // io.noties.markwon.image.AsyncDrawableLoader
        public void cancel(AsyncDrawable asyncDrawable) {
            Disposable remove = this.cache.remove(asyncDrawable);
            if (remove != null) {
                this.coilStore.cancel(remove);
            }
        }

        @Override // io.noties.markwon.image.AsyncDrawableLoader
        public void load(AsyncDrawable asyncDrawable) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            Disposable enqueue = this.imageLoader.enqueue(this.coilStore.load(asyncDrawable).newBuilder().target(new AsyncDrawableTarget(this, asyncDrawable, atomicBoolean, null)).build());
            if (atomicBoolean.get()) {
                return;
            }
            atomicBoolean.set(true);
            this.cache.put(asyncDrawable, enqueue);
        }

        @Override // io.noties.markwon.image.AsyncDrawableLoader
        public Drawable placeholder(AsyncDrawable asyncDrawable) {
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public interface CoilStore {
        void cancel(Disposable disposable);

        ImageRequest load(AsyncDrawable asyncDrawable);
    }

    CoilImagesPlugin(CoilStore coilStore, ImageLoader imageLoader) {
        this.coilAsyncDrawableLoader = new CoilAsyncDrawableLoader(coilStore, imageLoader);
    }

    public static CoilImagesPlugin create(final Context context, ImageLoader imageLoader) {
        return create(new CoilStore() { // from class: io.noties.markwon.image.coil.CoilImagesPlugin.2
            @Override // io.noties.markwon.image.coil.CoilImagesPlugin.CoilStore
            public void cancel(Disposable disposable) {
                disposable.dispose();
            }

            @Override // io.noties.markwon.image.coil.CoilImagesPlugin.CoilStore
            public ImageRequest load(AsyncDrawable asyncDrawable) {
                return new ImageRequest.Builder(context).data(asyncDrawable.getDestination()).build();
            }
        }, imageLoader);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
        AsyncDrawableScheduler.schedule(textView);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
        AsyncDrawableScheduler.unschedule(textView);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        builder.asyncDrawableLoader(this.coilAsyncDrawableLoader);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        builder.setFactory(Image.class, new ImageSpanFactory());
    }

    public static CoilImagesPlugin create(CoilStore coilStore, ImageLoader imageLoader) {
        return new CoilImagesPlugin(coilStore, imageLoader);
    }
}
