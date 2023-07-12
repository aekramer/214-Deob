package osrs;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class DevicePcmPlayer extends PcmPlayer {
   AudioFormat format;
   SourceDataLine line;
   int capacity2;
   byte[] byteSamples;

   DevicePcmPlayer() {
   }

   protected void init() {
      this.format = new AudioFormat((float)PcmPlayer.field291, 16, class347.PcmPlayer_stereo ? 2 : 1, true, false);
      this.byteSamples = new byte[256 << (class347.PcmPlayer_stereo ? 2 : 1)];
   }

   protected void open(int var1) throws LineUnavailableException {
      try {
         DataLine.Info var2 = new DataLine.Info(SourceDataLine.class, this.format, var1 << (class347.PcmPlayer_stereo ? 2 : 1));
         this.line = (SourceDataLine)AudioSystem.getLine(var2);
         this.line.open();
         this.line.start();
         this.capacity2 = var1;
      } catch (LineUnavailableException var3) {
         if (FloorOverlayDefinition.method4023(var1) != 1) {
            this.open(class128.method2970(var1));
         } else {
            this.line = null;
            throw var3;
         }
      }
   }

   protected int position() {
      return this.capacity2 - (this.line.available() >> (class347.PcmPlayer_stereo ? 2 : 1));
   }

   protected void write() {
      int var1 = 256;
      if (class347.PcmPlayer_stereo) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.samples[var2];
         if ((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.byteSamples[var2 * 2] = (byte)(var3 >> 8);
         this.byteSamples[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.line.write(this.byteSamples, 0, var1 << 1);
   }

   protected void close() {
      if (this.line != null) {
         this.line.close();
         this.line = null;
      }

   }

   protected void discard() {
      this.line.flush();
   }
}
