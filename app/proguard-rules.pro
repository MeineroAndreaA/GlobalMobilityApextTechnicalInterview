# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

 # With R8 full mode generic signatures are stripped for classes that are not
 # kept. Suspend functions are wrapped in continuations where the type argument
 # is used.
 -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

 # R8 full mode strips generic signatures from return types if not kept.
 -if interface * { @retrofit2.http.* public *** *(...); }
 -keep,allowoptimization,allowshrinking,allowobfuscation class <3>

 # With R8 full mode generic signatures are stripped for classes that are not kept.
 -keep,allowobfuscation,allowshrinking class retrofit2.Response

 # Mantener todas las clases y métodos utilizados por Gson
 -keep class com.google.gson.** { *; }
 -keepclassmembers enum com.google.gson.** { *; }
 -keepattributes Signature

 # Mantener clases de modelo y sus constructores
 -keep class com.aam.gmapextechnicalinterview.data.model.** { *; }
 -keepclassmembers class com.aam.gmapextechnicalinterview.data.model.** { <init>(...); }

 # Mantener constructores sin argumentos para clases de modelo
 -keepclassmembers class com.aam.gmapextechnicalinterview.data.model.** {
     <init>();
 }

 # Mantener clases de respuesta de Retrofit
 -keep class com.aam.gmapextechnicalinterview.data.model.response.** { *; }
 -keepclassmembers class com.aam.gmapextechnicalinterview.data.model.response.** { <init>(...); }

 # Mantener constructores sin argumentos para clases de respuesta de Retrofit
 -keepclassmembers class com.aam.gmapextechnicalinterview.data.model.response.** {
     <init>();
 }

 -dontwarn org.bouncycastle.jsse.BCSSLParameters
 -dontwarn org.bouncycastle.jsse.BCSSLSocket
 -dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
 -dontwarn org.conscrypt.Conscrypt$Version
 -dontwarn org.conscrypt.Conscrypt
 -dontwarn org.conscrypt.ConscryptHostnameVerifier
 -dontwarn org.openjsse.javax.net.ssl.SSLParameters
 -dontwarn org.openjsse.javax.net.ssl.SSLSocket
 -dontwarn org.openjsse.net.ssl.OpenJSSE