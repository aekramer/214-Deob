package osrs;
import java.util.LinkedList;
import java.util.List;
import net.runelite.rs.ScriptOpcodes;

public class NPCComposition extends DualNode {
   static AbstractArchive NpcDefinition_archive;
   static AbstractArchive field1995;
   static EvictingDualNodeHashTable NpcDefinition_cached = new EvictingDualNodeHashTable(64);
   static EvictingDualNodeHashTable NpcDefinition_cachedModels = new EvictingDualNodeHashTable(50);
   static SpritePixels[] headIconPkSprites;
   public int id;
   public String name = "null";
   public int size = 1;
   int[] models;
   int[] field2002;
   public int idleSequence = -1;
   public int turnLeftSequence = -1;
   public int turnRightSequence = -1;
   public int walkSequence = -1;
   public int walkBackSequence = -1;
   public int walkLeftSequence = -1;
   public int walkRightSequence = -1;
   public int field2014 = -1;
   public int field2011 = -1;
   public int field2012 = -1;
   public int field2013 = -1;
   public int field1994 = -1;
   public int field2015 = -1;
   public int field2016 = -1;
   public int field2017 = -1;
   short[] recolorFrom;
   public short[] recolorTo;
   short[] retextureFrom;
   public short[] retextureTo;
   public String[] actions = new String[5];
   public boolean drawMapDot = true;
   public int combatLevel = -1;
   int widthScale = 128;
   int heightScale = 128;
   public boolean isVisible = false;
   int ambient = 0;
   int contrast = 0;
   public int rotation = 32;
   public int[] transforms;
   int transformVarbit = -1;
   int transformVarp = -1;
   public boolean isInteractable = true;
   public boolean isClickable = true;
   public boolean isFollower = false;
   int[] headIconArchiveIds = null;
   short[] headIconSpriteIndex = null;
   IterableNodeHashTable params;

   NPCComposition() {
   }

   void postDecode() {
   }

   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   void decodeNext(Buffer var1, int var2) {
      int var3;
      int var4;
      if (var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if (var2 == 2) {
         this.name = var1.readStringCp1252NullTerminated();
      } else if (var2 == 12) {
         this.size = var1.readUnsignedByte();
      } else if (var2 == 13) {
         this.idleSequence = var1.readUnsignedShort();
      } else if (var2 == 14) {
         this.walkSequence = var1.readUnsignedShort();
      } else if (var2 == 15) {
         this.turnLeftSequence = var1.readUnsignedShort();
      } else if (var2 == 16) {
         this.turnRightSequence = var1.readUnsignedShort();
      } else if (var2 == 17) {
         this.walkSequence = var1.readUnsignedShort();
         this.walkBackSequence = var1.readUnsignedShort();
         this.walkLeftSequence = var1.readUnsignedShort();
         this.walkRightSequence = var1.readUnsignedShort();
      } else if (var2 == 18) {
         var1.readUnsignedShort();
      } else if (var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readStringCp1252NullTerminated();
         if (this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if (var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.recolorFrom = new short[var3];
         this.recolorTo = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.recolorFrom[var4] = (short)var1.readUnsignedShort();
            this.recolorTo[var4] = (short)var1.readUnsignedShort();
         }
      } else if (var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.retextureFrom = new short[var3];
         this.retextureTo = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.retextureFrom[var4] = (short)var1.readUnsignedShort();
            this.retextureTo[var4] = (short)var1.readUnsignedShort();
         }
      } else if (var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field2002 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field2002[var4] = var1.readUnsignedShort();
         }
      } else if (var2 == 93) {
         this.drawMapDot = false;
      } else if (var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if (var2 == 97) {
         this.widthScale = var1.readUnsignedShort();
      } else if (var2 == 98) {
         this.heightScale = var1.readUnsignedShort();
      } else if (var2 == 99) {
         this.isVisible = true;
      } else if (var2 == 100) {
         this.ambient = var1.readByte();
      } else if (var2 == 101) {
         this.contrast = var1.readByte() * 5;
      } else {
         int var5;
         if (var2 == 102) {
            var3 = var1.readUnsignedByte();
            var4 = 0;

            for(var5 = var3; var5 != 0; var5 >>= 1) {
               ++var4;
            }

            this.headIconArchiveIds = new int[var4];
            this.headIconSpriteIndex = new short[var4];

            for(int var6 = 0; var6 < var4; ++var6) {
               if ((var3 & 1 << var6) == 0) {
                  this.headIconArchiveIds[var6] = -1;
                  this.headIconSpriteIndex[var6] = -1;
               } else {
                  this.headIconArchiveIds[var6] = var1.readNullableLargeSmart();
                  this.headIconSpriteIndex[var6] = (short)var1.readShortSmartSub();
               }
            }
         } else if (var2 == 103) {
            this.rotation = var1.readUnsignedShort();
         } else if (var2 != 106 && var2 != 118) {
            if (var2 == 107) {
               this.isInteractable = false;
            } else if (var2 == 109) {
               this.isClickable = false;
            } else if (var2 == 111) {
               this.isFollower = true;
            } else if (var2 == 114) {
               this.field2014 = var1.readUnsignedShort();
            } else if (var2 == 115) {
               this.field2014 = var1.readUnsignedShort();
               this.field2011 = var1.readUnsignedShort();
               this.field2012 = var1.readUnsignedShort();
               this.field2013 = var1.readUnsignedShort();
            } else if (var2 == 116) {
               this.field1994 = var1.readUnsignedShort();
            } else if (var2 == 117) {
               this.field1994 = var1.readUnsignedShort();
               this.field2015 = var1.readUnsignedShort();
               this.field2016 = var1.readUnsignedShort();
               this.field2017 = var1.readUnsignedShort();
            } else if (var2 == 249) {
               this.params = ReflectionCheck.readStringIntParameters(var1, this.params);
            }
         } else {
            this.transformVarbit = var1.readUnsignedShort();
            if (this.transformVarbit == 65535) {
               this.transformVarbit = -1;
            }

            this.transformVarp = var1.readUnsignedShort();
            if (this.transformVarp == 65535) {
               this.transformVarp = -1;
            }

            var3 = -1;
            if (var2 == 118) {
               var3 = var1.readUnsignedShort();
               if (var3 == 65535) {
                  var3 = -1;
               }
            }

            var4 = var1.readUnsignedByte();
            this.transforms = new int[var4 + 2];

            for(var5 = 0; var5 <= var4; ++var5) {
               this.transforms[var5] = var1.readUnsignedShort();
               if (this.transforms[var5] == 65535) {
                  this.transforms[var5] = -1;
               }
            }

            this.transforms[var4 + 1] = var3;
         }
      }

   }

   public final Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4, NewStuff var5) {
      if (this.transforms != null) {
         NPCComposition var10 = this.transform();
         return var10 == null ? null : var10.getModel(var1, var2, var3, var4, var5);
      } else {
         long var6 = (long)this.id;
         if (var5 != null) {
            var6 |= var5.field1989 << 16;
         }

         Model var8 = (Model)NpcDefinition_cachedModels.get(var6);
         if (var8 == null) {
            ModelData var9 = this.getModelData(this.models, var5);
            if (var9 == null) {
               return null;
            }

            var8 = var9.toModel(this.ambient + 64, this.contrast + 850, -30, -50, -30);
            NpcDefinition_cachedModels.put(var8, var6);
         }

         Model var11;
         if (var1 != null && var3 != null) {
            var11 = var1.applyTransformations(var8, var2, var3, var4);
         } else if (var1 != null) {
            var11 = var1.transformActorModel(var8, var2);
         } else if (var3 != null) {
            var11 = var3.transformActorModel(var8, var4);
         } else {
            var11 = var8.toSharedSequenceModel(true);
         }

         if (this.widthScale != 128 || this.heightScale != 128) {
            var11.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var11;
      }
   }

   public final ModelData method3692(NewStuff var1) {
      if (this.transforms != null) {
         NPCComposition var2 = this.transform();
         return var2 == null ? null : var2.method3692(var1);
      } else {
         return this.getModelData(this.field2002, var1);
      }
   }

   ModelData getModelData(int[] var1, NewStuff var2) {
      int[] var3 = var1;
      if (var2 != null && var2.field1987 != null) {
         var3 = var2.field1987;
      }

      if (var3 == null) {
         return null;
      } else {
         boolean var4 = false;

         for(int var5 = 0; var5 < var3.length; ++var5) {
            if (var3[var5] != -1 && !field1995.tryLoadFile(var3[var5], 0)) {
               var4 = true;
            }
         }

         if (var4) {
            return null;
         } else {
            ModelData[] var9 = new ModelData[var3.length];

            for(int var6 = 0; var6 < var3.length; ++var6) {
               var9[var6] = ModelData.ModelData_get(field1995, var3[var6], 0);
            }

            ModelData var10;
            if (var9.length == 1) {
               var10 = var9[0];
               if (var10 == null) {
                  var10 = new ModelData(var9, var9.length);
               }
            } else {
               var10 = new ModelData(var9, var9.length);
            }

            short[] var7;
            int var8;
            if (this.recolorFrom != null) {
               var7 = this.recolorTo;
               if (var2 != null && var2.field1988 != null) {
                  var7 = var2.field1988;
               }

               for(var8 = 0; var8 < this.recolorFrom.length; ++var8) {
                  var10.recolor(this.recolorFrom[var8], var7[var8]);
               }
            }

            if (this.retextureFrom != null) {
               var7 = this.retextureTo;
               if (var2 != null && var2.field1991 != null) {
                  var7 = var2.field1991;
               }

               for(var8 = 0; var8 < this.retextureFrom.length; ++var8) {
                  var10.retexture(this.retextureFrom[var8], var7[var8]);
               }
            }

            return var10;
         }
      }
   }

   public final NPCComposition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = class343.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? Bounds.getNpcDefinition(var2) : null;
   }

   public boolean transformIsVisible() {
      if (this.transforms == null) {
         return true;
      } else {
         int var1 = -1;
         if (this.transformVarbit != -1) {
            var1 = class343.getVarbit(this.transformVarbit);
         } else if (this.transformVarp != -1) {
            var1 = Varps.Varps_main[this.transformVarp];
         }

         if (var1 >= 0 && var1 < this.transforms.length) {
            return this.transforms[var1] != -1;
         } else {
            return this.transforms[this.transforms.length - 1] != -1;
         }
      }
   }

   public int getIntParam(int var1, int var2) {
      IterableNodeHashTable var4 = this.params;
      int var3;
      if (var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if (var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.integer;
         }
      }

      return var3;
   }

   public String getStringParam(int var1, String var2) {
      return class165.method3374(this.params, var1, var2);
   }

   public boolean method3698() {
      return this.headIconArchiveIds != null && this.headIconSpriteIndex != null;
   }

   public int[] method3699() {
      return this.headIconArchiveIds;
   }

   public int method3687(int var1) {
      return this.headIconArchiveIds != null && var1 < this.headIconArchiveIds.length ? this.headIconArchiveIds[var1] : -1;
   }

   public short[] method3706() {
      return this.headIconSpriteIndex;
   }

   public short method3735(int var1) {
      return this.headIconSpriteIndex != null && var1 < this.headIconSpriteIndex.length ? this.headIconSpriteIndex[var1] : -1;
   }

   public static void method3714() {
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
         if (ArchiveDiskActionHandler.field4224 != 0) {
            ArchiveDiskActionHandler.field4224 = 1;

            try {
               ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock.wait();
            } catch (InterruptedException var3) {
            }
         }

      }
   }

   static int method3745(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 >= 2000) {
         var0 -= 1000;
         var3 = FriendSystem.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      } else {
         var3 = var2 ? class53.scriptDotWidget : Interpreter.scriptActiveWidget;
      }

      Messages.invalidateWidget(var3);
      int var4;
      int var5;
      if (var0 != ScriptOpcodes.CC_SETOBJECT && var0 != ScriptOpcodes.CC_SETOBJECT_NONUM && var0 != ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM) {
         if (var0 == ScriptOpcodes.CC_SETNPCHEAD) {
            var3.modelType = 2;
            var3.modelId = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            return 1;
         } else if (var0 == ScriptOpcodes.CC_SETPLAYERHEAD_SELF) {
            var3.modelType = 3;
            var3.modelId = Projectile.localPlayer.appearance.getChatHeadId();
            return 1;
         } else if (var0 == 1207) {
            boolean var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            GraphicsObject.method2043(var3, Projectile.localPlayer.appearance, var7);
            return 1;
         } else if (var0 == 1208) {
            var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var3.field3631 == null) {
               throw new RuntimeException("");
            } else {
               ItemComposition.method4019(var3, var4);
               return 1;
            }
         } else if (var0 == 1209) {
            Interpreter.Interpreter_intStackSize -= 2;
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            if (var3.field3631 == null) {
               throw new RuntimeException("");
            } else {
               class199.method3808(var3, var4, var5);
               return 1;
            }
         } else if (var0 == 1210) {
            var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var3.field3631 == null) {
               throw new RuntimeException("");
            } else {
               MusicPatchPcmStream.method5941(var3, Projectile.localPlayer.appearance.gender, var4);
               return 1;
            }
         } else {
            return 2;
         }
      } else {
         Interpreter.Interpreter_intStackSize -= 2;
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class300.ItemDefinition_get(var4);
         var3.modelAngleX = var6.rotation_y;
         var3.modelAngleY = var6.rotation_x;
         var3.modelAngleZ = var6.rotation_z;
         var3.modelOffsetX = var6.translate_x;
         var3.modelOffsetY = var6.translate_yz;
         var3.modelZoom = var6.model_zoom;
         if (var0 == ScriptOpcodes.CC_SETOBJECT_NONUM) {
            var3.itemQuantityMode = 0;
         } else if (var0 == ScriptOpcodes.CC_SETOBJECT_ALWAYS_NUM | 1 == var6.isStackable) {
            var3.itemQuantityMode = 1;
         } else {
            var3.itemQuantityMode = 2;
         }

         if (var3.field3667 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field3667;
         } else if (var3.rawWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.rawWidth;
         }

         return 1;
      }
   }

   static int method3746(int var0, Script var1, boolean var2) {
      int var3;
      Object var4;
      int var5;
      class494 var6;
      int var7;
      if (var0 != ScriptOpcodes.DB_FIND_WITH_COUNT && var0 != ScriptOpcodes.DB_FIND) {
         if (var0 != ScriptOpcodes.DB_FINDNEXT) {
            int var19;
            int var20;
            if (var0 == ScriptOpcodes.DB_GETFIELD) {
               Interpreter.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var19 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               var20 = class152.method3196(var19);
               var7 = class481.method8660(var19);
               int var21 = class280.method5603(var19);
               DbRowType var26 = class473.getDbRowType(var3);
               DbTableType var27 = class152.getDbTableType(var20);
               int[] var28 = var27.types[var7];
               int var12 = 0;
               int var13 = var28.length;
               if (var21 >= 0) {
                  if (var21 >= var13) {
                     throw new RuntimeException("Tuple index out-of-bounds. Requested: " + var21 + ", Max: " + var13);
                  }

                  var12 = var21;
                  var13 = var21 + 1;
               }

               Object[] var14 = var26.getColumnType(var7);
               if (var14 == null && var27.defaultValues != null) {
                  var14 = var27.defaultValues[var7];
               }

               int var15;
               int var16;
               if (var14 == null) {
                  for(var15 = var12; var15 < var13; ++var15) {
                     var16 = var28[var15];
                     class490 var22 = WorldMapRectangle.method5458(var16);
                     if (var22 == class490.field4976) {
                        Interpreter.Interpreter_stringStack[++class149.Interpreter_stringStackSize - 1] = "";
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class485.method8730(var16);
                     }
                  }

                  return 1;
               } else {
                  var15 = var14.length / var28.length;
                  if (var5 >= 0 && var5 < var15) {
                     for(var16 = var12; var16 < var13; ++var16) {
                        int var17 = var16 + var28.length * var5;
                        class490 var18 = WorldMapRectangle.method5458(var28[var16]);
                        if (var18 == class490.field4976) {
                           Interpreter.Interpreter_stringStack[++class149.Interpreter_stringStackSize - 1] = (String)var14[var17];
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (Integer)var14[var17];
                        }
                     }

                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               }
            } else if (var0 == ScriptOpcodes.DB_GETFIELDCOUNT) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var19 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = 0;
               var20 = class152.method3196(var19);
               var7 = class481.method8660(var19);
               DbRowType var25 = class473.getDbRowType(var3);
               DbTableType var9 = class152.getDbTableType(var20);
               int[] var10 = var9.types[var7];
               Object[] var11 = var25.getColumnType(var7);
               if (var11 == null && var9.defaultValues != null) {
                  var11 = var9.defaultValues[var7];
               }

               if (var11 != null) {
                  var5 = var11.length / var10.length;
               }

               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
               return 1;
            } else if (var0 != ScriptOpcodes.DB_FINDALL_WITH_COUNT && var0 != ScriptOpcodes.DB_FIND_FILTER) {
               if (var0 == ScriptOpcodes.DB_GETROWTABLE) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  DbRowType var24 = class473.getDbRowType(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var24.tableId;
                  return 1;
               } else if (var0 == ScriptOpcodes.DB_GETROW) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var19 = -1;
                  if (class158.field1737 != null && var3 >= 0 && var3 < class158.field1737.size()) {
                     var19 = (Integer)class158.field1737.get(var3);
                  }

                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var19;
                  return 1;
               } else if (var0 != ScriptOpcodes.DB_FIND_FILTER_WITH_COUNT && var0 != ScriptOpcodes.DB_FINDALL) {
                  return 2;
               } else {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var4 = class4.method13(var3);
                  var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var6 = class53.method1052(var5);
                  if (var6 == null) {
                     throw new RuntimeException();
                  } else if (class152.method3196(var5) != Client.field606) {
                     throw new RuntimeException();
                  } else if (class158.field1737 == null && class158.field1737.isEmpty()) {
                     throw new RuntimeException();
                  } else {
                     var7 = class280.method5603(var5);
                     List var8 = var6.method8803(var4, var7);
                     class158.field1737 = new LinkedList(class158.field1737);
                     if (var8 != null) {
                        class158.field1737.retainAll(var8);
                     } else {
                        class158.field1737.clear();
                     }

                     class218.field2404 = class158.field1737.iterator();
                     if (var0 == ScriptOpcodes.DB_FIND_FILTER_WITH_COUNT) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class158.field1737.size();
                     }

                     return 1;
                  }
               }
            } else {
               --Interpreter.Interpreter_intStackSize;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               class494 var23 = class143.method3126(var3);
               if (var23 == null) {
                  throw new RuntimeException();
               } else {
                  class158.field1737 = var23.method8803(0, 0);
                  var5 = 0;
                  if (class158.field1737 != null) {
                     Client.field606 = var3;
                     class218.field2404 = class158.field1737.iterator();
                     var5 = class158.field1737.size();
                  }

                  if (var0 == ScriptOpcodes.DB_FINDALL_WITH_COUNT) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
                  }

                  return 1;
               }
            }
         } else {
            if (class218.field2404 != null && class218.field2404.hasNext()) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (Integer)class218.field2404.next();
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
            }

            return 1;
         }
      } else {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var4 = class4.method13(var3);
         var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var6 = class53.method1052(var5);
         if (var6 == null) {
            throw new RuntimeException();
         } else {
            var7 = class280.method5603(var5);
            class158.field1737 = var6.method8803(var4, var7);
            if (class158.field1737 != null) {
               Client.field606 = class152.method3196(var5);
               class218.field2404 = class158.field1737.iterator();
               if (var0 == ScriptOpcodes.DB_FIND_WITH_COUNT) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class158.field1737.size();
               }
            } else {
               Client.field606 = -1;
               class218.field2404 = null;
               if (var0 == ScriptOpcodes.DB_FIND_WITH_COUNT) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }
            }

            return 1;
         }
      }
   }
}
