package coil.memory;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import coil.content.Utils;
import coil.memory.MemoryCache;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H¦\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcoil/memory/MemoryCache;", BuildConfig.FLAVOR, "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$Value;", "get", "(Lcoil/memory/MemoryCache$Key;)Lcoil/memory/MemoryCache$Value;", "value", BuildConfig.FLAVOR, "set", "(Lcoil/memory/MemoryCache$Key;Lcoil/memory/MemoryCache$Value;)V", BuildConfig.FLAVOR, "level", "trimMemory", "(I)V", "Builder", "Key", "Value", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MemoryCache {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcoil/memory/MemoryCache$Builder;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BuildConfig.FLAVOR, "percent", "maxSizePercent", "(D)Lcoil/memory/MemoryCache$Builder;", "Lcoil/memory/MemoryCache;", "build", "()Lcoil/memory/MemoryCache;", "Landroid/content/Context;", "D", BuildConfig.FLAVOR, "maxSizeBytes", "I", BuildConfig.FLAVOR, "strongReferencesEnabled", "Z", "weakReferencesEnabled", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private final Context context;
        private int maxSizeBytes;
        private double maxSizePercent;
        private boolean strongReferencesEnabled = true;
        private boolean weakReferencesEnabled = true;

        public Builder(Context context) {
            this.context = context;
            this.maxSizePercent = Utils.defaultMemoryCacheSizePercent(context);
        }

        public final MemoryCache build() {
            StrongMemoryCache emptyStrongMemoryCache;
            WeakMemoryCache realWeakMemoryCache = this.weakReferencesEnabled ? new RealWeakMemoryCache() : new EmptyWeakMemoryCache();
            if (this.strongReferencesEnabled) {
                double d5 = this.maxSizePercent;
                int calculateMemoryCacheSize = d5 > 0.0d ? Utils.calculateMemoryCacheSize(this.context, d5) : this.maxSizeBytes;
                emptyStrongMemoryCache = calculateMemoryCacheSize > 0 ? new RealStrongMemoryCache(calculateMemoryCacheSize, realWeakMemoryCache) : new EmptyStrongMemoryCache(realWeakMemoryCache);
            } else {
                emptyStrongMemoryCache = new EmptyStrongMemoryCache(realWeakMemoryCache);
            }
            return new RealMemoryCache(emptyStrongMemoryCache, realWeakMemoryCache);
        }

        public final Builder maxSizePercent(double percent) {
            if (0.0d > percent || percent > 1.0d) {
                throw new IllegalArgumentException("size must be in the range [0.0, 1.0].");
            }
            this.maxSizeBytes = 0;
            this.maxSizePercent = percent;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcoil/memory/MemoryCache$Value;", BuildConfig.FLAVOR, "Landroid/graphics/Bitmap;", "bitmap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "extras", "<init>", "(Landroid/graphics/Bitmap;Ljava/util/Map;)V", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "toString", "()Ljava/lang/String;", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Value {
        private final Bitmap bitmap;
        private final Map<String, Object> extras;

        public Value(Bitmap bitmap, Map<String, ? extends Object> map) {
            this.bitmap = bitmap;
            this.extras = map;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Value) {
                Value value = (Value) other;
                if (Intrinsics.areEqual(this.bitmap, value.bitmap) && Intrinsics.areEqual(this.extras, value.extras)) {
                    return true;
                }
            }
            return false;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public int hashCode() {
            return (this.bitmap.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Value(bitmap=" + this.bitmap + ", extras=" + this.extras + ')';
        }
    }

    Value get(Key key);

    void set(Key key, Value value);

    void trimMemory(int level);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001 B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcelable;", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "extras", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "copy", "(Ljava/lang/String;Ljava/util/Map;)Lcoil/memory/MemoryCache$Key;", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", BuildConfig.FLAVOR, "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getKey", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Key implements Parcelable {
        private final Map<String, String> extras;
        private final String key;
        private static final Companion Companion = new Companion(null);

        @Deprecated
        public static final Parcelable.Creator<Key> CREATOR = new Parcelable.Creator<Key>() { // from class: coil.memory.MemoryCache$Key$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MemoryCache.Key createFromParcel(Parcel parcel) {
                String readString = parcel.readString();
                Intrinsics.checkNotNull(readString);
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int i5 = 0; i5 < readInt; i5++) {
                    String readString2 = parcel.readString();
                    Intrinsics.checkNotNull(readString2);
                    String readString3 = parcel.readString();
                    Intrinsics.checkNotNull(readString3);
                    linkedHashMap.put(readString2, readString3);
                }
                return new MemoryCache.Key(readString, linkedHashMap);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MemoryCache.Key[] newArray(int size) {
                return new MemoryCache.Key[size];
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcoil/memory/MemoryCache$Key$Companion;", BuildConfig.FLAVOR, "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcoil/memory/MemoryCache$Key;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Key(String str, Map<String, String> map) {
            this.key = str;
            this.extras = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Key copy$default(Key key, String str, Map map, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = key.key;
            }
            if ((i5 & 2) != 0) {
                map = key.extras;
            }
            return key.copy(str, map);
        }

        public final Key copy(String key, Map<String, String> extras) {
            return new Key(key, extras);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Key) {
                Key key = (Key) other;
                if (Intrinsics.areEqual(this.key, key.key) && Intrinsics.areEqual(this.extras, key.extras)) {
                    return true;
                }
            }
            return false;
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeString(this.key);
            parcel.writeInt(this.extras.size());
            for (Map.Entry<String, String> entry : this.extras.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                parcel.writeString(key);
                parcel.writeString(value);
            }
        }

        public /* synthetic */ Key(String str, Map map, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i5 & 2) != 0 ? MapsKt.emptyMap() : map);
        }
    }
}
