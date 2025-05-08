package io.noties.markwon.html.jsoup.nodes;

import io.noties.markwon.html.jsoup.helper.Validate;
import java.util.Map;

/* loaded from: classes2.dex */
public class Attribute implements Map.Entry<String, String>, Cloneable {
    private String key;
    Attributes parent;
    private String val;

    public Attribute(String str, String str2, Attributes attributes) {
        Validate.notNull(str);
        this.key = str.trim();
        Validate.notEmpty(str);
        this.val = str2;
        this.parent = attributes;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        String str = this.key;
        if (str == null ? attribute.key != null : !str.equals(attribute.key)) {
            return false;
        }
        String str2 = this.val;
        String str3 = attribute.val;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.key;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.val;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Attribute m3564clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e5) {
            throw new RuntimeException(e5);
        }
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public String getValue() {
        return this.val;
    }

    @Override // java.util.Map.Entry
    public String setValue(String str) {
        int indexOfKey;
        String str2 = this.parent.get(this.key);
        Attributes attributes = this.parent;
        if (attributes != null && (indexOfKey = attributes.indexOfKey(this.key)) != -1) {
            this.parent.vals[indexOfKey] = str;
        }
        this.val = str;
        return str2;
    }
}
