package com.onelostlogician.proofs_using_generics.proofs;

public abstract class Ref<S,A extends Formula<A>> {
    public static <S> Ref<S,?> build() { return new RefImpl<>(); }

    public abstract Proof<A,?> set(S x);

    public abstract <P extends Proof<A,P>> S get();

    public <T> T unpack(UnpackRef<S, T> u) {
        return u.unpacked(this);
    }
}