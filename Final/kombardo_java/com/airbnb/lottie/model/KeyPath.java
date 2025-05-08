package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    private final List<String> keys;
    private KeyPathElement resolvedElement;

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    private boolean endsWithGlobstar() {
        return this.keys.get(r0.size() - 1).equals("**");
    }

    private boolean isContainer(String str) {
        return "__container".equals(str);
    }

    public KeyPath addKey(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.keys.add(str);
        return keyPath;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        KeyPath keyPath = (KeyPath) obj;
        if (!this.keys.equals(keyPath.keys)) {
            return false;
        }
        KeyPathElement keyPathElement = this.resolvedElement;
        KeyPathElement keyPathElement2 = keyPath.resolvedElement;
        return keyPathElement != null ? keyPathElement.equals(keyPathElement2) : keyPathElement2 == null;
    }

    public boolean fullyResolvesTo(String str, int i5) {
        if (i5 >= this.keys.size()) {
            return false;
        }
        boolean z5 = i5 == this.keys.size() - 1;
        String str2 = this.keys.get(i5);
        if (!str2.equals("**")) {
            return (z5 || (i5 == this.keys.size() + (-2) && endsWithGlobstar())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z5 && this.keys.get(i5 + 1).equals(str)) {
            return i5 == this.keys.size() + (-2) || (i5 == this.keys.size() + (-3) && endsWithGlobstar());
        }
        if (z5) {
            return true;
        }
        int i6 = i5 + 1;
        if (i6 < this.keys.size() - 1) {
            return false;
        }
        return this.keys.get(i6).equals(str);
    }

    public KeyPathElement getResolvedElement() {
        return this.resolvedElement;
    }

    public int hashCode() {
        int hashCode = this.keys.hashCode() * 31;
        KeyPathElement keyPathElement = this.resolvedElement;
        return hashCode + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    public int incrementDepthBy(String str, int i5) {
        if (isContainer(str)) {
            return 0;
        }
        if (this.keys.get(i5).equals("**")) {
            return (i5 != this.keys.size() - 1 && this.keys.get(i5 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean matches(String str, int i5) {
        if (isContainer(str)) {
            return true;
        }
        if (i5 >= this.keys.size()) {
            return false;
        }
        return this.keys.get(i5).equals(str) || this.keys.get(i5).equals("**") || this.keys.get(i5).equals("*");
    }

    public boolean propagateToChildren(String str, int i5) {
        return "__container".equals(str) || i5 < this.keys.size() - 1 || this.keys.get(i5).equals("**");
    }

    public KeyPath resolve(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.resolvedElement = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.keys);
        sb.append(",resolved=");
        sb.append(this.resolvedElement != null);
        sb.append('}');
        return sb.toString();
    }

    private KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }
}
