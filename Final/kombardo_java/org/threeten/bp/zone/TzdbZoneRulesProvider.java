package org.threeten.bp.zone;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.threeten.bp.jdk8.Jdk8Methods;

/* loaded from: classes3.dex */
public final class TzdbZoneRulesProvider extends ZoneRulesProvider {
    private List<String> regionIds;
    private final ConcurrentNavigableMap<String, Version> versions = new ConcurrentSkipListMap();
    private Set<String> loadedUrls = new CopyOnWriteArraySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Version {
        private final String[] regionArray;
        private final AtomicReferenceArray<Object> ruleData;
        private final short[] ruleIndices;
        private final String versionId;

        Version(String str, String[] strArr, short[] sArr, AtomicReferenceArray<Object> atomicReferenceArray) {
            this.ruleData = atomicReferenceArray;
            this.versionId = str;
            this.regionArray = strArr;
            this.ruleIndices = sArr;
        }

        ZoneRules createRule(short s5) {
            Object obj = this.ruleData.get(s5);
            if (obj instanceof byte[]) {
                obj = Ser.read(new DataInputStream(new ByteArrayInputStream((byte[]) obj)));
                this.ruleData.set(s5, obj);
            }
            return (ZoneRules) obj;
        }

        ZoneRules getRules(String str) {
            int binarySearch = Arrays.binarySearch(this.regionArray, str);
            if (binarySearch < 0) {
                return null;
            }
            try {
                return createRule(this.ruleIndices[binarySearch]);
            } catch (Exception e5) {
                throw new ZoneRulesException("Invalid binary time-zone data: TZDB:" + str + ", version: " + this.versionId, e5);
            }
        }

        public String toString() {
            return this.versionId;
        }
    }

    public TzdbZoneRulesProvider(InputStream inputStream) {
        try {
            load(inputStream);
        } catch (Exception e5) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules", e5);
        }
    }

    private boolean load(InputStream inputStream) {
        boolean z5 = false;
        for (Version version : loadData(inputStream)) {
            Version putIfAbsent = this.versions.putIfAbsent(version.versionId, version);
            if (putIfAbsent != null && !putIfAbsent.versionId.equals(version.versionId)) {
                throw new ZoneRulesException("Data already loaded for TZDB time-zone rules version: " + version.versionId);
            }
            z5 = true;
        }
        return z5;
    }

    private Iterable<Version> loadData(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        }
        if (!"TZDB".equals(dataInputStream.readUTF())) {
            throw new StreamCorruptedException("File format not recognised");
        }
        int readShort = dataInputStream.readShort();
        String[] strArr = new String[readShort];
        for (int i5 = 0; i5 < readShort; i5++) {
            strArr[i5] = dataInputStream.readUTF();
        }
        int readShort2 = dataInputStream.readShort();
        String[] strArr2 = new String[readShort2];
        for (int i6 = 0; i6 < readShort2; i6++) {
            strArr2[i6] = dataInputStream.readUTF();
        }
        this.regionIds = Arrays.asList(strArr2);
        int readShort3 = dataInputStream.readShort();
        Object[] objArr = new Object[readShort3];
        for (int i7 = 0; i7 < readShort3; i7++) {
            byte[] bArr = new byte[dataInputStream.readShort()];
            dataInputStream.readFully(bArr);
            objArr[i7] = bArr;
        }
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
        HashSet hashSet = new HashSet(readShort);
        for (int i8 = 0; i8 < readShort; i8++) {
            int readShort4 = dataInputStream.readShort();
            String[] strArr3 = new String[readShort4];
            short[] sArr = new short[readShort4];
            for (int i9 = 0; i9 < readShort4; i9++) {
                strArr3[i9] = strArr2[dataInputStream.readShort()];
                sArr[i9] = dataInputStream.readShort();
            }
            hashSet.add(new Version(strArr[i8], strArr3, sArr, atomicReferenceArray));
        }
        return hashSet;
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    protected ZoneRules provideRules(String str, boolean z5) {
        Jdk8Methods.requireNonNull(str, "zoneId");
        ZoneRules rules = this.versions.lastEntry().getValue().getRules(str);
        if (rules != null) {
            return rules;
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    protected Set<String> provideZoneIds() {
        return new HashSet(this.regionIds);
    }

    public String toString() {
        return "TZDB";
    }
}
