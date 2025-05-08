package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzas implements zzaq, Iterable<zzaq> {
    private final String zza;

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.zza.equals(((zzas) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator<zzaq> iterator() {
        return new zzau(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final zzaq zzc() {
        return new zzas(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Boolean zzd() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Double zze() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final String zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzaq
    public final Iterator<zzaq> zzh() {
        return new zzav(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0320  */
    @Override // com.google.android.gms.internal.measurement.zzaq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzaq zza(String str, zzh zzhVar, List<zzaq> list) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        char c5;
        int i5;
        String zzf;
        String zzf2;
        double min;
        double min2;
        int i6;
        int length;
        int i7;
        zzh zzhVar2;
        String zzf3;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || "search".equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str)) {
            str2 = "toLocaleUpperCase";
        } else {
            str2 = "toLocaleUpperCase";
            if (!str2.equals(str)) {
                str3 = "hasOwnProperty";
                str4 = "trim";
                if (!str4.equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
                str.hashCode();
                switch (str.hashCode()) {
                    case -1789698943:
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        if (str.equals(str7)) {
                            c5 = 0;
                            break;
                        }
                        c5 = 65535;
                        break;
                    case -1776922004:
                        str5 = "charAt";
                        str6 = "toString";
                        str8 = "toLocaleLowerCase";
                        str7 = str3;
                        if (str.equals(str6)) {
                            c5 = 1;
                            break;
                        }
                        c5 = 65535;
                        break;
                    case -1464939364:
                        str5 = "charAt";
                        str8 = "toLocaleLowerCase";
                        str6 = "toString";
                        str7 = str3;
                        if (str.equals(str8)) {
                            c5 = 2;
                            break;
                        }
                        c5 = 65535;
                        break;
                    case -1361633751:
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        if (str.equals(str5)) {
                            c5 = 3;
                            break;
                        }
                        c5 = 65535;
                        break;
                    case -1354795244:
                        if (str.equals("concat")) {
                            c5 = 4;
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case -1137582698:
                        if (str.equals("toLowerCase")) {
                            c5 = 5;
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case -906336856:
                        if (str.equals("search")) {
                            c5 = 6;
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case -726908483:
                        if (str.equals(str2)) {
                            c5 = 7;
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case -467511597:
                        if (str.equals("lastIndexOf")) {
                            c5 = '\b';
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case -399551817:
                        if (str.equals("toUpperCase")) {
                            c5 = '\t';
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case 3568674:
                        if (str.equals(str4)) {
                            c5 = '\n';
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case 103668165:
                        if (str.equals("match")) {
                            c5 = 11;
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case 109526418:
                        if (str.equals("slice")) {
                            c5 = '\f';
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case 109648666:
                        if (str.equals("split")) {
                            c5 = '\r';
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case 530542161:
                        if (str.equals("substring")) {
                            c5 = 14;
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case 1094496948:
                        if (str.equals("replace")) {
                            c5 = 15;
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    case 1943291465:
                        if (str.equals("indexOf")) {
                            c5 = 16;
                            str5 = "charAt";
                            str6 = "toString";
                            str7 = str3;
                            str8 = "toLocaleLowerCase";
                            break;
                        }
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                    default:
                        str5 = "charAt";
                        str6 = "toString";
                        str7 = str3;
                        str8 = "toLocaleLowerCase";
                        c5 = 65535;
                        break;
                }
                switch (c5) {
                    case 0:
                        zzg.zza(str7, 1, list);
                        String str9 = this.zza;
                        zzaq zza = zzhVar.zza(list.get(0));
                        if ("length".equals(zza.zzf())) {
                            return zzaq.zzh;
                        }
                        double doubleValue = zza.zze().doubleValue();
                        if (doubleValue == Math.floor(doubleValue) && (i5 = (int) doubleValue) >= 0 && i5 < str9.length()) {
                            return zzaq.zzh;
                        }
                        return zzaq.zzi;
                    case 1:
                        zzg.zza(str6, 0, list);
                        return this;
                    case 2:
                        zzg.zza(str8, 0, list);
                        return new zzas(this.zza.toLowerCase());
                    case 3:
                        zzg.zzc(str5, 1, list);
                        int zza2 = !list.isEmpty() ? (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue()) : 0;
                        String str10 = this.zza;
                        if (zza2 >= 0 && zza2 < str10.length()) {
                            return new zzas(String.valueOf(str10.charAt(zza2)));
                        }
                        return zzaq.zzj;
                    case 4:
                        if (list.isEmpty()) {
                            return this;
                        }
                        StringBuilder sb = new StringBuilder(this.zza);
                        for (int i8 = 0; i8 < list.size(); i8++) {
                            sb.append(zzhVar.zza(list.get(i8)).zzf());
                        }
                        return new zzas(sb.toString());
                    case 5:
                        zzg.zza("toLowerCase", 0, list);
                        return new zzas(this.zza.toLowerCase(Locale.ENGLISH));
                    case 6:
                        zzg.zzc("search", 1, list);
                        if (!list.isEmpty()) {
                            zzf = zzhVar.zza(list.get(0)).zzf();
                        } else {
                            zzf = zzaq.zzc.zzf();
                        }
                        if (Pattern.compile(zzf).matcher(this.zza).find()) {
                            return new zzai(Double.valueOf(r0.start()));
                        }
                        return new zzai(Double.valueOf(-1.0d));
                    case 7:
                        zzg.zza(str2, 0, list);
                        return new zzas(this.zza.toUpperCase());
                    case '\b':
                        zzg.zzc("lastIndexOf", 2, list);
                        String str11 = this.zza;
                        if (list.size() <= 0) {
                            zzf2 = zzaq.zzc.zzf();
                        } else {
                            zzf2 = zzhVar.zza(list.get(0)).zzf();
                        }
                        return new zzai(Double.valueOf(str11.lastIndexOf(zzf2, (int) (Double.isNaN(list.size() < 2 ? Double.NaN : zzhVar.zza(list.get(1)).zze().doubleValue()) ? Double.POSITIVE_INFINITY : zzg.zza(r4)))));
                    case '\t':
                        zzg.zza("toUpperCase", 0, list);
                        return new zzas(this.zza.toUpperCase(Locale.ENGLISH));
                    case '\n':
                        zzg.zza("toUpperCase", 0, list);
                        return new zzas(this.zza.trim());
                    case 11:
                        zzg.zzc("match", 1, list);
                        Matcher matcher = Pattern.compile(list.size() <= 0 ? BuildConfig.FLAVOR : zzhVar.zza(list.get(0)).zzf()).matcher(this.zza);
                        if (matcher.find()) {
                            return new zzaf(new zzas(matcher.group()));
                        }
                        return zzaq.zzd;
                    case '\f':
                        zzg.zzc("slice", 2, list);
                        String str12 = this.zza;
                        double zza3 = zzg.zza(!list.isEmpty() ? zzhVar.zza(list.get(0)).zze().doubleValue() : 0.0d);
                        if (zza3 < 0.0d) {
                            min = Math.max(str12.length() + zza3, 0.0d);
                        } else {
                            min = Math.min(zza3, str12.length());
                        }
                        int i9 = (int) min;
                        double zza4 = zzg.zza(list.size() > 1 ? zzhVar.zza(list.get(1)).zze().doubleValue() : str12.length());
                        if (zza4 < 0.0d) {
                            min2 = Math.max(str12.length() + zza4, 0.0d);
                        } else {
                            min2 = Math.min(zza4, str12.length());
                        }
                        return new zzas(str12.substring(i9, Math.max(0, ((int) min2) - i9) + i9));
                    case '\r':
                        zzg.zzc("split", 2, list);
                        String str13 = this.zza;
                        if (str13.length() == 0) {
                            return new zzaf(this);
                        }
                        ArrayList arrayList = new ArrayList();
                        if (list.isEmpty()) {
                            arrayList.add(this);
                        } else {
                            String zzf4 = zzhVar.zza(list.get(0)).zzf();
                            long zzc = list.size() > 1 ? zzg.zzc(zzhVar.zza(list.get(1)).zze().doubleValue()) : 2147483647L;
                            if (zzc == 0) {
                                return new zzaf();
                            }
                            String[] split = str13.split(Pattern.quote(zzf4), ((int) zzc) + 1);
                            int length2 = split.length;
                            if (!zzf4.isEmpty() || split.length <= 0) {
                                i6 = 0;
                            } else {
                                boolean isEmpty = split[0].isEmpty();
                                i6 = isEmpty;
                                if (split[split.length - 1].isEmpty()) {
                                    length2 = split.length - 1;
                                    i6 = isEmpty;
                                }
                            }
                            if (split.length > zzc) {
                                length2--;
                            }
                            while (i6 < length2) {
                                arrayList.add(new zzas(split[i6]));
                                i6++;
                            }
                        }
                        return new zzaf(arrayList);
                    case 14:
                        zzg.zzc("substring", 2, list);
                        String str14 = this.zza;
                        int zza5 = !list.isEmpty() ? (int) zzg.zza(zzhVar.zza(list.get(0)).zze().doubleValue()) : 0;
                        if (list.size() > 1) {
                            length = (int) zzg.zza(zzhVar.zza(list.get(1)).zze().doubleValue());
                        } else {
                            length = str14.length();
                        }
                        int min3 = Math.min(Math.max(zza5, 0), str14.length());
                        int min4 = Math.min(Math.max(length, 0), str14.length());
                        return new zzas(str14.substring(Math.min(min3, min4), Math.max(min3, min4)));
                    case 15:
                        zzg.zzc("replace", 2, list);
                        zzaq zzaqVar = zzaq.zzc;
                        String zzf5 = zzaqVar.zzf();
                        if (!list.isEmpty()) {
                            zzf5 = zzhVar.zza(list.get(0)).zzf();
                            if (list.size() > 1) {
                                zzaqVar = zzhVar.zza(list.get(1));
                            }
                        }
                        String str15 = this.zza;
                        int indexOf = str15.indexOf(zzf5);
                        if (indexOf < 0) {
                            return this;
                        }
                        if (zzaqVar instanceof zzal) {
                            i7 = 0;
                            zzaqVar = ((zzal) zzaqVar).zza(zzhVar, Arrays.asList(new zzas(zzf5), new zzai(Double.valueOf(indexOf)), this));
                        } else {
                            i7 = 0;
                        }
                        return new zzas(str15.substring(i7, indexOf) + zzaqVar.zzf() + str15.substring(indexOf + zzf5.length()));
                    case 16:
                        zzg.zzc("indexOf", 2, list);
                        String str16 = this.zza;
                        if (list.size() <= 0) {
                            zzf3 = zzaq.zzc.zzf();
                            zzhVar2 = zzhVar;
                        } else {
                            zzhVar2 = zzhVar;
                            zzf3 = zzhVar2.zza(list.get(0)).zzf();
                        }
                        return new zzai(Double.valueOf(str16.indexOf(zzf3, (int) zzg.zza(list.size() < 2 ? 0.0d : zzhVar2.zza(list.get(1)).zze().doubleValue()))));
                    default:
                        throw new IllegalArgumentException("Command not supported");
                }
            }
        }
        str3 = "hasOwnProperty";
        str4 = "trim";
        str.hashCode();
        switch (str.hashCode()) {
            case -1789698943:
                break;
            case -1776922004:
                break;
            case -1464939364:
                break;
            case -1361633751:
                break;
            case -1354795244:
                break;
            case -1137582698:
                break;
            case -906336856:
                break;
            case -726908483:
                break;
            case -467511597:
                break;
            case -399551817:
                break;
            case 3568674:
                break;
            case 103668165:
                break;
            case 109526418:
                break;
            case 109648666:
                break;
            case 530542161:
                break;
            case 1094496948:
                break;
            case 1943291465:
                break;
        }
        switch (c5) {
        }
    }
}
