package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableSetMultimap;

/* loaded from: classes.dex */
public abstract class zzik {
    public static final Supplier<ImmutableSetMultimap<String, String>> zza = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzim
        @Override // com.google.common.base.Supplier
        public final Object get() {
            ImmutableSetMultimap build;
            build = new ImmutableSetMultimap.Builder().build();
            return build;
        }
    });
}
