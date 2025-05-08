package io.noties.markwon;

/* loaded from: classes2.dex */
public class Prop<T> {
    private final String name;

    Prop(String str) {
        this.name = str;
    }

    public static <T> Prop<T> of(String str) {
        return new Prop<>(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.name.equals(((Prop) obj).name);
    }

    public T get(RenderProps renderProps) {
        return (T) renderProps.get(this);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public T require(RenderProps renderProps) {
        T t5 = get(renderProps);
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(this.name);
    }

    public void set(RenderProps renderProps, T t5) {
        renderProps.set(this, t5);
    }

    public String toString() {
        return "Prop{name='" + this.name + "'}";
    }

    public T get(RenderProps renderProps, T t5) {
        return (T) renderProps.get(this, t5);
    }
}
