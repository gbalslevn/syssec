package com.google.firebase.components;

import com.google.firebase.components.ComponentRegistrar;
import java.util.List;

/* loaded from: classes2.dex */
public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = new ComponentRegistrarProcessor() { // from class: E0.d
        @Override // com.google.firebase.components.ComponentRegistrarProcessor
        public final List processRegistrar(ComponentRegistrar componentRegistrar) {
            return componentRegistrar.getComponents();
        }
    };

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
