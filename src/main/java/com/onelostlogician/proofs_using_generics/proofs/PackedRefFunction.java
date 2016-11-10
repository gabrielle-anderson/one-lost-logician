package com.onelostlogician.proofs_using_generics.proofs;

interface PackedRefFunction<T> {
    public <A extends Formula<A>> RefFunction<?,T,A> function();
}
