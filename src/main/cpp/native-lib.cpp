#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_vacpm2_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "♠ C++ Shit so I don't forget ♠";
    return env->NewStringUTF(hello.c_str());
}