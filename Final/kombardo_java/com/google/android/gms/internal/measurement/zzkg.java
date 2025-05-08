package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzkg.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class zzkg<MessageType extends zzkg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzio<MessageType, BuilderType> {
    private static Map<Class<?>, zzkg<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzmx zzb = zzmx.zzc();

    /* loaded from: classes.dex */
    protected static class zzc<T extends zzkg<T, ?>> extends zzip<T> {
        public zzc(T t5) {
        }
    }

    /* loaded from: classes.dex */
    public static class zzd<ContainingType extends zzlm, Type> extends zzjr<ContainingType, Type> {
    }

    /* loaded from: classes.dex */
    public enum zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    private final int zza() {
        return zzma.zza().zza((zzma) this).zzb(this);
    }

    private final int zzb(zzme<?> zzmeVar) {
        if (zzmeVar == null) {
            return zzma.zza().zza((zzma) this).zza(this);
        }
        return zzmeVar.zza(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkk zzcj() {
        return zzkh.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkn zzck() {
        return zzlb.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzkm<E> zzcl() {
        return zzmd.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzma.zza().zza((zzma) this).zzb(this, (zzkg) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzcq()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    public final boolean j_() {
        return zzb(this, true);
    }

    public String toString() {
        return zzlr.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i5, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zzlo
    public final /* synthetic */ zzlm zzal() {
        return (zzkg) zza(zzf.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    final void zzc(int i5) {
        if (i5 >= 0) {
            this.zzd = (i5 & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i5);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    final int zzcc() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final int zzcf() {
        return zza((zzme) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzkg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzcg() {
        return (BuilderType) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzch() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza((zza) this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MessageType zzci() {
        return (MessageType) zza(zzf.zzd, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzlp zzcm() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzco() {
        zzma.zza().zza((zzma) this).zzd(this);
        zzcp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzcp() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzcq() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* loaded from: classes.dex */
    public static abstract class zza<MessageType extends zzkg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzcq()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzci();
        }

        private final BuilderType zzb(byte[] bArr, int i5, int i6, zzjt zzjtVar) {
            if (!this.zza.zzcq()) {
                zzan();
            }
            try {
                zzma.zza().zza((zzma) this.zza).zza(this.zza, bArr, 0, i6, new zzit(zzjtVar));
                return this;
            } catch (zzkp e5) {
                throw e5;
            } catch (IOException e6) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e6);
            } catch (IndexOutOfBoundsException unused) {
                throw zzkp.zzi();
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzin
        public /* synthetic */ Object clone() {
            zza zzaVar = (zza) this.zzb.zza(zzf.zze, null, null);
            zzaVar.zza = (MessageType) zzak();
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzin
        public final /* synthetic */ zzin zza(byte[] bArr, int i5, int i6) {
            return zzb(bArr, 0, i6, zzjt.zza);
        }

        /* renamed from: zzah, reason: merged with bridge method [inline-methods] */
        public final MessageType zzaj() {
            MessageType messagetype = (MessageType) zzak();
            if (messagetype.j_()) {
                return messagetype;
            }
            throw new zzmv(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzlp
        /* renamed from: zzai, reason: merged with bridge method [inline-methods] */
        public MessageType zzak() {
            if (!this.zza.zzcq()) {
                return this.zza;
            }
            this.zza.zzco();
            return this.zza;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void zzam() {
            if (this.zza.zzcq()) {
                return;
            }
            zzan();
        }

        protected void zzan() {
            MessageType messagetype = (MessageType) this.zzb.zzci();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.zzin
        public final /* synthetic */ zzin zza(byte[] bArr, int i5, int i6, zzjt zzjtVar) {
            return zzb(bArr, 0, i6, zzjtVar);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzcq()) {
                zzan();
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzma.zza().zza((zzma) messagetype).zza(messagetype, messagetype2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    final int zza(zzme zzmeVar) {
        if (zzcq()) {
            int zzb = zzb(zzmeVar);
            if (zzb >= 0) {
                return zzb;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzb);
        }
        if (zzcc() != Integer.MAX_VALUE) {
            return zzcc();
        }
        int zzb2 = zzb(zzmeVar);
        zzc(zzb2);
        return zzb2;
    }

    private static final <T extends zzkg<T, ?>> boolean zzb(T t5, boolean z5) {
        byte byteValue = ((Byte) t5.zza(zzf.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zze = zzma.zza().zza((zzma) t5).zze(t5);
        if (z5) {
            t5.zza(zzf.zzb, zze ? t5 : null, null);
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzkg<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzcg().zza(messagetype);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzkg<?, ?>> T zza(Class<T> cls) {
        zzkg<?, ?> zzkgVar = zzc.get(cls);
        if (zzkgVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkgVar = zzc.get(cls);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException("Class initialization cannot fail.", e5);
            }
        }
        if (zzkgVar == null) {
            zzkgVar = (T) ((zzkg) zzmz.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (zzkgVar != null) {
                zzc.put(cls, zzkgVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzkgVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzkn zza(zzkn zzknVar) {
        return zzknVar.zza(zzknVar.size() << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzkm<E> zza(zzkm<E> zzkmVar) {
        return zzkmVar.zza(zzkmVar.size() << 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e5);
        } catch (InvocationTargetException e6) {
            Throwable cause = e6.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzlm zzlmVar, String str, Object[] objArr) {
        return new zzmc(zzlmVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzkg<?, ?>> void zza(Class<T> cls, T t5) {
        t5.zzcp();
        zzc.put(cls, t5);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zza(zzjn zzjnVar) {
        zzma.zza().zza((zzma) this).zza((zzme) this, (zznl) zzjp.zza(zzjnVar));
    }
}
