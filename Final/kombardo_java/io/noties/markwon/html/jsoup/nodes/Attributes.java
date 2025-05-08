package io.noties.markwon.html.jsoup.nodes;

import io.noties.markwon.html.jsoup.helper.Validate;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Attributes implements Iterable<Attribute>, Cloneable {
    private static final String[] Empty = new String[0];
    private static final String EmptyString = "";
    private static final int GrowthFactor = 2;
    private static final int InitialCapacity = 4;
    String[] keys;
    private int size = 0;
    String[] vals;

    public Attributes() {
        String[] strArr = Empty;
        this.keys = strArr;
        this.vals = strArr;
    }

    private void add(String str, String str2) {
        checkCapacity(this.size + 1);
        String[] strArr = this.keys;
        int i5 = this.size;
        strArr[i5] = str;
        this.vals[i5] = str2;
        this.size = i5 + 1;
    }

    private void checkCapacity(int i5) {
        Validate.isTrue(i5 >= this.size);
        String[] strArr = this.keys;
        int length = strArr.length;
        if (length >= i5) {
            return;
        }
        int i6 = length >= 4 ? this.size * 2 : 4;
        if (i5 <= i6) {
            i5 = i6;
        }
        this.keys = copyOf(strArr, i5);
        this.vals = copyOf(this.vals, i5);
    }

    static String checkNotNull(String str) {
        return str == null ? "" : str;
    }

    private static String[] copyOf(String[] strArr, int i5) {
        String[] strArr2 = new String[i5];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i5));
        return strArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remove(int i5) {
        Validate.isFalse(i5 >= this.size);
        int i6 = (this.size - i5) - 1;
        if (i6 > 0) {
            String[] strArr = this.keys;
            int i7 = i5 + 1;
            System.arraycopy(strArr, i7, strArr, i5, i6);
            String[] strArr2 = this.vals;
            System.arraycopy(strArr2, i7, strArr2, i5, i6);
        }
        int i8 = this.size - 1;
        this.size = i8;
        this.keys[i8] = null;
        this.vals[i8] = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.size == attributes.size && Arrays.equals(this.keys, attributes.keys)) {
            return Arrays.equals(this.vals, attributes.vals);
        }
        return false;
    }

    public String get(String str) {
        int indexOfKey = indexOfKey(str);
        return indexOfKey == -1 ? "" : checkNotNull(this.vals[indexOfKey]);
    }

    public int hashCode() {
        return (((this.size * 31) + Arrays.hashCode(this.keys)) * 31) + Arrays.hashCode(this.vals);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfKey(String str) {
        Validate.notNull(str);
        for (int i5 = 0; i5 < this.size; i5++) {
            if (str.equals(this.keys[i5])) {
                return i5;
            }
        }
        return -1;
    }

    @Override // java.lang.Iterable
    public Iterator<Attribute> iterator() {
        return new Iterator<Attribute>() { // from class: io.noties.markwon.html.jsoup.nodes.Attributes.1

            /* renamed from: i, reason: collision with root package name */
            int f5971i = 0;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f5971i < Attributes.this.size;
            }

            @Override // java.util.Iterator
            public void remove() {
                Attributes attributes = Attributes.this;
                int i5 = this.f5971i - 1;
                this.f5971i = i5;
                attributes.remove(i5);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public Attribute next() {
                Attributes attributes = Attributes.this;
                String[] strArr = attributes.vals;
                int i5 = this.f5971i;
                String str = strArr[i5];
                String str2 = attributes.keys[i5];
                if (str == null) {
                    str = "";
                }
                Attribute attribute = new Attribute(str2, str, attributes);
                this.f5971i++;
                return attribute;
            }
        };
    }

    public Attributes put(String str, String str2) {
        int indexOfKey = indexOfKey(str);
        if (indexOfKey != -1) {
            this.vals[indexOfKey] = str2;
        } else {
            add(str, str2);
        }
        return this;
    }

    public int size() {
        return this.size;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Attributes m3565clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.size = this.size;
            this.keys = copyOf(this.keys, this.size);
            this.vals = copyOf(this.vals, this.size);
            return attributes;
        } catch (CloneNotSupportedException e5) {
            throw new RuntimeException(e5);
        }
    }
}
