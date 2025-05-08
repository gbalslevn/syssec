package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"androidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Ljava/util/Locale;", "locale", "<init>", "(Ljava/util/Locale;)V", BuildConfig.FLAVOR, "onLocaleChanged", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "isStartBoundary", "(I)Z", "isEndBoundary", "isLetterOrDigit", BuildConfig.FLAVOR, "text", "initialize", "(Ljava/lang/String;)V", "current", BuildConfig.FLAVOR, "following", "(I)[I", "preceding", "Ljava/text/BreakIterator;", "impl", "Ljava/text/BreakIterator;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AccessibilityIterators$WordTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    private static AccessibilityIterators$WordTextSegmentIterator instance;
    private BreakIterator impl;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator$Companion;", BuildConfig.FLAVOR, "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityIterators$WordTextSegmentIterator getInstance(Locale locale) {
            if (AccessibilityIterators$WordTextSegmentIterator.instance == null) {
                AccessibilityIterators$WordTextSegmentIterator.instance = new AccessibilityIterators$WordTextSegmentIterator(locale, null);
            }
            AccessibilityIterators$WordTextSegmentIterator accessibilityIterators$WordTextSegmentIterator = AccessibilityIterators$WordTextSegmentIterator.instance;
            Intrinsics.checkNotNull(accessibilityIterators$WordTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
            return accessibilityIterators$WordTextSegmentIterator;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AccessibilityIterators$WordTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
    }

    private final boolean isEndBoundary(int index) {
        return index > 0 && isLetterOrDigit(index + (-1)) && (index == getText().length() || !isLetterOrDigit(index));
    }

    private final boolean isLetterOrDigit(int index) {
        if (index < 0 || index >= getText().length()) {
            return false;
        }
        return Character.isLetterOrDigit(getText().codePointAt(index));
    }

    private final boolean isStartBoundary(int index) {
        return isLetterOrDigit(index) && (index == 0 || !isLetterOrDigit(index - 1));
    }

    private final void onLocaleChanged(Locale locale) {
        this.impl = BreakIterator.getWordInstance(locale);
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] following(int current) {
        if (getText().length() <= 0 || current >= getText().length()) {
            return null;
        }
        if (current < 0) {
            current = 0;
        }
        while (!isLetterOrDigit(current) && !isStartBoundary(current)) {
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            current = breakIterator.following(current);
            if (current == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.impl;
        if (breakIterator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            breakIterator2 = null;
        }
        int following = breakIterator2.following(current);
        if (following == -1 || !isEndBoundary(following)) {
            return null;
        }
        return getRange(current, following);
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
    public void initialize(String text) {
        super.initialize(text);
        BreakIterator breakIterator = this.impl;
        if (breakIterator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            breakIterator = null;
        }
        breakIterator.setText(text);
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] preceding(int current) {
        int length = getText().length();
        if (length <= 0 || current <= 0) {
            return null;
        }
        if (current > length) {
            current = length;
        }
        while (current > 0 && !isLetterOrDigit(current - 1) && !isEndBoundary(current)) {
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            current = breakIterator.preceding(current);
            if (current == -1) {
                return null;
            }
        }
        BreakIterator breakIterator2 = this.impl;
        if (breakIterator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            breakIterator2 = null;
        }
        int preceding = breakIterator2.preceding(current);
        if (preceding == -1 || !isStartBoundary(preceding)) {
            return null;
        }
        return getRange(preceding, current);
    }

    private AccessibilityIterators$WordTextSegmentIterator(Locale locale) {
        onLocaleChanged(locale);
    }
}
