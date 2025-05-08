package io.noties.markwon;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class RenderPropsImpl implements RenderProps {
    private final Map<Prop, Object> values = new HashMap(3);

    @Override // io.noties.markwon.RenderProps
    public <T> T get(Prop<T> prop) {
        return (T) this.values.get(prop);
    }

    @Override // io.noties.markwon.RenderProps
    public <T> void set(Prop<T> prop, T t5) {
        if (t5 == null) {
            this.values.remove(prop);
        } else {
            this.values.put(prop, t5);
        }
    }

    @Override // io.noties.markwon.RenderProps
    public <T> T get(Prop<T> prop, T t5) {
        T t6 = (T) this.values.get(prop);
        return t6 != null ? t6 : t5;
    }
}
