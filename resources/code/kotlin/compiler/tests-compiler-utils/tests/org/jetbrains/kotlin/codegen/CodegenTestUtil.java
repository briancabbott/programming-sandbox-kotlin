/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.codegen;

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.util.io.FileUtil;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.cli.jvm.compiler.KotlinCoreEnvironment;
import org.jetbrains.kotlin.codegen.forTestCompile.ForTestCompileRuntime;
import org.jetbrains.kotlin.test.Assertions;
import org.jetbrains.kotlin.test.JvmCompilationUtils;
import org.jetbrains.kotlin.test.KtAssert;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.utils.ExceptionUtilsKt;
import org.jetbrains.kotlin.utils.StringsKt;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodegenTestUtil {
    private CodegenTestUtil() {
    }

    @NotNull
    public static ClassFileFactory generateFiles(@NotNull KotlinCoreEnvironment environment, @NotNull CodegenTestFiles files) {
        return GenerationUtils.compileFiles(files.getPsiFiles(), environment).getFactory();
    }

    public static void assertThrows(
            @NotNull Method foo, @NotNull Class<? extends Throwable> exceptionClass, @Nullable Object instance, @NotNull Object... args
    ) throws IllegalAccessException {
        boolean caught = false;
        try {
            foo.invoke(instance, args);
        }
        catch (InvocationTargetException ex) {
            caught = exceptionClass.isInstance(ex.getTargetException());
        }
        KtAssert.assertTrue(String.format("Exception of class %s must be thrown", exceptionClass.getName()), caught);
    }

    @NotNull
    public static Method findDeclaredMethodByName(@NotNull Class<?> aClass, @NotNull String name) {
        Method result = findDeclaredMethodByNameOrNull(aClass, name);
        if (result == null) {
            throw new AssertionError("Method " + name + " is not found in " + aClass);
        }
        return result;
    }

    public static Method findDeclaredMethodByNameOrNull(@NotNull Class<?> aClass, @NotNull String name) {
        for (Method method : aClass.getDeclaredMethods()) {
            if (method.getName().equals(name)) {
                return method;
            }
        }
        return null;
    }

    @NotNull
    public static File compileJava(
            @NotNull List<String> fileNames,
            @NotNull List<String> additionalClasspath,
            @NotNull List<String> additionalOptions,
            @NotNull Assertions assertions
    ) {
        try {
            File directory = KtTestUtil.tmpDir("java-classes");
            compileJava(fileNames, additionalClasspath, additionalOptions, directory, assertions);
            return directory;
        }
        catch (IOException e) {
            throw ExceptionUtilsKt.rethrow(e);
        }
    }

    public static void compileJava(
            @NotNull List<String> fileNames,
            @NotNull List<String> additionalClasspath,
            @NotNull List<String> additionalOptions,
            @NotNull File outDirectory,
            @NotNull Assertions assertions
    ) {
        try {
            List<String> options = prepareJavacOptions(additionalClasspath, additionalOptions, outDirectory);
            JvmCompilationUtils.compileJavaFiles(CollectionsKt.map(fileNames, File::new), options, assertions);
        }
        catch (IOException e) {
            throw ExceptionUtilsKt.rethrow(e);
        }
    }

    @NotNull
    public static List<String> prepareJavacOptions(
            @NotNull List<String> additionalClasspath,
            @NotNull List<String> additionalOptions,
            @NotNull File outDirectory
    ) {
        List<String> classpath = new ArrayList<>();
        classpath.add(ForTestCompileRuntime.runtimeJarForTests().getPath());
        classpath.add(ForTestCompileRuntime.reflectJarForTests().getPath());
        classpath.add(KtTestUtil.getAnnotationsJar().getPath());
        classpath.addAll(additionalClasspath);

        List<String> options = new ArrayList<>(Arrays.asList(
                "-classpath", StringsKt.join(classpath, File.pathSeparator),
                "-d", outDirectory.getPath()
        ));
        options.addAll(additionalOptions);
        return options;
    }


    @NotNull
    public static Method findTheOnlyMethod(@NotNull Class<?> aClass) {
        Method r = null;
        for (Method method : aClass.getMethods()) {
            if (method.getDeclaringClass().equals(Object.class)) {
                continue;
            }

            if (r != null) {
                throw new AssertionError("More than one public method in class " + aClass);
            }

            r = method;
        }
        if (r == null) {
            throw new AssertionError("No public methods in class " + aClass);
        }
        return r;
    }

    @Nullable
    public static Object getAnnotationAttribute(@NotNull Object annotation, @NotNull String name) {
        try {
            return annotation.getClass().getMethod(name).invoke(annotation);
        }
        catch (Exception e) {
            throw ExceptionUtilsKt.rethrow(e);
        }
    }

    @NotNull
    public static List<String> findJavaSourcesInDirectory(@NotNull File directory) {
        List<String> javaFilePaths = new ArrayList<>(1);

        FileUtil.processFilesRecursively(directory, file -> {
            if (file.isFile() && FilesKt.getExtension(file).equals(JavaFileType.DEFAULT_EXTENSION)) {
                javaFilePaths.add(file.getPath());
            }
            return true;
        });

        return javaFilePaths;
    }
}