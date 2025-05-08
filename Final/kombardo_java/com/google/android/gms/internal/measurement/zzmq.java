package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
abstract class zzmq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zziy zziyVar) {
        zzmt zzmtVar = new zzmt(zziyVar);
        StringBuilder sb = new StringBuilder(zzmtVar.zza());
        for (int i5 = 0; i5 < zzmtVar.zza(); i5++) {
            byte zza = zzmtVar.zza(i5);
            if (zza == 34) {
                sb.append("\\\"");
            } else if (zza == 39) {
                sb.append("\\'");
            } else if (zza != 92) {
                switch (zza) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zza < 32 || zza > 126) {
                            sb.append('\\');
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            sb.append((char) ((zza & 7) + 48));
                            break;
                        } else {
                            sb.append((char) zza);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
