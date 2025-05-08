package com.google.android.gms.internal.measurement;

import A2.c;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class zzin<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> implements zzlp {
    public abstract /* synthetic */ Object clone();

    public abstract BuilderType zza(byte[] bArr, int i5, int i6);

    public abstract BuilderType zza(byte[] bArr, int i5, int i6, zzjt zzjtVar);

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final /* synthetic */ zzlp zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzlp
    public final /* synthetic */ zzlp zza(byte[] bArr, zzjt zzjtVar) {
        return zza(bArr, 0, bArr.length, zzjtVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzkj.zza(iterable);
        if (iterable instanceof zzkx) {
            List<?> zza = ((zzkx) iterable).zza();
            zzkx zzkxVar = (zzkx) list;
            int size = list.size();
            for (Object obj : zza) {
                if (obj == null) {
                    String str = "Element at index " + (zzkxVar.size() - size) + " is null.";
                    for (int size2 = zzkxVar.size() - 1; size2 >= size; size2--) {
                        zzkxVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof zziy) {
                    zzkxVar.zza((zziy) obj);
                } else if (obj instanceof byte[]) {
                    zzkxVar.zza(zziy.zza((byte[]) obj));
                } else {
                    zzkxVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzly) {
            list.addAll((Collection) iterable);
            return;
        }
        if (iterable instanceof Collection) {
            int size3 = ((Collection) iterable).size();
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + size3);
            } else if (list instanceof zzmd) {
                ((zzmd) list).zzb(list.size() + size3);
            }
        }
        int size4 = list.size();
        if ((iterable instanceof List) && (iterable instanceof RandomAccess)) {
            List list2 = (List) iterable;
            int size5 = list2.size();
            for (int i5 = 0; i5 < size5; i5++) {
                c cVar = (Object) list2.get(i5);
                if (cVar == null) {
                    zza(list, size4);
                }
                list.add(cVar);
            }
            return;
        }
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                zza(list, size4);
            }
            list.add(obj2);
        }
    }

    private static void zza(List<?> list, int i5) {
        String str = "Element at index " + (list.size() - i5) + " is null.";
        for (int size = list.size() - 1; size >= i5; size--) {
            list.remove(size);
        }
        throw new NullPointerException(str);
    }
}
