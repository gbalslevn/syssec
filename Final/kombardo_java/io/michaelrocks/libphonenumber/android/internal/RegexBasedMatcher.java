package io.michaelrocks.libphonenumber.android.internal;

/* loaded from: classes2.dex */
public final class RegexBasedMatcher implements MatcherApi {
    private final RegexCache regexCache = new RegexCache(100);

    private RegexBasedMatcher() {
    }

    public static MatcherApi create() {
        return new RegexBasedMatcher();
    }
}
