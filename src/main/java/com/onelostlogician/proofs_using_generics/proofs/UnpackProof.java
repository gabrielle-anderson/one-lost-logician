package com.onelostlogician.proofs_using_generics.proofs;

public interface UnpackProof<T> {
    <F extends Formula<F>, P extends Proof<F, P>> T unpacked(Proof<F,P> x);
}
