package io.noties.markwon.html;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public abstract class CssInlineStyleParser {

    /* loaded from: classes2.dex */
    static class Impl extends CssInlineStyleParser {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class CssIterable implements Iterable<CssProperty> {
            private final String input;

            /* loaded from: classes2.dex */
            private class CssIterator implements Iterator<CssProperty> {
                private final StringBuilder builder;
                private final CssProperty cssProperty;
                private int index;
                private final int length;

                private CssIterator() {
                    this.cssProperty = new CssProperty();
                    this.builder = new StringBuilder();
                    this.length = CssIterable.this.input.length();
                }

                private boolean hasNextPrepared() {
                    return hasValues(this.cssProperty.key(), this.cssProperty.value());
                }

                private boolean hasValues(String str, String str2) {
                    return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
                }

                private void prepareNext() {
                    this.cssProperty.set(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
                    this.builder.setLength(0);
                    String str = null;
                    boolean z5 = false;
                    String str2 = null;
                    for (int i5 = this.index; i5 < this.length; i5++) {
                        char charAt = CssIterable.this.input.charAt(i5);
                        if (str == null) {
                            if (':' == charAt) {
                                if (this.builder.length() > 0) {
                                    str = this.builder.toString().trim();
                                }
                                this.builder.setLength(0);
                            } else if (';' == charAt) {
                                this.builder.setLength(0);
                            } else if (Character.isWhitespace(charAt)) {
                                if (this.builder.length() > 0) {
                                    z5 = true;
                                }
                            } else if (z5) {
                                this.builder.setLength(0);
                                this.builder.append(charAt);
                                z5 = false;
                            } else {
                                this.builder.append(charAt);
                            }
                        } else if (str2 != null) {
                            continue;
                        } else if (Character.isWhitespace(charAt)) {
                            if (this.builder.length() > 0) {
                                this.builder.append(charAt);
                            }
                        } else if (';' == charAt) {
                            str2 = this.builder.toString().trim();
                            this.builder.setLength(0);
                            if (hasValues(str, str2)) {
                                this.index = i5 + 1;
                                this.cssProperty.set(str, str2);
                                return;
                            }
                        } else {
                            this.builder.append(charAt);
                        }
                    }
                    if (str == null || this.builder.length() <= 0) {
                        return;
                    }
                    this.cssProperty.set(str, this.builder.toString().trim());
                    this.index = this.length;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    prepareNext();
                    return hasNextPrepared();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.Iterator
                public CssProperty next() {
                    if (hasNextPrepared()) {
                        return this.cssProperty;
                    }
                    throw new NoSuchElementException();
                }
            }

            CssIterable(String str) {
                this.input = str;
            }

            @Override // java.lang.Iterable
            public Iterator<CssProperty> iterator() {
                return new CssIterator();
            }
        }

        Impl() {
        }

        @Override // io.noties.markwon.html.CssInlineStyleParser
        public Iterable<CssProperty> parse(String str) {
            return new CssIterable(str);
        }
    }

    public static CssInlineStyleParser create() {
        return new Impl();
    }

    public abstract Iterable<CssProperty> parse(String str);
}
