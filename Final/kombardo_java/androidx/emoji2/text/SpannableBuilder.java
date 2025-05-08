package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class SpannableBuilder extends SpannableStringBuilder {
    private final Class<?> mWatcherClass;
    private final List<WatcherWrapper> mWatchers;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class WatcherWrapper implements TextWatcher, SpanWatcher {
        private final AtomicInteger mBlockCalls = new AtomicInteger(0);
        final Object mObject;

        WatcherWrapper(Object obj) {
            this.mObject = obj;
        }

        private boolean isEmojiSpan(Object obj) {
            return obj instanceof EmojiSpan;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.mObject).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            ((TextWatcher) this.mObject).beforeTextChanged(charSequence, i5, i6, i7);
        }

        final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i5, int i6) {
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                ((SpanWatcher) this.mObject).onSpanAdded(spannable, obj, i5, i6);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i5, int i6, int i7, int i8) {
            int i9;
            int i10;
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    if (i5 > i6) {
                        i5 = 0;
                    }
                    if (i7 > i8) {
                        i9 = i5;
                        i10 = 0;
                        ((SpanWatcher) this.mObject).onSpanChanged(spannable, obj, i9, i6, i10, i8);
                    }
                }
                i9 = i5;
                i10 = i7;
                ((SpanWatcher) this.mObject).onSpanChanged(spannable, obj, i9, i6, i10, i8);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i5, int i6) {
            if (this.mBlockCalls.get() <= 0 || !isEmojiSpan(obj)) {
                ((SpanWatcher) this.mObject).onSpanRemoved(spannable, obj, i5, i6);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            ((TextWatcher) this.mObject).onTextChanged(charSequence, i5, i6, i7);
        }

        final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }
    }

    SpannableBuilder(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    private void blockWatchers() {
        for (int i5 = 0; i5 < this.mWatchers.size(); i5++) {
            this.mWatchers.get(i5).blockCalls();
        }
    }

    public static SpannableBuilder create(Class<?> cls, CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private void fireWatchers() {
        for (int i5 = 0; i5 < this.mWatchers.size(); i5++) {
            this.mWatchers.get(i5).onTextChanged(this, 0, length(), length());
        }
    }

    private WatcherWrapper getWatcherFor(Object obj) {
        for (int i5 = 0; i5 < this.mWatchers.size(); i5++) {
            WatcherWrapper watcherWrapper = this.mWatchers.get(i5);
            if (watcherWrapper.mObject == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    private boolean isWatcher(Object obj) {
        return obj != null && isWatcher(obj.getClass());
    }

    private void unblockwatchers() {
        for (int i5 = 0; i5 < this.mWatchers.size(); i5++) {
            this.mWatchers.get(i5).unblockCalls();
        }
    }

    public void beginBatchEdit() {
        blockWatchers();
    }

    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        WatcherWrapper watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i5, int i6, Class<T> cls) {
        if (!isWatcher((Class<?>) cls)) {
            return (T[]) super.getSpans(i5, i6, cls);
        }
        WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i5, i6, WatcherWrapper.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, watcherWrapperArr.length));
        for (int i7 = 0; i7 < watcherWrapperArr.length; i7++) {
            tArr[i7] = watcherWrapperArr[i7].mObject;
        }
        return tArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i5, int i6, Class cls) {
        if (cls == null || isWatcher((Class<?>) cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i5, i6, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        WatcherWrapper watcherWrapper;
        if (isWatcher(obj)) {
            watcherWrapper = getWatcherFor(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.mWatchers.remove(watcherWrapper);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i5, int i6, int i7) {
        if (isWatcher(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.mWatchers.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i5, i6, i7);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i5, int i6) {
        return new SpannableBuilder(this.mWatcherClass, this, i5, i6);
    }

    private boolean isWatcher(Class<?> cls) {
        return this.mWatcherClass == cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i5, int i6) {
        super.delete(i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i5, CharSequence charSequence) {
        super.insert(i5, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence) {
        blockWatchers();
        super.replace(i5, i6, charSequence);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i5, CharSequence charSequence, int i6, int i7) {
        super.insert(i5, charSequence, i6, i7);
        return this;
    }

    SpannableBuilder(Class<?> cls, CharSequence charSequence, int i5, int i6) {
        super(charSequence, i5, i6);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i5, int i6, CharSequence charSequence, int i7, int i8) {
        blockWatchers();
        super.replace(i5, i6, charSequence, i7, i8);
        unblockwatchers();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c5) {
        super.append(c5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i5, int i6) {
        super.append(charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i5) {
        super.append(charSequence, obj, i5);
        return this;
    }
}
