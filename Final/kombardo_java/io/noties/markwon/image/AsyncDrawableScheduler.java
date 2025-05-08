package io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import io.noties.markwon.R$id;

/* loaded from: classes2.dex */
public abstract class AsyncDrawableScheduler {

    /* loaded from: classes2.dex */
    private static class DrawableCallbackImpl implements Drawable.Callback {
        private final Invalidator invalidator;
        private Rect previousBounds;
        private final TextView view;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface Invalidator {
            void invalidate();
        }

        DrawableCallbackImpl(TextView textView, Invalidator invalidator, Rect rect) {
            this.view = textView;
            this.invalidator = invalidator;
            this.previousBounds = new Rect(rect);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(final Drawable drawable) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.view.post(new Runnable() { // from class: io.noties.markwon.image.AsyncDrawableScheduler.DrawableCallbackImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableCallbackImpl.this.invalidateDrawable(drawable);
                    }
                });
                return;
            }
            Rect bounds = drawable.getBounds();
            if (this.previousBounds.equals(bounds)) {
                this.view.postInvalidate();
            } else {
                this.invalidator.invalidate();
                this.previousBounds = new Rect(bounds);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
            this.view.postDelayed(runnable, j5 - SystemClock.uptimeMillis());
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.view.removeCallbacks(runnable);
        }
    }

    /* loaded from: classes2.dex */
    private static class TextViewInvalidator implements DrawableCallbackImpl.Invalidator, Runnable {
        private final TextView textView;

        TextViewInvalidator(TextView textView) {
            this.textView = textView;
        }

        @Override // io.noties.markwon.image.AsyncDrawableScheduler.DrawableCallbackImpl.Invalidator
        public void invalidate() {
            this.textView.removeCallbacks(this);
            this.textView.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = this.textView;
            textView.setText(textView.getText());
        }
    }

    private static AsyncDrawableSpan[] extractSpans(TextView textView) {
        CharSequence text = textView.getText();
        int length = text != null ? text.length() : 0;
        if (length == 0 || !(text instanceof Spanned)) {
            return null;
        }
        return (AsyncDrawableSpan[]) ((Spanned) text).getSpans(0, length, AsyncDrawableSpan.class);
    }

    public static void schedule(final TextView textView) {
        int i5 = R$id.markwon_drawables_scheduler_last_text_hashcode;
        Integer num = (Integer) textView.getTag(i5);
        int hashCode = textView.getText().hashCode();
        if (num == null || num.intValue() != hashCode) {
            textView.setTag(i5, Integer.valueOf(hashCode));
            AsyncDrawableSpan[] extractSpans = extractSpans(textView);
            if (extractSpans == null || extractSpans.length <= 0) {
                return;
            }
            int i6 = R$id.markwon_drawables_scheduler;
            if (textView.getTag(i6) == null) {
                View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: io.noties.markwon.image.AsyncDrawableScheduler.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        AsyncDrawableScheduler.unschedule(textView);
                        view.removeOnAttachStateChangeListener(this);
                        view.setTag(R$id.markwon_drawables_scheduler, null);
                    }
                };
                textView.addOnAttachStateChangeListener(onAttachStateChangeListener);
                textView.setTag(i6, onAttachStateChangeListener);
            }
            TextViewInvalidator textViewInvalidator = new TextViewInvalidator(textView);
            for (AsyncDrawableSpan asyncDrawableSpan : extractSpans) {
                AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
                drawable.setCallback2(new DrawableCallbackImpl(textView, textViewInvalidator, drawable.getBounds()));
            }
        }
    }

    public static void unschedule(TextView textView) {
        int i5 = R$id.markwon_drawables_scheduler_last_text_hashcode;
        if (textView.getTag(i5) == null) {
            return;
        }
        textView.setTag(i5, null);
        AsyncDrawableSpan[] extractSpans = extractSpans(textView);
        if (extractSpans == null || extractSpans.length <= 0) {
            return;
        }
        for (AsyncDrawableSpan asyncDrawableSpan : extractSpans) {
            asyncDrawableSpan.getDrawable().setCallback2(null);
        }
    }
}
