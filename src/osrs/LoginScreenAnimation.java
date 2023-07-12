package osrs;

public class LoginScreenAnimation {
   static Archive field1244;
   static SpritePixels[] mapMarkerSprites;
   static int field1255;
   IndexedSprite[] sprites;
   int[] field1243 = new int[256];
   int field1238 = 0;
   int[] field1239;
   int[] field1240;
   int[] field1241;
   int[] field1242;
   int field1235 = 0;
   int field1237 = 0;
   int[] field1245;
   int[] field1246;
   int[] field1250;
   int[] field1247;
   int field1249 = 0;
   int field1248 = 0;
   int field1251 = 0;

   LoginScreenAnimation(IndexedSprite[] var1) {
      this.sprites = var1;
      this.initColors();
   }

   void initColors() {
      this.field1240 = new int[256];

      int var1;
      for(var1 = 0; var1 < 64; ++var1) {
         this.field1240[var1] = var1 * 262144;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1240[var1 + 64] = var1 * 1024 + 16711680;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1240[var1 + 128] = var1 * 4 + 16776960;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1240[var1 + 192] = 16777215;
      }

      this.field1241 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1241[var1] = var1 * 1024;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1241[var1 + 64] = var1 * 4 + '\uff00';
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1241[var1 + 128] = var1 * 262144 + '\uffff';
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1241[var1 + 192] = 16777215;
      }

      this.field1242 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1242[var1] = var1 * 4;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1242[var1 + 64] = var1 * 262144 + 255;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1242[var1 + 128] = var1 * 1024 + 16711935;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1242[var1 + 192] = 16777215;
      }

      this.field1239 = new int[256];
      this.field1249 = 0;
      this.field1250 = new int['耀'];
      this.field1247 = new int['耀'];
      this.method2408((IndexedSprite)null);
      this.field1245 = new int['耀'];
      this.field1246 = new int['耀'];
   }

   void method2402() {
      this.field1240 = null;
      this.field1241 = null;
      this.field1242 = null;
      this.field1239 = null;
      this.field1250 = null;
      this.field1247 = null;
      this.field1245 = null;
      this.field1246 = null;
      this.field1249 = 0;
      this.field1248 = 0;
   }

   void draw(int var1, int var2) {
      if (this.field1245 == null) {
         this.initColors();
      }

      if (this.field1251 == 0) {
         this.field1251 = var2;
      }

      int var3 = var2 - this.field1251;
      if (var3 >= 256) {
         var3 = 0;
      }

      this.field1251 = var2;
      if (var3 > 0) {
         this.method2404(var3);
      }

      this.method2406(var1);
   }

   final void method2404(int var1) {
      this.field1249 += var1 * 128;
      int var2;
      if (this.field1249 > this.field1250.length) {
         this.field1249 -= this.field1250.length;
         var2 = (int)(Math.random() * 12.0);
         this.method2408(this.sprites[var2]);
      }

      var2 = 0;
      int var3 = var1 * 128;
      int var4 = (256 - var1) * 128;

      int var6;
      for(int var5 = 0; var5 < var4; ++var5) {
         var6 = this.field1245[var2 + var3] - this.field1250[var2 + this.field1249 & this.field1250.length - 1] * var1 / 6;
         if (var6 < 0) {
            var6 = 0;
         }

         this.field1245[var2++] = var6;
      }

      byte var15 = 10;
      var6 = 128 - var15;

      int var7;
      int var10;
      for(var7 = 256 - var1; var7 < 256; ++var7) {
         int var8 = var7 * 128;

         for(int var9 = 0; var9 < 128; ++var9) {
            var10 = (int)(Math.random() * 100.0);
            if (var10 < 50 && var9 > var15 && var9 < var6) {
               this.field1245[var8 + var9] = 255;
            } else {
               this.field1245[var8 + var9] = 0;
            }
         }
      }

      if (this.field1235 * 16 > 0) {
         this.field1235 = this.field1235 * 16 - var1 * 4;
      }

      if (this.field1237 * 16 > 0) {
         this.field1237 = this.field1237 * 16 - var1 * 4;
      }

      if (this.field1235 * 16 == 0 && this.field1237 * 16 == 0) {
         var7 = (int)(Math.random() * (double)(2000 / var1));
         if (var7 == 0) {
            this.field1235 = 1024;
         }

         if (var7 == 1) {
            this.field1237 = 1024;
         }
      }

      for(var7 = 0; var7 < 256 - var1; ++var7) {
         this.field1243[var7] = this.field1243[var7 + var1];
      }

      for(var7 = 256 - var1; var7 < 256; ++var7) {
         this.field1243[var7] = (int)(Math.sin((double)this.field1238 / 14.0) * 16.0 + Math.sin((double)this.field1238 / 15.0) * 14.0 + Math.sin((double)this.field1238 / 16.0) * 12.0);
         ++this.field1238;
      }

      this.field1248 = this.field1248 * 10000 + var1 * 10000;
      var7 = ((Client.cycle & 1) + var1) / 2;
      if (var7 > 0) {
         short var16 = 128;
         byte var17 = 2;
         var10 = 128 - var17 - var17;

         int var11;
         int var12;
         int var13;
         for(var11 = 0; var11 < this.field1248 * 100; ++var11) {
            var12 = (int)(Math.random() * (double)var10) + var17;
            var13 = (int)(Math.random() * (double)var16) + var16;
            this.field1245[var12 + (var13 << 7)] = 192;
         }

         this.field1248 = 0;

         int var14;
         for(var11 = 0; var11 < 256; ++var11) {
            var12 = 0;
            var13 = var11 * 128;

            for(var14 = -var7; var14 < 128; ++var14) {
               if (var7 + var14 < 128) {
                  var12 += this.field1245[var7 + var13 + var14];
               }

               if (var14 - (var7 + 1) >= 0) {
                  var12 -= this.field1245[var13 + var14 - (var7 + 1)];
               }

               if (var14 >= 0) {
                  this.field1246[var14 + var13] = var12 / (var7 * 2 + 1);
               }
            }
         }

         for(var11 = 0; var11 < 128; ++var11) {
            var12 = 0;

            for(var13 = -var7; var13 < 256; ++var13) {
               var14 = var13 * 128;
               if (var13 + var7 < 256) {
                  var12 += this.field1246[var7 * 128 + var11 + var14];
               }

               if (var13 - (var7 + 1) >= 0) {
                  var12 -= this.field1246[var14 + var11 - (var7 + 1) * 128];
               }

               if (var13 >= 0) {
                  this.field1245[var14 + var11] = var12 / (var7 * 2 + 1);
               }
            }
         }
      }

   }

   final int method2416(int var1, int var2, int var3) {
      int var4 = 256 - var3;
      return (var3 * (var2 & '\uff00') + var4 * (var1 & '\uff00') & 16711680) + (var3 * (var2 & 16711935) + var4 * (var1 & 16711935) & -16711936) >> 8;
   }

   final void method2406(int var1) {
      int var2 = this.field1239.length;
      if (this.field1235 * 16 > 0) {
         this.method2407(this.field1235 * 16, this.field1241);
      } else if (this.field1237 * 16 > 0) {
         this.method2407(this.field1237 * 16, this.field1242);
      } else {
         for(int var3 = 0; var3 < var2; ++var3) {
            this.field1239[var3] = this.field1240[var3];
         }
      }

      this.method2409(var1);
   }

   final void method2407(int var1, int[] var2) {
      int var3 = this.field1239.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if (var1 > 768) {
            this.field1239[var4] = this.method2416(this.field1240[var4], var2[var4], 1024 - var1);
         } else if (var1 > 256) {
            this.field1239[var4] = var2[var4];
         } else {
            this.field1239[var4] = this.method2416(var2[var4], this.field1240[var4], 256 - var1);
         }
      }

   }

   final void method2409(int var1) {
      int var2 = 0;

      for(int var3 = 1; var3 < 255; ++var3) {
         int var4 = (256 - var3) * this.field1243[var3] / 256;
         int var5 = var4 + var1;
         int var6 = 0;
         int var7 = 128;
         if (var5 < 0) {
            var6 = -var5;
            var5 = 0;
         }

         if (var5 + 128 >= WorldMapSectionType.rasterProvider.width) {
            var7 = WorldMapSectionType.rasterProvider.width - var5;
         }

         int var8 = var5 + (var3 + 8) * WorldMapSectionType.rasterProvider.width;
         var2 += var6;

         for(int var9 = var6; var9 < var7; ++var9) {
            int var10 = this.field1245[var2++];
            int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
            if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
               int var12 = var10;
               int var13 = 256 - var10;
               var10 = this.field1239[var10];
               int var14 = WorldMapSectionType.rasterProvider.pixels[var8];
               WorldMapSectionType.rasterProvider.pixels[var8++] = -16777216 | ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) + (var13 * (var14 & '\uff00') + var12 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var8;
            }
         }

         var2 += 128 - var7;
      }

   }

   final void method2408(IndexedSprite var1) {
      int var2;
      for(var2 = 0; var2 < this.field1250.length; ++var2) {
         this.field1250[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0 * 256.0);
         this.field1250[var3] = (int)(Math.random() * 256.0);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < 255; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               this.field1247[var5] = (this.field1250[var5 + 1] + this.field1250[var5 + 128] + this.field1250[var5 - 128] + this.field1250[var5 - 1]) / 4;
            }
         }

         int[] var8 = this.field1250;
         this.field1250 = this.field1247;
         this.field1247 = var8;
      }

      if (var1 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var1.subHeight; ++var3) {
            for(var4 = 0; var4 < var1.subWidth; ++var4) {
               if (var1.pixels[var2++] != 0) {
                  var5 = var4 + var1.xOffset + 16;
                  int var6 = var3 + var1.yOffset + 16;
                  int var7 = var5 + (var6 << 7);
                  this.field1250[var7] = 0;
               }
            }
         }
      }

   }

   public static int Widget_unpackTargetMask(int var0) {
      return var0 >> 11 & 63;
   }

   static class137[] method2429() {
      return new class137[]{class137.field1601, class137.field1593, class137.field1594, class137.field1595, class137.field1592, class137.field1597, class137.field1598, class137.field1599, class137.field1600};
   }

   static void findItemDefinitions(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class435.ItemDefinition_fileCount; ++var4) {
         ItemComposition var9 = class300.ItemDefinition_get(var4);
         if ((!var1 || var9.isTradable) && var9.noteTemplate == -1 && var9.name.toLowerCase().indexOf(var0) != -1) {
            if (var3 >= 250) {
               class105.foundItemIdCount = -1;
               class18.foundItemIds = null;
               return;
            }

            if (var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class18.foundItemIds = var2;
      class13.foundItemIndex = 0;
      class105.foundItemIdCount = var3;
      String[] var8 = new String[class105.foundItemIdCount];

      for(int var5 = 0; var5 < class105.foundItemIdCount; ++var5) {
         var8[var5] = class300.ItemDefinition_get(var2[var5]).name;
      }

      short[] var10 = class18.foundItemIds;
      Archive.sortItemsByName(var8, var10, 0, var8.length - 1);
   }
}
