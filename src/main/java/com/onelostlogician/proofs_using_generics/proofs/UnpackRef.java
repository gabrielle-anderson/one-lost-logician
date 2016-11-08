package com.onelostlogician.proofs_using_generics.proofs;

public interface UnpackRef<S, T> {
    <A extends Formula<A>> T unpacked(Ref<S, A> x);
}
