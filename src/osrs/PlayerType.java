package osrs;

public enum PlayerType implements MouseWheel {
   PlayerType_normal(0, -1, true, false, true),
   PlayerType_playerModerator(1, 0, true, true, true),
   PlayerType_jagexModerator(2, 1, true, true, false),
   PlayerType_ironman(3, 2, false, false, true),
   PlayerType_ultimateIronman(4, 3, false, false, true),
   PlayerType_hardcoreIronman(5, 10, false, false, true),
   field4202(6, 22, false, false, true),
   field4203(7, 41, false, false, true),
   field4204(8, 42, false, false, true),
   field4205(9, 43, false, false, true),
   field4213(10, 44, false, false, true),
   field4207(11, 45, false, false, true),
   field4208(12, 46, false, false, true),
   field4212(13, 47, false, false, true),
   field4209(14, 48, false, false, true),
   field4211(15, 49, false, false, true),
   field4206(16, 52, false, false, true);

   final int id;
   public final int modIcon;
   public final boolean isPrivileged;
   public final boolean isUser;

   PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.id = var3;
      this.modIcon = var4;
      this.isPrivileged = var6;
      this.isUser = var7;
   }

   public int rsOrdinal() {
      return this.id;
   }
}
