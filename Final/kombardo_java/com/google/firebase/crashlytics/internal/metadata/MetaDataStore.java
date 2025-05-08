package com.google.firebase.crashlytics.internal.metadata;

import com.adjust.sdk.Constants;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MetaDataStore {
    private static final String KEY_USER_ID = "userId";
    private static final Charset UTF_8 = Charset.forName(Constants.ENCODING);
    private final FileStore fileStore;

    public MetaDataStore(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    private static Map<String, String> jsonToKeysData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, valueOrNull(jSONObject, next));
        }
        return hashMap;
    }

    private static List<RolloutAssignment> jsonToRolloutsState(String str) {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            String string = jSONArray.getString(i5);
            try {
                arrayList.add(RolloutAssignment.create(string));
            } catch (Exception e5) {
                Logger.getLogger().w("Failed de-serializing rollouts state. " + string, e5);
            }
        }
        return arrayList;
    }

    private String jsonToUserId(String str) {
        return valueOrNull(new JSONObject(str), KEY_USER_ID);
    }

    private static String keysDataToJson(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static String rolloutsStateToJson(List<RolloutAssignment> list) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i5 = 0; i5 < list.size(); i5++) {
            try {
                jSONArray.put(new JSONObject(RolloutAssignment.ROLLOUT_ASSIGNMENT_JSON_ENCODER.encode(list.get(i5))));
            } catch (JSONException e5) {
                Logger.getLogger().w("Exception parsing rollout assignment!", e5);
            }
        }
        hashMap.put("rolloutsState", jSONArray);
        return new JSONObject(hashMap).toString();
    }

    private static void safeDeleteCorruptFile(File file) {
        if (file.exists() && file.delete()) {
            Logger.getLogger().i("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static String userIdToJson(String str) {
        return new JSONObject(str) { // from class: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.1
            final /* synthetic */ String val$userId;

            {
                this.val$userId = str;
                put(MetaDataStore.KEY_USER_ID, str);
            }
        }.toString();
    }

    private static String valueOrNull(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File getInternalKeysFileForSession(String str) {
        return this.fileStore.getSessionFile(str, "internal-keys");
    }

    public File getKeysFileForSession(String str) {
        return this.fileStore.getSessionFile(str, "keys");
    }

    public File getRolloutsStateForSession(String str) {
        return this.fileStore.getSessionFile(str, "rollouts-state");
    }

    public File getUserDataFileForSession(String str) {
        return this.fileStore.getSessionFile(str, "user-data");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    public Map<String, String> readKeyData(String str, boolean z5) {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e5;
        File internalKeysFileForSession = z5 ? getInternalKeysFileForSession(str) : getKeysFileForSession(str);
        if (!internalKeysFileForSession.exists() || internalKeysFileForSession.length() == 0) {
            safeDeleteCorruptFile(internalKeysFileForSession, "The file has a length of zero for session: " + str);
            return Collections.emptyMap();
        }
        try {
            try {
                fileInputStream = new FileInputStream(internalKeysFileForSession);
                try {
                    Map<String, String> jsonToKeysData = jsonToKeysData(CommonUtils.streamToString(fileInputStream));
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return jsonToKeysData;
                } catch (Exception e6) {
                    e5 = e6;
                    Logger.getLogger().w("Error deserializing user metadata.", e5);
                    safeDeleteCorruptFile(internalKeysFileForSession);
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.closeOrLog(r1, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e7) {
            fileInputStream = null;
            e5 = e7;
        } catch (Throwable th3) {
            ?? r12 = 0;
            th = th3;
            CommonUtils.closeOrLog(r12, "Failed to close user metadata file.");
            throw th;
        }
    }

    public List<RolloutAssignment> readRolloutsState(String str) {
        FileInputStream fileInputStream;
        File rolloutsStateForSession = getRolloutsStateForSession(str);
        if (!rolloutsStateForSession.exists() || rolloutsStateForSession.length() == 0) {
            safeDeleteCorruptFile(rolloutsStateForSession, "The file has a length of zero for session: " + str);
            return Collections.emptyList();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(rolloutsStateForSession);
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            List<RolloutAssignment> jsonToRolloutsState = jsonToRolloutsState(CommonUtils.streamToString(fileInputStream));
            Logger.getLogger().d("Loaded rollouts state:\n" + jsonToRolloutsState + "\nfor session " + str);
            CommonUtils.closeOrLog(fileInputStream, "Failed to close rollouts state file.");
            return jsonToRolloutsState;
        } catch (Exception e6) {
            e = e6;
            fileInputStream2 = fileInputStream;
            Logger.getLogger().w("Error deserializing rollouts state.", e);
            safeDeleteCorruptFile(rolloutsStateForSession);
            CommonUtils.closeOrLog(fileInputStream2, "Failed to close rollouts state file.");
            return Collections.emptyList();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            CommonUtils.closeOrLog(fileInputStream2, "Failed to close rollouts state file.");
            throw th;
        }
    }

    public String readUserId(String str) {
        FileInputStream fileInputStream;
        File userDataFileForSession = getUserDataFileForSession(str);
        FileInputStream fileInputStream2 = null;
        if (!userDataFileForSession.exists() || userDataFileForSession.length() == 0) {
            Logger.getLogger().d("No userId set for session " + str);
            safeDeleteCorruptFile(userDataFileForSession);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(userDataFileForSession);
            try {
                try {
                    String jsonToUserId = jsonToUserId(CommonUtils.streamToString(fileInputStream));
                    Logger.getLogger().d("Loaded userId " + jsonToUserId + " for session " + str);
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return jsonToUserId;
                } catch (Exception e5) {
                    e = e5;
                    Logger.getLogger().w("Error deserializing user metadata.", e);
                    safeDeleteCorruptFile(userDataFileForSession);
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void writeKeyData(String str, Map<String, String> map) {
        writeKeyData(str, map, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public void writeRolloutState(String str, List<RolloutAssignment> list) {
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e5;
        File rolloutsStateForSession = getRolloutsStateForSession(str);
        ?? isEmpty = list.isEmpty();
        if (isEmpty != 0) {
            safeDeleteCorruptFile(rolloutsStateForSession, "Rollout state is empty for session: " + str);
            return;
        }
        try {
            try {
                String rolloutsStateToJson = rolloutsStateToJson(list);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rolloutsStateForSession), UTF_8));
                try {
                    bufferedWriter.write(rolloutsStateToJson);
                    bufferedWriter.flush();
                    isEmpty = bufferedWriter;
                } catch (Exception e6) {
                    e5 = e6;
                    Logger.getLogger().w("Error serializing rollouts state.", e5);
                    safeDeleteCorruptFile(rolloutsStateForSession);
                    isEmpty = bufferedWriter;
                    CommonUtils.closeOrLog(isEmpty, "Failed to close rollouts state file.");
                }
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.closeOrLog(isEmpty, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e7) {
            bufferedWriter = null;
            e5 = e7;
        } catch (Throwable th3) {
            isEmpty = 0;
            th = th3;
            CommonUtils.closeOrLog(isEmpty, "Failed to close rollouts state file.");
            throw th;
        }
        CommonUtils.closeOrLog(isEmpty, "Failed to close rollouts state file.");
    }

    public void writeUserData(String str, String str2) {
        String userIdToJson;
        BufferedWriter bufferedWriter;
        File userDataFileForSession = getUserDataFileForSession(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                userIdToJson = userIdToJson(str2);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userDataFileForSession), UTF_8));
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(userIdToJson);
            bufferedWriter.flush();
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e6) {
            e = e6;
            bufferedWriter2 = bufferedWriter;
            Logger.getLogger().w("Error serializing user metadata.", e);
            CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void writeKeyData(String str, Map<String, String> map, boolean z5) {
        String keysDataToJson;
        BufferedWriter bufferedWriter;
        File internalKeysFileForSession = z5 ? getInternalKeysFileForSession(str) : getKeysFileForSession(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                keysDataToJson = keysDataToJson(map);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(internalKeysFileForSession), UTF_8));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e5) {
            e = e5;
        }
        try {
            bufferedWriter.write(keysDataToJson);
            bufferedWriter.flush();
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e6) {
            e = e6;
            bufferedWriter2 = bufferedWriter;
            Logger.getLogger().w("Error serializing key/value metadata.", e);
            safeDeleteCorruptFile(internalKeysFileForSession);
            CommonUtils.closeOrLog(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.closeOrLog(bufferedWriter2, "Failed to close key/value metadata file.");
            throw th;
        }
    }

    private static void safeDeleteCorruptFile(File file, String str) {
        if (file.exists() && file.delete()) {
            Logger.getLogger().i(String.format("Deleted corrupt file: %s\nReason: %s", file.getAbsolutePath(), str));
        }
    }
}
