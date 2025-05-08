package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"androidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Ljava/util/Locale;", "locale", "<init>", "(Ljava/util/Locale;)V", BuildConfig.FLAVOR, "onLocaleChanged", BuildConfig.FLAVOR, "text", "initialize", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "current", BuildConfig.FLAVOR, "following", "(I)[I", "preceding", "Ljava/text/BreakIterator;", "impl", "Ljava/text/BreakIterator;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class AccessibilityIterators$CharacterTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    private static AccessibilityIterators$CharacterTextSegmentIterator instance;
    private BreakIterator impl;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator$Companion;", BuildConfig.FLAVOR, "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityIterators$CharacterTextSegmentIterator getInstance(Locale locale) {
            if (AccessibilityIterators$CharacterTextSegmentIterator.instance == null) {
                AccessibilityIterators$CharacterTextSegmentIterator.instance = new AccessibilityIterators$CharacterTextSegmentIterator(locale, null);
            }
            AccessibilityIterators$CharacterTextSegmentIterator accessibilityIterators$CharacterTextSegmentIterator = AccessibilityIterators$CharacterTextSegmentIterator.instance;
            Intrinsics.checkNotNull(accessibilityIterators$CharacterTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
            return accessibilityIterators$CharacterTextSegmentIterator;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AccessibilityIterators$CharacterTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
    }

    private final void onLocaleChanged(Locale locale) {
        this.impl = BreakIterator.getCharacterInstance(locale);
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] following(int current) {
        int length = getText().length();
        if (length <= 0 || current >= length) {
            return null;
        }
        if (current < 0) {
            current = 0;
        }
        do {
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(current)) {
                BreakIterator breakIterator2 = this.impl;
                if (breakIterator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator2 = null;
                }
                int following = breakIterator2.following(current);
                if (following == -1) {
                    return null;
                }
                return getRange(current, following);
            }
            BreakIterator breakIterator3 = this.impl;
            if (breakIterator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator3 = null;
            }
            current = breakIterator3.following(current);
        } while (current != -1);
        return null;
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
        do {
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            if (breakIterator.isBoundary(current)) {
                BreakIterator breakIterator2 = this.impl;
                if (breakIterator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator2 = null;
                }
                int preceding = breakIterator2.preceding(current);
                if (preceding == -1) {
                    return null;
                }
                return getRange(preceding, current);
            }
            BreakIterator breakIterator3 = this.impl;
            if (breakIterator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator3 = null;
            }
            current = breakIterator3.preceding(current);
        } while (current != -1);
        return null;
    }

    private AccessibilityIterators$CharacterTextSegmentIterator(Locale locale) {
        onLocaleChanged(locale);
    }
}
