package com.onelostlogician.proofs_using_generics.proofs;

public interface UnpackProof<F extends Formula<F>, T> {
    <P extends Proof<F, P>> T unpacked(Proof<F,P> x);
}
