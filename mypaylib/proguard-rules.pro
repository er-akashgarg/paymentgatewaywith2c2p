-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-keepattributes Annotation,EnclosingMethod,SourceFile,LineNumberTable,Exceptions,Deprecated

-dontwarn android.support.**
-dontwarn com.google.**

-dontwarn org.spongycastle.x509.util.LDAPStoreHelper
-dontwarn org.spongycastle.jce.provider.X509LDAPCertStoreSpi

-keep public class org.spongycastle.** {*;}
-keep class java.security.** {*;}
-keep class javax.crypto.** {*;}

#2C2P PGW Library
-dontwarn com.ccpp.my2c2psdk.**
-keep class com.ccpp.my2c2psdk.cores.** {*;}
-dontwarn com.samsung.**
-dontwarn com.alipay.**

-keep class com.squareup.picasso.**{ *; }
-dontwarn com.squareup.picasso.**

# okhttp3
-dontwarn okio.**
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-keepclassmembers class * implements javax.net.ssl.SSLSocketFactory {
    private final javax.net.ssl.SSLSocketFactory delegate;
}
