package osrs;

public final class BZip2State {
   final int field5058 = 4096;
   final int field5027 = 16;
   final int field5028 = 258;
   final int field5029 = 6;
   final int field5057 = 50;
   final int field5031 = 18002;
   byte[] inputArray;
   int nextByte = 0;
   int nextBit_unused;
   byte[] outputArray;
   int next_out = 0;
   int outputLength;
   int field5060;
   byte out_char;
   int su_rNToGo;
   int bsBuff;
   int bsLive;
   int blockSize100k;
   int originalPointer;
   int field5045;
   int su_ch2;
   int[] unzftab = new int[256];
   int nblocks_used;
   int[] cftab = new int[257];
   int nInUse;
   boolean[] inUse = new boolean[256];
   boolean[] inUse16 = new boolean[16];
   byte[] seqToUnseq = new byte[256];
   byte[] ll8 = new byte[4096];
   int[] getAndMoveToFrontDecode_yy = new int[16];
   byte[] selector = new byte[18002];
   byte[] selectorMtf = new byte[18002];
   byte[][] temp_charArray2d = new byte[6][258];
   int[][] limit = new int[6][258];
   int[][] base = new int[6][258];
   int[][] perm = new int[6][258];
   int[] minLens = new int[6];
   int field5063;

   BZip2State() {
   }
}
