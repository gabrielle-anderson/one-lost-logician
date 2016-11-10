package com.onelostlogician.proofs_using_generics.proofs;

interface RefFunction<S,T,A extends Formula<A>> {
    public T apply(Ref<S,A> ref);
}
