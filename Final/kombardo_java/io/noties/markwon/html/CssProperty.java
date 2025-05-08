package io.noties.markwon.html;

/* loaded from: classes2.dex */
public class CssProperty {
    private String key;
    private String value;

    public String key() {
        return this.key;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public String toString() {
        return "CssProperty{key='" + this.key + "', value='" + this.value + "'}";
    }

    public String value() {
        return this.value;
    }
}
