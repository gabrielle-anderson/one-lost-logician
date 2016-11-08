package com.onelostlogician.proofs_using_generics.proofs;

//public abstract class Ref<S,A> {
//
//    static public <T> T build(PackedRefFunction<T> p) {
//        return building(p.function());
//    }
//
//    static private<S,T> T building(RefFunction<S,T,True> p) {
//        return p.apply(new RefImpl<>());
//    }
//
//    public <T> T unpack(UnpackRef<S,A,T> u) {
//        return u.<A> unpacked(this); }
//}
public abstract class Ref<S,A extends Formula<A>> {
    public abstract Proof<A,?> set(S x);
    public abstract S get();
    public static <S> Ref<S,?> build() { return new RefImpl<>(); }
    public <T> T unpack(UnpackRef<S, T> u) {
        return u.unpacked(this); }
}