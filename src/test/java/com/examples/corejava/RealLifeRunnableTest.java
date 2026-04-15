package com.examples.corejava;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.SAME_THREAD)
class RealLifeRunnableTest {
    private static final List<String> REAL_LIFE_EXAMPLES = List.of(
            "com.examples.reallife.algorithms.BacktrackingExample",
            "com.examples.reallife.algorithms.BfsGridExample",
            "com.examples.reallife.algorithms.BinarySearchExample",
            "com.examples.reallife.algorithms.LinearScanExample",
            "com.examples.reallife.algorithms.MergeIntervalsExample",
            "com.examples.reallife.algorithms.NestedLoopsExample",
            "com.examples.reallife.algorithms.RecursionExample",
            "com.examples.reallife.algorithms.SlidingWindowExample",
            "com.examples.reallife.algorithms.TopKFrequentExample",
            "com.examples.reallife.algorithms.TwoSumExample",
            "com.examples.reallife.algorithms.ValidParenthesesExample",
            "com.examples.reallife.collections.ArrayListVsLinkedListExample",
            "com.examples.reallife.collections.CollectionManipulationExample",
            "com.examples.reallife.collections.CollectionsOverviewExample",
            "com.examples.reallife.collections.ConcurrentHashMapExample",
            "com.examples.reallife.collections.ConversionExample",
            "com.examples.reallife.collections.FrequencyCountExample",
            "com.examples.reallife.collections.GroupingExample",
            "com.examples.reallife.collections.ListSetMapComparisonExample",
            "com.examples.reallife.collections.MapExamples",
            "com.examples.reallife.collections.PriorityQueueExample",
            "com.examples.reallife.collections.RemoveDuplicatesExample",
            "com.examples.reallife.collections.SafeRemovalExample",
            "com.examples.reallife.collections.SetExamples",
            "com.examples.reallife.complexity.ConstantSpaceExample",
            "com.examples.reallife.complexity.ConstantTimeExample",
            "com.examples.reallife.complexity.LinearSpaceExample",
            "com.examples.reallife.complexity.LinearTimeExample",
            "com.examples.reallife.complexity.LogarithmicTimeExample",
            "com.examples.reallife.complexity.NLogNExample",
            "com.examples.reallife.complexity.PermutationExample",
            "com.examples.reallife.complexity.QuadraticTimeExample",
            "com.examples.reallife.complexity.SubsetExample",
            "com.examples.reallife.concurrency.AtomicMapOperationsExample",
            "com.examples.reallife.concurrency.ConcurrentHashMapExample",
            "com.examples.reallife.concurrency.HashMapThreadSafetyExample",
            "com.examples.reallife.concurrency.StartVsRunExample",
            "com.examples.reallife.concurrency.SynchronizedCounterExample",
            "com.examples.reallife.concurrency.ThreadExample",
            "com.examples.reallife.exceptions.CheckedVsUncheckedExceptionExample",
            "com.examples.reallife.exceptions.FinalFinallyFinalizeExample",
            "com.examples.reallife.gc.GarbageCollectionExample",
            "com.examples.reallife.hashing.CustomObjectHashExample",
            "com.examples.reallife.hashing.EqualsHashCodeExample",
            "com.examples.reallife.hashing.HashMapExample",
            "com.examples.reallife.oop.CompositionVsInheritanceExample",
            "com.examples.reallife.oop.EncapsulationExample",
            "com.examples.reallife.oop.InheritancePolymorphismExample",
            "com.examples.reallife.oop.InterfaceVsAbstractExample",
            "com.examples.reallife.oop.LooseCouplingCohesionExample",
            "com.examples.reallife.oop.OverloadOverrideExample",
            "com.examples.reallife.optional.OptionalExample",
            "com.examples.reallife.sorting.ComparableExample",
            "com.examples.reallife.sorting.ComparableVsComparatorExample",
            "com.examples.reallife.sorting.ComparatorExample",
            "com.examples.reallife.sorting.PrimitiveVsObjectSortingExample",
            "com.examples.reallife.sorting.SortingExamples",
            "com.examples.reallife.streams.LambdaExample",
            "com.examples.reallife.streams.StreamsVsLoopsExample",
            "com.examples.reallife.strings.StringBuilderExample",
            "com.examples.reallife.strings.StringImmutabilityExample"
    );

    @TestFactory
    Stream<DynamicTest> everyRealLifeExampleRunsAndPrintsScenarioHeader() {
        return REAL_LIFE_EXAMPLES.stream()
                .map(className -> DynamicTest.dynamicTest(className, () -> {
                    String output = assertDoesNotThrow(() -> invokeRunAndCaptureOutput(className));
                    assertTrue(output.contains("Real-life e-commerce example:"),
                            () -> "Expected real-life scenario output from " + className);
                }));
    }

    private static String invokeRunAndCaptureOutput(String className) throws Exception {
        Class<?> exampleClass = Class.forName(className);
        Method run = exampleClass.getMethod("run");
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream capture = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setOut(capture);
            run.invoke(null);
        } finally {
            System.setOut(originalOut);
        }

        return output.toString(StandardCharsets.UTF_8);
    }
}
