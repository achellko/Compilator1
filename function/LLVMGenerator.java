import java.util.Stack;
import output.*;


class LLVMGenerator{
   
   static String header_text = "";
   static String main_text = "";
   static int main_tmp = 1;
   static String buffer = "";
   static int tmp = 1;
   static int br = 0;
   static int reg = 1;
   
   static Stack<Integer> brstack = new Stack<Integer>();
   static Stack<Integer> brstackREP = new Stack<Integer>();

   static void addNUM(String val1, String val2){
      buffer += "%"+tmp+" = add i32 "+val1+", "+val2+"\n";
      tmp++;
   }

   static void repeatstart(String repetitions){
      declareIF(Integer.toString(tmp));
      int counter = tmp;
      tmp++;
      assignREP(Integer.toString(counter), "0");
      br++;
      buffer += "br label %cond"+br+"\n";
      buffer += "cond"+br+":\n";

      loadREP(Integer.toString(counter));
      add("%"+(tmp-1), "1");
      assignREP(Integer.toString(counter), "%"+(tmp-1));

      buffer += "%"+tmp+" = icmp slt i32 %"+(tmp-2)+", "+repetitions+"\n";
      tmp++;

      buffer += "br i1 %"+(tmp-1)+", label %true"+br+", label %false"+br+"\n";
      buffer += "true"+br+":\n";
      brstackREP.push(br);
   }

   static void repeatend(){
      int b = brstackREP.pop();
      buffer += "br label %cond"+b+"\n";
      buffer += "false"+b+":\n";
   }

   static void icmp(String id, String value){
      buffer += "%"+tmp+" = load i32, i32* @"+id+"\n";
      tmp++;
      buffer += "%"+tmp+" = icmp eq i32 %"+(tmp-1)+", "+value+"\n";
      tmp++;
   }

   static void ifstart(){
     br++;
      buffer += "br i1 %"+(tmp-1)+", label %true"+br+", label %false"+br+"\n";
      buffer += "true"+br+":\n";
     brstack.push(br);
   }

   static void ifend(){
     int b = brstack.pop();
      buffer += "br label %false"+b+"\n";
      buffer += "false"+b+":\n";
   }

   static void functionstart(String id){
      main_text += buffer;
      main_tmp = tmp;
      buffer = "define i32 @"+id+"() nounwind {\n";
      tmp = 1;
   }

   static void functionend(){
      buffer += "ret i32 %"+(tmp-1)+"\n"; 
      buffer += "}\n";
      header_text += buffer;
      buffer = "";
      tmp = main_tmp;
   }

   static void scanf(String id){
      buffer += "%"+tmp+" = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* "+id+")\n";
      tmp++;      
   }


   static void printf(String id){
      buffer += "%"+tmp+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 "+id+")\n";
      tmp++;
   }

   static void declare(String id, Boolean global){
      if( global ){
         header_text += "@"+id+" = global i32 0\n";
      } else {
	 buffer += "%"+id+" = alloca i32\n";
      }
   }

   static void add(String val1, String val2){
      buffer += "%"+tmp+" = add i32 "+val1+", "+val2+"\n";
      tmp++;
   }

   static void declareIF(String id){
      buffer += "%"+id+" = alloca i32\n";
   }

   static void assign(String id, String value){
      buffer += "store i32 "+value+", i32* "+id+"\n";
   }

   static void assignREP(String id, String value){
      buffer += "store i32 "+value+", i32* %"+id+"\n";
   }

   static void loadREP(String id){
      buffer += "%"+tmp+" = load i32, i32* %"+id+"\n";
      tmp++;
   }

   static void load(String id){
      buffer += "%"+tmp+" = load i32, i32* "+id+"\n";
      tmp++;
   }

   static void call(String id){
      buffer += "%"+tmp+" = call i32 @"+id+"()\n";
      tmp++;
   }


   static void close_main(){
      main_text += buffer;
   }

   static String generate(){
      String text = "";
      text += "declare i32 @printf(i8*, ...)\n";
      text += "declare i32 @__isoc99_scanf(i8*, ...)\n";
      text += "@strp = constant [4 x i8] c\"%d\\0A\\00\"\n";
      text += "@strs = constant [3 x i8] c\"%d\\00\"\n";
      text += header_text;
      text += "define i32 @main() nounwind{\n";
      text += main_text;
      text += "ret i32 0 }\n";
      return text;
   }

}
