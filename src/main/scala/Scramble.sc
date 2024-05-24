val f = "katas"
val g = "steak"
f.filter(c => g.contains(c))
g.count(x => x == 'a')
def scramble(s1: String, s2: String) =
  s2.forall(x => s1.count(l => l == x) <= s2.count(l => l == x))
scramble("scriptjava", "javascript")
scramble("rkqodlw", "world")

f.filter(c => g.contains(c))

g.fold("")((x, y) => if(!f.contains(x)) s"$x" + y else "")
//
scramble("katas", "steak")

!List(2, 4, 6).forall(x => x % 2 == 0)

"scriptjava".count(x => x == 'j')

def scramble(s1: String, s2: String) =
  s2.forall(x => s1.count(l => l == x) >= s2.count(l => l == x))


//the actual way to do it (I didn't work this one out)
def scramble(s1: String, s2: String): Boolean = s2.diff(s1).isEmpty