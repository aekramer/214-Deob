package osrs;

public abstract class AbstractWorldMapIcon {
   public final Coord coord2;
   public final Coord coord1;
   int screenX;
   int screenY;

   AbstractWorldMapIcon(Coord var1, Coord var2) {
      this.coord1 = var1;
      this.coord2 = var2;
   }

   public abstract int getElement();

   abstract WorldMapLabel getLabel();

   abstract int getSubWidth();

   abstract int getSubHeight();

   boolean fitsScreen(int var1, int var2) {
      if (this.elementFitsScreen(var1, var2)) {
         return true;
      } else {
         return this.labelFitsScreen(var1, var2);
      }
   }

   boolean hasValidElement() {
      return this.getElement() >= 0;
   }

   boolean elementFitsScreen(int var1, int var2) {
      if (!this.hasValidElement()) {
         return false;
      } else {
         WorldMapElement var3 = class147.WorldMapElement_get(this.getElement());
         int var4 = this.getSubWidth();
         int var5 = this.getSubHeight();
         switch (var3.horizontalAlignment.value) {
            case 0:
               if (var1 > this.screenX - var4 && var1 <= this.screenX) {
                  break;
               }

               return false;
            case 1:
               if (var1 >= this.screenX && var1 < var4 + this.screenX) {
                  break;
               }

               return false;
            case 2:
               if (var1 < this.screenX - var4 / 2 || var1 > var4 / 2 + this.screenX) {
                  return false;
               }
         }

         switch (var3.verticalAlignment.value) {
            case 0:
               if (var2 >= this.screenY - var5 / 2 && var2 <= var5 / 2 + this.screenY) {
                  break;
               }

               return false;
            case 1:
               if (var2 >= this.screenY && var2 < var5 + this.screenY) {
                  break;
               }

               return false;
            case 2:
               if (var2 <= this.screenY - var5 || var2 > this.screenY) {
                  return false;
               }
         }

         return true;
      }
   }

   boolean labelFitsScreen(int var1, int var2) {
      WorldMapLabel var3 = this.getLabel();
      if (var3 == null) {
         return false;
      } else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
         return var2 >= this.screenY && var2 <= var3.height + this.screenY;
      } else {
         return false;
      }
   }

   public static void method5525() {
      SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
      SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
   }
}
