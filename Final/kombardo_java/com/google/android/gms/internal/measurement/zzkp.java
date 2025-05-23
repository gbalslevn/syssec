package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes.dex */
public class zzkp extends IOException {
    public zzkp(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzko zza() {
        return new zzko("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkp zzc() {
        return new zzkp("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkp zzd() {
        return new zzkp("Protocol message had invalid UTF-8.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkp zzf() {
        return new zzkp("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkp zzg() {
        return new zzkp("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkp zzh() {
        return new zzkp("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkp zzi() {
        return new zzkp("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
