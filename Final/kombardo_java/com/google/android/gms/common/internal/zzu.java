package com.google.android.gms.common.internal;

import android.net.Uri;

/* loaded from: classes.dex */
public abstract class zzu {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4345a = 0;
    private static final Uri zzb;
    private static final Uri zzc;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        zzb = parse;
        zzc = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
