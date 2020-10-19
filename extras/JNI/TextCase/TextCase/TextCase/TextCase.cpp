#include "pch.h"
#include <string>
#include <algorithm>
#include <jni.h>
#include "com_archsoft_TextCase.h"

using namespace std;

JNIEXPORT jstring JNICALL Java_com_archsoft_TextCase_upcase(JNIEnv* env, jobject obj, jstring text)
{
	// Step 1: Convert the JNI String (jstring) into C-String (char*)
	const char* str = env->GetStringUTFChars(text, nullptr);
	if (NULL == str) return nullptr;

	// Step 2: release resources
	env->ReleaseStringUTFChars(text, str);

	// Step 3: Create a C-Style string with upper case
	size_t size = strlen(str) + 1;
	char* out = new char[strlen(str) + 1];
	for (unsigned int i = 0; i < size; i++) {
		out[i] = toupper(str[i]);
	}

	// Step 4: Convert the C-string (char*) into JNI String (jstring) and return
	return env->NewStringUTF(out);
}

JNIEXPORT jstring JNICALL Java_com_archsoft_TextCase_lowcase(JNIEnv* env, jobject obj, jstring text)
{
	// Step 1: Convert the JNI String (jstring) into C-String (char*)
	const char* str = env->GetStringUTFChars(text, nullptr);
	if (NULL == str) return nullptr;

	// Step 2: release resources
	env->ReleaseStringUTFChars(text, str);

	// Step 3: Create a C-Style string with upper case
	size_t size = strlen(str) + 1;
	char* out = new char[strlen(str) + 1];
	for (unsigned int i = 0; i < size; i++) {
		out[i] = tolower(str[i]);
	}

	// Step 4: Convert the C-string (char*) into JNI String (jstring) and return
	return env->NewStringUTF(out);
}
