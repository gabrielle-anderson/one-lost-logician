package com.onelostlogician.proofs_using_generics.proofs;

interface PackedRefFunction<T> {
    public <A> RefFunction<?,T,A> function();
}
