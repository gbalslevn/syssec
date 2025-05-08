package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.identity.ClientIdentity;
import com.google.android.gms.internal.identity.zzeo;

/* loaded from: classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzaf();
    private int zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private int zzf;
    private float zzg;
    private boolean zzh;
    private long zzi;
    private final int zzj;
    private final int zzk;
    private final boolean zzl;
    private final WorkSource zzm;
    private final ClientIdentity zzn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequest(int i5, long j5, long j6, long j7, long j8, long j9, int i6, float f5, boolean z5, long j10, int i7, int i8, boolean z6, WorkSource workSource, ClientIdentity clientIdentity) {
        long j11;
        this.zza = i5;
        if (i5 == 105) {
            this.zzb = Long.MAX_VALUE;
            j11 = j5;
        } else {
            j11 = j5;
            this.zzb = j11;
        }
        this.zzc = j6;
        this.zzd = j7;
        this.zze = j8 == Long.MAX_VALUE ? j9 : Math.min(Math.max(1L, j8 - SystemClock.elapsedRealtime()), j9);
        this.zzf = i6;
        this.zzg = f5;
        this.zzh = z5;
        this.zzi = j10 != -1 ? j10 : j11;
        this.zzj = i7;
        this.zzk = i8;
        this.zzl = z6;
        this.zzm = workSource;
        this.zzn = clientIdentity;
    }

    private static String zze(long j5) {
        return j5 == Long.MAX_VALUE ? "∞" : zzeo.zzb(j5);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && ((isPassive() || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzl == locationRequest.zzl && this.zzm.equals(locationRequest.zzm) && Objects.equal(this.zzn, locationRequest.zzn)))) {
                return true;
            }
        }
        return false;
    }

    public long getDurationMillis() {
        return this.zze;
    }

    public int getGranularity() {
        return this.zzj;
    }

    public long getIntervalMillis() {
        return this.zzb;
    }

    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    public int getMaxUpdates() {
        return this.zzf;
    }

    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    public int getPriority() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzm);
    }

    public boolean isBatched() {
        long j5 = this.zzd;
        return j5 > 0 && (j5 >> 1) >= this.zzb;
    }

    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (isPassive()) {
            sb.append(zzan.zzb(this.zza));
            if (this.zzd > 0) {
                sb.append("/");
                zzeo.zzc(this.zzd, sb);
            }
        } else {
            sb.append("@");
            if (isBatched()) {
                zzeo.zzc(this.zzb, sb);
                sb.append("/");
                zzeo.zzc(this.zzd, sb);
            } else {
                zzeo.zzc(this.zzb, sb);
            }
            sb.append(" ");
            sb.append(zzan.zzb(this.zza));
        }
        if (isPassive() || this.zzc != this.zzb) {
            sb.append(", minUpdateInterval=");
            sb.append(zze(this.zzc));
        }
        if (this.zzg > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.zzg);
        }
        if (!isPassive() ? this.zzi != this.zzb : this.zzi != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(zze(this.zzi));
        }
        if (this.zze != Long.MAX_VALUE) {
            sb.append(", duration=");
            zzeo.zzc(this.zze, sb);
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.zzf);
        }
        if (this.zzk != 0) {
            sb.append(", ");
            sb.append(zzar.zzb(this.zzk));
        }
        if (this.zzj != 0) {
            sb.append(", ");
            sb.append(zzq.zzb(this.zzj));
        }
        if (this.zzh) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.zzl) {
            sb.append(", bypass");
        }
        if (!WorkSourceUtil.isEmpty(this.zzm)) {
            sb.append(", ");
            sb.append(this.zzm);
        }
        if (this.zzn != null) {
            sb.append(", impersonation=");
            sb.append(this.zzn);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzl);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzm, i5, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzn, i5, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzk;
    }

    public final boolean zzb() {
        return this.zzl;
    }

    public final WorkSource zzc() {
        return this.zzm;
    }

    public final ClientIdentity zzd() {
        return this.zzn;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        private boolean zzl;
        private WorkSource zzm;
        private ClientIdentity zzn;

        public Builder(int i5, long j5) {
            this(j5);
            setPriority(i5);
        }

        public LocationRequest build() {
            int i5 = this.zza;
            long j5 = this.zzb;
            long j6 = this.zzc;
            if (j6 == -1) {
                j6 = j5;
            } else if (i5 != 105) {
                j6 = Math.min(j6, j5);
            }
            long max = Math.max(this.zzd, this.zzb);
            long j7 = this.zze;
            int i6 = this.zzf;
            float f5 = this.zzg;
            boolean z5 = this.zzh;
            long j8 = this.zzi;
            return new LocationRequest(i5, j5, j6, max, Long.MAX_VALUE, j7, i6, f5, z5, j8 == -1 ? this.zzb : j8, this.zzj, this.zzk, this.zzl, new WorkSource(this.zzm), this.zzn);
        }

        public Builder setDurationMillis(long j5) {
            Preconditions.checkArgument(j5 > 0, "durationMillis must be greater than 0");
            this.zze = j5;
            return this;
        }

        public Builder setGranularity(int i5) {
            zzq.zza(i5);
            this.zzj = i5;
            return this;
        }

        public Builder setIntervalMillis(long j5) {
            Preconditions.checkArgument(j5 >= 0, "intervalMillis must be greater than or equal to 0");
            this.zzb = j5;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j5) {
            boolean z5 = true;
            if (j5 != -1 && j5 < 0) {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = j5;
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long j5) {
            Preconditions.checkArgument(j5 >= 0, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = j5;
            return this;
        }

        public Builder setMaxUpdates(int i5) {
            Preconditions.checkArgument(i5 > 0, "maxUpdates must be greater than 0");
            this.zzf = i5;
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float f5) {
            Preconditions.checkArgument(f5 >= 0.0f, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = f5;
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long j5) {
            boolean z5 = true;
            if (j5 != -1 && j5 < 0) {
                z5 = false;
            }
            Preconditions.checkArgument(z5, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = j5;
            return this;
        }

        public Builder setPriority(int i5) {
            zzan.zza(i5);
            this.zza = i5;
            return this;
        }

        public Builder setWaitForAccurateLocation(boolean z5) {
            this.zzh = z5;
            return this;
        }

        public final Builder zza(int i5) {
            zzar.zza(i5);
            this.zzk = i5;
            return this;
        }

        public final Builder zzb(boolean z5) {
            this.zzl = z5;
            return this;
        }

        public final Builder zzc(WorkSource workSource) {
            this.zzm = workSource;
            return this;
        }

        public Builder(long j5) {
            this.zza = 102;
            this.zzc = -1L;
            this.zzd = 0L;
            this.zze = Long.MAX_VALUE;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1L;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = false;
            this.zzm = null;
            this.zzn = null;
            setIntervalMillis(j5);
        }

        public Builder(LocationRequest locationRequest) {
            this(locationRequest.getPriority(), locationRequest.getIntervalMillis());
            setMinUpdateIntervalMillis(locationRequest.getMinUpdateIntervalMillis());
            setMaxUpdateDelayMillis(locationRequest.getMaxUpdateDelayMillis());
            setDurationMillis(locationRequest.getDurationMillis());
            setMaxUpdates(locationRequest.getMaxUpdates());
            setMinUpdateDistanceMeters(locationRequest.getMinUpdateDistanceMeters());
            setWaitForAccurateLocation(locationRequest.isWaitForAccurateLocation());
            setMaxUpdateAgeMillis(locationRequest.getMaxUpdateAgeMillis());
            setGranularity(locationRequest.getGranularity());
            int zza = locationRequest.zza();
            zzar.zza(zza);
            this.zzk = zza;
            this.zzl = locationRequest.zzb();
            this.zzm = locationRequest.zzc();
            ClientIdentity zzd = locationRequest.zzd();
            boolean z5 = true;
            if (zzd != null && zzd.zza()) {
                z5 = false;
            }
            Preconditions.checkArgument(z5);
            this.zzn = zzd;
        }
    }
}
