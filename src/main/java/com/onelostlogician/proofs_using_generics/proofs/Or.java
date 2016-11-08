package com.onelostlogician.proofs_using_generics.proofs;

public abstract class Or<S extends Formula<S>, T extends Formula<T>> extends Formula<Or<S,T>> { }
