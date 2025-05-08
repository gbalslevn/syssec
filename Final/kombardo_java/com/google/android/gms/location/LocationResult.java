package com.google.android.gms.location;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    private final List zzb;
    static final List zza = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzag();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationResult(List list) {
        this.zzb = list;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (Build.VERSION.SDK_INT >= 31) {
            return this.zzb.equals(locationResult.zzb);
        }
        if (this.zzb.size() != locationResult.zzb.size()) {
            return false;
        }
        Iterator it = locationResult.zzb.iterator();
        for (Location location : this.zzb) {
            Location location2 = (Location) it.next();
            if (Double.compare(location.getLatitude(), location2.getLatitude()) != 0 || Double.compare(location.getLongitude(), location2.getLongitude()) != 0 || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || !Objects.equal(location.getProvider(), location2.getProvider())) {
                return false;
            }
        }
        return true;
    }

    public Location getLastLocation() {
        int size = this.zzb.size();
        if (size == 0) {
            return null;
        }
        return (Location) this.zzb.get(size - 1);
    }

    public List<Location> getLocations() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LocationResult");
        int i5 = zzak.f4348a;
        List list = this.zzb;
        sb.ensureCapacity(list.size() * 100);
        sb.append("[");
        Iterator it = list.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            zzak.zza((Location) it.next(), sb);
            sb.append(", ");
            z5 = true;
        }
        if (z5) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getLocations(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
