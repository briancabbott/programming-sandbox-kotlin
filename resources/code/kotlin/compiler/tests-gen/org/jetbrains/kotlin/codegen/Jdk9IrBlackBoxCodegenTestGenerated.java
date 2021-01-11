/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.codegen;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/java9/box")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class Jdk9IrBlackBoxCodegenTestGenerated extends AbstractJdk9IrBlackBoxCodegenTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, TargetBackend.JVM_IR, testDataFilePath);
    }

    public void testAllFilesPresentInBox() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/java9/box"), Pattern.compile("^(.+)\\.kt$"), null, TargetBackend.JVM_IR, true);
    }

    @TestMetadata("concatDynamic.kt")
    public void testConcatDynamic() throws Exception {
        runTest("compiler/testData/codegen/java9/box/concatDynamic.kt");
    }

    @TestMetadata("concatDynamic200.kt")
    public void testConcatDynamic200() throws Exception {
        runTest("compiler/testData/codegen/java9/box/concatDynamic200.kt");
    }

    @TestMetadata("concatDynamic201.kt")
    public void testConcatDynamic201() throws Exception {
        runTest("compiler/testData/codegen/java9/box/concatDynamic201.kt");
    }

    @TestMetadata("concatDynamicIndy200.kt")
    public void testConcatDynamicIndy200() throws Exception {
        runTest("compiler/testData/codegen/java9/box/concatDynamicIndy200.kt");
    }

    @TestMetadata("concatDynamicIndy201.kt")
    public void testConcatDynamicIndy201() throws Exception {
        runTest("compiler/testData/codegen/java9/box/concatDynamicIndy201.kt");
    }

    @TestMetadata("concatDynamicInlineClasses.kt")
    public void testConcatDynamicInlineClasses() throws Exception {
        runTest("compiler/testData/codegen/java9/box/concatDynamicInlineClasses.kt");
    }

    @TestMetadata("concatDynamicWithInline.kt")
    public void testConcatDynamicWithInline() throws Exception {
        runTest("compiler/testData/codegen/java9/box/concatDynamicWithInline.kt");
    }

    @TestMetadata("kt36984.kt")
    public void testKt36984() throws Exception {
        runTest("compiler/testData/codegen/java9/box/kt36984.kt");
    }

    @TestMetadata("varHandle.kt")
    public void testVarHandle() throws Exception {
        runTest("compiler/testData/codegen/java9/box/varHandle.kt");
    }
}