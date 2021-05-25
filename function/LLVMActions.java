
import java.util.HashSet;
import java.util.Stack;
import output.*;
public class LLVMActions extends DemoBaseListener {

    HashSet<String> globalnames = new HashSet<String>();
    HashSet<String> functions = new HashSet<String>();
    HashSet<String> localnames = new HashSet<String>(); 
    String value, function;
    Boolean global;
    
    HashSet<String> variables = new HashSet<String>();
    Stack<String> stack = new Stack<String>();

    @Override
    public void exitAdd(DemoParser.AddContext ctx) {
        LLVMGenerator.addNUM(stack.pop(), stack.pop() );
        stack.push( "@"+(LLVMGenerator.tmp-1) );
    }

    @Override
    public void exitSingle(DemoParser.SingleContext ctx) {
    }

    @Override
    public void exitIf(DemoParser.IfContext ctx) { 
    }

    @Override
    public void enterBlockif(DemoParser.BlockifContext ctx) {
       LLVMGenerator.ifstart();
    }

    @Override
    public void exitBlockif(DemoParser.BlockifContext ctx) {
       LLVMGenerator.ifend();
    }
   
    @Override
    public void exitEqual(DemoParser.EqualContext ctx) { 
       String ID = ctx.ID().getText();
       String INT = ctx.INT().getText();
       if( globalnames.contains(ID) ) {
          LLVMGenerator.icmp( ID, INT );
       } 
       else if(localnames.contains(ID) ) {
           LLVMGenerator.icmp( ID, INT );	
       } else {
          ctx.getStart().getLine();
          System.err.println("Line "+ ctx.getStart().getLine()+", unknown variable: "+ID);
       }
    }

    @Override
    public void exitRepetitions(DemoParser.RepetitionsContext ctx) {
        LLVMGenerator.repeatstart(value);
    }

    @Override
    public void exitBlock(DemoParser.BlockContext ctx) {
        if( ctx.getParent() instanceof DemoParser.RepeatContext ){
            LLVMGenerator.repeatend();
        }
    }

    @Override 
    public void enterProg(DemoParser.ProgContext ctx) { 
       global = true;
    }

    @Override 
    public void exitProg(DemoParser.ProgContext ctx) { 
       LLVMGenerator.close_main();
       System.out.println( LLVMGenerator.generate() );
    }

    @Override 
    public void exitFparam(DemoParser.FparamContext ctx) {
       String ID = ctx.ID().getText();
       functions.add(ID); 
       function = ID;
       LLVMGenerator.functionstart(ID);
    }

    @Override
    public void enterFblock(DemoParser.FblockContext ctx) {
       global = false;
    }

    @Override
    public void exitFblock(DemoParser.FblockContext ctx) {
       if( ! localnames.contains(function) ){
          LLVMGenerator.assign(set_variable(function), "0");
       }
       LLVMGenerator.load( "%"+function );
       LLVMGenerator.functionend();
       localnames = new HashSet<String>();
       global = true;
    }

    @Override
    public void exitAssign(DemoParser.AssignContext ctx) { 
       String ID = ctx.ID().getText();
       LLVMGenerator.assign(set_variable(ID), value);
    }

    @Override 
    public void exitValue(DemoParser.ValueContext ctx) { 
       if( ctx.ID() != null ){
         String ID = ctx.ID().getText();     

         if( localnames.contains(ID) ) {
            LLVMGenerator.load( "%"+ID );
         } else if( globalnames.contains(ID) ) {
            LLVMGenerator.load( "@"+ID );
            stack.push( "@"+ID );
         } else if( functions.contains(ID) ) {
            LLVMGenerator.call(ID);
         } else {
            error(ctx.getStart().getLine(), "Unknown "+ID+ ": local > global > function");
         }
         value = "%"+(LLVMGenerator.tmp-1); 
       } 

       if( ctx.INT() != null ){
         value = ctx.INT().getText();
         stack.push( ctx.INT().getText() );
       } 
    }



    @Override
    public void exitWrite(DemoParser.WriteContext ctx) {
       LLVMGenerator.printf(value);
    } 

    @Override
    public void exitCall(DemoParser.CallContext ctx) {
       LLVMGenerator.call(ctx.ID().getText());
    } 


    @Override
    public void exitRead(DemoParser.ReadContext ctx) {
       String ID = ctx.ID().getText();
       LLVMGenerator.scanf( set_variable(ID) );
    } 
  
    public String set_variable(String ID){
       String id;
       if( global ){
          if( ! globalnames.contains(ID) ) {
             globalnames.add(ID);
             LLVMGenerator.declare(ID, true);          
          }
          id = "@"+ID; 
       } else {
          if( ! localnames.contains(ID) ) {
             localnames.add(ID);
             LLVMGenerator.declare(ID, false);
          }
          id = "%"+ID; 
       }
       return id;
    }

    void error(int line, String msg){
       System.err.println("Error! Line "+line+", "+msg);
       System.exit(1);
   } 

}
