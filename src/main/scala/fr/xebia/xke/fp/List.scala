package fr.xebia.xke.fp


trait List[A]

class Cons[A](elt: A, tail:List[A]) extends List[A]

class Nil[A] extends List[A]