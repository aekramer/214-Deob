package osrs;

public class class436 {
   float field4671;
   float field4672;
   float field4673;

   static {
      new class436(0.0F, 0.0F, 0.0F);
      new class436(1.0F, 1.0F, 1.0F);
      new class436(1.0F, 0.0F, 0.0F);
      new class436(0.0F, 1.0F, 0.0F);
      new class436(0.0F, 0.0F, 1.0F);
      AbstractSocket.method7950(100);
   }

   class436(float var1, float var2, float var3) {
      this.field4671 = var1;
      this.field4672 = var2;
      this.field4673 = var3;
   }

   final float method8058() {
      return (float)Math.sqrt((double)(this.field4672 * this.field4672 + this.field4671 * this.field4671 + this.field4673 * this.field4673));
   }

   public String toString() {
      return this.field4671 + ", " + this.field4672 + ", " + this.field4673;
   }
}
