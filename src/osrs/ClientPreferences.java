package osrs;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ClientPreferences {
   boolean roofsHidden;
   boolean hideUsername = false;
   boolean titleMusicDisabled;
   boolean displayFps = false;
   int field1264;
   double brightness = 0.8;
   int musicVolume = 127;
   int soundEffectsVolume = 127;
   int areaSoundEffectsVolume = 127;
   int field1269 = -1;
   String rememberedUsername = null;
   int windowMode = 1;
   final Map parameters = new LinkedHashMap();

   ClientPreferences() {
      this.method2431(true);
   }

   ClientPreferences(Buffer var1) {
      if (var1 != null && var1.array != null) {
         int var2 = var1.readUnsignedByte();
         if (var2 >= 0 && var2 <= 10) {
            if (var1.readUnsignedByte() == 1) {
               this.roofsHidden = true;
            }

            if (var2 > 1) {
               this.titleMusicDisabled = var1.readUnsignedByte() == 1;
            }

            if (var2 > 3) {
               this.windowMode = var1.readUnsignedByte();
            }

            if (var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.parameters.put(var5, var6);
               }
            }

            if (var2 > 4) {
               this.rememberedUsername = var1.readStringCp1252NullTerminatedOrNull();
            }

            if (var2 > 5) {
               this.hideUsername = var1.readBoolean();
            }

            if (var2 > 6) {
               this.brightness = (double)var1.readUnsignedByte() / 100.0;
               this.musicVolume = var1.readUnsignedByte();
               this.soundEffectsVolume = var1.readUnsignedByte();
               this.areaSoundEffectsVolume = var1.readUnsignedByte();
            }

            if (var2 > 7) {
               this.field1269 = var1.readUnsignedByte();
            }

            if (var2 > 8) {
               this.displayFps = var1.readUnsignedByte() == 1;
            }

            if (var2 > 9) {
               this.field1264 = var1.readInt();
            }
         } else {
            this.method2431(true);
         }
      } else {
         this.method2431(true);
      }

   }

   void method2431(boolean var1) {
   }

   Buffer toBuffer() {
      Buffer var1 = new Buffer(417, true);
      var1.writeByte(10);
      var1.writeByte(this.roofsHidden ? 1 : 0);
      var1.writeByte(this.titleMusicDisabled ? 1 : 0);
      var1.writeByte(this.windowMode);
      var1.writeByte(this.parameters.size());
      Iterator var2 = this.parameters.entrySet().iterator();

      while(var2.hasNext()) {
         Map.Entry var3 = (Map.Entry)var2.next();
         var1.writeInt((Integer)var3.getKey());
         var1.writeInt((Integer)var3.getValue());
      }

      var1.writeStringCp1252NullTerminated(this.rememberedUsername != null ? this.rememberedUsername : "");
      var1.writeBoolean(this.hideUsername);
      var1.writeByte((int)(100.0 * this.brightness));
      var1.writeByte(this.musicVolume);
      var1.writeByte(this.soundEffectsVolume);
      var1.writeByte(this.areaSoundEffectsVolume);
      var1.writeByte(this.field1269);
      var1.writeByte(this.displayFps ? 1 : 0);
      var1.writeInt(this.field1264);
      return var1;
   }

   void method2489(boolean var1) {
      this.roofsHidden = var1;
      class100.savePreferences();
   }

   boolean method2434() {
      return this.roofsHidden;
   }

   void method2524(boolean var1) {
      this.hideUsername = var1;
      class100.savePreferences();
   }

   boolean method2472() {
      return this.hideUsername;
   }

   void method2436(boolean var1) {
      this.titleMusicDisabled = var1;
      class100.savePreferences();
   }

   boolean method2437() {
      return this.titleMusicDisabled;
   }

   void method2438(boolean var1) {
      this.displayFps = var1;
      class100.savePreferences();
   }

   void method2439() {
      this.method2438(!this.displayFps);
   }

   boolean method2448() {
      return this.displayFps;
   }

   void method2452(int var1) {
      this.field1264 = var1;
      class100.savePreferences();
   }

   int method2442() {
      return this.field1264;
   }

   void method2443(double var1) {
      this.brightness = var1;
      class100.savePreferences();
   }

   double method2430() {
      return this.brightness;
   }

   void method2519(int var1) {
      this.musicVolume = var1;
      class100.savePreferences();
   }

   int method2488() {
      return this.musicVolume;
   }

   void updateSoundEffectVolume(int var1) {
      this.soundEffectsVolume = var1;
      class100.savePreferences();
   }

   int method2445() {
      return this.soundEffectsVolume;
   }

   void method2449(int var1) {
      this.areaSoundEffectsVolume = var1;
      class100.savePreferences();
   }

   int method2450() {
      return this.areaSoundEffectsVolume;
   }

   void method2432(String var1) {
      this.rememberedUsername = var1;
      class100.savePreferences();
   }

   String method2529() {
      return this.rememberedUsername;
   }

   void method2466(int var1) {
      this.field1269 = var1;
      class100.savePreferences();
   }

   int method2454() {
      return this.field1269;
   }

   void method2440(int var1) {
      this.windowMode = var1;
      class100.savePreferences();
   }

   int method2456() {
      return this.windowMode;
   }

   void method2457(String var1, int var2) {
      int var3 = this.method2460(var1);
      if (this.parameters.size() >= 10 && !this.parameters.containsKey(var3)) {
         Iterator var4 = this.parameters.entrySet().iterator();
         var4.next();
         var4.remove();
      }

      this.parameters.put(var3, var2);
      class100.savePreferences();
   }

   boolean method2484(String var1) {
      int var2 = this.method2460(var1);
      return this.parameters.containsKey(var2);
   }

   int method2459(String var1) {
      int var2 = this.method2460(var1);
      return !this.parameters.containsKey(var2) ? 0 : (Integer)this.parameters.get(var2);
   }

   int method2460(String var1) {
      return class226.method4452(var1.toLowerCase());
   }

   static final int method2435(int var0, int var1, int var2, int var3) {
      return var3 * var0 + var2 * var1 >> 16;
   }

   static void method2433(Font var0, Font var1) {
      if (class16.worldSelectBackSprites == null) {
         class16.worldSelectBackSprites = CollisionMap.method4206(class180.archive8, "sl_back", "");
      }

      if (class134.worldSelectFlagSprites == null) {
         class134.worldSelectFlagSprites = WorldMapRectangle.method5460(class180.archive8, "sl_flags", "");
      }

      if (class1.worldSelectArrows == null) {
         class1.worldSelectArrows = WorldMapRectangle.method5460(class180.archive8, "sl_arrows", "");
      }

      if (class342.worldSelectStars == null) {
         class342.worldSelectStars = WorldMapRectangle.method5460(class180.archive8, "sl_stars", "");
      }

      if (class299.worldSelectLeftSprite == null) {
         class299.worldSelectLeftSprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(class180.archive8, "leftarrow", "");
      }

      if (class128.worldSelectRightSprite == null) {
         class128.worldSelectRightSprite = WorldMapRectangle.SpriteBuffer_getIndexedSpriteByName(class180.archive8, "rightarrow", "");
      }

      Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
      Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
      var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
      if (class342.worldSelectStars != null) {
         class342.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
         var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
         class342.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
         var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if (class1.worldSelectArrows != null) {
         int var2 = Login.xPadding + 280;
         if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
            class1.worldSelectArrows[2].drawAt(var2, 4);
         } else {
            class1.worldSelectArrows[0].drawAt(var2, 4);
         }

         if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
            class1.worldSelectArrows[3].drawAt(var2 + 15, 4);
         } else {
            class1.worldSelectArrows[1].drawAt(var2 + 15, 4);
         }

         var0.draw("World", var2 + 32, 17, 16777215, -1);
         int var3 = Login.xPadding + 390;
         if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
            class1.worldSelectArrows[2].drawAt(var3, 4);
         } else {
            class1.worldSelectArrows[0].drawAt(var3, 4);
         }

         if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
            class1.worldSelectArrows[3].drawAt(var3 + 15, 4);
         } else {
            class1.worldSelectArrows[1].drawAt(var3 + 15, 4);
         }

         var0.draw("Players", var3 + 32, 17, 16777215, -1);
         var4 = Login.xPadding + 500;
         if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
            class1.worldSelectArrows[2].drawAt(var4, 4);
         } else {
            class1.worldSelectArrows[0].drawAt(var4, 4);
         }

         if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
            class1.worldSelectArrows[3].drawAt(var4 + 15, 4);
         } else {
            class1.worldSelectArrows[1].drawAt(var4 + 15, 4);
         }

         var0.draw("Location", var4 + 32, 17, 16777215, -1);
         var5 = Login.xPadding + 610;
         if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
            class1.worldSelectArrows[2].drawAt(var5, 4);
         } else {
            class1.worldSelectArrows[0].drawAt(var5, 4);
         }

         if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
            class1.worldSelectArrows[3].drawAt(var5 + 15, 4);
         } else {
            class1.worldSelectArrows[1].drawAt(var5 + 15, 4);
         }

         var0.draw("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
      var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
      Login.hoveredWorldIndex = -1;
      if (class16.worldSelectBackSprites != null) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (var23 + 1) - 1;
         var5 = 480 / (var24 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if (var5 * (var4 - 1) >= World.World_count) {
               --var4;
            }

            if (var4 * (var5 - 1) >= World.World_count) {
               --var5;
            }

            if (var4 * (var5 - 1) >= World.World_count) {
               --var5;
            }
         } while(var5 != var6 || var7 != var4);

         var6 = (765 - var4 * var23) / (var4 + 1);
         if (var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var24 * var5) / (var5 + 1);
         if (var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var4 * var23 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var24 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = (var5 + World.World_count - 1) / var5;
         Login.worldSelectPagesCount = var10 - var4;
         if (class299.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
            class299.worldSelectLeftSprite.drawAt(8, WorldMapID.canvasHeight / 2 - class299.worldSelectLeftSprite.subHeight / 2);
         }

         if (class128.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
            class128.worldSelectRightSprite.drawAt(class448.canvasWidth - class128.worldSelectRightSprite.subWidth - 8, WorldMapID.canvasHeight / 2 - class128.worldSelectRightSprite.subHeight / 2);
         }

         int var11 = var9 + 23;
         int var12 = var8 + Login.xPadding;
         int var13 = 0;
         boolean var14 = false;
         int var15 = Login.worldSelectPage;

         int var16;
         for(var16 = var15 * var5; var16 < World.World_count && var15 - Login.worldSelectPage < var4; ++var16) {
            World var17 = World.World_worlds[var16];
            boolean var18 = true;
            String var19 = Integer.toString(var17.population);
            if (var17.population == -1) {
               var19 = "OFF";
               var18 = false;
            } else if (var17.population > 1980) {
               var19 = "FULL";
               var18 = false;
            }

            class107 var20 = null;
            int var21 = 0;
            if (var17.isBeta()) {
               var20 = var17.isMembersOnly() ? class107.field1348 : class107.field1353;
            } else if (var17.isDeadman()) {
               var20 = var17.isMembersOnly() ? class107.field1362 : class107.field1361;
            } else if (var17.method1747()) {
               var21 = 16711680;
               var20 = var17.isMembersOnly() ? class107.field1357 : class107.field1351;
            } else if (var17.method1755()) {
               var20 = var17.isMembersOnly() ? class107.field1356 : class107.field1355;
            } else if (var17.isPvp()) {
               var20 = var17.isMembersOnly() ? class107.field1350 : class107.field1349;
            } else if (var17.method1756()) {
               var20 = var17.isMembersOnly() ? class107.field1358 : class107.field1352;
            } else if (var17.method1757()) {
               var20 = var17.isMembersOnly() ? class107.field1360 : class107.field1354;
            }

            if (var20 == null || var20.field1363 >= class16.worldSelectBackSprites.length) {
               var20 = var17.isMembersOnly() ? class107.field1347 : class107.field1359;
            }

            if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var11 && MouseHandler.MouseHandler_x < var23 + var12 && MouseHandler.MouseHandler_y < var24 + var11 && var18) {
               Login.hoveredWorldIndex = var16;
               class16.worldSelectBackSprites[var20.field1363].drawTransOverlayAt(var12, var11, 128, 16777215);
               var14 = true;
            } else {
               class16.worldSelectBackSprites[var20.field1363].drawAt(var12, var11);
            }

            if (class134.worldSelectFlagSprites != null) {
               class134.worldSelectFlagSprites[(var17.isMembersOnly() ? 8 : 0) + var17.location].drawAt(var12 + 29, var11);
            }

            var0.drawCentered(Integer.toString(var17.id), var12 + 15, var24 / 2 + var11 + 5, var21, -1);
            var1.drawCentered(var19, var12 + 60, var24 / 2 + var11 + 5, 268435455, -1);
            var11 = var11 + var7 + var24;
            ++var13;
            if (var13 >= var5) {
               var11 = var9 + 23;
               var12 = var12 + var23 + var6;
               var13 = 0;
               ++var15;
            }
         }

         if (var14) {
            var16 = var1.stringWidth(World.World_worlds[Login.hoveredWorldIndex].activity) + 6;
            int var22 = var1.ascent + 8;
            int var25 = MouseHandler.MouseHandler_y + 25;
            if (var25 + var22 > 480) {
               var25 = MouseHandler.MouseHandler_y - 25 - var22;
            }

            Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var16 / 2, var25, var16, var22, 16777120);
            Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var16 / 2, var25, var16, var22, 0);
            var1.drawCentered(World.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var25 + var1.ascent + 4, 0, -1);
         }
      }

      WorldMapSectionType.rasterProvider.drawFull(0, 0);
   }

   static void method2541(int var0, int var1, int var2) {
      if (var0 != 0) {
         int var3 = var0 >> 8;
         int var4 = var0 >> 4 & 7;
         int var5 = var0 & 15;
         Client.soundEffectIds[Client.soundEffectCount] = var3;
         Client.queuedSoundEffectLoops[Client.soundEffectCount] = var4;
         Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
         Client.soundEffects[Client.soundEffectCount] = null;
         int var6 = (var1 - 64) / 128;
         int var7 = (var2 - 64) / 128;
         Client.soundLocations[Client.soundEffectCount] = var5 + (var7 << 8) + (var6 << 16);
         ++Client.soundEffectCount;
      }
   }
}
