package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class CrashlyticsReportJsonTransform {
    private static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER = new JsonDataEncoderBuilder().configureWith(AutoCrashlyticsReportEncoder.CONFIG).ignoreNullValues(true).build();

    /* loaded from: classes2.dex */
    public interface ObjectParser<T> {
        T parse(JsonReader jsonReader);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.Session.Application parseApp(JsonReader jsonReader) {
        CrashlyticsReport.Session.Application.Builder builder = CrashlyticsReport.Session.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -519438642:
                    if (nextName.equals("developmentPlatform")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 213652010:
                    if (nextName.equals("developmentPlatformVersion")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setIdentifier(jsonReader.nextString());
                    break;
                case 1:
                    builder.setDevelopmentPlatform(jsonReader.nextString());
                    break;
                case 2:
                    builder.setDevelopmentPlatformVersion(jsonReader.nextString());
                    break;
                case 3:
                    builder.setVersion(jsonReader.nextString());
                    break;
                case 4:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                case 5:
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.ApplicationExitInfo parseAppExitInfo(JsonReader jsonReader) {
        CrashlyticsReport.ApplicationExitInfo.Builder builder = CrashlyticsReport.ApplicationExitInfo.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1516200806:
                    if (nextName.equals("buildIdMappingForArch")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 110987:
                    if (nextName.equals("pid")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 111312:
                    if (nextName.equals("pss")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 113234:
                    if (nextName.equals("rss")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 722137681:
                    if (nextName.equals("reasonCode")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 723857505:
                    if (nextName.equals("traceFile")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c5 = '\b';
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setBuildIdMappingForArch(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.a
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object parse(JsonReader jsonReader2) {
                            CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch parseBuildIdMappingForArch;
                            parseBuildIdMappingForArch = CrashlyticsReportJsonTransform.parseBuildIdMappingForArch(jsonReader2);
                            return parseBuildIdMappingForArch;
                        }
                    }));
                    break;
                case 1:
                    builder.setPid(jsonReader.nextInt());
                    break;
                case 2:
                    builder.setPss(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setRss(jsonReader.nextLong());
                    break;
                case 4:
                    builder.setTimestamp(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setProcessName(jsonReader.nextString());
                    break;
                case 6:
                    builder.setReasonCode(jsonReader.nextInt());
                    break;
                case 7:
                    builder.setTraceFile(jsonReader.nextString());
                    break;
                case '\b':
                    builder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static <T> List<T> parseArray(JsonReader jsonReader, ObjectParser<T> objectParser) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.parse(jsonReader));
        }
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch parseBuildIdMappingForArch(JsonReader jsonReader) {
        CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder builder = CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -609862170:
                    if (nextName.equals("libraryName")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 230943785:
                    if (nextName.equals("buildId")) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setLibraryName(jsonReader.nextString());
                    break;
                case 1:
                    builder.setArch(jsonReader.nextString());
                    break;
                case 2:
                    builder.setBuildId(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static CrashlyticsReport.CustomAttribute parseCustomAttribute(JsonReader jsonReader) {
        CrashlyticsReport.CustomAttribute.Builder builder = CrashlyticsReport.CustomAttribute.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("key")) {
                builder.setKey(jsonReader.nextString());
            } else if (nextName.equals("value")) {
                builder.setValue(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.Session.Device parseDevice(JsonReader jsonReader) {
        CrashlyticsReport.Session.Device.Builder builder = CrashlyticsReport.Session.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c5 = '\b';
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setSimulator(jsonReader.nextBoolean());
                    break;
                case 1:
                    builder.setManufacturer(jsonReader.nextString());
                    break;
                case 2:
                    builder.setRam(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setArch(jsonReader.nextInt());
                    break;
                case 4:
                    builder.setDiskSpace(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setCores(jsonReader.nextInt());
                    break;
                case 6:
                    builder.setModel(jsonReader.nextString());
                    break;
                case 7:
                    builder.setState(jsonReader.nextInt());
                    break;
                case '\b':
                    builder.setModelClass(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.Session.Event parseEvent(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Builder builder = CrashlyticsReport.Session.Event.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -259312414:
                    if (nextName.equals("rollouts")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setDevice(parseEventDevice(jsonReader));
                    break;
                case 1:
                    builder.setRollouts(parseEventRolloutsState(jsonReader));
                    break;
                case 2:
                    builder.setApp(parseEventApp(jsonReader));
                    break;
                case 3:
                    builder.setLog(parseEventLog(jsonReader));
                    break;
                case 4:
                    builder.setType(jsonReader.nextString());
                    break;
                case 5:
                    builder.setTimestamp(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.Session.Event.Application parseEventApp(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Builder builder = CrashlyticsReport.Session.Event.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1405314732:
                    if (nextName.equals("appProcessDetails")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1332194002:
                    if (nextName.equals("background")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -80231855:
                    if (nextName.equals("internalKeys")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 1847730860:
                    if (nextName.equals("currentProcessDetails")) {
                        c5 = 6;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setAppProcessDetails(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.c
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object parse(JsonReader jsonReader2) {
                            CrashlyticsReport.Session.Event.Application.ProcessDetails parseProcessDetails;
                            parseProcessDetails = CrashlyticsReportJsonTransform.parseProcessDetails(jsonReader2);
                            return parseProcessDetails;
                        }
                    }));
                    break;
                case 1:
                    builder.setBackground(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 2:
                    builder.setExecution(parseEventExecution(jsonReader));
                    break;
                case 3:
                    builder.setInternalKeys(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.b
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object parse(JsonReader jsonReader2) {
                            CrashlyticsReport.CustomAttribute parseCustomAttribute;
                            parseCustomAttribute = CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader2);
                            return parseCustomAttribute;
                        }
                    }));
                    break;
                case 4:
                    builder.setCustomAttributes(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.b
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object parse(JsonReader jsonReader2) {
                            CrashlyticsReport.CustomAttribute parseCustomAttribute;
                            parseCustomAttribute = CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader2);
                            return parseCustomAttribute;
                        }
                    }));
                    break;
                case 5:
                    builder.setUiOrientation(jsonReader.nextInt());
                    break;
                case 6:
                    builder.setCurrentProcessDetails(parseProcessDetails(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    public static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage parseEventBinaryImage(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals("name")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setName(jsonReader.nextString());
                    break;
                case 1:
                    builder.setSize(jsonReader.nextLong());
                    break;
                case 2:
                    builder.setUuidFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    builder.setBaseAddress(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.Session.Event.Device parseEventDevice(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Device.Builder builder = CrashlyticsReport.Session.Event.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setBatteryLevel(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    builder.setBatteryVelocity(jsonReader.nextInt());
                    break;
                case 2:
                    builder.setOrientation(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setDiskUsed(jsonReader.nextLong());
                    break;
                case 4:
                    builder.setRamUsed(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setProximityOn(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.Session.Event.Application.Execution parseEventExecution(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals("exception")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setAppExitInfo(parseAppExitInfo(jsonReader));
                    break;
                case 1:
                    builder.setThreads(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.g
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object parse(JsonReader jsonReader2) {
                            CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread;
                            parseEventThread = CrashlyticsReportJsonTransform.parseEventThread(jsonReader2);
                            return parseEventThread;
                        }
                    }));
                    break;
                case 2:
                    builder.setSignal(parseEventSignal(jsonReader));
                    break;
                case 3:
                    builder.setBinaries(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.h
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object parse(JsonReader jsonReader2) {
                            CrashlyticsReport.Session.Event.Application.Execution.BinaryImage parseEventBinaryImage;
                            parseEventBinaryImage = CrashlyticsReportJsonTransform.parseEventBinaryImage(jsonReader2);
                            return parseEventBinaryImage;
                        }
                    }));
                    break;
                case 4:
                    builder.setException(parseEventExecutionException(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.Session.Event.Application.Execution.Exception parseEventExecutionException(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setFrames(parseArray(jsonReader, new i()));
                    break;
                case 1:
                    builder.setReason(jsonReader.nextString());
                    break;
                case 2:
                    builder.setType(jsonReader.nextString());
                    break;
                case 3:
                    builder.setCausedBy(parseEventExecutionException(jsonReader));
                    break;
                case 4:
                    builder.setOverflowCount(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame parseEventFrame(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c5 = 4;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setOffset(jsonReader.nextLong());
                    break;
                case 1:
                    builder.setSymbol(jsonReader.nextString());
                    break;
                case 2:
                    builder.setPc(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setFile(jsonReader.nextString());
                    break;
                case 4:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Log parseEventLog(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Log.Builder builder = CrashlyticsReport.Session.Event.Log.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("content")) {
                builder.setContent(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.Session.Event.RolloutAssignment parseEventRolloutsAssignment(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.RolloutAssignment.Builder builder = CrashlyticsReport.Session.Event.RolloutAssignment.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1536268810:
                    if (nextName.equals("parameterKey")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1027290370:
                    if (nextName.equals("templateVersion")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 1098747284:
                    if (nextName.equals("rolloutVariant")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 1124454216:
                    if (nextName.equals("parameterValue")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setParameterKey(jsonReader.nextString());
                    break;
                case 1:
                    builder.setTemplateVersion(jsonReader.nextLong());
                    break;
                case 2:
                    builder.setRolloutVariant(parseRolloutAssignmentRolloutVariant(jsonReader));
                    break;
                case 3:
                    builder.setParameterValue(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.RolloutsState parseEventRolloutsState(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.RolloutsState.Builder builder = CrashlyticsReport.Session.Event.RolloutsState.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("assignments")) {
                builder.setRolloutAssignments(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.f
                    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                    public final Object parse(JsonReader jsonReader2) {
                        CrashlyticsReport.Session.Event.RolloutAssignment parseEventRolloutsAssignment;
                        parseEventRolloutsAssignment = CrashlyticsReportJsonTransform.parseEventRolloutsAssignment(jsonReader2);
                        return parseEventRolloutsAssignment;
                    }
                }));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.Session.Event.Application.Execution.Signal parseEventSignal(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Signal.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1147692044:
                    if (nextName.equals("address")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3059181:
                    if (nextName.equals("code")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setAddress(jsonReader.nextLong());
                    break;
                case 1:
                    builder.setCode(jsonReader.nextString());
                    break;
                case 2:
                    builder.setName(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c5 = 2;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setFrames(parseArray(jsonReader, new i()));
                    break;
                case 1:
                    builder.setName(jsonReader.nextString());
                    break;
                case 2:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static CrashlyticsReport.FilesPayload.File parseFile(JsonReader jsonReader) {
        CrashlyticsReport.FilesPayload.File.Builder builder = CrashlyticsReport.FilesPayload.File.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("filename")) {
                builder.setFilename(jsonReader.nextString());
            } else if (nextName.equals("contents")) {
                builder.setContents(Base64.decode(jsonReader.nextString(), 2));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.FilesPayload parseNdkPayload(JsonReader jsonReader) {
        CrashlyticsReport.FilesPayload.Builder builder = CrashlyticsReport.FilesPayload.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("files")) {
                builder.setFiles(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.e
                    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                    public final Object parse(JsonReader jsonReader2) {
                        CrashlyticsReport.FilesPayload.File parseFile;
                        parseFile = CrashlyticsReportJsonTransform.parseFile(jsonReader2);
                        return parseFile;
                    }
                }));
            } else if (nextName.equals("orgId")) {
                builder.setOrgId(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport.Session.OperatingSystem parseOs(JsonReader jsonReader) {
        CrashlyticsReport.Session.OperatingSystem.Builder builder = CrashlyticsReport.Session.OperatingSystem.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 1:
                    builder.setJailbroken(jsonReader.nextBoolean());
                    break;
                case 2:
                    builder.setVersion(jsonReader.nextString());
                    break;
                case 3:
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    public static CrashlyticsReport.Session.Event.Application.ProcessDetails parseProcessDetails(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder builder = CrashlyticsReport.Session.Event.Application.ProcessDetails.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case 110987:
                    if (nextName.equals("pid")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 1694598382:
                    if (nextName.equals("defaultProcess")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c5 = 3;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setPid(jsonReader.nextInt());
                    break;
                case 1:
                    builder.setProcessName(jsonReader.nextString());
                    break;
                case 2:
                    builder.setDefaultProcess(jsonReader.nextBoolean());
                    break;
                case 3:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0019. Please report as an issue. */
    private static CrashlyticsReport parseReport(JsonReader jsonReader) {
        CrashlyticsReport.Builder builder = CrashlyticsReport.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case -401988390:
                    if (nextName.equals("firebaseAuthenticationToken")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 1047652060:
                    if (nextName.equals("firebaseInstallationId")) {
                        c5 = '\b';
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c5 = '\t';
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c5 = '\n';
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c5 = 11;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setNdkPayload(parseNdkPayload(jsonReader));
                    break;
                case 1:
                    builder.setSdkVersion(jsonReader.nextString());
                    break;
                case 2:
                    builder.setAppQualitySessionId(jsonReader.nextString());
                    break;
                case 3:
                    builder.setAppExitInfo(parseAppExitInfo(jsonReader));
                    break;
                case 4:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 5:
                    builder.setFirebaseAuthenticationToken(jsonReader.nextString());
                    break;
                case 6:
                    builder.setGmpAppId(jsonReader.nextString());
                    break;
                case 7:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                case '\b':
                    builder.setFirebaseInstallationId(jsonReader.nextString());
                    break;
                case '\t':
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                case '\n':
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                case 11:
                    builder.setSession(parseSession(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant parseRolloutAssignmentRolloutVariant(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder builder = CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("variantId")) {
                builder.setVariantId(jsonReader.nextString());
            } else if (nextName.equals("rolloutId")) {
                builder.setRolloutId(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    private static CrashlyticsReport.Session parseSession(JsonReader jsonReader) {
        CrashlyticsReport.Session.Builder builder = CrashlyticsReport.Session.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c5 = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c5 = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c5 = 6;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c5 = 7;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c5 = '\b';
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c5 = '\t';
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c5 = '\n';
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c5 = 11;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    builder.setStartedAt(jsonReader.nextLong());
                    break;
                case 1:
                    builder.setAppQualitySessionId(jsonReader.nextString());
                    break;
                case 2:
                    builder.setIdentifierFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    builder.setEndedAt(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 4:
                    builder.setDevice(parseDevice(jsonReader));
                    break;
                case 5:
                    builder.setEvents(parseArray(jsonReader, new ObjectParser() { // from class: com.google.firebase.crashlytics.internal.model.serialization.d
                        @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
                        public final Object parse(JsonReader jsonReader2) {
                            CrashlyticsReport.Session.Event parseEvent;
                            parseEvent = CrashlyticsReportJsonTransform.parseEvent(jsonReader2);
                            return parseEvent;
                        }
                    }));
                    break;
                case 6:
                    builder.setOs(parseOs(jsonReader));
                    break;
                case 7:
                    builder.setApp(parseApp(jsonReader));
                    break;
                case '\b':
                    builder.setUser(parseUser(jsonReader));
                    break;
                case '\t':
                    builder.setGenerator(jsonReader.nextString());
                    break;
                case '\n':
                    builder.setCrashed(jsonReader.nextBoolean());
                    break;
                case 11:
                    builder.setGeneratorType(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.User parseUser(JsonReader jsonReader) {
        CrashlyticsReport.Session.User.Builder builder = CrashlyticsReport.Session.User.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals("identifier")) {
                builder.setIdentifier(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public CrashlyticsReport.Session.Event eventFromJson(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport.Session.Event parseEvent = parseEvent(jsonReader);
                jsonReader.close();
                return parseEvent;
            } finally {
            }
        } catch (IllegalStateException e5) {
            throw new IOException(e5);
        }
    }

    public String eventToJson(CrashlyticsReport.Session.Event event) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(event);
    }

    public CrashlyticsReport reportFromJson(String str) {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            try {
                CrashlyticsReport parseReport = parseReport(jsonReader);
                jsonReader.close();
                return parseReport;
            } finally {
            }
        } catch (IllegalStateException e5) {
            throw new IOException(e5);
        }
    }

    public String reportToJson(CrashlyticsReport crashlyticsReport) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(crashlyticsReport);
    }
}
