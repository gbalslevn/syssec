package io.noties.markwon;

import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.core.CorePlugin;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class RegistryImpl implements MarkwonPlugin.Registry {
    private final List<MarkwonPlugin> origin;
    private final Set<MarkwonPlugin> pending = new HashSet(3);
    private final List<MarkwonPlugin> plugins;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegistryImpl(List<MarkwonPlugin> list) {
        this.origin = list;
        this.plugins = new ArrayList(list.size());
    }

    private void configure(MarkwonPlugin markwonPlugin) {
        if (this.plugins.contains(markwonPlugin)) {
            return;
        }
        if (this.pending.contains(markwonPlugin)) {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.pending);
        }
        this.pending.add(markwonPlugin);
        markwonPlugin.configure(this);
        this.pending.remove(markwonPlugin);
        if (this.plugins.contains(markwonPlugin)) {
            return;
        }
        if (CorePlugin.class.isAssignableFrom(markwonPlugin.getClass())) {
            this.plugins.add(0, markwonPlugin);
        } else {
            this.plugins.add(markwonPlugin);
        }
    }

    private static <P extends MarkwonPlugin> P find(List<MarkwonPlugin> list, Class<P> cls) {
        Iterator<MarkwonPlugin> it = list.iterator();
        while (it.hasNext()) {
            P p5 = (P) it.next();
            if (cls.isAssignableFrom(p5.getClass())) {
                return p5;
            }
        }
        return null;
    }

    private <P extends MarkwonPlugin> P get(Class<P> cls) {
        P p5 = (P) find(this.plugins, cls);
        if (p5 == null) {
            p5 = (P) find(this.origin, cls);
            if (p5 == null) {
                throw new IllegalStateException("Requested plugin is not added: " + cls.getName() + ", plugins: " + this.origin);
            }
            configure(p5);
        }
        return p5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<MarkwonPlugin> process() {
        Iterator<MarkwonPlugin> it = this.origin.iterator();
        while (it.hasNext()) {
            configure(it.next());
        }
        return this.plugins;
    }

    @Override // io.noties.markwon.MarkwonPlugin.Registry
    public <P extends MarkwonPlugin> void require(Class<P> cls, MarkwonPlugin.Action<? super P> action) {
        action.apply(get(cls));
    }
}
