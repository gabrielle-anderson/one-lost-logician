package com.onelostlogician.proofs_using_generics.proofs;

interface RefFunction<S,T,A> {
    public T apply(Ref<S,A> ref);
}
