package com.onelostlogician.fluent_specifications.core;

import com.onelostlogician.fluent_specifications.Specification;
import com.onelostlogician.fluent_specifications.exceptions.FluentSpecificationException;
import com.onelostlogician.fluent_specifications.proxy.CGLibMethodInterceptor;
import com.onelostlogician.fluent_specifications.variables.Variable;
import com.onelostlogician.fluent_specifications.variables.VariableType;
import net.sf.cglib.proxy.Enhancer;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

class CoreFluentSpecifications {
    private static final String INIT = "<init>";
    private static final String GIVEN = "given";
    private static final String WHEN = "when";
    private static final String THEN = "then";

    private static final Set<CallSite> ACCEPTABLE_FOR_ALL_CALL_SITES = new HashSet<>(asList(CallSite.INIT, CallSite.GIVEN, CallSite.THEN));
    private static final Set<CallSite> ACCEPTABLE_EXISTS_CALL_SITES = new HashSet<>(asList(CallSite.GIVEN, CallSite.THEN));
    private static final Set<CallSite> ACCEPTABLE_EXISTS_UNIQUE_CALL_SITES = new HashSet<>(asList(CallSite.GIVEN, CallSite.THEN));
    private static final Set<CallSite> ACCEPTABLE_SUT_CALL_SITES = new HashSet<>(asList(CallSite.WHEN));

    private static Map<UUID, Variable> variableMap = new HashMap<>();

    static <T> T forall(Class<T> clazz) {
        return createAndRegisterVariable(clazz, VariableType.FORALL, ACCEPTABLE_FOR_ALL_CALL_SITES,
                "Forall variable creation must be performed only in the initialisation, " +
                "given, or then methods of a FluentSpecifications Specification."
        );
    }

    static <T> T exists(Class<T> clazz) {
        return createAndRegisterVariable(clazz, VariableType.EXISTS, ACCEPTABLE_EXISTS_CALL_SITES,
                "Exists variable creation must be performed only in the given or then " +
                        "methods of a FluentSpecifications Specification."
        );
    }

    static <T> T existsUnique(Class<T> clazz) {
        return createAndRegisterVariable(clazz, VariableType.EXISTS_UNIQUE, ACCEPTABLE_EXISTS_UNIQUE_CALL_SITES,
                "ExistsUnique variable creation must be performed only in the given or then " +
                        "methods of a FluentSpecifications Specification."
        );
    }

    static <T> T systemUnderTest(Class<T> clazz) {
        return createAndRegisterVariable(clazz, VariableType.EXISTS, ACCEPTABLE_SUT_CALL_SITES,
                "System under test variable creation must be performed only in the when method " +
                        "of a FluentSpecifications Specification."
        );
    }

    static Map<UUID, Variable> getVariableMap() {
        return variableMap;
    }

    private static <T> T createVariable(Class<T> tClass, UUID variableId) {
        return (T) Enhancer.create(tClass, new CGLibMethodInterceptor(variableId));
    }

    private static <T> T createAndRegisterVariable(Class<T> clazz, VariableType variableType, Set<CallSite> acceptableCallSites, String message) {
        CallSite callSite = getCallSite();
        if (!acceptableCallSites.contains(callSite)) {
            throw new FluentSpecificationException(message);
        }
        UUID variableId = UUID.randomUUID();
        T variable = createVariable(clazz, variableId);
        variableMap.put(variableId, new Variable(callSite, variableType));
        return variable;
    }

    private static CallSite getCallSite() {
        List<StackTraceElement> stackTraceElements = asList(Thread.currentThread().getStackTrace());
        List<String> methods = stackTraceElements.stream()
                .filter(stackTraceElement -> {
                    try {
                        return asList(Class.forName(stackTraceElement.getClassName()).getInterfaces())
                                .contains(Specification.class);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(StackTraceElement::getMethodName)
                .collect(toList());

        if (methods.contains(INIT)) {
            return CallSite.INIT;
        }
        else if (methods.contains(GIVEN)) {
            return CallSite.GIVEN;
        }
        else if (methods.contains(WHEN)) {
            return CallSite.WHEN;
        }
        else if (methods.contains(THEN)) {
            return CallSite.THEN;
        }
        else {
            throw new RuntimeException("Variable creation must be performed only in the initialisation, " +
                    "given, when, or then methods of a FluentSpecifications Specification.");
        }
    }
}
