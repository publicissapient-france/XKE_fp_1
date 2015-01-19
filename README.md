#Programmation fonctionnelle: Session 1

##Objectif
Nous allons ensemble découvrir la programmation fonctionnelle à travers une série d'exercice.
Nous allons voir les patterns de base et les contraintes associées.

À la fin de cette première session, vous aurez vu ce qu'est un foncteur (functor).

##Setup
Vous pouvez coder en Java ou en Scala. Il n'y a pas de librarie nécessaire.

##Contraintes

* Toute variable doit être 'final' (l'utilisation de var est interdite en Scala). De ce faite, faire une boucle est interdit car elle nécessite un compteur muable.
* L'héritage de classe est interdit, seulement l'implémentation (les default methods en Java 8 sont autorisées si elles sont finals).
* L'utilisation d'une autre classe que Int, Double, Boolean, String, Char est interdite.
* L'utilisation des exceptions est interdite.


##Partie 1: La liste

Une des structures élémentaires de la programmation fonctionnelle est la liste simplement chaînée.
La liste est formée d'élément qui sont liés à leur successeur. Un élément d'une liste est soit:
* l'élément vide (type nommé Nil)
* un élément non vide (head de type Cons) + la liste des éléments restants (tail)

Votre liste doit être polymorphique (avec un type générique). On attend donc une signature de type:

	//en Scala
	trait List[A] ...

	//En java
	public interface List<A> {...}

###Exercice 1
À vos claviers, coder donc cette structure. Nous devons pouvoir créer des listes à la fin de cette étape.

###Exercice 2
Implémenter la méthode `tail` sur la liste. Vous remarquerez que l'accès se fait en temps constant!

###Exercice 3
Généraliser la méthode `tail` dans une méthode `drop (n:Int)` qui retourne une liste avec `n` head en moins.

###Exercice 4
Implémenter la méthode `init` qui retourne une nouvelle liste sans son dernier élément.

###Exercice 5
Implémenter la fonction `sum` qui a la signature suivante:
	
	//En Scala
	def sum(ints: List[Int]): Int

	//En Java
	public static Integer sum(List<Integer> ints)



###Exercice 6
Implémenter la fonction `product` qui a la signature suivante:

	//En Scala
	def product(ints: List[Int]): Int

	//En Java
	public static Integer product(List<Integer> ints)


Il est évident que ces deux méthodes se ressemblent fortement. 
Comme vous avez suivi le pattern Red=>Green=>Refactor, il est temps de refactorer ce code.

###Exercice 7
Généraliser `sum` et `product` par une méthode `foldRight` qui a la signature suivante

	//En Scala
	def foldRight[B](z: B)(f: (A, B) => B): B

	//En Java
	public <B> B foldRight(B z, BiFunction<A,B,B> f)

###Exercice 8
En utilisation foldRight, implémenter la méthode `length` sur `List`.

Vous remarquerez que foldRight n'est pas `tail recursive`. 
Cela veut dire que dans sa récursivité, la dernière ligne n'est pas un appel récursif.
Sinon, le compilateur peut optimiser et transformer la récursion en `while`!
Cela évite d'exploser la pile d'appel pour des listes de grande taille.

###Exercice 9
Écrire `foldLeft` qui est `tail-recursive`:

	//En Scala
	def foldLeft[B](z: B)(f: (B, A) => B): B

	//En Java
	public <B> B foldLeft(B z, BiFunction<B,A,B> f)	

###Exercice 10
Réimplementer `sum`, `product` et `length` avec `foldLeft`.

###Exercice 11
Implémenter une fonction qui prend en entrée une liste d'entiers et retourne une nouvelle liste avec chaque entrée incrémentée de 1

	//En Scala
	def addOne(list: List[Int]): List[Int]

	//En Java
	public static List<Integer> addOne (List<Integer> list)

###Exercice 12
Implémenter une fonction qui prend en entrée une liste d'entiers et retourne une nouvelle liste avec sa représentation en String

	//En Scala
	def tostring(list: List[Int]): List[Int]

	//En Java
	public static List<Integer> tostring (List<Integer> list)

###Exercice 13
Généraliser `addOne` et `tostring` avec méthode `map`

	//En Scala
	def map[B](f: (A=>B)):List[B]

	//En Java
	public <B> List<B> (Function<A,B> f)

###Exercice 14
Écrire une méthode `filter` qui permet de filter le contenu d'une liste

	//En Scala
	def map(p: (A=>Boolean)):List[A]

	//En Java
	public List<A> (Predicate<A> p)

###Exercice 15
Écrire une méthode `flatMap` qui fonctionne comme `map` mais concatene les résultats.

	//En Scala
	def flatMap[B](f: (A => List[B])): List[B]

	//En Java
	public <B> List<B> flatMap(f: Function<A,B>)

###Exercice 16
Écrire une fonction qui prend deux listes et les concatenenes en utilisant `flatMap`

	//En Scala
	def join(others: List[A]):List[A]

	//En Java
	public List<A> join(List<A> others)

##Partie 2 : Option
###Créer la classe option
Une option est un type qui contient 0 ou 1 valeur.

* l'élément vide (type nommé None)
* un élément non vide (type nommé Some)

	//En Scala
	trait Option[+A] {
 		def map[B](f: A => B): Option[B]
 		def flatMap[B](f: A => Option[B]): Option[B]
 		def getOrElse[B >: A](default: => B): B
 		def orElse[B >: A](ob: => Option[B]): Option[B]
 		def filter(f: A => Boolean): Option[A]
	}

	//En Java
	public interface Option<A>{
		Option[B] map<B>(Function<A,B> f) 
 		Option[B] flatMap<B>(Function<A,Option<B>> f)
 		A getOrElse(A default)
 		Option[A] orElse(Option[B]:ob)
 		Option[A] filter(Predicate<A> p)
	}