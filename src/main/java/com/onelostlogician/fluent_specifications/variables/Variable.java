package com.onelostlogician.fluent_specifications.variables;

import com.onelostlogician.fluent_specifications.core.CallSite;

public class Variable {
    public final CallSite callSite;
    public final VariableType variableType;

    public Variable(CallSite callSite, VariableType variableType) {
        this.callSite = callSite;
        this.variableType = variableType;
    }
}
