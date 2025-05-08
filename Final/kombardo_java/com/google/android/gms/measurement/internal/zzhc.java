package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzhc {
    private final String zza;
    private final Bundle zzb;
    private Bundle zzc;
    private final /* synthetic */ zzha zzd;

    public zzhc(zzha zzhaVar, String str, Bundle bundle) {
        this.zzd = zzhaVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = new Bundle();
    }

    private final String zzb(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    if (!com.google.android.gms.internal.measurement.zzoy.zza() || !this.zzd.zze().zza(zzbn.zzcq)) {
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                        }
                    } else if (obj instanceof String) {
                        jSONObject.put("v", String.valueOf(obj));
                        jSONObject.put("t", "s");
                    } else if (obj instanceof Long) {
                        jSONObject.put("v", String.valueOf(obj));
                        jSONObject.put("t", "l");
                    } else if (obj instanceof int[]) {
                        jSONObject.put("v", Arrays.toString((int[]) obj));
                        jSONObject.put("t", "ia");
                    } else if (obj instanceof long[]) {
                        jSONObject.put("v", Arrays.toString((long[]) obj));
                        jSONObject.put("t", "la");
                    } else if (obj instanceof Double) {
                        jSONObject.put("v", String.valueOf(obj));
                        jSONObject.put("t", "d");
                    } else {
                        this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e5) {
                    this.zzd.zzj().zzg().zza("Cannot serialize bundle value to SharedPreferences", e5);
                }
            }
        }
        return jSONArray.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0123 A[Catch: NumberFormatException | JSONException -> 0x012b, NumberFormatException | JSONException -> 0x012b, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x012b, blocks: (B:13:0x0025, B:31:0x0094, B:31:0x0094, B:34:0x00a5, B:34:0x00a5, B:36:0x00ab, B:36:0x00ab, B:38:0x00b9, B:38:0x00b9, B:40:0x00cb, B:40:0x00cb, B:42:0x00d4, B:42:0x00d4, B:46:0x00d8, B:46:0x00d8, B:48:0x00de, B:48:0x00de, B:50:0x00ec, B:50:0x00ec, B:52:0x00fe, B:52:0x00fe, B:54:0x0107, B:54:0x0107, B:58:0x010b, B:58:0x010b, B:60:0x0117, B:60:0x0117, B:62:0x0123, B:62:0x0123, B:64:0x0053, B:67:0x005d, B:70:0x0067, B:73:0x0072, B:76:0x007c), top: B:12:0x0025, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle zza() {
        JSONObject jSONObject;
        String string;
        String string2;
        int hashCode;
        char c5;
        if (this.zzc == null) {
            String string3 = this.zzd.zzg().getString(this.zza, null);
            if (string3 != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string3);
                    for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                        try {
                            jSONObject = jSONArray.getJSONObject(i5);
                            string = jSONObject.getString("n");
                            string2 = jSONObject.getString("t");
                            hashCode = string2.hashCode();
                        } catch (NumberFormatException | JSONException unused) {
                            this.zzd.zzj().zzg().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                        if (hashCode == 100) {
                            if (string2.equals("d")) {
                                c5 = 1;
                                if (c5 != 0) {
                                }
                            }
                            c5 = 65535;
                            if (c5 != 0) {
                            }
                        } else if (hashCode == 108) {
                            if (string2.equals("l")) {
                                c5 = 2;
                                if (c5 != 0) {
                                }
                            }
                            c5 = 65535;
                            if (c5 != 0) {
                            }
                        } else if (hashCode == 115) {
                            if (string2.equals("s")) {
                                c5 = 0;
                                if (c5 != 0) {
                                }
                            }
                            c5 = 65535;
                            if (c5 != 0) {
                            }
                        } else if (hashCode != 3352) {
                            if (hashCode == 3445 && string2.equals("la")) {
                                c5 = 4;
                                if (c5 != 0) {
                                    bundle.putString(string, jSONObject.getString("v"));
                                } else if (c5 == 1) {
                                    bundle.putDouble(string, Double.parseDouble(jSONObject.getString("v")));
                                } else if (c5 == 2) {
                                    bundle.putLong(string, Long.parseLong(jSONObject.getString("v")));
                                } else if (c5 != 3) {
                                    if (c5 != 4) {
                                        this.zzd.zzj().zzg().zza("Unrecognized persisted bundle type. Type", string2);
                                    } else if (com.google.android.gms.internal.measurement.zzoy.zza() && this.zzd.zze().zza(zzbn.zzcq)) {
                                        JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                        int length = jSONArray2.length();
                                        long[] jArr = new long[length];
                                        for (int i6 = 0; i6 < length; i6++) {
                                            jArr[i6] = jSONArray2.optLong(i6);
                                        }
                                        bundle.putLongArray(string, jArr);
                                    }
                                } else if (com.google.android.gms.internal.measurement.zzoy.zza() && this.zzd.zze().zza(zzbn.zzcq)) {
                                    JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                    int length2 = jSONArray3.length();
                                    int[] iArr = new int[length2];
                                    for (int i7 = 0; i7 < length2; i7++) {
                                        iArr[i7] = jSONArray3.optInt(i7);
                                    }
                                    bundle.putIntArray(string, iArr);
                                }
                            }
                            c5 = 65535;
                            if (c5 != 0) {
                            }
                        } else {
                            if (string2.equals("ia")) {
                                c5 = 3;
                                if (c5 != 0) {
                                }
                            }
                            c5 = 65535;
                            if (c5 != 0) {
                            }
                        }
                    }
                    this.zzc = bundle;
                } catch (JSONException unused2) {
                    this.zzd.zzj().zzg().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzc == null) {
                this.zzc = this.zzb;
            }
        }
        return new Bundle((Bundle) Preconditions.checkNotNull(this.zzc));
    }

    public final void zza(Bundle bundle) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        SharedPreferences.Editor edit = this.zzd.zzg().edit();
        if (bundle2.size() == 0) {
            edit.remove(this.zza);
        } else {
            edit.putString(this.zza, zzb(bundle2));
        }
        edit.apply();
        this.zzc = bundle2;
    }
}
