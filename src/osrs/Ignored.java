package osrs;

public class Ignored extends User {
   static String field4610;
   int id;

   Ignored() {
   }

   int compareTo_ignored(Ignored var1) {
      return this.id - var1.id;
   }

   public int compareTo_user(User var1) {
      return this.compareTo_ignored((Ignored)var1);
   }

   public int compareTo(Object var1) {
      return this.compareTo_ignored((Ignored)var1);
   }
}
