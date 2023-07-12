package osrs;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class class169 {
   int field1802 = -1;
   String field1803;
   UrlRequest field1801;
   String field1805 = null;
   float[] field1806 = new float[4];
   ArrayList field1799 = new ArrayList();
   ArrayList field1812 = new ArrayList();
   ArrayList field1809 = new ArrayList();
   Map field1810 = new HashMap();
   Map field1811 = new HashMap();

   public boolean method3403(String var1, UrlRequester var2) {
      if (var1 != null && !var1.isEmpty()) {
         if (var2 == null) {
            return false;
         } else {
            this.method3413();

            try {
               this.field1803 = var1;
               this.field1801 = var2.request(new URL(this.field1803));
               this.field1802 = 0;
               return true;
            } catch (MalformedURLException var4) {
               this.method3413();
               this.field1802 = 100;
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public void method3417(UrlRequester var1) {
      switch (this.field1802) {
         case 0:
            this.method3429(var1);
            break;
         case 1:
            this.method3415();
            break;
         default:
            return;
      }

   }

   public int method3405() {
      return this.field1802;
   }

   public int method3406(String var1) {
      return this.field1810.containsKey(var1) ? (Integer)this.field1810.get(var1) : -1;
   }

   public String method3461(String var1) {
      return (String)((String)(this.field1811.containsKey(var1) ? this.field1811.get(var1) : null));
   }

   public ArrayList method3408() {
      return this.field1812;
   }

   public ArrayList method3409() {
      return this.field1809;
   }

   public String method3410() {
      return this.field1805;
   }

   public float[] method3411() {
      return this.field1806;
   }

   public ArrayList method3444() {
      return this.field1799;
   }

   void method3413() {
      this.field1801 = null;
      this.field1805 = null;
      this.field1806[0] = 0.0F;
      this.field1806[1] = 0.0F;
      this.field1806[2] = 1.0F;
      this.field1806[3] = 1.0F;
      this.field1799.clear();
      this.field1812.clear();
      this.field1809.clear();
      this.field1810.clear();
      this.field1811.clear();
   }

   void method3429(UrlRequester var1) {
      if (this.field1801 != null && this.field1801.isDone()) {
         byte[] var2 = this.field1801.getResponse();
         if (var2 == null) {
            this.method3413();
            this.field1802 = 100;
         } else {
            try {
               this.method3420(new class450(var2), var1);
            } catch (UnsupportedEncodingException var4) {
               this.method3413();
               this.field1802 = 102;
               return;
            }

            this.field1802 = this.field1812.size() > 0 ? 1 : 2;
            this.field1801 = null;
         }
      }
   }

   void method3415() {
      Iterator var1 = this.field1812.iterator();

      class175 var2;
      do {
         if (!var1.hasNext()) {
            var1 = this.field1812.iterator();

            while(var1.hasNext()) {
               var2 = (class175)var1.next();
               if (var2.field1844 != null) {
                  byte[] var3 = var2.field1844.getResponse();
                  if (var3 != null && var3.length > 0) {
                     this.field1802 = 2;
                     return;
                  }
               }
            }

            this.method3413();
            this.field1802 = 101;
            return;
         }

         var2 = (class175)var1.next();
      } while(var2.field1844 == null || var2.field1844.isDone());

   }

   void method3437(JSONArray var1, UrlRequester var2) throws JSONException {
      if (var1 != null) {
         for(int var3 = 0; var3 < var1.length(); ++var3) {
            try {
               JSONObject var4 = var1.getJSONObject(var3);
               class175 var5 = new class175(this);
               var5.field1844 = var2.request(new URL(var4.getString("src")));
               var5.field1841 = ParamComposition.method3829(var4, "placement");
               this.field1812.add(var5);
            } catch (MalformedURLException var6) {
            }
         }

      }
   }

   void method3402(JSONArray var1) throws JSONException {
      if (var1 != null) {
         for(int var2 = 0; var2 < var1.length(); ++var2) {
            JSONObject var3 = var1.getJSONObject(var2);
            class176 var4 = new class176(this);
            var4.field1848 = var3.getString("text");
            String var7 = var3.getString("align_x");
            byte var6;
            if (var7.equals("centre")) {
               var6 = 1;
            } else if (!var7.equals("bottom") && !var7.equals("right")) {
               var6 = 0;
            } else {
               var6 = 2;
            }

            var4.field1850 = var6;
            String var10 = var3.getString("align_y");
            byte var9;
            if (var10.equals("centre")) {
               var9 = 1;
            } else if (!var10.equals("bottom") && !var10.equals("right")) {
               var9 = 0;
            } else {
               var9 = 2;
            }

            var4.field1845 = var9;
            var4.field1852 = var3.getInt("font");
            var4.field1849 = ParamComposition.method3829(var3, "placement");
            this.field1809.add(var4);
         }

      }
   }

   void method3418(JSONObject var1) throws JSONException {
      if (var1 != null) {
         this.field1806 = ParamComposition.method3829(var1, "clickbounds");
         this.field1805 = var1.getString("endpoint");
         String[] var2 = JSONObject.getNames(var1);

         for(int var3 = 0; var3 < var1.length(); ++var3) {
            if (!var2[var3].equals("clickbounds") && !var2[var3].equals("endpoint")) {
               try {
                  int var4 = var1.getInt(var2[var3]);
                  this.field1799.add(new class177(this, var2[var3], var4));
               } catch (Exception var8) {
                  try {
                     String var5 = var1.getString(var2[var3]);
                     if (var5.equals("true")) {
                        this.field1799.add(new class177(this, var2[var3], 1));
                     } else if (var5.equals("false")) {
                        this.field1799.add(new class177(this, var2[var3], 0));
                     } else {
                        this.field1799.add(new class168(this, var2[var3], var5));
                     }
                  } catch (Exception var7) {
                  }
               }
            }
         }

      }
   }

   void method3427(JSONObject var1) throws JSONException {
      String[] var2 = JSONObject.getNames(var1);

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         try {
            int var4 = var1.getInt(var2[var3]);
            this.field1810.put(var2[var3], var4);
         } catch (Exception var8) {
            try {
               String var5 = var1.getString(var2[var3]);
               if (var5.equals("true")) {
                  this.field1810.put(var2[var3], 1);
               } else if (var5.equals("false")) {
                  this.field1810.put(var2[var3], 0);
               } else {
                  this.field1811.put(var2[var3], var5);
               }
            } catch (Exception var7) {
            }
         }
      }

   }

   void method3420(class450 var1, UrlRequester var2) {
      JSONObject var3;
      try {
         var3 = var1.method8238();
         var3 = var3.getJSONObject("message");
      } catch (Exception var9) {
         this.method3413();
         this.field1802 = 102;
         return;
      }

      try {
         this.method3437(var3.getJSONArray("images"), var2);
      } catch (Exception var8) {
         this.field1812.clear();
      }

      try {
         this.method3402(var3.getJSONArray("labels"));
      } catch (Exception var7) {
         this.field1809.clear();
      }

      try {
         this.method3418(var3.getJSONObject("behaviour"));
      } catch (Exception var6) {
         this.field1805 = null;
         this.field1806[0] = 0.0F;
         this.field1806[1] = 0.0F;
         this.field1806[2] = 1.0F;
         this.field1806[3] = 1.0F;
         this.field1799.clear();
      }

      try {
         this.method3427(var3.getJSONObject("meta"));
      } catch (Exception var5) {
         this.field1810.clear();
         this.field1811.clear();
      }

   }

   public boolean method3452(String var1, UrlRequester var2) {
      try {
         this.method3420(new class450(var1.getBytes()), var2);
         this.field1802 = this.field1812.size() > 0 ? 1 : 2;
      } catch (UnsupportedEncodingException var4) {
         this.field1802 = 102;
      }

      return this.field1802 < 100;
   }

   static boolean method3438(int var0, int var1, int var2) {
      return var0 >= 0 && var0 < 4 && var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104;
   }

   public static int[] method3407(byte[] var0) {
      if (var0 != null && var0.length != 0 && var0.length <= 8) {
         int[] var1 = new int[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            if (var0[var2] < 0 || var0[var2] > class525.field5174.length) {
               return null;
            }

            var1[var2] = class525.field5174[var0[var2]];
         }

         return var1;
      } else {
         return null;
      }
   }
}
