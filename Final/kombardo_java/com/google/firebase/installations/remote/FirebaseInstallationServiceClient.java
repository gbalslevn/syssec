package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FirebaseInstallationServiceClient {
    private static final String ACCEPT_HEADER_KEY = "Accept";
    private static final String API_KEY_HEADER = "x-goog-api-key";
    private static final String CACHE_CONTROL_DIRECTIVE = "no-cache";
    private static final String CACHE_CONTROL_HEADER_KEY = "Cache-Control";
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
    private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
    private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
    private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
    private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
    private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
    private static final String FIS_TAG = "Firebase-Installations";
    private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final String HEART_BEAT_HEADER = "x-firebase-client";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final int MAX_RETRIES = 1;
    private static final int NETWORK_TIMEOUT_MILLIS = 10000;
    private static final String SDK_VERSION_PREFIX = "a:";
    private static final int TRAFFIC_STATS_CREATE_INSTALLATION_TAG = 32769;
    private static final int TRAFFIC_STATS_DELETE_INSTALLATION_TAG = 32770;
    private static final int TRAFFIC_STATS_FIREBASE_INSTALLATIONS_TAG = 32768;
    private static final int TRAFFIC_STATS_GENERATE_AUTH_TOKEN_TAG = 32771;
    private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
    private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
    private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
    private final Context context;
    private final Provider<HeartBeatController> heartBeatProvider;
    private final RequestLimiter requestLimiter = new RequestLimiter();
    private boolean shouldServerErrorRetry;
    private static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
    private static final Charset UTF_8 = Charset.forName(Constants.ENCODING);

    public FirebaseInstallationServiceClient(Context context, Provider<HeartBeatController> provider) {
        this.context = context;
        this.heartBeatProvider = provider;
    }

    private static String availableFirebaseOptions(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            str4 = BuildConfig.FLAVOR;
        } else {
            str4 = ", " + str;
        }
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", str2, str3, str4);
    }

    private static JSONObject buildCreateFirebaseInstallationRequestBody(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", FIREBASE_INSTALLATION_AUTH_VERSION);
            jSONObject.put("sdkVersion", "a:18.0.0");
            return jSONObject;
        } catch (JSONException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static JSONObject buildGenerateAuthTokenRequestBody() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:18.0.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private String getFingerprintHashForPackage() {
        try {
            Context context = this.context;
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            if (packageCertificateHashBytes != null) {
                return Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.context.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e5) {
            Log.e("ContentValues", "No such package: " + this.context.getPackageName(), e5);
            return null;
        }
    }

    private URL getFullyQualifiedRequestUri(String str) {
        try {
            return new URL(String.format("https://%s/%s/%s", FIREBASE_INSTALLATIONS_API_DOMAIN, FIREBASE_INSTALLATIONS_API_VERSION, str));
        } catch (MalformedURLException e5) {
            throw new FirebaseInstallationsException(e5.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    private static byte[] getJsonBytes(JSONObject jSONObject) {
        return jSONObject.toString().getBytes(Constants.ENCODING);
    }

    private static boolean isSuccessfulResponseCode(int i5) {
        return i5 >= 200 && i5 < 300;
    }

    private static void logBadConfigError() {
        Log.e(FIS_TAG, "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    private static void logFisCommunicationError(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        String readErrorResponse = readErrorResponse(httpURLConnection);
        if (TextUtils.isEmpty(readErrorResponse)) {
            return;
        }
        Log.w(FIS_TAG, readErrorResponse);
        Log.w(FIS_TAG, availableFirebaseOptions(str, str2, str3));
    }

    private HttpURLConnection openHttpURLConnection(URL url, String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(NETWORK_TIMEOUT_MILLIS);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(NETWORK_TIMEOUT_MILLIS);
            httpURLConnection.addRequestProperty(CONTENT_TYPE_HEADER_KEY, JSON_CONTENT_TYPE);
            httpURLConnection.addRequestProperty(ACCEPT_HEADER_KEY, JSON_CONTENT_TYPE);
            httpURLConnection.addRequestProperty(CONTENT_ENCODING_HEADER_KEY, GZIP_CONTENT_ENCODING);
            httpURLConnection.addRequestProperty(CACHE_CONTROL_HEADER_KEY, CACHE_CONTROL_DIRECTIVE);
            httpURLConnection.addRequestProperty(X_ANDROID_PACKAGE_HEADER_KEY, this.context.getPackageName());
            HeartBeatController heartBeatController = this.heartBeatProvider.get();
            if (heartBeatController != null) {
                try {
                    httpURLConnection.addRequestProperty(HEART_BEAT_HEADER, (String) Tasks.await(heartBeatController.getHeartBeatsHeader()));
                } catch (InterruptedException e5) {
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e5);
                } catch (ExecutionException e6) {
                    Log.w("ContentValues", "Failed to get heartbeats header", e6);
                }
            }
            httpURLConnection.addRequestProperty(X_ANDROID_CERT_HEADER_KEY, getFingerprintHashForPackage());
            httpURLConnection.addRequestProperty(API_KEY_HEADER, str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
    }

    static long parseTokenExpirationTimestamp(String str) {
        Preconditions.checkArgument(EXPIRATION_TIMESTAMP_PATTERN.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    private InstallationResponse readCreateResponse(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, UTF_8));
        TokenResult.Builder builder = TokenResult.builder();
        InstallationResponse.Builder builder2 = InstallationResponse.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                builder2.setUri(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                builder2.setFid(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                builder2.setRefreshToken(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals("token")) {
                        builder.setToken(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        builder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                builder2.setAuthToken(builder.build());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return builder2.setResponseCode(InstallationResponse.ResponseCode.OK).build();
    }

    private static String readErrorResponse(HttpURLConnection httpURLConnection) {
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, UTF_8));
        try {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                String format = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return format;
            } catch (IOException unused2) {
                return null;
            }
        } catch (IOException unused3) {
            bufferedReader.close();
            return null;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused4) {
            }
            throw th;
        }
    }

    private TokenResult readGenerateAuthTokenResponse(HttpURLConnection httpURLConnection) {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, UTF_8));
        TokenResult.Builder builder = TokenResult.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
                builder.setToken(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                builder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return builder.setResponseCode(TokenResult.ResponseCode.OK).build();
    }

    private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, String str, String str2) {
        writeRequestBodyToOutputStream(httpURLConnection, getJsonBytes(buildCreateFirebaseInstallationRequestBody(str, str2)));
    }

    private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) {
        writeRequestBodyToOutputStream(httpURLConnection, getJsonBytes(buildGenerateAuthTokenRequestBody()));
    }

    private static void writeRequestBodyToOutputStream(URLConnection uRLConnection, byte[] bArr) {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public InstallationResponse createFirebaseInstallation(String str, String str2, String str3, String str4, String str5) {
        int responseCode;
        InstallationResponse readCreateResponse;
        if (!this.requestLimiter.isRequestAllowed()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        URL fullyQualifiedRequestUri = getFullyQualifiedRequestUri(String.format(CREATE_REQUEST_RESOURCE_NAME_FORMAT, str3));
        for (int i5 = 0; i5 <= 1; i5++) {
            TrafficStats.setThreadStatsTag(TRAFFIC_STATS_CREATE_INSTALLATION_TAG);
            HttpURLConnection openHttpURLConnection = openHttpURLConnection(fullyQualifiedRequestUri, str);
            try {
                try {
                    openHttpURLConnection.setRequestMethod("POST");
                    openHttpURLConnection.setDoOutput(true);
                    if (str5 != null) {
                        openHttpURLConnection.addRequestProperty(X_ANDROID_IID_MIGRATION_KEY, str5);
                    }
                    writeFIDCreateRequestBodyToOutputStream(openHttpURLConnection, str2, str4);
                    responseCode = openHttpURLConnection.getResponseCode();
                    this.requestLimiter.setNextRequestTime(responseCode);
                } catch (IOException | AssertionError unused) {
                }
                if (isSuccessfulResponseCode(responseCode)) {
                    readCreateResponse = readCreateResponse(openHttpURLConnection);
                } else {
                    logFisCommunicationError(openHttpURLConnection, str4, str, str3);
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        logBadConfigError();
                        readCreateResponse = InstallationResponse.builder().setResponseCode(InstallationResponse.ResponseCode.BAD_CONFIG).build();
                    }
                    openHttpURLConnection.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
                openHttpURLConnection.disconnect();
                TrafficStats.clearThreadStatsTag();
                return readCreateResponse;
            } catch (Throwable th) {
                openHttpURLConnection.disconnect();
                TrafficStats.clearThreadStatsTag();
                throw th;
            }
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public TokenResult generateAuthToken(String str, String str2, String str3, String str4) {
        int responseCode;
        TokenResult readGenerateAuthTokenResponse;
        if (!this.requestLimiter.isRequestAllowed()) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        URL fullyQualifiedRequestUri = getFullyQualifiedRequestUri(String.format(GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT, str3, str2));
        for (int i5 = 0; i5 <= 1; i5++) {
            TrafficStats.setThreadStatsTag(TRAFFIC_STATS_GENERATE_AUTH_TOKEN_TAG);
            HttpURLConnection openHttpURLConnection = openHttpURLConnection(fullyQualifiedRequestUri, str);
            try {
                try {
                    openHttpURLConnection.setRequestMethod("POST");
                    openHttpURLConnection.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    openHttpURLConnection.setDoOutput(true);
                    writeGenerateAuthTokenRequestBodyToOutputStream(openHttpURLConnection);
                    responseCode = openHttpURLConnection.getResponseCode();
                    this.requestLimiter.setNextRequestTime(responseCode);
                } finally {
                    openHttpURLConnection.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IOException | AssertionError unused) {
            }
            if (isSuccessfulResponseCode(responseCode)) {
                readGenerateAuthTokenResponse = readGenerateAuthTokenResponse(openHttpURLConnection);
            } else {
                logFisCommunicationError(openHttpURLConnection, null, str, str3);
                if (responseCode == 401 || responseCode == 404) {
                    readGenerateAuthTokenResponse = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.AUTH_ERROR).build();
                } else {
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    }
                    if (responseCode < 500 || responseCode >= 600) {
                        logBadConfigError();
                        readGenerateAuthTokenResponse = TokenResult.builder().setResponseCode(TokenResult.ResponseCode.BAD_CONFIG).build();
                    }
                }
            }
            return readGenerateAuthTokenResponse;
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }
}
