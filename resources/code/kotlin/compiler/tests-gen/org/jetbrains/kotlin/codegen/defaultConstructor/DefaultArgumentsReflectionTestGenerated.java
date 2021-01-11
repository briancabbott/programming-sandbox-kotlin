/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.codegen.defaultConstructor;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/defaultArguments/reflection")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class DefaultArgumentsReflectionTestGenerated extends AbstractDefaultArgumentsReflectionTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    public void testAllFilesPresentInReflection() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("compiler/testData/codegen/defaultArguments/reflection"), Pattern.compile("^(.+)\\.kt$"), null, true);
    }

    @TestMetadata("classInClassObject.kt")
    public void testClassInClassObject() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/classInClassObject.kt");
    }

    @TestMetadata("classInObject.kt")
    public void testClassInObject() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/classInObject.kt");
    }

    @TestMetadata("classWithTwoDefaultArgs.kt")
    public void testClassWithTwoDefaultArgs() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/classWithTwoDefaultArgs.kt");
    }

    @TestMetadata("classWithVararg.kt")
    public void testClassWithVararg() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/classWithVararg.kt");
    }

    @TestMetadata("enum.kt")
    public void testEnum() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/enum.kt");
    }

    @TestMetadata("internalClass.kt")
    public void testInternalClass() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/internalClass.kt");
    }

    @TestMetadata("privateClass.kt")
    public void testPrivateClass() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/privateClass.kt");
    }

    @TestMetadata("privateConstructor.kt")
    public void testPrivateConstructor() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/privateConstructor.kt");
    }

    @TestMetadata("publicClass.kt")
    public void testPublicClass() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/publicClass.kt");
    }

    @TestMetadata("publicClassWoDefArgs.kt")
    public void testPublicClassWoDefArgs() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/publicClassWoDefArgs.kt");
    }

    @TestMetadata("publicInnerClass.kt")
    public void testPublicInnerClass() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/publicInnerClass.kt");
    }

    @TestMetadata("publicInnerClassInPrivateClass.kt")
    public void testPublicInnerClassInPrivateClass() throws Exception {
        runTest("compiler/testData/codegen/defaultArguments/reflection/publicInnerClassInPrivateClass.kt");
    }
}